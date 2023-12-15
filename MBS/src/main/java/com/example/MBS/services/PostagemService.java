package com.example.MBS.services;

import com.example.MBS.models.Postagem;
import com.example.MBS.models.Usuario;
import com.example.MBS.repositories.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostagemService {

    private final PostagemRepository postagemRepository;

    @Autowired
    public PostagemService(PostagemRepository postRepository) {
        this.postagemRepository = postRepository;
    }

    public List<Postagem> obterTodosPosts() {
        return postagemRepository.findAll();
    }

    public Postagem obterPostPorId(Long id) {
        return postagemRepository.findById(id).orElse(null);
    }

    public List<Postagem> obterPostsPorUsuario(Usuario usuario) {
        return postagemRepository.findByUsuario(usuario);
    }

    public void salvarNovoPost(Postagem post) {
        // Lógica para salvar um novo post
        postagemRepository.save(post);
    }

    public void atualizarPost(Postagem postAtualizado) {
        // Lógica para validar e atualizar um post existente
        // Implemente conforme necessário
    }

    public void excluirPost(Long postId) {
        // Lógica para excluir um post pelo ID
        postagemRepository.deleteById(postId);
    }
}