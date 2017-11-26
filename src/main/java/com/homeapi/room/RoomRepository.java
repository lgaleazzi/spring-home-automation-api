package com.homeapi.room;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long>
{
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #room.hasAdministrator(authentication.name)")
    Room save(@Param("room") Room entity);


}
