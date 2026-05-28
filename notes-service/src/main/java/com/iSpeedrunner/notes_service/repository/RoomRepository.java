package com.iSpeedrunner.notes_service.repository;

import com.iSpeedrunner.notes_service.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
}
