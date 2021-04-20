package com.noteapp.notes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noteapp.config.User;
import com.noteapp.config.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


class NotesServiceTest {

    @Mock
    private NotesRepository notesRepository;
    @Mock
    private UserRepository userRepository;
    @Captor
    private ArgumentCaptor<Notes> notesArgumentCaptor;

    private NotesService underTest;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new NotesService(notesRepository,userRepository);
    }



    @Test
    void itShouldGetListNotesOfUser() throws JsonProcessingException {
        // Given
        User user = new User();
        user.setId(1L);
        user.setUsername("dawid");
        user.setPassword("szmajduch");
        user.setRole("ROLE_USER");

        NotesDto notes1 = new NotesDto(1L, "cosmos1", "online course1", "asdasdasd1",null,  user);
        NotesDto notes2 = new NotesDto(1L, "cosmos2", "online course2", "asdasdasd2",null,  user);
        NotesDto notes3 = new NotesDto(1L, "cosmos3", "online course3", "asdasdasd3",null,  user);
        NotesDto notes4 = new NotesDto(1L, "cosmos4", "online course4", "asdasdasd4",null,  user);

        List<Notes> notesList = notesRepository.findAllByUsername("dawid");
        NotesRequest notesRequest = new NotesRequest(notes1);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(notesRequest);
        NotesRequest backjsonString = objectMapper.readValue(jsonString, NotesRequest.class);
        System.out.println(notesRequest);
        System.out.println(jsonString);

        System.out.println(backjsonString.toString());
        // When


        // Then

    }

    @Test
    void itShouldSaveNotes() {
        // Given
        User dawid = new User();
        dawid.setId(1L);
        String usernameDawid = "dawid";
        dawid.setUsername(usernameDawid);
        dawid.setPassword("szmajduch");
        dawid.setRole("ROLE_USER");
        userRepository.save(dawid);

        Notes notes = new Notes(1L, "cosmos1", "online course1", LocalDateTime.now(), null, dawid);
        NotesDto notesDto = NotesMapper.toDto(notes);
        NotesRequest notesRequest = new NotesRequest(notesDto);

        // When
        underTest.saveNotes(notesRequest);

        // Then
        then(notesRepository).should().save(notesArgumentCaptor.capture());


    }
}
