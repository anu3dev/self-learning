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
//console.log(typeof num);        // "number"
//console.log(typeof str);        // "string"
//console.log(typeof arr);        // "object"
//console.log(typeof obj);        // "object"
//console.log(typeof func);       // "function"

/**
 * Ques 1 - Palindrome Number
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is a palindrome, as well as 12321. 
 * Negative numbers are not palindromes.
 */

const isPalindrome1 = (x) => {
    // Convert the number to a string
    const str = x.toString();
    // Check if the string is equal to its reverse
    return str === str.split('').reverse().join('');
}
//console.log(isPalindrome1(121), isPalindrome1(-121), isPalindrome1(10), isPalindrome1(12321)); 
// true, false, false, true

const isPalindrome2 = (x) => {
    // enhanced version
    return x < 0 ? false : (x === +x.toString().split('').reverse().join(''));
}
//console.log(isPalindrome2(121), isPalindrome2(-121), isPalindrome2(10), isPalindrome2(12321)); 
// true, false, false, true

/**
 * Ques 2 - Fibonacci Number
 * Fibonacci Series -> 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
 * F(0) = 0, F(1) = 1
 * F(n) = F(n-1) + F(n-2), for n > 1
 */

const fibonacci1 = (n) => {
    if (n < 0) return "Invalid input";
    if (n <= 1) return n;

    let a = 0, b = 1, c;
    for (let i = 2; i <= n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return c;
}
//console.log(fibonacci1(0), fibonacci1(1), fibonacci1(2), fibonacci1(3), fibonacci1(4), fibonacci1(5));
// 0, 1, 1, 2, 3, 5

const fibonacci2 = (n) => {
    if (n < 0) return "Invalid input";
    if (n <= 1) return n;

    return fibonacci2(n - 1) + fibonacci2(n - 2);
}
//console.log(fibonacci2(0), fibonacci2(1), fibonacci2(2), fibonacci2(3), fibonacci2(4), fibonacci2(5));
// 0, 1, 1, 2, 3, 5

/**
 * Ques 3 - Valid Anagram
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * For example, "anagram" is an anagram of "nagaram".
 */

const isAnagram1 = (s, t) => {
    // Convert strings to arrays, sort them, and join back to strings
    return s.split('').sort().join('') === t.split('').sort().join('');   
}
//console.log(isAnagram1("anagram", "nagaram"), isAnagram1("rat", "car"), isAnagram1("listen", "silent"));
// true, false, true

const isAnagram2 = (s, t) => {
    if (s.length !== t.length) return false; // Quick check for length
  
    let ob1 = {};
    let ob2 = {};

    for (let char of s) {
        ob1[char] = (ob1[char] || 0) + 1; // Count occurrences of each character in s
    }
    for (let char of t) {
        ob2[char] = (ob2[char] || 0) + 1; // Count occurrences of each character in t
    }
    // Compare the two objects
    for (let key in ob1) {
        if (ob1[key] !== ob2[key]) {
            return false; // If counts don't match, not an anagram
        }
    }
    return true; // If all counts match, it is an anagram
}
//console.log(isAnagram2("anagram", "nagaram"), isAnagram2("rat", "car"), isAnagram2("listen", "silent"));
// true, false, true

/**
 * Ques 4 - Two Sum
 * Given an array of integers and a target integer, return the indices of the two numbers such that
 * they add up to the target.
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * return [0, 1] because nums[0] + nums[1] = 2 + 7 = 9.
 */

const twoSum1 = (nums, target) => {
    // Using a brute force approach to find the two indices
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === target) {
                return [i, j]; // Return the indices of the two numbers
            }
        }
    }
    return []; // Return an empty array if no solution is found 
}
//console.log(twoSum1([2, 7, 11, 15], 26)); // [0, 3]

const twoSum2 = (nums, target) => {
    const obj = {}; // Using an object to store the indices of the numbers
    for (let i = 0; i < nums.length; i++) {
    // Using a hash map to find the two indices in a single pass
        const complement = target - nums[i]; // Calculate the complement
        if (obj[complement] !== undefined) {
            return [obj[complement], i]; // If complement exists, return the indices
        }
        obj[nums[i]] = i; // Store the index of the current number
    } 
}
//console.log(twoSum2([2, 7, 11, 15], 26)); // [0, 3]

