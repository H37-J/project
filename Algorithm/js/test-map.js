let map = new Map();

//set
map.set(1, 'hjk1');
map.set(2, 'hjk2');

//get
console.log(map.get(2));

//has
console.log(map.has(1));

//size
console.log(map.size);

//keys
for (let value of map.keys()) {
    console.log(value);
}

//values
for (let value of map.values()) {
    console.log(value);
}

//entry
for (let entry of map) {
    console.log(entry);
}

//fromEntries(일반객체로 변경)
let obj = Object.fromEntries(map.entries());

console.log(obj);

//delete
map.delete(1);
console.log(map);

//clear
map.clear();


//map을 이용한 사용자 방문횟수 저장
let visitingCountMap=new Map();

function countUser(user){
    let count = visitingCountMap.get(user) || 0;
    visitingCountMap.set(user,count+1);
}

let hjk={name:"hjk"}

countUser(hjk);

hjk=null;
//맵은 이렇게 해도 메모리에서 삭제 되지 않는다
//하지만 WeakMap을 사용하면 메모리에서 삭제된다

//위크맵을 사용한 캐싱처리
let cache=new WeakMap();

function process(obj){
    if(!cache.has(obj)){
        let result=obj;

        cache.set(obj,result);
    }

    return cache.get(obj);
}

let result1=process(obj);
let result2=process(obj);