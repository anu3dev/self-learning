// Primitive Data Types in JavaScript
let num = 42;                   // Number
let str = "Hello";              // String
let bool = true;                // Boolean
let und = undefined;            // Undefined
let nul = null;                 // Null
let sym = Symbol("id");         // Symbol
let bigInt = 9007199254740991n; // BigInt



// Non-Primitive (Reference) Data Types in JavaScript
let arrObj = [1, 2, 3];            // Array (Object)
let obj = { name: "Alice" };    // Object
let func = function() {};       // Function (Object)
let date = new Date();          // Date (Object)
let regex = /abc/;              // RegExp (Object)



// Example: typeof operator
console.log(typeof num);        // "number"
console.log(typeof str);        // "string"
console.log(typeof arr);        // "object"
console.log(typeof obj);        // "object"
console.log(typeof func);       // "function"



// Arrays declaaration and initialization
const arr = [10, 20, 30, 40];                       // Array of numbers
const arr1 = ["one", "two", "three", "four"];       // Array of strings



// arrays can have any kind of data type, it can be mixed as well.
const arr3 = [1, "two", true, null, undefined, { key: "value" }, [1, 2, 3]];



// Creating arrays using different methods
const arr4 = new Array(3);                                  // [undefined, undefined, undefined]
const arr5 = new Array(10, 20, 30);                         // [10, 20, 30]
const arr6 = Array.from({ length: 4 }, (_, i) => i + 1);    // [1, 2, 3, 4]
const arr7 = Array.of(1, 2, 3, 4);                          // [1, 2, 3, 4]



const arr8 = ["apple", "banana", "cherry"];



// add or remove last element from the array
arr8.push("date");              // ["apple", "banana", "cherry", "date"]
arr8.pop();                     // ["apple", "banana", "cherry"]



// add or remove first element from the array
arr8.unshift("apricot");        // ["apricot", "apple", "banana", "cherry"]
arr8.shift();                   // ["apple", "banana", "cherry"] 



// for loop to iterate through the array
for (let i = 0; i < arr8.length; i++) {
    console.log(arr8[i]);       // prints each element of the array
}



// while loop to iterate through the array
let i = 0;
while (i < arr8.length) {
    console.log(arr8[i]);       // prints each element of the array
    i++;
}



// inbuilt loop methods to iterate through the array
const arr9 = [9, 11, 8, 4, 7, 5];



// map method
// return a new array with same size as original and applies condition on each element
arr9.map((item, index) => {
    console.log(item, index);   // prints each element
})



// forEach method
// does not return a new array, just executes the function on each element
arr9.forEach((item, index) => {
    console.log(item, index);   // prints each element
})



// filter method
// returns a new array with elements that pass the test
console.log(arr9.filter(item => item > 5));             // prints [9, 11, 8, 7]



// reduce method
// reduces the array to a single value by applying a function on each element
console.log(arr9.reduce((acc, item) => acc + item, 0)); // prints 44



// some method
// checks if at least one element passes the test
console.log(arr9.some(item => item > 10));              // prints true



// every method
// checks if all elements pass the test
console.log(arr9.every(item => item > 0));              // prints true



// find method
// returns the first element that passes the test
console.log(arr9.find(item => item > 5));               // prints 9



// spread and rest operator
const arr10 = [1, 2, 3];
const arr11 = [4, 5, 6];



// spread operator to combine arrays
console.log([...arr10, ...arr11]);               // [1, 2, 3, 4, 5, 6]



// rest operator to collect arguments
const logFruits = (...fruits) => {
    console.log("Fruits:", fruits);
}
logFruits("apple", "banana", "cherry"); // Fruits: [ 'apple', 'banana', 'cherry' ]



// concat method
// combines two or more arrays
console.log(arr10.concat(arr11));              // [1, 2, 3, 4, 5, 6]



// slice method
// returns a shallow copy of a portion of an array into a new array object
console.log([9, 6, 5, 2, 8].slice(1, 4));                // [6, 5, 2]
// [6, 5, 2] (elements from index 1 to 3 are included, index 4 is excluded)



// splice method
// changes the contents of an array by removing or replacing existing elements and/or adding new elements
let arr12 = [9, 6, 5, 2, 8, 9];
console.log(arr12.splice(1, 2, 20, 30)); 
// [6, 5] (removes 2 elements starting from index 1 and adds 20, 30)
console.log(arr12); // [9, 20, 30, 2, 8, 9]



// fill method
// fills all the elements of an array from a start index to an end index with a static value
let arr13 = [1, 2, 3, 4, 5];
console.log(arr13.fill(0, 1, 4)); // [1, 0, 0, 0, 5]
console.log(arr13.fill(7)); // [7, 7, 7, 7, 7] 



// indexOf method
// returns the first index at which a given element can be found in the array, or -1 if it is not present
const arr14 = [1, 2, 3, 4, 3, 5];
console.log(arr14.indexOf(3)); // returns 2 (first occurrence of 3
console.log(arr13.indexOf(10)); // returns -1 (not found)



// flat method
// creates a new array with all sub-array elements concatenated into it recursively up to the specified
const arr15 = [1, 2, [3, 4, [5, 6]]];
console.log(arr15.flat()); // [1, 2, 3, 4, [5, 6]]
console.log(arr15.flat(2)); // [1, 2, 3, 4, 5, 6]



// reverse method
// reverses the elements of an array in place
const arr16 = [1, 2, 3, 4, 5];
console.log(arr16.reverse()); // [5, 4, 3, 2, 1]



// sort method
// sorts the elements of an array in place and returns the sorted array
const arr17 = [5, 3, 8, 1, 2];
console.log(arr17.sort()); // [1, 2, 3, 5, 8]



/**
 * In JavaScript, there are several types of objects:
 *
 * 1. Standard (Built-in) Objects:
 *    - Object (base object)
 *    - Array
 *    - Function
 *    - Date
 *    - RegExp (regular expressions)
 *    - Error
 *    - Map
 *    - Set
 *    - WeakMap
 *    - WeakSet
 *    - Promise
 *
 * 2. User-defined Objects:
 *    - Objects you create using object literals, constructors, or classes.
 *
 * 3. Special Objects:
 *    - Math
 *    - JSON
 *    - Global objects (like window in browsers)
 */

 
 
