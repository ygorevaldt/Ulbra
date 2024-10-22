import { Outlet } from "react-router-dom";
import { Nav } from "../components/Nav";

export function Layout() {
    return (
        <div className="">
            <Nav />
            <div className="p-4">
                <Outlet />
            </div>
        </div>
    );
}