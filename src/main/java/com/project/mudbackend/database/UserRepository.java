package com.project.mudbackend.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.mudbackend.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM users ORDER BY ?3 LIMIT ?1,?2", nativeQuery = true)
    List<User> findAll(int offset, int limit, String sortField);
 
    @Query(value = "SELECT * FROM users WHERE user_nickname = ?1", nativeQuery = true)
    Optional<User> findByName(String user);
    
}
