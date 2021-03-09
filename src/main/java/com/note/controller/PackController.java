package com.note.controller;

import com.note.entity.Note;
import com.note.repository.PackRepository;
import com.note.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("user/{id}")
public class PackController {

    private PackRepository packRepository;
    private PackService packService;

    @Autowired
    public PackController(PackService packService) {
        this.packService = packService;
    }

    @GetMapping("/notes-list")
    public List<Note> getAllNotes(@PathVariable Long userId) {
        return packService.findAll();
    }
}
