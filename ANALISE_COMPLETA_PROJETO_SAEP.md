# 📚 ANÁLISE COMPLETA DO PROJETO SAEP 2025 - GUIA DE ESTUDOS

## 🎯 VISÃO GERAL DO PROJETO

Este é um **Sistema de Controle de Estoque** desenvolvido em **Spring Boot** para a prova SAEP 2025. O projeto implementa um sistema completo de gerenciamento de produtos, tipos, usuários e movimentações de estoque com autenticação e interface web.

### 🏗️ ARQUITETURA DO PROJETO
- **Framework**: Spring Boot 3.5.7
- **Linguagem**: Java 17
- **Banco de Dados**: MySQL
- **Frontend**: Thymeleaf + Bootstrap 5
- **Segurança**: Spring Security
- **Padrão**: MVC (Model-View-Controller)

---

## 📁 ESTRUTURA DE PASTAS E ARQUIVOS

```
saep_db1/
├── src/main/java/com/saep2025/saep_db1/
│   ├── config/          # Configurações do sistema
│   ├── controller/      # Controladores (recebem requisições)
│   ├── model/          # Entidades do banco de dados
│   ├── repository/     # Acesso aos dados (CRUD)
│   ├── service/        # Regras de negócio
│   └── util/           # Utilitários
├── src/main/resources/
│   ├── templates/      # Páginas HTML (Thymeleaf)
│   ├── static/         # CSS, JS, imagens
│   ├── application.properties  # Configurações da aplicação
│   ├── schema.sql      # Estrutura do banco
│   └── data.sql        # Dados iniciais
└── pom.xml            # Dependências Maven
```

---

## 🔧 ANÁLISE DETALHADA DOS ARQUIVOS

### 1. 📄 **pom.xml** - Configuração de Dependências

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- Declaração XML padrão com codificação UTF-8 -->

<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!-- Definição do namespace Maven para gerenciamento de dependências -->
    
    <modelVersion>4.0.0</modelVersion>
    <!-- Versão do modelo POM utilizada -->

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.7</version>
        <relativePath />
        <!-- Herda configurações do Spring Boot Parent para facilitar o desenvolvimento -->
    </parent>

    <groupId>com.saep2025.saep_db1</groupId>
    <!-- Identificador único do grupo/organização do projeto -->
    
    <artifactId>saep_db1</artifactId>
    <!-- Nome do artefato/projeto -->
    
    <version>1.0.0</version>
    <!-- Versão atual do projeto -->
    
    <name>saep_db1</name>
    <!-- Nome amigável do projeto -->
    
    <description>Projeto SAEP 2025 - Spring Boot + MySQL + Thymeleaf + Security</description>
    <!-- Descrição detalhada do que o projeto faz -->

    <properties>
        <java.version>17</java.version>
        <!-- Define que o projeto usa Java 17 -->
    </properties>

    <dependencies>
        <!-- Lista de bibliotecas que o projeto precisa para funcionar -->
        
        <!-- Web: Permite criar aplicações web com Spring MVC -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Thymeleaf: Motor de templates para criar páginas HTML dinâmicas -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <!-- JPA: Para trabalhar com banco de dados usando ORM -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <!-- MySQL: Driver para conectar com banco MySQL -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
        </dependency>

        <!-- Security: Sistema de autenticação e autorização -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <!-- Lombok: Gera automaticamente getters, setters, construtores -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- DevTools: Reinicia automaticamente a aplicação durante desenvolvimento -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <!-- Bootstrap: Framework CSS para interface bonita -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>5.3.3</version>
        </dependency>

        <!-- WebJars Locator: Resolve automaticamente caminhos dos arquivos CSS/JS -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>webjars-locator-core</artifactId>
        </dependency>
    </dependencies>
</project>
```

### 2. ⚙️ **application.properties** - Configurações da Aplicação

```properties
# Nome da aplicação Spring Boot
spring.application.name=saep_db1

# CONFIGURAÇÕES DO BANCO DE DADOS MYSQL
# URL de conexão: localhost na porta 3306, banco saep_db1
# createDatabaseIfNotExist=true: cria o banco automaticamente se não existir
# useSSL=false: desabilita SSL para desenvolvimento local
# serverTimezone=UTC: define fuso horário UTC
spring.datasource.url=jdbc:mysql://localhost:3306/saep_db1?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC

# Usuário do MySQL (padrão: root)
spring.datasource.username=root

# Senha do MySQL (vazia por padrão no XAMPP/WAMP)
spring.datasource.password=

# Driver JDBC do MySQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# CONFIGURAÇÕES DO HIBERNATE (ORM)
# create: apaga e recria as tabelas a cada inicialização
spring.jpa.hibernate.ddl-auto=create

# Mostra os comandos SQL no console (útil para debug)
spring.jpa.show-sql=true

# Formata o SQL de forma legível
spring.jpa.properties.hibernate.format_sql=true

# Executa sempre os scripts SQL (schema.sql e data.sql)
spring.sql.init.mode=always

# Permite que o Hibernate crie as tabelas antes de executar data.sql
spring.jpa.defer-datasource-initialization=true

# Desabilita cache do Thymeleaf (páginas são recarregadas automaticamente)
spring.thymeleaf.cache=false
```

### 3. 🚀 **SaepDb1Application.java** - Classe Principal

```java
package com.saep2025.saep_db1;
// Define o pacote onde a classe está localizada

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importa as classes necessárias do Spring Boot

