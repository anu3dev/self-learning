/**
 * Explain linear and binary search algorithms.
 * Linear search checks each element in a list sequentially until it finds 
 * the target value or reaches the end of the list.
 * 
 * Binary search, on the other hand, requires a sorted list and works by 
 * repeatedly dividing the search interval in half. If the target value is 
 * less than the middle element, the search continues in the lower half, 
 * otherwise it continues in the upper half. 
 * 
 * This makes binary search much more efficient than linear search for large
 * datasets.
 */



/**
 * Ques 1 - Implement linear search algorithm.
 * write to function to search "target" in nums. If found, return the index, 
 * otherwise return -1.
 */

const linearSearch = (nums, target) => {
	for(let i = 0; i < nums.length; i++){
		if(target === nums[i])
			return i;
	}
	return -1;
}
// time complexity: O(n)
// space complexity: O(1)
//console.log(linearSearch([1, 2, 3, 4, 5], 5)); // Output: 4
//console.log(linearSearch([1, 2, 3, 4, 5], 6)); // Output: -1



/** 
 * Ques 2 - Implement global linear search algorithm.
 * write to function to search "target" in nums. If found, return the indices,
 * otherwise return an empty array.
 */
 
const globalLinearSearch = (nums, target) => {
	const arr = [];
	for(let i = 0; i < nums.length; i++){
		if(target === nums[i])
			arr.push(i);
	}
	return arr.length ? arr : -1;
}
// time complexity: O(n)
// space complexity: O(1)
//console.log(globalLinearSearch([1, 2, 3, 4, 5], 5)); // Output: [4]
//console.log(globalLinearSearch([1, 2, 3, 4, 5, 7, 8, 5, 2, 5], 5)); // Output: [4, 7, 9]
//console.log(globalLinearSearch([1, 2, 3, 4, 5], 6)); // Output: []



/**
 * Ques 3 - Implement binary search algorithm.
 * write to function to search "target" in nums. If found, return the index,
 * otherwise return -1.
 * Note: nums must be sorted in ascending order.
 */

const binarySearch = (nums, target) => {
    let start = 0;
    let end = nums.length - 1;

    while (start <= end) {
        let mid = Math.floor((start + end) / 2);

        if(nums[mid] === target) {
            return mid; // Target found
        } else if (nums[mid] < target) {
            start = mid + 1; // Search in the right half
        } else {
            end = mid - 1; // Search in the left half
        }
    }
    return -1; // Target not found
}
// time complexity: O(log n) bcos exponential reduction of search space
// space complexity: O(1)
//console.log(binarySearch([1, 2, 3, 4, 5], 5)); // Output: 4
//console.log(binarySearch([1, 2, 3, 4, 5], 6)); // Output: -1



/**
 * Ques 4 - Kth missing positive integer.
 * Given an array of positive integers arr and an integer k, return the kth
 * missing positive integer.
 */

const findKthMissingPositive = (arr, k) => {
	let count = 0;

    for (let i = 0; i < arr.length; i++) {
        if(arr[i] <= k + count) {
            count++;
        }
    }
    return k + count;
}

// time complexity: O(n) where n is the length of the array
// space complexity: O(1)
//console.log(findKthMissingPositive([2, 3, 4, 7, 11], 5)); // Output: 9
//console.log(findKthMissingPositive([1, 2, 3, 4], 2)); // Output: 6



/**
 * Ques 5 - Maximum Count of Positive Integer and Negative Integer Given 
 * an array nums sorted in non-decreasing order, return the maximum between 
 * the number of positive integers and the number of negative integers.
 * 
 * Input: nums = [-2,-1,-1,1,2,3]  ----->>>>>  Output: 3
 * Explanation: There are 3 positive integers and 3 negative integers. 
 * The maximum count among them is 3.
 */

function maximumCount(nums) {
  return Math.max(upperBound(nums), lowerBound(nums));
}

function upperBound(nums) {
  let low = 0,
    high = nums.length - 1;

  while (low < high) {
    let mid = Math.ceil((low + high) / 2);
    if (nums[mid] < 0) low = mid;
    else high = mid - 1;
  }

  return nums[0] >= 0 ? 0 : low + 1;
}

function lowerBound(nums) {
  let low = 0,
    high = nums.length - 1;

  while (low < high) {
    let mid = Math.floor((low + high) / 2);
    if (nums[mid] > 0) high = mid;
    else low = mid + 1;
  }

  return nums[nums.length - 1] <= 0 ? 0 : nums.length - low;
}
console.log(maximumCount([-2, -1, -1, 1, 2, 3])); // Output: 3
console.log(maximumCount([-3, -2, -1, 0, 1, 2])); // Output: 3
console.log(maximumCount([-1, -1, -1, -1])); // Output: 0
console.log(maximumCount([1, 2, 3, 4])); // Output: 4
console.log(maximumCount([0, 0, 0, 0])); // Output: 0
console.log(maximumCount([-5, 1, 2, 3, 4])); // Output: 4
