package com.project.mudbackend.data;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO {
    
    @NotNull
    @Min(value = 100, message = "Invalid status code")
    @Max(value = 599, message = "Invalid status code")
    int statusCode;

    @NotBlank(message = "Message is mandatory")
    String message;
}
