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



/**
 * Ques 6 - Second Largest Number
 * Find the second largest number in an array of numbers.
 */
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



/**
 * Ques 7 - Rotate Array by K Steps
 * Given an array and a number k, rotate the array to the right by k steps.
 * Example: Given arr = [1, 2, 3, 4, 5] and k = 2,
 * the array should be rotated to [4, 5, 1, 2, 3].
 * Note: If k is non-negative, the array is rotated to the right.
 */
 