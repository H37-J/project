import React, { Component } from 'react';
import ReactDOM from 'react-dom';


export default class Head extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        const {headerTitle} = this.props;
        return (
            <div> {headerTitle} </div>
        )
    }
}

