package com.noteapp.notes;

import com.noteapp.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotesDtoTest {
    @Test
    public void testSetId() {
        NotesDto notesDto = new NotesDto();
        notesDto.setId(123L);
        assertEquals(123L, notesDto.getId().longValue());
    }

    @Test
    public void testSetName() {
        NotesDto notesDto = new NotesDto();
        notesDto.setName("Name");
        assertEquals("Name", notesDto.getName());
    }

    @Test
    public void testSetDescription() {
        NotesDto notesDto = new NotesDto();
        notesDto.setDescription("The characteristics of someone or something");
        assertEquals("The characteristics of someone or something", notesDto.getDescription());
    }

    @Test
    public void testSetCategory() {
        NotesDto notesDto = new NotesDto();
        notesDto.setCategory("Category");
        assertEquals("Category", notesDto.getCategory());
    }


    @Test
    public void testSetCreatedAt() {
        NotesDto notesDto = new NotesDto();
        notesDto.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        assertEquals("NotesDto{id=null, name='null', description='null', category='null', createdAt=0001-01-01T01:01,"
                + " user=null}", notesDto.toString());
    }

    @Test
    public void testToString() {
        assertEquals("NotesDto{id=null, name='null', description='null', category='null', createdAt=null, user=null}",
                (new NotesDto()).toString());
    }
}

