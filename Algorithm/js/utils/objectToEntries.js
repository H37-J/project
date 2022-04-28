const objectToEntries = obj => Object.keys(obj).map(k => [k, obj[k]]);

objectToEntries({ a: 1, b: 2 }); // [ ['a', 1], ['b', 2] ]

const objectToPairs = obj => Object.entries(obj);

const omit = (obj, arr) =>
  Object.keys(obj)
    .filter(k => !arr.includes(k))
    .reduce((acc, key) => ((acc[key] = obj[key]), acc), {});