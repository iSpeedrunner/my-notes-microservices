package com.iSpeedrunner.notes_service.service;

import com.iSpeedrunner.notes_service.exception.NoteNotFoundException;
import com.iSpeedrunner.notes_service.model.Note;
import com.iSpeedrunner.notes_service.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class NoteService {
    private final NoteRepository repo;

    public Note create(Note note) {
        return repo.save(note);
    }
    
    public Note getById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Нотатку з ID '" + id + "' не знайдено"));
    }

    public Note update(String id, Note currentNote) {
        return repo.findById(id)
                .map(existingNote -> {
                    existingNote.setTitle(currentNote.getTitle());
                    existingNote.setContent(currentNote.getContent());
                    return repo.save(existingNote);
                })
                .orElseThrow(() -> new NoteNotFoundException("Нотатку з ID '" + id + "' не знайдено"));
    }

    public void delete(String id) {
        if(!repo.existsById(id)){
            throw new NoteNotFoundException("Нотатку з ID '" + id + "' не знайдено");
        }
        repo.deleteById(id);
    }
}
