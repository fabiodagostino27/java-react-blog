import { useEffect, useState } from "react";
import { useGlobalContext } from "../contexts/GlobalContext";
import axios from "axios";

export default function LoginForm() {
    const { apiUrl } = useGlobalContext();
    const [username, setUsername] = useState(null);
    const [password, setPassword] = useState(null);

    const handleSubmit = (e) => {
        e.preventDefault();

        const data = {
            username: username,
            password: password
        }

        axios.
            post(apiUrl + "/auth/login", data, {
                headers: {
                    "Content-Type": "application/json"
                }
            })
            .then((response) => {
                console.log("login effettuato con successo!");
            })
            .catch((err) => {
                console.error(err);
            })
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="username"
                    onChange={(e) => setUsername(e.target.value)} />

                <input
                    type="password"
                    name="password"
                    onChange={(e) => setPassword(e.target.value)} />

                <button>Invio</button>    
            </form>
        </>
    )
}