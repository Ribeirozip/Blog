package com.example.MBS.controllers;

import com.example.MBS.models.Postagem;
import com.example.MBS.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BlogController {

    PostRepository repository;
    //pesquisa por todos os posts
    @GetMapping("/paginaInicial")
    public List<Postagem> getAllPost(){
        return repository.findAll();
    }
    // pesquisa de post especifico
    @GetMapping("/paginaInicial/{id}")
    public ResponseEntity<Postagem> getPostagemById(@PathVariable Long id) {
        Optional<Postagem> postagemOptional = repository.findById(id);

        // Verifica se o postagem foi encontrado
        if (postagemOptional.isPresent()) {
            Postagem postagem = postagemOptional.get();
            return ResponseEntity.ok(postagem);
        } else {
            // Retorna 404 Not Found se o postagem não for encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //salvar post
    @PostMapping("/paginaInicial")
    public Postagem savePost(@RequestBody Postagem postagem){
        return repository.save(postagem);
    }
    //deletar post
    @DeleteMapping("/paginaInicial/{id}")
    public void deletePost(@PathVariable Long id){
        repository.deleteById(id);
    }
}
