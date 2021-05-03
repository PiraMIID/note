package com.noteapp.notes;

import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class NotesRepositoryTest {
    /*
    Im use h2 database cause is working on RAM memory so is faster then postgres
    * */


    @Autowired
    private NotesRepository underTest;

    @Autowired
    private UserRepository userRepository;

    private String usernameDawid;
    private String usernameKasia;

    @BeforeEach
    void setUnderTest() {

        User dawid = new User();
        dawid.setId(1L);
        this.usernameDawid = "dawid";
        dawid.setUsername(usernameDawid);
        dawid.setPassword("szmajduch");
        dawid.setRole("ROLE_USER");
        userRepository.save(dawid);

        User kasia = new User();
        kasia.setId(2L);
        this.usernameKasia = "Kasia";
        kasia.setUsername(usernameKasia);
        kasia.setPassword("Bartoszewicz");
        kasia.setRole("ROLE_USER");
        userRepository.saveAll(List.of(kasia, dawid));

//        Notes notes1 = new Notes(1L, "cosmos1", "online course1", LocalDateTime.now(), null, dawid);
//        Notes notes2 = new Notes(2L, "cosmos2", "online course2", LocalDateTime.now(), null, dawid);
        Notes notes3 = new Notes(3L, "cosmos31", "online course32", LocalDateTime.now(), null, dawid);
        Notes notes4 = new Notes(4L, "cosmos4", "online course4", LocalDateTime.now(), null, dawid);
        Notes notes5 = new Notes(5L, "cosmos5", "online course5", LocalDateTime.now(), null, kasia);
        Notes notes6 = new Notes(6L, "cosmos6", "online course6", LocalDateTime.now(), null, kasia);

        underTest.saveAll(List.of(notes3, notes4, notes5, notes6));
    }


    @Test
    void itShouldReturnListNotesOfUserByUsername() {
        // Given
        // When
        List<Notes> allByUsernameDawid = underTest.findAllByUsername(usernameDawid);


        // Then

//        Dawid
        assertThat(allByUsernameDawid).hasSize(2)
                .isInstanceOf(List.class);
        assertThat(allByUsernameDawid
                .stream()
                .filter(notes -> notes.getUser().getUsername().equals(usernameDawid))
                .count()).isEqualTo(2);

//        Kasia
        List<Notes> allByUsernameKasia = underTest.findAllByUsername(usernameKasia);
        assertThat(allByUsernameKasia).hasSize(2)
                .isInstanceOf(List.class);
        assertThat(allByUsernameKasia
                .stream()
                .filter(notes -> notes.getUser().getUsername().equals(usernameKasia)));
    }

    @Test
    void itShouldGetListOfAssetsWithUsernameAndNameOrDescription() {
        // Given
        // When
//                Notes notes3 = new Notes(3L, "cosmos31", "online course3", LocalDateTime.now(), null, dawid);
        List<Notes> allByUsernameDawid = underTest.findAllByUsernameAndNameOrDescription(usernameDawid, "3");

        // Then

//        Dawid
        assertThat(allByUsernameDawid).hasSize(1)
                .isInstanceOf(List.class);
        assertThat(allByUsernameDawid
                .stream()
                .filter(notes ->
                        notes.getUser().getUsername().equals(usernameDawid) &&
                                (notes.getName().contains("3") || notes.getDescription().contains("3")))
                .count()).isEqualTo(1);
    }

    @Test
    void itShouldGetListOfAssetsWithUsernameAndJustName() {
        // Given
        // When
//                Notes notes3 = new Notes(3L, "cosmos31", "online course32", LocalDateTime.now(), null, dawid);
        List<Notes> allByUsernameDawid = underTest.findAllByUsernameAndNameOrDescription(usernameDawid, "1");

        // Then

//        Dawid
        assertThat(allByUsernameDawid).hasSize(1)
                .isInstanceOf(List.class);
        assertThat(allByUsernameDawid
                .stream()
                .filter(notes ->
                        notes.getUser().getUsername().equals(usernameDawid) &&
                                (notes.getName().contains("1") || notes.getDescription().contains("1")))
                .count()).isEqualTo(1);
    }

    @Test
    void itShouldGetListOfAssetsWithUsernameAndJustDescription() {
        // Given
        // When
//                Notes notes3 = new Notes(3L, "cosmos31", "online course32", LocalDateTime.now(), null, dawid);
        List<Notes> allByUsernameDawid = underTest.findAllByUsernameAndNameOrDescription(usernameDawid, "2");

        // Then

//        Dawid
        assertThat(allByUsernameDawid).hasSize(1)
                .isInstanceOf(List.class);
        assertThat(allByUsernameDawid
                .stream()
                .filter(notes ->
                        notes.getUser().getUsername().equals(usernameDawid) &&
                                (notes.getName().contains("2") || notes.getDescription().contains("2")))
                .count()).isEqualTo(1);
    }

    @Test
    void itShouldGetListNotes() {
        // Given
        // When
        List<Notes> allByUsernameDawid = underTest.findAllByUserUsernameAndName(usernameDawid, "cosmos31");
        // Then
        assertThat(allByUsernameDawid).hasSize(1)
                .isInstanceOf(List.class);

    }
}
