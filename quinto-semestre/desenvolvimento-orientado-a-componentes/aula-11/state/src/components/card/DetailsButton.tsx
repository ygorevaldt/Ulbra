type DetailsButtonProps = {
    handleShowDetails: () => void;
    showDetails: boolean;
}

export function DetailsButton({
    handleShowDetails,
    showDetails
}: DetailsButtonProps) {
    return (
        <button
            onClick={handleShowDetails}
            className="
                        select-none rounded-lg bg-blue-500 py-3 px-6 text-center align-middle font-sans text-xs font-bold uppercase text-white shadow-md shadow-blue-500/20 transition-all hover:shadow-lg hover:shadow-blue-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none
                    ">
            {showDetails ? "Ocultar" : "Saiba mais"}
        </button>
    );
}