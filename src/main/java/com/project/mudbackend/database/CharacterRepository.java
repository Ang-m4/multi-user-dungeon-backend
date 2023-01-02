package com.project.mudbackend.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.mudbackend.model.Character;

public interface CharacterRepository extends JpaRepository<Character,Long> {

    @Query(value = "SELECT * From characters c INNER JOIN users u ON u.character_character_id = c.character_id WHERE u.user_id = ?1", nativeQuery = true)
    Optional<Character> getByUserId(Long userId);

}
