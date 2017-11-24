package com.homeauto.room;

import com.homeauto.com.homeauto.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Room extends BaseEntity
{
    private String name;
    private int area;

    protected Room() {
        super();
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
}
