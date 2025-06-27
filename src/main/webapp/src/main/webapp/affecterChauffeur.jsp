<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Affectation Chauffeur Vehicule</title>
    <!-- Bootstrap CSS -->
 <!-- Bootstrap CSS -->
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
<body class="bg-light">

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

                        <div class="card mb-3">
                            <div class="card-body">
                                <h5 class="card-title text-center pb-0 fs-4">Affectation d'Äôun Chauffeur a†un Vehicule</h5>
                                <p class="text-center small">Veuillez remplir les informations pour affecter un chauffeur a un vehicule pour un trajet existant</p>

                                <form action="${pageContext.request.contextPath}/affecterChauffeur" method="post" class="row g-3 needs-validation" novalidate>
                                    <div class="col-12">
                                        <label for="trajetId" class="form-label">Donner l'ID du Trajet</label>
                                        <div class="input-group has-validation">
                                            <span class="input-group-text" id="inputGroupPrepend">#</span>
                                            <input type="text" id="trajetId" name="trajetId" class="form-control" placeholder="Ex : TRJ-12345678" required>
                                            <div class="invalid-feedback">Veuillez saisir un identifiant de trajet valide.</div>
                                        </div>
                                    </div> 

                                    <div class="col-12">
                                        <label for="idchauffeur" class="form-label">Donner l'ID du Chauffeur</label>
                                        <input type="text" id="idchauffeur" name="idchauffeur" class="form-control" placeholder="CH-numCIN" required>
                                        <div class="invalid-feedback">Veuillez s√©lectionner un chauffeur.</div>
                                    </div>

                                    <div class="col-12">
                                        <label for="idvehicule" class="form-label">Donner l'ID du Vehicule</label>
                                        <input type="text" id="idvehicule" name="idvehicule" class="form-control" placeholder="Ex : VH-immatriculation" required>
                                        <div class="invalid-feedback">Veuillez selectionner un v√©hicule.</div>
                                    </div>

                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary w-100">Affecter le Chauffeur</button>
                                    </div>
                                </form>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>

    </div>
</main><!-- End #main -->

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // Validation Bootstrap
    (() => {
        'use strict';
        const forms = document.querySelectorAll('.needs-validation');
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    })();
</script>
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
