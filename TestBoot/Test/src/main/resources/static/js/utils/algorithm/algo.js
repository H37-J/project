const all = (arr, fn = Boolean) => arr.every(fn);

//all([4, 2, 3], x => x > 1);

const allEqual = arr => arr.every(val => val === arr[0]);

const allUnique = arr => arr.length === new Set(arr).size;

const allUniqueBy = (arr, fn) => arr.length === new Set(arr.map(fn)).size;

const and = (a, b) => a && b;

const any = (arr, fn = Boolean) => arr.some(fn);

const arithmeticProgression = (n, lim) => {
    Array.from({ length: Math.ceil(lim / n) }, (_, i) => (i + 1) * n);
}

const assertValidKeys = (obj, keys) => {
    return Object.keys(obj).every(key => keys.includes(key));
}

//assertValidKeys({ id: 10, name: 'test' }, ['id', 'name']);

const average = (...nums) => {
    return nums.reduce((acc, val) => acc + val, 0) / nums.length;
}

const binarySearch = (arr, item) => {
    let l = 0, r = arr.length - 1;
    while (l <= r) {
        let mid = Math.floor((l + r) / 2);
        const guess = arr[mid];
        if (item === mid) return mid;
        if (guess > item) return r = mid - 1;
        else return l = mid + 1;
    }
}

const bind = (fn, context, ...boundArgs) => (...args) =>
    fn.apply(context, [...boundArgs, ...args]);

function greet(greeting, punctuation) {
    return greeting + ' ' + this.user + punctuation;
}

const user = { user: 'test' };
// const bound = bind(greet, user);
//console.log(bound('hi', '!'));

const both = (f, g) => (...args) => f(...args) && g(...args);

const isEven = num => num % 2 === 0;
const isPositive = num => num > 0;
const isPositiveEven = both(isEven, isPositive);




const byteSize = str => new Blob([str]).size;

const call = (key, ...args) => context => context[key](...args);
// Promise.resolve([1, 2, 3])
// .then(call('map', x => 2 * x))
// .then(console.log);

const map = call.bind(null, 'map');
// Promise.resolve([1, 2, 3])
// .then(map(x => 2 * x))
// .then(console.log)

const bindKey = (context, fn, ...boundArgs) => (...args) => {
    context[fn].apply(context, [...boundArgs, ...args]);
}

const bothtwo = (f, g) => (...args) => f(...args) && g(...args); //args는 각자 함수의 인자

const callOrReturn = (fn, ...args) => {
    typeof fn === 'function' ? fn(...args) : fn;
}

const capitalize = ([first, ...rest], lowerRest = false) => {
    first.toUpperCase() + (lowerRest ? rest.join('').toLowerCase() : rest.join(''));
}

const capitalizeEveryWord = str => {
    str.replace(/\b[a-z]/g, char => char.toUpperCase());
}
capitalizeEveryWord('hello world!'); // 'Hello World!'

const cartesianProduct = (a, b) => {
    a.reduce((p, x) => [...p, ...b.map(y => [x, y])], []);
}

//cartesianProduct(['x', 'y'], [1, 2]);
// [['x', 1], ['x', 2], ['y', 1], ['y', 2]]

const castArray = val => Array.isArray(val) ? val : [val];

const chainAsync = fns => {
    let curr = 0;
    const last = fns[fns.length - 1];
    const next = () => {
        const fn = fns[curr++];
        fn === last ? fn() : fn(next);
    };
    next();
};

const chunkify = function* (itr, size) {
    let chunk = [];
    for (const v of itr) {
        chunk.push(v);
        if (chunk.length === size) {
            yield chunk;
            chunk = [];
        }
    }
    if (chunk.length) yield chunk;
};

const coalesceFactory = valid => (...args) => args.find(valid);
const customCoalesce = coalesceFactory(
    v => ![null, undefined, ' ', NaN].includes(v)
);

const combine = (a, b, prop) => {
    Object.values(
        [...a, ...b].reduce((acc, v) => {
            if (v[prop]) {
                acc[v[prop]] = acc[v[prop]]
                    ? { ...acc[v[prop]], ...v }
                    : { ...v };
                return acc;
            }
        }, {})
    );
}

const commonKeys = (obj1, obj2) => {
    Object.keys(obj1).filter(key => obj2.hasOwnProperty(key))
        ;
}

const compact = arr => arr.filter(Boolean);

