/**
 * Ques 1 - find the subarray with the maximum sum and return its sum
 * example: Given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

const maxSubArray1 = (arr) => {
    let maxSum = arr[0]; // Initialize maxSum to the first element
    let startIdx = 0; // Initialize startIndex to 0
    let endIdx = 0; // Initialize endIndex to 0

    for (let i = 0; i < arr.length; i++){
        let currentSum = 0; // Initialize currentSum for each starting point
        for (let j = i; j < arr.length; j++){
            currentSum = currentSum + arr[j]; // Add the current element to currentSum
            if (currentSum > maxSum) {
                maxSum = currentSum; // Update maxSum if currentSum is greater
                startIdx = i; // Update start index
                endIdx = j; // Update end index
            }
        }
    }
    return { sum: maxSum, subArray: arr.slice(startIdx, endIdx + 1) }; // Return the maximum sum found along with start and end indices
}
//console.log(maxSubArray1([-2,1,-3,4,-1,2,1,-5,4])); // { sum: 6, subArray: [ 4, -1, 2, 1 ] }
// time complexity: O(n^2) - nested loops
// space complexity: O(1) - no extra space used for storing results



/**
 * Kadane's Algorithm - Optimized solution
 * This algorithm runs in O(n) time complexity.
 * It keeps track of the maximum sum ending at each position and updates the 
 * global maximum accordingly.
 */

const maxSubArray2 = (arr) => {
    let sum = 0;
    let max = arr[0]; // Initialize max to the first element

    for (let i = 0; i < arr.length; i++) {
        sum += arr[i]; // Add the current element to sum
        if (sum > max) {
            max = sum; // Update max if current sum is greater
        }
        if (sum < 0) {
            sum = 0; // Reset sum if it becomes negative
        }
    }
    return max;
}
console.log(maxSubArray2([-2,1,-3,4,-1,2,1,-5,4])); // 6
// time complexity: O(n)
// space complexity: O(1) - no extra space used for storing results