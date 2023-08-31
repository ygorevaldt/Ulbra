-- 1- Crie uma view que mostra os detalhes dos livros
CREATE VIEW detalhes_livros AS
	SELECT li.LivroID, li.Titulo, a.NomeAutor 
		FROM livros li
        INNER JOIN autores a ON a.AutorID = li.AutorID;

SELECT * FROM detalhes_livros;

-- 2 - Crie uma view que mostra o número de livros por autor
CREATE VIEW numero_livros_por_autor AS
SELECT
    NomeAutor,
    (SELECT COUNT(l.AutorID) FROM Livros l WHERE l.AutorID = a.AutorID) AS NumeroDeLivros
FROM
    Autores a;

SELECT * FROM numero_livros_por_autor;

-- 3 - Crie uma view que mostra os livros de um autor específico
CREATE VIEW livros_por_autor AS
SELECT li.Titulo, a.NomeAutor
FROM livros li
JOIN autores a ON a.AutorID = li.AutorID
WHERE li.AutorID = 1;

SELECT * FROM livros_por_autor;

-- 4 - Criar uma View de Títulos Únicos de Livros
CREATE VIEW livros_titulos_unicos AS
SELECT DISTINCT Titulo FROM livros;

SELECT * FROM livros_titulos_unicos;

-- 5 - Criar uma View de Livros com Título Maior que N Caracteres
CREATE VIEW titulos_maiores_que_onze AS
SELECT titulo FROM livros WHERE char_length(Titulo) > 11;

SELECT * FROM titulos_maiores_que_onze;