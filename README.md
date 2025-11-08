# Spring Cloud Microservices - Customer / Inventory / Gateway / Eureka

Ce projet démontre une architecture microservices basée sur **Spring Boot**, **Spring Data REST**, **Spring Cloud Gateway** et **Eureka Discovery**.

Il illustre :

- Un **Customer Service** exposé via Spring Data REST
- Un **Inventory/Product Service**
- Un **Eureka Discovery Service** pour l’enregistrement des services
- Un **API Gateway** (Spring Cloud Gateway) pour centraliser l’accès aux microservices
- L’utilisation de **projections**, **personnalisation de chemins**, **Actuator**, et **routage statique/dynamique**

---

## 🏗️ Architecture globale

L’API Gateway joue le rôle de point d’entrée unique.  
Les microservices se registrent dans Eureka, et le Gateway route les requêtes vers eux.

### 1️⃣ Architecture de la Gateway

**(01)** _Schéma de l’architecture utilisée pour le routage via Spring Cloud Gateway_  
![Architecture Gateway](screenshots/architecture-de-gateway-utilisé-15.PNG)

---

## 🧩 Customer Service

Microservice exposant les ressources `Customer` avec Spring Data REST et H2.

### 2️⃣ Vérifier `CustomerService` dans H2

**(02)** _Visualisation des données `Customer` dans la base H2 pour confirmer la persistance._  
![H2 CustomerService](screenshots/verifier-customerservice-en-h2-2.PNG)

### 3️⃣ Exposition via Spring Data REST

**(03)** _Vérification que `CustomerService` expose correctement les ressources via Spring Data REST (fonctionne comme un contrôleur REST automatique)._  
![Spring Data REST Customers](screenshots/verifier-customerservice-en-springdatarest(fonctione-comme-controlleur)-3.PNG)

### 4️⃣ Actuator Health - Customer Service

**(04)** _Utilisation d’Actuator `/actuator/health` pour vérifier que le `CustomerService` est démarré._  
![CustomerService Health](screenshots/verifier-si-customerservice-est-demaré-AVECactuatorHEALTH-6.PNG)

---

## ⚙️ Spring Data REST : Exposer l’ID & Personnaliser les chemins

### 5️⃣ Exposer l’ID dans Spring Data REST (Code)

**(05)** _Configuration côté code pour exposer l’ID des entités dans Spring Data REST (par défaut non sérialisé)._  
![Exposer ID Code](screenshots/exposer-le-id-dans-springdatarest(requete-CONVENTION)-car-pardefaut-la-serialization-le-cache-(code)4.PNG)

### 6️⃣ Exposer l’ID dans Spring Data REST (Résultat)

**(06)** _Résultat de l’exposition des IDs dans la réponse JSON Spring Data REST._  
![Exposer ID Resultat](screenshots/exposer-le-id-dans-springdatarest(requeteCONVENTION)-car-pardefaut-la-serialization-le-cache-4.PNG)

### 7️⃣ Personnaliser le chemin Spring Data REST

**(07)** _Personnalisation du chemin (ex: `/api/customers`) au lieu du chemin par défaut._  
![Custom Path Spring Data REST](screenshots/personaliser-le-chemin-de-springdata-rest-6.PNG)

---

## 📐 Projections (REST façon GraphQL)

### 8️⃣ Projection - Résultat

**(08)** _Réponse avec seulement les champs demandés (ex: `name`, `email`) grâce à une projection._  
![Projection View](screenshots/La-projection-pour-renvoyer-que-les-chap-demandé-5.PNG)

### 9️⃣ Projection - Code

**(09)** _Définition de l’interface de projection pour contrôler les champs retournés._  
![Projection Code](screenshots/La-projection-pour-renvoyer-que-les-chap-demandé-CODE-5.PNG)

---

## 📡 Eureka Discovery Service

### 🔟 Lancer & Vérifier Eureka

**(10)** _Vérification qu’un service est bien démarré avant enregistrement dans Eureka._  
![Vérifier Service](screenshots/verifier-si-service-est-demaré-7.PNG)

### 1️⃣1️⃣ Dashboard Eureka

**(11)** _Vue du dashboard Eureka montrant les services enregistrés._  
![Eureka Dashboard](screenshots/eureka-discovery-service-dashboard-12.PNG)

### 1️⃣2️⃣ Tous les services enregistrés

**(12)** _Les trois microservices sont correctement enregistrés dans Eureka._  
![Services enregistrés](screenshots/LES-trois-service-sont-enrengistre-dans-discovery-eurika-13.PNG)

---

## 🚪 Spring Cloud Gateway

### 1️⃣3️⃣ Préparation du routage vers les microservices

**(13)** _Étape de création des microservices (Customer, Inventory…) avant configuration de la Gateway._  
![Préparation Gateway](screenshots/tout-ce-quon-a-fait-des-maintenant-on-a-creer-les-...entorydansPORT8082-maitenant-on-va-configurer-la-gateway-8.PNG)

### 1️⃣4️⃣ Configuration statique de la Gateway (YAML)

**(14)** _Configuration statique des routes dans `application.yml` pour router vers les microservices._  
![Gateway Config Statique](screenshots/configuration-de-la-gateway-de-maniere-static-9.PNG)

### 1️⃣5️⃣ Schéma de la configuration statique

**(15)** _Schéma visuel expliquant le routage statique via la Gateway._  
![Gateway Static Schema](screenshots/configuration-de-la-gateway-de-maniere-static-Schema-10.PNG)

### 1️⃣6️⃣ Accès au microservice via la Gateway

**(16)** _Démonstration de l’accès au `CustomerService` à travers la Gateway (au lieu d’appeler directement le microservice)._  
![Accès via Gateway](screenshots/on-peut-acceder-au-microservice-depuis-la-gateway-14.PNG)

### 1️⃣7️⃣ Routage dynamique avec Eureka

**(17)** _Utilisation du nom logique du service (`CUSTOMER-SERVICE`) pour faire du routage dynamique (`lb://`) via la Gateway._  
![Routage dynamique](screenshots/gateway-ROUTAGEdynamique-il-suffit-dajouter-le-nom-de-service-slash-api-slash-customer-15.PNG)

---

## 🧪 Actuator & Monitoring

### 1️⃣8️⃣ Liste des beans / endpoints Actuator

**(18)** _Affichage des informations exposées par Actuator (health, beans, etc.) pour vérifier l’état de l’application._  
![Actuator Infos](screenshots/actuator-affiche-tout-les-bins-ui-sont-demare-8.PNG)

---

## 🚀 Lancer le projet

1. Démarrer **Eureka Discovery Service**
2. Démarrer **Customer Service** et **Inventory/Product Service**
3. Démarrer **Spring Cloud Gateway**
4. Tester :
   - `http://localhost:<gateway-port>/api/customers`
   - `http://localhost:<gateway-port>/api/products`
   - `http://localhost:<eureka-port>/` pour le dashboard Eureka

---

## 📚 Technologies utilisées

- Java / Spring Boot
- Spring Data JPA & Spring Data REST
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka
- H2 Database
- Spring Boot Actuator

