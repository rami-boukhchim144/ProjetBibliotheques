# ProjetBibliotheques

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-green)](https://spring.io/projects/spring-boot)
[![Kafka](https://img.shields.io/badge/Kafka-3.5.0-orange)](https://kafka.apache.org/)
[![Docker](https://img.shields.io/badge/Docker-24-blue)](https://www.docker.com/)

---

## 🔹 Description

ProjetBibliotheques est une application microservices pour la gestion d’une bibliothèque.  
Elle inclut plusieurs services indépendants communiquant via **Kafka** et enregistrés dans **Eureka** pour la découverte de services.

- **BookService** : Gestion des livres (CRUD, disponibilité, événements Kafka).  
- **UserService** : Gestion des utilisateurs et emprunts.  
- **GatewayService** : Point d’entrée API pour exposer les endpoints des microservices.  
- **EurekaServer** : Serveur de découverte pour gérer les microservices.  

---

## 🔹 Fonctionnalités

- Création, lecture, mise à jour et suppression de livres et utilisateurs.
- Suivi de la disponibilité des livres.
- Communication entre services via Kafka (events BookCreated, BookUpdated, etc.).
- Découverte des services via Eureka.
- Interface REST exposée via Gateway.
- Base de données H2 en mémoire pour tests et développement.

---

## 🔹 Prérequis

- [Java 17](https://www.oracle.com/java/)
- [Maven 3.8+](https://maven.apache.org/)
- [Docker & Docker Compose](https://www.docker.com/)
- [Kafka 3+](https://kafka.apache.org/)
- [Spring Boot 3+](https://spring.io/projects/spring-boot)

---

## 🔹 Installation & Exécution

### Avec Maven

1. Cloner le projet :

```bash
git clone https://github.com/rami-boukhchim144/ProjetBibliotheques.git
cd ProjetBibliotheques
Compiler chaque service :

bash
Copier le code
cd BookService
mvn clean package
cd ../UserService
mvn clean package
cd ../GatewayService
mvn clean package
cd ../EurekaServer
mvn clean package
Lancer chaque service :

bash

java -jar target/BookService-0.0.1-SNAPSHOT.jar
java -jar target/UserService-0.0.1-SNAPSHOT.jar
java -jar target/GatewayService-0.0.1-SNAPSHOT.jar
java -jar target/EurekaServer-0.0.1-SNAPSHOT.jar
Avec Docker Compose
Construire les images Docker :

bash

docker-compose build
Lancer tous les services :

bash

docker-compose up
🔹 Endpoints principaux
BookService

GET /books : Liste des livres

POST /books : Ajouter un livre

PUT /books/{id} : Mettre à jour un livre

DELETE /books/{id} : Supprimer un livre

UserService

GET /users : Liste des utilisateurs

POST /users : Ajouter un utilisateur

Gateway

GET /api/books : Redirection vers BookService

GET /api/users : Redirection vers UserService

🔹 Architecture
lua
Copier le code
+----------------+       +-----------------+
| EurekaServer    |<----->| BookService     |
+----------------+       +-----------------+
                              ^
                              |
                              v
                        +-----------------+
                        | UserService     |
                        +-----------------+
                              ^
                              |
                              v
                        +-----------------+
                        | GatewayService  |
                        +-----------------+
🔹 Technologies
Java 17

Spring Boot 3.x

Spring Cloud Netflix Eureka

Apache Kafka

H2 Database

Docker & Docker Compose

👨‍💻 Auteur

Boukhchim Rami
Étudiant en 4ᵉ année Ingénierie

