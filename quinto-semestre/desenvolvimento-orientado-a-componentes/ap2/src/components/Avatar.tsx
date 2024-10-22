type AvatarProps = {
    imgUrl: string;
}

export function Avatar({
    imgUrl
}: AvatarProps) {
    return (
        <img
            className="
                rounded-full w-20 h-20 
                outline-double outline-2 outline-offset-2
            "
            src={imgUrl}
        />
    );
}
