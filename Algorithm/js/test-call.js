function say(){
    console.log(this.name);
}



let user={name:'hjk'};
let admin={name:'hani'};

say.call(user);
say.call(admin);

//call을 이용한 캐싱처리
let worker={
    somMethod(){
        return 1;
    },

    slow(x){
        console.log(x);
        return x * this.somMethod();
    }
};

function cachingDecorator(func){
    let cache=new Map();
    return function(x){
        if(cache.has(x)){
            return cache.get(x);
        }
        let result=func.call(this,x);
        cache.set(x,result);
        return result;
    }
}

worker.slow=cachingDecorator(worker.slow);

console.log(worker.slow(2));
console.log(worker.slow(2));

// func.call(context, ...args); // 전개 문법을 사용해 인수가 담긴 배열을 전달하는 것과
// func.apply(context, args);   // call을 사용하는 것은 동일합니다.
