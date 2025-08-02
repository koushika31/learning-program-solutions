import React from 'react';

function BookDetails({ show }) {
  const books = [
    { title: 'Master React', price: 670 },
    { title: 'Deep Dive into Angular 11', price: 800 },
    { title: 'Mongo Essentials', price: 450 }
  ];

  return show ? (
    <div>
      <h2>Book Details</h2>
      {books.map((book, index) => (
        <div key={index}>
          <strong>{book.title}</strong><br />
          {book.price}<br /><br />
        </div>
      ))}
    </div>
  ) : null;
}

export default BookDetails;
