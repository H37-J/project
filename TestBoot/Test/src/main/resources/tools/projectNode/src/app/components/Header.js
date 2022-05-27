import React, { Component } from 'react';

export default class Header extends Component {
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

