import React from 'react';
import { render, screen } from '@testing-library/react';
import CohortDetails from './CohortDetails';
import { CohortsData } from './Cohort';

describe('CohortDetails Component', () => {
  test('renders cohort code in heading', () => {
    render(<CohortDetails cohort={CohortsData[0]} />);
    const heading = screen.getByRole('heading', { level: 3 });
    expect(heading).toHaveTextContent(CohortsData[0].cohortCode);
  });

  test('renders status text', () => {
    render(<CohortDetails cohort={CohortsData[0]} />);
    expect(screen.getByText(/Scheduled|Ongoing/i)).toBeInTheDocument();
  });

  test('renders all cohort details', () => {
    render(<CohortDetails cohort={CohortsData[1]} />);
    expect(screen.getByText(/Trainer: Elisa Smith/i)).toBeInTheDocument();
    expect(screen.getByText(/Coach: Apoorv/i)).toBeInTheDocument();
    expect(screen.getByText(/Start Date: 10-Sep-2021/i)).toBeInTheDocument();

  });

  test('renders fallback if no data', () => {
    render(<CohortDetails />);
    expect(screen.getByText('No data')).toBeInTheDocument();
  });
});
