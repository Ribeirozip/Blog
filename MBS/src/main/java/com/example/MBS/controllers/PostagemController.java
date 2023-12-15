package com.example.MBS.controllers;


import com.example.MBS.models.Postagem;
import com.example.MBS.services.PostagemService;
import com.example.MBS.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemService postagemService;
    private final UsuarioService usuarioService;

    @Autowired
    public PostagemController(PostagemService postagemService, UsuarioService usuarioService) {
        this.postagemService = postagemService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String exibirTodasPostagens(Model model) {
        model.addAttribute("postagens", postagemService.obterTodosPosts());
        return "todasPostagens";
    }

    @GetMapping("/{postId}")
    public String exibirDetalhesPostagem(@PathVariable Long postId, Model model) {
        Postagem postagem = postagemService.obterPostPorId(postId);
        model.addAttribute("postagem", postagem);
        return "detalhesPostagem";
    }

    @GetMapping("/nova")
    public String formularioNovaPostagem(Model model) {
        model.addAttribute("postagem", new Postagem());
        model.addAttribute("usuarios", usuarioService.listarTodosUsuarios());
        return "novaPostagem";
    }

    @PostMapping("/nova")
    public String salvarNovaPostagem(Postagem postagem) {
        postagemService.salvarNovoPost(postagem);
        return "redirect:/postagens";
    }

    @GetMapping("/{postId}/editar")
    public String formularioEditarPostagem(@PathVariable Long postId, Model model) {
        Postagem postagem = postagemService.obterPostPorId(postId);
        model.addAttribute("postagem", postagem);
        model.addAttribute("usuarios", usuarioService.listarTodosUsuarios());
        return "editarPostagem";
    }

    @PostMapping("/{postId}/editar")
    public String atualizarPostagem(@ModelAttribute Postagem postagemAtualizada) {
        postagemService.atualizarPost(postagemAtualizada);
        return "redirect:/postagens";
    }

    @PostMapping("/{postId}/excluir")
    public String excluirPostagem(@PathVariable Long postId) {
        postagemService.excluirPost(postId);
        return "redirect:/postagens";
    }
}
