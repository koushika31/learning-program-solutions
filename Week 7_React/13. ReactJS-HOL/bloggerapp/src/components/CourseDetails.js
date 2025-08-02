import React from 'react';

function CourseDetails({ show }) {
  const courses = [
    { name: 'Angular', date: '4/8/2025' },
    { name: 'React', date: '6/10/2025' }
  ];

  if (!show) return null; 

  return (
    <div>
      <h2>Course Details</h2>
      {courses.map((course, index) => (
        <div key={index}>
          <strong>{course.name}</strong><br />
          {course.date}<br /><br />
        </div>
      ))}
    </div>
  );
}

export default CourseDetails;
