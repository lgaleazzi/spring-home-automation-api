package com.homeapi.device;

import com.homeapi.control.Control;
import com.homeapi.core.BaseEntity;
import com.homeapi.room.Room;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Device extends BaseEntity
{
    private String name;
    @ManyToOne
    private Room room;
    @OneToMany(mappedBy = "device")
    private List<Control> controls;

    protected Device()
    {
        super();
        this.controls = new ArrayList<>();
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

    public List<Control> getControls()
    {
        return controls;
    }

    public void addControl(Control control)
    {
        control.setDevice(this);
        this.controls.add(control);
    }
}
