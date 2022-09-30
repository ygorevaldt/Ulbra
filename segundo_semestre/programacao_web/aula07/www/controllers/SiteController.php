<?php

class SiteController
{
  public function home()
  {
    require_once("views/templates/header.php");
    require_once("views/site/home.php");
    require_once("views/templates/footer.php");
  }

  public function sobre()
  {
    require_once("views/templates/header.php");
    require_once("views/site/about.php");
    require_once("views/templates/footer.php");
  }

  public function produtos()
  {
    require_once("views/templates/header.php");
    require_once("views/site/product.php");
    require_once("views/templates/footer.php");
  }

  public function contato()
  {
    require_once("views/templates/header.php");
    require_once("views/site/contact.php");
    require_once("views/templates/footer.php");
  }
}
