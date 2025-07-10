const someOperation = (n) => {
    return (n * (n + 5)) / 2;           // 3
}
// total operation = 3 => O(1) time complexity



const GoingUpDown = (n) => {
    console.log("Going up");            // 1
    for (let i = 0; i < n; i++) {
        console.log(i);                 // n     
    }
    console.log("Going down");          // 1
    for (let i = n - 1; i >= 0; i--) {
        console.log(i);                 // n
    }  
    console.log("Done");                // 1
}
// Total operation = 2n + 3 = 2n = O(n) time complexity



const printBoth = (n) => {
    for (let i = 0; i < n; i++) {       // n
        for (let j = 0; j < n; j++) {   // n
            console.log(i, j);          // n^2               
        }                 
    }
}
//Total operation = n^2 = O(n^2) time complexity



const sumOfArr = (arr) => {
    let sum = 0;                       
    for (let i = 0; i < arr.length; i++) { 
        sum += arr[i];                 
    }
    return sum;                         
}
// Total operation = since output is not dependent on input size, it is O(1) space complexity.



const funnyNumberArray = (n) => {
    const arr = [];                       
    for (let i = 0; i < n; i++) { 
        for (let j = 0; j < arr.length; j++) { 
            arr.push(i + j); // O(n^2) operation    
        }
    }
    return arr;                         
}
// Total operation = O(n^2) time complexity, O(n) space complexity.



const createMatrix = (n) => {
    const matrix = [];
    for (let i = 0; i < n; i++) {
        const row = [];
        for (let j = 0; j < n; j++) {
            row.push(i * j);
        }
        matrix.push(row);
    }
    return matrix;
}
// Total space used = n * n = O(n^2) space complexity.



