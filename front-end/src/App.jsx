import { BrowserRouter, Route, Routes } from "react-router-dom";
import { GlobalProvider } from "./contexts/GlobalContext";
import LoginForm from "./components/LoginForm";
import RegisterForm from "./components/RegisterForm";
import HomePage from "./pages/HomePage";
import DefaultLayout from "./layouts/DefaultLayout";

function App() {
    return (
        <>
            <BrowserRouter>
                <GlobalProvider>
                    <Routes>
                        <Route Component={DefaultLayout}>
                            <Route path="/" Component={HomePage} />
                            <Route path="login" Component={LoginForm} />
                            <Route path="register" Component={RegisterForm} />
                        </Route>
                    </Routes>
                </GlobalProvider>
            </BrowserRouter>
        </>
    )
}

export default App
