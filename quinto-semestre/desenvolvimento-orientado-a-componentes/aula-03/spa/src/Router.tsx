import { Route, Routes } from "react-router-dom";
import { Layout } from "./layouts/Layout";
import { Home } from "./pages/Home";
import { About } from "./pages/About";
import { Contact } from "./pages/Contact";

export function Router() {
    return (
        <Routes>
            <Route path="/" element={<Layout />}>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/contact" element={<Contact />} />
            </Route>
        </Routes>
    );
}