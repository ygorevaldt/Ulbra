class NeuralNetwork {
    #inputSize;
    #hiddenSize;
    #outputSize;
    #weightsInputToHiddenLayer = [];
    #weightsHiddenToOutputLayer = [];


    constructor({
        inputSize,
        hiddenSize,
        outputSize
    } = {}) {
        this.#inputSize = inputSize;
        this.#hiddenSize = hiddenSize;
        this.#outputSize = outputSize;

        this.#startWeightsInputToHiddenLayer();
        this.#startWeightsHiddenToOutputLayer();
    }

    training({
        trainingData = [],
        learningRate = 0.1,
        limit = 1000
    } = {}) {
        for (let i = 0; i < limit; i++) {
            for (let i = 0; i < trainingData.length; i++) {
                let input = trainingData[i].input;
                let resultAwaited = trainingData[i].resultAwaited;

                let { hiddenLayerOutput, finalOutput } = this.feedForward(input);

                let outputErrors = this.#calcOutputError(resultAwaited, finalOutput);
                let outputAdjusts = this.#calcAdjusts(outputErrors, finalOutput);

                this.#calcAdjustsWeightsHiddenToOutputLayer({
                    learningRate,
                    outputAdjusts,
                    hiddenLayerOutput
                });

                const hiddenLayerErrors = this.#calcHiddenLayerErrors(outputAdjusts);
                const hiddenAdjusts = this.#calcAdjustsWeightsInputToHiddenLayer({
                    hiddenLayerErrors,
                    hiddenLayerOutput
                });

                this.#adjustWeightsInputToHiddenLayer({
                    learningRate,
                    hiddenAdjusts,
                    input
                });
            }
        }
    }

    #adjustWeightsInputToHiddenLayer({
        learningRate,
        hiddenAdjusts,
        input
    } = {}) {
        for (let i = 0; i < this.#weightsInputToHiddenLayer.length; i++) {
            for (let j = 0; j < this.#weightsInputToHiddenLayer[i].length; j++) {
                this.#weightsInputToHiddenLayer[i][j] += learningRate * hiddenAdjusts[j] * input[i];
            }
        }
    }

    #calcAdjustsWeightsInputToHiddenLayer({
        hiddenLayerErrors,
        hiddenLayerOutput
    } = {}) {
        let hiddenAdjusts = [];
        for (let i = 0; i < hiddenLayerErrors.length; i++) {
            hiddenAdjusts.push(hiddenLayerErrors[i] * this.#sigmoideDerived(hiddenLayerOutput[i]));
        }

        return hiddenAdjusts;
    }

    #calcHiddenLayerErrors(outputAdjusts) {
        let hiddenErrors = [];
        for (let i = 0; i < this.#weightsHiddenToOutputLayer.length; i++) {
            let erro = 0;

            for (let j = 0; j < outputAdjusts.length; j++) {
                erro += outputAdjusts[j] * this.#weightsHiddenToOutputLayer[i][j];
            }

            hiddenErrors.push(erro);
        }

        return hiddenErrors;
    }

    #calcAdjustsWeightsHiddenToOutputLayer({
        learningRate,
        outputAdjusts,
        hiddenLayerOutput
    } = {}) {
        for (let i = 0; i < this.#weightsHiddenToOutputLayer.length; i++) {
            for (let j = 0; j < this.#weightsHiddenToOutputLayer[i].length; j++) {
                this.#weightsHiddenToOutputLayer[i][j] += learningRate * outputAdjusts[j] * hiddenLayerOutput[i];
            }
        }
    }

    #calcOutputError(resultAwaited, finalOutput) {
        const outputErrors = [];
        for (let i = 0; i < resultAwaited.length; i++) {
            outputErrors.push(resultAwaited[i] - finalOutput[i]);
        }

        return outputErrors;
    }

    #calcAdjusts(outputErrors, finalOutput) {
        let outputAdjusts = [];
        for (let i = 0; i < outputErrors.length; i++) {
            outputAdjusts.push(outputErrors[i] * this.#sigmoideDerived(finalOutput[i]));
        }

        return outputAdjusts;
    }

    feedForward(input) {
        const hiddenLayerOutput = this.#multiplyVetorByMatriz(
            input,
            this.#weightsInputToHiddenLayer
        ).map(this.#sigmoide);

        const finalOutput = this.#multiplyVetorByMatriz(
            hiddenLayerOutput,
            this.#weightsHiddenToOutputLayer
        ).map(this.#sigmoide);

        return ({
            hiddenLayerOutput,
            finalOutput
        });
    }

    #sigmoide(x) {
        return 1 / (1 + Math.exp(-x));
    }

    #sigmoideDerived(x) {
        return x * (1 - x);
    }

    #multiplyVetorByMatriz(activations, weights) {
        const results = [];

        for (let j = 0; j < weights[0].length; j++) {
            let sum = 0;

            for (let i = 0; i < activations.length; i++) {
                sum += activations[i] * weights[i][j];
            }

            results.push(sum);
        }

        return results;
    }

    #startWeightsInputToHiddenLayer() {
        for (let i = 0; i < this.#inputSize; i++) {
            let weights = this.#getWeights(this.#hiddenSize);
            this.#weightsInputToHiddenLayer.push(weights);
        }
    }

    #startWeightsHiddenToOutputLayer() {
        for (let i = 0; i < this.#hiddenSize; i++) {
            let weights = this.#getWeights(this.#outputSize);
            this.#weightsHiddenToOutputLayer.push(weights);
        }
    }

    #getWeights(size) {
        let weights = [];
        for (let i = 0; i < size; i++) {
            weights.push(Math.random() * 2 - 1);
        }

        return weights;
    }
}

module.exports = NeuralNetwork;