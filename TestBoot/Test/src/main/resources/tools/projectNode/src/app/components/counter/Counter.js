import axios from 'axios';
import React, { Component, useEffect } from 'react'
import Spinner from '../spinner/Spinner';
import style from './Counter.css';

const Counter = ({ number, onIncrease }) => {
    useEffect(() => {
        console.log(number);
        console.log(onIncrease);
    },[number])
    
    return (
        <div>
       
        </div>
    )
}

export default Counter;