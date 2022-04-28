
import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import { Provider  } from 'react-redux';
import ReduxApp from './ReduxApp';
import counterApp from '../reducers';

const store = createStore(counterApp);

ReactDOM.render(
    <Provider store = {store}>
        <ReduxApp />
    </Provider>,
);