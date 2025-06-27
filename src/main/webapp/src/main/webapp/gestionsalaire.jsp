<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Salaires</title>
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
  <div class="container">

    <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

            <div class="d-flex justify-content-center py-4">
                <a href="home.jsp" class="logo d-flex align-items-center w-auto">
                  <img src="assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">TransLogistics</span>
                </a>
              </div><!-- End Logo -->

            <div class="card mb-3">
              <div class="card-body">

                <div class="pt-4 pb-2">
                  <h5 class="card-title text-center pb-0 fs-4">Gestion des Salaires </h5>
                </div>

                <form action="/gestionSalaries" method="post" class="row g-3 needs-validation" novalidate>
                  <!-- Sélection du Chauffeur -->
                  <div class="col-12">
                    <label for="idchauffeur" class="form-label">Donner ID du Chauffeur</label>
                    <input type="text" id="idchauffeur" name="idchauffeur" class="form-control" placeholder="CH-numCIN" >
                    <div class="invalid-feedback">Veuillez sélectionner un chauffeur.</div>
                  </div>

                  <div class="col-12">
                    <label for="idtechnicien" class="form-label">Donner ID du technicien</label>
                    <input type="text" id="idtechnicien" name="idtechnicien" class="form-control"  >
                    <div class="invalid-feedback">Veuillez sélectionner un technicien.</div>
                  </div>

                  <!-- Heures Travaillées -->
                  <div class="col-12">
                    <label for="heuresTravaillees" class="form-label">Heures Travaillées</label>
                    <input type="number" id="heuresTravaillees" name="heuresTravaillees" class="form-control" placeholder="Heures travaillées ce mois" min="0" required>
                    <div class="invalid-feedback">Veuillez entrer le nombre d'heures travaillées.</div>
                  </div>

                  <!-- Calcul du Salaire -->
                  <div class="col-12">
                    <label for="salaire" class="form-label">Salaire à Payer (Dinars)</label>
                    <input type="text" id="salaire" name="salaire" class="form-control" placeholder="Salaire calculé" readonly>
                  </div>

                  <!-- Date de Paiement -->
                  <div class="col-12">
                    <label for="datePaiement" class="form-label">Date de Paiement</label>
                    <input type="date" id="datePaiement" name="datePaiement" class="form-control" required>
                    <div class="invalid-feedback">Veuillez entrer la date de paiement.</div>
                  </div>

                  <!-- Bouton de soumission -->
                  <div class="col-12">
                    <button type="submit" class="btn btn-primary w-100">Calculer et Enregistrer</button>
                  </div>
                </form>

              </div>
            </div>

          </div>
        </div>
      </div>
    </section>

  </div>
</main>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // Fonction pour calculer le salaire en fonction des heures et du taux horaire
    document.getElementById("heuresTravaillees").addEventListener("input", calculateSalary);
    document.getElementById("tauxHoraire").addEventListener("input", calculateSalary);

    function calculateSalary() {
        const heuresTravaillees = document.getElementById("heuresTravaillees").value;
        const tauxHoraire = document.getElementById("tauxHoraire").value;
        const salaire = document.getElementById("salaire");

        if (heuresTravaillees && tauxHoraire) {
            salaire.value = (heuresTravaillees * tauxHoraire).toFixed(2);
        } else {
            salaire.value = "";
        }
    }

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