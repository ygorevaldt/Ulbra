interface HeaderProps {
    children: React.ReactNode;
}

export function Header({
    children
}: HeaderProps) {
    return (
        <header className="text-4xl font-black">
            {children}
        </header>
    );
}