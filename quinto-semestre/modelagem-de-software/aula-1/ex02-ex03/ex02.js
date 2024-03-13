/*
    Atividade 2: Modelagem de Praia

    Considere o seguinte cenário:
    Imagine que estamos desenvolvendo um aplicativo turístico e precisa representar a entidade Praia. Crie uma classe chamada Praia na linguagem que preferir com os seguintes atributos: nome, localizacao, temperaturaAgua e tipoAreia. Adicione um método chamado informacoesPraia que retorna uma string com todas as informações da praia. Em seguida, crie uma instância dessa classe e utilize o método informacoesPraia para exibir os detalhes da praia.
*/

class Beach {
    #name;
    #location;
    #waterTemperature;
    #sandType

    constructor({
        name,
        location,
        waterTemperature,
        sandType
    } = {}) {
        this.#name = name;
        this.#location = location;
        this.#waterTemperature = waterTemperature;
        this.#sandType = sandType;
    }

    get informations() {
        return `Nome: ${this.#name} - Localização: ${this.#location} - Temperatura da água: ${this.#waterTemperature} - Tipo de areia: ${this.#sandType}`;
    }
}

const beach = new Beach({
    name: "Curumim",
    location: "Av. Beira Mar, 6124-6404, Capão da Canoa RS, 95555-000",
    waterTemperature: "15ºc",
    sandType: "normal"
});

console.log("beach informations: ", beach.informations);