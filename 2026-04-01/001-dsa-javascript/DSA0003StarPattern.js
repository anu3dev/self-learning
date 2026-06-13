/**
 * draw a pattern like 4*4 as below
 * 
 *  *  *  *  *  *
 *  *  *  *  *
 *  *  *  *  *
 *  *  *  *  *
 */

const drawSquarePatter = (num) => {
    // handling row
    for(let i = 0; i < num; i++){
        let row = ""

        // handling column
        for(let j = 0; j < num; j++){
            row = row + `${row ? "  *" : "*"}`
        }

        console.log(row)
    }
}
drawSquarePatter(4)



/**
 * draw a pattern like right angle triangle as below
 * 
 *  *
 *  *  *
 *  *  *  *
 *  *  *  *  *
 */

const drawRightAngleTriangle = (num) => {
    for(let i = 0; i < num; i++){
        let row = ""

        for(let j = 0; j <= i; j++){
            row = row + `${row ? "  *" : "*"}`
        }

        console.log(row)
    }
}
drawRightAngleTriangle(4)



/**
 * print number in right angle triangle as below
 * 
 *  1
 *  1  2
 *  1  2  3
 *  1  2  3  4
 */

const printNumberInRightAngleFormat = (num) => {
    for(let i = 0; i < num; i++){
        let row = ""

        for(let j = 0; j <= i; j++){
            row = row + `${row ? `  ${j + 1}` : `${j + 1}`}`
        }

        console.log(row)
    }
}
printNumberInRightAngleFormat(4)



/**
 * print number in right angle triangle as below
 * 
 *  1
 *  2  2
 *  3  3  3
 *  4  4  4  4
 */

const printNumberInRightAngleFormatOne = (num) => {
    for(let i = 0; i < num; i++){
        let row = ""

        for(let j = 0; j <= i; j++){
            row = row + `${row ? `  ${i + 1}` : `${i + 1}`}`
        }

        console.log(row)
    }
}
printNumberInRightAngleFormatOne(4)



/**
 * print number in right angle triangle as below
 * 
 *  1  2  3  4
 *  1  2  3
 *  1  2 
 *  1
 */



/**
 * print number in right angle triangle as below
 * 
 *  1  2  3  4
 *  2  2  3
 *  3  3
 *  4 
 */



/**
 * print number in right angle triangle as below
 * 
 *  *  *  *  *
 *  *  *  *
 *  *  *
 *  *
 */



/**
 * print number in right angle triangle as below
 * 
 *  -  -  -  -
 *  -  -  -  *
 *  -  -  *  *
 *  -  *  *  *
 *  *  *  *  *
 */

const printNumberInRightAngleFormat5 = (num) => {
    for(let i = 0; i < num; i++){
        let row = ""

        for(let j = 0; j < num - 1; j++){
            if(i === 0){
                row = row + "  -"
            } else if (i < num - 1){
                if(j < num - 1 - i){
                    row = row + "  -"
                } else {
                    row = row + "  *"
                }
            } else if (i === num - 1){
                row = row + "  *"
            }
        }

        console.log(row)
    }
}
printNumberInRightAngleFormat5(5)



/**
 * print number in right angle triangle as below
 * 
 *  1 
 *  1  0
 *  1  0  1
 *  1  0  1  0
 *  1  0  1  0  1
 */

const printNumberInRightAngleFormat6 = (num) => {
    for(let i = 1; i <= num; i++){
        let row = ""

        for(let j = 1; j <= i; j++){
            if(j % 2 === 0){
                row = row + "  " + 0
            } else {
                row = row + "  " + 1
            }
        }

        console.log(row)
    }
}
printNumberInRightAngleFormat6(5)



/**
 * print number in right angle triangle as below
 * 
 *  1 
 *  0  0
 *  1  1  1
 *  0  0  0  0
 *  1  1  1  1  1
 */

const printNumberInRightAngleFormat7 = (num) => {
    for(let i = 1; i <= num; i++){
        let row = ""

        for(let j = 1; j <= i; j++){
            if(i % 2 === 0){
                row = row + "  " + 0
            } else {
                row = row + "  " + 1
            }
        }

        console.log(row)
    }
}
printNumberInRightAngleFormat7(5)