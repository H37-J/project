const forEachRight = (arr, callback) => arr.reverse().forEach(callback);

forEachRight([1,2,3,4], val => console.log(val));
