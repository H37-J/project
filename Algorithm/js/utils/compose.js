const compose = (...fns) => fns.reduce((f,g) => (...args) => f(g(...args)));

const add = x => x + 5;
const multiply = (x,y) => x * y;
const multyadd = compose(add,multiply);
multyadd(5,2);
