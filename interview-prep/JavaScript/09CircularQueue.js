/**
 * Circular Queue meaning that when the end of the queue is reached, it wraps 
 * around to the front.
 * This implementation uses a fixed-size array to represent the queue.
 * It uses FIFO (First In First Out) principle.
 */

let MyCircularQueue = (k) => {
    this.queue = [];
    this.size = k;
}

MyCircularQueue.prototype.enqueue = (value) => {
    if (this.queue.length < this.size) {
        this.queue.push(value);
    } else {
        return "Queue is full";
    }
};

MyCircularQueue.prototype.dequeue = () => {
    if (this.queue.length === 0) {
        return "Queue is empty";
    }
    return this.queue.shift();
};

MyCircularQueue.prototype.front = () => {
    if (this.queue.length === 0) {
        return "Queue is empty";
    }
    return this.queue[0];
};

MyCircularQueue.prototype.rear = () => {
    if (this.queue.length === 0) {
        return "Queue is empty";
    }
    return this.queue[this.queue.length - 1];
};

MyCircularQueue.prototype.isEmpty = () => {
    return this.queue.length === 0;
};

MyCircularQueue.prototype.isFull = () => {
    return this.queue.length === this.size;
};

const circularQueue = new MyCircularQueue(5);
console.log(circularQueue.isEmpty()); // true

circularQueue.enqueue(10);
console.log(circularQueue.front(), circularQueue.rear()); // 10 10

circularQueue.enqueue(20);
console.log(circularQueue.front(), circularQueue.rear()); // 10 20

circularQueue.enqueue(30);
circularQueue.enqueue(40);
circularQueue.enqueue(50);

console.log(circularQueue.isFull()); // true

circularQueue.enqueue(60); // "Queue is full"

circularQueue.dequeue();

console.log(circularQueue.front(), circularQueue.rear()); // 20 50
