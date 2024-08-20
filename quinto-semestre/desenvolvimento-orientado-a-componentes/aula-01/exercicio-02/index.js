const integers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function showImparsAndPars(numbers) {
    numbers.forEach(number => {
        let isPar = (number % 2) == 0;
        console.log(isPar ? `${number} = par` : `${number} = impar`);
    });
}

showImparsAndPars(integers);