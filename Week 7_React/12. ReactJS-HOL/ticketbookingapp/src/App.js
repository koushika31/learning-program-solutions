import React, { useState } from 'react';

function GuestPage() {
  return (
    <div>
      <h1>Please sign up.</h1>
    </div>
  );
}

function UserPage() {
  return (
    <div>
      <h1>Welcome back</h1>
    </div>
  );
}

function LoginControl() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  let button;
  let page;

  if (isLoggedIn) {
    button = <button onClick={() => setIsLoggedIn(false)}>Logout</button>;
    page = <UserPage />;
  } else {
    button = <button onClick={() => setIsLoggedIn(true)}>Login</button>;
    page = <GuestPage />;
  }

  return (
    <div>
      {page}
      {button}
    </div>
  );
}

export default function App() {
  return (
    <div>
      <LoginControl />
    </div>
  );
}
