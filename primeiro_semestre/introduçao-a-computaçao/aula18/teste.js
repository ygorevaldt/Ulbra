algorismos = ['A', 'B', 'C', 'D', 'E', 'F'];
limiteLaco = algorismos.length -1;
for (let i = limiteLaco; i >= 0; i--) {
  switch (algorismos[i]) {
    case 'A':
      algorismos[i] = 10;
      console.log(algorismos[i]);
      break;
    case 'B':
      algorismos[i] = 11;
      console.log(algorismos[i]);
      break;  
    case 'C':
      algorismos[i] = 12;
      console.log(algorismos[i]);
      break;
    case 'D':
      algorismos[i] = 13;
      console.log(algorismos[i]);
      break;  
    case 'E':
      algorismos[i] = 14;
      console.log(algorismos[i]);
      break;
    case 'F':
      algorismos[i] = 15;
      console.log(algorismos[i]);
      break;
  }
}
