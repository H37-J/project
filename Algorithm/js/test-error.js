let json="{bad json}"

try{
    let user=JSON.parse(json);
    console.log(user.name);
}catch(err){
    console.log(err.name);
    console.log(err.message);
    console.log(err.stack);
}


//custom error(throw)

let json2='{"age":30}';

try{
    let user=JSON.parse(json2);

    if(!user.name){
        throw new SyntaxError("불완전한 데이터:이름없음");
    }
    console.log(user.name);
}catch(e){
    console.log(e.message);
}

//커스텀 에러

//Error객체의 기본 구조
// class Error{
//     constructor(message) {
//         this.message=message;
//         this.name="Error";
//         this.stack=<call stack>;
//     }
// }

class ValidationError extends Error{
    constructor(message){
        super(message);
        this.name="ValidateionError";
    }
}

function test(){
    throw new ValidationError("에러 발생!!");
}

try{
    test();
}catch(err){
    console.log(err);
}
