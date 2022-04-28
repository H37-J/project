let user = {
    name: 'hjk'
};

// 함수의 추가법
user.say = function() {
    console.log(this.name);
};

// user.say();

//this
user = {
    name: 'hjk2',

    say() {
        console.log(this.name); //this는 객체를 나타낸다
    }
};

// user.say();

//arrow 함수
user = {
    name: 'hjk3',

    say() {
        let arrow = () => console.log(this.name);
        arrow();
    }
};

// user.say();

// 객체의 순회
// Object.keys(obj) – 객체의 키만 담은 배열을 반환합니다.
// Object.values(obj) – 객체의 값만 담은 배열을 반환합니다.
// Object.entries(obj) – [키, 값] 쌍을 담은 배열을 반환합니다.

user = {
    name: 'hjk1',
    age: 28
};

for (let value of Object.values(user)) {
    console.log(value);
}