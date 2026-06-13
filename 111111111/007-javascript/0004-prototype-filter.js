Array.prototype.myFilter = function(fn){
    let arr = []

    for(let i = 0; i < this.length; i++){
        if(fn(this[i])){
            arr.push(this[i])
        }
    }

    return arr
}

const originalArr = [3, 4, 5]
const filteredArr = originalArr.myFilter(num => num % 2 === 0);
// console.log(filteredArr)
// [ 4 ]