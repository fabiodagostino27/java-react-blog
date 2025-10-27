import logo from "../assets/logo.png"

export default function Navbar() {
    return (
        <nav className="navbar bg-body-secondary">
            <div className="container">
                <a className="navbar-brand" href="#">
                    <img src={logo} alt="Tellit" width="80px" />
                </a>
            </div>
        </nav>
    )
}