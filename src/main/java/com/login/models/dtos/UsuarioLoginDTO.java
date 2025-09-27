package com.login.models.dtos;

import jakarta.validation.constraints.NotEmpty;

public record UsuarioLoginDTO(
        @NotEmpty String nome,
        @NotEmpty String senha
) {
}
