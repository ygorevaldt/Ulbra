-- TB_ALUNO
CREATE TABLE aluno ( 
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    nome VARCHAR(255), 
    idade INT, 
    curso VARCHAR(255) 
);

INSERT INTO aluno 
	(nome, idade, curso)
VALUES 
    ('João', 20, 'Engenharia'), 
    ('Maria', 22, 'Ciência da Computação'), 
    ('Carlos', 21, 'Medicina');

-- TB_NOTA
CREATE TABLE nota (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT, 
    disciplina VARCHAR(50), 
    nota INT, 
    FOREIGN KEY (id_aluno) REFERENCES aluno(id)
);

INSERT INTO nota 
	(id_aluno, disciplina, nota)
VALUES 
    (1, 'Matemática', 85),
    (1, 'Física', 78),
    (2, 'Matemática', 92),
    (2, 'Física', 88),
    (3, 'Matemática', 75),
    (3, 'Física', 80);
    
CREATE VIEW vw_notas_alunos AS
SELECT aluno.nome, nota.disciplina, nota.nota
FROM aluno
JOIN nota ON aluno.id = nota.id_aluno;

SELECT * FROM vw_notas_alunos;
    