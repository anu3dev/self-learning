const array001 = []
const array002 = [105, 43, 92, 7, 67, 18, 222, 56, 88, 13]

// Selection Sort Algorithm Implementation in JavaScript
// time complexity: O(n^2)
// space complexity: O(1)
const sortAnArray001 = (arr) => {
    if(arr.length < 2) return arr

    for(let i = 0; i < arr.length; i++){
        for(let j = i + 1; j < arr.length; j++){
            if(arr[i] > arr[j]){
                let temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }
    return arr
}
console.log(sortAnArray001(array001))
console.log(sortAnArray001(array002))

// Bubble Sort Algorithm Implementation in JavaScript
// time complexity: O(n^2)
// space complexity: O(1)
const sortAnArray002 = (arr) => {
    if(arr.length < 2) return arr

    for(let i = 0; i < arr.length - 1; i++){
        for(let j = 0; j < arr.length - 1 - i; j++){
            if(arr[j] > arr[j + 1]){
                let temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    return arr
}
console.log(sortAnArray002(array001))
console.log(sortAnArray002(array002))



// Quick Sort Algorithm Implementation in JavaScript
// time complexity: O(n log n) on average, O(n^2) in the worst case
// space complexity: O(log n)
const sortAnArray003 = (arr) => {
    if(arr.length < 2) return arr

    const left = [];
    const right = [];
    const pivot = arr[arr.length - 1]

    for(let i = 0; i < arr.length - 1; i++){
        if(arr[i] < pivot){
            left.push(arr[i])
        } else {
            right.push(arr[i])
        }
    }

    return [...sortAnArray002(left), pivot, ...sortAnArray002(right)]
}
console.log(sortAnArray003(array001))
console.log(sortAnArray003(array002))