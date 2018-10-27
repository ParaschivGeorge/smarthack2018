package com.losnarghileros.smarthack2018.service;

import com.losnarghileros.smarthack2018.repository.ReservationRepository;
import com.losnarghileros.smarthack2018.repository.RoomRepository;
import com.losnarghileros.smarthack2018.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }
}