/**
 * Ques 5 - Best Time to Buy and Sell Stock
 * Given an array where the ith element is the price of a given stock on day i, 
 * wamt to maximize your profit by choosing a single day to buy one stock and choosing a 
 * different day in the future to sell that stock.
 * Example: Given prices = [7, 1, 5, 3, 6, 4], return 5 because buying on day 2 (price = 1) 
 * and selling on day 5 (price = 6) is a profit of 6-1 = 5, which is the maximum profit.
 * [7, 1, 5, 3, 6, 4] -> 5
 * [5, 4, 3, 2, 1] -> 0
 */

const maxprofit1 = (prices) => {
    let globalProfit = 0; // Initialize global profit to 0

    for(let i = 0; i < prices.length; i++) {
        for (let j = i + 1; j < prices.length; j++) {
            const profit = prices[j] - prices[i]; // Calculate profit
            if (profit > globalProfit) {
                globalProfit = profit; // Update global profit if current profit is greater
            }
        }
    }

    return globalProfit; // Return the maximum profit found
}
//console.log(maxprofit1([7, 2, 5, 3, 6, 4, 1, 9]), maxprofit1([5, 4, 3, 2, 1]), maxprofit1([2,4,1]));

const maxprofit2 = (prices) => {
    let minPrice = prices[0] || 0; // Initialize minPrice to a very high value
    let profit = 0; // Initialize maxProfit to 0

    for (let i = 0; i < prices.length; i++) {
        if (prices[i] < minPrice) {
            minPrice = prices[i]; // Update minPrice if current price is lower
        } else if (prices[i] - minPrice > profit) {
            profit = prices[i] - minPrice; // Update maxProfit if current profit is greater
        }
    }

    return profit; // Return the maximum profit found
} 
//console.log(maxprofit2([7, 2, 5, 3, 6, 4, 1, 9]), maxprofit2([5, 4, 3, 2, 1]), maxprofit2([2,4,1]));

const someOperation = (n) => {
    return (n * (n + 5)) / 2;           // 3
}
// total operation = 3 => O(1) time complexity

const GoingUpDown = (n) => {
    console.log("Going up");            // 1
    for (let i = 0; i < n; i++) {
        console.log(i);                 // n     
    }
    console.log("Going down");          // 1
    for (let i = n - 1; i >= 0; i--) {
        console.log(i);                 // n
    }  
    console.log("Done");                // 1
}
// Total operation = 2n + 3 = 2n = O(n) time complexity

const printBoth = (n) => {
    for (let i = 0; i < n; i++) {       // n
        for (let j = 0; j < n; j++) {   // n
            console.log(i, j);          // n^2               
        }                 
    }
}
//Total operation = n^2 = O(n^2) time complexity

const sumOfArr = (arr) => {
    let sum = 0;                       
    for (let i = 0; i < arr.length; i++) { 
        sum += arr[i];                 
    }
    return sum;                         
}
// Total operation = since output is not dependent on input size, it is O(1) space complexity.

const funnyNumberArray = (n) => {
    const arr = [];                       
    for (let i = 0; i < n; i++) { 
        for (let j = 0; j < arr.length; j++) { 
            arr.push(i + j); // O(n^2) operation    
        }
    }
    return arr;                         
}
// Total operation = O(n^2) time complexity, O(n) space complexity.

const createMatrix = (n) => {
    const matrix = [];
    for (let i = 0; i < n; i++) {
        const row = [];
        for (let j = 0; j < n; j++) {
            row.push(i * j);
        }
        matrix.push(row);
    }
    return matrix;
}
// Total space used = n * n = O(n^2) space complexity.

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
    //console.log(arr8[i]);       // prints each element of the array
}

// while loop to iterate through the array
let i = 0;
while (i < arr8.length) {
    //console.log(arr8[i]);       // prints each element of the array
    i++;
}

// inbuilt loop methods to iterate through the array
const arr9 = [9, 11, 8, 4, 7, 5];

// map method
// return a new array with same size as original and applies condition on each element
arr9.map((item, index) => {
    //console.log(item, index);   // prints each element
})

// forEach method
// does not return a new array, just executes the function on each element
arr9.forEach((item, index) => {
    //console.log(item, index);   // prints each element
})

// filter method
// returns a new array with elements that pass the test
//console.log(arr9.filter(item => item > 5));             // prints [9, 11, 8, 7]

