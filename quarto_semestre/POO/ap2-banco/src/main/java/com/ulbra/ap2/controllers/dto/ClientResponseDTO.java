package com.ulbra.ap2.controllers.dto;

public class ClientResponseDTO {
    private String nome;
    private int idade;
    private String profissao;

    public ClientResponseDTO(String nome, int idade, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getProfissao() {
        return profissao;
    }
}
