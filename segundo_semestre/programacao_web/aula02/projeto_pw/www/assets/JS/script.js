$(document).ready(function() {
  $("#cidade-01").click(function() {
    $("#descricao-cidade").load("views/cidade01.html");
  })
  $("#cidade-02").click(function() {
    $("#descricao-cidade").load("views/cidade02.html");
  })
  $("#cidade-03").click(function() {
    $("#descricao-cidade").load("views/cidade03.html");
  })
})