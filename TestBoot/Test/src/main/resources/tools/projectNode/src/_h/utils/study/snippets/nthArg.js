const nthArg = n => (...args) => {
    return args.slice(n)[0]
}

const third = nthArg(2)
third(1, 2, 3)

console.log(Math.pow(32, 1 / 5))