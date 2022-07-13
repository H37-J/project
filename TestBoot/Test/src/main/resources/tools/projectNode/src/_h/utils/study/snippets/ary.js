const ary = (fn, n) => (...args) => {
    console.log(...args)
    const result = fn(...args.slice(0, n));
    console.log(result)
}

const firstTwoMax = ary(Math.max, 2);
const result = [[2, 6, 'a'], [6, 4, 8], [10]].map(x => firstTwoMax(...x)); 
console.log(result)