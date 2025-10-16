import { useEffect, useState } from "react";
import { useGlobalContext } from "../contexts/GlobalContext";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

export default function LoginForm() {
    const { apiUrl } = useGlobalContext();
    const [username, setUsername] = useState(null);
    const [password, setPassword] = useState(null);

    const navigate = useNavigate();

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
                localStorage.setItem("token", response.data);
                navigate("/")
            })
            .catch((err) => {
                console.error(err.response.data);
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

                <button>Login</button>
            </form>

            <Link to={"/register"} className="btn btn-dark">Non hai un account? registrati qui!</Link>
        </>
    )
}