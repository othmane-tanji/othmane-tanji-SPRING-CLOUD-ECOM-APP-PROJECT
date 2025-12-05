# Spring Cloud Microservices - Customers, Inventory, Gateway & Eureka

Ce projet présente une architecture microservices basée sur **Spring Boot** et **Spring Cloud**, incluant :

- Un **Customer Service** exposé avec Spring Data REST
- Un **Inventory/Product Service**
- Un **Eureka Discovery Service** pour la découverte des services
- Un **Spring Cloud Gateway** jouant le rôle d’API Gateway
- L’utilisation de **Spring Data REST**, **projections**, **Actuator**, **routage statique et dynamique** via le Gateway

L’objectif est de montrer comment construire une architecture claire, documentée par des captures d’écran numérotées.

---

## 🏗️ Architecture globale

Ce projet suit le schéma classique :

**Client → Spring Cloud Gateway → (Customer Service / Inventory Service) + Eureka Discovery**

---

## 🖼️ Captures d’écran (numérotées dans l’ordre)

### 1️⃣ Vérification du Customer Service dans H2

**(1) Vérifier les données `Customer` dans H2.**  
Permet de confirmer que les clients sont bien persistés en base.

![1 - Customers dans H2](screenshots/verifier-customerservice-en-h2-2.PNG)

---

### 2️⃣ Exposition automatique via Spring Data REST

**(2) Vérifier que `CustomerService` expose les ressources via Spring Data REST.**  
Spring Data REST joue le rôle de contrôleur REST automatique.

![2 - Spring Data REST Customers](screenshots/verifier-customerservice-en-springdatarest(fonctione-comme-controlleur)-3.PNG)

---

### 3️⃣ Exposer l’ID côté Spring Data REST (Code)

**(3) Configuration pour exposer les IDs dans les réponses JSON.**

![3 - Exposer ID (Code)](screenshots/exposer-le-id-dans-springdatarest(requete-CONVENTION)-car-pardefaut-la-serialization-le-cache-(code)4.PNG)

---

### 4️⃣ Exposer l’ID côté Spring Data REST (Résultat)

**(4) Résultat : les IDs sont maintenant visibles dans la réponse JSON.**

![4 - Exposer ID (Résultat)](screenshots/exposer-le-id-dans-springdatarest(requeteCONVENTION)-car-pardefaut-la-serialization-le-cache-4.PNG)

---

### 5️⃣ Personnalisation du chemin Spring Data REST

**(5) Personnaliser le path d’accès (ex: `/api/customers`) au lieu des URLs par défaut.**

![5 - Personnaliser chemin Spring Data REST](screenshots/personaliser-le-chemin-de-springdata-rest-6.PNG)

---

### 6️⃣ Projection Spring Data REST (Code)

**(6) Mise en place d’une projection pour contrôler les champs retournés (style GraphQL).**

![6 - Projection (Code)](screenshots/La-projection-pour-renvoyer-que-les-chap-demandé-CODE-5.PNG)

---

### 7️⃣ Projection Spring Data REST (Résultat)

**(7) Résultat de la projection : seules les propriétés souhaitées sont renvoyées.**

![7 - Projection (Résultat)](screenshots/La-projection-pour-renvoyer-que-les-chap-demandé-5.PNG)

---

### 8️⃣ Vérifier le statut du Customer Service avec Actuator (Health)

**(8) Utilisation de `/actuator/health` pour vérifier que le service est bien démarré.**

![8 - Actuator Health](screenshots/verifier-si-customerservice-est-demaré-AVECactuatorHEALTH-6.PNG)

---

### 9️⃣ Vérifier qu’un service est bien démarré

**(9) Vérification supplémentaire de l’état d’un service avant intégration avec les autres composants.**

![9 - Vérifier service démarré](screenshots/verifier-si-service-est-demaré-7.PNG)

---

### 🔟 Création des microservices & préparation du Gateway

**(10) Création des services (Customer, Inventory sur port 8082, etc.) et préparation de la configuration Gateway.**

![10 - Préparation Gateway](screenshots/tout-ce-quon-a-fait-des-maintenant-on-a-creer-les-...entorydansPORT8082-maitenant-on-va-configurer-la-gateway-8.PNG)

---

### 1️⃣1️⃣ Configuration statique de la Gateway (YAML)

**(11) Configuration des routes statiques dans Spring Cloud Gateway pour router vers les microservices.**

![11 - Gateway config statique](screenshots/configuration-de-la-gateway-de-maniere-static-9.PNG)

---

### 1️⃣2️⃣ Schéma du routage statique Gateway

**(12) Schéma expliquant le routage statique à travers le Gateway.**

![12 - Schéma Gateway statique](screenshots/configuration-de-la-gateway-de-maniere-static-Schema-10.PNG)

---

### 1️⃣3️⃣ Intégration avec Eureka (Découverte de services)

