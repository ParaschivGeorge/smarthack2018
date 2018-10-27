package com.losnarghileros.smarthack2018.repository;

import com.losnarghileros.smarthack2018.entities.Reservation;
import com.losnarghileros.smarthack2018.entities.Room;
import com.losnarghileros.smarthack2018.entities.User;
import com.losnarghileros.smarthack2018.entities.enums.RoomType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationSpecifications {

    public static Specification<Reservation> findBy(String email,
                                                    String roomName,
                                                    Date date,
                                                    Long startTime,
                                                    Long endTime,
                                                    Long capacity,
                                                    RoomType roomType,
                                                    Long floor) {
        return new Specification<Reservation>() {
            @Override
            public Predicate toPredicate(Root<Reservation> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                final List<Predicate> predicateList = new ArrayList<>();

                Join<Reservation, Room> room = root.join("room");
                Join<Reservation, User> user = root.join("user");

                if (email != null && !email.isEmpty()) {
                    predicateList.add(cb.equal(user.get("email"), email));
                }

                if (roomName != null && !roomName.isEmpty()) {
                    predicateList.add(cb.like(cb.upper(room.get("name")), '%' + roomName.toUpperCase() + '%'));
                }

                if (date != null) {
                    predicateList.add(cb.equal(root.get("date"), date));
                }

                if (startTime != null) {
                    predicateList.add(cb.greaterThanOrEqualTo(root.get("startTime"), startTime));
                }

                if (endTime != null) {
                    predicateList.add(cb.lessThanOrEqualTo(root.get("endTime"), endTime));
                }

                if (capacity != null) {
                    predicateList.add(cb.greaterThanOrEqualTo(room.get("capacity"), capacity));
                }

                if (roomType != null) {
                    predicateList.add(cb.equal(room.get("type"), roomType));
                }

                if (floor != null) {
                    predicateList.add(cb.equal(room.get("floor"), floor));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }
}
