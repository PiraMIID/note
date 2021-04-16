package com.noteapp.notes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotesRequest {

    private NotesDto notesDto;

    public NotesRequest(@JsonProperty("notes") NotesDto notesDto) {
        this.notesDto = notesDto;
    }
}
