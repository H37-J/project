import React, { Component } from 'react';

export default class RandomNumber extends Component {
    constructor(props) {
        super(props);
        this.updateNumber = this.updateNumber.bind(this);
    }
    
    updateNumber() {
        let value = Maht.round(Math.random() * 100);
        this.props.onUpdate(value);
    }

    render() {
        return (
            <div>
                <div>RANDOM NUMBER: {this.props.number}</div>
                <button onClick={this.updateNumber}>랜덤숫자</button>
            </div>
        )
    }
}