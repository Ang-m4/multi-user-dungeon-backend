package com.project.mudbackend.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    @NotNull
    Long id;

    @NotBlank(message = "The user must have a nickname")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must be 8 characters long, at least one lettter and one number")
    String nickname;

    @NotBlank(message = "The user must have a password")
    String password;

    @NotBlank(message = "The user must have a role")
    @Pattern(regexp = "^(ROLE_ADMIN|ROLE_USER|ROLE_DESIGNER)$")
    String role;

}
