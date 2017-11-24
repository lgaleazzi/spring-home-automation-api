package com.homeapi.device;

import com.homeapi.core.BaseEntity;
import com.homeapi.room.Room;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Device extends BaseEntity
{
    private String name;
    @ManyToOne
    private Room room;

    protected Device()
    {
        super();
    }

    public Device(String name, Room room)
    {
        this();
        this.name = name;
        this.room = room;
    }

    public Device(String name)
    {
        this(name, null);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room = room;
    }
}
