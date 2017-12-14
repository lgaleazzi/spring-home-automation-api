package com.homeapi.room;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long>
{
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #room.hasAdministrator(authentication.name)")
    Room save(@Param("room") Room entity);

    @RestResource(path = "name", rel = "name")
    Page<Room> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    @RestResource(path = "area", rel = "area")
    Page<Room> findByAreaLessThan(@Param("area") int area, Pageable pageable);
}