@SpringBootApplication
// Anotação que marca esta como classe principal do Spring Boot
// Combina @Configuration, @EnableAutoConfiguration e @ComponentScan
public class SaepDb1Application {

    public static void main(String[] args) {
        // Método principal que inicia a aplicação
        SpringApplication.run(SaepDb1Application.class, args);
        // Executa a aplicação Spring Boot passando a classe principal e argumentos
    }
}
```

---

## 🗃️ MODELOS (ENTIDADES DO BANCO)

### 4. 👤 **Usuario.java** - Entidade Usuário

```java
package com.saep2025.saep_db1.model;
// Pacote onde estão as entidades do banco

import jakarta.persistence.*;
// Importa anotações JPA para mapeamento objeto-relacional

import lombok.Getter;
import lombok.Setter;
// Importa anotações Lombok para gerar getters e setters automaticamente

@Entity
// Marca esta classe como uma entidade JPA (tabela no banco)
@Getter
// Lombok gera automaticamente todos os métodos getter
@Setter
// Lombok gera automaticamente todos os métodos setter
public class Usuario {

    @Id
    // Marca este campo como chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Gera automaticamente o valor do ID (auto_increment no MySQL)
    private Long id;
    // Campo ID único para cada usuário

    private String nome;
    // Campo para armazenar o nome do usuário

    @Column(unique = true)
    // Garante que o email seja único no banco (não pode repetir)
    private String email;
    // Campo para email (usado como login)

    private String senha;
    // Campo para senha criptografada
}
```

### 5. 🏷️ **Tipo.java** - Entidade Tipo de Produto

```java
package com.saep2025.saep_db1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
// Lombok gera construtor sem parâmetros
@AllArgsConstructor
// Lombok gera construtor com todos os parâmetros
@Data
// Lombok gera getters, setters, toString, equals e hashCode
@Entity
// Marca como entidade JPA
public class Tipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ID único do tipo
    
    private String descricao;
    // Descrição do tipo (ex: "Corante", "Alvejante")
}
```

### 6. 📦 **Produto.java** - Entidade Produto

```java
package com.saep2025.saep_db1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
// BigDecimal é usado para valores monetários/decimais precisos

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ID único do produto

    private String descproduto;
    // Descrição/nome do produto

    @ManyToOne
    // Relacionamento muitos-para-um: muitos produtos podem ter o mesmo tipo
    @JoinColumn(name = "idtipo")
    // Define que a coluna "idtipo" faz referência à tabela tipo
    private Tipo tipo;
    // Referência ao tipo do produto

    private String unidmedida;
    // Unidade de medida (kg, L, un, etc.)
    
    private BigDecimal estoqueminimo;
    // Quantidade mínima que deve ter em estoque
    
    private BigDecimal estoqueatual;
    // Quantidade atual em estoque
}
```

### 7. 📊 **Movimento.java** - Entidade Movimentação

```java
package com.saep2025.saep_db1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtransacao;
    // ID único da transação

    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;
    // Produto que foi movimentado

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    // Usuário que fez a movimentação

    private char tipomovto;
    // Tipo: 'E' = Entrada, 'S' = Saída

    private BigDecimal qtdmovto;
    // Quantidade movimentada

    private LocalDateTime datahoramovto = LocalDateTime.now();
    // Data e hora da movimentação (padrão: agora)
}
```

---

## 🗄️ REPOSITÓRIOS (ACESSO AOS DADOS)

### 8. 👥 **UsuarioRepository.java**

```java
package com.saep2025.saep_db1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// Interface que fornece métodos CRUD prontos

import com.saep2025.saep_db1.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Herda métodos como save(), findAll(), findById(), delete()
    // <Usuario, Long> = Entidade Usuario com ID do tipo Long
    
    Optional<Usuario> findByEmail(String email);
    // Método customizado: busca usuário pelo email
    // Optional evita NullPointerException se não encontrar
}
```

### 9. 📦 **ProdutoRepository.java**

```java
package com.saep2025.saep_db1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saep2025.saep_db1.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Interface simples que herda todos os métodos CRUD básicos
    // Não precisa de métodos customizados para este projeto
}
```

### 10. 🏷️ **TipoRepository.java**

```java
package com.saep2025.saep_db1.repository;

import com.saep2025.saep_db1.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
    // Interface básica para operações CRUD com tipos
}
```

### 11. 📊 **MovimentoRepository.java**

```java
package com.saep2025.saep_db1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saep2025.saep_db1.model.Movimento;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
    // Interface básica para movimentações
}
```

---

## 🔧 SERVIÇOS (REGRAS DE NEGÓCIO)

### 12. 🔐 **UsuarioService.java** - Autenticação

```java
package com.saep2025.saep_db1.service;

import com.saep2025.saep_db1.model.Usuario;
import com.saep2025.saep_db1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
// Marca como serviço do Spring (componente de negócio)
public class UsuarioService implements UserDetailsService {
    // Implementa interface do Spring Security para autenticação

