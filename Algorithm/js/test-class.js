//기본적인 클래스 생성과 사용법
// class User{

//     constructor(name){
//         this.name=name;
//     }

//     say(){
//         console.log(this.name);
//     }
// }

// let user=new User('hjk');
// user.say();

//getter,setter
class User{
    constructor(name){
        this.name=name;
    }

    get name(){
        return this._name;
    }

    set name(value){
        if(value.length<4){
            console.log('이름이 너무 짧습니다');
            return;
        }
        this._name=value;
    }
    //setter getter을 만들지 않아도 된다
}

let user=new User('hjka1');
console.log(user.name);


//클래스 필드로 바안딩된 메서드

class Button{
    constructor(name){
        this.name=name;
    }

    click=()=>{
        console.log(this.name);
    }
}

// let button=new Button('name');
// setTimeout(button.click,1000);

//내부 인터페이스와, 외부 인터페이스
// 내부 인터페이스(internal interface) – 동일한 클래스 내의 다른 메서드에선 접근할 수 있지만, 클래스 밖에선 접근할 수 없는 프로퍼티와 메서드 private,다른 언어에서는 자신과 자식 클래스에만 접근 가능한 protected 제공
// 외부 인터페이스(external interface) – 클래스 밖에서도 접근 가능한 프로퍼티와 메서드 public

class CoffeeMachine {
    _waterAmount = 0;
  
    setWaterAmount(value) {
      if (value < 0) throw new Error("물의 양은 음수가 될 수 없습니다.");
      this._waterAmount = value;
    }
  
    getWaterAmount() {
      return this._waterAmount;
    }
  }
  
  new CoffeeMachine().setWaterAmount(100);

  //상속자관련

  class Animal{
      constructor(name){
          this.speed=0;
          this.name=name;
      }
  }

  class Rabbit extends Animal{
      constructor(name,ear){
          super(name); //부모의 생성자를 호출 하지않으면 객체를 생성할때 this가 결정되지 않는다.
          this.ear=ear;
      }
  }


//extends
class PowerArray extends Array {
    isEmpty() {
      return this.length === 0;
    }
  }
  
  let arr = new PowerArray(1, 2, 5, 10, 50);
  console.log(arr.isEmpty()); // false
  
  let filteredArr = arr.filter(item => item >= 10);
  console.log(filteredArr); // 10, 50
  console.log(filteredArr.isEmpty()); // false