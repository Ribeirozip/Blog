package com.example.MBS.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_Post ;
    private String titulo_Post;
    private String image_Post;
    private String conteudo_Post;
    private Date data_Post;
}
