const arr = [5, 9, 2, 11, 17]

const finalSumVal = arr.reduce((accumulator, current) => accumulator + current, 0)
// console.log(finalSumVal)
// 44



const nestedArr = [[1, 2], [3, 4], [5, 6]]

const flatenArr = nestedArr.reduce((accumulator, current) => accumulator.concat(current), [])
// console.log(flatenArr)
// [ 1, 2, 3, 4, 5, 6 ]



const fruits = ["apple", "orange", "apple", "lemon", "mango", "apple"]

const fruitCount = fruits.reduce((accumulator, current) => {
    accumulator[current] = (accumulator[current] || 0) + 1
    return accumulator
}, {})
// console.log(fruitCount)
// { apple: 3, orange: 1, lemon: 1, mango: 1 }



Array.prototype.myReduce = function(fn, initialValue){
    let acc = initialValue;

    for(let i = 0; i < this.length; i++){
        acc = fn(acc, this[i])
    }

    return acc
}

const array = [5, 9, 2, 11, 17]

const sum = array.myReduce((accumulator, current) => accumulator + current, 0)
// console.log(sum)
// 44