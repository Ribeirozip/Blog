package com.example.MBS.repositories;

import com.example.MBS.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("Select email_User from Usuario")
    Optional<Object> findByEmail(String email);

    // Adicione métodos personalizados, se necessário
}
