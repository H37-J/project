const forOwn = (obj, fn) => Object.keys(obj).forEach(key => fn(obj[key], key, obj));

forOwn({ key: 'bar', value: 'value' }, v => console.log(v));
