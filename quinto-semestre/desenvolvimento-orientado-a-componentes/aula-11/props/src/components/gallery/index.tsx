import { Scientist } from "../../types";
import { Profile } from "../profile";

type GalleryProps = {
    scientists: Scientist[]
}

export function Gallery({
    scientists
}: GalleryProps) {
    return (
        <ul>
            {scientists.map((scientist) => {
                return (
                    <li key={scientist.name}>
                        <Profile scientist={scientist} />
                    </li>
                );
            })}
        </ul>
    );
}