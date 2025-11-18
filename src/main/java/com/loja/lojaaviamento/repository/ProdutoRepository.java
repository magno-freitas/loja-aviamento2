package com.loja.lojaaviamento.repository;

import com.loja.lojaaviamento.model.Produto;
import com.loja.lojaaviamento.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR LOWER(p.descricao) LIKE LOWER(CONCAT('%', :termo, '%'))")
    List<Produto> buscarPorNomeOuDescricao(@Param("termo") String termo);
    
    List<Produto> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
    
    List<Produto> findByAtivoTrueOrderByNomeAsc();
    
    List<Produto> findByCategoriaOrderByNomeAsc(Categoria categoria);
    
    @Query("SELECT p FROM Produto p WHERE p.quantidadeEstoque <= p.estoqueMinimo AND p.ativo = true")
    List<Produto> findProdutosComEstoqueBaixo();
    
    List<Produto> findAllByOrderByNomeAsc();
}