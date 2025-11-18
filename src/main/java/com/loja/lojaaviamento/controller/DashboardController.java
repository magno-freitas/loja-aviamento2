package com.loja.lojaaviamento.controller;

import com.loja.lojaaviamento.service.ProdutoService;
import com.loja.lojaaviamento.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private MovimentacaoEstoqueService movimentacaoService;
    
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        model.addAttribute("nomeUsuario", authentication.getName());
        model.addAttribute("totalProdutos", produtoService.listarAtivos().size());
        model.addAttribute("produtosEstoqueBaixo", produtoService.listarComEstoqueBaixo());
        model.addAttribute("ultimasMovimentacoes", movimentacaoService.listarTodas().stream().limit(5).toList());
        return "dashboard";
    }
    
    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }
}