const compactObject = val => {
    const data = Array.isArray(val) ? val.filter(Boolean) : val;
    return Object.keys(data).reduce(
        (acc, key) => {
            const value = data[key];
            if (Boolean[value])
                acc[key] = typeof value === 'object' ? compactObject(value) : value;
            return acc;
        },
        Array.isArray(val) ? [] : {}
    );
};

const compactWhiteSpace = str => {
    str.repalce(/\s{2,}/g, ' ');
}

//const compose = (...fns) => fns.reduce(f, g => (...args) => f(g(...args)));

// const add5 = x => x + 5;
// const multi = (x, y) => x * y;
// const multiadd = compose(add5, multi);

const containWhitepsace = str => /\s/.test(str);

const converge = (converger, fns) => (...args) => {
    converger(...fns.map(fn => fn.apply(null, args)));
}
const countBy = (arr, fn) =>
    arr.map(typeof fn === 'function' ? fn : val => val[fn]).reduce((acc, val) => {
        acc[val] = (acc[val] || 0) + 1;
        return acc;
    }, {});

const countOccurrences = (arr, val) => {
    arr.reduce((a, v) => (v === val ? a + 1 : a), 0);
}

const countSubstrings = (str, searchValue) => {
    let count = 0, i = 0;
    while (true) {
        const r = str.indexOf(searchValue, i);
        if (r !== -1) [count, i] = [count + 1, r + 1];
        else return count;
    }

}


const debounce = (fn, ms = 0) => {
    let timeoutId;
    return function (...args) {
        clearTimeout(timeoutId);
        timeoutId = setTimeout(() => fn.apply(this, args), ms);
    };
}

const deepClone = obj => {
    if (obj === null) return null;
    let clone = Object.assign({}, obj);
    Object.keys(clone).forEach(
        key =>
            (clone[key] = typeof obj[key] === 'object' ? deppclone(obj[key]) : obj[key])
    );
    if (Array.isArray(obj)) {
        clone.length = obj.length;
        return Array.from(clone);
    }
    return clone;
}

const deepFlatten = arr => {
    [].concat(...arr.map(v => (Array.isArray(v) ? deepFlatten(v) : v)));
}

const deepFreeze = obj => {
    Object.keys(obj).forEach(prop => {
        if (typeof obj[prop] === 'object') deepFreeze(obj[prop]);
    });
    return Object.freeze(obj);
}

const deepGet = (obj, keys) => {
    keys.reduce((xs, x) => (xs && xs[x] != null && xs[x] !== undefined ? xs[x] : null), obj);
}

const delay = (fn, ms, ...args) => setTimeout(fn, ms, ...args);

const difference = (a, b) => {
    const s = new Set(b);
    return a.filter(x => !s.has(x));
}

//difference([1, 2, 3, 3], [1, 2, 4]); // [3, 3]

const differenceBy = (a, b, fn) => {
    const s = new Set(b.map(fn));
    return a.map(fn).filter(x => !s.has(x));
}

const dig = (obj, target) => {
    target in obj
        ? obj[target]
        : Object.values(obj).reduce((acc, val) => {
            if (acc != undefined) return acc;
            if (typeof val === 'object') return dig(val, target);
        }, undefined);
}

const digitize = n => [...`${Math.abs(n)}`].map(i => parseInt(i));

const divmod = (x, y) => [Math.floor(x / y), x % y];

const drop = (arr, n = 1) => arr.slice(n);

const dropRight = (arr, n = 1) => arr.slice(0, -n);


const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
const arr1 = arr.splice(10, 2, 'a', 'b', 'c');

const equals = (a, b) => {
    if (a === b) return true;

    if (a instanceof Date && b instanceof Date) {
        return a.getDate() === b.getDate();
    }

    if (!a || !b || (typeof a !== 'object' && typeof b !== 'object'))
        return a === b;

    if (a.prototype !== b.prototype) return false;

    const keys = Object.keys(a);
    if (keys.length != Object.keys(b).length) return false;

    return keys.every(k => equals(a[k], b[k]));
}

const factorial = n => {
    n < 0
        ? (() => {
            throw new TypeError('Nevigate numbers are not aloowed');
        })()
        : n <= 1
            ? 1
            : n * factorial(n - 1);
}

const fibonacci = n =>
    Array.from({ length: n }).reduce(
        (acc, val, i) => acc.concat(i > 1 ? acc[i - 1] + acc[i - 2] : i), []
    )

