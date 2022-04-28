const accumulate = (...nums) => {
    return nums.reduce((acc, n) => [...acc, n + (acc.slice(-1)[0] || 0)], []);
}

let result = accumulate(1, 2, 3, 4);
console.log(result);
