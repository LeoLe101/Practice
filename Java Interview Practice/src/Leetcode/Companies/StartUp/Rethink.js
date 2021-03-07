// Write a function that flattens an Array of Array objects into a flat Array. Our function must flatten any given array input.
// Space (N) - Time (N)
const flatten = (arr) => {
    let result = []
    
    // Loop through curr Arr
    for (let i = 0; i < arr.length; i++) {
        // If curr element is an Arr, recursively loop thru it
        if (Array.isArray(arr[i])) {
            result = result.concat(flatten(arr[i]))
        } 
        // Else, concat to result
        else {
            result.push(arr[i])
        }
    }
    return result
}

// Because each arr might has inner arrays, a loop from outside is needed
// to iterate through all the array and other normal elements.
// If the current element in the array is an inner array, recursively go into it and repeat the process.
flatten([[1,[3,4,5],7,8], 9, 10, 11, [12,13,14,51, [[23], [33,35,62]]]])
