package com.login.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
       @NotEmpty String nome,
       @NotEmpty @Email String email,
       @NotEmpty @Size(min = 6) String senha) {
}
