/***
 * Ques 1 - Implement bubble sort algorithm.
 * Bubble sort is a simple sorting algorithm that repeatedly steps through the list,
 * compares adjacent elements and swaps them if they are in the wrong order.
 * The pass through the list is repeated until the list is sorted.
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 * 
 * Write a function to sort the array in ascending order.
 * If the array is already sorted, return the same array.
 * If the array is empty, return an empty array.
 */
const bubbleSort = (arr) => {
    if (arr.length === 0) return [];

    const n = arr.length;

    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]]
            }
        }
    }    

    return arr;
}
//console.log(bubbleSort([5, 4, 3, 2, 1])); // Output: [1, 2, 3, 4, 5]



/**
 * Ques 2 - Implement selection sort algorithm.
 * Selection sort is a simple sorting algorithm that divides the input list into two parts:
 * a sorted and an unsorted part. It repeatedly selects the smallest (or largest) element from
 * the unsorted part and moves it to the end of the sorted part.
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */

const selectionSort = (arr) => {
    if (arr.length === 0) return [];

    const n = arr.length;
    for (let i = 0; i < n - 1; i++) {
        let minIndex = i;
        for (let j = i + 1; j < n; j++) {
            if(arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex !== i) {
            [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]];
        }
    }
    return arr;
}
//console.log(selectionSort([5, 4, 3, 2, 1])); // Output: [1, 2, 3, 4, 5]



/**
 * Ques 3 - Implement insertion sort algorithm.
 * Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time.
 * It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
const insertionSort = (arr) => {
    if (arr.length === 0) return [];
    const n = arr.length;
    for (let i = 1; i < n; i++) {
        let key = arr[i];
        let j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
    return arr;
}
//console.log(insertionSort([5, 4, 3, 2, 1])); // Output: [1, 2, 3, 4, 5]



/**
 * Ques 4 - Sort() method in JavaScript.
 * The sort() method sorts the elements of an array in place and returns the sorted array.
 * The default sort order is according to string Unicode code points.
 */

const fruits = ["dragon fruit", "apple", "date", "banana", "cherry"];
//console.log(fruits.sort()); // Output: ['apple', 'banana', 'cherry', 'date', 'dragon fruit']

const nums = [10, 5, 18, 1, 27];
//console.log(nums.sort()); // Output: [1, 10, 18, 27, 5] (not sorted numerically)

// To sort numbers correctly, we need to provide a compare function
//console.log(nums.sort((a, b) => a - b)); // Output: [1, 5, 10, 18, 27]

const person = [
    { name: "Alice", age: 30 },
    { name: "Bob", age: 25 },
    { name: "Charlie", age: 35 }
];
//console.log(person.sort((a, b) => a.age - b.age)); // Output: sorted by age



/**
 * Ques 5 - Implement merge sort algorithm.
 * Merge sort is an efficient, stable, and comparison-based sorting algorithm.
 * It divides the array into halves, sorts each half, and then merges the sorted halves.
 * 
 * Time complexity: O(n log n)
 * Space complexity: O(n)
 */

const merge = (left, right) => {
    const result = [];

    while (left.length && right.length) {
        if (left[0] < right[0]) {
            result.push(left.shift());
        } else {
            result.push(right.shift());
        }
    }
    return [...result, ...left, ...right];
}

const mergeSort = (arr) => {
    if (arr.length <= 1) return arr;

    const mid = Math.floor(arr.length / 2);

    const left = mergeSort(arr.slice(0, mid));
    const right = mergeSort(arr.slice(mid));

    return merge(left, right);
}
//console.log(mergeSort([5, 4, 3, 2, 1])); // Output: [1, 2, 3, 4, 5]



/**
 * Ques 6 - Given an array of integers where intervals[i] = [start, end], merge 
 * all overlapping intervals and return an array of the non-overlapping intervals that cover 
 * all the intervals in the input.
 */
const mergeIntervals = (intervals) => {
    const startIndex = 0;
    const endIndex = 1;

    intervals.sort((a, b) => a[startIndex] - b[startIndex]);

    const mergeIntervals = [];

    let mergedStart = intervals[0][startIndex];
    let mergedEnd = intervals[0][endIndex];

    for (let i = 1; i < intervals.length; i++) {
        const subsequentInterval = intervals[i];
        if (subsequentInterval[startIndex] <= mergedEnd) {
            mergedEnd = Math.max(mergedEnd, subsequentInterval[endIndex]);
        } else {
            mergeIntervals.push([mergedStart, mergedEnd]);
            mergedStart = subsequentInterval[startIndex];
            mergedEnd = subsequentInterval[endIndex];
        }
    }

    mergeIntervals.push([mergedStart, mergedEnd]);
    return mergeIntervals;
}
//console.log(mergeIntervals([[1, 3], [2, 6], [8, 10], [15, 18]])); // Output: [[1, 6], [8, 10], [15, 18]]
//console.log(mergeIntervals([[1, 4], [4, 5]])); // Output: [[1, 5]]
//console.log(mergeIntervals([[1, 4], [2, 3]])); // Output: [[1, 4]]



/**
 * Ques 7 - Implement quick sort algorithm.
 * Quick sort is an efficient sorting algorithm that uses a divide-and-conquer approach.
 * It selects a 'pivot' element and partitions the array into two halves: elements less than the pivot
 * and elements greater than the pivot. It then recursively sorts the two halves.
 * 
 * Time complexity: O(n log n) on average, O(n^2) in the worst case
 * Space complexity: O(log n) for the recursive stack
 */

const quickSort = (arr) => {
    if (arr.length <= 1) return arr;

    const pivot = arr[0];

    const left = [];
    const right = [];

    for (let i = 1; i < arr.length; i++) {
        if(arr[i] < pivot){
            left.push(arr[i])
        }else{
            right.push(arr[i])
        }
    }

    return [...quickSort(left), pivot, ...quickSort(right)];
}
//console.log(quickSort([5, 4, 3, 2, 1])); // Output: [1, 2, 3, 4, 5]



/**
 * Given as array of integers, sort the array in ascending order and return it.
 * You must solve without any built-in funnctions in O(n log n) time complexity and 
 * with smallest space complexity.
 */

function pivot(arr, start = 0, end = arr.length - 1) {
  function swap(array, i, j) {
    let temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  let pivot = arr[start];
  let swapIdx = start;

  for (let i = start + 1; i < arr.length; i++) {
    if (arr[i] < pivot) {
      swapIdx++;
      swap(arr, swapIdx, i);
    }
  }

  swap(arr, start, swapIdx);
  return swapIdx;
}

function quickSortArr(arr, start = 0, end = arr.length - 1) {
  if (start < end) {
    const pivotIndex = pivot(arr, start, end);
    quickSortArr(arr, start, pivotIndex - 1);
    quickSortArr(arr, pivotIndex + 1, end);
  }

  return arr;
}

const sortArray = (arr) => {
    return quickSortArr(arr);
}

console.log(quickSortArr([5, 4, 3, 2, 1])); // Output: [1, 2, 3, 4, 5]
console.log(sortArray([10, 7, 8, 9, 1, 5])); // Output: [1, 5, 7, 8, 9, 10]