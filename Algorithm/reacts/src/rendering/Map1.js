import React, { Component } from 'react';
import ReactDOM from 'react-dom';

function M(p) {
  const data = (
    <ol>
      {p.data.map(show => (
        <li key={show.id}>{show.title}</li>
      ))}
    </ol>
  );

  return <div>{data}</div>;
}

class Map1 extends React.Component {
  render() {
    const data = [
      { id: 1, title: 'First' },
      { id: 2, title: 'second' }
    ];
    return <M data={data} />;
  }
}

export default Map1;
