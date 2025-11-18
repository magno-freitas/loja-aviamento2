package com.loja.lojaaviamento.controller;

import com.loja.lojaaviamento.model.Produto;
import com.loja.lojaaviamento.service.ProdutoService;
import com.loja.lojaaviamento.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        if (busca != null && !busca.trim().isEmpty()) {
            model.addAttribute("produtos", produtoService.buscarPorTermo(busca));
            model.addAttribute("busca", busca);
        } else {
            model.addAttribute("produtos", produtoService.listarAtivos());
        }
        return "produtos/lista";
    }
    
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "produtos/form";
    }
    
    @PostMapping
    public String salvar(@Valid @ModelAttribute Produto produto, BindingResult result, 
                        Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaService.listarTodas());
            return "produtos/form";
        }
        
        try {
            produtoService.salvar(produto);
            redirectAttributes.addFlashAttribute("sucesso", "Produto salvo com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar produto: " + e.getMessage());
        }
        
        return "redirect:/produtos";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return produtoService.buscarPorId(id)
            .map(produto -> {
                model.addAttribute("produto", produto);
                model.addAttribute("categorias", categoriaService.listarTodas());
                return "produtos/form";
            })
            .orElseGet(() -> {
                redirectAttributes.addFlashAttribute("erro", "Produto não encontrado!");
                return "redirect:/produtos";
            });
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            produtoService.excluir(id);
            redirectAttributes.addFlashAttribute("sucesso", "Produto excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao excluir produto: " + e.getMessage());
        }
        return "redirect:/produtos";
    }
}