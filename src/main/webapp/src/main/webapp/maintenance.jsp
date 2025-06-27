<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Suivi de Maintenance des Véhicules</title>
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

<body class="bg-light">

<main>
  <div class="container">
    <section class="register d-flex flex-column align-items-center justify-content-center py-4">
           <!-- Logo -->
           <div class="d-flex justify-content-center py-4">
            <a href="home.jsp" class="logo d-flex align-items-center w-auto">
              <img src="assets/img/logo.png" alt="">
              <span class="d-none d-lg-block">TransLogistics</span>
            </a>
          </div><!-- End Logo -->
      <div class="card shadow-lg p-4 mb-5 rounded">
        
                     
        <div class="card-body">
          <h5 class="card-title text-center pb-0 fs-4">Suivi de Maintenance d'un Véhicule</h5>
          <form action="/suiviMaintenance" method="post" class="needs-validation" novalidate>
            <!-- Sélection du véhicule -->
            <div class="mb-3">
              <label for="idvehicule" class="form-label">Donner ID de Véhicule</label>
              <input type="text" id="idvehicule" name="idvehicule" class="form-control" placeholder="Ex : VH-immatriculation" required>
              <div class="invalid-feedback">Veuillez sélectionner un véhicule.</div>
            </div>

            <!-- Date de maintenance -->
            <div class="mb-3">
              <label for="dateMaintenance" class="form-label">Date de la maintenance</label>
              <input type="date" id="dateMaintenance" name="dateMaintenance" class="form-control" required>
              <div class="invalid-feedback">Veuillez saisir la date de maintenance.</div>
            </div>

            <!-- Type de maintenance -->
            <div class="mb-3">
              <label for="typeMaintenance" class="form-label">Type de maintenance</label>
              <select id="typeMaintenance" name="typeMaintenance" class="form-select" required>
                <option value="" selected disabled>Choisir le type de maintenance</option>
                <option value="Révision">Révision</option>
                <option value="Réparation">Réparation</option>
                <option value="Changement de pièce">Changement de pièce</option>
              </select>
              <div class="invalid-feedback">Veuillez sélectionner un type de maintenance.</div>
            </div>

            <!-- Description de la maintenance -->
            <div class="mb-3">
              <label for="description" class="form-label">Description de la maintenance</label>
              <textarea id="description" name="description" rows="4" class="form-control" placeholder="Décrivez les interventions effectuées..." required></textarea>
              <div class="invalid-feedback">Veuillez fournir une description de la maintenance.</div>
            </div>

            <!-- Technicien -->
            <div class="mb-3">
              <label for="idtechnicien" class="form-label">ID du technicien</label>
              <input type="text" id="idtechnicien" name="idtechnicien" class="form-control" required>
              <div class="invalid-feedback">Veuillez saisir l'ID du technicien.</div>
            </div>

            <!-- Statut de la maintenance -->
            <div class="mb-3">
              <label for="statut" class="form-label">Statut de la maintenance</label>
              <select id="statut" name="statut" class="form-select" required>
                <option value="" selected disabled>Sélectionner le statut</option>
                <option value="Terminé">Terminé</option>
                <option value="En cours">En cours</option>
                <option value="A planifier">A planifier</option>
              </select>
              <div class="invalid-feedback">Veuillez sélectionner un statut.</div>
            </div>
            <div class="mb-3">
              <label class="form-label">Confirmation de Diagnostic</label>
              <div class="form-check">
                  <input class="form-check-input" type="checkbox" id="livraisonConfirmee" name="livraisonConfirmee" value="true" required>
                  <label class="form-check-label" for="livraisonConfirmee">Je confirme que le diagnostic est términé </label>
                  <div class="invalid-feedback">Veuillez confirmer le Diagnostic.</div>
              </div>
          </div>
            <!-- Remarques supplémentaires -->
            <div class="mb-3">
              <label for="remarques" class="form-label">Remarques supplémentaires</label>
              <textarea id="remarques" name="remarques" rows="3" class="form-control" placeholder="Ajouter des remarques (facultatif)"></textarea>
            </div>

            <!-- Bouton de soumission -->
            <button type="submit" class="btn btn-primary w-100">Enregistrer la Maintenance</button>
          </form>
        </div>
      </div>
    </section>
  </div>
</main>

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