    @Autowired
    // Injeta automaticamente o repositório
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Método obrigatório do UserDetailsService
        // É chamado quando alguém tenta fazer login
        
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));
        // Busca usuário pelo email, lança exceção se não encontrar

        return User.builder()
                .username(usuario.getEmail())    // Define email como username
                .password(usuario.getSenha())    // Senha criptografada
                .roles("USER")                   // Perfil padrão: USER
                .build();
        // Constrói objeto UserDetails que o Spring Security entende
    }
}
```

---

## ⚙️ CONFIGURAÇÕES

### 13. 🔒 **SecurityConfig.java** - Configuração de Segurança

```java
package com.saep2025.saep_db1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
// Marca como classe de configuração do Spring
public class SecurityConfig {

    @Bean
    // Cria um bean gerenciado pelo Spring
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Define quais URLs podem ser acessadas sem login
                .requestMatchers("/login", "/css/**", "/js/**", "/img/**", "/admin/gerarsenha").permitAll()
                // Todas as outras URLs exigem autenticação
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/login")                    // Página de login customizada
                .defaultSuccessUrl("/principal", true)  // Redireciona após login bem-sucedido
                .permitAll()                           // Permite acesso à página de login
            )
            .logout(logout -> logout
                .logoutUrl("/logout")                          // URL para fazer logout
                .logoutSuccessUrl("/login?logout=true")        // Redireciona após logout
                .permitAll()                                   // Permite logout para todos
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // Configura BCrypt para criptografar senhas
        // BCrypt é um algoritmo seguro que adiciona "salt" às senhas
    }
}
```

### 14. 🗄️ **DatabaseInitializer.java** - Inicializador do Banco

```java
package com.saep2025.saep_db1.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
// Marca como componente do Spring (será executado automaticamente)
public class DatabaseInitializer implements CommandLineRunner {
    // CommandLineRunner executa código após a aplicação iniciar

    @Override
    public void run(String... args) throws Exception {
        // Método executado automaticamente na inicialização
        
        System.out.println("==============================================");
        System.out.println(" 🚀 SAEP 2025 - Banco de Dados Inicializado com sucesso!");
        System.out.println(" ✅ Tabelas criadas e dados carregados via schema.sql e data.sql");
        System.out.println(" 💾 Pronto para uso no ambiente MySQL local (saep_db1)");
        System.out.println("==============================================");
        // Exibe mensagens informativas no console
    }
}
```

### 15. 🔍 **DataVerifier.java** - Verificador de Dados

```java
package com.saep2025.saep_db1.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.saep2025.saep_db1.model.Tipo;
import com.saep2025.saep_db1.model.Usuario;
import com.saep2025.saep_db1.repository.TipoRepository;
import com.saep2025.saep_db1.repository.UsuarioRepository;

@Component
public class DataVerifier implements CommandLineRunner {
    // Verifica e cria dados iniciais se necessário

    private final UsuarioRepository usuarioRepository;
    private final TipoRepository tipoRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public DataVerifier(UsuarioRepository usuarioRepository, TipoRepository tipoRepository) {
        // Construtor que recebe os repositórios por injeção de dependência
        this.usuarioRepository = usuarioRepository;
        this.tipoRepository = tipoRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("==============================================");
        System.out.println("🔍 Verificando dados iniciais do SAEP 2025...");

        // 1️⃣ Verifica se existe usuário administrador
        if (usuarioRepository.count() == 0) {
            // Se não há usuários, cria o administrador padrão
            Usuario admin = new Usuario();
            admin.setNome("Administrador");
            admin.setEmail("admin@saep.com");
            admin.setSenha(passwordEncoder.encode("admin"));  // Criptografa a senha
            usuarioRepository.save(admin);
            System.out.println("✅ Usuário padrão criado: admin@saep.com (senha: admin)");
        } else {
            System.out.println("ℹ️ Usuário(s) já cadastrado(s). Nenhuma ação necessária.");
        }

        // 2️⃣ Verifica se existem tipos
        if (tipoRepository.count() == 0) {
            // Se não há tipos, cria os tipos padrão
            List<Tipo> tipos = new ArrayList<>();

            Tipo t1 = new Tipo();
            t1.setDescricao("Corante");
            Tipo t2 = new Tipo();
            t2.setDescricao("Alvejante");
            Tipo t3 = new Tipo();
            t3.setDescricao("Auxiliar");
            Tipo t4 = new Tipo();
            t4.setDescricao("Não definido");

            tipos.addAll(Arrays.asList(t1, t2, t3, t4));
            tipoRepository.saveAll(tipos);  // Salva todos os tipos de uma vez

            System.out.println("✅ Tipos padrões criados: Corante, Alvejante, Auxiliar, Não definido");
        } else {
            System.out.println("ℹ️ Tipos já existentes. Nenhuma ação necessária.");
        }

        System.out.println("==============================================");
        System.out.println("🚀 Banco de dados SAEP 2025 pronto para uso!");
        System.out.println("==============================================");
    }
}
```

---

## 🎮 CONTROLADORES (RECEBEM REQUISIÇÕES)

### 16. 🔐 **LoginController.java** - Controle de Login

```java
package com.saep2025.saep_db1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// Marca como controlador MVC (recebe requisições HTTP)
public class LoginController {

    @GetMapping("/login")
    // Mapeia requisições GET para /login
    public String login() {
        return "login";
        // Retorna o nome do template (login.html)
        // Spring Boot procura em src/main/resources/templates/
    }

