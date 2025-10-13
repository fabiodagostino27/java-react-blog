import { BrowserRouter, Route, Routes } from "react-router-dom";
import { GlobalProvider } from "./contexts/GlobalContext";
import LoginForm from "./components/LoginTest";

function App() {
    return (
        <>
            <BrowserRouter>
                <GlobalProvider>
                    <Routes>
                        <Route path="login" Component={LoginForm} />
                    </Routes>
                </GlobalProvider>
            </BrowserRouter>
        </>
    )
}

export default App
