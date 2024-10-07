import { useEffect, useState } from "react";
import { Artwork } from "./types/artwork";
import { Card } from "./components/card/Card";
import { Pagination } from "./components/Pagination";

export function App() {

    const [artworks, setArtworks] = useState<Artwork[]>([]);
    const [artwork, setArtwork] = useState<Artwork | null>(null);
    const [navIndex, setNavIndex] = useState(0);

    useEffect(() => {
        fetch("./src/data/data.json")
            .then((response) => response.json())
            .then((data) => {
                setArtworks(data.artworks);
                setArtwork(data.artworks[navIndex]);
            })
            .catch((error) => console.error("Erro ao buscar os dados:", error));
    }, [navIndex]);

    function handleNextArtwork() {
        if (!artworks[navIndex + 1]) return;
        setNavIndex((currentState) => currentState + 1);

        setArtwork(artworks[navIndex]);
    }

    function handlePreviusArtwork() {
        if (!artworks[navIndex - 1]) return;
        setNavIndex((currentState) => currentState - 1);

        setArtwork(artworks[navIndex]);
    }

    return (
        <main className="
            flex flex-col gap-4
            p-4 items-center justify-center
        ">
            <h1 className="text-3xl font-bold underline">
                Obras de arte famosas
            </h1>
            {artwork && (
                <Card artwork={artwork} />
            )}
            <Pagination previus={handlePreviusArtwork} next={handleNextArtwork} />

        </main>


    );
}

