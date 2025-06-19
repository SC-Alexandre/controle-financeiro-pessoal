package com.alexandre.controleFinanceiro.repository;

import com.alexandre.controleFinanceiro.entity.Lancamento;
import com.alexandre.controleFinanceiro.entity.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

    List<Lancamento> findByUsuarioIdOrderByDataDesc(Long usuarioId);
    List<Lancamento> findByCategoriaIdAndUsuarioId(Long categoriaId, Long usuarioId);
    List<Lancamento> findByUsuarioIdAndDataBetween(Long usuarioId, LocalDate dataInicio, LocalDate dataFim);
    List<Lancamento> findByUsuarioIdAndTipo(Long usuarioId, TipoLancamento tipo);
}