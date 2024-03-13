/*
    Atividade 3: Sistema de Reservas de Voos

    Considere o seguinte cenário:
    Você está desenvolvendo um sistema de reservas de voos e precisa modelar a entidade Voo. Crie uma classe chamada Voo na linguagem que preferir que represente a estrutura de um voo. A classe deve ter os seguintes atributos: companhiaAerea, origem, destino, dataPartida e precoPassagem. Adicione um método chamado informacoesVoo que retorne uma string com todas as informações do voo. Crie uma instância dessa classe, atribuindo valores aos atributos, e utilize o método informacoesVoo para exibir os detalhes do voo.
*/

class Flight {
    #airline;
    #origin;
    #destination;
    #startDate;
    #ticketPrice;

    constructor({
        airline,
        origin,
        destination,
        startDate,
        ticketPrice,
    } = {}) {
        this.#airline = airline;
        this.#origin = origin;
        this.#destination = destination;
        this.#startDate = startDate;
        this.#ticketPrice = ticketPrice;
    }

    get informations() {
        return `Companhia aérea: ${this.#airline} - Origem: ${this.#origin} - Destino: ${this.#destination} - Data de partida: ${this.#startDate} - preço da passagem: ${this.#ticketPrice}`;
    }
}

const flight = new Flight({
    airline: "GOL",
    origin: "Porto Alegre",
    destination: "Patagônia",
    startDate: new Date("2024-03-22"),
    ticketPrice: 2000
});

console.log("Flight informations: ", flight.informations);