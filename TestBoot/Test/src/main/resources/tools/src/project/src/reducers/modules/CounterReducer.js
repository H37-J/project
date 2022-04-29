import produce from "immer";
import { createAction, handleActions } from "redux-actions";

const INCREASE = 'counter/INCREASE';

let number = -1;
export const increase = createAction(INCREASE, number => number);

const initialState = {
    number: -1
};

const counterReducer = handleActions(
    {
        [INCREASE]: (state , {payload: number}) => {
            produce(state, draft => {
                draft.number = number;
            })
        }
    },
    initialState,
);

export default counterReducer;