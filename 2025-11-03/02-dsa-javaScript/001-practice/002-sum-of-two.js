const arr01 = [2,7,11,15]
const arr02 = [3,2,4]
const arr03 = [3,2,4,8,9,17]

const sumOfTwo = (arr, target) => {
    for(let i = 0; i < arr?.length; i++){
        for(let j = i + 1; j < arr.length; j++){
            if(arr[i] + arr[j] === target){
                return [i, j]
            }
        }
    }
    return []
}

console.log(sumOfTwo(arr01, 26)) // [0,1]
console.log(sumOfTwo(arr02, 6)) // [1,2]
console.log(sumOfTwo(arr03, 20)) // [1,2]