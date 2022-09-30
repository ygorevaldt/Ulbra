$(document).ready(function(){
  $('#menu_soma_dois_numeros').click(function(){
    $('#section').load('soma_dois_numeros.html', function(){
      $('#somar').click(function(){
        let numeroUm = parseFloat($('#numeroUm').val());
        let numeroDois = parseFloat($('#numeroDois').val());
        $('#resultado').html(`<strong>Resultado = </strong>${numeroUm + numeroDois}`);
      });
    });
  });
});