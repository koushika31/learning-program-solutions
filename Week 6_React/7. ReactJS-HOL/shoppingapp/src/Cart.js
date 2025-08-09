import React, { Component } from 'react';

class Cart extends Component {
  render() {
    return (
      <div>
        <h4>Item Name: {this.props.itemname}</h4>
        <p>Price: {this.props.price}</p>
      </div>
    );
  }
}

export default Cart;
