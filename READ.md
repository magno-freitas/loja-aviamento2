loja-aviamentos-spring
Etapa 1 — Usuário & Login do projeto Loja de Aviamentos e Tintas, usando Spring Boot + Spring Security 6 + JPA + H2 + Thymeleaf + Bootstrap. Esta etapa já com cadastro, autenticação e telas básicas.

Requisitos Requisitos Funcionais (RF)
RF01 — Cadastrar usuário (nome, e-mail único, senha com hash, perfil).
RF02 — Autenticar usuário via e-mail + senha.
RF03 — Manter sessão autenticada e exibir nome do usuário logado.
RF04 — Logout seguro (invalidar sessão).
RF05 — Acesso à /home apenas autenticado.
RF06 — E-mail deve ser único no sistema.
RF07 — Exibir feedbacks de erro (login inválido, e-mail já existente, validações).
RF08 — Habilitar /h2-console apenas em dev.
Requisitos Não Funcionais (RNF)

RNF01 — Segurança: senhas com BCrypt; proteção CSRF habilitada (formulários Thymeleaf).
RNF02 — Persistência em H2 (dev), JPA/Hibernate.
RNF03 — UI responsiva com Bootstrap 5 + Thymeleaf.
RNF04 — Código organizado em camadas: controller, service, repository, domain.
RNF05 — Validação com Bean Validation (javax/jakarta).
RNF06 — Padrão de logs de autenticação (sucesso/falha).
RNF07 — Preparado para trocar H2 por outro SGBD depois (configuração externa).
2) Casos de Uso (texto)

UC-01: Registrar Usuário

Ator: Visitante

Fluxo: abre “Criar conta” → informa nome, e-mail, senha, confirma → sistema valida, cria usuário com senha hash e perfil ROLE_USER → redireciona para login com mensagem de sucesso.

**Exceções: **e-mail em uso; senha fraca; campos obrigatórios.

UC-02: Autenticar Usuário

Ator: Usuário

Fluxo: abre “Login” → informa e-mail/senha → sistema autentica via Spring Security → redireciona para /home.

Exceções: credenciais inválidas (mensagem amigável).