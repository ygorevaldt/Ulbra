$(document).ready(function () {
  $('#menu_maior_menor_dez').click(function () {
    $('#section').load('maior_menor_dez.html', function () {
      $('#verificar').click(function () {
        let numero = parseFloat($('#numero').val());
        if (numero > 10) {
          $('#verificaNumero').html(`O número <strong>${numero}</strong> é maior que <strong>10</strong>.`);
          return;
        }
        if (numero < 10) {
          $('#verificaNumero').html(`O número <strong>${numero}</strong> é menor que <strong>10</strong>.`);
          return;
        }
        if (numero == 10) {
          $('#verificaNumero').html(`O número <strong>${numero}</strong> é igual que <strong>10</strong>.`);
          return;
        }
      });
    });
  });
});