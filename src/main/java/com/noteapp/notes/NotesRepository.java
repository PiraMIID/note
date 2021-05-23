package com.noteapp.notes;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface NotesRepository extends JpaRepository<Notes, Long> {

  @Query("select n from Notes n where n.user.username = :username")
  List<Notes> findAllByUsername(String username);

  @Query("select n from Notes n where lower(n.name) like lower(concat('%', :text ,'%')) " +
      "or lower(n.description) like lower(concat('%', :text, '%')) " +
      "and n.user.username like :username ")
  List<Notes> findAllByUsernameAndNameOrDescription(String username, String text);

  Notes save(Notes notes);

  void deleteById(Long id);
}
