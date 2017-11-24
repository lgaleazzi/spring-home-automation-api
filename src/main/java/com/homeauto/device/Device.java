package com.homeauto.device;

import com.homeauto.com.homeauto.core.BaseEntity;
import com.homeauto.room.Room;

import javax.persistence.Entity;

@Entity
public class Device extends BaseEntity
{
    private String name;
    private Room room;

    protected Device()
    {
        super();
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
