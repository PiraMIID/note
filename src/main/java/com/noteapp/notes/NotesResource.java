package com.noteapp.notes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotesResource {

    private NotesService notesService;

    public NotesResource(NotesService notesService) {
        this.notesService = notesService;
    }

//    @GetMapping("/{userName}/user")
//    public User getUser(@PathVariable String userName) {
//        return assetsService.getUser(userName);
//    }

    @GetMapping("/assets")
    public List<NotesDto> assetDtoList() {
        return notesService.getList();
    }

//    @GetMapping("/{userName}/assets")
//    public UserDetails assetDtoList(@PathVariable("username") String userName) {
//        return assetsService.getUser(userName);
//    }



}
