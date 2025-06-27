<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard -TransLogistics</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: NiceAdmin
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Updated: Apr 20 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<style>
.card {
  display: flex;
  justify-content: center;  /* Centrer horizontalement */
  align-items: center;      /* Centrer verticalement */
  height: 90%; 
              /* Assurez-vous que la carte occupe toute la hauteur disponible */
}

.card-icon {
  width: 100px;  /* Taille du cercle */
  height: 100px; /* Taille du cercle */
  background-color: #f0f0f0; /* Ajoutez une couleur de fond si nécessaire */
}

.icon-image {
  width: 55px;  /* Taille de l'image */
  height: 250px; /* Taille de l'image */
  object-fit: contain; /* Ajuster l'image sans déformation */
}


</style>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">TransLogistics</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
      <form class="search-form d-flex align-items-center" method="POST" action="#">
        <input type="text" name="query" placeholder="Search" title="Enter search keyword">
        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
      </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->

        <li class="nav-item dropdown">

          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-bell"></i>
            <span class="badge bg-primary badge-number">4</span>
          </a><!-- End Notification Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
            <li class="dropdown-header">
              Vous avez 4 notifications 
              <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>


            <li>
              <hr class="dropdown-divider">
            </li>
            <li class="dropdown-footer">
              <a href="#">Voir Tous les Notifications</a>
            </li>

          </ul><!-- End Notification Dropdown Items -->

        </li><!-- End Notification Nav -->

        <li class="nav-item dropdown">

          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-chat-left-text"></i>
            <span class="badge bg-success badge-number">3</span>
          </a><!-- End Messages Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
            <li class="dropdown-header">
              Vous avez 3 messages
              <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>


            <li class="dropdown-footer">
              <a href="#">Voir Tous les messages</a>
            </li>

          </ul><!-- End Messages Dropdown Items -->

        </li><!-- End Messages Nav -->

        <li class="nav-item dropdown pe-3">

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
            <img src="profil.png" alt="Profile" class="rounded-circle">
            <span class="d-none d-md-block dropdown-toggle ps-2">Compte</span>
          </a><!-- End Profile Iamge Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
            <li class="dropdown-header">
              <h6>Compte</h6>
              <span>Employé</span>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>Mon Compte</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.jsp">
                <i class="bi bi-gear"></i>
                <span>Paramétres</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="pages-faq.jsp">
                <i class="bi bi-question-circle"></i>
                <span>Aide?</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <i class="bi bi-box-arrow-right"></i>
                <span>Déconnexion</span>
              </a>
            </li>

          </ul><!-- End Profile Dropdown Items -->
        </li><!-- End Profile Nav -->

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="dashbordadmin.jsp">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->


      <li class="nav-heading">Pages</li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="home.jsp">
          <i class="bi bi-person"></i>
          <span>Acceuil</span>
        </a>
      </li><!-- End Profile Page Nav -->

      
      <li class="nav-item">
        <a class="nav-link collapsed" href="maintenance.jsp">
          <img src="maintenance.png" alt="Suivi de Maintenance" style="width: 27px; height: 27px; margin-right: 5px;">
          <span>Suivi De Maintenance</span>
        </a>
      </li><!-- End Contact Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="affecterchauffeurs.jsp">
          <img src="affecterchauffeurs.png" alt="Suivi de Maintenance" style="width: 27px; height: 27px; margin-right: 5px;">
          <span>Affectation Des Chauffeurs</span>
        </a>
      </li><!-- End Contact Page Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="gestionsalaire.jsp">
          <img src="gestionsalaire.png" alt="Suivi de Maintenance" style="width: 35px; height: 25px; margin-right: 5px;">
          <span>Gestion Des Salaires</span>
        </a>
      </li><!-- End Contact Page Nav -->
      

      <li class="nav-item">
        <a class="nav-link collapsed" href="register.jsp">
          <i class="bi bi-card-list"></i>
          <span>Register</span>
        </a>
      </li><!-- End Register Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="login.jsp">
          <i class="bi bi-box-arrow-in-right"></i>
          <span>Login</span>
        </a>
      </li><!-- End Login Page Nav -->

      

    </ul>

  </aside><!-- End Sidebar-->

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Dashboard</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="home.jsp">Acceuil</a></li>
          <li class="breadcrumb-item active">Dashboard</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
      <div class="row">