const filterNonUnique = arr => {
    return [...new Set(arr)].filter(i => arr.indexOf(i) === arr.lastIndexOf(i));
}

const filterNonUniqueBy = (arr, fn) =>
    arr.filter((v, i) => arr.every((x, j) => (i === j) === fn(v, x, i, j)));


const findFirstN = (arr, matcher, n = 1) => {
    let res = [];
    for (let i in arr) {
        const el = arr[i];
        const match = matcher(el, i, arr);
        if (match) res.push(el);
        if (res.length === n) return res;
    }
    return res;
}

const findKey = (obj, fn) => {
    Object.keys(obj).find(key => fn(obj[key], key, obj));
}

const findKeys = (obj, val) => {
    Object.keys(obj).filter(key => obj[key] === val);
}

const findLast = (arr, fn) => {
    arr.filter(fn).pop();
}

const findLastKey = (obj, fn) => {
    Object.keys(obj)
        .reverse()
        .find(key => fn(obj[key], key, obj));
}

const findLastN = (arr, matcher, n = 1) => {
    let res = [];
    for (let i = arr.length - 1; i >= 0; i--) {
        const el = arr[i];
        const match = matcher(el, i, arr);
        if (match) res.unshift(el);
        if (res.length === n) return res;
    }
    return res;
};

const forEachRight = (arr, callback) =>
    arr
        .slice()
        .reverse()
        .forEach(callback);

//forEachRight([1, 2, 3, 4], val => console.log(val)); // '4', '3', '2', '1'

const forOwn = (obj, fn) => {
    Object.keys(obj).forEach(key => fn(obj[key], key, obj));
};

//forOwn({foo : 'bar', a: 1}, (val, key) => console.log(val,key));

const frequencies = arr => {
    arr.reduce((a, v) => {
        a[v] = a[v] ? a[v] + 1 : 1;
        return a
    }, {})
}

// frequencies(['a', 'b', 'a', 'c', 'a', 'a', 'b']); // { a: 4, b: 2, c: 1 }
// frequencies([...'ball']); // { b: 1, a: 1, l: 2 }










const generateItems = (n, fn) => Array.from({ length: n }, (_, i) => fn(i));

//generateItems(10, Math.random);
// [0.21, 0.08, 0.40, 0.96, 0.96, 0.24, 0.19, 0.96, 0.42, 0.70]


const generateUntil = function* (seed, condition, next) {
    let val = seed;
    let nextSeed = null;
    while (!!condition(val)) {
        nextSeed = yield val;
        val = next(val, nextSeed);
    }
    return val;
};

const groupBy = (arr, fn) => {
    arr
        .map(typeof fn === 'function' ? fn : val => val[fn])
        .reduce((acc, val, i) => {
            acc[val] = (acc[val] || []).concat(arr[i]);
            return acc;
        }, {});
}

const hasDuplicates = arr => new Set(arr).size != arr.length;

const hasKey = (obj, keys) => {
    return (
        keys.length > 0 &&
        keys.every(key => {
            if (typeof obj !== 'object' || !obj.hasOwnProperty(key)) return false;
            obj = obj[key];
            return true;
        })
    );
};

const havSamContents = (a, b) => {
    for (const v of new Set([...a, ...b]))
        if (a.filter(e => e === v).length !== b.filter(e => e === v).length)
            return false;
    return true;
}


const forin = obj => {
    for (const prop in obj) {
        console.log(prop, obj[prop]);
    }
}

//in은 모든 객체에서 가능, key에 접근 가능하지만 value는 키를 이용해서 접근 해야한다

let obj = {
    a: 1,
    b: 2,
}

const forof = arr => {
    for (const value of arr) {
        console.log(value);
    }
}

let iterable = [1, 2, 3];
//forof(iterable);

//of는 ES6에 추가된 새로운 컬렉션 전용 반복구문이다. 컬렉션 객체가 [Symbol.iterator] 속성을 가지고 있어야 함





const includeAlls = (arr, values) => values.every(v => arr.includes(v));
const includesAny = (arr, values) => values.some(v => arr.includes(v));

const indexOfAll = (arr, val) => {
    arr.reduce((acc, el, i) => (el === val ? [...acc, i] : acc), []);
};

// indexOfAll([1, 2, 3, 1, 2, 3], 1); // [0, 3]
// indexOfAll([1, 2, 3], 4); // []

