interface PageProps {
    children: React.ReactNode;
}

export function Page({
    children
}: PageProps) {
    return (
        <article className="flex flex-col gap-4">
            {children}
        </article>
    );
}