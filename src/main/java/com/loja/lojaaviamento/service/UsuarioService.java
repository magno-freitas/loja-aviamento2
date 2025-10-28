package com.loja.lojaaviamento.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.loja.lojaaviamento.Domain.Usuario;
import com.loja.lojaaviamento.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> listAll() {
        return repo.findAll();
    }

    public void save(Usuario usuario) {
        repo.save(usuario);
    }

    public Optional<Usuario> findById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}