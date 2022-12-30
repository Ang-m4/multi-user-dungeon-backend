package com.project.mudbackend.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

import com.project.mudbackend.model.Item;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterDTO {

    @NotNull
    Long id;

    @NotBlank(message = "The character must have a name")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    String name;

    @NotNull(message = "message = The character must have a last updated date")
    LocalDate lastUpdate;

    @NotNull(message = "The character must have a valid attack level")
    @Min(value = 0, message = "Invalid attack level, it must be greater than zero")
    Integer attackLevel;

    @NotNull(message = "The character must have a valid defence slash")
    @Min(value = 0, message = "Invalid defence slash, it must be greater than zero")
    Integer defenceSlash;

    @NotNull(message = "The character must have valid size")
    @Min(value = 0, message = "Invalid size, it must be greater than zero")
    Integer size;

    @NotNull(message = "The character must have a valir hitpoints stat")
    @Min(value = 0, message = "Invalid hitpoints, it must be greater than zero")
    Integer hitpoints;

    Set<String> category;
    String examine;
    Integer weight;
    ArrayList<Item> items;
}
