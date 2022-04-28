import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { Route, Link, NavLink, BrowserRouter as Router } from 'react-router-dom';
import Test from '../Test/Test';
import Rendering from '../rendering/rendering1';
import Map1 from '../rendering/Map1';

class R extends React.Component {
  render() {
    return (
      <Router>
        <ul>
          <li>
            <NavLink to="/" exact activeStyle={{ color: 'red' }}>
              Home
            </NavLink>
          </li>
          <li>
            <NavLink to="/Map" exact activeStyle={{ color: 'green' }}>
              About
            </NavLink>
          </li>
          <li>
            <NavLink to="/Rendering" exact activeStyle={{ color: 'magenta' }}>
              Contact
            </NavLink>
          </li>
        </ul>
        <div>
          <switch>
            <Route exact path="/" component={Test} />
            <Route path="/Map" component={Map1} />
            <Route path="/Rendering" component={Rendering} />
          </switch>
        </div>
      </Router>
    );
  }
}

export default R;
