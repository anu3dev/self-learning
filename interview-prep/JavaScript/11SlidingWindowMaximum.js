/**
 * Sliding Window Maximum
 * You are given an array of integers nums, there is a sliding window of size 
 * k which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 *
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */
 
 const slidingWindowMax1 = (nums, k) => {
	if(!nums.length) 
		return "array is empty";
	
	if(k > nums.length) 
		return "k is greater than array size";
	
	let finalArr = [];
	
	for(let i = 0; i < nums.length - k + 1; i++){
        let maxVal = nums[i];
		for(let j = 0 + i; j < k + i; j++){
			if (maxVal < nums[j]){
				maxVal = nums[j];
			}
		}
		finalArr.push(maxVal);
	}
	return finalArr;
}
//console.log(slidingWindowMax1([1,3,-1,-3,5,3,6,7], 3))
//console.log(slidingWindowMax1([1,-1], 1))

// time complexity: O(n*k) where n is the length of the array and k is the size 
// of the sliding window means that in the worst case, we are doing k comparisons
// for each of the n elements in the array.
// space complexity: O(n) for the final array that stores the maximum values.

const slidingWindowMax2 = (nums, k) => {
    if(!nums.length) 
        return "array is empty";
    
    if(k > nums.length) 
        return "k is greater than array size";
    
    let finalArr = [];
    let deque = []; // to store indices of useful elements in the current window

    for(let i = 0; i < nums.length; i++) {
        // Remove elements not in the current window
        if(deque.length && deque[0] < i - k + 1) {
            deque.shift();
        }
        
        // Remove elements smaller than the current element
        while(deque.length && nums[deque[deque.length - 1]] < nums[i]) {
            deque.pop();
        }
        
        deque.push(i);
        
        // Add the maximum of the current window to the result
        if(i >= k - 1) {
            finalArr.push(nums[deque[0]]);
        }
    }
    return finalArr;
}
console.log(slidingWindowMax2([1,3,-1,-3,5,3,6,7], 3))
console.log(slidingWindowMax2([1,-1], 1))
// time complexity: O(n) where n is the length of the array. Each element is added 
// and removed from the deque at most once.
// space complexity: O(k) for the deque that stores indices of useful 
// elements in the current