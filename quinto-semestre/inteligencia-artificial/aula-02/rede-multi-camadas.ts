import { InputWeigth } from "./types";
import { speedLimit, ramp, sigmoid } from "./utils";

const input_weights: InputWeigth[] = [
    { input: -1, weight: 0 },
    { input: 1, weight: -1 },
    { input: 1, weight: 2 }
];

let functionChoiced = "FS";
let y = 0;

switch (functionChoiced) {
    case "LR":
        y = speedLimit(sum(input_weights));
        break;
    case "FR":
        y = ramp(sum(input_weights));
        break;
    case "FS":
        y = sigmoid(sum(input_weights));
        break;
    default:
        console.error("Opção inválida");
        break;
}

console.log(`Saída ${y} , função utilizada: ${functionChoiced}`);

function sum(input_weights: InputWeigth[]) {
    let sum = 0;

    input_weights.forEach(element => {
        sum += (element.input * element.weight);
    });

    return sum;
}
