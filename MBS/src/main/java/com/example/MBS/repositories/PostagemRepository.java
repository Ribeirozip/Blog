package com.example.MBS.repositories;

import com.example.MBS.models.Postagem;
import com.example.MBS.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostagemRepository extends JpaRepository<Postagem,Long> {
    List<Postagem> findByUsuario(Usuario usuario);

}
