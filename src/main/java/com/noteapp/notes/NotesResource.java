package com.noteapp.notes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

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




    @GetMapping("/{userName}/assets")
    public ResponseEntity<List<NotesDto>> getAll(@PathVariable("userName") String userName) {
        System.out.println(userName);
        return new ResponseEntity<>(notesService.getList().subList(1,5), HttpStatus.ACCEPTED);
    }

    @GetMapping("/assets")
    public ResponseEntity<List<NotesDto>> ggetAll() {
//        System.out.println("easy");
        return new ResponseEntity<>(notesService.getList(), HttpStatus.ACCEPTED);
    }

//    @GetMapping("/app/components/assets/asset/list/assetList.html")
//    public ResponseEntity<List<NotesDto>> aassetDtoList() {
//        return new ResponseEntity<>(notesService.getList().subList(1,5), HttpStatus.ACCEPTED);
//    }



}
