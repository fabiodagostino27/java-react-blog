import { useEffect, useState } from "react";
import { useGlobalContext } from "../contexts/GlobalContext";
import axios from "axios";

export default function HomePage() {
    const { apiUrl } = useGlobalContext();
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        axios
            .get(apiUrl + "/posts", {
                params: {
                    sort: ""
                }
            })
            .then((response) => {
                setPosts(response.data);
                console.log(posts)
            })
            .catch((error) => {
                console.error(error)
            })
    }, [])

    return (
        <main className="container">
        </main>
    )
}