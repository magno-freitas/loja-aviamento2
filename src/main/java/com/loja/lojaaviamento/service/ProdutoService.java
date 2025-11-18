package com.loja.lojaaviamento.service;

import com.loja.lojaaviamento.model.Produto;
import com.loja.lojaaviamento.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;
    
    public List<Produto> listarTodos() {
        return repository.findAllByOrderByNomeAsc();
    }
    
    public List<Produto> listarAtivos() {
        return repository.findByAtivoTrueOrderByNomeAsc();
    }
    
    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }
    
    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }
    
    public void excluir(Long id) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isPresent()) {
            produto.get().setAtivo(false);
            repository.save(produto.get());
        }
    }
    
    public List<Produto> buscarPorTermo(String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            return listarAtivos();
        }
        return repository.buscarPorNomeOuDescricao(termo.trim());
    }
    
    public List<Produto> listarComEstoqueBaixo() {
        return repository.findProdutosComEstoqueBaixo();
    }
    
    public void atualizarEstoque(Long produtoId, Integer novaQuantidade) {
        Optional<Produto> produto = repository.findById(produtoId);
        if (produto.isPresent()) {
            produto.get().setQuantidadeEstoque(novaQuantidade);
            repository.save(produto.get());
        }
    }
}