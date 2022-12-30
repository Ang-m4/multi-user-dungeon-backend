package com.project.mudbackend.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Entity(name = "monsters")
public class Monster {
    
    @Id
    @GeneratedValue
    @Column(name = "monster_id")
    Long id;

    @Column(name = "monster_name")
    String name;

    @Column(name = "monster_last_update")
    LocalDate lastUpdate;

    @Column(name = "monster_attack_level")    
    Integer attackLevel;

    @Column(name = "monster_defence_slash")
    Integer defenceSlash;

    @Column(name = "monster_size")
    Integer size;

    @Column(name = "monster_hitpoints")
    Integer hitpoints;

    @ElementCollection
    @CollectionTable(name = "monster_categories", joinColumns = @JoinColumn(name = "monster_id"))
    @Column(name = "monster_categorie")
    Set<String> category;

    @Column(name = "monster_examine")
    String examine;

    @Column(name = "monster_wikiURL")
    String wikiURL;
    
}