**(13) Intégration du Discovery Service pour que les microservices s’enregistrent automatiquement sans connaître les adresses exactes des autres.**

![13 - Configuration Eureka / Discovery](screenshots/maitenant-le%20discovery-service-pour-avoir-enreng...il-a-pas-besoin-de-connaitre-ladresse-mais-juste-le-nom-11.PNG)

---

### 1️⃣4️⃣ Dashboard Eureka

**(14) Vue du tableau de bord Eureka montrant les services enregistrés.**

![14 - Eureka Dashboard](screenshots/eureka-discovery-service-dashboard-12.PNG)

---

### 1️⃣5️⃣ Tous les services enregistrés dans Eureka

**(15) Confirmation que les trois services sont bien enregistrés dans Eureka.**

![15 - Les trois services enregistrés](screenshots/LES-trois-service-sont-enrengistre-dans-discovery-eurika-13.PNG)

---

### 1️⃣6️⃣ Accès au microservice via la Gateway

**(16) Démonstration : appel du `CustomerService` via la Gateway au lieu d’appeler directement le microservice.**

![16 - Accès via Gateway](screenshots/on-peut-acceder-au-microservice-depuis-la-gateway-14.PNG)

---

### 1️⃣7️⃣ Routage dynamique avec Eureka + Gateway

**(17) Utilisation du routage dynamique (`lb://SERVICE-NAME`) basé sur les noms des services enregistrés dans Eureka.**

![17 - Routage dynamique](screenshots/gateway-ROUTAGEdynamique-il-suffit-dajouter-le-nom-de-service-slash-api-slash-customer-15.PNG)

---

### 1️⃣8️⃣ Architecture Gateway / Microservices

**(18) Schéma global de l’architecture Spring Cloud Gateway + microservices + Eureka.**

![18 - Architecture Gateway](screenshots/architecture-de-gateway-utilisé-15.PNG)

---

### 1️⃣9️⃣ Actuator - Beans et infos techniques

**(19) Visualisation des informations exposées par Actuator (beans, context, etc.) pour le monitoring.**

![19 - Actuator Infos](screenshots/actuator-affiche-tout-les-bins-ui-sont-demare-8.PNG)

---

## 2️⃣0️⃣ Configuration du Spring Cloud Config Server

**(20) Création du config-service, configuration du port 9999 et initialisation du repo Git config-repo contenant les fichiers de configuration utilisés par les microservices.**

![20 - ConfigService](screenshots/config-repo-git-commit-1.png)

---

## 2️⃣1️⃣ Config Server – Activation avec @EnableConfigServer

**(21) Activation du serveur de configuration Spring Cloud grâce à l’annotation @EnableConfigServer dans la classe ConfigServiceApplication, après l’initialisation du dépôt Git contenant les fichiers de configuration.**

![21 - ConfigService](screenshots/ACTIVER-SERVICE-CONFIGURATION-2.png)

---

## 2️⃣2️⃣ Définition du chemin Git pour le Config Server

**(22) Configuration du spring.cloud.config.server.git.uri avec le chemin complet du dossier config-repo, récupéré via la commande pwd, afin que le Config Server puisse charger les fichiers de configuration.**

![22 - Eureka Dashboard](screenshots/CONFIG-pATH-3.png)

---

## 2️⃣3️⃣ Test du Config Server – Chargement de la configuration d’un microservice

**(23) Vérification du fonctionnement du Config Server via l’URL http://localhost:9999/customer-service/default, montrant le JSON généré contenant les propriétés chargées depuis le repo Git (customer-service.properties et application.properties).**

![23 - Eureka Dashboard](screenshots/TEST-CONFIG-SERVICE-4.png)

---

## 2️⃣4️⃣ Injection des paramètres du Config Server dans un microservice

**(24) Test de l’injection des propriétés distantes (global.params.p1, global.params.p2) depuis le Config Server dans le microservice customer-service, avec exposition via l’endpoint /testConfig1. Le JSON retourné ({"p1":"456","p2":"234"}) confirme que la configuration est correctement chargée.**

![24 - Eureka Dashboard](screenshots/CUSTOMERSERVICE-A-CONTACTER-CONFIGSERVICE-5.png)

---

## 2️⃣5️⃣ Modification des paramètres globaux (sans rafraîchissement automatique)

**(25) Mise à jour des valeurs global.params.p1 et global.params.p2 dans application.properties du config-repo (777 et 8989).**
**Cependant, le microservice customer-service affiche toujours les anciennes valeurs (456, 234) car aucun mécanisme de rafraîchissement** **(/actuator/refresh, Spring Cloud Bus, ou redémarrage manuel) n’a encore été déclenché.**

![25 - Eureka Dashboard](screenshots/ON-A-CHANGE-LES-PARAM-MAIS-PAS-DE-CHANGEMENT-DANS-WEB-6.png)

---

