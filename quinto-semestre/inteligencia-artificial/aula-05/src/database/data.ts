import { Question } from "../models/question";
import { Response } from "../models/response";

export const questions: Question[] = [
    new Question({
        title: "É homen?",
        response: new Response({
            yes: new Question({
                title: "Ele joga futebol?",
                response: new Response({
                    yes: new Question({
                        title: "Ele é goleiro?",
                        response: new Response({
                            yes: "Julio Cezar",
                            no: "Neymar Jr"
                        })
                    }),
                    no: "Lucas Saraiva"
                })
            })
        })
    }),
    new Question({
        title: "É mulher?",
        response: new Response({
            yes: new Question({
                title: "Ela é famosa?",
                response: new Response({
                    yes: new Question({
                        title: "Ela é modelo?",
                        response: new Response({
                            yes: "Gisele Bündchen",
                            no: "Margot Robbie"
                        })
                    }),
                    no: "Alessandra Silveira"
                })
            })
        })
    }),
    new Question({
        title: "É personagem animado?",
        response: new Response({
            yes: new Question({
                title: "Ele é do Dragon Ball?",
                response: new Response({
                    yes: new Question({
                        title: "Ele é o protagonista?",
                        response: new Response({
                            yes: "Goku",
                            no: "Vegeta"
                        })
                    }),
                    no: new Question({
                        title: "Ele é ninja?",
                        response: new Response({
                            yes: "Naruto",
                            no: "Pikachu"
                        })
                    })
                })
            })
        })
    }),
    new Question({
        title: "É um animal?",
        response: new Response({
            yes: new Question({
                title: "Ele é o melhor amigo do homem?",
                response: new Response({
                    yes: new Question({
                        title: "Ele é um cão de raça grande?",
                        response: new Response({
                            yes: "Pastor Alemão",
                            no: "Poodle"
                        })
                    }),
                    no: new Question({
                        title: "Ele é selvagem?",
                        response: new Response({
                            yes: "Leão",
                            no: "Vaca"
                        })
                    })
                })
            })
        })
    })
];