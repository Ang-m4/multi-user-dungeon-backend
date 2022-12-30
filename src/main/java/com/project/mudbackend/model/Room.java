package com.project.mudbackend.model;

import java.util.ArrayList;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "rooms")
public class Room {
    
    @Id
    @GeneratedValue
    Long id;

    @OneToMany
    ArrayList<DecorativeItem> decorativeItems;

    @OneToMany
    ArrayList<Item> items;

    @OneToMany
    Set<Character> characters;

    @ManyToOne
    Monster monster;

    @OneToMany
    Set<Room> exits;

}
