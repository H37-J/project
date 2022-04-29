import React, { useCallback, useReducer, useRef, useState } from 'react';
import Header from './components/Header';
import Content from './components/Content';
import Counter from './components/Counter/Counter';
import Spinner from './components/Spinner/Spinner';
import { Routes, Route } from 'react-router';
import CounterContainer from './reducers/containers/CounterContainer';


const App = () => {
    return (
        <div>
        <Routes>
            <Route path="/" element={<CounterContainer />} />
            <Route path="/content" element={<Content />} />
        </Routes>
        </div>
    );
};

export default App;