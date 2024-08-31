const Perceptron = require("./Perceptron.js");

const trainingData = [
    { input: [0, 0, 0], resultAwaited: 0 },
    { input: [0, 0, 1], resultAwaited: 0 },
    { input: [0, 1, 0], resultAwaited: 0 },
    { input: [0, 1, 1], resultAwaited: 0 },
    { input: [1, 0, 0], resultAwaited: 1 },
    { input: [1, 0, 1], resultAwaited: 1 },
    { input: [1, 1, 0], resultAwaited: 1 },
    { input: [1, 1, 1], resultAwaited: 1 }
];

const neuron = new Perceptron(3);
neuron.training(trainingData);

const resultsAwaited = ["cítrica", "doce"];
const result = neuron.process([1, 1, 0]);

console.log(`A fruta informada é ${resultsAwaited[result]}`);




