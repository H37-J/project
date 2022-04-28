//for of
let str = 'hello';

for (let char of str) {
    // console.log(char);
}

//유사배열의 특성
console.log(str[0]);

//문자의 불변성(특정문자 변경방법)

function sc(str, c_str, index) {
    let newstr = '';
    for (let i = 0; i < str.length; i++) {
        if (index == i) {
            newstr += c_str;
            continue;
        }
        newstr += str[i];
    }

    return newstr;
}

let c_str = sc(str, 's', 0);
console.log(c_str);

//indexof(부분 문자열 찾기) 없을시 -1
str = 'test1 test2';
console.log(str.indexOf('test2')); //6

//startWith,endsWith
console.log(str.startsWith('test1'));

//substring(slice와 같지만 start가 end보다 커도 오류가 발생하지 않음)
console.log(str.substring(1, 3));

//substr(start부터 시작해,length만큼 반환)
console.log(str.substr(0, 3)); //0인덱스부터 3개