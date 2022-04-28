let str="test";

console.log(str.toUpperCase());



// 문자열 str은 원시값이므로 원시값의 프로퍼티(toUpperCase)에 접근하는 순간 특별한 객체가 만들어집니다. 
// 이 객체는 문자열의 값을 알고 있고, toUpperCase()와 같은 유용한 메서드를 가지고 있습니다.
// 메서드가 실행되고, 새로운 문자열이 반환됩니다(alert 창에 이 문자열이 출력됩니다).
// 특별한 객체는 파괴되고, 원시값 str만 남습니다.
