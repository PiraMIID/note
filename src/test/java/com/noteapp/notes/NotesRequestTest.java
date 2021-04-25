package com.noteapp.notes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noteapp.config.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NotesRequestTest {

    //for fan | is not necessary
    @Test
    void itShouldNotAddUserToJsonNotesRequest() throws JsonProcessingException {
        // Given
        User user = new User();
        user.setId(1L);
        user.setUsername("dawid");
        user.setPassword("szmajduch");
        user.setRole("ROLE_USER");

        NotesDto notes = new NotesDto(1L, "cosmos1", "online course1", "asdasdasd1", null, user);

        // When
        NotesRequest beforeJSON = new NotesRequest(notes);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(beforeJSON);
        NotesRequest afterJSON = objectMapper.readValue(jsonString, NotesRequest.class);

        // Then
        then(beforeJSON.getNotesDto().getUser()).isNotNull();
        then(notes.getUser()).isNotNull();
        then(afterJSON.getNotesDto().getUser()).isNull();

        then(afterJSON.getNotesDto().getName()).isEqualTo(beforeJSON.getNotesDto().getName());
        then(afterJSON.getNotesDto().getName()).isEqualTo(notes.getName());
        then(afterJSON.getNotesDto().getDescription()).isEqualTo(beforeJSON.getNotesDto().getDescription());
        then(afterJSON.getNotesDto().getDescription()).isEqualTo(notes.getDescription());
    }

}
