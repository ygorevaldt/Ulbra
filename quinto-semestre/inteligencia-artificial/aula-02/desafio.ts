let p1 = -1, p2 = -1, p3 = -1;

let sums = 0, adjusts = 0, totalAdjusts = 0, repetitions = 0;
let y = 0;

const training = [
    [0, 0, 0, 0], //laranja - cítrico
    [0, 0, 1, 0], //abacaxi - cítrico
    [0, 1, 0, 0], //morando - cítrico
    [0, 1, 1, 0], //kiwi - cítrico
    [1, 0, 0, 1], //mamão - doce
    [1, 0, 1, 1], //banana - doce
    [1, 1, 0, 1], //maça - doce
    [1, 1, 1, 1], //uva; - doce
];

// TREINANDO
do {
    adjusts = 0;

    training.forEach((values) => {
        let [x1, x2, x3, result] = values;
        checkIfAdjust(x1, x2, x3, result);
    });
} while (adjusts != 0);

console.log("Teste de aprendizagem com rede neural\n");
console.log(`Peso 1: ${p1}\n`);
console.log(`Peso 2: ${p2}\n`);
console.log(`Peso 3: ${p3}\n`);
console.log(`Foram necessários ${totalAdjusts} ajustes para treinar a rede.\n`);

function checkIfAdjust(
    x1: number,
    x2: number,
    x3: number,
    resultAwaited: number
) {
    sums = sum(x1, x2, x3);
    y = trasnference(sums);
    if (y != resultAwaited) {
        adjust(x1, x2, x3, resultAwaited, y);
        adjusts++;
        totalAdjusts++;
    }
}

function sum(x1: number, x2: number, x3: number): number {
    return (x1 * p1) + (x2 * p2) + (x3 * p3);
}

function trasnference(sum: number) {
    return (sum <= 0) ? 0 : 1;
}

function adjust(
    input1: number,
    input2: number,
    input3: number,
    retultAwaited: number,
    resultObteined: number
): void {
    p1 += 1 * (retultAwaited - resultObteined) * input1;
    p2 += 1 * (retultAwaited - resultObteined) * input2;
    p3 += 1 * (retultAwaited - resultObteined) * input3;
}