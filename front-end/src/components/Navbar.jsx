import logo from "../assets/logo.png"
import { Link } from "react-router-dom"

export default function Navbar() {
    return (
        <nav className="navbar bg-info">
            <div className="container">
                <Link className="navbar-brand" to={"/"}>
                    <img src={logo} alt="Tellit" width="80px" />
                </Link>
            </div>
        </nav>
    )
}