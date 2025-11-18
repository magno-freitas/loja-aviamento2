package com.loja.lojaaviamento.service;

import com.loja.lojaaviamento.model.MovimentacaoEstoque;
import com.loja.lojaaviamento.model.Produto;
import com.loja.lojaaviamento.Domain.Usuario;
import com.loja.lojaaviamento.repository.MovimentacaoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MovimentacaoEstoqueService {
    
    @Autowired
    private MovimentacaoEstoqueRepository repository;
    
    @Autowired
    private ProdutoService produtoService;
    
    public List<MovimentacaoEstoque> listarTodas() {
        return repository.findAllByOrderByDataMovimentacaoDesc();
    }
    
    public List<MovimentacaoEstoque> listarPorProduto(Produto produto) {
        return repository.findByProdutoOrderByDataMovimentacaoDesc(produto);
    }
    
    @Transactional
    public MovimentacaoEstoque registrarMovimentacao(Produto produto, MovimentacaoEstoque.TipoMovimentacao tipo, 
                                                   Integer quantidade, String observacao, Usuario usuario) {
        
        // Criar movimentação
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        movimentacao.setProduto(produto);
        movimentacao.setTipo(tipo);
        movimentacao.setQuantidade(quantidade);
        movimentacao.setObservacao(observacao);
        movimentacao.setUsuario(usuario);
        
        // Atualizar estoque do produto
        Integer estoqueAtual = produto.getQuantidadeEstoque();
        Integer novoEstoque;
        
        if (tipo == MovimentacaoEstoque.TipoMovimentacao.ENTRADA) {
            novoEstoque = estoqueAtual + quantidade;
        } else {
            novoEstoque = estoqueAtual - quantidade;
            if (novoEstoque < 0) {
                throw new RuntimeException("Estoque insuficiente! Estoque atual: " + estoqueAtual);
            }
        }
        
        produto.setQuantidadeEstoque(novoEstoque);
        produtoService.salvar(produto);
        
        return repository.save(movimentacao);
    }
    
    public boolean verificarEstoqueBaixo(Produto produto) {
        return produto.getQuantidadeEstoque() <= produto.getEstoqueMinimo();
    }
}