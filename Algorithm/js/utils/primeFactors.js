const primeFactors = n => {
  let a = [],
    f = 2;
  while (n > 1) {
    if (n % f === 0) {
      a.push(f);
      n /= f;
    } else {
      f++;
    }
  }
  return a;
};

const primes = num => {
  let arr = Array.from({ length: num - 1 }).map((x, i) => i + 2),
    sqroot = Math.floor(Math.sqrt(num)),
    numsTillSqroot = Array.from({ length: sqroot - 1 }).map((x, i) => i + 2);
  numsTillSqroot.forEach(x => (arr = arr.filter(y => y % x !== 0 || y === x)));
  return arr;
};
