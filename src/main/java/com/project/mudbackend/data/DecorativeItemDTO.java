package com.project.mudbackend.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DecorativeItemDTO {
    
    @NotNull
    Long id;
    
    @NotBlank(message = "The decorative must have a name")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    String name;
    
}
