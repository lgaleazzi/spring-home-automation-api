package com.homeapi.core;

import com.homeapi.control.Control;
import com.homeapi.control.ControlRepository;
import com.homeapi.device.Device;
import com.homeapi.device.DeviceRepository;
import com.homeapi.room.Room;
import com.homeapi.room.RoomRepository;
import com.homeapi.user.User;
import com.homeapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner
{
    private final DeviceRepository deviceRepository;
    private final RoomRepository roomRepository;
    private final ControlRepository controlRepository;
    private final UserRepository userRepository;

    @Autowired
    public DataLoader(DeviceRepository deviceRepository, RoomRepository roomRepository,
                      UserRepository userRepository, ControlRepository controlRepository)
    {
        this.deviceRepository = deviceRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.controlRepository = controlRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        List<User> users = Arrays.asList(
                new User("Livia", new String[] {"ROLE_USER", "ROLE_ADMIN"}, "password"),
                new User("Frank", new String[] {"ROLE_USER"}, "password"),
                new User("Inga", new String[] {"ROLE_USER"}, "password")
        );
        userRepository.save(users);

        Device tv = new Device("TV");
        Room livingRoom = new Room("Living Room", 30);
        livingRoom.addAdministrator(users.get(0));
        livingRoom.addDevice(tv);

        roomRepository.save(livingRoom);
        deviceRepository.save(tv);
    }
}
