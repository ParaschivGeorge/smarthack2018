package com.losnarghileros.smarthack2018.controller;

import com.losnarghileros.smarthack2018.service.ReservationService;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
}
