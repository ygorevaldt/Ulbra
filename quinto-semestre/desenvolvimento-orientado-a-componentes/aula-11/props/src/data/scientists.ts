import { Scientist } from "../types";

export const scientists: Scientist[] = [
    {
        name: "Maria Sklodowaska-Curie",
        imgPath: "https://upload.wikimedia.org/wikipedia/commons/7/7e/Marie_Curie_c1920.jpg",
        profession: "Física e química",
        discovered: "Poionium (elemento químico)",
        awards: [
            { name: "Prêmio Nobel de Física" },
            { name: "Prêmio Nobel de Química " },
            { name: "Medalha Matteucci" }
        ]
    },
    {
        name: "Katsuko Saruhashi",
        imgPath: "https://th.bing.com/th/id/OIP.mfAacDPH6ZKs4bHbYNCbmAHaEd?rs=1&pid=ImgDetMain",
        profession: "Geoquímica",
        discovered: "Método para medir o dióxido de carbono na água do mar",
        awards: [
            { name: "Prêmio Miyke de geoquímica" },
            { name: "prêmio tanaka" }
        ]
    },
    {
        name: "Albert Einstein",
        imgPath: "https://upload.wikimedia.org/wikipedia/commons/d/d3/Albert_Einstein_Head.jpg",
        profession: "Físico teórico",
        discovered: "Teoria da Relatividade",
        awards: [
            { name: "Prêmio Nobel de Física" },
            { name: "Medalha Max Planck" }
        ]
    },
    {
        name: "Rosalind Franklin",
        imgPath: "https://upload.wikimedia.org/wikipedia/pt/9/97/Rosalind_Franklin.jpg",
        profession: "Química e cristalógrafa",
        discovered: "Estrutura do DNA",
        awards: [
            { name: "Prêmio Louisa Gross Horwitz" },
            { name: "Prêmio BUNSEN" }
        ]
    },
    {
        name: "Nikola Tesla",
        imgPath: "https://upload.wikimedia.org/wikipedia/commons/d/d4/N.Tesla.JPG",
        profession: "Engenheiro elétrico e inventor",
        discovered: "Corrente Alternada (CA)",
        awards: [
            { name: "Medalha Edison" },
            { name: "Grande Cruz da Ordem de São Sava" }
        ]
    },
    {
        name: "Ada Lovelace",
        imgPath: "https://upload.wikimedia.org/wikipedia/commons/a/a4/Ada_Lovelace_portrait.jpg",
        profession: "Matemática e escritora",
        discovered: "Primeiro algoritmo de computador",
        awards: [
            { name: "O Mês Ada Lovelace" },
            { name: "Medalha Augusta Ada King" }
        ]
    }
]