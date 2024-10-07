type PaginationProps = {
    previus: () => void;
    next: () => void
}

export function Pagination({
    previus,
    next
}: PaginationProps) {
    return (
        <aside className="flex gap-2">
            <button
                className="rounded-md px-4 py-2 bg-blue-800 text-white "
                onClick={previus}
            >
                Anterior
            </button>
            <button
                className="rounded-md px-4 py-2 bg-blue-800 text-white "
                onClick={next}
            >
                Próximo
            </button>
        </aside>
    );
}