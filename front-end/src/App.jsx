import { BrowserRouter, Route, Routes } from "react-router-dom";
import { GlobalProvider } from "./contexts/GlobalContext";

function App() {
    return (
        <>
            <BrowserRouter>
                <GlobalProvider>
                    <Routes>
                        
                    </Routes>
                </GlobalProvider>
            </BrowserRouter>
        </>
    )
}

export default App
