package com.login.servicies;


import com.login.models.dtos.UsuarioDTO;
import com.login.models.entities.Usuario;
import com.login.repositories.UsuarioRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO save(UsuarioDTO dto){
        Usuario usuario = new Usuario(dto);
        Usuario salvo = usuarioRepository.save(usuario);
        return salvo.toDTO();
    }
}
