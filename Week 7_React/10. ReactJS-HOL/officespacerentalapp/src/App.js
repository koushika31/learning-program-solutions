import React from "react";
import officeImg from "./assets/office.jpg"; 

const officeSpaces = [
  {
    name: "DBS",
    rent: 50000,
    address: "Chennai",
    image: officeImg, 
  },
];

const App = () => {
  return (
    <div style={{ padding: "40px", textAlign: "center" }}>
      <h1 style={{ fontWeight: "bold" }}>Office Space , at Affordable Range</h1>

      {officeSpaces.map((office, index) => (
        <div key={index} style={{ marginBottom: "50px" }}>
          <img
            src={office.image}
            alt={office.name}
            style={{ width: "300px", height: "auto", margin: "20px auto" }}
          />
          <h2>Name: {office.name}</h2>
          <p
            style={{
              color: office.rent > 60000 ? "green" : "red",
              fontWeight: "bold",
            }}
          >
            Rent: Rs. {office.rent}
          </p>
          <p><strong>Address:</strong> {office.address}</p>
        </div>
      ))}
    </div>
  );
};

export default App;
