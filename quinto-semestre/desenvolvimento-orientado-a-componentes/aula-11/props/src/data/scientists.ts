import { Scientist } from "../types";

export const scientists: Scientist[] = [
    {
        name: "Maria Sklodowaska-Curie",
        imgPath: "https://upload.wikimedia.org/wikipedia/commons/7/7e/Marie_Curie_c1920.jpg",
        profession: "Física e química",
        discovered: "poionium (elemento químico)",
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
    }
]