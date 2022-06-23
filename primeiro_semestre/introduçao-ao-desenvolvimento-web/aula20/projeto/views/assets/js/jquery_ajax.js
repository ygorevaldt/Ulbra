$(document).ready(() =>{
  $("header").load("views/header.html");
  $("footer").load("views/footer.html");
  $("main").load("views/home.html");
  $("#menuHome").addClass('active');

  function removeClass() {
    $("#menuHome").removeClass("active");
    $("#menuSobre").removeClass("active");
    $("#menuProdutos").removeClass("active");
    $("#menuContato").removeClass("active");
  }

  $("#menuHome").click(() =>{
    removeClass();
    $("#menuHome").addClass("active");
    $("main").load("views/home.html");
  })

  $("#menuSobre").click(() =>{
    removeClass();
    $("#menuSobre").addClass("active");
    $("main").load("views/sobre.html");
  })

  $("#menuProdutos").click(() =>{
    removeClass();
    $("#menuProdutos").addClass("active");
    $("main").load("views/produtos.html");
  })

  $("#menuContato").click(() =>{
    removeClass();
    $("#menuContato").addClass("active");
    $("main").load("views/contato.html");
  })
})