## 2️⃣6️⃣ Rafraîchissement manuel de la configuration avec /actuator/refresh

**(26) Envoi d’une requête POST vers http://localhost:8081/actuator/refresh afin de recharger dynamiquement les nouvelles valeurs du config-repo sans redémarrer le microservice. La réponse 200 OK confirme que les propriétés ont été actualisées côté client.**

![26 - Eureka Dashboard](screenshots/REQUETE-POST-7.png)

---

## 2️⃣7️⃣ Vérification des microservices enregistrés dans Eureka

(27) Consultation du tableau de bord Eureka (http://localhost:8761) pour vérifier que tous les microservices sont correctement enregistrés :

BILLING-SERVICE

CONFIG-SERVICE

CUSTOMER-SERVICE

GATEWAY-SERVICE

INVENTORY-SERVICE

Tous apparaissent avec le statut UP et leurs URLs respectives, confirmant une intégration réussie avec le Discovery Server.

![27 - Eureka Dashboard](screenshots/eureka-check-services-8.png)


---

## 2️⃣8️⃣ Vérification du routage via le Gateway

**(28) Appel de l’endpoint /testConfig1 du microservice customer-service en passant par l’API Gateway (http://localhost:8888/CUSTOMER-SERVICE/testConfig1).
Les valeurs retournées ({"p1":"1111","p2":"2222"}) confirment que :

le routage dynamique lb://CUSTOMER-SERVICE fonctionne,

la configuration a bien été rafraîchie après le /actuator/refresh,

la communication Gateway → Eureka → Customer-Service est correcte. **

![28 - Eureka Dashboard](screenshots/ON-PASSE-par-gateway-et-on-verifie-9.png)



2️⃣9️⃣ Appel d’un microservice complet via le Gateway – Facture détaillée

(30) Test du routage complet via Gateway avec l’endpoint :
http://localhost:8888/BILLING-SERVICE/bills/1

La réponse JSON retournée contient :

les informations de la facture (billingDate, customerId, …)

les productItems enrichis automatiquement par le Inventory Service,

les informations du Customer Service récupérées via communication inter-services,

le tout accessible via Gateway grâce au routage dynamique Eureka + Gateway.

![29 - Eureka Dashboard](screenshots/TOUT-FONCTIONE-FINAL.png)


3️⃣0️⃣ Architecture globale — Communication entre Config Server, Eureka, Gateway et microservices

(29) Schéma d’ensemble montrant l’architecture microservices complète :

(1) Les microservices (Customer, Billing, Inventory) se registrent automatiquement auprès du Eureka Discovery Server.

(2) Le Config Service fournit les configurations centralisées à tous les microservices.

(3) Le Spring Cloud Gateway récupère la liste des instances via Eureka et redirrige les clients vers les bons services grâce au routage dynamique.

**(4) Eureka agit comme un registre des services disponibles.

**(5) Les microservices communiquent entre eux via Eureka, sans connaître leurs adresses réelles.

![30 - Eureka Dashboard](screenshots/architecture-finale-02.png)


## 3️⃣1️⃣ Intégration du Frontend Angular avec les microservices via le Gateway

(31) Le frontend Angular (port 4200) consomme l’API INVENTORY-SERVICE via le Gateway (http://localhost:8888/INVENTORY-SERVICE/products) et affiche correctement la liste des produits.
Cela confirme :

le bon fonctionnement du CORS,

la communication Angular → Gateway → Eureka → Inventory Service,

le mapping du tableau Angular avec les données réelles du microservice.

![31 - ANGULAR INVENTORY](screenshots/1.png)


## 3️⃣2️⃣ Frontend Angular – Affichage des clients via le Customer Service

(32) Le frontend Angular (port 4200) consomme l’API du CUSTOMER-SERVICE via le Gateway (http://localhost:8888/CUSTOMER-SERVICE/customers) et affiche la liste des clients.
Ce résultat confirme que :

le routage dynamique via Gateway fonctionne,

le service Eureka fournit correctement l’adresse du microservice,

le frontend récupère et mappe les données du backend sans erreur,

CORS et HTTPClient Angular sont correctement configurés.

![32 - ANGULAR INVENTORY](screenshots/2.png)


## 🚀 Lancement du projet

1. Démarrer **Eureka Discovery Service**
2. Démarrer **Customer Service**
3. Démarrer **Inventory/Product Service**
4. Démarrer **Spring Cloud Gateway**
5. Tester :
   - `http://localhost:<gateway-port>/api/customers`
   - `http://localhost:<gateway-port>/api/products`
   - `http://localhost:<eureka-port>/` pour le dashboard Eureka

---

## 🛠️ Stack technique

- Java & Spring Boot
- Spring Data JPA & Spring Data REST
- Spring Cloud Gateway (statique & dynamique)
- Spring Cloud Netflix Eureka
- Spring Boot Actuator
- H2 Database

