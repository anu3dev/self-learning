/**
 * write a functuon that returns the count of digits in a number
 */

const countDigitInANumber = (num) => {
    if(num == 0)
        return 1

    // converting negative number to positive
    num = Math.abs(num)

    let count = 0

    while(num > 0){
        num = Math.floor(num / 10)
        count++
    }

    return count
}
console.log(countDigitInANumber(28960)) // 5
console.log(countDigitInANumber(-280)) // 3
console.log(countDigitInANumber(0)) // 1



/**
 * check palindrome
 * 
 * palindrome is a positive integer number which can be read backward and forward same.
 */

const isPalindrome = (num) => {
    let tempNum = num
    let revNum = 0

    while(tempNum > 0){
        revNum = (revNum * 10) + (tempNum % 10)
        tempNum = Math.floor(tempNum / 10)
    }

    return num === revNum ? 'yes' : 'no'
}
console.log(isPalindrome(121)) // yes
console.log(isPalindrome(-121)) // no
console.log(isPalindrome(21)) // no



/**
 * reverse an integer
 */

const reverseInteger = (num) => {
    let tempNum = Math.abs(num)
    let revNum = 0

    while(tempNum > 0){
        revNum = (revNum * 10) + (tempNum % 10)
        tempNum = Math.floor(tempNum / 10)
    }

    return num < 0 ? -revNum : revNum
}
console.log(reverseInteger(123)) // 321
console.log(reverseInteger(-123)) // -321
console.log(reverseInteger(120)) // 21