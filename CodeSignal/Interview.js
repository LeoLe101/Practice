/**
 * Given a string s consisting of small English letters, 
 * find and return the first instance of a non-repeating character in it. 
 * If there is no such character, return '_'.
 * 
 * For s = "abacabad", the output should be 'c'.
 * There are 2 non-repeating characters in the string: 'c' and 'd'. 
 * Return c since it appears in the string first.
 * 
 * For s = "abacabaabacaba", the output should be '_'.
 * There are no characters in this string that do not repeat.
 * 
 * @param {*} s     String given from the user
 * @return          The first non-repeated char or '_' if none existed.
 */
function firstNotRepeatingCharacter(s) {
    // create an empty Map object;
    const stringMap = new Map();

    // iterate over characters of s and add to Map if char doesn't exist.
    // increment it's corresponding value if char exists.
    for (char of s) {
        if (stringMap.has(char)) {
            stringMap.set(char, stringMap.get(char) + 1)
        } else {
            stringMap.set(char, 1);
        }
    };

    // iterate over Map; and find the first key with value === 1;
    for (let [key, value] of stringMap) {
        if (value === 1) {
            return key;
        }
    }

    // if nothing is returned from the iteration, return '_'
    return '_';
}

function firstNotRepeatingCharacterWithArrayApproach(str) {

    let charArr = [];
    let currChar;
    
    for (let i = 0; i < str.length; i++) {
        currChar = s[i];
        charArr[currChar]++;
    }
    
    for (int i = 0; i < charArr.length; i++) {
        if (charArr[i] == 1) {
            currChar = (char) i;
            return currChar; 
        }
    }
    
    return '_';



    return '_';
}