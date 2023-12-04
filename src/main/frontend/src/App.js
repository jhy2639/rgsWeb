import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';
// import Login from './Login/Login';

const App = () => {

  const [posts, setPosts] = useState([]);

  useEffect(async () => {
    // axios({
    //   method: "GET",
    //   url:'https://jsonplaceholder.typicode.com/photos'
    // }).then(response => setPosts(response.data));

    // axios.get('https://jsonplaceholder.typicode.com/photos')
    // .then(response => setPosts(response.data));

    try {
      const response = await axios.get('https://jsonplaceholder.typicode.com/photos');
      setPosts(response.data)
    } catch (error) {
      console.log(error);
    }
  });

  return (
    <ul>
      {posts.map(post => (
        <li key={post.id}>
          <div>{post.title}</div>
          <div><img src={post.thumbnailUrl} /></div>
        </li>
      ))}
    </ul>
  );
};

export default App;