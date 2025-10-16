export default function RegisterForm() {
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
            post(apiUrl + "/auth/register", data, {
                headers: {
                    "Content-Type": "application/json"
                }
            })
            .then((response) => {
                console.log("Registrazione effettuata con successo!");
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

                <button>Registrati</button>
            </form>
        </>
    )
}