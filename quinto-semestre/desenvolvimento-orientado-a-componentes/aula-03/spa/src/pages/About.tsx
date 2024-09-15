import { Header } from "../components/Header";
import { Page } from "../components/Page";

export function About() {
    return (
        <Page>
            <Header>
                <h1>Sobre</h1>
            </Header>
            <main className="flex flex-col gap-2">
                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Est corrupti fuga quod aspernatur distinctio voluptate veniam nostrum corporis provident laborum totam error illum aperiam eius, atque animi temporibus neque blanditiis!
                </p>
                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore atque vitae animi accusamus veniam, perspiciatis ducimus esse soluta error.
                </p>
            </main>
        </Page>
    );
}