import { BrowserRouter, Route, Routes } from "react-router-dom";
import { GlobalProvider } from "./contexts/GlobalContext";
import LoginForm from "./components/LoginForm";
import RegisterForm from "./components/RegisterForm";
import HomePage from "./pages/HomePage";

function App() {
    return (
        <>
            <BrowserRouter>
                <GlobalProvider>
                    <Routes>
                        <Route path="/" Component={HomePage} />
                        <Route path="login" Component={LoginForm} />
                        <Route path="register" Component={RegisterForm} />
                    </Routes>
                </GlobalProvider>
            </BrowserRouter>
        </>
    )
}

export default App
