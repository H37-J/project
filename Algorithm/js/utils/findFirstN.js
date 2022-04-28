const findFistN = (arr, matcher , n = 1) => {
    let res = [];
    for(let i in arr){
        const el = arr[i];
        const match = matcher(el, i , arr);
        if(match) res.push(el);
        if(res.length === n)   return res;
    }
    return res;
};

