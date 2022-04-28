import React, { Component } from 'react';
import ReactDOM from 'react-dom';


export default class Content extends Component {
    constructor(props) {
        super(props)

        this.state = {
            content: "Contents"
        };
    }

    updateContent = () => {
        this.setState({
            content: "Content Change"
        });
    }

    render() {
        const {contentTitle} = this.props;
        return (
            <div> 
                <div>{contentTitle}</div>
                <div>{this.state.content}</div>
                <button onClick = {this.updateContent} > Update Content </button>
            </div>
        )
    }
}

// Content.propTypes = {
//     contentTitle: React.PropTypes.string
// }