const obj = {
    id: 1,
    name: 'test1'
};

const oth = obj;
oth.id = obj.id + 1;

const other = {
    ...obj,
    id: obj.id + 1
};

console.log(oth);
console.log(other);