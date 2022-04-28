import React from 'react';
import Counter from './Counter';
import Buttons from './Buttons';
import Options from './Options';

class ReduxApp extends React.Component {
    render(){
        return (
            <div style={ {textAlign: 'center'} }>
                <Counter/>
                <Options/>
                <Buttons/>
            </div>
        );
    }

}

export default ReduxApp;