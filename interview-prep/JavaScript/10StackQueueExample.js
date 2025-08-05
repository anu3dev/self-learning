/**
 * Ques 1 - implement stack using queue
 * Implement LIFO using two queues
 * The implementation should support push, pop, top, and isEmpty methods.
 */

let myStack = function() {
    this.queue1 = [];
    this.queue2 = [];
};

myStack.prototype.push = function(value) {
    while (this.queue1.length > 0) {
        this.queue2.push(this.queue1.shift());
    }
    this.queue1.push(value);
    while (this.queue2.length > 0) {
        this.queue1.push(this.queue2.shift());
    }
}

myStack.prototype.pop = function() {
    if (this.queue1.length === 0) {
        return null;
    }
    return this.queue1.shift();
}

myStack.prototype.top = function() {
    if (this.queue1.length === 0) {
        return null;
    }
    return this.queue1[0];
}

myStack.prototype.print = function() {
    let stringval = "";
    
    for (let i = 0; i < this.queue1.length; i++) {
        stringval += this.queue1[i] + " ";
    }

    return stringval.trim();
}

let stack = new myStack();

stack.push(10);
stack.push(20);
stack.push(30);

console.log(stack.top()); // 30
console.log(stack.print()); // "30 20 10"

stack.pop();

console.log(stack.top()); // 20
console.log(stack.print()); // "20 10"



/**
 * Ques 2 - implement queue using stack
 * Implement FIFO using two stacks
 * The implementation should support enqueue, dequeue, front, and isEmpty methods.
 */

let MyQueue = function() {
    this.stack1 = [];
    this.stack2 = [];
}

MyQueue.prototype.enqueue = function(value) {
    this.stack1.push(value);
}

MyQueue.prototype.dequeue = function() {
    if (this.stack2.length === 0) {
        while (this.stack1.length > 0) {
            this.stack2.push(this.stack1.pop());
        }
    }
    return this.stack2.pop();
}

MyQueue.prototype.front = function() {
    if (this.stack2.length > 0) {
        return this.stack2[this.stack2.length - 1];
    }
    return this.stack1[0];
}

MyQueue.prototype.print = function() {
    let stringval = "";
    
    for (let i = 0; i < this.stack1.length; i++) {
        stringval += this.stack1[i] + " ";
    }
    
    for (let i = this.stack2.length - 1; i >= 0; i--) {
        stringval += this.stack2[i] + " ";
    }

    return stringval.trim();
}

let queue = new MyQueue();

queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);

console.log(queue.front()); // 10
console.log(queue.print()); // "10 20 30"

queue.dequeue();

console.log(queue.front()); // 20
console.log(queue.print()); // "20 30"



/**
 * Ques 3 - implement stack using circular queue
 * Implement LIFO using a circular queue
 * The implementation should support push, pop, top, and isEmpty methods.
 */

let MyCircularQueue = function(size) {
    this.queue = new Array(size);
    this.front = 0;
    this.rear = 0;
    this.size = size;
    this.count = 0;
}

MyCircularQueue.prototype.push = function(value) {
    if (this.count === this.size) {
        return false;
    }
    this.queue[this.rear] = value;
    this.rear = (this.rear + 1) % this.size;
    this.count++;
    return true;
}

MyCircularQueue.prototype.pop = function() {
    if (this.count === 0) {
        return null;
    }
    let value = this.queue[this.front];
    this.front = (this.front + 1) % this.size;
    this.count--;
    return value;
}

MyCircularQueue.prototype.top = function() {
    if (this.count === 0) {
        return null;
    }
    return this.queue[(this.rear - 1 + this.size) % this.size];
}

MyCircularQueue.prototype.isEmpty = function() {
    return this.count === 0;
}

MyCircularQueue.prototype.print = function() {
    let stringval = "";
    for (let i = 0; i < this.count; i++) {
        stringval += this.queue[(this.front + i) % this.size] + " ";
    }
    return stringval.trim();
}

let circularQueue = new MyCircularQueue(5);

circularQueue.push(10);
circularQueue.push(20);
circularQueue.push(30);

console.log(circularQueue.top()); // 30
console.log(circularQueue.print()); // "10 20 30"

circularQueue.pop();

console.log(circularQueue.top()); // 20
console.log(circularQueue.print()); // "10 20"