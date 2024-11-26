const City = require("./city");
const Fitness = require("./fitness");

function createRoute(cityList) {
  const route = [...cityList].sort(() => 0.5 - Math.random());
  return route;
}

function initialPopulation(popSize, cityList) {
  const population = [];
  for (let i = 0; i < popSize; i++) {
    population.push(createRoute(cityList));
  }
  return population;
}

function rankRoutes(population) {
  const fitnessResults = {};
  for (let i = 0; i < population.length; i++) {
    fitnessResults[i] = new Fitness(population[i]).routeFitness();
  }

  return Object.entries(fitnessResults)
    .sort(([, fitnessA], [, fitnessB]) => fitnessB - fitnessA)
    .map(([index, fitness]) => [parseInt(index), fitness]);
}

function selection(popRanked, eliteSize) {
  const selectionResults = [];
  const cumulativeFitness = popRanked.reduce(
    (acc, [, fitness], index) => [...acc, (acc[index - 1] || 0) + fitness],
    []
  );

  for (let i = 0; i < eliteSize; i++) {
    selectionResults.push(popRanked[i][0]);
  }

  for (let i = 0; i < popRanked.length - eliteSize; i++) {
    const pick = Math.random() * cumulativeFitness[popRanked.length - 1];
    for (let j = 0; j < popRanked.length; j++) {
      if (pick <= cumulativeFitness[j]) {
        selectionResults.push(popRanked[j][0]);
        break;
      }
    }
  }

  return selectionResults;
}

function matingPool(population, selectionResults) {
  const matingpool = [];
  for (let i = 0; i < selectionResults.length; i++) {
    const index = selectionResults[i];
    matingpool.push(population[index]);
  }
  return matingpool;
}

function breed(parent1, parent2) {
  let child = [];
  let childP1 = [];
  let childP2 = [];

  let geneA = Math.floor(Math.random() * parent1.length);
  let geneB = Math.floor(Math.random() * parent1.length);

  let startGene = Math.min(geneA, geneB);
  let endGene = Math.max(geneA, geneB);

  for (let i = startGene; i < endGene; i++) {
    childP1.push(parent1[i]);
  }

  childP2 = parent2.filter((item) => !childP1.includes(item));

  return childP1.concat(childP2);
}

function breedPopulation(matingpool, eliteSize) {
  const children = [];
  const length = matingpool.length - eliteSize;
  const pool = [...matingpool].sort(() => 0.5 - Math.random());

  for (let i = 0; i < eliteSize; i++) {
    children.push(matingpool[i]);
  }

  for (let i = 0; i < length; i++) {
    const child = breed(pool[i], pool[pool.length - i - 1]);
    children.push(child);
  }

  return children;
}

function mutate(individual, mutationRate) {
  for (let swapped = 0; swapped < individual.length; swapped++) {
    if (Math.random() < mutationRate) {
      let swapWith = Math.floor(Math.random() * individual.length);
      while (swapWith === swapped) {
        swapWith = Math.floor(Math.random() * individual.length);
      }

      const city1 = individual[swapped];
      const city2 = individual[swapWith];

      individual[swapped] = city2;
      individual[swapWith] = city1;
    }
  }
  return individual;
}

function mutatePopulation(population, mutationRate) {
  const mutatedPop = [];

  for (let ind = 0; ind < population.length; ind++) {
    const mutatedInd = mutate(population[ind], mutationRate);
    mutatedPop.push(mutatedInd);
  }
  return mutatedPop;
}

function nextGeneration(currentGen, eliteSize, mutationRate) {
  const popRanked = rankRoutes(currentGen);
  const selectionResults = selection(popRanked, eliteSize);
  const matingpool = matingPool(currentGen, selectionResults);
  const children = breedPopulation(matingpool, eliteSize);
  const nextGeneration = mutatePopulation(children, mutationRate);
  return nextGeneration;
}

function geneticAlgorithm(
  population,
  popSize,
  eliteSize,
  mutationRate,
  generations
) {
  let pop = initialPopulation(popSize, population);
  console.log("Distância Inicial: " + (1 / rankRoutes(pop)[0][1]).toFixed(2));

  for (let i = 0; i < generations; i++) {
    pop = nextGeneration(pop, eliteSize, mutationRate);
    console.log(
      "Distância da Geração " +
        (i + 1) +
        ": " +
        (1 / rankRoutes(pop)[0][1]).toFixed(2)
    );
  }

  console.log("Distância Final: " + (1 / rankRoutes(pop)[0][1]).toFixed(2));
  const bestRouteIndex = rankRoutes(pop)[0][0];
  const bestRoute = pop[bestRouteIndex];
  console.log("Melhor rota:", bestRoute);
  return bestRoute;
}

const cityList = [
  new City(60, 200),
  new City(180, 200),
  new City(80, 180),
  new City(140, 180),
  new City(20, 160),
  new City(100, 160),
  new City(200, 160),
  new City(140, 140),
  new City(40, 120),
  new City(100, 120),
  new City(180, 100),
  new City(60, 80),
  new City(120, 80),
  new City(180, 60),
  new City(20, 40),
  new City(100, 40),
  new City(200, 40),
  new City(20, 20),
  new City(60, 20),
  new City(160, 20),
];

geneticAlgorithm(cityList, 200, 40, 0.02, 1000);
