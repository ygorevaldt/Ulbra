import { Scientist } from "../../types";
import styles from "./profile.module.css";

type ProfileProps = {
    scientist: Scientist;
}

export function Profile({
    scientist
}: ProfileProps) {
    return (
        <article className={styles.profileContainer}>
            <header>
                <h2>{scientist.name}</h2>
            </header>
            <img src={scientist.imgPath} alt={`Retrato do cientista ${scientist.name}`} />
            <ul>
                <li key={0}>
                    <span>Profissão:</span>
                    <p>{scientist.profession}</p>
                </li>
                <li key={1}>
                    <span>Prêmios: <strong>{scientist.awards.length}</strong></span>
                    <div>
                        {
                            scientist.awards.map((award, index) => {
                                return scientist.awards.length - 1 !== index
                                    ? <span>{award.name}, </span>
                                    : <span>{award.name}</span>
                            })
                        }
                    </div>
                </li>
                <li key={2}>
                    <span>Descoberta</span>
                    <p>{scientist.discovered}</p>
                </li>
            </ul>
        </article>
    );
}