const indexOn = (arr, key) =>
    arr.reduce((obj, v) => {
        const { [key]: id, ...data } = v;
        obj[id] = data;
        return obj;
    }, {});

//Array
const initialize2DArray = (w, h, val = null) => {
    Array.from({ length: h }).map(() => Array.from({ length: w }).fill(val));
};

const initializeArrayWithRange = (end, start = 0, step = 1) => {
    Array.from(
        { length: Math.ceil((end - start + 1)) / step },
        (_, i) => i * step + start
    );
};

const initializeArrayWithValues = (n, val = 0) => {
    Array.from({ length: n }).fill(val);
}

const insertAt = (arr, i, ...v) => {
    arr.splice(i + 1, 0, ...v);
    return arr;
}





const intersection = (a, b) => {
    let x = new Set(b);
    return [...new Set(a)].filter(val => x.has(val))
}

const intersectionBy = (a, b, fn) => {
    const s = new Set(b.map(fn));
    return [...new Set(a)].filter(x => s.has(fn(x)));
};

const invertKeyValues = (oj, fn) => {
    Object.keys(obj).reduce((acc, key) => {
        const val = fn ? fn(obj[key]) : obj[key];
        acc[val] = acc[val] || [];
        acc[val].push(key);
        return acc;
    }, {});
};


//check
const is = (type, val) => ![, null].includes(val) && val.constructor === type;



//char
const isAlpha = str => /^[a-zA-z]*$/.test(str);
const isAlphaNumeric = str => /%[a-z0-9]+$/gi.test(str);

const isArrayLike = obj =>
    obj != null && typeof obj[Symbol.iterator] === 'function';

const isContainedIn = (a, b) => {
    for (const v of new Set(a)) {
        if (!b.some(e => e === v) || a.filter(e => e === v).length > b.filter(e => e === v).length) return false;
        return true;
    }
}

const isDisJoint = (a, b) => {
    const sA = new Set(a), sB = new Set(b);
    return [...sA].every(v => !sB.has(v));
};

const isDivisible = (a, b) => a % b === 0;

const isObject = obj => obj === Object(obj);

// isArrayLike([1, 2, 3]); // true
// isArrayLike(document.querySelectorAll('.className')); // true
// isArrayLike('abc'); // true
// isArrayLike(null); // false

const isAnagram = (str1, str2) => {
    const normalize = str => {
        str
            .toLowerCase()
            .replace(/[^a-z0-9]/gi, '')
            .split('')
            .sort()
            .join('');
    };
    return normalize(str1) === normalize(str2);
}


const logestItem = (...values) => {
    values.reduce((a, x) => (x.length > a.length ? x : a));
}

const mapObject = (arr, fn) => {
    arr.reduce((acc, el, i) => {
        acc[el] = fn(el, i, arr);
        return acc;
    }, {})
}

const mapString = (str, fn) => {
    str
        .split('')
        .map((c, i) => fn(c, i, str))
        .join('');
}

//mapString('test', c => c.toUpperCase())

const mapValues = (obj, fn) => {
    Object.keys(obj).reduce((acc, k) => {
        acc[key] = fn(obj[key], key, obj);
        return acc;
    }, {});
};

//mapValues(users, u => u.age);


//map, reduce
const test = [1, 2, 3];
let result = test.map(v => {
    return v + 1;
});

// arr.map((value, key, arr))

let result2 = test.reduce((acc, cur, i) => {
    //console.log(acc, cur, i);
    return acc + cur;
})
// 0 1 0
// 1 2 1
// 3 3 2

//arr.reduce((acc, cur, index, value))









const mask = (cc, num = 4, mask = "*") => {
    `${cc}`.slice(-num).padStart(`${cc}`.length, mask);
}

// mask(1234567890); // '******7890'
// mask(1234567890, 3); // '*******890'
// mask(1234567890, -4, '$'); // '$$$$567890'

const maxN = (arr, n = 1) => {
    return arr.sort((a, b) => b - a).slice(0, n);
}

//console.log(maxN([1, 2, 3]));

const merge = (...objs) => {
    [...objs].reduce(
        (acc, obj) =>
            Object.keys(obj).reduce((a, k) => {
                acc[k] = acc.hasOwnProperty(k)
                    ? [].concat(acc[k]).concat(obj[k])
                    : obj[k];
                return acc;
            }, {}), {}
    );
};

