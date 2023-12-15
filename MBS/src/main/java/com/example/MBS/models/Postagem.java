package com.example.MBS.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Post ;
    private String titulo_Post;
    private String image_Post;
    private String conteudo_Post;
    private Date data_Post;

    @ManyToOne
    @JoinColumn(name = "Usuario_id_User")
    private Usuario usuario;
}
