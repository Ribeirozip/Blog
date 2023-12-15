package com.example.MBS.services;

import com.example.MBS.models.Usuario;
import com.example.MBS.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registrarNovoUsuario(Usuario usuario) {
        // Antes de salvar, criptografa a senha do usuário
        usuario.setSenha_User(passwordEncoder.encode(usuario.getSenha_User()));
        usuarioRepository.save(usuario);
    }

    public Usuario obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario obterUsuarioPorEmail(String email) {
        return (Usuario) usuarioRepository.findByEmail(email).orElse(null);
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obterUsuarioLogado() {
        // Lógica para obter o usuário logado (pode depender da sua implementação de autenticação)
        // Retorne null se não estiver logado
        // Exemplo: Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //          return obterUsuarioPorEmail(authentication.getName());
        return null;
    }

    public void atualizarInformacoesUsuario(Usuario usuarioAtualizado) {
        // Lógica para validar e atualizar as informações do usuário
        // Implemente conforme necessário
    }

    public void excluirUsuarioAtual() {
        // Lógica para excluir a conta do usuário logado
        // Implemente conforme necessário
    }
}