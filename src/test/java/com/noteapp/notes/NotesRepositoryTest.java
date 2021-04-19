package com.noteapp.notes;

import com.noteapp.config.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class NotesRepositoryTest {
    /*
    Im use h2 database cause is working on RAM memory so is faster then postgres
    * */

    @Autowired
    private NotesRepository underTest;

    @Test
    void itShouldReturnListNotesOfUser() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setUsername("dawid");
        user.setPassword("szmajduch");
        user.setRole("ROLE_USER");

        NotesDto notes1 = new NotesDto(1L, "cosmos1", "online course1", "asdasdasd1",null,  user);
        NotesDto notes2 = new NotesDto(1L, "cosmos2", "online course2", "asdasdasd2",null,  user);
        NotesDto notes3 = new NotesDto(1L, "cosmos3", "online course3", "asdasdasd3",null,  user);
        NotesDto notes4 = new NotesDto(1L, "cosmos4", "online course4", "asdasdasd4",null,  user);

        // When
        List<Notes> notesList = underTest.findAllByUsername("dawid");

        // Then



    }
}
