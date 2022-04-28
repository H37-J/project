import arr from './array/arr.js';

//생성방법
let a = new Array();
a = [1, 2, 3];

//forin
for (let key in a) {
  console.log(a[key]);
}

//length로 배열 줄이기(length는 배열내의 개수가 아닌 가장 큰 인덱스의 +1이다,1,2,3,4,5가 있는 배열에 arr.length=2 로하면 1,2로 배열이 줄어든다)
a.length = 0; //배열 초기화

//splice
let arr1 = ['I', 'study', 'JavaScript'];

arr1.splice(1, 1); // 인덱스 1부터 요소 한 개를 제거

console.log(arr1); // ["I", "JavaScript"]
arr1 = ['I', 'study', 'JavaScript'];
arr1.splice(2, 0, 'complex', 'language');
console.log(arr1); // "I", "study", "complex", "language", "JavaScript"

//slice
let arr2 = ['t', 'e', 's', 't'];
let arr2_copy = arr2.slice(1, 3); //두번째 인덱스는 포함 x
console.log(arr2_copy);

//indexOf
let index_result = arr.indexOf(arr2, 't');
console.log(index_result);

//find
let user = [
  { id: 1, name: 'hjk1' },
  { id: 2, name: 'hjk2' }
];

let find_result = user.find(index => index.id == 1);
console.log(find_result);

//filter
let user2 = [
  { id: 1, name: 'hjk1' },
  { id: 2, name: 'hjk2' }
];

let filter_result = user2.filter(index => index.id > 1);
console.log(filter_result);

//map
let user3 = [
  { id: 1, name: 'hjk1' },
  { id: 2, name: 'hjk22' }
];

let map_result = user3.map(index => index.name.length);
console.log(map_result);

//compare
function compareNumeric(a, b) {
  if (a > b) return 1;
  if (a == b) return 0;
  if (a < b) return -1;
}

//sort
let sort_arr = [1, 2, 15];

sort_arr.sort(compareNumeric);

// console.log(sort_arr);

//split(문자열을 배열로 나눈다)
let names = 'test1,test2,test3';
let split_arr = names.split(',');

for (let name of split_arr) {
  console.log(name);
}

//reduce()
// let value = arr.reduce(function(accumulator, item, index, array) {
//     // ...
//   }, [initial]);

let reduce_arr = [1, 2, 3, 4, 5];

let reduce_result = reduce_arr.reduce((sum, currnt) => sum + currnt, 0);
console.log(reduce_result);
