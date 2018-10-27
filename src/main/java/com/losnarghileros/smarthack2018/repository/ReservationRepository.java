package com.losnarghileros.smarthack2018.repository;

import com.losnarghileros.smarthack2018.entities.Reservation;
import com.losnarghileros.smarthack2018.entities.Room;
import com.losnarghileros.smarthack2018.entities.User;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@Api(tags = "Reservation Entity")
@RepositoryRestResource(collectionResourceRel = "reservation", path = "reservation")
public interface ReservationRepository extends CrudRepository<Reservation, Long>, JpaSpecificationExecutor<Reservation> {
    List<Reservation> findByUserAndRoomAndDateAndStartTimeAndEndTime(User user, Room room, Date date, Long startTime, Long endTime);
}
