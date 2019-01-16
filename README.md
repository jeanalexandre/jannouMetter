# jannouMetter 
[![Build Status](https://travis-ci.org/jeanalexandre/jannoumeter.svg?branch=master)](https://travis-ci.org/jeanalexandre/jannoumeter)


**Build database :**
   
 1. Construire le container docker `docker-compose up -d`
 2. Vérification du fonctionnement du container `docker ps -a`
 3. Connexion au container `docker exec -it <ID CONTAINER> bash`
 4. Lancer pgsql `psql -U psqluer`
 5. Créer la base de donnée `create database psqluer;`

**Lancer le serveur**

 1. Retourner à la racine du projet `cd ../..`
 2. Lancer la commande  `mvn spring-boot:run`
