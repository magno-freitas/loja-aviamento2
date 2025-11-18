

-- Criar banco de dados
CREATE DATABASE IF NOT EXISTS saep_db;
USE saep_db;

-- Tabela de usuários
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    ativo BOOLEAN DEFAULT TRUE,
    criado_em DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de categorias
CREATE TABLE categorias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    descricao TEXT
);

-- Tabela de produtos
CREATE TABLE produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    quantidade_estoque INT NOT NULL DEFAULT 0,
    estoque_minimo INT NOT NULL DEFAULT 1,
    categoria_id BIGINT NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

-- Tabela de movimentações de estoque
CREATE TABLE movimentacoes_estoque (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    produto_id BIGINT NOT NULL,
    tipo ENUM('ENTRADA', 'SAIDA') NOT NULL,
    quantidade INT NOT NULL,
    data_movimentacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    observacao TEXT,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produtos(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Inserir usuários
INSERT INTO usuarios (nome, email, senha, role) VALUES 
('Administrador do Sistema', 'admin@admin.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9P8jW0UpNzyr.2u', 'ADMIN'),
('Magno', 'magno@loja.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9P8jW0UpNzyr.2u', 'USER'),
('João Santos', 'joao@loja.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9P8jW0UpNzyr.2u', 'USER');

-- Inserir categorias
INSERT INTO categorias (nome, descricao) VALUES 
('Linhas e Fios', 'Linhas de costura, bordado e fios diversos para confecção'),
('Botões', 'Botões de diversos materiais, tamanhos e cores'),
('Zíperes e Fechos', 'Zíperes, fechos e acessórios de fechamento'),
('Fitas e Rendas', 'Fitas decorativas, rendas e acabamentos diversos'),
('Tecidos', 'Tecidos diversos para confecção e artesanato'),
('Ferramentas', 'Ferramentas e utensílios para costura e artesanato');

-- Inserir produtos
INSERT INTO produtos (nome, descricao, preco, quantidade_estoque, estoque_minimo, categoria_id, ativo) VALUES 
-- Linhas e Fios (categoria_id = 1)
('Linha de Algodão Branca 200m', 'Linha 100% algodão cor branca, carretel 200 metros', 3.50, 50, 10, 1, true),
('Linha de Algodão Preta 200m', 'Linha 100% algodão cor preta, carretel 200 metros', 3.50, 45, 10, 1, true),
('Fio de Bordar Kit 12 Cores', 'Kit com 12 meadas de fio para bordado, cores sortidas', 15.90, 25, 5, 1, true),
('Linha de Poliéster Azul', 'Linha de poliéster resistente cor azul, carretel 500m', 5.80, 30, 8, 1, true),

-- Botões (categoria_id = 2)
('Botão Plástico Branco 2cm', 'Botão plástico branco 2cm de diâmetro, pacote com 10 unidades', 2.50, 200, 50, 2, true),
('Botão Madeira Natural 1.5cm', 'Botão de madeira natural 1.5cm, pacote com 8 unidades', 6.40, 150, 30, 2, true),
('Botão Metálico Dourado 2.5cm', 'Botão metálico dourado para roupas finas, unidade', 2.50, 80, 20, 2, true),
('Botão Pressão Preto', 'Botão de pressão preto tamanho médio, pacote com 20 unidades', 8.90, 60, 15, 2, true),

-- Zíperes e Fechos (categoria_id = 3)
('Zíper Comum 20cm Preto', 'Zíper comum 20cm cor preta para roupas', 2.80, 60, 15, 3, true),
('Zíper Comum 30cm Branco', 'Zíper comum 30cm cor branca para roupas', 3.20, 55, 15, 3, true),
('Zíper Invisível 40cm Bege', 'Zíper invisível 40cm cor bege para vestidos', 8.90, 30, 10, 3, true),
('Colchete de Pressão Níquel', 'Colchete de pressão níquel tamanho grande, pacote com 10', 4.50, 40, 12, 3, true),

-- Fitas e Rendas (categoria_id = 4)
('Fita de Cetim 1cm Branca', 'Fita de cetim branca 1cm largura, rolo 10 metros', 4.50, 40, 8, 4, true),
('Renda Guipir Branca 3cm', 'Renda guipir branca 3cm largura, vendida por metro', 12.00, 35, 10, 4, true),
('Fita Gorgorão 2cm Colorida', 'Fita gorgorão 2cm diversas cores, rolo 5 metros', 6.80, 25, 8, 4, true),
('Elástico Chato 1cm Preto', 'Elástico chato preto 1cm largura, rolo 10 metros', 8.50, 20, 5, 4, true),

-- Tecidos (categoria_id = 5)
('Tecido Algodão Liso Branco', 'Tecido 100% algodão liso branco, largura 1,50m, vendido por metro', 18.90, 20, 5, 5, true),
('Tecido Jeans Azul Tradicional', 'Tecido jeans azul tradicional, largura 1,40m, vendido por metro', 25.50, 15, 3, 5, true),
('Tecido Malha Cotton Mescla', 'Tecido malha cotton mescla cinza, largura 1,60m, vendido por metro', 22.00, 18, 5, 5, true),
('Tecido Oxford Listrado', 'Tecido oxford listrado azul e branco, largura 1,50m, vendido por metro', 28.90, 12, 4, 5, true),

-- Ferramentas (categoria_id = 6)
('Tesoura de Costura 8 Polegadas', 'Tesoura profissional para costura 8 polegadas, aço inox', 35.90, 12, 3, 6, true),
('Alfinetes Cabeça Colorida', 'Caixa com 100 alfinetes cabeça colorida para costura', 8.50, 30, 8, 6, true),
('Fita Métrica 150cm', 'Fita métrica flexível 150cm com trava automática', 12.90, 25, 5, 6, true),
('Dedal de Metal Tamanho M', 'Dedal de metal tamanho médio para proteção do dedo', 4.20, 40, 10, 6, true);

-- Inserir algumas movimentações de exemplo
INSERT INTO movimentacoes_estoque (produto_id, tipo, quantidade, observacao, usuario_id) VALUES 
(1, 'ENTRADA', 20, 'Reposição de estoque - compra fornecedor', 1),
(2, 'SAIDA', 5, 'Venda para cliente Maria', 2),
(3, 'ENTRADA', 10, 'Estoque inicial', 1),
(4, 'SAIDA', 3, 'Venda balcão', 3),
(5, 'ENTRADA', 50, 'Compra em atacado', 1),
(6, 'SAIDA', 8, 'Venda para confecção', 2),
(7, 'ENTRADA', 15, 'Reposição', 1),
(8, 'SAIDA', 2, 'Venda avulsa', 3),
(9, 'ENTRADA', 25, 'Estoque inicial', 1),
(10, 'SAIDA', 4, 'Venda cliente João', 2);

-- Comentários sobre o banco
-- Este script cria um banco completo para controle de estoque de uma loja de aviamentos
-- Inclui tabelas para usuários, categorias, produtos e movimentações
-- Possui dados de exemplo com pelo menos 3 registros em cada tabela
-- Senhas dos usuários: admin123 (criptografada com BCrypt)
-- O sistema permite controle completo de entrada e saída de mercadorias
-- Implementa verificação de estoque mínimo e histórico de movimentações