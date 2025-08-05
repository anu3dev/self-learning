/**
 * Stack means a collection of elements that follows the Last In First Out (LIFO) principle.
 * The last element added is the first one to be removed.
 * 
 * In JavaScript, we can implement a stack using an array using methods like
 * push() to add elements and pop() to remove them.
 */

class Stack {
    constructor() {
        this.stack = [];
    }

    // Push an element onto the stack
    push(element) {
        this.stack.push(element);
    }

    // Pop an element from the stack
    pop() {
        if(this.isEmpty()) {
            return "Stack is empty";
        }
        return this.stack.pop();
    }

    // Get the top element of the stack
    peek() {
        if(this.isEmpty()) {
            return "Stack is empty";
        }
        return this.stack[this.size() - 1];
    }

    // Check if the stack is empty
    isEmpty() {
        return this.size() === 0;
    }

    // Size of the stack
    size() {
        return this.stack.length;
    }
}

const stack1 = new Stack();

stack1.push(10); // Adds 10 to the stack
stack1.push(20); // Adds 20 to the stack
stack1.push(30); // Adds 30 to the stack

//console.log(stack1.peek()); // should output 30 (top element of the stack)
//console.log(stack1.size()); // should output 3 (number of elements in the stack)

stack1.pop(); // Removes 30

//console.log(stack1.peek()); // should output 20 (new top element after popping)
//console.log(stack1.size()); // should output 2 (number of elements after popping)

stack1.pop(); // Removes 20
stack1.pop(); // Removes 10

//console.log(stack1.isEmpty()); // should output true (stack is now empty)
//console.log(stack1.pop()); // should output "Stack is empty" (trying to pop from an empty stack)
//console.log(stack1.peek()); // should output "Stack is empty" (trying to peek at an empty stack)
//console.log(stack1.size()); // should output 0 (size of the empty stack)



/**
 * Ques 1 - reverse order of words in a string
 * Example: "Hello World" should become "World Hello"
 */
 
const reverseWordsOfString = (str) => {
    const revArr = str.split(" ").reverse();

    let reversedStr = "";

    if(revArr.length){
        for(let word of revArr) {
            if(word) {
                reversedStr += " " + word;
            }
        }
    } else {
        return reversedStr;
    }

	return reversedStr.trim(); // Remove trailing space
}
//console.log(reverseWordsOfString("I am a good boy")); // Output: "boy good a am I"
//console.log(reverseWordsOfString("   I am a     good boy   ")); // Output: "boy good a am I"

const reverseWordsOfStringUsingStack = (str) => {
    const words = str.split(" ");

    let reversedStr = "";

    while (words.length) {
        const current  = words.pop();

        if(current){
            reversedStr += " " + current;
        }
    }

    return reversedStr.trim(); // Remove trailing space
}
//console.log(reverseWordsOfStringUsingStack("I am a good boy")); // Output: "boy good a am I"
//console.log(reverseWordsOfStringUsingStack("   I am a     good boy   ")); // Output: "boy good a am I"



/**
 * Ques 2 - Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets are closed by the same type of brackets.
 * 2. Open brackets are closed in the correct order.
 * For example:
 * "()" is valid but "(]" is not.
 * "()[]{}" is valid but "(]" is not.
 * "{[]}" is valid but "(}" is not.
 */

const isValidParentheses = (s) => {
    const stack = [];

    for (let i = 0; i < s.length; i++) {
        const char = s[i];

        if(char === "(" || char === "{" || char === "["){
            stack.push(char);
        } else if(char === ")" || char === "}" || char === "]"){
            if(!stack.length){
                return false;
            }

            const top = stack.pop();

            if(
                ((char === ")" && top !== "(") ||
                (char === "}" && top !== "{") ||
                (char === "]" && top !== "["))
            ){
                return false;
            }
        }
    }

    return stack.length === 0; // If stack is empty, all brackets were matched
}
console.log(isValidParentheses("()")); // Output: true
console.log(isValidParentheses("()[]{}")); // Output: true
console.log(isValidParentheses("(]")); // Output: false
console.log(isValidParentheses("{[]}")); // Output: true
console.log(isValidParentheses("(}")); // Output: false
console.log(isValidParentheses("({[]}){}[]")); // Output: true
console.log(isValidParentheses("}({[]}){}[]")); // Output: false