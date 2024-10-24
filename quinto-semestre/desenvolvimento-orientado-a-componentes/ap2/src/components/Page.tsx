import { Header } from "./Header";

interface PageProps {
    title: string;
    children: React.ReactNode;
}

export function Page({
    title,
    children
}: PageProps) {
    return (
        <article className="flex flex-col gap-4">
            <Header>
                <h1>
                    {title}
                </h1>
            </Header>
            {children}
        </article>
    );
}