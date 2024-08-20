export function ramp(sum: number) {
    if (sum < 0) return 0;
    if (sum === 0 || sum === 1) return sum;
    return 1;
}