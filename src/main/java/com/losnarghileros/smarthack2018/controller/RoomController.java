package com.losnarghileros.smarthack2018.controller;

import com.losnarghileros.smarthack2018.entities.Room;
import com.losnarghileros.smarthack2018.entities.enums.RoomType;
import com.losnarghileros.smarthack2018.service.RoomService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/findBy")
    public @ResponseBody
    PagedResources<Room> findBy(
            @PageableDefault(page = 0, size = 9999)Pageable pageable,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long capacity,
            @RequestParam(required = false) RoomType type,
            @RequestParam(required = false) Long floor){
        return roomService.findBy(pageable, name, capacity, type, floor);
    }
}
