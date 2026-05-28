package com.iSpeedrunner.notes_service.service;

import com.iSpeedrunner.notes_service.exception.RoomNotFoundException;
import com.iSpeedrunner.notes_service.model.Room;
import com.iSpeedrunner.notes_service.repository.NoteRepository;
import com.iSpeedrunner.notes_service.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository repo;
    private final NoteRepository noteRepository;

    public Room create(Room r) {
        return repo.save(r);
    }

    public Room getById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RoomNotFoundException("Кімната з ID = {" + id + "} не знайдена"));
    }

    public List<Room> getRooms() {
        return repo.findAll();
    }

    public Room update(String id, Room currentRoom) {
        Room existRoom = repo.findById(id)
                .orElseThrow(() -> new RoomNotFoundException("Кімната з ID = {" + id + "} не знайдена"));

        existRoom.setName(currentRoom.getName());

        return repo.save(existRoom);
    }

    public void delete(String id) {
        if(!repo.existsById(id)) {
            throw  new RoomNotFoundException("Кімната з ID = {" + id + "} не знайдена");
        }

        noteRepository.deleteByRoomId(id);
        repo.deleteById(id);
    }
}
