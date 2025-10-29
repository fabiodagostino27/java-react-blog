import { useState } from "react";
import { useGlobalContext } from "../contexts/GlobalContext";

export default function HomePage() {
    const { apiUrl } = useGlobalContext();
    const [posts, setPosts] = useState([]);

    return (
        <main className="container">
            <h1></h1>
        </main>
    )
}