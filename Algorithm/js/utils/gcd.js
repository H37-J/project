const gcd = (...arr) => {
  const _gcd = (x, y) => (!y ? x : gcd(y, x % y));
  return [...arr].reduce((a, b) => _gcd(a, b));
};

const lcm = (...arr) => {
  const gcd = (x, y) => (!y ? x : gcd(y, x % y));
  const _lcm = (x, y) => (x * y) / gcd(x, y);
  return [...arr].reduce((a, b) => _lcm(a, b));
};
