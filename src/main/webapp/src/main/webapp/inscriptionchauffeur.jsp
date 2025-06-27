<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
      
        <title>Inscription - TransLogistics</title>
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
                                            <h5 class="card-title text-center pb-0 fs-4">Inscription d'un Chauffeur</h5>
                                            <p class="text-center small">Entrez les informations nécessaires pour inscrire un chauffeur</p>
                                        </div>

                                        <form action="/addChauffeur" method="post" class="row g-3 needs-validation" novalidate>

                                            <div class="col-12">
                                                <label for="idchauffeur" class="form-label">ID Chauffeur</label>
                                                <input type="text" id="idchauffeur" name="idchauffeur" class="form-control" placeholder="CH-numCIN" required>
                                                <div class="invalid-feedback">Veuillez sélectionner un id chauffeur.</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="nom" class="form-label">Nom</label>
                                                <input type="text" id="nom" name="nom" class="form-control" placeholder="Entrez le nom" required>
                                                <div class="invalid-feedback">Veuillez saisir le nom.</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="prenom" class="form-label">Prenom</label>
                                                <input type="text" id="prenom" name="prenom" class="form-control" placeholder="Entrez le prénom" required>
                                                <div class="invalid-feedback">Veuillez saisir le prenom.</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="email" class="form-label">Adresse e-mail</label>
                                                <input type="email" id="email" name="email" class="form-control" placeholder="exemple@domaine.com" required>
                                                <div class="invalid-feedback">Veuillez saisir une adresse e-mail valide.</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="telephone" class="form-label">Numero de telephone</label>
                                                <input type="tel" id="telephone" name="telephone" class="form-control" placeholder="Ex : +216 22 369 400" pattern="\+216\d{8}" required>
                                                <div class="invalid-feedback">Veuillez saisir un numero de telephone valide.</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="dateNaissance" class="form-label">Date de naissance</label>
                                                <input type="date" id="dateNaissance" name="dateNaissance" class="form-control" required>
                                                <div class="invalid-feedback">Veuillez saisir une date de naissance valide.</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="permis" class="form-label">Permis de conduire</label>
                                                <select id="permis" name="permis" class="form-select" required>
                                                    <option value="" selected disabled>Choisissez une catégorie de permis</option>
                                                    <option value="C">C (poids lourds)</option>
                                                    <option value="C1">C1 (véhicules légers poids lourds)</option>
                                                    <option value="CE">CE (des poids lourds (C) avec une remorque)</option>
                                                    <option value="C1E">C1E (camions légers)</option>
                                                    <option value="D">D (Remorques lourdes)</option>
                                                    <option value="BE">BE (des remorques)</option>
                                                </select>
                                                <div class="invalid-feedback">Veuillez sélectionner une catégorie de permis.</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="certifications" class="form-label">Certifications supplémentaires</label>
                                                <textarea id="certifications" name="certifications" rows="3" class="form-control" placeholder="Exemple : Transport de marchandises dangereuses, Certificat médical"></textarea>
                                            </div>

                                            <div class="col-12">
                                                <button type="submit" class="btn btn-primary w-100">Inscrire le Chauffeur</button>
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

        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/main.js"></script>

    </body>
</html>
