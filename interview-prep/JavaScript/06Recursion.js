/**
 * Recursion is a powerful programming technique where a function calls itself to solve smaller instances of the same problem.
 * This is often used to break down complex problems into simpler ones.
 */

// Write a recursive function to calculate the factorial of a number.
const factorial = (num) => {
	if(num === 0) return 1;
	return num * factorial(num - 1);
}
//console.log(factorial(5)); // Output: 120

// Create an array with range of numbers from 1 to n using recursion.
const arrayWithRangeOfNumbers = (startNum, endNum) => {
	if(startNum > endNum) return [];
	const arr = arrayWithRangeOfNumbers(startNum, endNum - 1);
	arr.push(endNum);
	return arr;
}
//console.log(arrayWithRangeOfNumbers(1, 5)); // Output: [1, 2, 3, 4, 5]

// Write a recursive function to reverse a string.
const reverseString = (str) => {
	if(str.length === 0) return "";
    return str[str.length - 1] + reverseString(str.slice(0, -1)); 
}
//console.log(reverseString("anurag")); // Output: "garuna"

// Accessing elements in an array or string using index.
[1, 2, 3, 4, 6][3]; // Output: 4
"anurag"[3]; // Output: "r"

/**
 * The slice() method returns a part of an array or string, without changing the original.
 * It takes two arguments: start index (inclusive) and end index (exclusive).
 * If end is not given, it slices to the end. Negative indexes count from the end.
 * 
 * Slice does shallow copying, meaning it does not modify the original array or string.
 */

// String examples:
const str = "hello";
str.slice(1);    // "ello" (from index 1 to the end)
str.slice(1, 4); // "ell" (from index 1 to 3)
str.slice(0, 2); // "he" (from index 0 to 1)

str.slice(-2);   // "lo" (last 2 characters)
str.slice(0, -1); // "hell" (up to but not including the last character)

// Write a recursive function to check if a string is a palindrome.
const isPalindrome = (str) => {
	if (str.length <= 1) return true;
	if (str[0] !== str[str.length - 1]) return false;
	return isPalindrome(str.slice(1, -1));
}
//console.log(isPalindrome("racecar")); // Output: true

// Write a recursive function to find the nth Fibonacci number 
// like 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
const fibonacci = (num) => {
	if(num < 0) return "invalid input";
	if(num <= 1) return num;
	return fibonacci(num - 1) + fibonacci(num - 2);
}
//console.log(fibonacci(9)); // Output: 34

// Given an integer array nums of unique elements, return all possible subsets (the power set).
const subsets = (nums) => {
	const result = [];
    const backtrack = (start, path) => {
        result.push([...path]);
        for (let i = start; i < nums.length; i++) {
            path.push(nums[i]);
            backtrack(i + 1, path);
            path.pop();
        }
    };
    backtrack(0, []);
    return result; 
}
console.log(subsets([1, 2, 3])); // Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]