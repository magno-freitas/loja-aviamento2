package com.loja.lojaaviamento.controller;

import com.loja.lojaaviamento.Domain.Usuario;
import com.loja.lojaaviamento.model.MovimentacaoEstoque;
import com.loja.lojaaviamento.model.Produto;
import com.loja.lojaaviamento.service.MovimentacaoEstoqueService;
import com.loja.lojaaviamento.service.ProdutoService;
import com.loja.lojaaviamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private MovimentacaoEstoqueService movimentacaoService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public String gestaoEstoque(Model model) {
        model.addAttribute("produtos", produtoService.listarAtivos());
        model.addAttribute("produtosEstoqueBaixo", produtoService.listarComEstoqueBaixo());
        model.addAttribute("movimentacoes", movimentacaoService.listarTodas());
        return "estoque/gestao";
    }
    
    @GetMapping("/movimentar/{id}")
    public String movimentar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Produto> produto = produtoService.buscarPorId(id);
        if (produto.isPresent()) {
            model.addAttribute("produto", produto.get());
            model.addAttribute("dataAtual", LocalDate.now());
            return "estoque/movimentar";
        } else {
            redirectAttributes.addFlashAttribute("erro", "Produto não encontrado!");
            return "redirect:/estoque";
        }
    }
    
    @PostMapping("/movimentar")
    public String processarMovimentacao(@RequestParam Long produtoId,
                                      @RequestParam String tipo,
                                      @RequestParam Integer quantidade,
                                      @RequestParam(required = false) String observacao,
                                      Authentication authentication,
                                      RedirectAttributes redirectAttributes) {
        try {
            Optional<Produto> produtoOpt = produtoService.buscarPorId(produtoId);
            if (!produtoOpt.isPresent()) {
                redirectAttributes.addFlashAttribute("erro", "Produto não encontrado!");
                return "redirect:/estoque";
            }
            
            Produto produto = produtoOpt.get();
            Usuario usuario = usuarioService.buscarPorEmail(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            
            MovimentacaoEstoque.TipoMovimentacao tipoMovimentacao = 
                MovimentacaoEstoque.TipoMovimentacao.valueOf(tipo.toUpperCase());
            
            movimentacaoService.registrarMovimentacao(produto, tipoMovimentacao, quantidade, observacao, usuario);
            
            // Verificar se estoque ficou baixo após saída
            if (tipoMovimentacao == MovimentacaoEstoque.TipoMovimentacao.SAIDA && 
                movimentacaoService.verificarEstoqueBaixo(produto)) {
                redirectAttributes.addFlashAttribute("alerta", 
                    "ATENÇÃO: Produto '" + produto.getNome() + "' está com estoque baixo! " +
                    "Quantidade atual: " + produto.getQuantidadeEstoque() + 
                    " (Mínimo: " + produto.getEstoqueMinimo() + ")");
            } else {
                redirectAttributes.addFlashAttribute("sucesso", "Movimentação registrada com sucesso!");
            }
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao registrar movimentação: " + e.getMessage());
        }
        
        return "redirect:/estoque";
    }
    
    @GetMapping("/historico/{id}")
    public String historico(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Produto> produto = produtoService.buscarPorId(id);
        if (produto.isPresent()) {
            model.addAttribute("produto", produto.get());
            model.addAttribute("movimentacoes", movimentacaoService.listarPorProduto(produto.get()));
            return "estoque/historico";
        } else {
            redirectAttributes.addFlashAttribute("erro", "Produto não encontrado!");
            return "redirect:/estoque";
        }
    }
}