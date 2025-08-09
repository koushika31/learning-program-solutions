import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  const titleStyle = {
    color:
      cohort.status.toLowerCase() === 'ongoing'
        ? 'green'
        : cohort.status.toLowerCase() === 'scheduled'
        ? 'blue'
        : 'black'
  };

  return (
    <div className={styles.box}>
      <div className={styles.title} style={titleStyle}>
        {cohort.name}
      </div>
      <dl>
        <dt>Started On</dt>
        <dd>{cohort.startDate}</dd>

        <dt>Current Status</dt>
        <dd>{cohort.status}</dd>

        <dt>Coach</dt>
        <dd>{cohort.coach}</dd>

        <dt>Trainer</dt>
        <dd>{cohort.trainer}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
