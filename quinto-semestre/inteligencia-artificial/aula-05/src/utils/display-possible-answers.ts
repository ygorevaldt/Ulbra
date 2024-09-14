export function displayPossibleAnswers(answers: string[]) {
    let possibleAnswers = "";
    let count = 1;

    answers.forEach((response) => {
        answers.length === count
            ? possibleAnswers += `${response}`
            : possibleAnswers += `${response}, `;

        count++;
    });

    console.log(`${possibleAnswers}\n`);
}