type ImageProps = {
    url: string;
    alt: string;
}

export function Image({
    url,
    alt
}: ImageProps) {
    return (
        <div className="relative mx-6 -mt-6 h-80 overflow-hidden rounded-xl bg-blue-gray-500 bg-clip-border text-white shadow-lg shadow-blue-gray-500/40 bg-gradient-to-r from-blue-500 to-blue-600">
            <img src={url} alt={alt} className="h-full w-full object-cover" />
        </div>
    );
}