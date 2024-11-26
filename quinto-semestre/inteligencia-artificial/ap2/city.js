module.exports = class City {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }

  distance(toCity) {
    return Math.sqrt((this.x - toCity.x) ** 2 + (this.y - toCity.y) ** 2);
  }

  toString() {
    return `(${this.x}, ${this.y})`;
  }
};
