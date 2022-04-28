import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Test from './Test/Test';
import State1 from './State/State1';
import Form1 from './form/form1';
import Rendering from './rendering/rendering1';
import R from './Router/Router';
import Map1 from './rendering/Map1';
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
    <R />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
