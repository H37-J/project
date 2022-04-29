import axios from 'axios';
import React, { Component } from 'react'
import { connect } from 'react-redux';
import { receiveValue } from '../../actions/CounterAction';
import counterReducer from '../../reducers/modules/CounterReducer';
import Spinner from '../Spinner/Spinner';
import style from './Counter.css';

class Counter extends Component {
    
    constructor(props) {
        super(props);
    }

    onClick = () => {
        axios.post('/counter').then(res => {
            this.props.onIncrease(res.data.number);
        });
    }
    
    componentDidMount() {
        let getNumber = () => {
            axios.get('/counter').then(res => {
                this.props.onIncrease(res.data.number);
                setTimeout(getNumber, 1000 * 5);
            });
        }
        setTimeout(getNumber, 1000);
    }

    componentDidUpdate() {
        this.element.classList.remove(style.bound);
        this.element.offsetWidth;
        this.element.classList.add(style.bound);
    }

    render() {
        const number = (
            <div className={style.number} ref={ref => {this.element = ref}}>
                {this.props.number}
            </div>
        );
    
        const spinner = (
            <Spinner />
        );

        return (
            <div className={style.container} onClick={this.onClick}>
                <div className={style.center}>
                    {(this.props.number == -1) ? spinner : number}
                </div>
            </div>
        );
    }
}

export default Counter;