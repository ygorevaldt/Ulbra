<section class="m-3">
  <h1>Contato</h1>
  <form class="form w-75" action="http://localhost/api/index.php/contact" method="POST">
    <div>
      <label for="name">Nome</label>
      <input class="form-control" type="text" name="name">
    </div>
    <div>
      <label for="email">E-mail</label>
      <input class="form-control" type="text" name="email">
    </div>
    <div>
      <label for="message" class="d-block">Mensagem</label>
      <textarea class="form-control" name="message" cols="30" rows="10" placeholder="Deixe sua mensagem"></textarea>
    </div>
    <div class="text-end">
      <button type="submit" class="btn btn-primary btn-sm mt-2">Enviar</button>
    </div>
  </form>
</section>