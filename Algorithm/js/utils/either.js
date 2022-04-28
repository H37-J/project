const either = (f, g) => (...args) => f(...args) || g(...args);
