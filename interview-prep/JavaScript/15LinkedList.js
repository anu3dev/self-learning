/**
 * 
 * Linked list is a data structure consisting of a sequence of elements,
 * where each element (node) contains a value and a reference (or pointer) to the next node 
 * in the sequence.
 * 
 * Linked List implementation in JavaScript
 * This code defines a simple linked list with methods to add, remove, and display elements.
 */


class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
    }

    addFirst(data) {
        const newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    addLast(data){
        const newNode = new Node(data);

        if (!this.head) {
            this.head = newNode;
            return;
        }

        let current = this.head;
        while (current.next) {
            current = current.next;
        }
        current.next = newNode;
    }


    size() {
        let count = 0;
        let current = this.head;
        while (current) {
            count++;
            current = current.next;
        }
        return count;
    }


    addAt(index, data) {
        if (index < 0 || index > this.size()) {
            throw new Error("Invalid index");
        }

        const newNode = new Node(data);

        if (index === 0) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        let current = this.head;
        let count = 0;

        while (count < index - 1) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    removeTop(){
        if (!this.head) {
            throw new Error("List is empty");
        }
        this.head = this.head.next;
    }

    removeLast() {
        if (!this.head) {
            throw new Error("List is empty");
        }

        if (!this.head.next) {
            this.head = null;
            return;
        }

        let current = this.head;
        while (current.next && current.next.next) {
            current = current.next;
        }
        current.next = null;
    }

    removeAt(index) {
        if (index < 0 || index >= this.size()) {
            throw new Error("Invalid index");
        }

        if (index === 0) {
            this.head = this.head.next;
            return;
        }

        let current = this.head;
        let count = 0;
        while (count < index - 1) {
            current = current.next;
            count++;
        }
        current.next = current.next.next;
    }

    printList() {
        let current = this.head;
        while (current) {
            console.log("Linked List:", current.data);
            current = current.next;
        }
    }
}


const linkedList = new LinkedList();
linkedList.addFirst(10);
linkedList.addLast(20);
linkedList.addLast(30);
linkedList.addAt(1, 15);
// linkedList.printList(); // Linked List: 10, Linked List: 15, Linked List: 20, Linked List: 30

// console.log();
linkedList.removeTop();
// linkedList.printList(); // Linked List: 15, Linked List: 20, Linked List: 30

// console.log();
linkedList.removeLast();
// linkedList.printList(); // Linked List: 15, Linked List: 20

// console.log();
linkedList.addAt(1, 25);
linkedList.addAt(0, 5);
linkedList.removeAt(1);
// linkedList.printList(); // Linked List: 5, Linked List: 25, Linked List: 20



/**
 * Palindrome Linked List:
 * Given the head of a singly linked list, return true if it is a palindrome.
 * A palindrome is a word, phrase, number, or other sequence of characters that reads 
 * the same forward and backward (ignoring spaces, punctuation, and capitalization).
 */

function isPalindrome(head) {
    let string = '';
    let current = head;

    while(current) {
        string += current.data;
        current = current.next;
    }
    const reversed = string.split('').reverse().join('');
    return string === reversed;
}

const linkedList1 = new LinkedList();
linkedList1.addLast(1);
linkedList1.addLast(2);
linkedList1.addLast(2);
linkedList1.addLast(1);
//console.log(isPalindrome(linkedList1.head)); // true

const linkedList2 = new LinkedList();
linkedList2.addLast(1);
linkedList2.addLast(2);
linkedList2.addLast(3);
// console.log(isPalindrome(linkedList2.head)); // false



/**
 * Reverse Linked List:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

function reverseLinkedList(head) {
    let prev = null;
    let current = head;

    while (current) {
        let next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}

const linkedList3 = new LinkedList();
linkedList3.addLast(1);
linkedList3.addLast(2);
linkedList3.addLast(3);
// linkedList3.printList(); // Linked List: 1, Linked List: 2, Linked List: 3

// Reverse the linked list

const reversedHead = reverseLinkedList(linkedList3.head);
const reversedList = new LinkedList();
reversedList.head = reversedHead;
// reversedList.printList(); // Linked List: 3, Linked List: 2, Linked List: 1



/**
 * Add Two Numbers:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 */

class ListNode {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

function addTwoNumbers(l1, l2) {
    let dummyHead = new ListNode(0);
    let p = l1, q = l2, current = dummyHead;
    let carry = 0;

    while (p || q || carry) {
        let sum = (p ? p.value : 0) + (q ? q.value : 0) + carry;
        carry = Math.floor(sum / 10);
        current.next = new ListNode(sum % 10);
        current = current.next;

        if (p) p = p.next;
        if (q) q = q.next;
    }
    return dummyHead.next;
}

const l1 = new LinkedList();
l1.addLast(2);
l1.addLast(4);
l1.addLast(3);

const l2 = new LinkedList();
l2.addLast(5);
l2.addLast(6);
l2.addLast(4);

const result = addTwoNumbers(l1.head, l2.head);
const resultList = new LinkedList();
resultList.head = result;
resultList.printList(); // Linked List: 7, Linked List: 0, Linked List: 8



/**
 * LRU Cache:
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class with methods to get and put values.
 * 
 * The LRU Cache is a data structure that stores a limited number of items and evicts the least 
 * recently used item when the limit is reached.
 * 
 * The LRU Cache implementation in JavaScript uses a combination of a doubly linked list and a 
 * hash map to achieve O(1) time complexity for both get and put operations.
 * 
 * example is - https://github.com/piyush-eon/dsa-with-javascript-course/blob/master/%239%20-%20Linked%20List/4-lru-cache-singly-linked-list.js
 *  and https://www.youtube.com/watch?v=4dO29k0qVU4&list=PLKhlp2qtUcSZtJefDThsXcsAbRBCSTgW4&index=17
 */
