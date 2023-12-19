import React, { useEffect, useState } from 'react';
import axios from 'axios';


const LoginForm = () => {

    const [inputId, setInputId] = useState('');
    const [inputPwd, setInputPwd] = useState('');
    const [token, setToken] = useState('');
    const [hello, setHello] = useState('');

    // useEffect(() => {
    //     axios.get('/api/test')
    //         .then((res) => {
    //             setHello(res.data);
    //         })
    // }, []);

    useEffect(() => {
        const fetchData = async () => {
            try {
                // 인증 토큰이 존재할 경우에만 '/api/test' 엔드포인트로 GET 요청 보내기
                if (token) {
                    const response = await axios.get('/api/test', {
                        headers: {
                            Authorization: `Bearer ${token}`,
                        },
                    });
                    setHello(response.data);
                }
            } catch (error) {
                console.error('데이터를 불러오는 중 에러 발생:', error);
            }
        };

        // 컴포넌트가 마운트될 때와 토큰이 업데이트될 때마다 실행
        fetchData();
    }, [token]);

    const handleLogin = async () => {
        try {
            // 아이디와 비밀번호를 사용하여 로그인 요청 보내기
            const response = await axios.post('http://localhost:8090/api/rgsLogin', {
                inputId: inputId,
                inputPwd: inputPwd,
            });

            // 로그인 성공 시 토큰 저장
            setToken(response.data.token);

            // 성공적으로 로그인한 경우에 대한 처리
            console.log('로그인 성공:', response.data);
        } catch (error) {
            // 로그인 실패한 경우에 대한 처리
            console.error('로그인 실패:', error.response.data);
        }
    };

    return (
        <div>
            <h2>Login Form</h2>
            <div>
                <label>Username:</label>
                <input
                    type="text"
                    value={inputId}
                    onChange={(e) => setInputId(e.target.value)}
                />
            </div>
            <div>
                <label>Password:</label>
                <input
                    type="password"
                    value={inputPwd}
                    onChange={(e) => setInputPwd(e.target.value)}
                />
            </div>
            <button onClick={handleLogin}>Login</button>

            {token && (
                <div>
                    <h2>Test Component</h2>
                    <p>{hello}</p>
                </div>
            )}
        </div>
    );
};

export default LoginForm;