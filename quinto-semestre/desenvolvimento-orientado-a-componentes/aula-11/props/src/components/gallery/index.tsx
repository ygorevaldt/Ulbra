import { Scientist } from "../../types";
import { Profile } from "../profile";
import styles from "./gallery.module.css";

type GalleryProps = {
    scientists: Scientist[]
}

export function Gallery({
    scientists
}: GalleryProps) {
    return (
        <ul className={styles.galleryContainer}>
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