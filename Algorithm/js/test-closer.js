//함수 내부에서 함수 외부의 변수에 접근 할 수 있다
//{...} 에서 let 으로 선언한 변수는 오직 블록 안에서만 접근 가능하다
{
    let a=1;
    console.log(a);
}
//console.log(a); //error

//var는 블록 스코프가 없다. for나 if에서는 블록 스코프가 없지만 유일하게 함수에서는 함수범위 내에서만 유효한 변수 범위를 갖는다
{
    var b=1;
}

console.log(b);

//다음은 함수를 끌어 올리는 호이스팅

function sayHi() {
    phrase = "Hello"; // (*)
  
    if (false) {
      var phrase;
    }
  
    console.log(phrase);
}

function makeCounter(){
    let count=0;

    return function(){
        return count++;
    }
}

let counter=makeCounter();

console.log(counter());
console.log(counter());
console.log(counter());


//렉시컬 
//환경 레코드(Environment Record) – 모든 지역 변수를 프로퍼티로 저장하고 있는 객체입니다. this 값과 같은 기타 정보도 여기에 저장됩니다.
//외부 렉시컬 환경(Outer Lexical Environment) 에 대한 참조 – 외부 코드와 연관됨
//함수 선언문으로 선언된 함수는 선언 즉시 사용 할 수 있다. 하지만 변수는 let을 만나 선언이 될 때 까지는 사용 할 수 없다
//함수 실행시 내부 렉시컬 환경에서 원하는 변수를 우선으로 검색하고 찾지 못하면 외부 렉시컬 환경으로 확장된다.

//함수는 호출 장소와 상관없이 자신이 태어난 곳을 기억할 수있는 [[Envioronment]]프로퍼티가 있다.함수는 호출 될 때마다 새로운 렉시컬 환경을 생성하는데, 이때 외부 렉시컬 환경으로 저 프로퍼티를 참조한다.

//클로저는 외부변수를 기억하고 이 외부변수에 접근 할 수 있는 함수를 의미함


//화살표 함수에는 this가 없다

let group = {
    title: "1모둠",
    students: ["보라", "호진", "지민"],
  
    showList() {
      this.students.forEach(
        student => console.log(this.title + ': ' + student) //외부의 렉시컬을 참조하여ㅕ showList에서 this를 참조한다
      );
    }
  };
  
  group.showList();

group = {
    title: "1모둠",
    students: ["보라", "호진", "지민"],
  
    showList() {
      this.students.forEach(function(student) {
        // TypeError: Cannot read property 'title' of undefined
        // console.log(this.title + ': ' + student) 에러가 발생함
      });
    }
  };
  
  group.showList();