//콜백 설명

import { response } from 'express';

function loadScript(src) {
  let script = document.createElement('script');
  script.src = src;
  document.head.appendChild(script);
}

//loadScript('./test.js');
// somfunction() 자바스크립트는 비동기적으로 실행되기 때문에 somfunction()이 스크립트 로딩이 종료되는걸 기다리지 않는다. 여기서 콜백을 사용한다.

//콜백을 이용한 해결법

function loadScriptCallback(src, callback) {
  let script = document.createElement('script');
  script.src = src;
  script.onload = () => callback(script);
  document.head.appendChild(script);
}

// loadScriptCallback('./test.js',script=>{
//     console.log(script.src);
// })

//프라미스
let promise = new Promise(function (resolve, reject) {
  setTimeout(() => resolve('done'), 1000);
});

promise.then(
  result => console.log('성공'), //첫번째 인수는 프라미스가 이행되었을때
  error => console.log('에러') //두번째 인수는 이행되지 않았을때
);

//resolve시 state(pending)->state(fulfilled)로 result(undefined)->result(done)으로 변경, reject시 state(rejected),result(error)로 변경

// function promiseloadScript(src) {
//     return new Promise(function(resolve, reject) {
//       let script = document.createElement('script');
//       script.src = src;

//       script.onload = () => resolve(script);
//       script.onerror = () => reject(new Error(`${src}를 불러오는 도중에 에러가 발생함`));

//       document.head.append(script);
//     });
//   }

//  promise = loadScript("https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.11/lodash.js");

//   promise.then(
//     script => alert(`${script.src}을 불러왔습니다!`),
//     error => alert(`Error: ${error.message}`)
//   );

//   promise.then(script => alert('또다른 핸들러...'));

//프로마이스 체이닝
//resolve 함수는 then의 첫번째 함수를 실행한다
//reject시 then은 실행되지 않는다
new Promise(function (resolve, reject) {
  setTimeout(() => resolve(1), 1000);
})
  .then(function (result) {
    console.log(result);
    return result * 2;
  })
  .then(function (result) {
    console.log(result);
    return result * 2;
  })
  .then(function (result) {
    console.log(result);
  })
  .catch(err => console.log(err));

//async(앞에 async 를 붙인다. 그럼 해당 함수는 프라미스를 반환한다. 프라미스가 아닌 값을 반환하더라도 이행 상태의 프라미스로 값을 감싸 이행된 프라미스가 반행되도록 한다)
//await는 async 함수 안에서만 동작한다
async function f() {
  return 1;
}

f().then(console.log);

async function ff() {
  let promise = new Promise((resolve, reject) => {
    setTimeout(() => resolve('완료'), 1000);
  });

  let result = await promise; //promise가 이행될 때까지 기다림

  console.log(result);
}

ff();

//asycn클래스 메서드
class Waiter {
  async wait() {
    return await Promise.resolve('Waiter');
  }
}

new Waiter().wait().then(console.log);

function myDisplayer(some) {
  document.getElementById('demo').innerHTML = some;
}

function getFile(myCallback) {
  let req = new XMLHttpRequest();
  req.open('GET', 'mycar.html');
  req.onload = function () {
    if (req.status == 200) {
      myCallback(this.responseText);
    } else {
      myCallback('Error: ' + req.status);
    }
  };
  req.send();
}

getFile(myDisplayer);

async function getFile() {
  let myPromise = new Promise(function (resolve) {
    let req = new XMLHttpRequest();
    req.open('GET', 'mycar.html');
    req.onload = function () {
      if (req.status == 200) {
        resolve(req.response);
      } else {
        resolve('File not Found');
      }
    };
    req.send();
  });
  document.getElementById('demo').innerHTML = await myPromise;
}

getFile();
