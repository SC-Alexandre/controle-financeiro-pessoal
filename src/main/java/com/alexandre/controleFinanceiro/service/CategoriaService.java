package com.alexandre.controleFinanceiro.service;

import com.alexandre.controleFinanceiro.entity.Categoria;
import com.alexandre.controleFinanceiro.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria criarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarPorUsuario(Long usuarioId){
        return categoriaRepository.findByUsuarioId(usuarioId);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria atualizarCategoria(Long id, Categoria categoria){
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada pelo id: "+id);
        }
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Long id){
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada pelo id: "+id);
        }
        categoriaRepository.deleteById(id);
    }
}
