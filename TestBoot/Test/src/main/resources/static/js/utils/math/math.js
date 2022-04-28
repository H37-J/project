const gcd = (...arr) => {
    const _gcd = (x, y) => (!y ? x : gcd(y, x % y));
    return [...arr].reduce((a, b) => _gcd(a, b));
}

gcd(8, 36); // 4
gcd(...[12, 8, 32]); // 4

const isPrime = num => {
    const boudary = Math.floor(Math.sqrt(num));
    for(let i = 2; i <= boundary; i++) {
        if(num % i === 0) return false;
    }
    return num >= 2;
}

const lcm = (...arr) => {
    const gcd = (x, y) => (!y ? x : gcd(y, x % y));
    const _lcm = (x, y) => (x * y) / gcd(x, y);
    return [...arr].reduce((a, b) => _lcm(a, b));
}

const primeFactor = n => {
    let a = [], f = 2;
    while(n > 1) {
        if(n % f === 0) {
            a.push(f);
            n /= f;
        } else {
            f++;
        }
    }
    return n;
}

const primes = num => {
    let arr = Array.from({ length: num - 1 }).map((x, i) => i + 2),
      sqroot = Math.floor(Math.sqrt(num)),
      numsTillSqroot = Array.from({ length: sqroot - 1 }).map((x, i) => i + 2);
    numsTillSqroot.forEach(x => (arr = arr.filter(y => y % x !== 0 || y === x)));
    return arr;
};

const prod = (...arr) => [...arr].reduce((acc, val) => acc * val, 1);
