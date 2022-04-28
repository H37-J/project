function pow(x, n) {
  let result = 1;

  for (let i = 0; i < n; i++) {
    result *= x;
  }

  return result;
}

console.log(pow(2, 3));

//재귀로 변경
function recursive_pow(x, n) {
  if (n == 1) {
    return x; //재귀의 베이스 x==pow(x,1); n이 1이 아닐때 pow(x,n)==x* pow(x,n-1); 이를 재귀 단계라고하고 목표 작업인 pow(x,n)이 될때까지 함수를 실행한다
  } else {
    return x * pow(x, n - 1);
  }
}

console.log(recursive_pow(2, 3));

//재귀를 이용한 임직원 급여 합계구하기
let company = {
  sales: [
    { name: 'John', salary: 1000 },
    { name: 'Alice', salary: 1600 }
  ],
  development: {
    sites: [
      { name: 'Peter', salary: 2000 },
      { name: 'Alex', salary: 1800 }
    ],
    internals: [{ name: 'Jack', salary: 1300 }]
  }
};

function sumSalaries(department) {
  if (Array.isArray(department)) {
    return department.reduce((prev, current) => prev + current.salary, 0);
  } else {
    let sum = 0;
    for (let subdep of Object.values(department)) {
      sum += sumSalaries(subdep);
    }
    return sum;
  }
}

console.log(sumSalaries(company));

// 실행 컨텍스트와 스택

// 실제 재귀 호출이 어떻게 동작하는지 알아봅시다. 이를 위해서 함수의 내부 동작에 대해 살펴보도록 하겠습니다.

// 실행 중인 함수의 실행 절차에 대한 정보는 해당 함수의 실행 컨텍스트(execution context) 에 저장됩니다.

// 실행 컨텍스트는 함수 실행에 대한 세부 정보를 담고 있는 내부 데이터 구조입니다. 제어 흐름의 현재 위치, 변수의 현재 값, this의 값(여기선 다루지 않음) 등 상세 내부 정보가 실행 컨텍스트에 저장됩니다.

// 함수 호출 일 회당 정확히 하나의 실행 컨텍스트가 생성됩니다.

// 함수 내부에 중첩 호출이 있을 때는 아래와 같은 절차가 수행됩니다.

//     현재 함수의 실행이 일시 중지됩니다.
//     중지된 함수와 연관된 실행 컨텍스트는 실행 컨텍스트 스택(execution context stack) 이라는 특별한 자료 구조에 저장됩니다.
//     중첩 호출이 실행됩니다.
//     중첩 호출 실행이 끝난 이후 실행 컨텍스트 스택에서 일시 중단한 함수의 실행 컨텍스트를 꺼내오고, 중단한 함수의 실행을 다시 이어갑니다.

// 이제 pow (2, 3)가 호출되면 실행 컨텍스트에서 무슨 일이 일어나는지 살펴봅시다.

// 스택 최상단에 현재 컨텍스트가 '기록’됩니다.
// 서브 호출을 위한 새로운 컨텍스트가 만들어집니다.
// 서브 호출이 완료되면. 기존 컨텍스트를 스택에서 꺼내(pop) 실행을 이어나갑니다.
