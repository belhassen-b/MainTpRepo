CREATE DATABASE IF NOT EXISTS `magasin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `magasin`;
CREATE TABLE IF NOT EXISTS categories
(
    id_categories  INT         NOT NULL AUTO_INCREMENT,
    nom_categories VARCHAR(45) NULL,
    PRIMARY KEY (id_categories)
);

CREATE TABLE IF NOT EXISTS produit
(
    id_produit           INT         NOT NULL AUTO_INCREMENT,
    nom_produit          VARCHAR(45) NULL,
    prix_produit         INT         NULL,
    stock        INT         NULL,
    categorie_id INT         NULL,
    PRIMARY KEY (id_produit),
    FOREIGN KEY (categorie_id) REFERENCES categories (id_categories)
);



CREATE TABLE IF NOT EXISTS client
(
    id_client     INT         NOT NULL AUTO_INCREMENT,
    nom_client    VARCHAR(45) NULL,
    prenom_client VARCHAR(45) NULL,
    email_client  VARCHAR(45) NULL,
    PRIMARY KEY (id_client)
);

CREATE TABLE IF NOT EXISTS commandes
(
    id_commandes        INT         NOT NULL AUTO_INCREMENT,
    client_id INT         NULL,
    date      DATETIME    NULL,
    statut    VARCHAR(45) NULL,
    PRIMARY KEY (id_commandes),
    FOREIGN KEY (client_id) REFERENCES client (id_client)
);

CREATE TABLE IF NOT EXISTS lignes_commande
(
    id_lignesCommande INT NOT NULL AUTO_INCREMENT,
    commande_id       INT NULL,
    produit_id        INT NULL,
    quantite          INT NULL,
    PRIMARY KEY (id_lignesCommande),
    FOREIGN KEY (commande_id) REFERENCES commandes (id_commandes),
    FOREIGN KEY (produit_id) REFERENCES produit (id_produit)

);



-- Insertion de données

INSERT INTO categories (nom_categories)
VALUES ('Fruits');
INSERT INTO categories (nom_categories)
VALUES ('Legumes');
INSERT INTO categories (nom_categories)
VALUES ('Viandes');
INSERT INTO categories (nom_categories)
VALUES ('Poissons');

INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Pomme', 2, 10, 1);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Poire', 3, 10, 1);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Banane', 1, 10, 1);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Orange', 2, 10, 1);

INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Carotte', 1, 10, 2);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Patate', 2, 10, 2);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Salade', 1, 10, 2);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Tomate', 2, 10, 2);

INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Boeuf', 10, 10, 3);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Poulet', 5, 10, 3);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Porc', 8, 10, 3);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Agneau', 12, 10, 3);

INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Saumon', 10, 10, 4);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Thon', 8, 10, 4);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Sardine', 5, 10, 4);
INSERT INTO produit (nom_produit, prix_produit, stock, categorie_id)
VALUES ('Maquereau', 6, 10, 4);


INSERT INTO client (nom_client, prenom_client, email_client)
VALUES ('Dupont', 'Jean', 'djean@test.fr');
INSERT INTO client (nom_client, prenom_client, email_client)
VALUES ('Durand', 'Pierre', 'dpierre@test.fr ');
INSERT INTO client (nom_client, prenom_client, email_client)
VALUES ('Martin', 'Paul', 'mpaul@test.fr ');
INSERT INTO client (nom_client, prenom_client, email_client)
VALUES ('Bernard', 'Jacques', 'bjacques@test.fr ');

INSERT INTO commandes (client_id, date, statut)
VALUES (1, '2018-01-01', 'En cours');
INSERT INTO commandes (client_id, date, statut)
VALUES (2, '2018-01-02', 'En cours');
INSERT INTO commandes (client_id, date, statut)
VALUES (3, '2018-01-03', 'Expédiée');
INSERT INTO commandes (client_id, date, statut)
VALUES (1, '2018-01-04', 'En cours');
INSERT INTO commandes (client_id, date, statut)
VALUES (2, '2018-01-05', 'En cours');


INSERT INTO lignes_commande (commande_id, produit_id, quantite)
VALUES (1, 1, 2);
INSERT INTO lignes_commande (commande_id, produit_id, quantite)
VALUES (1, 2, 3);
INSERT INTO lignes_commande (commande_id, produit_id, quantite)
VALUES (2, 3, 1);
INSERT INTO lignes_commande (commande_id, produit_id, quantite)
VALUES (2, 4, 2);
INSERT INTO lignes_commande (commande_id, produit_id, quantite)
VALUES (3, 5, 1);

-- Requêtes

--         Sélection des produits par nom, catégorie, prix, etc.

SELECT *
FROM produit
ORDER BY nom_produit asc;
SELECT *
FROM produit
ORDER BY categorie_id asc;
SELECT *
FROM produit
ORDER BY prix_produit asc;
SELECT *
FROM produit
ORDER BY stock asc;


--         Affichage des clients et de leurs commandes

SELECT *
FROM client
ORDER BY nom_client asc;

SELECT *
FROM commandes
ORDER BY client_id asc;

--         Filtrage des commandes en fonction de la date, du montant total ou du statut

SELECT *
FROM commandes
ORDER BY date asc;
SELECT *
FROM commandes
ORDER BY statut asc;



-- determine le chiffre d'affaire pour une période donnée
SELECT SUM(produit.prix_produit) AS Chiffre_d_affaire_pour_une_periode_donnee
FROM produit
         INNER JOIN commandes ON date
WHERE date between '2018-01-01' and '2018-01-03';
-- Calcul du prix moyen des commandes pour une catégorie donnée
SELECT AVG(produit.prix_produit) AS Prix_moyen_des_commandes_pour_une_catégorie_donnée
FROM produit
         INNER JOIN categories ON categorie_id
WHERE categories.nom_categories = 'Fruits';


SELECT AVG(produit.prix_produit) AS Prix_moyen_des_commandes_pour_une_catégorie_donnée
FROM produit
         INNER JOIN categories ON categorie_id
WHERE nom_categories = 'Legumes';

--   Création de vues pour simplifier l'accès aux données
--   Vue des commandes avec le détail des produits et des montants

CREATE VIEW commandes_detaillees  AS
SELECT *
FROM commandes
         INNER JOIN lignes_commande ON commandes.id_commandes = lignes_commande.commande_id;


--             Vue des produits les plus vendus

CREATE VIEW produits_plus_vendus AS
SELECT *
FROM produit
         INNER JOIN lignes_commande ON produit.id_produit = lignes_commande.produit_id
ORDER BY quantite desc;

--             Vue des clients les plus dépensiers

CREATE VIEW clients_plus_depensiers AS
SELECT nom_client, prenom_client, SUM(prix_produit) AS total
FROM client
    INNER JOIN commandes ON client.id_client = commandes.client_id
    INNER JOIN lignes_commande ON commandes.id_commandes = lignes_commande.commande_id
    INNER JOIN produit ON lignes_commande.produit_id = produit.id_produit
GROUP BY nom_client, prenom_client
ORDER BY total desc;

--         Recherche des produits ayant un stock inférieur à un seuil donné
SELECT *
FROM produit
WHERE stock < 5
ORDER BY stock asc;

-- Identification des clients n'ayant passé aucune commande durant une période spécifique

SELECT *
FROM client
         INNER JOIN commandes ON client.id_client = commandes.client_id
WHERE date between '2018-01-01' and '2018-01-03';

-- Analyse des préférences d'achat des clients en fonction des catégories de produits

SELECT *
FROM client
         INNER JOIN commandes ON client.id_client = commandes.client_id
         INNER JOIN lignes_commande ON commandes.id_commandes = lignes_commande.commande_id
         INNER JOIN produit ON lignes_commande.produit_id = produit.id_produit
         INNER JOIN categories ON produit.categorie_id = categories.id_categories
ORDER BY client.nom_client asc;
