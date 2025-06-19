package com.alexandre.controleFinanceiro.controller;

import com.alexandre.controleFinanceiro.entity.Categoria;
import com.alexandre.controleFinanceiro.service.CategoriaService;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("controleFinanceiroApi/categorias")
@CrossOrigin("*")
public class CategoriaController{

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria){
        return categoriaService.criarCategoria(categoria);
    }

    @GetMapping
    public List<Categoria> listarCategorias(){
        return categoriaService.listarCategorias();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Categoria> listarPorUsuario(@PathVariable Long usuarioId){
        return categoriaService.listarPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.atualizarCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
    }
}
