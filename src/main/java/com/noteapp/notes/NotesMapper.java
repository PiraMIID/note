package com.noteapp.notes;

import org.springframework.stereotype.Service;

@Service
public class NotesMapper {



    public static NotesDto toDto(Notes notes) {
        NotesDto dto = new NotesDto();
        dto.setId(notes.getId());
        dto.setName(notes.getName());
        dto.setDescription(notes.getDescription());
        dto.setCreatedAt(notes.getCreatedAt());
        dto.setUser(notes.getUser());
        return dto;
    }

    public static Notes toEntity(NotesDto dto) {
        Notes notes = new Notes();
        notes.setId(dto.getId());
        notes.setName(dto.getName());
        notes.setDescription(dto.getDescription());
        notes.setCreatedAt(dto.getCreatedAt());
        notes.setUser(dto.getUser());
        return notes;
    }
}
