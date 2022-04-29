import React, { useCallback } from "react";
import { useDispatch, useSelector } from "react-redux"
import Counter from "../../components/Counter/Counter";
import { increase } from "../modules/CounterReducer";


const CounterContainer = () => {
    const number = useSelector(state => state.counterReducer.number);
    const dispatch = useDispatch();
    const onIncrease = useCallback(() => dispatch(increase()), [dispatch]);


    return (
        <Counter number={number} onIncrease={onIncrease} />
    );
};

export default CounterContainer;