    @GetMapping("/principal")
    // Mapeia requisições GET para /principal
    public String principal() {
        return "principal";
        // Retorna template principal.html (página inicial após login)
    }
}
```

### 17. 🏠 **PrincipalController.java** - Página Inicial

```java
package com.saep2025.saep_db1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

    @GetMapping("/")
    // Mapeia a raiz do site (/)
    public String redirecionarParaPrincipal() {
        return "redirect:/inicio";
        // Redireciona para /inicio
    }

    @GetMapping("/inicio")
    // Página principal do sistema
    public String principal(Model model) {
        // Model permite passar dados para o template
        model.addAttribute("tituloPagina", "Página Inicial - SAEP 2025");
        // Adiciona atributo que pode ser usado no HTML
        return "principal";
        // Carrega template principal.html
    }

    @GetMapping("/teste")
    // Página de teste do layout
    public String testeLayout() {
        return "teste";
    }
}
```

### 18. 👤 **UsuarioController.java** - CRUD de Usuários

```java
package com.saep2025.saep_db1.controller;

import com.saep2025.saep_db1.model.Usuario;
import com.saep2025.saep_db1.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
// Todas as URLs deste controller começam com /usuarios
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        // Injeção de dependência via construtor (recomendado)
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    // GET /usuarios - Lista todos os usuários
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        // Busca todos os usuários e passa para o template
        return "usuario/lista";
        // Retorna template usuario/lista.html
    }

    @GetMapping("/novo")
    // GET /usuarios/novo - Formulário para novo usuário
    public String novo(Model model) {
        model.addAttribute("usuario", new Usuario());
        // Cria objeto vazio para o formulário
        return "usuario/form";
        // Retorna template usuario/form.html
    }

    @PostMapping("/salvar")
    // POST /usuarios/salvar - Salva usuário (novo ou editado)
    public String salvar(@ModelAttribute Usuario usuario) {
        // @ModelAttribute pega dados do formulário e cria objeto Usuario
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        // Criptografa a senha antes de salvar
        usuarioRepository.save(usuario);
        // Salva no banco de dados
        return "redirect:/usuarios";
        // Redireciona para lista de usuários
    }

    @GetMapping("/editar/{id}")
    // GET /usuarios/editar/123 - Formulário para editar usuário
    public String editar(@PathVariable Long id, Model model) {
        // @PathVariable pega o {id} da URL
        model.addAttribute("usuario", usuarioRepository.findById(id).orElse(new Usuario()));
        // Busca usuário pelo ID, se não encontrar cria novo
        return "usuario/form";
        // Usa o mesmo formulário (form.html detecta se é novo ou edição)
    }

    @GetMapping("/excluir/{id}")
    // GET /usuarios/excluir/123 - Exclui usuário
    public String excluir(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        // Remove usuário do banco
        return "redirect:/usuarios";
        // Volta para lista
    }
}
```

### 19. 🏷️ **TipoController.java** - CRUD de Tipos

```java
package com.saep2025.saep_db1.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.saep2025.saep_db1.model.Tipo;
import com.saep2025.saep_db1.repository.TipoRepository;

@Controller
@RequestMapping("/tipos")
public class TipoController {

    private final TipoRepository tipoRepository;

    public TipoController(TipoRepository tipoRepository) {
        // Injeção via construtor
        this.tipoRepository = tipoRepository;
    }

    @GetMapping
    // GET /tipos - Lista todos os tipos
    public String listar(Model model) {
        List<Tipo> tipos = tipoRepository.findAll();
        model.addAttribute("tipos", tipos);
        model.addAttribute("tituloPagina", "Lista de Tipos");
        model.addAttribute("ativo", "tipos");  // Para destacar menu ativo
        return "tipo/lista";
    }

    @GetMapping("/novo")
    // GET /tipos/novo - Formulário novo tipo
    public String novo(Model model) {
        model.addAttribute("tipo", new Tipo());
        model.addAttribute("tituloPagina", "Novo Tipo de Produto");
        return "tipo/form";
    }

    @PostMapping("/salvar")
    // POST /tipos/salvar - Salva tipo
    public String salvar(@ModelAttribute Tipo tipo) {
        tipoRepository.save(tipo);
        return "redirect:/tipos";
    }

    @GetMapping("/editar/{id}")
    // GET /tipos/editar/123 - Edita tipo
    public String editar(@PathVariable Long id, Model model) {
        Tipo tipo = tipoRepository.findById(id).orElse(new Tipo());
        model.addAttribute("tipo", tipo);
        model.addAttribute("tituloPagina", "Editar Tipo");
        return "tipo/form";
    }

