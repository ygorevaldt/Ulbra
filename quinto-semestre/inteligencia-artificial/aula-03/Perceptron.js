class Perceptron {
    numberOfInputs;
    weights;
    bias;
    learningRate = 0.1;

    constructor(numberOfInputs) {
        this.numberOfInputs = numberOfInputs;
        this.weights = [];
        this.bias = Math.random();

        this._fillWeights();
    }

    training(trainingData) {
        let adjust = true;

        while (adjust) {
            adjust = false;

            for (let i = 0; i < trainingData.length; i++) {
                let input = trainingData[i].input;
                let resultAwaited = trainingData[i].resultAwaited;

                let output = this.process(input);

                let error = resultAwaited - output;

                if (error === 0) continue;

                adjust = true;
                this._adjust(error, input);
            }
        }

        console.log("Neurônio treinado com sucesso");
    }

    process(input) {
        const weightedSum = this._sum(input);
        const output = this._activate(weightedSum);
        return output;
    }

    _adjust(error, input) {
        for (let i = 0; i < this.numberOfInputs; i++) {
            this.weights[i] += error * input[i] * this.learningRate;
        }
        this.bias += error * this.learningRate;
    }

    _sum(input) {
        let weightedSum = this.bias;
        for (let i = 0; i < this.numberOfInputs; i++) {
            weightedSum += input[i] * this.weights[i];
        }

        return weightedSum;
    }

    _activate(weightedSum) {
        return weightedSum < 0 ? 0 : 1;
    }

    _fillWeights() {
        for (let i = 0; i < this.numberOfInputs; i++) {
            this.weights.push(Math.random());
        }
    }
}

module.exports = Perceptron;