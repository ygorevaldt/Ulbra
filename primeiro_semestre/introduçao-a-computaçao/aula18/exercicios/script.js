
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
      }
      if (aux > 0) {
        potencia *= 2;
        resultado += (parseInt(algorismos[i]) * (baseInicio * potencia));
      }
      aux++;
    };
    // OCTAL
    if (baseInicio == 8) { 
      if (aux == 0) {
        resultado += (parseInt(algorismos[i]) * (baseInicio * 1));
      }
      if (aux > 0) {
        potencia *= 8;
        resultado += (parseInt(algorismos[i]) * (baseInicio * potencia));
      }
      aux++;
    };
    // HEXADECIMAL
    if (baseInicio == 16) { 
      if(algorismos[i] == 'A' || algorismos[i] == 'a') {
        algorismos[i] = 10;
      }
      else if (algorismos[i] == 'B' || algorismos[i] == 'b'){
        algorismos[i] = 11;
      }
      else if (algorismos[i] == 'C' || algorismos[i] == 'c'){
        algorismos[i] = 12;
      }
      else if (algorismos[i] == 'D' || algorismos[i] == 'd'){
        algorismos[i] = 13;
      }
      else if (algorismos[i] == 'E' || algorismos[i] == 'e'){
        algorismos[i] = 14;
      }
      else if (algorismos[i] == 'F' || algorismos[i] == 'f'){
        algorismos[i] = 15;
      }
      if (aux == 0) {
        resultado += (parseInt(algorismos[i]) * (baseInicio * 1));
      }
      if (aux > 0) {
        potencia *= 16;
        resultado += (parseInt(algorismos[i]) * (baseInicio * potencia));
      }
      aux++;
    };
  }
  document.querySelector("#resultado").innerHTML = `Resultado: <strong>${resultado / baseInicio}</strong>(${baseFinal})`;
}