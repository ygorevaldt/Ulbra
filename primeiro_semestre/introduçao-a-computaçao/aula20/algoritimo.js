let base = parseFloat(prompt("Digite a base: "));
console.log(`Você digitou ${base} como número base`);
let expoente = parseFloat(prompt("Digite o expoente: "));
let resultado = Math.pow(base, expoente);

document.querySelector("#resultado").innerHTML = `${base} ^ ${expoente} = ${resultado}`;

console.log(`Você digitou ${expoente} como número expoente`);
console.log(`\nCalculando....\n\n`);

for (let i = 0; i <= expoente; i++) {
  console.log(`${base} ^ ${i} = ${base ** i}`);
}

console.log(`\nResultado = ${resultado}`);