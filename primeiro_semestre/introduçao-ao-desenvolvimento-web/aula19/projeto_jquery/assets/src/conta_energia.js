$(document).ready(function(){
  $('#menu_conta_energia').click(function(){
    $('#section').load('conta_energia.html', function(){
      $('#calcular').click(function(){
        let quantidadeKwh = parseFloat($('#quantidadeKwh').val());
        let valorKwh = parseFloat($('#valorKwh').val());

        if (quantidadeKwh > 100 && quantidadeKwh <= 200) {
          valorKwh = valorKwh + valorKwh * (25 / 100);
        } else if (quantidadeKwh > 200) {
          valorKwh = valorKwh + valorKwh * (50 / 100);
        }
        
        $('#valorDaConta').html(`<strong>Valor à pagar:</strong> $${quantidadeKwh * valorKwh},00`);
      });
    });
  });
});