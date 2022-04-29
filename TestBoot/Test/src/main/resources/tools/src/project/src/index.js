import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { BrowserRouter } from 'react-router-dom';
import { createStore } from 'redux';
import App from './App';
import { composeWithDevTools } from 'redux-devtools-extension';
import rootReducer from './reducers/modules/RootReducer';

const store = createStore(rootReducer, composeWithDevTools());
const rootElement = document.getElementById('root');
ReactDOM.render(
    <Provider store={store}>
        <BrowserRouter>
            <App />
        </BrowserRouter>
    </Provider>, rootElement
);