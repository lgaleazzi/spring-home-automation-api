package com.homeapi.core;

import com.homeapi.control.ControlRepository;
import com.homeapi.device.Device;
import com.homeapi.device.DeviceRepository;
import com.homeapi.room.Room;
import com.homeapi.room.RoomRepository;
import com.homeapi.user.DetailsService;
import com.homeapi.user.User;
import com.homeapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final DetailsService detailsService;

    @Autowired
    public DataLoader(DeviceRepository deviceRepository, RoomRepository roomRepository,
                      UserRepository userRepository, ControlRepository controlRepository, DetailsService detailsService)
    {
        this.deviceRepository = deviceRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.controlRepository = controlRepository;
        this.detailsService = detailsService;
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

        UserDetails userDetails = detailsService.loadUserByUsername("Livia");

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        Device tv = new Device("TV");
        Device stereo = new Device("stereo");
        Device fridge = new Device("Fridge");
        Room kitchen = new Room("Kitchen", 40);
        Room livingRoom = new Room("Living Room", 30);
        livingRoom.addAdministrator(users.get(1));
        livingRoom.addAdministrator(users.get(1));
        livingRoom.addDevice(tv);
        livingRoom.addDevice(stereo);
        kitchen.addDevice(fridge);

        roomRepository.save(livingRoom);
        roomRepository.save(kitchen);
        deviceRepository.save(tv);
        deviceRepository.save(stereo);
        deviceRepository.save(fridge);
    }
}
