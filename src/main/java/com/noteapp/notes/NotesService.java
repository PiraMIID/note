package com.noteapp.notes;

import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<NotesDto> findAll() {
        return notesRepository.findAllByUsername(username())
                .stream()
                .map(NotesMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<NotesDto> findAllByNameOrDescription(String text) {
        return notesRepository.findAllByUsernameAndNameOrDescription(username(), text)
                .stream()
                .map(NotesMapper::toDto)
                .collect(Collectors.toList());
    }

    public NotesDto save(NotesDto notesDto) {
        Notes notes = NotesMapper.toEntity(notesDto);
        notes.setUser(getUserByName());
        Notes save = notesRepository.save(notes);
        return NotesMapper.toDto(save);
    }

    public User getUserByName() {
        return userRepository.findByUsername(username()).get();
    }

    public NotesDto update(NotesDto notesDto) {
        Notes notes = notesRepository.getOne(notesDto.getId());
        Notes save = notesRepository.save(notes);
        return NotesMapper.toDto(save);
    }

    public void deleteNotes(Long id) {
        notesRepository.deleteById(id);
    }

    private String username() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
