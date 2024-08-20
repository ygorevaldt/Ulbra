export function sigmoid(sum: number) {
    if (sum >= 0) return 1 - 1 / (1 + sum);
    return -1 + 1 / (1 - sum);
}