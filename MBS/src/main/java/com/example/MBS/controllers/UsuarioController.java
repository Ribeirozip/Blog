package com.example.MBS.controllers;

import com.example.MBS.models.Usuario;
import com.example.MBS.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registro")
    public String registroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(Usuario usuario) {
        usuarioService.registrarNovoUsuario(usuario);
        return "redirect:/login";
    }

    @GetMapping("/perfil")
    public String exibirPerfil(Model model) {
        Usuario usuarioLogado = usuarioService.obterUsuarioLogado();
        model.addAttribute("usuario", usuarioLogado);
        return "perfil";
    }

    @PostMapping("/perfil/atualizar")
    public String atualizarPerfil(Usuario usuarioAtualizado) {
        usuarioService.atualizarInformacoesUsuario(usuarioAtualizado);
        return "redirect:/usuarios/perfil";
    }

    @PostMapping("/perfil/excluir")
    public String excluirConta() {
        usuarioService.excluirUsuarioAtual();
        return "redirect:/logout";
    }

    @GetMapping("/admin/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodosUsuarios());
        return "listaUsuarios";
    }
}
