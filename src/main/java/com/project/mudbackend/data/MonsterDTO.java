package com.project.mudbackend.data;

import java.time.LocalDate;
import java.util.Set;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonsterDTO {
    
    @NotNull
    Long id;

    @NotBlank(message = "The monster must have a valid name")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    String name;

    @NotNull(message = "The monster must have a valid last updated date")
    LocalDate lastUpdate;

    @NotNull(message = "The monster must have an attack level")
    @Min(value = 0, message = "Invalid attack level, it must be greater than zero")
    Integer attackLevel;

    @NotNull(message = "The monster must have a valid defence slash")
    @Min(value = 0, message = "Invalid defence slash, it must be greater than zero")
    Integer defenceSlash;

    @NotNull(message = "The monster must have a valid size")
    @Min(value = 0, message = "Invalid size, it must be greater than zero")
    Integer size;

    @NotNull(message = "The monster must have a valid hitpoints stat")
    @Min(value = 0, message = "Invalid hitpoints, it must be greater than zero")
    Integer hitpoints;

    Set<String> category;

    @NotBlank(message = "The monster must have a description")
    String examine;
    String wikiURL;
    
}
