import React from "react";

const ListofPlayers = () => {
  const players = [
    { name: "Sachin", score: 98 },
    { name: "Dhoni", score: 60 },
    { name: "Virat", score: 45 },
    { name: "Rohit", score: 77 },
    { name: "Yuvaraj", score: 39 },
    { name: "Raina", score: 88 },
    { name: "Jadeja", score: 51 },
    { name: "Bumrah", score: 69 },
    { name: "Ashwin", score: 92 },
    { name: "Gill", score: 36 },
    { name: "Shami", score: 71 },
  ];

  // Arrow function to filter below 70
  const below70 = players.filter(p => p.score < 70);

  return (
    <div style={{ padding: "20px" }}>
      <h2>All Players:</h2>
      <ul>
        {players.map((p, index) => (
          <li key={index}>{p.name} - {p.score}</li>
        ))}
      </ul>

      <h3>Players with Score Below 70:</h3>
      <ul>
        {below70.map((p, index) => (
          <li key={index}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
