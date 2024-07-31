class PriorityQueue {
  constructor() {
    this.items = [];
  }

  isEmpty() {
    return this.items.length === 0;
  }

  add(element, priority) {
    const qElement = new QElement(element, priority);
    let contain = false;
    for (let i = 0; i < this.items.length; i += 1) {
      if (this.items[i].priority > qElement.priority) {
        this.items.splice(i, 0, qElement);
        contain = true;
        break;
      }
    }
    if (!contain) {
      this.items.push(qElement);
    }
  }

  peek() {
    if (this.isEmpty()) {
      return 'No elements in Queue';
    }
    return this.items[0];
  }

  poll() {
    if (this.isEmpty()) {
      return 'Underflow';
    }
    return this.items.shift();
  }

  hasValue(args) {
    for (let i = 0; i < this.items.length; i += 1) {
      if (this.items[i].element === args) {
        return true;
      }
    }
    return false;
  }

  size() {
    if (this.isEmpty()) {
      return 'Underflow';
    }
    return this.items.length;
  }

  swap(a, b) {
    const tmp = this.items[a];
    this.items[a] = this.items[b];
    this.items[b] = tmp;
  }

  changePriority(firstTerm, secondTerm) {
    let i = 0;
    while (i < this.items.length) {
      if (this.items[i].element === firstTerm) {
        if (secondTerm < this.items[i].priority) {
          // move up
          this.items[i].priority = secondTerm;
          while (i > 0 && this.items[i - 1].priority > secondTerm) {
            this.swap(i - 1, i);
            i -= 1;
          }
        } else if (secondTerm > this.items[i].priority) {
          // move down
          this.items[i].priority = secondTerm;
          while (i < this.items.length - 1 && this.items[i + 1].priority < secondTerm) {
            this.swap(i + 1, i);
            i += 1;
          }
        }
        break;
      }
      i += 1;
    }
  }

  printPQueue() {
    let str = '';
    for (let i = 0; i < this.items.length; i += 1) { str += this.items[i].element + ' '; }
    return str;
  }
}

class QElement {
  constructor(element, priority) {
    this.element = element;
    this.priority = priority;
  }
}
const priorityQueue = new PriorityQueue(); 

export {
  PriorityQueue,
};
