package com.losnarghileros.smarthack2018.repository;

import com.losnarghileros.smarthack2018.entities.Room;
import com.losnarghileros.smarthack2018.entities.enums.RoomType;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Api(tags = "Room Entity")
@RepositoryRestResource(collectionResourceRel = "room", path = "room")
public interface RoomRepository extends CrudRepository<Room, Long>, JpaSpecificationExecutor<Room> {
    Room findByName(String name);
}
