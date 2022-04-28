import axios from 'axios';
import React, { Component } from 'react'
import { connect } from 'react-redux';
import { receiveValue } from '../../actions/CounterAction';
import Spinner from '../Spinner/Spinner';
import style from './Counter.css';

class Counter extends Component {
    
    constructor(props) {
        super(props);
    }

    onClick = () => {
        axios.post('/counter').then(res => {
            this.props.onReceive(res.data.number);
        });
    }
    
    componentDidMount() {
        let getNumber = () => {
            axios.get('/counter').then(res => {
                this.props.onReceive(res.data.number);
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
                {this.props.value}
            </div>
        );
    
        const spinner = (
            <Spinner />
        );

        return (
            <div className={style.container} onClick={this.onClick}>
                <div className={style.center}>
                    {(this.props.value == -1) ? spinner : number}
                </div>
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        value: state.value
    };
};

const mapDispatchToProps = (dispatch) => {
    return {
        onReceive: (value) => {
            dispatch(receiveValue(value));
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Counter);