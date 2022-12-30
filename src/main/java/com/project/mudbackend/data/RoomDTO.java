package com.project.mudbackend.data;

import java.util.ArrayList;
import java.util.Set;

import com.project.mudbackend.model.DecorativeItem;
import com.project.mudbackend.model.Item;
import com.project.mudbackend.model.Monster;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RoomDTO {
    
    @NotNull
    Long id;

    ArrayList<DecorativeItem> decorativeItems;

    @NotEmpty(message = "A room must have at least one item")
    ArrayList<Item> items;

    @NotEmpty(message = "A room must have at leat a player")
    Set<Character> characters;

    Monster monster;

}
