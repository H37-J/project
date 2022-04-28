const message = () => {
    const name = 'test';
    const age = 40;
    return name + 'is' + age;
};

export default message;

import {message} from './module.js';


const name = 'test';
const age = 14;

export {name, age};