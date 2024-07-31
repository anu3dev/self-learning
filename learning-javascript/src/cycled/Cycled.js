class Cycled {
  constructor(generatorArray) {
    this.mainArray = generatorArray;
    this.position = 0;
  }

  * [Symbol.iterator]() {
    for (let i = 0; i < this.mainArray.length; i += 1) {
      yield this.mainArray[i];
    }
  }

  [Symbol.iterator]() {
    const subArrary = [];
    let start = this.position;
    let count = 0;
    while (count < this.mainArray.length) {
      subArrary.push(this.mainArray[start]);
      if (start === this.mainArray.length - 1) {
        start = 0;
      } else {
        start += 1;
      }
      count += 1;
    }
    return subArrary.values();
  }

  next() {
    if (this.position === this.mainArray.length - 1) {
      this.position = 0;
    } else {
      this.position += 1;
    }

    function* nextGenerator(obj) {
      yield obj.mainArray[obj.position];
    }

    return nextGenerator(this).next().value;
  }

  previous() {
    if (this.position === 0) {
      this.position = this.mainArray.length - 1;
    } else {
      this.position -= 1;
    }

    function* nextGenerator(obj) {
      yield obj.mainArray[obj.position];
    }

    return nextGenerator(this).next().value;
  }

  current() {
    function* currentGenerator(obj) {
      yield obj.mainArray[obj.position];
    }

    return currentGenerator(this).next().value;
  }

  step(stepBy) {
    function* stepGenerator(obj) {
      yield obj.mainArray[obj.position];
    }

    if (this.position + stepBy >= this.mainArray.length) {
      this.position -= this.mainArray.length - stepBy;
    } else {
      this.position += stepBy;
    }
    return stepGenerator(this).next().value;
  }

  get index() {
    return this.position;
  }

  set index(val) {
    if (val >= 0 && val <= this.mainArray.length) {
      this.position = val;
    }
  }

  indexOf(value) {
    return this.mainArray.indexOf(value);
  }

  * reversed() {
    yield this.mainArray[this.mainArray.length - 1 - this.position];
  }
}
export { Cycled };
