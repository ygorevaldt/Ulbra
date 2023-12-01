import express, { response } from "express";
import mysql, { createConnection } from "mysql";

import dotenv from "dotenv";
dotenv.config();

const app = express();
app.use(express.json());

const { DB_HOST, DB_PORT, DB_USER, DB_PASSWORD, DB_DATABASE, } = process.env;
const config = {
    host: DB_HOST,
    port: DB_PORT,
    user: DB_USER,
    password: DB_PASSWORD,
    database: DB_DATABASE
}
const connection = createConnection(config);
connection.connect((error) => {
    if (error) {
        console.error("Erro ao conectar ao banco de dados:", error);
        return;
    }
    console.log("Conexão bem-sucedida ao banco de dados");
});

// ROUTES
app.get("/", (req, res) => {
    res.status(200).send("Webservice online");
});

app.get("/atletas", async (req, res) => {
    connection.query("SELECT * FROM atleta", (error, response) => {
        if (error) {
            res.status(500).send("Internal server error");
            return;
        }
        if (!response[0]) {
            res.status(404).send("Nenhum atleta encontrado");
            return;
        }
        res.status(200).json(response);
    });
});

app.post("/atletas", (req, res) => {
    const { nome, idade, esporte, equipe } = req.body;
    connection.query(`INSERT INTO atleta (nome, idade, esporte, equipe) VALUES (?, ?, ?, ?)`, [nome, idade, esporte, equipe], (error, response) => {
        if (error) {
            res.send(400).send("Erro ao cadastrar atleta");
            return;
        }
        res.status(201).send("Created");
    });
});

app.delete("/atletas/:id", (req, res) => {
    const { id } = req.params;
    connection.query("DELETE FROM atleta WHERE id = ?", [id], (error, response) => {
        if (error) {
            res.send(500).send("Erro ao remover atleta")
            return;
        }
        res.status(200).send("Ok");
    })
})

const { API_BASE_URL, API_PORT } = process.env;
app.listen(API_PORT, () => {
    console.log(`Server on address ${API_BASE_URL}:${API_PORT}`);
});

