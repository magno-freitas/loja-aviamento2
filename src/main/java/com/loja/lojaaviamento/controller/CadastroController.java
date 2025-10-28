package com.loja.lojaaviamento.controller;

import com.loja.lojaaviamento.Domain.Usuario;
import com.loja.lojaaviamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/cadastro")
    public String cadastroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setRole("user");
        usuarioService.save(usuario);
        return "redirect:/login?cadastro";
    }
}