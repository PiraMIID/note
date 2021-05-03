package com.noteapp.notes;

import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Service
@EnableAspectJAutoProxy
@Slf4j
public class NotesService {

    private final UserRepository userRepository;
    private final NotesRepository notesRepository;

    private String username;

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
        System.out.println("service notes :" + this.username);
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


//    @Pointcut("execution(* com.noteapp.notes..*(..))")
//    private void anyMethod() {
//    }
//
//    @Before("anyMethod()")
//    private  void getusername(JoinPoint joinPoint) {
//        if (!Arrays.stream(joinPoint.getArgs()).allMatch(Objects::nonNull)) {
//            this.username = SecurityContextHolder.getContext().getAuthentication().;
//        }
//    }
}
