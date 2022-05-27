import React from "react";
import {useSelector } from "react-redux"
import Counter from "../../components/counter/Counter";
import useActions from "../lib/useActions";
import { increase } from "../modules/CounterReducer";


const CounterContainer = () => {
    const number = useSelector(state => state.CounterReducer.number);
    const [onIncrease] = useActions(
        [increase],
        []
    );

    return (
        <Counter number={number} onIncrease={onIncrease} />
    );
};

export default CounterContainer;