# 🪡 SISTEMA DE CONTROLE DE ESTOQUE - LOJA DE AVIAMENTOS
## SAEP 2025 - Projeto Completo Spring Boot + MySQL + Thymeleaf

---

## 🎯 **VISÃO GERAL DO PROJETO**

Sistema completo de controle de estoque desenvolvido para uma loja de aviamentos, implementando todas as funcionalidades solicitadas na prova SAEP 2025.

### ✨ **Funcionalidades Principais**
- 🔐 **Autenticação e Autorização** com Spring Security
- 📦 **Cadastro de Produtos** com categorias e validações
- 📊 **Gestão de Estoque** com entrada e saída de mercadorias
- ⚠️ **Alertas de Estoque Baixo** automáticos
- 📈 **Dashboard** com resumo do sistema
- 🔍 **Busca de Produtos** por nome ou descrição
- 📋 **Histórico de Movimentações** completo
- 👥 **Gestão de Usuários** com diferentes perfis

---

## 🛠️ **TECNOLOGIAS UTILIZADAS**

- **Backend:** Spring Boot 3.5.6, Spring Security, Spring Data JPA
- **Frontend:** Thymeleaf, Bootstrap 5.3, JavaScript
- **Banco de Dados:** MySQL 8.0+
- **Linguagem:** Java 17
- **Build:** Maven
- **Validação:** Bean Validation (JSR-303)
- **Segurança:** BCrypt para criptografia de senhas

---

## 📁 **ESTRUTURA DO PROJETO**

```
loja-aviamento2/
├── src/main/java/com/loja/lojaaviamento/
│   ├── config/              # Configurações (Security, DataInitializer)
│   ├── controller/          # Controladores MVC
│   ├── Domain/              # Entidade Usuario
│   ├── model/               # Entidades (Produto, Categoria, MovimentacaoEstoque)
│   ├── repository/          # Repositories JPA
│   └── service/             # Regras de negócio
├── src/main/resources/
│   ├── templates/           # Páginas HTML Thymeleaf
│   │   ├── produtos/        # Templates de produtos
│   │   └── estoque/         # Templates de estoque
│   ├── static/              # CSS, JS, imagens
│   ├── application.properties
│   └── data.sql             # Dados iniciais
├── script_banco_saep_db.sql # Script completo do banco
├── documentacao.md          # Documentação completa
└── pom.xml                  # Dependências Maven
```

---

## 🚀 **COMO EXECUTAR O PROJETO**

### 📋 **Pré-requisitos**
- Java 17 ou superior
- MySQL Server 8.0+
- Maven 3.8+ (ou usar o wrapper incluído)

### 🔧 **Configuração do Banco de Dados**
1. Instalar e iniciar o MySQL Server
2. Executar o script: `script_banco_saep_db.sql`
3. O banco `saep_db` será criado automaticamente

### ▶️ **Executando a Aplicação**
```bash
# Clonar/extrair o projeto
cd loja-aviamento2

# Executar com Maven
mvn spring-boot:run

# Ou usar o wrapper (se disponível)
./mvnw spring-boot:run
```

### 🌐 **Acessando o Sistema**
- **URL:** http://localhost:8080
- **Admin:** admin@admin.com / admin123
- **Usuário:** user@user.com / user123

---

## 📊 **FUNCIONALIDADES IMPLEMENTADAS**

### 🔐 **1. Sistema de Login**
- Autenticação com email e senha
- Mensagens de erro personalizadas
- Redirecionamento automático após login
- Logout seguro

### 📦 **2. Cadastro de Produtos**
- ✅ Listagem de produtos em ordem alfabética
- ✅ Busca por nome ou descrição
- ✅ Formulário com validações completas
- ✅ Edição de produtos existentes
- ✅ Exclusão lógica (inativação)
- ✅ Categorização de produtos

### 📊 **3. Gestão de Estoque**
- ✅ Produtos listados em ordem alfabética
- ✅ Seleção de produto para movimentação
- ✅ Entrada e saída de mercadorias
- ✅ Data automática de movimentação
- ✅ Verificação automática de estoque baixo
- ✅ Alertas visuais para estoque mínimo

### 🏠 **4. Dashboard Principal**
- ✅ Nome do usuário logado
- ✅ Botão de logout
- ✅ Acesso ao cadastro de produtos
- ✅ Acesso à gestão de estoque
- ✅ Resumo de informações importantes

---

## 🗃️ **MODELO DE DADOS**

### 📋 **Entidades Principais**

**Usuários**
- ID, Nome, Email, Senha, Role, Ativo, Data Criação

**Categorias**
- ID, Nome, Descrição

**Produtos**
- ID, Nome, Descrição, Preço, Quantidade Estoque, Estoque Mínimo, Categoria, Ativo

