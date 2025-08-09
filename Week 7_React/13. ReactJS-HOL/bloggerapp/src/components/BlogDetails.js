import React from 'react';

function BlogDetails({ show }) {
  const blogs = [
    {
      title: 'React Learning',
      author: 'Stephen Biz',
      content: 'Welcome to learning React!'
    },
    {
      title: 'Installation',
      author: 'Schwezdneier',
      content: 'You can install React from npm.'
    }
  ];

  return (
    show && (
      <div>
        <h2>Blog Details</h2>
        {blogs.map((blog, index) => (
          <div key={index}>
            <strong>{blog.title}</strong><br />
            <em>{blog.author}</em><br />
            <p>{blog.content}</p>
          </div>
        ))}
      </div>
    )
  );
}

export default BlogDetails;
