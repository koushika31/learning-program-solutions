import React from 'react';

function App() {
  const items = [
    { name: 'Laptop', price: 80000 },
    { name: 'TV', price: 120000 },
    { name: 'Washing Machine', price: 50000 },
    { name: 'Mobile', price: 30000 },
    { name: 'Fridge', price: 70000 }
  ];

  const tableStyle = {
    border: '1px solid gray',
    borderCollapse: 'collapse',
    margin: 'auto',
    textAlign: 'center',
    fontFamily: 'Arial',
    color: 'teal'
  };

  const thStyle = {
    fontWeight: 'bold',
    color: 'green'
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '40px' }}>
      <h1 style={{ color: 'green' }}>Items Ordered :</h1>
      <table style={tableStyle}>
        <thead>
          <tr>
            <th style={{ ...tableStyle, ...thStyle }}>Name</th>
            <th style={{ ...tableStyle, ...thStyle }}>Price</th>
          </tr>
        </thead>
        <tbody>
          {items.map((item, index) => (
            <tr key={index}>
              <td style={tableStyle}>{item.name}</td>
              <td style={tableStyle}>{item.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
