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
        // Criar usuário admin
        if (usuarioRepository.findByEmail("admin@admin.com").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNome("Administrador");
            admin.setEmail("admin@admin.com");
            admin.setSenha(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");
            usuarioRepository.save(admin);
            System.out.println("Admin criado: admin@admin.com / admin123");
        }
        
        // Criar usuário comum
        if (usuarioRepository.findByEmail("user@user.com").isEmpty()) {
            Usuario user = new Usuario();
            user.setNome("Usuário Comum");
            user.setEmail("user@user.com");
            user.setSenha(passwordEncoder.encode("user123"));
            user.setRole("USER");
            usuarioRepository.save(user);
            System.out.println("Usuário criado: user@user.com / user123");
        }
    }
}