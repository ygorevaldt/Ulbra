import { Scientist } from "../types";
import { Profile } from "./Profile";

type GalleryProps = {
    scientists: Scientist[]
}

export function Gallery({
    scientists
}: GalleryProps) {
    return (
        <ul className="
            grid 
            lg:grid-cols-3 gap-3
            md:grid-cols-2
            sm:grid-cols-1
        ">
            {scientists.map((scientist) => {
                return (
                    <li
                        className=""
                        key={scientist.name}
                    >
                        <Profile scientist={scientist} />
                    </li>
                );
            })}
        </ul>
    );
}