$(document).ready(function () {
  $('#menu_nome_x_vezes').click(function(){
    $('#section').load('nome_x_vezes.html', function () {
      $('#escrever').click(function () {
        let nome = $('#nome').val();
        let numero = parseInt($('#numero').val());
        let nomesRepetidos = [];
        for(let i = 0; i < numero; i++){
          nomesRepetidos[i] = ` ${nome}`;
        }
        $('#nomesRepetidos').html(nomesRepetidos).val();
      })
    })
  })
});