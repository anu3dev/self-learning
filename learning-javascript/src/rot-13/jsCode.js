// https://www.freecodecamp.org/learn/javascript-algorithms-and-data-structures

/**
 * A palindrome is a word or sentence that's spelled the same way both forward and backward,
 * ignoring punctuation, case, and spacing.
 */

const palindrome = (str) => {
    const modifiedValue = str.replace(/[^a-zA-Z0-9]/g, "").toLowerCase()
    const revModifiedValue = modifiedValue.split('').reverse().join('')

    return modifiedValue === revModifiedValue ? true : false;
}

/**
 * 
 * One of the simplest and most widely known ciphers is a Caesar cipher, also known as a shift cipher.
 * In a shift cipher the meanings of the letters are shifted by some set amount. A common modern use is 
 * the ROT13 cipher, where the values of the letters are shifted by 13 places. All letters will be uppercase.
 * Do not transform any non-alphabetic character (i.e. spaces, punctuation), but do pass them on.
 */

const rot13 = (str) => {
    const convertedArr = []

    str.split('').map((item) => {

        if ((item.charCodeAt(0) >= 65) && (item.charCodeAt(0) <= 90)) {
            const increadedVal = (item.charCodeAt(0) + 13)

            if (increadedVal > 90) {
                convertedArr.push(String.fromCharCode((increadedVal % 90) + 64))
            } else {
                convertedArr.push(String.fromCharCode(increadedVal))
            }
            return convertedArr

        } else {
            convertedArr.push((item))
        }
        return convertedArr
    })
    return convertedArr.join('')
}

/**
 * Return true if the passed string looks like a valid US phone number.
 */


