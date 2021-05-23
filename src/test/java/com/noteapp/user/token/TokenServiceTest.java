package com.noteapp.user.token;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.noteapp.exception.httpException.ApiConflictException;
import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import com.noteapp.user.email.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TokenServiceTest {

  @Mock
  private TokenRepository tokenRepository;
  @Mock
  private UserRepository userRepository;
  @Mock
  private MailService mailService;

  private TokenService underTest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    this.underTest = new TokenService(tokenRepository,userRepository,mailService);
  }

  @BeforeEach
  void afterEach() {
    User user = new User();
    user.setUsername("Andrzej");
    user.setEmail("email@o2.pl");
    userRepository.save(user);
  }

  @Test
  void itShouldThrowWhenEmailIsTaken() {
    // Given
    String email = "email@o2.pl";
    String username = "Eldon";
    SignupRequest signupRequest = new SignupRequest();
    signupRequest.setEmail(email);
    signupRequest.setUsername(username);

    // When
    when(underTest.checkEmailIsTaken(email)).thenReturn(true);

    // Then
    assertThrows(ApiConflictException.class, () -> underTest.checkNotDataNotAlreadyInDB(signupRequest));
  }

  @Test
  void itShouldThrowWhenUsernameIsTaken() {
    // Given
    String email = "asd@dsfg.pl";
    String username = "Andrzej";
    SignupRequest signupRequest = new SignupRequest();
    signupRequest.setEmail(email);
    signupRequest.setUsername(username);

    // When
    when(underTest.checkUsernameIsTaken(username)).thenReturn(true);

    // Then
    assertThrows(ApiConflictException.class, () -> underTest.checkNotDataNotAlreadyInDB(signupRequest));
  }

  @Test
  void itShouldName() {



  }
}
