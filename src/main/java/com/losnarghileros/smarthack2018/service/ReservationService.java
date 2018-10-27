package com.losnarghileros.smarthack2018.service;

import com.losnarghileros.smarthack2018.entities.Reservation;
import com.losnarghileros.smarthack2018.entities.Room;
import com.losnarghileros.smarthack2018.entities.User;
import com.losnarghileros.smarthack2018.entities.enums.RoomType;
import com.losnarghileros.smarthack2018.repository.ReservationRepository;
import com.losnarghileros.smarthack2018.repository.ReservationSpecifications;
import com.losnarghileros.smarthack2018.repository.RoomRepository;
import com.losnarghileros.smarthack2018.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationService {

    private PagedResourcesAssembler pagedResourcesAssembler;
    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private RoomRepository roomRepository;

    public ReservationService(PagedResourcesAssembler pagedResourcesAssembler, ReservationRepository reservationRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    public Reservation add(String email, String roomName, Date date, Long startTime, Long endTime) {
        User user = userRepository.findByEmail(email);
        Room room = roomRepository.findByName(roomName);
        System.out.println("here");
        return reservationRepository.save(new Reservation(user, room, date, startTime, endTime));
    }

    public PagedResources<Reservation> findBy(Pageable pageable, String email, String roomName, Date date, Long startTime, Long endTime, Long capacity, RoomType roomType, Long floor) {
        Page<Reservation> reservations = reservationRepository.findAll(ReservationSpecifications.findBy(email, roomName, date, startTime, endTime, capacity, roomType, floor), pageable);

        return pagedResourcesAssembler.toResource(reservations);
    }

    public boolean delete(String email, String roomName, Date date, Long startTime, Long endTime) {
        User user = userRepository.findByEmail(email);
        Room room = roomRepository.findByName(roomName);
        reservationRepository.delete(reservationRepository.findByUserAndRoomAndDateAndStartTimeAndEndTime(user, room, date, startTime, endTime));
        return true;
    }
}
