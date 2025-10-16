import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useGlobalContext } from "../contexts/GlobalContext";
import axios from "axios";

export default function RegisterForm() {
    const { apiUrl } = useGlobalContext();
    const [username, setUsername] = useState(null);
    const [password, setPassword] = useState(null);
    const [error, setError] = useState(null);

    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();

        const data = {
            username: username,
            password: password
        }

        axios.
            post(apiUrl + "/auth/register", data, {
                headers: {
                    "Content-Type": "application/json"
                }
            })
            .then((response) => {
                console.log("Registrazione effettuata con successo!");
                navigate("/login")
            })
            .catch((err) => {
                console.error(err.response.data);
                setError(err.response.data);
            })
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                {
                    error ?
                        <div class="alert alert-danger" role="alert">
                            {error}
                        </div>
                    : null    
                }


                <input
                    type="text"
                    name="username"
                    onChange={(e) => setUsername(e.target.value)} />

                <input
                    type="password"
                    name="password"
                    onChange={(e) => setPassword(e.target.value)} />

                <button>Registrati</button>
            </form>
        </>
    )
}