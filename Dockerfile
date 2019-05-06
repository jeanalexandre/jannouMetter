# Creation d'un conteneur maven
FROM maven:alpine as jvm

# On défini le repertoire de tavail
WORKDIR /java-app

# On copie la totalité du contenu de l'app dans java-app
COPY . .

# Lance la commande mvn package pour build
RUN mvn package

# On se place dans un nouveau repertoire apres le build
WORKDIR /java-jar

# On copie tout les .jar genere par le build dans java-jar (emplacement courant)
RUN cp /java-app/target/*.jar /java-jar

# On demarre l'app en lancant demarrant l'app
CMD ["java", "-jar", "app.jar"]
