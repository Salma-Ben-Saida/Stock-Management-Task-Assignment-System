# Stock-Management-Task-Assignment-System

🇺🇸 README – FleetMan | Fleet & Driver Management System (JEE Project)

📌 Project Overview
FleetMan is a Java EE-based management system developed for the logistics company TransLogistics, aiming to centralize and streamline the coordination of vehicles, drivers, and delivery routes.
This academic project demonstrates how a backend system can support logistical decision-making through modular design, XML data modeling, and task assignment logic.

🎯 Mission Objective
TransLogistics seeks to enhance the operational efficiency of its fleet and drivers by implementing a reliable and centralized digital system.
FleetMan fulfills this need by offering tools for:

* Managing vehicle condition and maintenance schedules
* Assigning drivers based on skills, availability, and certifications
* Planning and tracking delivery routes
* Improving coordination and performance tracking
* Integrating with GPS modules for real-time vehicle tracking
* Enabling future data integration with other enterprise systems
  
💡 Key Features

XML-Based Storage: Instead of a traditional relational database, this project uses XML files with XSD schemas for data persistence and validation (via JAXB).

Modular Design: Separation of logic across vehicle management, driver assignment, and route scheduling.

Role-Based Logic: Driver-task mapping based on profile constraints.

Custom CRUD Operations: Operations on all entities (vehicles, drivers, routes) via servlet-based controllers.

Reporting Module: Basic report generation for operational monitoring.

🛠️ Technologies Used

Java EE (Servlets)

JSP (front-end view templates – partially implemented)

XML for data persistence

XSD for schema validation

JAXB for XML serialization

MVC architecture

📈 Future Enhancements
While XML serialization was chosen for academic purposes, future iterations of FleetMan could integrate:

A relational DB (PostgreSQL/MySQL) for scalable data management

A front-end interface (React, Vue) for better UX

RESTful APIs for mobile/real-time consumption

AI-based route optimization or driver assignment

Real-time dashboard for KPIs and GPS data


-- In app Screenshots | Captures d'écran :

<img width="885" alt="Screenshot 2025-06-28 at 5 34 48 PM" src="https://github.com/user-attachments/assets/737a802c-ea11-4e1d-83c9-fc44e998e2d2" />
<img width="919" alt="Screenshot 2025-06-28 at 5 35 39 PM" src="https://github.com/user-attachments/assets/f0644ff3-ade5-4c06-9c3f-0afdb36be5c4" />
<img width="960" alt="Screenshot 2025-06-28 at 5 35 23 PM" src="https://github.com/user-attachments/assets/ef2276f1-6035-4910-999f-34541160309d" />
<img width="926" alt="Screenshot 2025-06-28 at 5 35 07 PM" src="https://github.com/user-attachments/assets/8cda8aa1-c9ca-43c1-aede-55f0d804d5d5" />

<img width="988" alt="Screenshot 2025-06-28 at 5 36 12 PM" src="https://github.com/user-attachments/assets/9d930749-7061-47be-8599-85fc6be2e8de" />
<img width="524" alt="Screenshot 2025-06-28 at 5 35 56 PM" src="https://github.com/user-attachments/assets/ebea0c4a-1b47-4f9f-92fa-c6453dc17c9d" />

<img width="593" alt="Screenshot 2025-06-28 at 5 38 03 PM" src="https://github.com/user-attachments/assets/705419ea-2377-4a29-93f1-0e69406d3077" />

<img width="869" alt="Screenshot 2025-06-28 at 5 36 52 PM" src="https://github.com/user-attachments/assets/0371031e-8ac4-431e-a699-e9e1250ac842" />
<img width="793" alt="Screenshot 2025-06-28 at 5 38 38 PM" src="https://github.com/user-attachments/assets/31c46fe0-6d1b-487c-86d4-1d1bb34e248f" />
<img width="988" alt="Screenshot 2025-06-28 at 5 36 39 PM" src="https://github.com/user-attachments/assets/a76bbecc-d310-48ac-a7fb-de458854a727" />
<img width="534" alt="Screenshot 2025-06-28 at 5 38 27 PM" src="https://github.com/user-attachments/assets/63320116-d2f6-4851-802d-b7a35f2fca64" />
<img width="859" alt="Screenshot 2025-06-28 at 5 36 24 PM" src="https://github.com/user-attachments/assets/c4ac402b-4844-4e76-a5aa-58f01facb1b1" />
<img width="683" alt="Screenshot 2025-06-28 at 5 38 16 PM" src="https://github.com/user-attachments/assets/6c3d5606-af79-4568-986d-f8007d020b51" />

<img width="755" alt="Screenshot 2025-06-28 at 5 37 47 PM" src="https://github.com/user-attachments/assets/6eafedba-8c3e-4b61-97d9-e7720c716ef0" />


<img width="732" alt="Screenshot 2025-06-28 at 5 37 29 PM" src="https://github.com/user-attachments/assets/b811246f-2f36-464d-85da-eca9ea8a7d41" />
<img width="867" alt="Screenshot 2025-06-28 at 5 37 11 PM" src="https://github.com/user-attachments/assets/899400df-143b-46bf-9926-55eded337559" />




🇫🇷 README – FleetMan | Système de Gestion de Flotte et de Chauffeurs (Projet JEE)

📌 Présentation du projet
FleetMan est une application Java EE destinée à l’entreprise fictive TransLogistics. Ce projet académique vise à centraliser et automatiser la gestion des véhicules, des chauffeurs et des trajets logistiques afin d’améliorer la productivité et la coordination.

🎯 Définition de la mission
TransLogistics souhaite digitaliser la gestion de sa flotte et optimiser ses opérations logistiques.
Le projet FleetMan vise à répondre à cet objectif par les moyens suivants :

* Administration des véhicules (état, maintenance, disponibilité)
* Gestion des chauffeurs (compétences, disponibilités, certifications)
* Planification et suivi des trajets logistiques
* Intégration possible avec un module GPS pour le suivi en temps réel
* Coordination améliorée via un système centralisé
* Préparation à l’interopérabilité avec d’autres outils existants
  
💡 Fonctionnalités principales

Base de données XML : Persistance des données via des fichiers XML, validés avec des schémas XSD (utilisation de JAXB pour sérialisation).

Architecture modulaire : Organisation claire entre les modules de véhicules, chauffeurs et trajets.

Assignation intelligente : Association chauffeurs/trajets selon leurs contraintes et qualifications.

CRUD complet : Opérations d’ajout, suppression et mise à jour sur toutes les entités.

Module de rapport : Génération de rapports simples sur les opérations.

🛠️ Technologies utilisées

Java EE (Servlets)

JSP (vues – partiellement développées)

XML comme solution de stockage

XSD pour la validation des données

JAXB (Java Architecture for XML Binding)

Architecture MVC

📈 Améliorations futures

Bien que l’utilisation du XML réponde ici à un objectif pédagogique, les évolutions possibles incluent :
Migration vers une base de données relationnelle (PostgreSQL, MySQL)
Développement d’une interface moderne (React, Vue.js)
Création d’une API RESTful
Intégration d’un moteur d’IA pour l’optimisation des trajets
Visualisation de données en temps réel via dashboard
