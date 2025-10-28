package com.loja.lojaaviamento.config;

import com.loja.lojaaviamento.Domain.Usuario;
import com.loja.lojaaviamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findByEmail("admin@admin.com").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNome("Administrador");
            admin.setEmail("admin@admin.com");
            admin.setSenha(passwordEncoder.encode("admin123"));
            admin.setRole("admin");
            usuarioRepository.save(admin);
            System.out.println("Admin criado: admin@admin.com / admin123");
        }
    }
}