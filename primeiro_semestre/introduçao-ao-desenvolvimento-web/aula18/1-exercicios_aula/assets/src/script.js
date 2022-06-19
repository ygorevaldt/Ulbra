/* Prompt / Alert */
let ativaPrompt = document.querySelector("#ativaPrompt");
ativaPrompt.addEventListener("click", function () {
  prompt("Este é um exemplo de prompt");
});

let ativaAlert = document.querySelector("#ativaAlert");
ativaAlert.addEventListener("click", function () {
  alert("Este é um exemplo de alert");
});

/* Leia um valor e imprima os resultados: “É maior que 10” ou “Não é maior que 10” ou ainda “É igual a 10" */
let valor = document.querySelector("#valor");
let verificar = document.querySelector("#verificar");
let mostraResultado = document.querySelector("#mostraResultado");
verificar.addEventListener("click", function () {
  if (valor.value > 10) {
    mostraResultado.innerHTML =
      "<strong>O valor digitado é maior que 10</strong>";
    return;
  }
  if (valor.value < 10) {
    mostraResultado.innerHTML =
      "<strong>O valor digitado é menor que 10</strong>";
    return;
  }
  if (valor.value == 10) {
    mostraResultado.innerHTML =
      "<strong>O valor digitado é igual que 10</strong>";
    return;
  }
});

/* Soma dois valores lidos e imprime resultado */
const numero1 = document.querySelector("#numero1");
const numero2 = document.querySelector("#numero2");
let somar = document.querySelector("#somar");
let resultado = document.querySelector("#resultado");
somar.addEventListener("click", function () {
  let soma = parseFloat(numero1.value) + parseFloat(numero2.value);
  resultado.innerHTML = `<strong>Resultado = ${soma}</strong>`;
});

/* Leia 2 valores e a operação a ser realizada (+, -, * ou /) e imprima o resultado (use um switch) */
const valor1 = document.querySelector("#valor1");
const valor2 = document.querySelector("#valor2");
let operacao = document.querySelector("#operacao");
let calcular = document.querySelector("#calcular");
let resultadoCalcular = document.querySelector("#resultadoCalcular");
calcular.addEventListener("click", function () {
  switch (operacao.value) {
    case "+":
      result = parseFloat(valor1.value) + parseFloat(valor2.value);
      resultadoCalcular.innerHTML = `O resultado é ${result}`;
      break;
    case "-":
      result = parseFloat(valor1.value) - parseFloat(valor2.value);
      resultadoCalcular.innerHTML = `O resultado é ${result}`;
      break;
    case "*":
      result = parseFloat(valor1.value) * parseFloat(valor2.value);
      resultadoCalcular.innerHTML = `O resultado é ${result}`;
      break;
    case "/":
      result = parseFloat(valor1.value) / parseFloat(valor2.value);
      resultadoCalcular.innerHTML = `O resultado é ${result}`;
      break;
  }
});

/* 5 - Calcular conta de consumo de energia elétrica */
function calculaValor() {
  const quantidadeKwh = parseFloat(document.querySelector("#quantidadeKwh").value);
  let valorKwh = parseFloat(document.querySelector("#valorKwh").value);
  if (quantidadeKwh > 100 && quantidadeKwh <= 200) {
    valorKwh = valorKwh + valorKwh * (25 / 100);
  } else if (quantidadeKwh > 200) {
    valorKwh = valorKwh + valorKwh * (50 / 100);
  }
  let calculo = quantidadeKwh * valorKwh;
  let valorDaConta = document.querySelector("#valorDaConta");
  valorDaConta.innerHTML = `<strong> Valor da conta = $${calculo},00</strong>`;
};

/* 6 - Mostre na tela o maior número entre números digitados */
function verificaNumero() {
  let numeros = document.querySelector("#numeros").value;
  numeros = numeros.split(",");

  let maiorNumero = 0;

  for (let i = 0; i < numeros.length; i++) {
    let numeroAtual = parseFloat(numeros[i]);
    if (numeroAtual > maiorNumero) {
      maiorNumero = numeroAtual;
    }
  }
  document.getElementById("maiorNumero") . innerHTML = `O maior número digitado foi <strong>${maiorNumero}</strong>`;
}


/* Maior de idade, menor de idade */ 
function verificaIdade() {
  let idades = document.querySelector("#idades").value;
  idades = idades.split(",");
  console.log(idades);

  let maior18 = 0;
  let menor18 = 0;

  for (let i = 0; i < idades.length; i++) {
    let idadeAtual = parseFloat(idades[i]);
    if (idadeAtual < 18) {
      menor18++;
    } else {
      maior18++;
    }
  }
  document.getElementById("mostraIdade") . innerHTML = `<strong>${menor18}</strong> pessoas são menores de idade e <strong>${maior18}</strong> são maiores de idade`;
}

/* 8 - Leia um nome e um valor n e imprima o nome n vezes usando o laço for */
 function escreveNome() {
  const nome = document.querySelector("#nome").value;
  const numero = document.querySelector("#numero").value;
  for(let i = 0; i < numero; i++) {
    document.querySelector("#repeteNome").innerHTML += `${nome} `;
  }
 }

 /* Leia um nome, endereço e e-mail, armazene em um array, depois imprima na tela; */
 function mostraDadosForm() {
  const nome = document.querySelector("#nomeForm").value;
  const endereco = document.querySelector("#enderecoForm").value;
  const email = document.querySelector("#emailForm").value

  document.querySelector("#nameForm").innerHTML = `<strong>Nome: </strong>${nome}`;
  document.querySelector("#addressForm").innerHTML = `<strong>Endereço: </strong> ${endereco}`;
  document.querySelector("#mailForm").innerHTML = `<strong>Nome: </strong>${email}`;

 }