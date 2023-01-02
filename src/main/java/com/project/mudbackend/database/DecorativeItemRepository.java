package com.project.mudbackend.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.mudbackend.model.DecorativeItem;

public interface DecorativeItemRepository extends JpaRepository<DecorativeItem,Long> {
    
    @Query(value = "SELECT * FROM decorative_items OFFSET ?1 LIMIT ?2", nativeQuery = true)
    List<DecorativeItem> findAll(int offset, int limit);

    @Query(value = "SELECT * FROM decorative_items WHERE decorative_item_name = ?1", nativeQuery = true)
    Optional<DecorativeItem> findByName(String name);

}
