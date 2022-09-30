CREATE TABLE professores
(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nome VARCHAR(100) NOT NULL, 
  telefone VARCHAR(20),
  cpf VARCHAR(15) UNIQUE NOT NULL
);

CREATE TABLE disciplinas
(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nome VARCHAR(100) NOT NULL,
  id_professor INT NOT NULL,
  CONSTRAINT professor_ensina_disciplina
  FOREIGN KEY(id_professor) REFERENCES professores(id) 
 );

CREATE TABLE softwares
(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE uso_software_disciplina
(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id_disciplina INT NOT NULL,
  id_software INT NOT NULL,
  CONSTRAINT software_usa_disciplina
  FOREIGN KEY(id_software) REFERENCES softwares(id),
  CONSTRAINT disciplina_usa_software
  FOREIGN KEY(id_disciplina) REFERENCES disciplinas(id)
);

