import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import App from './App';
import counterReducer from './reducers/CounterReducer';

const store = createStore(counterReducer);
const rootElement = document.getElementById('root');
ReactDOM.render(
    <Provider store={store}>
        <App/>
    </Provider>, rootElement
);