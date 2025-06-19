package com.alexandre.controleFinanceiro.controller;

import com.alexandre.controleFinanceiro.entity.Lancamento;
import com.alexandre.controleFinanceiro.entity.TipoLancamento;
import com.alexandre.controleFinanceiro.service.LancamentoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("controleFinanceiroApi/lancamentos")
@CrossOrigin("*")
public class LancamentoController{

    private final LancamentoService lancamentoService;

    public LancamentoController(LancamentoService lancamentoService) {
        this.lancamentoService = lancamentoService;
    }

    @PostMapping
    public Lancamento criarLancamento(@RequestBody Lancamento lancamento){
        return lancamentoService.criarLancamento(lancamento);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Lancamento> listarPorUsuario(@PathVariable Long usuarioId){
        return lancamentoService.listarPorUsuario(usuarioId);
    }

    @GetMapping("/usuario/{usuarioId}/categoria/{categoriaId}")
    public List<Lancamento> listarPorCategoriaUsuario(@PathVariable Long usuarioId, @PathVariable Long categoriaId){
        return lancamentoService.listarPorCategoriaEUsuario(categoriaId, usuarioId);
    }

    @GetMapping("/usuario/{usuarioId}/periodo?inicio=2024-01-01&fim=2024-01-31")
    public List<Lancamento> listarPorPeriodo(@PathVariable Long usuarioId, @RequestParam LocalDate incio, @RequestParam LocalDate fim){
        return lancamentoService.listarPorPerido(usuarioId, incio, fim);
    }

    @GetMapping("/usuario/{usuarioId}/tipo/{tipo}")
    public List<Lancamento> listarPorTipo(@PathVariable Long usuarioId, @PathVariable TipoLancamento tipo){
        return lancamentoService.listarPorTipo(usuarioId, tipo);
    }

    @PutMapping("/{id}")
    public Lancamento atualizarLancamento(@PathVariable Long id, @RequestBody Lancamento lancamento){
        return lancamentoService.atualizarLancamento(id, lancamento);
    }

    @DeleteMapping("/{id}")
    public void deletarLancamento(@PathVariable Long id){
        lancamentoService.deletarLancamento(id);
    }
}
