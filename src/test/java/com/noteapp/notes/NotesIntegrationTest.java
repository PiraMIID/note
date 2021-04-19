package com.noteapp.notes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noteapp.config.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureMockMvc
public class NotesIntegrationTest {

    @Autowired
    private NotesRepository notesRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void itShouldCreateJsonNotesWithOutUser() {
        //Given
        User user = new User();
        user.setId(1L);
        user.setUsername("dawid");
        user.setPassword("szmajduch");
        user.setRole("ROLE_USER");

        NotesDto notes1 = new NotesDto(1L, "cosmos1", "online course1", "asdasdasd1",null, user);
        NotesDto notes2 = new NotesDto(1L, "cosmos2", "online course2", "asdasdasd2",null, user);

        //When
        //Then
    }

    private String objectToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            fail("Failed to convert object to json");
            return null;
        }
    }
}
