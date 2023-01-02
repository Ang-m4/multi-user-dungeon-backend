package com.project.mudbackend.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.mudbackend.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
    
    @Query(value = "SELECT * FROM items OFFSET ?1 LIMIT ?2", nativeQuery = true)
    List<Item> findAll(int offset, int limit);

    @Query(value = "SELECT * FROM items WHERE item_name = ?1", nativeQuery = true)
    Optional<Item> findByName(String name);
}
