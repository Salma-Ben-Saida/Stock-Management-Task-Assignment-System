<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Obtenir un Devis - TransLogistics</title>
  <meta name="description" content="">
  <meta name="keywords" content="">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Fonts -->
  <link href="https://fonts.googleapis.com" rel="preconnect">
  <link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Main CSS File -->
  <link href="assets/css/main.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Logis
  * Template URL: https://bootstrapmade.com/logis-bootstrap-logistics-website-template/
  * Updated: Aug 07 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body class="get-a-quote-page">

  <header id="header" class="header d-flex align-items-center fixed-top">
    <div class="container-fluid container-xl position-relative d-flex align-items-center">

      <a href="home.jsp" class="logo d-flex align-items-center me-auto">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <!-- <img src="assets/img/logo.png" alt=""> -->
        <h1 class="sitename">TransLogistics</h1>
      </a>

     
      <nav id="navmenu" class="navmenu">
        <ul>
          <li><a href="home.jsp">Acceuil<br></a></li>
          <li><a href="about.jsp" class="active">À Propos</a></li>
          <li><a href="services.jsp">Services</a></li>
          <li><a href="register.jsp">Créer Compte</a></li>
          <li><a href="login.jsp">Se Connecter</a></li>
          <li><a href="contact.jsp">Contact</a></li>
        </ul>
        <i class="mobile-nav-toggle d-xl-none bi bi-list"></i>
      </nav>

      <a class="btn-getstarted" href="devis.jsp">Obtenir un Devis</a>

    </div>
  </header>

  <main class="main">

    <!-- Page Title -->
    <div class="page-title dark-background" data-aos="fade" style="background-image: url(assets/img/page-title-bg.jpg);">
      <div class="container position-relative">
        <h1>Obtenir un Devis</h1>
        <p>Demandez votre devis personnalisé pour des solutions logistiques adaptées à vos besoins.</p>
        <nav class="breadcrumbs">
          <ol>
            <li><a href="home.jsp">Acceuil</a></li>
            <li class="current">Obtenir un Devis</li>
          </ol>
        </nav>
      </div>
    </div><!-- End Page Title -->

    <!-- Get A Quote Section -->
    <section id="get-a-quote" class="get-a-quote section">

      <div class="container">

        <div class="row g-0" data-aos="fade-up" data-aos-delay="100">

          <div class="col-lg-5 quote-bg" style="background-image: url(assets/img/quote-bg.jpg);"></div>

          <div class="col-lg-7" data-aos="fade-up" data-aos-delay="200">
            <form action="forms/get-a-quote.php" method="post" class="php-email-form">
              <h3>Obtenir un Devis</h3>
              <p>Veuillez remplir le formulaire ci-dessous pour recevoir votre devis personnalisé dans les plus brefs délais.</p>

              <div class="row gy-4">

                <div class="col-md-6">
                  <input type="text" name="departure" class="form-control" placeholder="Ville de départ" required="">
                </div>

                <div class="col-md-6">
                  <input type="text" name="delivery" class="form-control" placeholder="Ville de livraison" required="">
                </div>

                <div class="col-md-6">
                  <input type="text" name="weight" class="form-control" placeholder="Total Weight (kg)" required="">
                </div>

                <div class="col-md-6">
                  <input type="text" name="dimensions" class="form-control" placeholder="Dimensions (cm)" required="">
                </div>

                <div class="col-lg-12">
                  <h4>Vos informations personnelles</h4>
                </div>

                <div class="col-12">
                  <input type="text" name="name" class="form-control" placeholder="Nom" required="">
                </div>

                <div class="col-12 ">
                  <input type="email" class="form-control" name="email" placeholder="Email" required="">
                </div>

                <div class="col-12">
                  <input type="text" class="form-control" name="phone" placeholder="Téléphone" required="">
                </div>

                <div class="col-12">
                  <textarea class="form-control" name="message" rows="6" placeholder="Message" required=""></textarea>
                </div>

                <div class="col-12 text-center">
                  <div class="loading">Chargement</div>
                  <div class="error-message"></div>
                  <div class="sent-message">Votre demande de devis a été envoyée avec succès. Merci !</div>

                  <button type="submit">Obtenir un Devis</button>
                </div>

              </div>
            </form>
          </div><!-- End Quote Form -->

        </div>

      </div>

    </section><!-- /Get A Quote Section -->

  </main>
  <footer id="footer" class="footer dark-background">

    <div class="container footer-top">
      <div class="row gy-4">
        <div class="col-lg-5 col-md-12 footer-about">
          <a href="home.html" class="logo d-flex align-items-center">
            <span class="sitename">TransLogistics</span>
          </a>
          <p>Votre partenaire de confiance  qui propose le transport de toutes marchandises conteneurisées, conventionnels, groupages ou remorques frigorifiques et autres depuis départ-usine jusqu’à arriver et ce dans les règles de l’art et avec professionnalisme.</p>
          <div class="social-links d-flex mt-4">
            <a href=""><i class="bi bi-twitter-x"></i></a>
            <a href=""><i class="bi bi-facebook"></i></a>
            <a href=""><i class="bi bi-instagram"></i></a>
            <a href=""><i class="bi bi-linkedin"></i></a>
          </div>
        </div>

        <div class="col-lg-2 col-6 footer-links">
          <h4>Liens utiles</h4>
          <ul>
            <li><a href="home.jsp">Acceuil</a></li>
            <li><a href="about.jsp">À Propos</a></li>
            <li><a href="services.jsp">Services</a></li>
            <li><a href="contact.jsp">Contact</a></li>
            <li><a href="devis.jsp">Obtenir un Devis</a></li>
          </ul>
        </div>

        <div class="col-lg-2 col-6 footer-links">
          <h4>Nos Services</h4>
          <ul>
            <li><a href="#">Service logistique</a></li>
            <li><a href="#">Transport terrestre</a></li>
            <li><a href="#">Transport Express</a></li>
            <li><a href="#">Stockage</a></li>
            <li><a href="#">Transport Produit Frais</a></li>
          </ul>
        </div>

        <div class="col-lg-3 col-md-12 footer-contact text-center text-md-start">
          <h4>Contactez-nous</h4>
          <p>Résidence Kahia 03 App 13 Chouchet Rades – </p>
          <p>Ben Arous</p>
          <p> Tunisie</p>
          <p class="mt-4"><strong>Téléphone:</strong> <span>+216 31 550 533</span></p>
          <p><strong>Email:</strong> <span>info@translogistics.com</span></p>
        </div>

      </div>
    </div>

    <div class="container copyright text-center mt-4">
      <p>© <span>Copyright</span> <strong class="px-1 sitename">TransLogistics</strong> <span>All Rights Reserved</span></p>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you've purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: [buy-url] -->
      
      </div>
    </div>

  </footer>

  <!-- Scroll Top -->
  <a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Preloader -->
  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>