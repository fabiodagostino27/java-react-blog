import logo from "../assets/logo.png"

export default function Navbar() {
    return (
        <nav class="navbar bg-body-secondary">
            <div class="container">
                <a class="navbar-brand" href="#">
                    <img src={logo} alt="Tellit" width="80px" />
                </a>
            </div>
        </nav>
    )
}