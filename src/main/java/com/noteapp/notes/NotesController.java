package com.noteapp.notes;


import com.noteapp.exceptions.ApiRequestExcaption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("api/notes")
public class NotesController {

    private final NotesService notesService;


    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }


    @GetMapping("")
    public List<NotesDto> getAll(@RequestParam(required = false) String text, @RequestAttribute("username") String username) {
        if (text != null)
            return notesService.findAllByUsernameAndNameOrDescription(username, text);
        else
            return notesService.findAllByUsername(username);
    }


    @PostMapping("/create")
    public ResponseEntity<NotesDto> addNotes(@RequestAttribute("username") String username, @RequestBody NotesDto notes) {
        if (notes.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Notes name can't be empty");
        }
        NotesDto save = notesService.save(username, notes);
        if (save == null) {
            throw new ApiRequestExcaption("Notes cannot save with exceptions");
        }
        return ResponseEntity.ok(save);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<NotesDto> update(@PathVariable("id") Long id, @RequestBody NotesDto notesDto) {
        if (!id.equals(notesDto.getId())) {
            throw new ApiRequestExcaption("The update object need to have id same as id in path");
        }
        NotesDto updated = notesService.update(notesDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public Long deleteNotes(@PathVariable("id") Long id) {
        notesService.deleteNotes(id);
        return id;
    }


}



