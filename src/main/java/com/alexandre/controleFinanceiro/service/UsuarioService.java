package com.alexandre.controleFinanceiro.service;

import com.alexandre.controleFinanceiro.entity.Usuario;
import com.alexandre.controleFinanceiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario){
        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario não encontrado pelo id" +id);
        }
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario não encontrado pelo id" +id);
        }
        usuarioRepository.deleteById(id);
    }
}
