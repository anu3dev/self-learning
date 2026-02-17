const unFlatterArr =  [1,2,3,[4,5,6,[7,8,[10,11]]],9];


const flattenArray1 = unFlatterArr.flat().flat().flat();
//console.log(flattenArray1); 
// [1,2,3,4,5,6,7,8,10,11,9]


const getFlattenArray = (arr) => {
    let tempArr = []

    for(let i = 0; i < arr.length; i++){
        if(Array.isArray(arr[i])){
            tempArr = tempArr.concat(getFlattenArray(arr[i]))
        } else {
            tempArr.push(arr[i])
        }
    }

    return tempArr;
}
//console.log(getFlattenArray(unFlatterArr)) 
// [1,2,3,4,5,6,7,8,10,11,9]


const arr1 = [3, 7, 2]
const arr2 = [9, 1, 5].concat(arr1);
//console.log(arr2) 
// [ 9, 1, 5, 3, 7, 2 ]