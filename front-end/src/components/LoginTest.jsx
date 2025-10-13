import { useState } from "react";
import { useGlobalContext } from "../contexts/GlobalContext";

export default function LoginForm() {
    const {apiUrl} = useGlobalContext();
    const [username, setUsername] = useState(null);
    const [password, setPassword] = useState(null);

    console.log(apiUrl)
    return (
        <>
        </>
    )
}