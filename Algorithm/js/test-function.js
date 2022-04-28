let user = {
    firstName: "John",
    sayHi() {
      console.log(`Hello, ${this.firstName}!`);
    }
  };
  
  setTimeout(user.sayHi, 1000); // Hello, undefined! 객체 메서드가 내부가 아닌 다른곳에 콜백으로 호출되어 사라진 this. 여기서 this는 window를 참고하여 window.firstName이 되기 때문이다


//this를 context로 고정 시키는 법
user={
    name:'hjk'
};

function func(){
    console.log(this.name);
}

let funcUser=func.bind(user);
funcUser();

//해결법 도출
user = {
    firstName: "hjk",
    sayHi() {
      console.log(`Hello, ${this.firstName}!`);
    }
  };

let say=user.sayHi.bind(user);

setTimeout(say,1000);

//함수의 고정
function mul(a, b) {
    return a * b;
  }
  
  let double = mul.bind(null, 2);
  console.log( double(3) ); // = mul(2, 3) = 6
  console.log( double(4) ); // = mul(2, 4) = 8
  console.log( double(5) ); // = mul(2, 5) = 10