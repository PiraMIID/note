package com.note.service;

import com.note.entity.Note;
import com.note.repository.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackService {

    private PackRepository packRepository;

    @Autowired
    public PackService(PackRepository packRepository) {
        this.packRepository = packRepository;
    }


    public List<Note> findAll() {
        return packRepository .getNotes();
    }
}
