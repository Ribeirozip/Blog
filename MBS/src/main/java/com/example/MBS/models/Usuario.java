package com.example.MBS.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_User;
        private String nome_User;
        private String email_User;
        private String senha_User;

        @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
        private List<Postagem> posts;
}
