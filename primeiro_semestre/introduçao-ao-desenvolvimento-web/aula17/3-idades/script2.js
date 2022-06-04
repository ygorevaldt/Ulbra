function encontrar()
{
let resultado = document.querySelector('#resultado');
let listaDeIdades = document.querySelector('#listaDeIdades').value;
listaDeIdades = Array.from(listaDeIdades);
const maiorIdade = 18;
let maiorDeIdade = 0;
let menorDeIdade = 0
let busca = ',';
let indice = listaDeIdades.indexOf(busca);
while(indice >= 0){
  listaDeIdades.splice(indice, 1);
  indice = listaDeIdades.indexOf(busca);
}
listaDeIdades.forEach((idade, index) => {
  if (idade > maiorIdade) {
    maiorDeIdade++;
  } else {
    menorDeIdade++;
  }
  
});
resultado.innerHTML = `Total de maiores de idade <strong>${maiorDeIdade}</strong><br>Total de menores de idade <strong>${menorDeIdade}</strong><br>`;
}
