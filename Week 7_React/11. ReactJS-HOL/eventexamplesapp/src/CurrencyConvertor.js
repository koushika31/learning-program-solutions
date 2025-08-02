import React, { useState } from 'react';

function CurrencyConverter() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    if (currency === 'Euro') {
      const converted = amount * 80; // 1 Euro = ₹80 (example)
      alert(`Converting to ${currency} Amount is ${converted}`);
    }
  };

  return (
    <div>
      <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <div>
          Amount: <input value={amount} onChange={(e) => setAmount(e.target.value)} />
        </div>
        <div>
          Currency:
          <select value={currency} onChange={(e) => setCurrency(e.target.value)}>
            <option value="">Select</option>
            <option value="Euro">Euro</option>
          </select>
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default CurrencyConverter;
