package com.losnarghileros.smarthack2018.service;

import com.losnarghileros.smarthack2018.entities.Room;
import com.losnarghileros.smarthack2018.entities.enums.RoomType;
import com.losnarghileros.smarthack2018.repository.RoomRepository;
import com.losnarghileros.smarthack2018.repository.RoomSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private PagedResourcesAssembler pagedResourcesAssembler;
    private RoomRepository roomRepository;

    public RoomService(PagedResourcesAssembler pagedResourcesAssembler, RoomRepository roomRepository) {
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.roomRepository = roomRepository;
    }

    public PagedResources<Room> findBy(Pageable pageable, String name, Long capacity, RoomType type, Long floor) {
        Page<Room> rooms = roomRepository.findAll(RoomSpecifications.findBy(name, capacity, type, floor), pageable);

        return pagedResourcesAssembler.toResource(rooms);
    }
}
