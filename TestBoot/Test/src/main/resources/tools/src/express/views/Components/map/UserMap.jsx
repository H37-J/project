import React, { Component } from 'react';

class MapApp extends Component {
    render() {
        return (
            <UserMap/>
        );
    }
}

class UserMap extends Component {
    constructor(props) {
        super(props);
        this.state = {
            users: [
                {name: 'test1', age:1},
                {name: 'test2', age:2},
                {name: 'test3', age:3},
            ]
        };
    }

    render() {
        return (
            <div>
                <h1>Contacts</h1>
                <div>
                    {this.state.users.map((user, key) => {
                        return (<UserSpan name = {user.name}
                        age = {user.age} 
                        key = {key}/>);
                    })}
                </div>
            </div>
        )
    }
}

class UserSpan extends Component {
    render() {
        return (
            <span>{this.props.name} {this.props.age}</span>
        );
    }
}