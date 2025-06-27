<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signalement d'une Panne</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
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
                            <a href="home.html" class="logo d-flex align-items-center w-auto">
                              <img src="assets/img/logo.png" alt="">
                              <span class="d-none d-lg-block">TransLogistics</span>
                            </a>
                          </div><!-- End Logo -->

                            <div class="card mb-3">

                                <div class="card-body">

                                    <div class="pt-4 pb-2">
                                        <h5 class="card-title text-center pb-0 fs-4">Signalement d'une Panne</h5>
                                        <p class="text-center small">Veuillez remplir les informations suivantes.</p>
                                    </div>

                                    <form action="/reportPanne" method="post" class="row g-3 needs-validation" novalidate>

                                        <!-- Identifiant du véhicule -->
                                        <div class="col-12">
                                            <label for="idvehicule" class="form-label">ID du véhicule</label>
                                            <input type="text" id="idvehicule" name="idvehicule" class="form-control" placeholder="Ex : VH-immatriculation" required>
                                            <div class="invalid-feedback">Veuillez saisir l'identifiant du véhicule.</div>
                                        </div>

                                        <!-- Chauffeur assigné -->
                                        <div class="col-12">
                                            <label for="idchauffeur" class="form-label">ID du chauffeur</label>
                                            <input type="text" id="idchauffeur" name="idchauffeur" class="form-control" placeholder="CH-numCIN" required>
                                            <div class="invalid-feedback">Veuillez saisir id du chauffeur.</div>
                                        </div>

                                        <!-- Localisation de la panne -->
                                        <div class="col-12">
                                            <label for="localisation" class="form-label">Localisation</label>
                                            <input type="text" id="localisation" name="localisation" class="form-control" placeholder="Ex : Km 45, Autoroute A1" required>
                                            <div class="invalid-feedback">Veuillez indiquer la localisation de la panne.</div>
                                        </div>

                                        <!-- Date et heure -->
                                        <div class="col-12">
                                            <label for="dateHeure" class="form-label">Date et heure</label>
                                            <input type="datetime-local" id="dateHeure" name="dateHeure" class="form-control" required>
                                            <div class="invalid-feedback">Veuillez spécifier la date et l'heure de la panne.</div>
                                        </div>

                                        <!-- Type de panne -->
                                        <div class="col-12">
                                            <label for="typePanne" class="form-label">Type de panne</label>
                                            <select id="typePanne" name="typePanne" class="form-select" required>
                                                <option value="" selected disabled>Choisissez le type de panne</option>
                                                <option value="Moteur">Moteur</option>
                                                <option value="Pneu">Pneu</option>
                                                <option value="Freins">Freins</option>
                                                <option value="Électrique">Électrique</option>
                                                <option value="Autre">Autre</option>
                                            </select>
                                            <div class="invalid-feedback">Veuillez sélectionner un type de panne.</div>
                                        </div>

                                        <!-- Description supplémentaire -->
                                        <div class="col-12">
                                            <label for="description" class="form-label">Description de la panne</label>
                                            <textarea id="description" name="description" rows="4" class="form-control" placeholder="Ex : Bruit suspect dans le moteur, perte de puissance..." required></textarea>
                                            <div class="invalid-feedback">Veuillez fournir une description de la panne.</div>
                                        </div>

                                        <!-- Bouton de soumission -->
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-primary w-100">Signaler la Panne</button>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Activation de la validation Bootstrap
        (() => {
            'use strict'
            const forms = document.querySelectorAll('.needs-validation')
            Array.from(forms).forEach(form => {
                form.addEventListener('submit', event => {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
        })()
    </script>

</body>

</html>