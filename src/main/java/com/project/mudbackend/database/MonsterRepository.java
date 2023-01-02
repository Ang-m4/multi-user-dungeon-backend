package com.project.mudbackend.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.mudbackend.model.Monster;

public interface MonsterRepository extends JpaRepository<Monster,Long> {
    
    @Query(value = "SELECT * FROM monsters OFFSET ?1 LIMIT ?2", nativeQuery = true)
    List<Monster> findAll(int offset, int limit);

    @Query(value = "SELECT * FROM monsters WHERE monster_name = ?1",nativeQuery = true)
    Optional<Monster> findByName(String name);
}
