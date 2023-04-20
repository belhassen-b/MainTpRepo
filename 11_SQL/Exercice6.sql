CREATE DATABASE IF NOT EXISTS exercice6 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE exercice6;

CREATE TABLE IF NOT EXISTS departement (
  departement_id INT NOT NULL,
  departement_code VARCHAR(3) ,
  departement_nom VARCHAR(255),
  departement_nom_uppercase VARCHAR(255),
  departement_slug VARCHAR(255),
  departement_nom_soundex VARCHAR(20),
  PRIMARY KEY (departement_id)
);

-- question 1 Obtenir la liste des 10 villes les plus peuplées en  2012
SELECT
  ville_nom,
  ville_population_2012
FROM villes_france_free
ORDER BY ville_population_2012 DESC
LIMIT 10;

-- question 2 Obtenir la liste des 50 villes ayant le plus de superficie

SELECT ville_nom, ville_surface
FROM villes_france_free
ORDER BY ville_surface ASC
LIMIT 50;

-- question 3 Obtenir la liste des départements d'outre-mer
SELECT departement_nom
FROM departement
WHERE departement_code LIKE '97%';

-- question 4 Obtenir le nom des 10 villes les plus peuplées ainsi que le départment associé
SELECT
  ville_nom,
  ville_population_2012,
  departement_nom
FROM villes_france_free
INNER JOIN departement ON departement.departement_code = villes_france_free.ville_departement
ORDER BY ville_population_2012 DESC
LIMIT 10;

-- question 5 Obtenir la liste du nom de chaque departement associé à son code et nombre de commune order by departement avec le plus de commune
SELECT
  departement_nom,
  departement_code,
  COUNT(ville_departement) AS nombre_commune
FROM villes_france_free
INNER JOIN departement ON departement.departement_code = villes_france_free.ville_departement
GROUP BY departement_nom, departement_code
ORDER BY nombre_commune DESC;

-- question 6 Obtenir la liste des plus 10 grands départements en terme de superficie
SELECT departement_nom, ROUND(SUM(ville_surface)) AS superficie
FROM villes_france_free
INNER JOIN departement ON departement.departement_code = villes_france_free.ville_departement
GROUP BY departement_nom
ORDER BY superficie DESC
LIMIT 10;

-- question 7 Compter le nombre de villes dont le nom commence par "Saint"
SELECT COUNT(ville_nom) AS nombre_ville
FROM villes_france_free
WHERE ville_nom LIKE 'Saint%';

-- quesrtion 8 Obtenir la liste des villes qui ont un nom existants plusieurs fois et trier  pour obtenir celles dont le nom est plus souvent utilisé
SELECT ville_nom, COUNT(ville_nom) AS nombre_ville
FROM villes_france_free
GROUP BY ville_nom
HAVING nombre_ville > 1
ORDER BY nombre_ville DESC;

-- question 9 Obtenir en 1 seule requête la liste des ville ddont la superficie est > à la superficie moyenne
SELECT ville_nom, ville_surface
FROM villes_france_free
WHERE ville_surface > (SELECT AVG(ville_surface) FROM villes_france_free)
ORDER BY ville_surface ASC;

-- question 10 Obtenir la liste des départements qui possèdent plus de 2 millions d 'habitants
SELECT departement_nom, SUM(ville_population_2012) AS population
FROM villes_france_free
INNER JOIN departement ON departement.departement_code = villes_france_free.ville_departement
GROUP BY departement_nom
HAVING population > 2000000;

-- question 11 Remplacez les tirets par un espace vide pour toutes les villes commençant par "SAINT-" (majuscule)
UPDATE villes_france_free
SET ville_nom = REPLACE(ville_nom, '-', ' ')
WHERE ville_nom LIKE 'SAINT-%';
