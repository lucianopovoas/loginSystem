package com.login.repositories;

import com.login.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.nome = :nome and u.senha = :senha")
    public Usuario login(@Param("nome") String nome, @Param("senha") String senha);
}
