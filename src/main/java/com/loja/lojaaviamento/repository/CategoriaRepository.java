package com.loja.lojaaviamento.repository;

import com.loja.lojaaviamento.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    @Query("SELECT c FROM Categoria c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :termo, '%'))")
    List<Categoria> buscarPorNome(@Param("termo") String termo);
    
    List<Categoria> findByNomeContainingIgnoreCase(String nome);
}