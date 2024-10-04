import { Question } from "../models/question";
import { Recomendation } from "../models/recomendation";
import { Response } from "../models/response";

export const questions: Question[] = [
    new Question({
        id: 1,
        title: "Você prefere livros de ficção ou não-ficção?",
        responses: [
            new Response({
                value: "Sim",
                redirectToQuestion: 2
            }),
            new Response({
                value: "Não",
                redirectToQuestion: 9
            })
        ]
    }),
    new Question({
        id: 2,
        title: "Você gosta de histórias com elementos fantásticos ou de ficção científica?",
        responses: [
            new Response({
                value: "Sim",
                redirectToQuestion: 3
            }),
            new Response({
                value: "Não",
                redirectToQuestion: 6
            })
        ]
    }),
    new Question({
        id: 3,
        title: "Você prefere fantasia épica com vários personagens e mundos complexos?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "O Senhor dos Anéis",
                    author: "J.R.R. Tolkien"
                })
            }),
            new Response({
                value: "Não",
                redirectToQuestion: 4
            })
        ]
    }),
    new Question({
        id: 4,
        title: "Você gosta de ficção científica com foco em tecnologia e espaço?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "Duna",
                    author: "Frank Herbert"
                })
            }),
            new Response({
                value: "Não",
                redirectToQuestion: 5
            })
        ]
    }),
    new Question({
        id: 5,
        title: "Você prefere uma fantasia mais leve com foco em magia e aventura?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "Harry Potter",
                    author: "J.K. Rowling"
                })
            }),
            new Response({
                value: "Não",
                recomendation: new Recomendation({
                    title: "Coraline",
                    author: "Neil Gaiman"
                })
            })
        ]
    }),
    new Question({
        id: 6,
        title: "Você gosta de histórias com mistério e suspense?",
        responses: [
            new Response({
                value: "Sim",
                redirectToQuestion: 7
            }),
            new Response({
                value: "Não",
                redirectToQuestion: 8
            })
        ]
    }),
    new Question({
        id: 7,
        title: "Você prefere histórias com investigações criminais e suspense psicológico?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "O Silêncio dos Inocentes",
                    author: "Thomas Harris"
                })
            }),
            new Response({
                value: "Não",
                recomendation: new Recomendation({
                    title: "Assassinato no Expresso do Oriente",
                    author: "Agatha Christie"
                })
            })
        ]
    }),
    new Question({
        id: 8,
        title: "Você prefere romances contemporâneos focados em relacionamentos e emoções?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "Um Dia",
                    author: "David Nicholls"
                })
            }),
            new Response({
                value: "Não",
                recomendation: new Recomendation({
                    title: "O Sol é para Todos",
                    author: "Harper Lee"
                })
            })
        ]
    }),
    new Question({
        id: 9,
        title: "Você está buscando um livro de desenvolvimento pessoal ou biografia?",
        responses: [
            new Response({
                value: "Sim",
                redirectToQuestion: 10
            }),
            new Response({
                value: "Não",
                redirectToQuestion: 13
            })
        ]
    }),
    new Question({
        id: 10,
        title: "Você prefere livros de autoajuda com foco em produtividade e sucesso?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "Os 7 Hábitos das Pessoas Altamente Eficazes",
                    author: "Stephen Covey"
                })
            }),
            new Response({
                value: "Não",
                redirectToQuestion: 11
            })
        ]
    }),
    new Question({
        id: 11,
        title: "Você prefere biografias de grandes líderes ou personalidades históricas?",
        responses: [
            new Response({
                value: "Sim",
                redirectToQuestion: 12
            }),
            new Response({
                value: "Não",
                recomendation: new Recomendation({
                    title: "Mindset: A Nova Psicologia do Sucesso",
                    author: "Carol S. Dweck"
                })
            })
        ]
    }),
    new Question({
        id: 12,
        title: "Você gostaria de ler a biografia de um inventor ou empreendedor?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "Steve Jobs",
                    author: "Walter Isaacson"
                })
            }),
            new Response({
                value: "Não",
                recomendation: new Recomendation({
                    title: "Leonardo da Vinci",
                    author: "Walter Isaacson"
                })
            })
        ]
    }),
    new Question({
        id: 13,
        title: "Você está interessado em livros sobre ciência ou história?",
        responses: [
            new Response({
                value: "Sim",
                redirectToQuestion: 14
            }),
            new Response({
                value: "Não",
                redirectToQuestion: 16
            })
        ]
    }),
    new Question({
        id: 14,
        title: "Você gosta de livros sobre ciência e exploração do universo?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "Cosmos",
                    author: "Carl Sagan"
                })
            }),
            new Response({
                value: "Não",
                redirectToQuestion: 15
            })
        ]
    }),
    new Question({
        id: 15,
        title: "Você prefere história, com foco em eventos e figuras históricas?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "Sapiens: Uma Breve História da Humanidade",
                    author: "Yuval Noah Harari"
                })
            }),
            new Response({
                value: "Não",
                recomendation: new Recomendation({
                    title: "O Gene: Uma História Íntima",
                    author: "Siddhartha Mukherjee"
                })
            })
        ]
    }),
    new Question({
        id: 16,
        title: "Você gosta de livros de filosofia ou sociologia?",
        responses: [
            new Response({
                value: "Sim",
                recomendation: new Recomendation({
                    title: "O Mundo de Sofia",
                    author: "Jostein Gaarder"
                })
            }),
            new Response({
                value: "Não",
                recomendation: new Recomendation({
                    title: "A Revolução dos Bichos",
                    author: "George Orwell"
                })
            })
        ]
    })
];