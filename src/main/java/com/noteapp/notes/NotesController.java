package com.noteapp.notes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/api/notes")
public class NotesController {

    private NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("")
    public ResponseEntity<List<NotesDto>> getAll() {
        return new ResponseEntity<>(notesService.getList().subList(0,20), HttpStatus.ACCEPTED);
    }


    @PostMapping("/create")
    public ResponseEntity<NotesDto> addNotes(@RequestBody NotesDto notes) {
        if(notes.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nostes name can't be empty");
        }
        NotesDto save = notesService.save(notes);
        return ResponseEntity.ok(save);
    }
//    @PostMapping("/create")
//    @GetMapping("/{id}/eidt")
//    @PostMapping("/{id}/edit")
//    @PostMapping("/{id}/remove")
//    @PostMapping("/isdone")

}
