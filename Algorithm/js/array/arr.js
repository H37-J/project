export default class arr {
    num = 1;

    constructor(arr) {
        this.arr = arr;
        this.value = 'default';
    }

    static forin(arr) {
        for (const key in arr) {
            console.log(arr[key]);
        }
    }

    forin() {
        for (const key in this.arr) {
            console.log(this.arr[key]);
        }
    }

    forof() {
        for (const item of this.arr) {
            console.log(item);
            //this는 함수호출자 객체를 가리킨다
        }
    }

    static forof(arr) {
        for (const item of arr) {
            console.log(item);
        }
    }

    from() {
        return Array.from(this.value);
    }

    static from(value) {
        return Array.from(value); //value를 배열로 각각 분해
    }

    //배열생성
    static of(...value) {
        return Array.of(...value);
    }

    static push(arr, value) {
        arr.push(value);
    }

    static concat(arr, value) {
        console.log(value);
        arr.join(`\'${value}\'`);
    }

    static reverse(arr) {
        return arr.reverse();
    }

    static slice(arr, start, end) {
        arr.slice(start, end);
        //end is not inlcuded
    }

    static splice(arr, addarr) {
        Array.prototype.splice.apply(arr, [1, 0].concat(addarr));
    }

    static indexOf(arr, index) {
        return arr.indexOf(index);
    }
}
//객체생성
// let a = new arr([1, 2, 3]);
// a.forof();

// //스태틱
// let array = [1, 2, 3, 4];
// arr.forof(array);

// //배열로 각각 분해
// console.log(a.from());
// console.log(arr.from('test'));

// //배열생성
// let arrof = arr.of('String', 'test');
// console.log(arrof);

// //배열 추가
// arr.push(array, 5);
// console.log(array);

// let result = array.join('');
// console.log(result);