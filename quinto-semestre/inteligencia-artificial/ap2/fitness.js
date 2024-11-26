module.exports = class Fitness {
  constructor(route) {
    this.route = route;
    this.distance = 0;
    this.fitness = 0.0;
  }

  routeDistance() {
    if (this.distance === 0) {
      let pathDistance = 0;
      for (let i = 0; i < this.route.length; i++) {
        const fromCity = this.route[i];
        const toCity =
          i + 1 < this.route.length ? this.route[i + 1] : this.route[0];
        pathDistance += fromCity.distance(toCity);
      }
      this.distance = pathDistance;
    }
    return this.distance;
  }

  routeFitness() {
    if (this.fitness === 0) {
      this.fitness = 1 / this.routeDistance();
    }
    return this.fitness;
  }
};
