# Étape 1 : utiliser une image Java comme base
FROM eclipse-temurin:17-jdk-jammy

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier jar compilé dans le conteneur
COPY target/BookService-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port utilisé par le service
EXPOSE 8081

# Commande pour lancer l'application
ENTRYPOINT ["java","-jar","app.jar"]
