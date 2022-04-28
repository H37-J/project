import React, { Compoenet } from 'react';

class State1 extends React.Component {
  constructor() {
    super();
    this.state = { display: true };
    this.toggle = this.toggle.bind(this);
  }

  toggle() {
    this.setState({ display: !this.state.display });
  }

  render() {
    const name = this.state.display ? (
      <div>
        true <button onClick={this.toggle}>false</button>{' '}
      </div>
    ) : (
      <div>
        false <button onClick={this.toggle}>true</button>
      </div>
    );

    return (
      <div>
        <h1>welcome</h1>
        {name}
      </div>
    );
  }
}

export default State1;
