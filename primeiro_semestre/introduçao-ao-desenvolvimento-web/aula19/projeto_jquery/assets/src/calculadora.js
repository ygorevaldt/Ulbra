$(document).ready(function(){
  $('#menu_calculadora').click(function(){
    $('#section').load('calculadora.html', function(){
      $('#calcular').click(function(){
        let numeroUm = parseFloat($('#valor1').val());
        let numeroDois = parseFloat($('#valor2').val());
        let operacao = $('#operacao').val();
        
        switch (operacao) {
          case '+':
            $('#resultado').html(`<strong>Resultado = </strong> ${numeroUm + numeroDois}`);
            break;
          case '-':
            $('#resultado').html(`<strong>Resultado = </strong> ${numeroUm - numeroDois}`);
            break;
          case '*':
            $('#resultado').html(`<strong>Resultado = </strong> ${numeroUm * numeroDois}`);
            break;
          case '/':
            $('#resultado').html(`<strong>Resultado = </strong> ${numeroUm / numeroDois}`);
            break;
        }
      });
    });
  })})
