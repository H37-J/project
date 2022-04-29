import { combineReducers } from "redux";
import counterReducer from "./CounterReducer";

const RootReducer = combineReducers({
    counterReducer,
});

export default RootReducer;