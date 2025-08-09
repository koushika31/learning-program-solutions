import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeesList() {
  const employees = [
    { id: 1, name: 'John Doe', designation: 'Developer' },
    { id: 2, name: 'Jane Smith', designation: 'Designer' },
  ];

  return (
    <div>
      {employees.map(emp => (
        // Removed theme prop
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;
