//정규표현의 긴 문법
let regexp=new RegExp('pattern','ig');

//짧은 문법
regexp='pattern/flags';


// i
//     i 플래그가 붙으면 대·소문자 구분 없이 검색합니다. 따라서 A와 a에 차이가 없습니다(아래 예시 참조).
// g
//     g 플래그가 붙으면 패턴과 일치하는 모든 것들을 찾습니다. g 플래그가 없으면 패턴과 일치하는 첫 번째 결과만 반환됩니다.
// m
//     다중 행 모드(multiline mode)를 활성화합니다. 자세한 내용은 앵커 ^와 $의 여러 행 모드, 'm' 플래그에서 다룰 예정입니다.
// s
//     .이 개행 문자 \n도 포함하도록 ‘dotall’ 모드를 활성화합니다. 자세한 내용은 문자 클래스에서 다룰 예정입니다.
// u
//     유니코드 전체를 지원합니다. 이 플래그를 사용하면 서로게이트 쌍(surrogate pair)을 올바르게 처리할 수 있습니다. 자세한 내용은 유니코드: 'u' 플래그와 \p{...} 클래스에서 다룰 예정입니다.
// y
//     문자 내 특정 위치에서 검색을 진행하는 ‘sticky’ 모드를 활성화 시킵니다. 자세한 내용은 Sticky flag "y", searching at position에서 다룰 예정입니다. 

let str='We will,we will rock you';
console.log(str.match(/we/gi)); //배열을 리턴 ['We','we'];

//일치하는 패턴이 없을 때 null을 반환한다 이 경우 length를 사용할 수 없으므로 조심해야한다

//정규 표현으로 relace 하기
console.log( str.replace(/we/ig, "I") ); // I will, I will

//test로 일치 여부 확인
regexp=/willa/i;
console.log(regexp.test(str));

//문자 클래스
//문자클래스는 특정 집합에 포함된 모든 기호에 일치하는 특별한 표현이다.

let tel="+7(903)-123-45-67";
regexp=/\d/g;
console.log(tel.match(regexp));
console.log(tel.match(regexp).join('')) //배열조합

str='Is there CSS4?';
regexp=/CSS\d/;

console.log(str.match(regexp)); //CSS+숫자가 들어간것

str="i love HTML5! test3"
regexp=/\s\w\w\w\w\d/ig;
console.log(str.match(regexp)); //공백,문자,문자,문자,문자,숫자인것을 검색

// .은 아무 문자에나 일치
str='cs-4';
regexp=/cs.4/;
console.log(str.match(regexp));

console.log('😄'); 

//^와 $는 정규식에서 특별한 뜻을 지닌다. 이것을 앵커라 한다.
//^는 ^test일시 문자열이 test로 시작하는지를 체크한다
//$는 test$일시 문자열이 test로 끝나는지를 체크한다
let str1='test aa';
let str2='aa test';
regexp=/^test/;
let regexp2=/test$/;
console.log(regexp.test(str1));
console.log(regexp2.test(str2));

//완전히 일치하는지 검사하기
let goodInput="12:34";
let badInput="12:345";

regexp=/^\d\d:\d\d$/;
console.log(regexp.test(goodInput));
console.log(regexp.test(badInput));

//m플래그로 여러 행 모드
str = `1st place: Winnie
2nd place: Piglet
3rd place: Eeyore`;

console.log( str.match(/^\d/gm) ); // 1, 2, 3