import './App.css';
import { useState } from 'react';
import Header from './Header/Header';

function App() {

  const [num, setNum] = useState(1);

  const [numList, setNumList] = useState([]);
  

  function numRecording(){
    setNumList([...numList, num]); // JS6문법

    setNum(0);
  }

  return (
    <div className="App">
        {/* <div className='number'>현재숫자 : { num }</div>
        <button onClick={() => setNum(num + 1)}>숫자 증가</button>
        <button onClick={() => setNum(num - 1)}>숫자 감소</button>
        <button onClick={numRecording}>숫자 기록</button>
        <h1>저장된 숫자</h1>
        <ul>
          {numList.map((num) => (
            <li>{num}</li>
          ))}
        </ul> */}
        <Header/>
    </div>
  );
}

export default App;