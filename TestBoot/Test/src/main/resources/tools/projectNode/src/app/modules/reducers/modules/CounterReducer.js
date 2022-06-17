import produce from "immer";
import { createAction, handleActions } from "redux-actions";

const INCREASE = 'CounterReducer/INCREASE';

export const increase = createAction(INCREASE, number => number);

const initialState = {
    number: -1
};

const CounterReducer = handleActions(
    {
        [INCREASE]: (state , {payload: number}) => 
            produce(state, draft => {
                draft.number = number;
            }),
    },
    initialState,
);

export default CounterReducer;