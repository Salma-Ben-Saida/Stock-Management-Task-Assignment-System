<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard - TransLogistics-Véhicules</title>
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

<body>

   <!-- ======= Header ======= -->
   <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="home.jsp" class="logo d-flex align-items-center">
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
              <span>Employe</span>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.jsp">
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
                <span>Parametres</span>
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
      <h1>Liste Des Véhicules</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="home.html">Acceuil</a></li>
          <li class="breadcrumb-item active">Liste Des Véhicules</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
        <div class="row">
      
          <!-- Recent Sales -->
          <div class="col-12">
            <div class="card recent-sales overflow-auto">
      
              <div class="filter">
                <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                  <li class="dropdown-header text-start">
                    <h6>Filter</h6>
                  </li>
                  <li><a class="dropdown-item" href="#">Today</a></li>
                  <li><a class="dropdown-item" href="#">This Month</a></li>
                  <li><a class="dropdown-item" href="#">This Year</a></li>
                </ul>
              </div>
      
              <div class="card-body">
                <h5 class="card-title">Véhicules <span>| TransLogitcs</span></h5>
      
                <table class="table table-borderless datatable">
                  <thead>
                    <tr>
                      <th scope="col">idVéhicule</th>
                      <th scope="col">Immatriculation</th>
                      <th scope="col">Marque</th>
                      <th scope="col">Modéle</th>
                      <th scope="col">CapacitéCharge</th>
                      <th scope="col">Etat</th>
                      <th scope="col">DateDérnModification</th>
                   
                      <th scope="col">Operations</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row"><a href="#">#2457</a></th>
                      <td>Brandon Jacob</td>
                      <td><a href="#" class="text-primary">At praesentium minu</a></td>
                      <td>brandon@example.com</td>
                      <td>+123456789</td>
                      <td>01/01/1980</td>
                     
                      <td>Certification X</td>
                      <td>
                        <a href="gestionvehicule.html" class="btn btn-light btn-sm"><i class="bi bi-pencil-square text-primary"></i></a>
                        <a href="gestionvehicule.html" class="btn btn-light btn-sm"><i class="bi bi-plus-circle text-success"></i></a>
                        <a href="#" class="btn btn-light btn-sm"><i class="bi bi-trash text-danger"></i></a>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row"><a href="#">#2147</a></th>
                      <td>Bridie Kessler</td>
                      <td><a href="#" class="text-primary">Blanditiis dolor omnis similique</a></td>
                      <td>bridie@example.com</td>
                      <td>+987654321</td>
                      <td>15/05/1992</td>
                     
                      <td>Certification Y</td>
                      <td>
                        <a href="#" class="btn btn-light btn-sm"><i class="bi bi-pencil-square text-primary"></i></a>
                        
                        <a href="#" class="btn btn-light btn-sm"><i class="bi bi-plus-circle text-success"></i></a>
                        <a href="#" class="btn btn-light btn-sm"><i class="bi bi-trash text-danger"></i></a>
                      </td>
                    </tr>
                  </tbody>
                </table>
      
              </div>
      
            </div>
          </div><!-- End Recent Sales -->
      
        </div>
      </section>
      
      

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