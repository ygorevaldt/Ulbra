import { Link } from "react-router-dom";


export function Nav() {
    return (
        <nav className="
            flex-1
            bg-zinc-800 py-4 px-4
        ">
            <ul className="flex gap-3 text-xl">
                <li>
                    <Link to="/" className="hover:text-purple-400">
                        Início
                    </Link>
                </li>
                <li>
                    <Link to="/register" className="hover:text-purple-400">
                        Cadastrar
                    </Link>
                </li>
            </ul>
        </nav>
    );
}