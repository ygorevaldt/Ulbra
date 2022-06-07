function alerta() {
  alert(`Este é um exemplo de alert`);
}
function pergunta() {
  prompt(`Este é um exemplo de prompt`);
}

const confirma = document.querySelector("#confirma");
confirma.addEventListener("click", function () {
  confirm(`Este é um exemplo de confirm`);
});

function verificaIdade() {
  let idade = document.querySelector("#idade");
  let idadeVerificada = document.querySelector("#idadeVerificada");
  idade.value >= 18
    ? (idadeVerificada.innerHTML = `Você tem ${idade.value} anos - MAIOR DE IDADE`)
    : (idadeVerificada.innerHTML = `Você tem ${idade.value} anos - MENOR DE IDADE`);
}

function maiorNumero() {
  let resultado = document.querySelector("#resultado");
  let numero1 = document.querySelector("#numero1").value;
  let numero2 = document.querySelector("#numero2").value;
  let numero3 = document.querySelector("#numero3").value;
  let listaNumeros = [numero1, numero2, numero3];
  let maiorValor = numero1;
  listaNumeros.forEach((numero) => {
    if (numero > maiorValor) {
      maiorValor = parseFloat(numero);
    }
  });
  resultado.innerHTML = `<strong>O maior valor informado foi: ${maiorValor}</strong>`;
}
