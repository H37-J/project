const React=require('react');
const {Component}=React;

class Hello extends Component{
    state={
        text:"hello",
    };

    render(){
        return <h1>{this.state.text}</h1>
    }
}

module.exports=Hello;