    @GetMapping("/excluir/{id}")
    // GET /tipos/excluir/123 - Exclui tipo
    public String excluir(@PathVariable Long id) {
        tipoRepository.deleteById(id);
        return "redirect:/tipos";
    }
}
```

### 20. 📦 **ProdutoController.java** - CRUD de Produtos

```java
package com.saep2025.saep_db1.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.saep2025.saep_db1.model.Produto;
import com.saep2025.saep_db1.model.Tipo;
import com.saep2025.saep_db1.repository.ProdutoRepository;
import com.saep2025.saep_db1.repository.TipoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final TipoRepository tipoRepository;

    public ProdutoController(ProdutoRepository produtoRepository, TipoRepository tipoRepository) {
        // Injeção via construtor (recomendada pelo Sonar)
        this.produtoRepository = produtoRepository;
        this.tipoRepository = tipoRepository;
    }

    @GetMapping
    // GET /produtos - Lista produtos com alerta de estoque crítico
    public String listar(Model model) {
        List<Produto> produtos = produtoRepository.findAll();

        // Conta produtos com estoque crítico (atual <= mínimo)
        long produtosCriticos = produtos.stream()
                .filter(p -> p.getEstoqueatual() != null && p.getEstoqueminimo() != null)
                .filter(p -> p.getEstoqueatual().compareTo(p.getEstoqueminimo()) <= 0)
                .count();

        model.addAttribute("produtos", produtos);
        model.addAttribute("produtosCriticos", produtosCriticos);
        model.addAttribute("ativo", "produtos");
        return "produto/lista";
    }

    @PostMapping("/salvar")
    // POST /produtos/salvar - Salva produto
    public String salvar(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/novo")
    // GET /produtos/novo - Formulário novo produto
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("tipos", tipoRepository.findAll());  // Para o select
        return "produto/form";
    }

    @GetMapping("/editar/{id}")
    // GET /produtos/editar/123 - Edita produto
    public String editar(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Produto inválido: " + id));

        // Evita NullPointerException no select de tipos
        if (produto.getTipo() == null) {
            produto.setTipo(new Tipo());
        }

        model.addAttribute("produto", produto);
        model.addAttribute("tipos", tipoRepository.findAll());
        return "produto/form";
    }

    @GetMapping("/excluir/{id}")
    // GET /produtos/excluir/123 - Exclui produto com tratamento de erro
    public String excluir(@PathVariable Long id, RedirectAttributes redirect) {
        try {
            produtoRepository.deleteById(id);
            redirect.addFlashAttribute("mensagemSucesso", "Produto excluído com sucesso!");
        } catch (Exception e) {
            // Se há movimentações vinculadas, não pode excluir
            redirect.addFlashAttribute("mensagemErro", 
                "Não foi possível excluir: o produto está vinculado a outros registros.");
        }
        return "redirect:/produtos";
    }
}
```

### 21. 📊 **MovimentoController.java** - CRUD de Movimentações

```java
package com.saep2025.saep_db1.controller;

import com.saep2025.saep_db1.model.Movimento;
import com.saep2025.saep_db1.model.Produto;
import com.saep2025.saep_db1.model.Usuario;
import com.saep2025.saep_db1.repository.MovimentoRepository;
import com.saep2025.saep_db1.repository.ProdutoRepository;
import com.saep2025.saep_db1.repository.UsuarioRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/movimentos")
public class MovimentoController {

    private MovimentoRepository movimentoRepository;
    private ProdutoRepository produtoRepository;
    private UsuarioRepository usuarioRepository;

    public MovimentoController(MovimentoRepository movimentoRepository, 
                              ProdutoRepository produtoRepository,
                              UsuarioRepository usuarioRepository) {
        this.movimentoRepository = movimentoRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    // GET /movimentos - Lista movimentações
    public String listar(Model model) {
        List<Movimento> movimentos = movimentoRepository.findAll();
        model.addAttribute("movimentos", movimentos);
        return "movimento/lista";
    }

    @GetMapping("/novo")
    // GET /movimentos/novo - Formulário nova movimentação
    public String novo(Model model) {
        model.addAttribute("movimento", new Movimento());
        model.addAttribute("produtos", produtoRepository.findAll());
        return "movimento/form";
    }

    @PostMapping("/salvar")
    // POST /movimentos/salvar - Salva movimentação e atualiza estoque
    public String salvar(@ModelAttribute Movimento movimento,
                         @AuthenticationPrincipal UserDetails userDetails,
                         Model model) {
        // @AuthenticationPrincipal pega dados do usuário logado

        // Busca usuário logado pelo email
        Usuario usuario = usuarioRepository.findByEmail(userDetails.getUsername()).orElse(null);
        if (usuario != null) {
            movimento.setUsuario(usuario);
        }

        // Busca produto para validar estoque
        Produto produto = produtoRepository.findById(movimento.getProduto().getId()).orElse(null);

        if (produto != null) {
            // Validação: saída não pode ser maior que estoque atual
            if (movimento.getTipomovto() == 'S' && 
                movimento.getQtdmovto().compareTo(produto.getEstoqueatual()) > 0) {

                model.addAttribute("erro", 
                    "❌ Quantidade solicitada (" + movimento.getQtdmovto() + 
                    ") é maior que o estoque atual (" + produto.getEstoqueatual() + ").");
                model.addAttribute("movimento", movimento);
                model.addAttribute("produtos", produtoRepository.findAll());
                return "movimento/form";  // Volta para formulário com erro
            }

            // Atualização do estoque
            if (movimento.getTipomovto() == 'E') {
                // Entrada: soma ao estoque
                produto.setEstoqueatual(produto.getEstoqueatual().add(movimento.getQtdmovto()));
            } else if (movimento.getTipomovto() == 'S') {
                // Saída: subtrai do estoque
                produto.setEstoqueatual(produto.getEstoqueatual().subtract(movimento.getQtdmovto()));
            }
            produtoRepository.save(produto);  // Salva estoque atualizado
        }

        movimentoRepository.save(movimento);  // Salva movimentação
        return "redirect:/movimentos";
    }
}
```

### 22. 🔧 **AdminController.java** - Utilitários Admin

```java
package com.saep2025.saep_db1.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController retorna dados diretamente (não templates)
public class AdminController {

