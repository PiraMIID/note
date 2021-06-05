package com.noteapp.notes;

import com.fasterxml.jackson.annotation.JsonProperty;


//todo: 11: today check that this class is needed (i live for now)

public class NotesRequest {

    private final NotesDto notesDto;

    public NotesRequest(@JsonProperty("notesDto") NotesDto notesDto) {
        System.out.println(notesDto);
        this.notesDto = notesDto;
    }

    public NotesDto getNotesDto() {
        return notesDto;
    }

    @Override
    public String toString() {
        return "NotesRequest{" +
                "notesDto=" + notesDto +
                '}';
    }
}
