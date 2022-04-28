import React, { Component } from 'react';
import RandomNumber from './RandomNumber';


class ButtonApp extends Component {
    constructor(props) {
        super(props);

        this.state = {
            value: Math.round(Math.random * 100)
        };

        this.udpateValue = this.updateVlaue.bind(this);
    }

    updateValue(randomValue) {
        this.setState({
            value: randomValue
        });
    } 

    render(){
        return (
            <div>
                <RandomNumber number = {this.state.value}
                    onUpdate = {this.updateValue} />
            </div>
        )
    }
}