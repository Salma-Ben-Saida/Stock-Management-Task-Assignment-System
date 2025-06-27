<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajout de Véhicule</title>
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

                        <!-- Logo -->
                        <div class="d-flex justify-content-center py-4">
                            <a href="home.jsp" class="logo d-flex align-items-center w-auto">
                              <img src="assets/img/logo.png" alt="">
                              <span class="d-none d-lg-block">TransLogistics</span>
                            </a>
                          </div><!-- End Logo -->

                        <div class="card mb-3">
                            <div class="card-body">
                                <div class="pt-4 pb-2">
                                    <h5 class="card-title text-center pb-0 fs-4">Ajouter un Nouveau Véhicule</h5>
                                </div>

                                <form action="/fleetMan/addVehicule" method="post" class="row g-3 needs-validation" novalidate>
                                    

                                    <!-- Numéro de plaque -->
                                    <div class="col-12">
                                        <label for="immatriculation" class="form-label">Immatriculation</label>
                                        <input type="text" id="immatriculation" name="immatriculation" class="form-control" placeholder="Ex: 213-TN-545" required>
                                        <div class="invalid-feedback">Veuillez saisir un numéro de plaque valide.</div>
                                    </div>

                                    <!-- Type de véhicule -->
                                    <div class="col-12">
                                        <label for="type" class="form-label">Modèle de véhicule</label>
                                        <select id="type" name="type" class="form-select" required>
                                            <option value="" selected disabled>Choisir un modèle de véhicule</option>
                                            <option value="Camion-porteEngines">Camion-porteEngines</option>
                                            <option value="Camion-àPlateau">Camion-àPlateau</option>
                                            <option value="Remoque">Remoque</option>
                                            <option value="Camion-citerne">Camion-citerne</option>
                                            <option value="penne-basculate">penne-basculate</option>
                                            <option value="Camion-frigorifiques">Camion-frigorifiques</option>
                                            <option value="autre">autre</option>
                                        </select>
                                        <div class="invalid-feedback">Veuillez sélectionner un modèle de véhicule.</div>
                                    </div>
                                    <!-- marque -->
                                    <div class="col-12">
                                        <label for="idvehicule" class="form-label">Marque</label>
                                        <input type="text" id="marque" name="idvehicule" class="form-control"  required>
                                        <div class="invalid-feedback">Veuillez donner la marque.</div>
                                    </div>

                                    <!-- Capacité de charge -->
                                    <div class="col-12">
                                        <label for="capacite" class="form-label">Capacité de charge (en tonnes)</label>
                                        <input type="number" id="capacite" name="capacite" class="form-control" placeholder="Ex: 5.5" step="0.1" min="0.1" required>
                                        <div class="invalid-feedback">Veuillez indiquer une capacité valide (en tonnes).</div>
                                    </div>

                                    <!-- État actuel -->
                                    <div class="col-12">
                                        <label for="etat" class="form-label">État actuel</label>
                                        <select id="etat" name="etat" class="form-select" required>
                                            <option value="" selected disabled>Choisir l'état du véhicule</option>
                                            <option value="Disponible">Disponible</option>
                                            <option value="En service">En service</option>
                                            <option value="En maintenance">En maintenance</option>
                                            <option value="En panne">En panne</option>
                                        </select>
                                        <div class="invalid-feedback">Veuillez indiquer l'état actuel du véhicule.</div>
                                    </div>

                                    <!-- Date de dernière maintenance -->
                                    <div class="col-12">
                                        <label for="maintenance" class="form-label">Date de la dernière maintenance</label>
                                        <input type="date" id="maintenance" name="maintenance" class="form-control" required>
                                        <div class="invalid-feedback">Veuillez sélectionner une date de maintenance valide.</div>
                                    </div>

                                    <!-- Commentaire -->
                                    <div class="col-12">
                                        <label for="commentaire" class="form-label">Commentaire (facultatif)</label>
                                        <textarea id="commentaire" name="commentaire" rows="3" class="form-control" placeholder="Ajoutez des détails supplémentaires (facultatif)"></textarea>
                                    </div>

                                    <!-- Bouton d'ajout -->
                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary w-100">Ajouter le Véhicule</button>
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