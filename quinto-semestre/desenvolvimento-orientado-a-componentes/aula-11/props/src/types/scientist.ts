import { Award } from "./award";

export type Scientist = {
    name: string;
    imgPath: string;
    profession: string;
    awards: Award[];
    discovered: string
}