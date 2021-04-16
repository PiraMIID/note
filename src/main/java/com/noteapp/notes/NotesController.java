package com.noteapp.notes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/api/notes")
public class NotesController {

    private NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("")
    public ResponseEntity<List<NotesDto>> ggetAll() {
        return new ResponseEntity<>(notesService.getList().subList(0,20), HttpStatus.ACCEPTED);
    }

    //    @GetMapping("")
//    @GetMapping("/create")
//    @PostMapping("/create")
//    @GetMapping("/{id}/eidt")
//    @PostMapping("/{id}/edit")
//    @PostMapping("/{id}/remove")
//    @PostMapping("/isdone")

}
