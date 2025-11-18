package com.loja.lojaaviamento.service;

import com.loja.lojaaviamento.model.Categoria;
import com.loja.lojaaviamento.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;
    
    public List<Categoria> listarTodas() {
        return repository.findAll();
    }
    
    public Optional<Categoria> buscarPorId(Long id) {
        return repository.findById(id);
    }
    
    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }
    
    public void excluir(Long id) {
        repository.deleteById(id);
    }
    
    public List<Categoria> buscarPorNome(String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            return listarTodas();
        }
        return repository.buscarPorNome(termo.trim());
    }
}