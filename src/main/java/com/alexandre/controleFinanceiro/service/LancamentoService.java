package com.alexandre.controleFinanceiro.service;

import com.alexandre.controleFinanceiro.entity.Lancamento;
import com.alexandre.controleFinanceiro.entity.TipoLancamento;
import com.alexandre.controleFinanceiro.repository.LancamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;

    public LancamentoService(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento criarLancamento(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> listarPorUsuario(Long usuarioId){
        return lancamentoRepository.findByUsuarioIdOrderByDataDesc(usuarioId);
    }

    public List<Lancamento> listarPorCategoriaEUsuario(Long categoriaId, Long usuarioId){
        return lancamentoRepository.findByCategoriaIdAndUsuarioId(categoriaId, usuarioId);
    }

    public List<Lancamento> listarPorPerido(Long usuarioId, LocalDate inicio, LocalDate fim){
        return lancamentoRepository.findByUsuarioIdAndDataBetween(usuarioId, inicio, fim);
    }

    public List<Lancamento> listarPorTipo(Long usuarioId, TipoLancamento tipo){
        return lancamentoRepository.findByUsuarioIdAndTipo(usuarioId, tipo);
    }

    public Lancamento atualizarLancamento(Long id, Lancamento lancamento){
        if(!lancamentoRepository.existsById(id)){
            throw new RuntimeException("Lancamento não encontrado por id: "+id);
        }
        lancamento.setId(id);
        return lancamentoRepository.save(lancamento);
    }

    public void deletarLancamento(Long id){
        if(!lancamentoRepository.existsById(id)){
            throw new RuntimeException("Lancamento não encontrado por id: "+id);
        }
        lancamentoRepository.deleteById(id);
    }
}
