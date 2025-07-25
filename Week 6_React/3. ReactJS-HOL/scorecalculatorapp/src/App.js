import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore name="Koushika" school="Kurinji Senior Secondary School" total={425} goal={5} />
    </div>
  );
}

export default App;
