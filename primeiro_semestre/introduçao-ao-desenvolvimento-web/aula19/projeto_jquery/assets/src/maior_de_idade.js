$(document).ready(function(){
  $('#menu_maior_de_idade').click(function(){
    $('#section').load('maior_de_idade.html', function(){
      $('#verificar').click(function(){
        let idades = $('#idades').val();
        idades = idades.split(',');
        let maior18 = 0;
        let menor18 = 0;
        for(let i = 0; i < idades.length; i++) {
          if (idades[i] < 18) {
            menor18++;
          }
          if (idades[i] >= 18) {
            maior18++;
          }
        }
        $('#idadesVerificadas').html(`Você digitou <strong>${menor18}</strong> idades menores que 18 e <strong>${maior18}</strong> idades maiores que 18`);
      });
    });
  });
});