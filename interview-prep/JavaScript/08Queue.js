/**
 * Queue means a data structure that follows the First In First Out (FIFO) principle,
 * where elements are added to the back and removed from the front.
 * 
 * In JavaScript, we can implement a queue using an array with methods like
 * enqueue() to add elements and dequeue() to remove them.
 */

class Queue {
	constructor(){
		this.queue = [];
	}
	
	enqueue(element){
		this.queue.push(element);
	}
	
	dequeue(){
		if(this.isEmpty()){
			return "queue is empty";
		}
		return this.queue.shift();
	}
	
	front(){
		if(this.isEmpty()){
			return "queue is empty";
		}
		return this.queue[0];
	}

	size() {
        return this.queue.length;
    }
	
	printQueue(){
		let stringval = "";
		
		for(let i = 0; i < this.size(); i++){
			stringval += this.queue[i] + " ";
		}
		
		return stringval;
	}
	
	isEmpty(){
		this.size() === 0;
	}
}

const queue1 = new Queue();

queue1.enqueue(10);
queue1.enqueue(20);
queue1.enqueue(30);

console.log(queue1.size());
console.log(queue1.printQueue());
console.log(queue1.front());

queue1.dequeue();

console.log(queue1.size());
console.log(queue1.printQueue());
console.log(queue1.front());

