import React, { Component } from 'react';
import './Spinner.scss';

export default class Spinner extends Component {
    render() {
        return (
            <div className="spinner">
                <div className="rect1"></div>
                <div className="rect2"></div>
                <div className="rect3"></div>
                <div className="rect4"></div>
            </div>
        );

    }
}