<!-- Left side columns -->
<div class="container d-flex justify-content-center align-items-center" style="min-height: 70vh;">
    <div class="row justify-content-center">
      <!-- Sales Card -->
      <div class="col-xxl-4 col-md-6 mb-4">
        <a href="dashbordchauffeurs.jsp" class="card-link">
          <div class="card info-card sales-card text-center">
            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
              <img src="chauffeur.png" alt="icon" class="icon-image">
            </div>
            <div class="card-body d-flex flex-column justify-content-center align-items-center">
              <h5 class="card-title mb-3">Liste Des Chauffeurs</h5>
              <p class="text-muted small">Explorez la liste complète de nos chauffeurs dédiés, au cœur de notre service de logistique et de transport.</p>
            </div>
          </div>
        </a>
      </div>
      <!-- End Sales Card -->

  
  
      <!-- Sales Card -->
      <div class="col-xxl-4 col-md-6 mb-4">
        <a href="dashbordvehicules.jsp" class="card-link">
          <div class="card info-card sales-card text-center">
            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
              <img src="vehicule.png" alt="icon" class="icon-image">
            </div>
            <div class="card-body d-flex flex-column justify-content-center align-items-center">
              <h5 class="card-title mb-3">Liste Des Véhicules</h5>
              <p class="text-muted small">Decouvrez notre flotte de véhicules, prêts à répondre à tous les besoins en matière de transport et de logistique.</p>
            </div>
          </div>
        </a>
      </div>
      <!-- End Sales Card -->
  
      <!-- Sales Card -->
      <div class="col-xxl-4 col-md-6 mb-4">
        <a href="dashbordtrajets.jsp" class="card-link">
          <div class="card info-card sales-card text-center">
            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
              <img src="trajet.png" alt="icon" class="icon-image">
            </div>
            <div class="card-body d-flex flex-column justify-content-center align-items-center">
              <h5 class="card-title mb-3">Liste Des Trajets Planifies</h5>
              <p class="text-muted small">Consultez les trajets planifiés pour une gestion optimisée de nos opérations de transport.</p>
            </div>
          </div>
        </a>
      </div>
      <!-- End Sales Card -->

      <!-- Sales Card -->
      <div class="col-xxl-4 col-md-6 mb-4">
        <a href="alerte.jsp" class="card-link">
          <div class="card info-card sales-card text-center">
            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
              <img src="alerte.png" alt="icon" class="icon-image">
            </div>
            <div class="card-body d-flex flex-column justify-content-center align-items-center">
              <h5 class="card-title mb-3">Alerte D'Incidents</h5>
              <p class="text-muted small">Signalez ici les pannes et incidents des véhicules pour une intervention rapide et efficace !</p>
            </div>
          </div>
        </a>
      </div>
      <!-- End Sales Card -->
       <!-- Sales Card -->
      <div class="col-xxl-4 col-md-6 mb-4">
        <a href="confirmationcmdpointage.jsp" class="card-link">
          <div class="card info-card sales-card text-center">
            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
              <img src="confirmationcmdpointage.png" alt="icon" class="icon-image">
            </div>
            <div class="card-body d-flex flex-column justify-content-center align-items-center">
              <h5 class="card-title mb-3">Confirmation Des Commandes</h5>
              <p class="text-muted small">Confirmez les commandes finalisées pour assurer la satisfaction client et le bon suivi logistique !</p>
            </div>
          </div>
        </a>
      </div>
      <!-- End Sales Card -->
       <!-- Sales Card -->
      <div class="col-xxl-4 col-md-6 mb-4">
        <a href="gps.jsp" class="card-link">
          <div class="card info-card sales-card text-center">
            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
              <img src="gps.png" alt="icon" class="icon-image">
            </div>
            <div class="card-body d-flex flex-column justify-content-center align-items-center">
              <h5 class="card-title mb-3">Suivi GPS</h5>
              <p class="text-muted small">Gardez un œil en temps réel sur nos véhicules pour une logistique fluide et des trajets optimisés!</p>
            </div>
          </div>
        </a>
      </div>
      <!-- End Sales Card -->
    </div>
  </div>
  
  
         
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer">
    <div class="copyright">
      &copy; Copyright <strong><span>TransLogitcs</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
      <!-- All the links in the footer should remain intact. -->
      <!-- You can delete the links only if you purchased the pro version. -->
      <!-- Licensing information: https://bootstrapmade.com/license/ -->
      <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
      
    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/chart.js/chart.umd.js"></script>
  <script src="assets/vendor/echarts/echarts.min.js"></script>
  <script src="assets/vendor/quill/quill.js"></script>
  <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>