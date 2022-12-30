package com.project.mudbackend.data;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDTO {
    
    @NotNull
    Long id;

    @NotBlank(message = "The item must have a name")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    String name;

    @NotNull(message = "The item must have a last updated date")
    LocalDate lastUpdated;

    @NotNull(message = "The item must have a cost")
    @Min(value = 0, message = "Invalid cost, it must be greater than zero")
    Integer cost;

    @NotNull(message = "The item must have a valid weight")
    @Min(value = 0, message = "Invalid weight, it must be greater than zero")
    Float weight;

    @NotNull(message = "The item must have a valid description")
    String examine;
    String url;
    
}
