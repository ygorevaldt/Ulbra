import { useState } from "react";
import { Artwork } from "../../types/artwork";
import { Details } from "./Details";
import { DetailsButton } from "./DetailsButton";
import { Image } from "./Image";

type CardProps = {
    artwork: Artwork
}

export function Card({
    artwork
}: CardProps) {
    const [showDetails, setShowDetails] = useState(false);

    function handleShowDetails() {
        setShowDetails(showDetails ? false : true);
    }

    return (
        <article className="
            relative flex flex-col 
            rounded-xl mt-10 max-w-sm
            bg-white bg-clip-border text-gray-700 shadow-md
        ">
            <Image alt={artwork.alt} url={artwork.url} />
            <div className="p-6">
                <h2 className="mb-2 block font-sans text-xl font-semibold leading-snug tracking-normal text-blue-gray-900 antialiased">
                    {artwork.name}
                </h2>
                {showDetails && (
                    <Details artist={artwork.artist} description={artwork.description} />
                )}
            </div>
            <div className="p-6 pt-0">
                <DetailsButton
                    handleShowDetails={handleShowDetails}
                    showDetails={showDetails}
                />
            </div>
        </article>
    );
}