package com.loja.lojaaviamento.repository;

import com.loja.lojaaviamento.model.MovimentacaoEstoque;
import com.loja.lojaaviamento.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {
    
    List<MovimentacaoEstoque> findByProdutoOrderByDataMovimentacaoDesc(Produto produto);
    
    List<MovimentacaoEstoque> findAllByOrderByDataMovimentacaoDesc();
    
    @Query("SELECT m FROM MovimentacaoEstoque m WHERE m.dataMovimentacao BETWEEN :inicio AND :fim ORDER BY m.dataMovimentacao DESC")
    List<MovimentacaoEstoque> findByPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);
}