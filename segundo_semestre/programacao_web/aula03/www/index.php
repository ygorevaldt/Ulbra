<?php

if (!isset($_GET['controller'])) {
  require_once('controllers/SiteController.php');
  $SiteController = new SiteController();
  $SiteController->home();
} else {
  switch ($_REQUEST['controller']) {
    case 'site':
      require_once('controllers/SiteController.php');
      $SiteController = new SiteController();

      if (!isset($_GET['action'])) {
        $SiteController->home();
      } else {
        switch ($_REQUEST['action']) {
          case 'home':
            $SiteController->home();
            break;
          case 'sobre':
            $SiteController->sobre();
            break;
          case 'produtos':
            $SiteController->produtos();
            break;
          case 'contato':
            $SiteController->contato();
            break;
          default:
            break;
        }
      }
    default:
      break;
  }
}
