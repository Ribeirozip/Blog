package com.example.MBS.repositories;

import com.example.MBS.models.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PostRepository extends JpaRepository<Postagem,Long> {
}
