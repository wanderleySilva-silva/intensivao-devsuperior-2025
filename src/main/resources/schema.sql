-- Criação da tabela tb_game
CREATE TABLE tb_game (
    id SERIAL PRIMARY KEY, -- Chave primária auto incrementada
    title VARCHAR(255) NOT NULL, -- Título do jogo
    score NUMERIC(3, 1) NOT NULL, -- Nota do jogo (ex.: 4.8)
    game_year INT NOT NULL, -- Ano de lançamento
    genre VARCHAR(255) NOT NULL, -- Gênero do jogo
    platforms VARCHAR(255) NOT NULL, -- Plataformas disponíveis
    img_url TEXT NOT NULL, -- URL da imagem do jogo
    short_description TEXT NOT NULL, -- Descrição curta
    long_description TEXT NOT NULL -- Descrição longa
);

-- Criação da tabela tb_game_list
CREATE TABLE tb_game_list (
    id SERIAL PRIMARY KEY, -- Chave primária auto incrementada
    name VARCHAR(255) NOT NULL -- Nome da lista de jogos
);

-- Criação da tabela tb_belonging (tabela de relacionamento)
CREATE TABLE tb_belonging (
    list_id INT NOT NULL, -- ID da lista de jogos
    game_id INT NOT NULL, -- ID do jogo
    position INT NOT NULL, -- Posição do jogo na lista
    PRIMARY KEY (list_id, game_id), -- Chave primária composta
    CONSTRAINT fk_belonging_list FOREIGN KEY (list_id) REFERENCES tb_game_list (id) ON DELETE CASCADE,
    CONSTRAINT fk_belonging_game FOREIGN KEY (game_id) REFERENCES tb_game (id) ON DELETE CASCADE
);
