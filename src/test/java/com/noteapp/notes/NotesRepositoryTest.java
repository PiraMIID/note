package com.noteapp.notes;

import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class NotesRepositoryTest {


    @Autowired
    private NotesRepository underTest;

    @Autowired
    private UserRepository userRepository;

    private String usernameDawid;
    private String usernameKasia;

    @BeforeEach
    void setUnderTest() {

        User dawid = new User();
        this.usernameDawid = "dawid";
        dawid.setUsername(usernameDawid);
        dawid.setPassword("szmajduch");
        dawid.setRole("ROLE_USER");

        User kasia = new User();
        this.usernameKasia = "Kasia";
        kasia.setUsername(usernameKasia);
        kasia.setPassword("Bartoszewicz");
        kasia.setRole("ROLE_USER");
        userRepository.saveAll(List.of(kasia, dawid));

        Notes notes1 = new Notes("cosmos1", "online course1", LocalDateTime.now(), null, dawid);
        Notes notes2 = new Notes("cosmos2", "online course2", LocalDateTime.now(), null, dawid);
        Notes notes5 = new Notes("cosmos5", "online course5", LocalDateTime.now(), null, kasia);
        Notes notes6 = new Notes("cosmos6", "online course6", LocalDateTime.now(), null, kasia);

        underTest.saveAll(List.of(notes1,notes2, notes5, notes6));
    }


    @Test
    void itShouldReturnListNotesOfUserByUsername() {
        // Given
        // When
        List<Notes> allByUsernameDawid = underTest.findAllByUsername(usernameDawid);
        List<Notes> allByUsernameKasia = underTest.findAllByUsername(usernameKasia);
        // Then

//        Dawid
        assertThat(allByUsernameDawid
                .stream()
                .filter(notes -> notes.getUser().getUsername().equals(usernameDawid))
                .count()).isEqualTo(2);

//        Kasia


        assertThat(allByUsernameKasia
                .stream()
                .filter(notes -> notes.getUser().getUsername().equals(usernameKasia)));
    }

    @Test
    void itShouldGetListOfAssetsWithUsernameAndNameOrDescription() {
        // Given
        // When
//                Notes notes3 = new Notes(3L, "cosmos31", "online course3", LocalDateTime.now(), null, dawid);
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

}
