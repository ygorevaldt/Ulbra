
function converteNumero() {
  let algorismos = document.querySelector("#numero").value;
  algorismos = algorismos.split("");
  const limiteLaco = algorismos.length -1;

  let baseInicio = parseInt(document.querySelector("#baseInicio").value);
  let baseFinal = parseInt(document.querySelector("#baseFinal").value);
  
  let aux = 0;
  let resultado = 0;
  let potencia = 1;

  for(let i = limiteLaco; i >= 0; i--){
    // BINARIO
    if (baseInicio == 2) { 
      if (aux == 0) {
        resultado += (parseInt(algorismos[i]) * (baseInicio * 1));
        console.log(resultado);
      }
      if (aux > 0) {
        potencia *= 2;
        resultado += (parseInt(algorismos[i]) * (baseInicio * potencia));
        console.log(resultado);
      }
      aux++;
    };
    // OCTAL
    if (baseInicio == 8) { 
      if (aux == 0) {
        resultado += (parseInt(algorismos[i]) * (baseInicio * 1));
        console.log(resultado);
      }
      if (aux > 0) {
        potencia *= 8;
        resultado += (parseInt(algorismos[i]) * (baseInicio * potencia));
        console.log(resultado);
      }
      aux++;
    };
    // EXADECIMAL
    if (baseInicio == 16) { 
      if (aux == 0) {
        resultado += (parseInt(algorismos[i]) * (baseInicio * 1));
        console.log(resultado);
      }
      if (aux > 0) {
        potencia *= 16;
        resultado += (parseInt(algorismos[i]) * (baseInicio * potencia));
        console.log(resultado);
      }
      aux++;
    };
  }
  document.querySelector("#resultado").innerHTML = `Resultado: <strong>${resultado / baseInicio}</strong>(${baseFinal})`;
}