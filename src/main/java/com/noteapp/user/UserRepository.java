package com.noteapp.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.function.Consumer;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);

    //todo: make test of it is working well
//    @Query("select true as user from User u where u.email like ?1 and u.isAccountNonLocked=false")
    boolean existsByEmail(String email);


    /**
     * this method
     */
    @Modifying
    @Query("DELETE FROM User u where u.isAccountNonLocked=false and (select COUNT(t) from Token t where t.user=u)=0 ")
    void removeIfAccountIsNotConfirmAndTokenNotExist();

//    Long findUserIdByUsername(String userName);

}
