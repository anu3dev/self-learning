// ways to declare a string
let str1 = "Hello, World!";
let str2 = 'Hello, World!';
let str3 = `Hello, World!`;
let str4 = new String("Hello, World!");

// template literal example
const name = "John";
const greeting = `Hello, ${name}!`;

/**
 * Ques 1 - Truncate a text
 * Write a function called truncate that checks the length of a string
 * and truncates it to a specified length, adding "..." if it exceeds that 
 * length.
 */

function truncate(text, length) {
    if (text.length > length) {
        return text.slice(0, length) + "...";
    }
    return text;
}
console.log(truncate("This is a long text that needs to be truncated.", 20));

/**
 * Ques 2 - Palindrome Check
 * Write a function called isPalindrome that checks if a given string is a palindrome.
 */

function isPalindromeString(str) {
    const cleaned = str.replace(/[^a-zA-Z0-9]/g, "").toLowerCase();
    const reversed = cleaned.split("").reverse().join("");
    return cleaned === reversed;
}
console.log(isPalindromeString("A man, a plan, a canal: Panama")); // true
console.log(isPalindromeString("race a car")); // false

function isPalindromeNumber(num) {
    if(num < 0) return false; // negative numbers are not palindromes
    if(num === 0) return true; // zero is a palindrome

    const str = num.toString();
    const reversed = str.split("").reverse().join("");
    return str === reversed;
}
console.log(isPalindromeNumber(121)); // true
console.log(isPalindromeNumber(123)); // false

/**
 * Ques 3 - Hamming Distance
 * Write a function called hammingDistance that calculates the Hamming distance
 * between two strings of equal length.
 */

function hammingDistance(str1, str2) {
    if (str1.length !== str2.length) {
        throw new Error("Strings must be of equal length");
    }

    let distance = 0;
    for (let i = 0; i < str1.length; i++) {
        if (str1[i] !== str2[i]) {
            distance++;
        }
    }
    return distance;
}
console.log(hammingDistance("karolin", "kathrin")); // 3
console.log(hammingDistance("1011101", "1001001")); // 2

/**
 * Ques - 4 - valid anagram
 * Write a function called isAnagram that checks if two strings are 
 * anagrams of each other
 */

function isAnagram1(str1, str2) {
    const normalize = (str) => str.toLowerCase().replace(/[^a-z]/g, "").split("").sort().join("");
    return normalize(str1) === normalize(str2);
}

console.log(isAnagram1("listen", "silent")); // true
console.log(isAnagram1("hello", "world")); // false

function isAnagram2(str1, str2) {
    if (str1.length !== str2.length) return false;
    const countChars = (str) => {   
        const count = {};
        for (const char of str) {
            count[char] = (count[char] || 0) + 1;
        }
        return count;
    }
    const count1 = countChars(str1);
    const count2 = countChars(str2);

    for (const char in count1) {
        if (count1[char] !== count2[char]) {
            return false;
        }
    }
    return true;
}

console.log(isAnagram2("listen", "silent")); // true
console.log(isAnagram2("hello", "world")); // false
