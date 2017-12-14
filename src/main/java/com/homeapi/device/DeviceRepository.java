package com.homeapi.device;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface DeviceRepository extends PagingAndSortingRepository<Device, Long>
{
    @RestResource(path = "name", rel = "name")
    Page<Device> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);
}
