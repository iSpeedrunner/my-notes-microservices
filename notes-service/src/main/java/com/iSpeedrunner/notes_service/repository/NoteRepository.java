package com.iSpeedrunner.notes_service.repository;

import com.iSpeedrunner.notes_service.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    public void deleteByRoomId(String roomId);
}
