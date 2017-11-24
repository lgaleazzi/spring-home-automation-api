package com.homeapi.control;

import com.homeapi.core.BaseEntity;
import com.homeapi.device.Device;
import com.homeapi.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import java.time.LocalDateTime;

@Entity
public class Control extends BaseEntity
{
    private String name;
    private int value;
    @OneToOne
    private Device device;
    @ManyToOne
    private User lastModifiedBy;
    @Version
    private Long version;

    protected Control()
    {
        super();
    }

    public Control(String name, Device device, int value, User lastModifiedBy)
    {
        this();
        this.name = name;
        this.device = device;
        this.value = value;
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Device getDevice()
    {
        return device;
    }

    public void setDevice(Device device)
    {
        this.device = device;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public User getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy)
    {
        this.lastModifiedBy = lastModifiedBy;
    }
}
