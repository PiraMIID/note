package com.noteapp.config;

import com.noteapp.config.User;
import com.noteapp.user.UserDaetis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDaetis,Long> {

    Optional<User> findByUsername(String username);
}
