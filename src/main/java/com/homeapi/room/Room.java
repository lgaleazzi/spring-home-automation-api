package com.homeapi.room;

import com.homeapi.core.BaseEntity;
import com.homeapi.device.Device;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends BaseEntity
{
    private String name;
    private int area;
    @OneToMany(mappedBy = "room")
    private List<Device> devices;

    protected Room() {
        super();
        this.devices = new ArrayList<>();
    }

    public Room(String name, int area)
    {
        this();
        this.name = name;
        this.area = area;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getArea()
    {
        return area;
    }

    public void setArea(int area)
    {
        this.area = area;
    }

    public List<Device> getDevices()
    {
        return devices;
    }

    public void addDevice(Device device)
    {
        device.setRoom(this);
        this.devices.add(device);
    }
}
