import React, { Component } from 'react';
import PropTypes from 'prop-types';

class propos1 extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: 'java'
    };
  }

  render() {
    return (
      <div>
        <JTP test={this.state.name} />
      </div>
    );
  }
}

class JTP extends React.Component {
  render() {
    return <div>{this.props.test}</div>;
  }
}

propos1.propTypes = {
  propArray: PropTypes.array.isRequired,
  propBool: PropTypes.bool.isRequired,
  propFunc: PropTypes.func,
  propNumber: PropTypes.number,
  propString: PropTypes.string
};
propos1.defaultProps = {
  propArray: [1, 2, 3, 4, 5],
  propBool: true,
  propFunc: function (x) {
    return x + 5;
  },
  propNumber: 1,
  propString: 'JavaTpoint',
  name: 'test'
};

export default propos1;
