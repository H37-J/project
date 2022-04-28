function sumAll(...args){
    let sum=0;

    for(let arg of args) sum+=arg;

    return sum;
}

function sumAll(... args){
  let test = 0;

}

console.log(sumAll(1,2,3,4));

//spread
let arr=[1,2,3];
let arr2=[4,5,6]

console.log(Math.max(...arr,...arr2));

//전개문법을 사용해 문자열을 배열로도 변경 가능
let str="hello";
let st=[...str]; //==Array.from(str);
console.log(Array.isArray(st));
