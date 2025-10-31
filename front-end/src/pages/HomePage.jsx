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
                    sort: "asc"
                }
            })
            .then((response) => {
                setPosts(response.data);
            })
            .catch((error) => {
                console.error(error)
            })
    }, [])

    console.log(posts)

    return (
        <main className="container">
        </main>
    )
}