import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Login.css';

const handleInputId = () => {

    

};

const Login = () => {

    const [idvalue, setIdValue] = useState([]);

 

    return (
        <div className='loginForm'>
            <input className="idForm" type='text'/><br/>
            <input className="pwForm" type='text'/>

            <div className="loginBtn">로그인</div>
            <span className="joinAccount">사용자등록요청</span>

        </div>
    );
}

export default Login;