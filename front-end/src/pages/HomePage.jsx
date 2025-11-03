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
        <main className="container my-4">
            <h1>Nuovi post</h1>
            {
                posts.content && posts.content.map((post, index) => {
                    if (index <= 2) return <p>{post.title}</p>
                    else return null
                })
            }
        </main>
    )
}