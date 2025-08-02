import React from 'react';
import CourseDetails from './components/CourseDetails';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';

import './App.css';

function App() {
  const showCourses = true;
  const showBooks = true;
  const showBlogs = true;

  return (
    <div style={{ display: 'flex', justifyContent: 'space-evenly', marginTop: '50px' }}>
      <CourseDetails show={showCourses} />
      <div style={{ borderLeft: '3px solid green', height: '300px' }}></div>
      <BookDetails show={showBooks} />
      <div style={{ borderLeft: '3px solid green', height: '300px' }}></div>
      <BlogDetails show={showBlogs} />
    </div>
  );
}

export default App;
