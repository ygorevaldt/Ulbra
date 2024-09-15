import { Header } from "../components/Header";
import { Page } from "../components/Page";

export function Home() {
    return (
        <Page>
            <Header>
                <h1>
                    Single Page Application (SPA)
                </h1>
            </Header>
            <main>
                <p>
                    Uma <span className="text-pink-500">Single Page Application (SPA)</span> é um tipo de aplicação web que carrega uma única página HTML e atualiza dinamicamente seu conteúdo conforme o usuário interage com a aplicação
                </p>
            </main>
        </Page>
    );
}