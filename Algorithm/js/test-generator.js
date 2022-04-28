function* generateSequence(){
    yield 1;
    yield 2;
    return 3;
}

//제네테레이터 함수는 일반 함수 동작과 다르다. 코드가 실행되지 않고 대신 실행을 처리하는 특별 객체, 제너레이터 객체가 반환된다.
let generator=generateSequence();
console.log(generator);

//next를 실행할 때마다 yield값을 차례차례 반환함
let one=generator.next();
console.log(JSON.stringify(one));
let two=generator.next();
console.log(JSON.stringify(two));

//yield값이 끝나면 done은 true가 된다
let three=generator.next();
console.log(three);

//제너레이터는 이터러블이기에 for of가 가능하다
for(let value of generator){
    console.log(value);
}