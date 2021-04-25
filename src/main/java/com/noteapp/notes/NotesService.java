package com.noteapp.notes;

import com.noteapp.config.User;
import com.noteapp.config.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotesService {

    private final UserRepository userRepository;
    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository, UserRepository userRepository) {
        this.notesRepository = notesRepository;
        this.userRepository = userRepository;
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

    public NotesDto save(String username, NotesDto notesDto) {
        Notes notes = NotesMapper.toEntity(notesDto);
        notes.setUser(getUserByName(username));
        Notes save = notesRepository.save(notes);
        return NotesMapper.toDto(save);
    }

    public User getUserByName(String username) {
        return userRepository.findByUsername(username).get();
    }

    public NotesDto update(NotesDto notesDto) {
        Notes notes = notesRepository.getOne(notesDto.getId());
        Notes save = notesRepository.save(notes);
        return NotesMapper.toDto(save);
    }

    public void deleteNotes(Long id) {
        notesRepository.deleteById(id);
    }
}
