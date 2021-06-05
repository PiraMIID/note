package com.noteapp;

import com.github.javafaker.Faker;
import com.noteapp.note.Note;
import com.noteapp.note.NoteRepository;
import com.noteapp.notes.Notes;
import com.noteapp.notes.NotesRepository;
import com.noteapp.todos.Todo;
import com.noteapp.todos.TodoRepository;
import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class Start {
    public Start(NotesRepository notesRepository,
                 UserRepository userRepository,
                 PasswordEncoder passwordEncoder,
                 NoteRepository noteRepository,
                 TodoRepository todoRepository) {

        User appUser = new User();

        appUser.setUsername("dawid");
        appUser.setPassword(passwordEncoder.encode("szmajduch"));
        appUser.setRole("ROLE_USER");
        userRepository.save(appUser);



//        Notes notesUser = new Notes();

//        notesUser.setName("nota 1");
//        notesUser.setDescription("opis");
//        notesUser.setCreatedAt(LocalDateTime.now());
//        notesUser.setUser(appUser);
//        notesRepository.save(notesUser);
//
//        Notes notesUser0 = new Notes();
//
//        notesUser0.setName("nota 2");
//        notesUser0.setDescription("opis");
//        notesUser0.setCreatedAt(LocalDateTime.now());
//        notesUser0.setUser(appUser);
//        notesRepository.save(notesUser0);
//
//        Notes notesUser1 = new Notes();
//
//        notesUser1.setName("nota 3");
//        notesUser1.setDescription("opis");
//        notesUser1.setCreatedAt(LocalDateTime.now());
//        notesUser1.setUser(appUser);
//        notesRepository.save(notesUser1);



        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Notes notes = addNotes(faker,appUser);
            notesRepository.save(notes);
//            for (int j = 0; j < 5; j++) {
//                addNoteToNotes(faker,notes,noteRepository);
//
//            }
            addTodos(faker,appUser, todoRepository);
        }
    }

    Notes addNotes(Faker faker,User user) {
        Notes notes = new Notes();
        notes.setUser(user);
        notes.setName(faker.educator().course());
        notes.setCreatedAt(LocalDateTime.now());
        notes.setDescription(faker.chuckNorris().fact());
        return notes;
    }

//    void addNoteToNotes(Faker faker, Notes notes,NoteRepository noteRepository) {
//        Note note = new Note();
//        note.setQuestion(faker.lorem().sentence());
//        note.setTxtValue(faker.lorem().sentence(20));
//        note.setNotes(notes);
//        noteRepository.save(note);
//    }

    void addTodos(Faker faker, User user, TodoRepository todoRepository) {
        Todo todo = new Todo();
        todo.setName(faker.job().keySkills());
        todo.setDone(faker.bool().bool());
        todo.setUser(user);
        todo.setValue(faker.lorem().sentence(10));
        todoRepository.save(todo);
    }

}
