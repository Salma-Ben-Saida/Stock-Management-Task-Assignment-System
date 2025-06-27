<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmation de Livraison et Enregistrement de Présence</title>
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
<body>

<main>
    <div class="container min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <section class="section w-100">
            <div class="row justify-content-center">
                <div class="col-lg-6 col-md-8 col-sm-12 d-flex flex-column align-items-center justify-content-center">
                    <div class="d-flex justify-content-center py-4">
                        <a href="home.html" class="logo d-flex align-items-center w-auto">
                          <img src="assets/img/logo.png" alt="">
                          <span class="d-none d-lg-block">TransLogistics</span>
                        </a>
                      </div><!-- End Logo -->
                    <div class="card shadow-lg w-100">
                        <div class="card-body">
                            <h5 class="card-title text-center pb-0 fs-4">Confirmation de Livraison et Enregistrement de Presence</h5>
                            <form action="/confirmDeliveryAndPresence" method="post" class="needs-validation" novalidate>
                                <!-- Identifiant Chauffeur -->
                                <div class="mb-3">
                                    <label for="idchauffeur" class="form-label">ID du Chauffeur</label>
                                    <input type="text" id="idchauffeur" name="idchauffeur" class="form-control" placeholder="CH-numCIN" required>
                                    <div class="invalid-feedback">Veuillez saisir votre identifiant.</div>
                                </div>

                                <!-- Numéro de Commande -->
                                <div class="mb-3">
                                    <label for="commandeId" class="form-label">Numero de Commande</label>
                                    <input type="text" id="commandeId" name="commandeId" class="form-control" placeholder="Entrez le numéro de commande" required>
                                    <div class="invalid-feedback">Veuillez saisir le numéro de commande.</div>
                                </div>

                                <!-- Confirmation de Livraison -->
                                <div class="mb-3">
                                    <label class="form-label">Confirmation de Livraison</label>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="livraisonConfirmee" name="livraisonConfirmee" value="true" required>
                                        <label class="form-check-label" for="livraisonConfirmee">Je confirme que la commande est bien arrivee à destination</label>
                                        <div class="invalid-feedback">Veuillez confirmer la livraison.</div>
                                    </div>
                                </div>

                                <!-- Heure d'Arrivée -->
                                <div class="mb-3">
                                    <label for="heureArrivee" class="form-label">Heure d'Arrivee</label>
                                    <input type="datetime-local" id="heureArrivee" name="heureArrivee" class="form-control" required>
                                    <div class="invalid-feedback">Veuillez saisir l'heure d'arrivee.</div>
                                </div>

                                <!-- Heure de Départ -->
                                <div class="mb-3">
                                    <label for="heureDepart" class="form-label">Heure de Depart</label>
                                    <input type="datetime-local" id="heureDepart" name="heureDepart" class="form-control" required>
                                    <div class="invalid-feedback">Veuillez saisir l'heure de depart.</div>
                                </div>


                                <!-- Bouton de Confirmation -->
                                <div class="col-12">
                                <button type="submit"  class="btn btn-primary w-100">Confirmer</button></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</main>

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