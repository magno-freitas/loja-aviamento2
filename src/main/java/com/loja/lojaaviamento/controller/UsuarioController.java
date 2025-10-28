package com.loja.lojaaviamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.loja.lojaaviamento.Domain.Usuario;
import com.loja.lojaaviamento.service.UsuarioService;

@Controller
public class UsuarioController {

    private final UsuarioService service;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", service.listAll());
        return "list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "form";
    }

    @PostMapping("/usuario")
    public String salvar(@ModelAttribute("usuario") Usuario usuario) {
        if (usuario.getId() != null) {
            // Editando usuário existente
            Usuario usuarioExistente = service.findById(usuario.getId()).orElse(null);
            if (usuarioExistente != null) {
                usuarioExistente.setNome(usuario.getNome());
                usuarioExistente.setEmail(usuario.getEmail());
                usuarioExistente.setRole(usuario.getRole());
                // Só atualiza senha se foi fornecida uma nova
                if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
                    usuarioExistente.setSenha(passwordEncoder.encode(usuario.getSenha()));
                }
                service.save(usuarioExistente);
            }
        } else {
            // Criando novo usuário
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            service.save(usuario);
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Usuario usuario = service.findById(id).orElse(new Usuario());
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/usuarios";
    }
}