import React from "react";
import sty from './Header.css';

function Header() {

    return (
        <div id={sty.header}>
            <span className={sty.title}>모임이름</span>
            
            {/* API연결예정 */}
            <span className={sty.memFee}>잔액표시</span>
        </div>
    );
}

export default Header;