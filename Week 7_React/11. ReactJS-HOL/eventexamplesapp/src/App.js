import React, { useState } from 'react';

function App() {
  const [count, setCount] = useState(1);
  const [amount, setAmount] = useState('80');
  const [currency, setCurrency] = useState('Euro');

  const handleIncrement = () => {
    setCount(prev => prev + 1);
    alert('Hello Member1'); // Message after increment
  };

  const handleDecrement = () => {
    setCount(prev => prev - 1);
  };

  const sayWelcome = (msg) => {
    alert(`Hello! ${msg}`);
  };

  const handleClick = () => {
    alert('I was clicked');
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (currency === 'Euro') {
      const result = parseFloat(amount) * 80;
      alert(`Converting to  ${currency} Amount is ${result}`);
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <div>{count}</div>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={handleDecrement}>Decrement</button>
      <br /><br />
      <button onClick={() => sayWelcome('Welcome')}>Say welcome</button>
      <br /><br />
      <button onClick={handleClick}>Click on me</button>
      <br /><br />

      <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>

      <form onSubmit={handleSubmit}>
        <div>
          <label>Amount: </label>
          <input
            type="text"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
        </div>
        <br />
        <div>
          <label>Currency: </label>
          <select
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
          >
            <option value="">Select</option>
            <option value="Euro">Euro</option>
          </select>
        </div>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
