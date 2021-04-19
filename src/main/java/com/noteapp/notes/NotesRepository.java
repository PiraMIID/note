package com.noteapp.notes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Long> {

    @Query("select n from Notes n where n.user.username = ?1")
    List<Notes> findAllByUsername(String dawid);
}
