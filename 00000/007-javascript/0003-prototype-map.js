Array.prototype.myMap = function(fn){
    let arr = []

    for(let i = 0; i < this.length; i++){
        arr.push(fn(this[i]))
    }

    return arr;
}


const originalArr = [3, 4, 5]
const mapedArr = originalArr.myMap(n => n * 3);
// console.log(originalArr, mapedArr)
// [ 3, 4, 5 ] [ 9, 12, 15 ]