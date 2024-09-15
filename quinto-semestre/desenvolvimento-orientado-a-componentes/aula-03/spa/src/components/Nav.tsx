import { Link } from "react-router-dom";

export function Nav() {
    return (
        <nav className="
            flex-1
            bg-zinc-800 py-3 px-2
        ">
            <ul className="flex gap-3 text-xl">
                <li>
                    <Link to="/">
                        Início
                    </Link>
                </li>
                <li>
                    <Link to="/about">
                        Sobre
                    </Link>
                </li>
                <li>
                    <Link to="/contact">
                        Contato
                    </Link>
                </li>
            </ul>
        </nav>
    );
}