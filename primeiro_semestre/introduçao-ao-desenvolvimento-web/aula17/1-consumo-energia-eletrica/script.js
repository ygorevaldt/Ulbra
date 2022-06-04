function calcular() {
  const valorKwh = document.querySelector('#valorKwh').value;
  let consumoKwh = document.querySelector('#consumoKwh').value;
  let resultado = document.querySelector("#resultado");
  let aumento;
  if (consumoKwh > 100 && consumoKwh <= 200) {
    aumento = consumoKwh * (25 / 100);
  }
  if (consumoKwh > 200) {
    aumento = consumoKwh * (50 / 100);
  }
  let valor = (consumoKwh * valorKwh) + aumento;
  resultado.innerText = `Valor à pagar: $${valor},00`;
}