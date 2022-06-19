$(document).ready(function(){
  $('#menu_nome_email').click(function(){
    $('#section').load('nome_email.html', function(){
      $('#escrever').click(function(){
        let nome = $('#nome').val();
        let email = $('#email').val();
        let nomeEmail = [nome, email];
        $('#nomeEmail').html(`<strong>Nome: </strong>${nomeEmail[0]}<br><strong>E-mail: </strong>${nomeEmail[1]}`);
      })
    })
  })
})