**Movimentações de Estoque**
- ID, Produto, Tipo (Entrada/Saída), Quantidade, Data, Observação, Usuário

---

## 🧪 **CASOS DE TESTE IMPLEMENTADOS**

### ✅ **Testes de Login**
- Login com credenciais válidas
- Login com credenciais inválidas
- Redirecionamento após autenticação

### ✅ **Testes de Produtos**
- Cadastro de produto válido
- Validação de campos obrigatórios
- Busca por nome/descrição
- Edição de produtos
- Exclusão de produtos

### ✅ **Testes de Estoque**
- Movimentação de entrada
- Movimentação de saída
- Validação de estoque insuficiente
- Alertas de estoque baixo
- Histórico de movimentações

---

## 📋 **ENTREGAS REALIZADAS**

### ✅ **1. Lista de Requisitos Funcionais**
- Documento completo em `documentacao.md`
- 10 requisitos funcionais detalhados
- Critérios de aceitação definidos

### ✅ **2. Diagrama Entidade Relacionamento (DER)**
- Modelo relacional completo
- Relacionamentos entre entidades
- Chaves primárias e estrangeiras

### ✅ **3. Script de Criação e População**
- Arquivo: `script_banco_saep_db.sql`
- Banco nomeado como "saep_db"
- Mínimo 3 registros por tabela
- Dados realistas para loja de aviamentos

### ✅ **4. Interface de Autenticação**
- Tela de login responsiva
- Tratamento de falhas de autenticação
- Mensagens informativas
- Design com Bootstrap

### ✅ **5. Interface Principal**
- Dashboard com nome do usuário
- Botão de logout funcional
- Navegação para cadastro de produtos
- Navegação para gestão de estoque
- Layout responsivo e intuitivo

### ✅ **6. Interface Cadastro de Produto**
- Listagem automática de produtos
- Campo de busca funcional
- Formulário de inserção completo
- Edição de produtos existentes
- Exclusão com confirmação
- Validações client-side e server-side
- Navegação de retorno

### ✅ **7. Interface Gestão de Estoque**
- Produtos em ordem alfabética (algoritmo de ordenação SQL)
- Seleção de produto para movimentação
- Escolha entre entrada e saída
- Campo de data da movimentação
- Verificação automática de estoque baixo
- Alertas visuais para estoque mínimo

### ✅ **8. Descritivo de Teste de Software**
- Casos de teste detalhados
- Ferramentas e ambiente especificados
- Testes para cada requisito funcional

### ✅ **9. Lista de Requisitos de Infraestrutura**
- SGBD: MySQL 8.0+
- Linguagem: Java 17
- SO: Windows 11
- Especificações completas de hardware e software

---

## 🎨 **INTERFACE DO USUÁRIO**

### 🎯 **Design Responsivo**
- Bootstrap 5.3 para layout moderno
- Ícones Bootstrap Icons
- Cores temáticas por funcionalidade
- Alertas e mensagens contextuais

### 📱 **Experiência do Usuário**
- Navegação intuitiva
- Feedback visual imediato
- Confirmações para ações críticas
- Validações em tempo real

---

## 🔒 **SEGURANÇA IMPLEMENTADA**

- **Autenticação:** Spring Security com formulário customizado
- **Autorização:** Controle de acesso por roles (ADMIN/USER)
- **Criptografia:** BCrypt para senhas
- **Validação:** Server-side e client-side
- **Proteção CSRF:** Configurada no Spring Security

---

## 📈 **ALGORITMOS IMPLEMENTADOS**

### 🔤 **Ordenação Alfabética**
- **Produtos:** Ordenação SQL com `ORDER BY nome ASC`
- **Categorias:** Ordenação automática nas consultas
- **Movimentações:** Ordenação por data decrescente

### 🔍 **Busca e Filtros**
- **Busca Textual:** LIKE com LOWER() para case-insensitive
- **Filtros:** Por categoria, status ativo/inativo
- **Paginação:** Preparado para implementação futura

---

## 🚀 **PRÓXIMAS MELHORIAS**

- 📄 Relatórios em PDF
- 📊 Gráficos de movimentação
- 📱 API REST para mobile
- 🔔 Notificações por email
- 📦 Código de barras
- 💰 Controle financeiro

---

## 👨💻 **DESENVOLVEDOR**

**Projeto SAEP 2025**  
**Sistema de Controle de Estoque - Loja de Aviamentos**  
**Tecnologia:** Spring Boot + MySQL + Thymeleaf  
**Data:** Janeiro 2025

---

## 📞 **SUPORTE**

Para dúvidas sobre o sistema:
- 📧 Consulte a documentação completa em `documentacao.md`
- 🗄️ Execute o script SQL para configurar o banco
- 🔧 Verifique as configurações no `application.properties`

**Sistema pronto para produção e avaliação SAEP 2025! 🎉**