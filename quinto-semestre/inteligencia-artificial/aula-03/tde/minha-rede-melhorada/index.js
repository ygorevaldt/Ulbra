const NeuralNetwork = require("./rede-neural-multicamadas.js");

const neuralNetwork = new NeuralNetwork({
    inputSize: 3,
    hiddenSize: 4,
    outputSize: 1
});

let trainingData = [
    { input: [0, 0, 0], resultAwaited: [0] },
    { input: [0, 0, 1], resultAwaited: [0] },
    { input: [0, 1, 0], resultAwaited: [0] },
    { input: [0, 1, 1], resultAwaited: [0] },
    { input: [1, 0, 0], resultAwaited: [1] },
    { input: [1, 0, 1], resultAwaited: [1] },
    { input: [1, 1, 0], resultAwaited: [1] },
    { input: [1, 1, 1], resultAwaited: [1] }
];

neuralNetwork.training({
    trainingData
});

console.log(neuralNetwork.feedForward([0, 0, 0]).finalOutput); //Resultado = [ 0.03709795912511977 ]
console.log(neuralNetwork.feedForward([1, 1, 1]).finalOutput); //Resultado = [ 0.9800835036988698 ]