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

    public NotesDto saveNotes(NotesRequest notesRequest) {
        NotesDto notesDto = notesRequest.getNotesDto();
        Notes notes = NotesMapper.toEntity(notesDto);
        Notes save = notesRepository.save(notes);
        return NotesMapper.toDto(save);
    }

    public List<NotesDto> findAllByUsername(String username) {
        return notesRepository.findAllByUsername(username)
                .stream()
                .map(NotesMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<NotesDto> findAllByUsernameAndNameOrDescription(String username, String text) {
        return notesRepository.findAllByUsernameAndNameOrDescription(username, text)
                .stream()
                .map(NotesMapper::toDto)
                .collect(Collectors.toList());
    }
}
