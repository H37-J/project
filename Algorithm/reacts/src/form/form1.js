import React, { Component } from 'react';

class form1 extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      check: true,
      age: 5
    };
  }

  handler = event => {
    const target = event.taget;
    const value = target.type === 'checkbox' ? target.chcked : target.value;
    const name = target.name;
    this.setState({
      [name]: value
    });
  };

  getAge = () => {
    alert(this.state.age);
  };

  render() {
    return (
      <div>
        <form>
          <h1>Multiple Input Controlled Form Example</h1>
          <label>
            check:
            <input
              name="check"
              type="checkbox"
              checked={this.state.check}
              onChange={this.handleInputChange}
            />
          </label>
          <br />
          <label>
            age:
            <input
              name="age"
              type="number"
              value={this.state.age}
              onChange={this.handleInputChange}
            />
          </label>
        </form>
        <button onClick={this.getAge}>get</button>
      </div>
    );
  }
}

export default form1;
