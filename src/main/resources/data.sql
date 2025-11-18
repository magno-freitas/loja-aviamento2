-- Inserir categorias
INSERT INTO categorias (nome, descricao) VALUES 
('Linhas e Fios', 'Linhas de costura, bordado e fios diversos'),
('Botões', 'Botões de diversos materiais e tamanhos'),
('Zíperes', 'Zíperes e fechos diversos'),
('Fitas e Rendas', 'Fitas decorativas, rendas e acabamentos'),
('Tecidos', 'Tecidos diversos para confecção'),
('Ferramentas', 'Ferramentas de costura e artesanato');

-- Inserir produtos
INSERT INTO produtos (nome, descricao, preco, quantidade_estoque, estoque_minimo, categoria_id, ativo) VALUES 
-- Linhas e Fios (categoria_id = 1)
('Linha de Algodão Branca', 'Linha 100% algodão cor branca, rolo 200m', 3.50, 50, 10, 1, true),
('Linha de Algodão Preta', 'Linha 100% algodão cor preta, rolo 200m', 3.50, 45, 10, 1, true),
('Fio de Bordar Colorido', 'Kit com 12 cores sortidas para bordado', 15.90, 25, 5, 1, true),

-- Botões (categoria_id = 2)
('Botão Plástico Branco 2cm', 'Botão plástico branco 2cm de diâmetro', 0.25, 200, 50, 2, true),
('Botão Madeira Natural 1.5cm', 'Botão de madeira natural 1.5cm', 0.80, 150, 30, 2, true),
('Botão Metálico Dourado', 'Botão metálico dourado para roupas finas', 2.50, 80, 20, 2, true),

-- Zíperes (categoria_id = 3)
('Zíper Comum 20cm Preto', 'Zíper comum 20cm cor preta', 2.80, 60, 15, 3, true),
('Zíper Comum 30cm Branco', 'Zíper comum 30cm cor branca', 3.20, 55, 15, 3, true),
('Zíper Invisível 40cm', 'Zíper invisível 40cm diversas cores', 8.90, 30, 10, 3, true),

-- Fitas e Rendas (categoria_id = 4)
('Fita de Cetim 1cm Branca', 'Fita de cetim branca 1cm largura, rolo 10m', 4.50, 40, 8, 4, true),
('Renda Guipir Branca', 'Renda guipir branca 3cm largura, metro', 12.00, 35, 10, 4, true),
('Fita Gorgorão Colorida', 'Fita gorgorão 2cm diversas cores', 6.80, 25, 8, 4, true),

-- Tecidos (categoria_id = 5)
('Tecido Algodão Liso Branco', 'Tecido 100% algodão liso branco, metro', 18.90, 20, 5, 5, true),
('Tecido Jeans Azul', 'Tecido jeans azul tradicional, metro', 25.50, 15, 3, 5, true),
('Tecido Malha Cotton', 'Tecido malha cotton diversas cores, metro', 22.00, 18, 5, 5, true),

-- Ferramentas (categoria_id = 6)
('Tesoura de Costura 8"', 'Tesoura profissional para costura 8 polegadas', 35.90, 12, 3, 6, true),
('Alfinetes Cabeça Colorida', 'Caixa com 100 alfinetes cabeça colorida', 8.50, 30, 8, 6, true),
('Fita Métrica 150cm', 'Fita métrica flexível 150cm', 12.90, 25, 5, 6, true);