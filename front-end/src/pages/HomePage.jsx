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
                    sort: "createdAt,desc",
                    size: 3,
                    page: 0
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
                    return <p>{post.title}</p>
                })
            }
        </main>
    )
}