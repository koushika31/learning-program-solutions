import React, { useState } from 'react';
import EmployeesList from './EmployeesList';
import ThemeContext from './ThemeContext';

function App() {
  const [theme, setTheme] = useState('light');

  return (
    <ThemeContext.Provider value={theme}>
      <div>
        <h1>Employee Management</h1>
        {/* Removed passing theme as props */}
        <EmployeesList />
        <button onClick={() => setTheme(prev => prev === 'light' ? 'dark' : 'light')}>
          Toggle Theme
        </button>
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
