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
* 
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
