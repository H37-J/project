import React, { Component } from 'react';

export default class Content extends Component {
    constructor(props) {
        super(props)

        this.state = {
            content: "Content"
        };
    }

    updateContent() {
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
                <button onClick = {this.updateContent.bind(this)} > Update Content </button>
            </div>
        )
    }

}

// Content.propTypes = {
//     contentTitle: React.PropTypes.string
// }