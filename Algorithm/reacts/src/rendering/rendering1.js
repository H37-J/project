import React, { Component } from 'react';
import ReactDOM from 'react-dom';

class rendering1 extends React.Component {
  render() {
    const myList = ['Peter', 'Sachin', 'Kevin', 'Dhoni', 'Alisa'];
    const listItems = myList.map(myList => {
      return <li>{myList}</li>;
    });

    return <div>{listItems}</div>;
  }
}

export default rendering1;
