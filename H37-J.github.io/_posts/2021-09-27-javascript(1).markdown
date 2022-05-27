---
layout:     post
title:      "Javascript(1)"
subtitle:   " \"내가 공부한 Javascript 사용법 정리 \""
date:       2021-08-30 12:00:00
author:     "H37-J"
header-img: "img/post-bg-2015.jpg"
catalog: true
tags:
    - Javascript

---

# 자바스크립트 정리

## 브라우저에서의 자바스크립트

브라우저에서 태그를 이용하여 외부의 스크립트 파일을 가져오지만
파일 마다 독립적인 파일 스코프를 갖지 않고 하나의 전역객체를 공유한다.

## IIFE(즉시 실행함수 표현)

즉시 실행 함수 표현(IIFE, Immediately Invoked Function Expression)은 정의되자마자 즉시 실행되는 Javascript Function 를 말한다.
(function() {
  const aName = "Mary"
})()

## ES6 모듈

ES6에서는 다음과 같이 export, import를 사용 할 수 있다.

```javascript
export function test(){
    return "test";
}
```

```javascript
import * as fun from "./test.js"
console.log(fun.test());

하지만 이 사용방식은 아직 모든 브라우저에서는 지원하지 않기 떄문에 따라서 Webpack을 사용한다.
```

## 웹팩

웹팩은 하나의 시작점으로부터 의존적인 모듈을 전부 찾아내서 하나의 파일로 만든다.
이 결과물을 Output이라고 한다.
