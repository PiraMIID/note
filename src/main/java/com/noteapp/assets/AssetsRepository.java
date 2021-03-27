package com.noteapp.assets;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AssetsRepository extends JpaRepository<Assets, Long> {
    List<Assets> findAllByUserId(Long id);
}
