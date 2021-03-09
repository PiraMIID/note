package com.note.repository;

import com.note.entity.Note;
import com.note.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackRepository extends JpaRepository<Pack, Long> {
    List<Note> getNotes();
}
