package com.noteapp.note;

import com.noteapp.notes.NotesService;
import org.springframework.stereotype.Controller;

//todo: 6:

@Controller("/api/notes/{id}")
public class NoteController {

    private final NotesService notesService;

    public NoteController(NotesService notesService) {
        this.notesService = notesService;
    }

    //    @GetMapping("")
//    @GetMapping("/create")
//    @PostMapping("/create")
//    @GetMapping("/{id}/eidt")
//    @PostMapping("/{id}/edit")
//    @PostMapping("/isdone")

}
