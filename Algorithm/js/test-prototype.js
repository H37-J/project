let animal={
    eats:true,
    walk(){
        console.log('동물 걷기');
    }
};

let rabbit={
    jumps:true,
    __proto__:animal //상속의 개념이라고 보면 된다
}

rabbit.walk();

//
// animal엔 다양한 메서드가 있습니다.
 animal = {
    walk() {
      if (!this.isSleeping) {
        alert(`동물이 걸어갑니다.`);
      }
    },
    sleep() {
      this.isSleeping = true;
    }
  };
  
   rabbit = {
    name: "하얀 토끼",
    __proto__: animal
  };
  
  // rabbit의 프로퍼티 isSleeping을 true로 변경합니다.
  rabbit.sleep();
  
  console.log(rabbit.isSleeping); // true
  console.log(animal.isSleeping); // undefined (프로토타입에는 isSleeping이라는 프로퍼티가 없습니다.)

  // 객체 순회,자신만의 프로퍼티 걸러내기
  let animal = {
    eats: true
  };
  
  let rabbit = {
    jumps: true,
    __proto__: animal
  };
  
  for(let prop in rabbit) {
    let isOwn = rabbit.hasOwnProperty(prop);
  
    if (isOwn) {
      console.log(`객체 자신의 프로퍼티: ${prop}`); // 객체 자신의 프로퍼티: jumps
    } else {
      console.log(`상속 프로퍼티: ${prop}`); // 상속 프로퍼티: eats
    }
  }

  //new Object나 리터럴 문법 {...}를 사용해 객체를 참조할때 Object.prototype을 참조한다
  //obj.toString()을 사용하면 Object.prototype에서 해당 메서드를 가져오는 것이다
  let obj={}
  console.log(obj.__proto__ === Object.prototype);

  //이 외에도 Array.prototype, Function.prototype 은 모두 Object프로토 타입을 상속한다

  let arr=[1,2,3]
  console.log(arr) //Array.prototype.toString()으로 호출 되는 것


  //Object.create로 객체 생성 가능
   animal = {
    eats: true
  };
  
   rabbit = Object.create(animal, {
    jumps: {
      value: true
    }
  });
  
  alert(rabbit.jumps); // true