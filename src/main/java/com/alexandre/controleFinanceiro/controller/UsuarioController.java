package com.alexandre.controleFinanceiro.controller;

import com.alexandre.controleFinanceiro.entity.Usuario;
import com.alexandre.controleFinanceiro.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("controleFinanceiroApi/usuarios")
@CrossOrigin("*")
public class UsuarioController{

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios () {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/id/{id}")
    public Optional<Usuario> listarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/email/{email}")
    public Optional<Usuario> listarPorEmail(@PathVariable String email){
        return usuarioService.buscarPorEmail(email);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.atualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
}