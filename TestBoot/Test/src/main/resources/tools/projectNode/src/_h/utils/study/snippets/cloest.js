const closest = (arr, n) => {
    arr.reduce((acc, num) => (Math.abs(num - n) < Math(acc - n) ? num : acc))
}