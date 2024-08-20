const list = [
    { x1: 0, x2: 0, result: 0 },
    { x1: 0, x2: 1, result: 0 },
    { x1: 1, x2: 0, result: 1 },
    { x1: 1, x2: 1, result: 1 }
]

let p1 = -1, p2 = -1;

let sums = 0, adjusts = 0, totalAdjusts = 0, repetitions = 0;
let y = 0;

do {
    adjusts = 0;

    list.forEach(({ x1, x2, result }) => {
        checkIfAdjust(x1, x2, result);
    });

} while (adjusts != 0);

console.log("Teste de aprendizagem com rede neural\n");
console.log(`Peso 1: ${p1}\n`);
console.log(`Peso 2: ${p2}\n`);
console.log(`Foram necessários ${totalAdjusts} ajustes para treinar a rede.\n`);

function checkIfAdjust(
    x1: number,
    x2: number,
    resultAwaited: number
) {
    sums = sum(x1, x2);
    y = trasnference(sums);
    if (y != resultAwaited) {
        adjust(x1, x2, resultAwaited, y);
        adjusts++;
        totalAdjusts++;
    }
}

function sum(x1: number, x2: number): number {
    return (x1 * p1) + (x2 * p2);
}

function trasnference(sum: number) {
    return (sum <= 0) ? 0 : 1;
}

function adjust(
    input1: number,
    input2: number,
    retultAwaited: number,
    resultObteined: number
): void {
    p1 += 1 * (retultAwaited - resultObteined) * input1;
    p2 += 1 * (retultAwaited - resultObteined) * input2;
}
