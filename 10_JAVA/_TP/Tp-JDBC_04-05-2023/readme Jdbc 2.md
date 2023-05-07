## TP2_JDBC_vente_voiture
Pour ce TP, il faudra créer une application qui fonctionnera en ligne de
commande avec une base de données MySQL (bdd_voiture).
L’application fonctionnera avec un menu comme indique ci-dessous :
1. Enregistrer la voiture
2. Lister toutes les voitures
3. Supprimer la voiture
4. Changer de voiture
5. Inscrire une personne
6. Lister toutes les personnes
7. Supprimer la personne
8. Changer de personne
9. Faire la vente
10. Afficher les ventes de voiture
11. Afficher la liste des ventes d’un véhicule pour une personne
12. Quitter


Une voiture dispose des caractéristiques suivantes :
• Id
• Nom
• Année
• Puissance cheveaux
• Prix
Une personne dispose des caractéristiques suivantes :
• Id
• Nom
• Prenom
• Age
• Prix
Une vente se compose d’une personne, d’une voiture et d’une date.
Il faudra bien respecter la structuration suivante :
• dao / daoImpl / utils / entity
On ne validera les changements que lorsqu’ils se sont biens déroulés.