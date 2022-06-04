function encontrar()
{
let resultado = document.querySelector('#resultado');
let listaDeNumeros = document.querySelector('#listaDeNumeros').value;
listaDeNumeros = Array.from(listaDeNumeros);
let maiorNumero = 0;
let busca = ',';
let indice = listaDeNumeros.indexOf(busca);
while(indice >= 0){
  listaDeNumeros.splice(indice, 1);
  indice = listaDeNumeros.indexOf(busca);
}
listaDeNumeros.forEach((numero, index) => {
  if (numero > maiorNumero) {
    maiorNumero = numero;
  }
});
resultado.innerHTML = `O maior número digitado foi <strong>${maiorNumero}</strong>`;
}