CREATE TABLE curso
(
    nomecurso SERIAL PRIMARY KEY,
    valorcredito NUMERIC(12,2)
);

INSERT INTO curso (nomecurso, valorcredito) VALUES ('curso 01', 10);
INSERT INTO curso (nomecurso, valorcredito) VALUES ('curso 02', 08);
INSERT INTO curso (nomecurso, valorcredito) VALUES ('curso 03', 12);
INSERT INTO curso (nomecurso, valorcredito) VALUES ('curso 04', 07);
INSERT INTO curso (nomecurso, valorcredito) VALUES ('curso 05', 20);
INSERT INTO curso (nomecurso, valorcredito) VALUES ('curso 06', 10);

SELECT nomecurso, valorcredito 
FROM curso 
WHERE valorcredito = (select min(valorcredito) from curso);

SELECT nomecurso AS "nome do curso"
FROM curso
JOIN valor

id_aluno INTEGER NOT NULL,
FOREIGN KEY (id_aluno)
REFERENCES Alunos (id_aluno) 
    ON UPDATE CASCADE 
    ON DELETE RESTRICT

SELECT turmas.id_turma,
disciplinas.nome AS "Nome da disciplina",
turmas.sala AS "Sala"
FROM Turmas 
INNER JOIN disciplinas ON turmas.id_turma = disciplinas.id_turma;
