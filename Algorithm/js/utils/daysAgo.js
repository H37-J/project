const daysAgo = n =>{
    let d = new Date();
    d.setDate(d.getDate() - Math.abs(n));
    return d.toISOString().split('T')[0];
};

let result = daysAgo(20);
console.log(result);

