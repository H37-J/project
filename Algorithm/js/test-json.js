//stringfy
let human={
    name:'hjk',
    age:30,
    isAdmin:true,
};

let json = JSON.stringify(human);

console.log(json);

//parse(json을 다시 객체로)
let userData = '{ "name": "John", "age": 35, "isAdmin": false, "friends": [0,1,2,3] }';

let user = JSON.parse(userData);
console.log(user);

console.log( user.friends[1] ); // 1