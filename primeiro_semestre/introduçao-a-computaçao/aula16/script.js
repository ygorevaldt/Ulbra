function resultado() {
  let nome = document.querySelector("#nome");
  let sobrenome = document.querySelector("#sobrenome");
  let resultado = document.querySelector("#resultado");

  resultado.innerHTML = `${nome} ${sobrenome}`;
}
