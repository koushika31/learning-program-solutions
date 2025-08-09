import React from "react";

const IndianPlayers = () => {
  const allPlayers = ["Sachin1", "Dhoni2", "Virat3", "Rohit4", "Yuvaraj5", "Raina6"];

  // Destructuring odd and even players
  const oddPlayers = [allPlayers[0], allPlayers[2], allPlayers[4]];
  const evenPlayers = [allPlayers[1], allPlayers[3], allPlayers[5]];

  // Merging two arrays
  const T20players = ["Mr. First Player", "Mr. Second Player", "Mr. Third Player"];
  const ranjiPlayers = ["Mr. Fourth Player", "Mr. Fifth Player", "Mr. Sixth Player"];
  const mergedPlayers = [...T20players, ...ranjiPlayers];

  return (
    <div style={{ padding: "20px" }}>
      <h2>Odd Players</h2>
      <ul>
        <li>First : {oddPlayers[0]}</li>
        <li>Third : {oddPlayers[1]}</li>
        <li>Fifth : {oddPlayers[2]}</li>
      </ul>

      <hr />

      <h2>Even Players</h2>
      <ul>
        <li>Second : {evenPlayers[0]}</li>
        <li>Fourth : {evenPlayers[1]}</li>
        <li>Sixth : {evenPlayers[2]}</li>
      </ul>

      <hr />

      <h2>List of Indian Players Merged:</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
