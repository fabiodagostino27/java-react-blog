import logo from "../assets/logo.png"

export default function Footer() {
    return (
        <footer className="bg-body-secondary py-4">
            <div className="container d-flex flex-column align-items-center">
                <img src={logo} alt="Tellit" style={{ height: "60px", marginBottom: "10px" }} />
                <ul className="list-inline mb-2">
                    <li className="list-inline-item"><a href="/about" className="text-decoration-none text-muted">Chi siamo</a></li>
                    <li className="list-inline-item"><a href="/privacy" className="text-decoration-none text-muted">Privacy</a></li>
                    <li className="list-inline-item"><a href="/contatti" className="text-decoration-none text-muted">Contatti</a></li>
                    <li className="list-inline-item"><a href="/faq" className="text-decoration-none text-muted">FAQ</a></li>
                </ul>
                <div>
                    <a href="https://facebook.com" className="mx-2 text-muted"><i className="bi bi-facebook"></i></a>
                    <a href="https://instagram.com" className="mx-2 text-muted"><i className="bi bi-instagram"></i></a>
                    <a href="https://twitter.com" className="mx-2 text-muted"><i className="bi bi-twitter"></i></a>
                </div>
                <small className="text-muted d-block mt-2">
                    &copy; {new Date().getFullYear()} Tellit. Tutti i diritti riservati.
                </small>
            </div>
        </footer>
    );
}