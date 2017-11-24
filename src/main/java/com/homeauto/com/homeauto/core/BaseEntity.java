package com.homeauto.com.homeauto.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    protected BaseEntity()
    {
        id = null;
    }
}