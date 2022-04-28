import React, { Component } from 'react';
import { CSSTranstionGroup } from 'react-transition-group';

class Items extends React.Component {
  constructor(props) {
    super(props);
    this.state = { items: ['Blockchain', 'ReactJS', 'TypeScript', 'JavaTpoint'] };
  }

  handleAdd = () => {
    const newItems = this.state.items.concat([prompt('Enter Item')]);
    this.setState({ items: newItems });
  };

  handleRemove = index => {
    let newItems = this.state.items.slice();
    newItems.splice(index, 1);
    this.setState({ items: newItems });
  };

  render() {
    const items = this.state.items.map((item, index) => (
      <div key={item} onClick={() => this.handleRemove(index)}>
        {item}
      </div>
    ));

    return (
      <div>
        <h1>Animation Example</h1>
        <button onClick={this.handleAdd}>Insert Item</button>
        <CSSTranstionGroup
          transitionName="example"
          transitionEnterTimeout={800}
          transitionLeaveTimeout={600}
        >
          {items}
        </CSSTranstionGroup>
      </div>
    );
  }
}

export default Items;
