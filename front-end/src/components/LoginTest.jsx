import { useEffect, useState } from "react";
import { useGlobalContext } from "../contexts/GlobalContext";

export default function LoginForm() {
    const {apiUrl} = useGlobalContext();
    const [username, setUsername] = useState(null);
    const [password, setPassword] = useState(null);


    return (
        <>
            <input
                type="text"
                name="username"
                onChange={(e) => setUsername(e.target.value)} />

            <input 
                type="password"
                name="password"
                onChange={(e) => setPassword(e.target.value)} />    
        </>
    )
}