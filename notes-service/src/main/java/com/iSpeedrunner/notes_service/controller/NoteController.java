package com.iSpeedrunner.notes_service.controller;

import com.iSpeedrunner.notes_service.exception.NoteNotFoundException;
import com.iSpeedrunner.notes_service.model.Note;
import com.iSpeedrunner.notes_service.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@AllArgsConstructor
public class NoteController {
    private final NoteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note) {
        return service.create(note);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable String id) {
        Note note = service.getById(id);

        return ResponseEntity.ok(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable String id, @RequestBody Note note) {
        Note updatedNote = service.update(id, note);

        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
