CREATE DATABASE IF NOT EXISTS exercice5 CHARACTER SET utf8 COLLATE utf8_general_ci;

USE exercice5;

CREATE TABLE IF NOT EXISTS ventes (
    id_vente INT NOT NULL AUTO_INCREMENT,
    nom_produit VARCHAR(255) NOT NULL,
    quantite INT NOT NULL,
    prix_unitaire DECIMAL(6,2) NOT NULL,
    date_vente DATE NOT NULL,
    PRIMARY KEY (id_vente)

);

INSERT INTO ventes (nom_produit, quantite, prix_unitaire, date_vente)
VALUES
('Munchies Honey Sweet Trail Mix', 85, '0.27', '2023-04-01'),
 ('Eggwhite Frozen', 14, '7.82', '2023-04-11'),
 ('Sugar - Palm', 77, '6.63', '2023-04-04'),
 ('Wasabi Paste', 21, '4.22', '2023-04-21'),
('Mousse - Passion Fruit', 15, '6.00', '2023-04-30'),
('Pasta - Rotini, Dry', 99, '5.36', '2023-04-01'),
 ('Vinegar - White Wine', 12, '5.30', '2023-03-01'),
 ('Cornstarch', 14, '8.39', '2023-02-11'),
 ('Tomato - Plum With Basil', 41, '5.77', '2023-04-09'),
 ('Oil - Macadamia', 19, '5.13', '2023-04-08'),
 ('Appetizer - Seafood Assortment', 1, '0.81', '2023-04-24'),
 ('Coffee Decaf Colombian', 8, '6.43', '2023-04-03'),
 ('Beef - Baby, Liver', 61, '6.53', '2023-01-11'),
 ('Ranchero - Primerba, Paste', 7, '7.28', '2023-01-31'),
 ('Pasta - Rotini, Dry', 29, '5.36', '2023-02-28'),
 ('Mousse - Passion Fruit', 3, '6.00', '2023-02-10'),
 ('Eggwhite Frozen', 4, '7', '2023-01-31');






-- 1 Montant total des ventes pour chaque produit
SELECT nom_produit, SUM(quantite * prix_unitaire) AS montant_total FROM ventes GROUP BY nom_produit;

-- 2 Quelle est la quantité totale vendue pour chaque produit ?
SELECT nom_produit, SUM(quantite) AS quantite_totale FROM ventes GROUP BY nom_produit;

-- 3 Quelle est la date de vente la plus récente pour chaque produit ?
SELECT nom_produit, MAX(date_vente) AS date_vente FROM ventes GROUP BY nom_produit;

-- 4 Calculer le montant total des ventes par produit , ainsi que la quantité totale vendue pour chaque produit?
SELECT nom_produit, SUM(quantite * prix_unitaire) AS montant_total, SUM(quantite) AS quantite_totale FROM ventes GROUP BY nom_produit;

-- 5 Quel est le prix unitaire moyen de chaque produit vendu ?
SELECT nom_produit,ROUND( AVG(prix_unitaire), 2) AS prix_unitaire_moyen   FROM ventes GROUP BY nom_produit;

-- 6 Combien de ventes ont été réalisées pour chaque produit ?
SELECT nom_produit, COUNT(*) AS nombre_ventes FROM ventes GROUP BY nom_produit;

-- 7 Quelle est la vente avec le montant total le plus élevé ?
SELECT * FROM ventes WHERE (quantite * prix_unitaire) = (SELECT MAX(quantite * prix_unitaire) FROM ventes);

