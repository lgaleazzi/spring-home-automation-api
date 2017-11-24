package com.homeapi.core;

import com.homeapi.device.Device;
import com.homeapi.device.DeviceRepository;
import com.homeapi.room.Room;
import com.homeapi.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner
{
    private final DeviceRepository deviceRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public DataLoader(DeviceRepository deviceRepository, RoomRepository roomRepository)
    {
        this.deviceRepository = deviceRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        Device tv = new Device("TV");
        Room livingRoom = new Room("Living Room", 30);
        livingRoom.addDevice(tv);

        roomRepository.save(livingRoom);
        deviceRepository.save(tv);
    }
}
