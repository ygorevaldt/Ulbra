$(document).read(function(){
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
  })

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
        
        $('#valorDaConta').html(`<strong>Valor à pagar:</strong> ${quantidadeKwh * valorKwh},00`);
      });
    });

  })
})