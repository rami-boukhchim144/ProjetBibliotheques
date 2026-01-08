# Dockerfile pour Eureka Server
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/EurekaServer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","app.jar"]
