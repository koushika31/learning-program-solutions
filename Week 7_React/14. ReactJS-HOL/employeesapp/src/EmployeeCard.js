import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext); 

  const buttonStyle = {
    backgroundColor: theme === 'light' ? '#eee' : '#333',
    color: theme === 'light' ? '#000' : '#fff',
    padding: '8px 16px',
    border: 'none',
    margin: '10px',
    borderRadius: '4px',
  };

  return (
    <div style={{ marginBottom: '20px' }}>
      <h3>{employee.name}</h3>
      <p>{employee.designation}</p>
      <button style={buttonStyle}>View Profile</button>
    </div>
  );
}

export default EmployeeCard;