    @GetMapping("/admin/gerarsenha")
    // Utilitário para gerar senhas criptografadas
    // Exemplo: http://localhost:8080/admin/gerarsenha?senha=admin
    public String gerarSenha(@RequestParam String senha) {
        // @RequestParam pega parâmetro da URL (?senha=valor)
        String hash = new BCryptPasswordEncoder().encode(senha);
        return """
                🧩 <b>Senha digitada:</b> %s<br>
                🔒 <b>Hash gerado (BCrypt):</b><br>
                <code>%s</code>
                """.formatted(senha, hash);
        // Retorna HTML com a senha original e o hash gerado
    }
}
```

---

## 🛠️ UTILITÁRIOS

### 23. 🔐 **GerarSenha.java** - Gerador de Senhas

```java
package com.saep2025.saep_db1.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Classe utilitária para gerar senhas criptografadas em BCrypt.
 * 
 * Uso:
 * 1️⃣ Execute essa classe como aplicação Java.
 * 2️⃣ Digite a senha desejada quando solicitado.
 * 3️⃣ Copie o hash gerado e use no banco de dados.
 */
public class GerarSenha {

    public static void main(String[] args) {
        // Método main permite executar esta classe independentemente
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Digite a senha a ser criptografada: ");
        String senha = scanner.nextLine();  // Lê senha do usuário
        scanner.close();

        String hash = new BCryptPasswordEncoder().encode(senha);
        // Gera hash BCrypt da senha

        System.out.println("\\nSenha criptografada:");
        System.out.println(hash);
        // Exibe o hash para copiar e usar no banco
    }
}
```

---

## 🗄️ SCRIPTS DO BANCO DE DADOS

### 24. 🏗️ **schema.sql** - Estrutura do Banco

```sql
-- ========================================
-- SCHEMA - SAEP 2025
-- ========================================

-- Cria banco se não existir com charset UTF-8
CREATE DATABASE IF NOT EXISTS saep_db1 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE saep_db1;

-- ========================================
-- TABELA USUÁRIO
-- ========================================
CREATE TABLE IF NOT EXISTS usuario (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,    -- ID único auto incremento
  nome VARCHAR(255),                       -- Nome do usuário
  email VARCHAR(255) UNIQUE,               -- Email único (usado como login)
  senha VARCHAR(255)                       -- Senha criptografada
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;   -- Engine InnoDB para transações

-- ========================================
-- TABELA TIPO
-- ========================================
CREATE TABLE IF NOT EXISTS tipo (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,    -- ID único
  descricao VARCHAR(255)                   -- Descrição do tipo
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ========================================
-- TABELA PRODUTO
-- ========================================
CREATE TABLE IF NOT EXISTS produto (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,    -- ID único
  descproduto VARCHAR(255),                -- Descrição do produto
  unidmedida VARCHAR(50),                  -- Unidade de medida
  estoqueatual DECIMAL(10,2),              -- Estoque atual (10 dígitos, 2 decimais)
  estoqueminimo DECIMAL(10,2),             -- Estoque mínimo
  idtipo BIGINT,                           -- Chave estrangeira para tipo
  CONSTRAINT fk_produto_tipo FOREIGN KEY (idtipo)
    REFERENCES tipo(id) ON DELETE SET NULL ON UPDATE CASCADE
    -- Se tipo for excluído, produto fica sem tipo (NULL)
    -- Se ID do tipo mudar, atualiza automaticamente
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ========================================
-- TABELA MOVIMENTO
-- ========================================
CREATE TABLE IF NOT EXISTS movimento (
  idtransacao BIGINT AUTO_INCREMENT PRIMARY KEY,  -- ID único da transação
  datahoramovto DATETIME(6),                      -- Data/hora com microssegundos
  qtdmovto DECIMAL(10,2),                         -- Quantidade movimentada
  tipomovto CHAR(1) NOT NULL,                     -- Tipo: 'E'=Entrada, 'S'=Saída
  idproduto BIGINT,                               -- Produto movimentado
  idusuario BIGINT,                               -- Usuário que fez a movimentação
  CONSTRAINT fk_movimento_produto FOREIGN KEY (idproduto)
    REFERENCES produto(id) ON DELETE CASCADE ON UPDATE CASCADE,
    -- Se produto for excluído, movimentações também são excluídas
  CONSTRAINT fk_movimento_usuario FOREIGN KEY (idusuario)
    REFERENCES usuario(id) ON DELETE CASCADE ON UPDATE CASCADE
    -- Se usuário for excluído, movimentações também são excluídas
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

### 25. 📊 **data.sql** - Dados Iniciais

```sql
-- ========================================
-- DADOS INICIAIS - SAEP 2025
-- ========================================

-- USUÁRIO PADRÃO (senha: admin)
-- Hash BCrypt da senha "admin"
INSERT INTO usuario (nome, email, senha)
VALUES ('Administrador', 'admin@saep.com',
        '$2a$10$0omgADneSOBADv2v0OTXk.PHuUwiIjT12HoTalmHzZstKUW93LHJ2');

-- TIPOS PADRÃO para classificar produtos
INSERT INTO tipo (descricao) VALUES
('Corante'),      -- ID 1
('Alvejante'),    -- ID 2
('Auxiliar'),     -- ID 3
('Não definido'); -- ID 4

-- PRODUTOS INICIAIS com estoque
INSERT INTO produto (descproduto, unidmedida, estoqueatual, estoqueminimo, idtipo)
VALUES
('Corante Azul', 'L', 10, 3, 1),        -- 10L atual, mínimo 3L, tipo Corante
('Alvejante Branco', 'L', 25, 5, 2),    -- 25L atual, mínimo 5L, tipo Alvejante
('Produto Auxiliar X', 'kg', 15, 4, 3); -- 15kg atual, mínimo 4kg, tipo Auxiliar

-- MOVIMENTOS INICIAIS (histórico)
INSERT INTO movimento (datahoramovto, qtdmovto, tipomovto, idproduto, idusuario)
VALUES
(NOW(), 5.00, 'E', 1, 1),  -- Entrada de 5L do produto 1 pelo usuário 1
(NOW(), 2.00, 'S', 2, 1),  -- Saída de 2L do produto 2 pelo usuário 1
(NOW(), 3.00, 'E', 3, 1);  -- Entrada de 3kg do produto 3 pelo usuário 1
```

---

## 🎨 TEMPLATES HTML (INTERFACE)

### 26. 🔐 **login.html** - Página de Login

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="pt-BR">
<!-- xmlns:th habilita uso do Thymeleaf para templates dinâmicos -->

<head>
    <meta charset="UTF-8">
    <title>Login - SAEP 2025</title>
    <link rel="stylesheet" th:href="@{/css/style.css}">
    <!-- th:href="@{/css/style.css}" gera URL correta para CSS -->
    
    <style>
        /* CSS inline para estilizar a página de login */
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;  /* Altura total da tela */
        }
        .login-container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 320px;
        }
        h2 { text-align: center; margin-bottom: 20px; }
        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover { background: #0056b3; }
        .msg {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>

<body>
<div class="login-container">
    <h2>Login SAEP</h2>
    
    <!-- Formulário de login que envia para /login via POST -->
    <form th:action="@{/login}" method="post">
        <!-- th:action="@{/login}" gera URL correta -->
        
        <input type="text" name="username" placeholder="E-mail" required>
        <!-- name="username" é obrigatório para Spring Security -->
        
        <input type="password" name="password" placeholder="Senha" required>
        <!-- name="password" é obrigatório para Spring Security -->
        
        <button type="submit">Entrar</button>
    </form>
    
    <!-- Mensagens condicionais do Thymeleaf -->
    <p th:if="${param.error}" class="msg">Usuário ou senha inválidos!</p>
    <!-- th:if="${param.error}" mostra apenas se há parâmetro error na URL -->
    
    <p th:if="${param.logout}" class="msg">Logout realizado com sucesso!</p>
    <!-- th:if="${param.logout}" mostra apenas se há parâmetro logout na URL -->
</div>
</body>
</html>
```

### 27. 🏠 **principal.html** - Dashboard Principal

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="pt-BR"
      th:replace="~{fragments/_layout :: layout(~{::body})}">
<!-- th:replace usa o layout padrão e substitui apenas o body -->

<head>
  <meta charset="UTF-8">
  <title>Dashboard SAEP 2025</title>
</head>

<body>
<div th:fragment="conteudo" class="container text-center dashboard-container">
  <!-- th:fragment="conteudo" define que este div será inserido no layout -->

  <!-- Título dinâmico -->
  <h1 class="fw-bold mb-3 display-5 text-light">
    <i class="bi bi-stars"></i> Bem-vinda ao Sistema <span class="text-info">SAEP 2025</span>!
  </h1>
  <p class="lead mb-5">Gerencie seus <strong>produtos</strong> e <strong>tipos</strong> com estilo e eficiência.</p>

  <!-- Cards de navegação -->
  <div class="row justify-content-center g-4">
    <!-- Card Produtos -->
    <div class="col-md-5">
      <div class="card shadow-lg p-4">
        <div class="card-body">
          <i class="bi bi-box2-heart display-4 text-info mb-3"></i>
          <h4 class="section-title">Gerenciar Produtos</h4>
          <p class="mt-2">Cadastre, edite e acompanhe os níveis de estoque dos seus produtos.</p>
          <a th:href="@{/produtos}" class="btn btn-outline-info btn-modern w-100 mt-3">
            <!-- th:href="@{/produtos}" gera link para /produtos -->
            <i class="bi bi-arrow-right-circle"></i> Acessar
          </a>
        </div>
      </div>
    </div>

    <!-- Card Tipos -->
    <div class="col-md-5">
      <div class="card shadow-lg p-4">
        <div class="card-body">
          <i class="bi bi-tags-fill display-4 text-warning mb-3"></i>
          <h4 class="section-title">Gerenciar Tipos</h4>
          <p class="mt-2">Organize os tipos de produtos para manter o controle de estoque completo.</p>
          <a th:href="@{/tipos}" class="btn btn-outline-warning btn-modern w-100 mt-3">
            <i class="bi bi-arrow-right-circle"></i> Acessar
          </a>
        </div>
      </div>
    </div>
  </div>

  <!-- Rodapé com data/hora dinâmica -->
  <div class="footer-info">
    <small>
      <i class="bi bi-clock-history"></i> Último acesso em
      <span th:text="${#dates.format(#dates.createNow(), 'dd/MM/yyyy HH:mm')}"></span>
      <!-- th:text exibe data/hora atual formatada -->
    </small>
  </div>

</div>
</body>
</html>
```

### 28. 🎨 **_layout.html** - Layout Base

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title th:text="${pageTitle} ?: 'SAEP 2025'"></title>
  <!-- th:text="${pageTitle} ?: 'SAEP 2025'" usa pageTitle se existir, senão usa 'SAEP 2025' -->

  <!-- Bootstrap & Ícones via CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

  <style>
    /* CSS customizado para o tema do sistema */
    body { 
      background: linear-gradient(135deg, #0f2027, #203a43, #2c5364); 
      color: #f8f9fa; 
      min-height: 100vh; 
      padding-top: 70px; 
    }
    .navbar { 
      background: rgba(0, 0, 0, 0.8); 
      backdrop-filter: blur(10px); 
    }
    .navbar-brand { 
      font-weight: 700; 
      color: #00d4ff !important; 
      letter-spacing: 1px; 
    }
    .nav-link { 
      color: #f8f9fa !important; 
      font-weight: 500; 
    }
    .nav-link:hover { 
      color: #00d4ff !important; 
    }
    .btn-logout { 
      border: 1px solid #00d4ff; 
      color: #00d4ff; 
      transition: all 0.3s; 
    }
    .btn-logout:hover { 
      background-color: #00d4ff; 
      color: #0f2027; 
    }
    footer { 
      text-align: center; 
      padding: 20px 0; 
      color: #aaa; 
      font-size: 0.9em; 
      margin-top: 40px; 
    }
    footer i { 
      color: #00d4ff; 
    }
  </style>
</head>

<body>
  <!-- Barra de navegação fixa no topo -->
  <nav class="navbar navbar-expand-lg navbar-dark shadow-sm fixed-top">
    <div class="container-fluid px-4">
      <a class="navbar-brand" th:href="@{/principal}">
        <i class="bi bi-stars"></i> SAEP 2025
      </a>

      <!-- Botão para menu mobile -->
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Menu de navegação -->
      <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav align-items-center">
          <li class="nav-item">
            <a class="nav-link" th:href="@{/produtos}">
              <i class="bi bi-box-seam"></i> Produtos
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" th:href="@{/tipos}">
              <i class="bi bi-tags"></i> Tipos
            </a>
          </li>
          <li class="nav-item ms-3">
            <!-- Formulário de logout -->
            <form th:action="@{/logout}" method="post" class="d-inline">
              <button type="submit" class="btn btn-sm btn-logout">
                <i class="bi bi-box-arrow-right"></i> Sair
              </button>
            </form>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Conteúdo principal (será substituído por cada página) -->
  <main class="container mt-5" th:fragment="layout(conteudo)">
    <div th:replace="${conteudo}"></div>
    <!-- th:replace="${conteudo}" substitui por conteúdo específico de cada página -->
  </main>

  <!-- Rodapé -->
  <footer>
    <i class="bi bi-c-circle"></i> SAEP 2025 · Desenvolvido com ❤️ por Karize
  </footer>
</body>
</html>
```

---

## 📋 COMO USAR ESTE PROJETO COMO BASE PARA O SAEP

### 🎯 **Entendendo a Estrutura**

1. **Modelos (model/)**: Representam as tabelas do banco
   - Cada classe = uma tabela
   - Anotações JPA fazem o mapeamento automático
   - Relacionamentos são definidos com @ManyToOne, @OneToMany

2. **Repositórios (repository/)**: Acesso aos dados
   - Herdam JpaRepository para métodos CRUD prontos
   - Podem ter métodos customizados (findByEmail)

3. **Controladores (controller/)**: Recebem requisições
   - @GetMapping para exibir páginas
   - @PostMapping para processar formulários
   - Model passa dados para templates

4. **Templates (templates/)**: Interface HTML
   - Thymeleaf permite HTML dinâmico
   - th:* são diretivas para dados dinâmicos
   - Layout reutilizável evita repetição

### 🔧 **Adaptando para Sua Prova**

1. **Novos Modelos**: Crie classes em model/ com anotações JPA
2. **Novos Repositórios**: Interfaces que herdam JpaRepository
3. **Novos Controladores**: Classes com @Controller e mapeamentos
4. **Novos Templates**: HTML com Thymeleaf em templates/
5. **Banco de Dados**: Atualize schema.sql e data.sql

### 📚 **Conceitos Importantes**

- **MVC**: Model (dados), View (interface), Controller (lógica)
- **JPA**: Mapeamento objeto-relacional automático
- **Spring Security**: Autenticação e autorização
- **Thymeleaf**: Templates HTML dinâmicos
- **Bootstrap**: Framework CSS responsivo
- **Maven**: Gerenciamento de dependências

### 🚀 **Para Executar**

1. Instale MySQL e crie banco `saep_db1`
2. Configure `application.properties` com suas credenciais
3. Execute `mvn spring-boot:run` ou rode SaepDb1Application
4. Acesse http://localhost:8080
5. Login: admin@saep.com / senha: admin

---

## 🎓 **RESUMO PARA ESTUDOS**

Este projeto implementa um **sistema completo de controle de estoque** usando as melhores práticas do Spring Boot. É um excelente template para entender:

- ✅ **Arquitetura MVC**
- ✅ **Mapeamento JPA/Hibernate**
- ✅ **Spring Security**
- ✅ **Templates Thymeleaf**
- ✅ **CRUD completo**
- ✅ **Validações de negócio**
- ✅ **Interface responsiva**

**Use este projeto como base** e adapte conforme os requisitos da sua prova SAEP! 🚀