const memoize = fn => {
    const cache = new Map();
    const chached = function (val){
        return chached.has(val)
        ? cache.get(val)
        : cache.set(val, fn.call(this,val)) && cache.get(val);
    };
    cached.cache = cache;
    return cached;
}