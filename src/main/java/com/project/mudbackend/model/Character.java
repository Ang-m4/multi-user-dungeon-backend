package com.project.mudbackend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "characters")
public class Character {
    
    @Id
    @GeneratedValue
    @Column(name = "character_id")
    Long id;

    @Column(name = "character_name")
    String name;

    @Column(name = "character_last_update")
    LocalDate lastUpdate;

    @Column(name = "character_attack_level")
    Integer attackLevel;

    @Column(name = "character_defence_slash")
    Integer defenceSlash;

    @Column(name = "chatacter_size")
    Integer size;
    
    @Column(name = "character_hitpoints")
    Integer hitpoints;

    @ElementCollection
    @CollectionTable(name = "character_categories", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "character_categorie")
    Set<String> category;

    @Column(name = "character_examine")
    String examine;

    @Column(name = "character_weight")
    Integer weight;

    @OneToMany
    ArrayList<Item> items;
    
}