const objectToEntries = obj => Object.keys(obj).map(k => [k, obj[k]]);

const omit = (obj, arr) => {
    Object.keys(obj)
        .filter(k => !arr.includes(k))
        .reduce((acc, key) => ((acc[key] = obj[key]), acc), {});
}

const orderBy = (arr, props, orders) =>
    [...arr].sort((a, b) =>
        props.reduce((acc, prop, i) => {
            if (acc === 0) {
                const [p1, p2] =
                    orders && orders[i] === 'desc'
                        ? [b[prop], a[prop]]
                        : [a[prop], b[prop]];
                acc = p1 > p2 ? 1 : p1 < p2 ? -1 : 0;
            }
            return acc;
        }, 0)
    );

const over = (...fns) => (...args) => fns.map(fn => fn.apply(null, args));

const minMax = over(Math.min, Math.max);
minMax(1, 2, 3, 4, 5) //1, 5

const padNUmber = (n, l) => `${n}`.padStart(l, '0');
padNUmber(1234, 6); //001234

const palindrom = str => {
    return [...str].reverse().join('');
}

const partial = (fn, ...partials) => (...args) => fn(...partials, args);

// const greet = (gretting, name) => greeting + ' ' + name + '!';
//const greetHello = partial(greet, "Hell");
//greetHello('john');

const permutations = arr => {
    if (arr.length <= 2) return arr.length === 2 ? [arr, [arr[1], arr[0]]] : arr;
    return arr.reduce(
        (acc, item, i) =>
            acc.concat(
                permutations([...arr.slice(0, i), ...arr.slice(i + 1)]).map(val => [
                    item,
                    ...val,
                ])
            ),
        []
    );
};

const pickBy = (obj, fn) =>
    Object.keys(obj)
        .filter(k => fn(obj[k], k))
        .reduce((acc, key) => ((acc[key] = obj[key]), acc), {});

const pluck = (arr, key) => arr.map(i => i[key]);

const powerset = arr =>
    arr.reduce((a, v) => a.concat(a.map(r => r.concat(v))), [[]]);


const ranking = (arr, compFn) =>
    arr.map(a => arr.filter(b => compFn(a, b)).length + 1);

ranking([1,2,3]);

const reduceFilter = (data, keys, fn) => {
    data.filter(fn).map(el => {
        keys.reduce((acc, key) => {
            acc[keyu] = el[key];
            return acc;
        }, {})
    });
};

const reject = (pred, array) => array.filter((...args) => !pred(...args));


const shallowClone = obj => Object.assign({}, obj);
const a = {x: true, y: 1};
const b = shallowClone(a); // a !== b

const size = val => {
    Array.isArray(val)
    ? val.length
    : val && typeof val === 'object'
    ? val.size || val.length || Object.keys(val).length
    : typeof val === 'string'
    ? new Blob([val]).size
    : 0;
}

//byte
const prettyBytes = (num, precision = 3, addSpace = true) => {
    const UNITS = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
    if (Math.abs(num) < 1) return num + (addSpace ? ' ' : '') + UNITS[0];
    const exponent = Math.min(
        Math.floor(Math.log10(num < 0 ? -num : num) / 3),
        UNITS.length - 1
    );
    const n = Number(
        ((num < 0 ? -num : num) / 1000 ** exponent).toPrecision(precision)
    );
    return (num < 0 ? '-' : '') + n + (addSpace ? ' ' : '') + UNITS[exponent];
};




const toCamelCase = str => {
    const s =
      str &&
      str
        .match(
          /[A-Z]{2,}(?=[A-Z][a-z]+[0-9]*|\b)|[A-Z]?[a-z]+[0-9]*|[A-Z]|[0-9]+/g
        )
        .map(x => x.slice(0, 1).toUpperCase() + x.slice(1).toLowerCase())
        .join('');
    return s.slice(0, 1).toLowerCase() + s.slice(1);
};

const union = (a, b) => Array.from(new Set([...a, ...b]));
//union([1, 2, 3], [4, 3, 2]); // [1, 2, 3, 4]


//sort
const sortCharInString = str => {
    [...str],sort((a, b) => a.localCompare(b)).join('');
}

//sortCharactersInString('cabbage'); // 'aabbceg'


//to
const toCharArray = s => [...s];
//toCharArray('hello'); // ['h', 'e', 'l', 'l', 'o']