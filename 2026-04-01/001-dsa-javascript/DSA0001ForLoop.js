/**
 * Write a function that searches for an element in an array and returns the index, 
 * if the element is not present then return -1.
 */
const array1 = [4, 2, 0, 10, 8, 30];

const findIndexOfItemInAnArray = (arr, num) => {
    for(let i = 0; i < arr.length; i++){
        if(arr[i] === num){
            return i;
        }
    }
    return -1;
}
console.log(findIndexOfItemInAnArray(array1, 10))
console.log(findIndexOfItemInAnArray(array1, 9))



/**
 * write a function that returns the number of negative numbers in an array
 */
const array2 = [2, -9, 17, 0, 1, -10, -4, 8];

const countNegativeNumbersInAnArray = (arr) => {
    let count = 0;

    for(let i = 0; i < arr.length; i++){
        if(arr[i] < 0){
            count++;
        }
    }
    return count;
}
console.log(countNegativeNumbersInAnArray(array2));



/**
 * write a function that returns the largest number in an array
 */
const array3 = [5, 0, 7, 10, 8, 17, 1]

const largestNumberInAnArray = (arr) => {
    let largestNum = 0

    for(let i = 0; i < arr.length; i++){
        if(arr[i] > largestNum){
            largestNum = arr[i];
        }
    }

    return largestNum;
}
console.log(largestNumberInAnArray(array3))



/**
 * write a function that returns the largest number in an array, array can have negative numbers
 */
const array4 = [-13, -17, -5, -347, -5, -234444, -1]

const largestNumberInAnArrayWithNumbers = (arr) => {
    let largestNum = -Infinity

    for(let i = 0; i < arr.length; i++){
        if(arr[i] > largestNum){
            largestNum = arr[i];
        }
    }

    return largestNum;
}
console.log(largestNumberInAnArrayWithNumbers(array4))



/**
 * Find second largest number in an array
 */
const array5 = [4, 9, 0, 2, 8, 9, 7, 1]

const findSecondLargetNumberInAnArray = (arr) => {
    let largestNum = -Infinity
    let secondLargestNum = -Infinity

    for(let i = 0; i < arr.length; i++){
        if(arr[i] > largestNum){
            secondLargestNum = largestNum;
            largestNum = arr[i];
        } else if(arr[i] !== largestNum && arr[i] > secondLargestNum){
            secondLargestNum = arr[i]
        }
    }

    return secondLargestNum;
}
console.log(findSecondLargetNumberInAnArray(array5))

/**
 * Always ask interviewer for negative cases like -
 * what if array is empty.
 * what if array has only one element.
 * what if array has duplicates.
 * what if array has negative numbers.
 */ 