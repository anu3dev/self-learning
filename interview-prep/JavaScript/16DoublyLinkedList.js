/**
 * Doubly linked list is a data structure that consists of nodes where each node contains a
 * reference to the next and previous node.
 * 
 * Doubly Linked List implementation in JavaScript
 * This code defines a simple doubly linked list with methods to add, remove, and display elements.
 */
class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    constructor() {
        this.head = null;
    }

    addFirst(data) {
        const newNode = new Node(data);
        
        newNode.next = this.head;

        if (this.head) {
            this.head.prev = newNode;
        }
        this.head = newNode;
    }

    addLast(data) {
        const newNode = new Node(data);

        if (!this.head) {
            this.head = newNode;
            return;
        }

        let current = this.head;
        while (current.next) {
            current = current.next;
        }

        newNode.prev = current;
        current.next = newNode;
    }
}

// https://www.youtube.com/watch?v=4FvRJ8T8Izw&list=PLKhlp2qtUcSZtJefDThsXcsAbRBCSTgW4&index=18