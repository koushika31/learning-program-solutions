class Cohort {
  constructor(cohortCode, startDate, technology, trainerName, coachName, currentStatus) {
    this.cohortCode = cohortCode;
    this.coachName = coachName;
    this.trainerName = trainerName;
    this.technology = technology;
    this.startDate = startDate;
    this.currentStatus = currentStatus;
  }
}

const CohortsData = [
  new Cohort('INTADMDF10', '22-Feb-2022', '.NET FSD', 'Jojo Jose', 'Aathma', 'Scheduled'),
  new Cohort('ADM21JF014', '10-Sep-2021', 'Java FSD', 'Elisa Smith', 'Apoorv', 'Ongoing'),
  new Cohort('CDBJF21025', '24-Dec-2021', 'Java FSD', 'John Doe', 'Aathma', 'Ongoing')
];

export { Cohort, CohortsData };
