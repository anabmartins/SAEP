/* Lógico_1: */

CREATE TABLE Professor (
    id_professor serial PRIMARY KEY,
    nome varchar,
    senha varchar,
    email varchar,
    fk_Turma_id_turma serial
);

CREATE TABLE Atividade (
    descricao varchar,
    id_atividade serial PRIMARY KEY
);

CREATE TABLE Turma (
    id_turma serial PRIMARY KEY,
    nome varchar,
    fk_Atividade_id_atividade serial
);
 
ALTER TABLE Professor ADD CONSTRAINT FK_Professor_2
    FOREIGN KEY (fk_Turma_id_turma)
    REFERENCES Turma (id_turma)
    ON DELETE CASCADE;
 
ALTER TABLE Turma ADD CONSTRAINT FK_Turma_2
    FOREIGN KEY (fk_Atividade_id_atividade)
    REFERENCES Atividade (id_atividade)
    ON DELETE CASCADE;

Insert into atividade (descricao) values ('atividade');

Insert into turma (nome, fk_atividade_id_atividade) values ('3B', 1);

Insert into professor (nome, email, senha, fk_turma_id_turma) values
('Ana', 'ana@', '123', 1);

select * from professor;

Insert into atividade (descricao) values ('atividade SQL 2');

Insert into turma (nome, fk_atividade_id_atividade) values ('3A', 1);

Insert into professor (nome, email, senha, fk_turma_id_turma) values
('jackson', 'jackson@', '123', 1);

select * from professor;

Insert into atividade (descricao) values ('atividade React');

Insert into turma (nome, fk_atividade_id_atividade) values ('3A', 1);

Insert into professor (nome, email, senha, fk_turma_id_turma) values
('bruno', 'bruno@', '123', 1);

select * from professor;