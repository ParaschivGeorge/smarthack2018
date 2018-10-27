package com.losnarghileros.smarthack2018.repository;

import com.losnarghileros.smarthack2018.entities.Room;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Api(tags = "Room Entity")
@RepositoryRestResource(collectionResourceRel = "room", path = "room")
public interface RoomRepository extends CrudRepository<Room, Long>, JpaSpecificationExecutor<Room> {
}
