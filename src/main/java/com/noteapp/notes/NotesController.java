package com.noteapp.notes;

import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/notes")
public class NotesController {

    private NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("")
    public List<NotesDto> getAll(@RequestAttribute("username") String username, @RequestParam(required = false) String text) {
        System.out.println("username = " + username + " text = " + text);
        if(text != null)
            return notesService.findAllByUsernameAndNameOrDescription(username, text);
        else
            return notesService.findAllByUsername(username);

    }


//    @PostMapping("")
//    public ResponseEntity<NotesDto> addNotes(@RequestBody NotesDto notes) {
//        if(notes.getName().isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Notes name can't be empty");
//        }
//        NotesDto save = notesService.save(notes);
//        return ResponseEntity.ok(save);
//    }
//    @PostMapping("/create")
//    @GetMapping("/{id}/eidt")
//    @PostMapping("/{id}/edit")
//    @PostMapping("/{id}/remove")
//    @PostMapping("/isdone")

}
