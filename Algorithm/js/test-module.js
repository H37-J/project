//export지시자를 변수나 함수 앞에 붙이면 외부 모듈에서 해당 변수나 함수에 접근할 수 있다
export function say(user){
    console.log(`${user}`);
}

export let admin={};

//import를 이용해서 불러온다
import {say,admin} from './say.js';
console.log(say);
say('hjk');

//import할 것이 면으면 imprt * as from 과 같이 가능


//export default는 모듈이 하나만 있다는걸 명시해준다 보통 이 방법을 더 많이 사용한다
export default class User{
    constructor(name){
        this.name=name;
    }
}