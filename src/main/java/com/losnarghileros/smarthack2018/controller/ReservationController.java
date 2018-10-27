package com.losnarghileros.smarthack2018.controller;

import com.losnarghileros.smarthack2018.entities.Reservation;
import com.losnarghileros.smarthack2018.entities.enums.RoomType;
import com.losnarghileros.smarthack2018.service.ReservationService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody Reservation add(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String roomName,
            @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(required = true) Long startTime,
            @RequestParam(required = true) Long endTime
            ) {
        return reservationService.add(email, roomName, date, startTime, endTime);
    }

    @GetMapping(path = "/findBy")
    public @ResponseBody PagedResources<Reservation> findBy(
            @PageableDefault(page = 0, size = 9999)Pageable pageable,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String roomName,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(required = false) Long startTime,
            @RequestParam(required = false) Long endTime,
            @RequestParam(required = false) Long capacity,
            @RequestParam(required = false) RoomType roomType,
            @RequestParam(required = false) Long floor
    ) {
        return reservationService.findBy(pageable, email, roomName, date, startTime, endTime, capacity, roomType, floor);
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody Boolean delete(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String roomName,
            @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(required = true) Long startTime,
            @RequestParam(required = true) Long endTime
    ) {
        return reservationService.delete(email, roomName, date, startTime, endTime);
    }
}
