## TP Design Pattern Adapter

Vous travaillez pour une entreprise de location de voitures en ligne. L'entreprise a récemment décidé de s'associer avec un nouveau fournisseur de données de voitures pour améliorer la qualité de son catalogue en ligne. Malheureusement, le fournisseur utilise un format de données qui n'est pas compatible avec le système de location de voitures de l'entreprise.
Vous devez adapter ce format de données à un format compatible avec le système de location de voitures de l'entreprise en utilisant le design pattern Adapter.
Voici la classe CarData qui représente les informations d'une voiture dans le format de données du fournisseur :

![](file:///D:/MainTpRepo/10_JAVA/_TP/Tp_Vendredi_14_04_2023/img/1.png)

Et voici l'interface de la classe Car qui représente les informations d'une voiture compatible avec le système de location de voitures de l'entreprise :

![](file:///D:/MainTpRepo/10_JAVA/_TP/Tp_Vendredi_14_04_2023/img/2.png)

Votre tâche consiste à créer une classe CarDataAdapter qui adapte la classe CarData du fournisseur au format de données compatible avec le système de location de voitures de l'entreprise.

## TP Exception Java

Écrire un programme Java qui lit un tableau d'entiers à partir de la console et qui calcule la somme de tous les éléments du tableau. Si un élément du tableau ne peut pas être converti en entier, le programme doit ignorer cet élément et afficher un message d'erreur.

Si le tableau est vide, le programme doit afficher un message d'erreur.

Le programme doit également gérer les exceptions liées à la lecture à partir de la console. Voici un exemple d'entrée pour le tableau :
10 20 30 abc 40 50

Le résultat attendu pour cette entrée est : 150

Il faudra traiter les différents risques d


## TP Papeterie – HashMap :

 Papeterie :
Dans une papeterie un Article est composé au minimum d’une référence unique.
Chaque ArticleUnitaire dispose aussi de cette caractéristique en plus d’un nom et d’un prix unitaire.

 Stylo et Ramette
Il n’y a que 2 produits qui sont vendus dans cette papeterie : Stylo et Ramette.
Les ramettes qui y sont vendus disposent aussi des informations des articles unitaires et en plus d’un grammage et pour les stylos, il s’agira de la couleur.

 Lot :
Dans cette papeterie, on peut aussi acheter en lot.
Un lot se compose des infos d’un Article et se compose d’un article, d’une quantité et d’un pourcentage de remise.

 Facture :
Pour les clients (juste une chaine de caractère), ils reçoivent après leurs achats une Facture qui sera composé un nombre de ligne par défaut de 10 maximums, un numéro de facture (unique), le client, une date (chaine de caractère) et une quantité de ligne d’achat (tableau). Dans les factures, on aura 2 methodes :

-> - ajouterLigne(ref article, quanité article).
-> - getPrixTotal() => qui va retourner le montant total de la facture.

 Ligne :
Chaque ligne sera composée d’un article et d’une quantité acheté. Pour chaque ligne de la facture, une méthode AfficheLigne() nous permettra d’afficher les information suivantes :
Quantité – reference de l’article – nom de l’article – prix unitaire – prix total. Mettez bien les getters et setters, les tostring() là où ça vous paraîtra nécessaire…
Vous pouvez utiliser des abstracts, des enums, des interfaces si vous estimez que cela est nécéssaire…

En attendant de savoir comment travailler en Java avec une base de données, vous allez enregistrer les articles dans une table de hachage (HashMap) dont les clés seront les références des articles et les valeurs seront les articles eux-mêmes.

Tout article du magasin a une référence qui l'identifie parmi les autres articles. Ensuite, les articles ne sont plus désignés que par leur référence (dans les factures ou bien dans les lots). Leurs caractéristiques (par exemple, leur prix unitaire), sont ensuite automatiquement récupérés depuis la table de hachage.

2 questions auquel il faudra répondre : Où mettre cette table de hachage (hashMap)? Comment les articles seront mis dans la table de hachage ?


## TP Stream Java

En vous basant sur les classes et objets suivants, il faudra utiliser les streams en java pour répondre aux questions, ci-après.

![](file:///D:/MainTpRepo/10_JAVA/_TP/Tp_Vendredi_14_04_2023/img/3.png)

![](file:///D:/MainTpRepo/10_JAVA/_TP/Tp_Vendredi_14_04_2023/img/4.png)

1.  Sélectionner les Student qui ont un âge supérieur à 18 ans ?
2. Transformer les Teacher en une liste de leurs noms ?
3. Transformer les Teacher en une liste de leurs matières enseignées ?
4.  Donnez-moi la liste des teachers en passant par les courses ?
5.  Calculer la somme de toutes les durées des cours ?
6.  Sélectionner les cours avec une durée supérieure à 30 heures, puis récupérer une liste de leurs noms triée par ordre alphabétique ?         
7.  Regrouper les Student par âge, puis afficher le nombre d'étudiants dans chaque groupe ?
8. En passant par Student, il faut récupérer une liste de Course et il faut garder les doublons.
9. Sélectionner les cours avec une durée supérieure à 40 heures, puis récupérer une liste de leurs noms triée par ordre alphabétique ?
10. Regrouper les Teacher par année d'entrée en fonction, puis afficher le nombre d'enseignants dans chaque groupe ? (vous pouvez utiliser une collection comme map pour récupérer le resultat).
11. Sélectionner les Student avec un âge compris entre 20 et 25 ans, puis récupérer une liste de leurs Course triée par ordre alphabétique ?
12. Compter le nombre d'étudiants dans chaque cours, puis récupérer une Map associant chaque Course à son nombre d'étudiants ?
13. Quels sont les noms de tous les étudiants inscrits dans un cours donné (Java)?
14. Quel est le nom de l'enseignant qui a enseigné le plus grand nombre de cours ?
15. Quel est le nombre moyen de cours suivis par les étudiants de plus de 20 ans ?
16. Quels sont les noms des étudiants qui ont suivi tous les cours ?
17. Quel est le pourcentage d'étudiants qui ont suivi au moins un cours avec chaque enseignant ?

