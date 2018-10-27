package com.losnarghileros.smarthack2018.entities;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

//    @JsonFormat(pattern="dd/MM/yyyy")
    private Date date;

    private Long endTime;
    private Long startTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public Room getRoomData() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public User getUser() {
        return user;
    }

    public User getUserData() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation() {
    }

    public Reservation(User user, Room room, Date date, Long startTime, Long endTime) {
        this.user = user;
        this.room = room;
        this.date = date;
        this.endTime = endTime;
        this.startTime = startTime;
    }
}
