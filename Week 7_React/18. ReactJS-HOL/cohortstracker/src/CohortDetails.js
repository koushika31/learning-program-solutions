import React from 'react';

function CohortDetails({ cohort }) {
  if (!cohort) return <p>No data</p>;

  return (
    <div className="cohort-card">
      <h3>{cohort.cohortCode}</h3>
      <p>Start Date: {cohort.startDate}</p>
      <p>Technology: {cohort.technology}</p>
      <p>Trainer: {cohort.trainerName}</p>
      <p>Coach: {cohort.coachName}</p>
      <p>Status: {cohort.currentStatus}</p>
    </div>
  );
}

export default CohortDetails;
