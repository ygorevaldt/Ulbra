  function enviaForm(){
    let respostaFormulario = document.querySelector("#respostaFormulario");

    let dadosFormulario = {
      nome: document.querySelector("#nome").value,
      telefone: document.querySelector("#telefone").value,
      email: document.querySelector("#email").value
    }

    if(dadosFormulario.nome &&  dadosFormulario.email) {
      respostaFormulario.innerHTML  = `<span class="text-success">Dados enviados com sucesso</span>`;
    } else {
      respostaFormulario.innerHTML = `<span class="text-danger">Você esqueceu de preencher um campo obrigatório</span>`;
    }
  }
