CREATE TABLE cursos (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
    media_aprovacao NUMERIC(10,2) NOT NULL
);

CREATE TABLE alunos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INTEGER NOT NULL
);

CREATE TABLE aluno_curso
(
	id_aluno INTEGER,
	id_curso INTEGER,
	FOREIGN KEY (id_aluno)
        REFERENCES alunos (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
    FOREIGN KEY (id_curso)
        REFERENCES	cursos (id)
            ON UPDATE CASCADE
            ON DELETE RESTRICT
);

INSERT INTO cursos (nome, media_aprovacao) VALUES ('HTML', 6.0);
INSERT INTO cursos (nome, media_aprovacao) VALUES ('CSS', 6.0);
INSERT INTO cursos (nome, media_aprovacao) VALUES ('JavaScript', 7.0);

INSERT INTO alunos (nome, idade) VALUES ('Ygor Evaldt', 25);
INSERT INTO alunos (nome, idade) VALUES ('Ygor Evaldt', 25);
INSERT INTO alunos (nome, idade) VALUES ('Ygor Bitencourt', 25);
INSERT INTO alunos (nome, idade) VALUES ('Alessandra Silveira', 19);
INSERT INTO alunos (nome, idade) VALUES ('Alessandra Silveira', 19);
INSERT INTO alunos (nome, idade) VALUES ('Alessandra da Silveira', 19);
INSERT INTO alunos (nome, idade) VALUES ('Alessandra da Silveira', 20);
INSERT INTO alunos (nome, idade) VALUES ('Cassio Huggentobler', 40);
INSERT INTO alunos (nome, idade) VALUES ('Cassio da Costa', 40);
INSERT INTO alunos (nome, idade) VALUES ('Cassio da Costa', 40);

INSERT INTO aluno_curso (id_aluno, id_curso) VALUES(1, 1);
INSERT INTO aluno_curso (id_aluno, id_curso) VALUES(2, 2);
INSERT INTO aluno_curso (id_aluno, id_curso) VALUES(1, 3);
INSERT INTO aluno_curso (id_aluno, id_curso) VALUES(2, 3);
INSERT INTO aluno_curso (id_aluno, id_curso) VALUES(3, 3);

SELECT * FROM cursos;
SELECT * FROM alunos;
SELECT * FROM aluno_curso;

SELECT * 
FROM alunos
JOIN aluno_curso
ON alunos.id = aluno_curso.id_aluno
JOIN cursos
ON cursos.id = aluno_curso.id_curso;

SELECT alunos.nome AS "Nome do Aluno", cursos.nome AS "Nome do Curso"
FROM alunos
JOIN aluno_curso
ON alunos.id = aluno_curso.id_aluno
JOIN cursos
ON cursos.id = aluno_curso.id_curso;

INSERT INTO alunos (
	nome,
	idade
) 
VALUES (
	'Aleatório',
	25
);

INSERT INTO cursos (
	nome,
	media_aprovacao
) 
VALUES (
	'Postgres',
	7
);

INSERT INTO aluno_curso (
	id_aluno,
	id_curso
)
VALUES (
	5,
	4
)

SELECT * FROM cursos;

UPDATE cursos
SET nome = 'PostgresSQL'
WHERE nome = 'Postgres';

UPDATE alunos 
SET id = 10
WHERE id = 2;

-- JOINS
SELECT alunos.nome AS "Nome do aluno", cursos.nome AS "Nome do Curso"
FROM alunos
JOIN aluno_curso
ON alunos.id = aluno_curso.id_aluno
JOIN cursos
ON cursos.id = aluno_curso.id_curso;

SELECT alunos.id AS "ID do Aluno",
alunos.nome AS "Nome do Aluno",
cursos.id AS "ID do Curso",
cursos.nome AS "Nome do Curso",
FROM alunos
JOIN aluno_curso
ON aluno_curso.id_aluno = alunos.id
JOIN cursos
ON aluno_curso.id_curso = cursos.id
ORDER BY alunos.nome ASC;

SELECT alunos.nome AS "Nome do aluno", cursos.nome AS "Nome do Curso"
FROM alunos
LEFT JOIN aluno_curso
ON alunos.id = aluno_curso.id_aluno
LEFT JOIN cursos
ON cursos.id = aluno_curso.id_curso;

SELECT alunos.nome AS "Nome do aluno", cursos.nome AS "Nome do Curso"
FROM alunos
RIGHT JOIN aluno_curso
ON aluno_curso.id_aluno = alunos.id
RIGHT JOIN cursos
ON aluno_curso.id_curso = cursos.id;

SELECT alunos.nome AS "Nome do aluno", cursos.nome AS "Nome do Curso"
FROM alunos
FULL JOIN aluno_curso
ON aluno_curso.id_aluno = alunos.id
FULL JOIN cursos
ON aluno_curso.id_curso = cursos.id;

SELECT alunos.nome AS "Nome do Aluno", cursos.nome AS "Nome do Curso"
FROM alunos
CROSS JOIN cursos;

-- SUM/COUNT
SELECT COUNT(id) AS "Quantidade de alunos" FROM alunos;

SELECT SUM(idade) AS "Soma de idades de todos os alunos" FROM alunos;

SELECT 
COUNT(id) AS "Quantidade de alunos",
SUM(idade) AS "Soma de idades de todos os alunos",
ROUND(AVG(idade),2) AS "Média de idades dos alunos"
FROM alunos;

-- GROUP BY
SELECT nome, idade
COUNT(id) AS "Nomes iguais mas idades diferentes"
FROM alunos
GROUP BY nome, idade
ORDER BY idade;

-- Quantos alunos estão matriculados em cada curso
SELECT cursos.nome,
COUNT(alunos.id) AS "Alunos matriculados"
FROM alunos
JOIN aluno_curso ON aluno_curso.id_aluno = alunos.id
JOIN cursos ON aluno_curso.id_curso = cursos.id
GROUP BY cursos.nome
ORDER BY cursos.nome ASC;

-- HAVING
-- Saber se existe algum curso sem alunos matriculados;
SELECT cursos.nome,
COUNT(alunos.id) AS "Alunos matriculados"
FROM cursos
LEFT JOIN aluno_curso ON aluno_curso.id_curso = cursos.id
LEFT JOIN alunos ON aluno_curso.id_aluno = alunos.id
GROUP BY cursos.nome
HAVING COUNT(alunos.id) = 0;

-- Saber quais cursos tem alunos matriculados;
SELECT cursos.nome,
COUNT(alunos.id) AS "Alunos matriculados"
FROM cursos
LEFT JOIN aluno_curso ON aluno_curso.id_curso = cursos.id
LEFT JOIN alunos ON aluno_curso.id_aluno = alunos.id
GROUP BY cursos.nome
HAVING COUNT(alunos.id) > 0;
