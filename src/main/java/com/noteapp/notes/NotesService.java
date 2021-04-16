package com.noteapp.notes;

import com.noteapp.config.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotesService {

    private UserRepository userRepository;
    private NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository, UserRepository userRepository) {
        this.notesRepository = notesRepository;
        this.userRepository = userRepository;
    }


    public List<NotesDto> getList() {
        return notesRepository.findAll()
                .stream()
                .map(NotesMapper::toDto)
                .collect(Collectors.toList());
    }

    public NotesDto save(NotesDto notesDto) {
        Notes notes = NotesMapper.toEntity(notesDto);
        Notes save = notesRepository.save(notes);
        return NotesMapper.toDto(save);
    }
}
