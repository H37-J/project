import React from 'react';
import Header from './components/Header';
import Content from './components/Content';
import Counter from './components/Counter/Counter';
import Spinner from './components/Spinner/Spinner';

export default class App extends React.Component {
    render() {
        return (
            <div>
                <Counter />
            </div>
        )
    }
}
