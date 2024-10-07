
type DetailsProps = {
    artist: string;
    description: string;
}

export function Details({
    artist,
    description
}: DetailsProps) {
    return (
        <div>
            <strong>{artist}</strong>
            <p className="block font-sans text-base font-light leading-relaxed text-inherit antialiased">
                {description}
            </p>
        </div>
    );
}