// reduce method
// reduces the array to a single value by applying a function on each element
//console.log(arr9.reduce((acc, item) => acc + item, 0)); // prints 44

// some method
// checks if at least one element passes the test
//console.log(arr9.some(item => item > 10));              // prints true

// every method
// checks if all elements pass the test
//console.log(arr9.every(item => item > 0));              // prints true

// find method
// returns the first element that passes the test
//console.log(arr9.find(item => item > 5));               // prints 9

// spread and rest operator
const arr10 = [1, 2, 3];
const arr11 = [4, 5, 6];

// spread operator to combine arrays
//console.log([...arr10, ...arr11]);               // [1, 2, 3, 4, 5, 6]

// rest operator to collect arguments
const logFruits = (...fruits) => {
    console.log("Fruits:", fruits);
}
//logFruits("apple", "banana", "cherry"); // Fruits: [ 'apple', 'banana', 'cherry' ]

// concat method
// combines two or more arrays
//console.log(arr10.concat(arr11));              // [1, 2, 3, 4, 5, 6]

// slice method
// returns a shallow copy of a portion of an array into a new array object
//console.log([9, 6, 5, 2, 8].slice(1, 4));                // [6, 5, 2]
// [6, 5, 2] (elements from index 1 to 3 are included, index 4 is excluded)

// splice method
// changes the contents of an array by removing or replacing existing elements and/or adding new elements
let arr12 = [9, 6, 5, 2, 8, 9];
//console.log(arr12.splice(1, 2, 20, 30)); 
// [6, 5] (removes 2 elements starting from index 1 and adds 20, 30)
//console.log(arr12); // [9, 20, 30, 2, 8, 9]

// fill method
// fills all the elements of an array from a start index to an end index with a static value
let arr13 = [1, 2, 3, 4, 5];
//console.log(arr13.fill(0, 1, 4)); // [1, 0, 0, 0, 5]
//console.log(arr13.fill(7)); // [7, 7, 7, 7, 7] 

// indexOf method
// returns the first index at which a given element can be found in the array, or -1 if it is not present
const arr14 = [1, 2, 3, 4, 3, 5];
//console.log(arr14.indexOf(3)); // returns 2 (first occurrence of 3
//console.log(arr13.indexOf(10)); // returns -1 (not found)

// flat method
// creates a new array with all sub-array elements concatenated into it recursively up to the specified
const arr15 = [1, 2, [3, 4, [5, 6]]];
//console.log(arr15.flat()); // [1, 2, 3, 4, [5, 6]]
//console.log(arr15.flat(2)); // [1, 2, 3, 4, 5, 6]

// reverse method
// reverses the elements of an array in place
const arr16 = [1, 2, 3, 4, 5];
//console.log(arr16.reverse()); // [5, 4, 3, 2, 1]

// sort method
// sorts the elements of an array in place and returns the sorted array
const arr17 = [5, 3, 8, 1, 2];
//console.log(arr17.sort()); // [1, 2, 3, 5, 8]

// Ques 1 - Second Largest Number
// Find the second largest number in an array of numbers.

const findSecondLargestNumber1 = (arr) => {
    // Set is a built-in object that lets you store unique values of any type.
    // It automatically removes duplicates.
    // dont use sort(), always use sort(a, b) => (a - b))
    // because sort() converts numbers to strings and sorts them lexicographically.
    const sortedArr = [...new Set(arr)].sort((a, b) => (b - a));
    if(sortedArr.length > 1) {
        return sortedArr[1]; 
    } else {
        return null;
    }
    // set has time complexity of O(n) for insertion and O(n) for conversion to array.
    // sort has time complexity of O(n log n).
    // Overall time complexity is O(n log n) and Space complexity is O(n).
}
//console.log(findSecondLargestNumber1([10, 2, 1, 12, 5, 3, 10, 12])); // Output: 5

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

const findSecondLargestNumber2 = (arr) => {
    let largest = Number.NEGATIVE_INFINITY
    let secondLargest = Number.NEGATIVE_INFINITY;
    for (let num of arr) { // time complexity O(n) and space complexity O(1)
        if(num > largest) {
            secondLargest = largest;
            largest = num;
        } else if(num > secondLargest && num != largest) {
            secondLargest = num;
        }
    }
    return secondLargest
}
//console.log(findSecondLargestNumber2([10, 2, 1, 12, 5, 3, 10, 12])); // Output: 5

