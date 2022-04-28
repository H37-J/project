import React, { Component } from 'react';
import Content from './Content';
import Head from './Head';

export default class App extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        const {headerTitle} = this.props;
        const {contentTitle} = this.props;
        
        return (
            <div>
                <Head headerTitle = {headerTitle} />
                <Content contentTitle = {contentTitle} />
            </div>
        )
    }
}

App.defaultProps = {
    headerTitle: 'Default Header',
    contentTitle: 'Default Content'
}