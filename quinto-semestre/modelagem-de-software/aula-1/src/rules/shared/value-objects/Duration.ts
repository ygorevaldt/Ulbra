export default class Duration {
    constructor(
        readonly minutes: number
    ) { }

    hours(): string {
        const numberOfMinutesInOneHour = 60;
        const hours = Math.floor(this.minutes / numberOfMinutesInOneHour);
        const minutes = this.minutes % numberOfMinutesInOneHour;

        if (hours > 0 && minutes > 0) return `${hours},${minutes}`;
        if (hours > 0) return `${hours}`;
        return `0,${minutes}`;
    }

    seconds(): number {
        const numberOfSecondsInOneMinute = 60;
        return this.minutes * numberOfSecondsInOneMinute;
    }
}