<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Suivi GPS du Véhicule</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY"></script>
    <style>
        #map {
            width: 100%;
            height: 500px;
            border: 1px solid #ccc;
        }
    </style>
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
    
      <link href="assets/css/style.css" rel="stylesheet">
</head>
<body>

<!-- Section principale avec flexbox et centrage -->
<main>
  <div class="container">

    <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6 col-md-8 d-flex flex-column align-items-center justify-content-center">
            <div class="d-flex justify-content-center py-4">
                <a href="home.jsp" class="logo d-flex align-items-center w-auto">
                  <img src="assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">TransLogistics</span>
                </a>
              </div><!-- End Logo -->

       

            <!-- Carte GPS et formulaire dans une carte -->
            <div class="card mb-3">
              <div class="card-body">
                
                <div class="pt-4 pb-2">
                  <h5 class="card-title text-center pb-0 fs-4">Suivi GPS d'un Vehicule</h5>
                  <p class="text-center small">Entrez l'ID du vehicule pour obtenir sa position</p>
                </div>

                <!-- Formulaire de suivi GPS -->
                <form id="gpsForm" class="row g-3 needs-validation" novalidate>
                  <div class="col-12">
                    <label for="idvehicule" class="form-label">ID du Vehicule</label>
                    <input type="text" id="idvehicule" name="idvehicule" class="form-control" placeholder="Ex : VH-immatriculation" required>
                    <div class="invalid-feedback">Veuillez saisir l'identifiant du vehicule.</div>
                  </div>

                  <!-- Bouton de suivi -->
                  <div class="col-12">
                    <button type="button" class="btn btn-primary w-100" onclick="getVehicleLocation()">Afficher la Position</button>
                  </div>
                </form>

              </div>
            </div>

            <!-- Carte GPS -->
            <div class="mb-4" data-aos="fade-up" data-aos-delay="200">
                <iframe style="border:0; width: 800px; height: 500px;" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d403071.05025254794!2d10.1658!3d36.8189!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x130f5022257b4d3f%3A0x7cb14c1f6f9d3a60!2sTunis%2C%20Tunisia!5e0!3m2!1sen!2sus!4v1676961268712" 
                frameborder="0" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe> 
              </div><!-- End Google Maps -->
          </div>
        </div>
      </div>
    </section>

  </div>
</main>

<script>
    // Fonction pour obtenir et afficher la position du véhicule
    function getVehicleLocation() {
        const idvehicule = document.getElementById('idvehicule').value;

        if (!idvehicule) {
            alert('Veuillez entrer un identifiant de véhicule.');
            return;
        }

        // Exemple de coordonnées GPS (à remplacer par une API backend réelle)
        const fakeCoordinates = {
            lat: 36.8065, // Latitude fictive
            lng: 10.1815  // Longitude fictive
        };

        initMap(fakeCoordinates);
    }

    // Initialiser la carte Google Maps
    function initMap(coordinates) {
        const map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: coordinates
        });

        // Ajouter un marqueur sur la carte
        new google.maps.Marker({
            position: coordinates,
            map: map,
            title: "Position actuelle du véhicule"
        });
    }
</script>

<script>
    // Validation Bootstrap
    (function () {
        'use strict';
        var forms = document.querySelectorAll('.needs-validation');
        Array.prototype.slice.call(forms).forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    })();
</script>

<!-- Vendor JS Files -->
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

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

<script src="assets/js/main.js"></script>

</body>
</html>