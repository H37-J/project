const binary = fn => (a, b) => {
    console.log(a,b)
}

const result = [2, 1, 0].map(binary(Math.max))
console.log(result)