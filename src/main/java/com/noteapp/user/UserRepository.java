package com.noteapp.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.function.Consumer;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

//    Long findUserIdByUsername(String userName);

}
