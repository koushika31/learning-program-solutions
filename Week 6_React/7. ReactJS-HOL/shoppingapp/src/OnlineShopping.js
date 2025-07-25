import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  render() {
    const items = [
      { itemname: "Pencil", price: 5 },
      { itemname: "Pen", price: 10 },
      { itemname: "Notebook", price: 20 },
      { itemname: "Eraser", price: 3 },
      { itemname: "Scale", price: 7 }
    ];

    return (
      <div>
        <h2>Online Shopping Cart</h2>
        {items.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
