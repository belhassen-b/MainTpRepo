## TP Class Java

Sujet : Créez un nouveau projet» nommé « TpClasseChaise » et faire un programme permettant de :

![](file:///D:/MainTpRepo/10_JAVA/_EXERCICES/Exo_Cours_04-04-2023/img/1.png)
![](file:///D:/MainTpRepo/10_JAVA/_EXERCICES/Exo_Cours_04-04-2023/img/2.png)
 
TP Héritage

* Supposons que nous souhaitions créer une application qui permet de manipuler différents types de comptes bancaires: les compte simple, les comptes épargnes et les comptes payants.
* 	Tous les types de comptes sont caractériser par: un code et un solde
* 	Lors de la création d’un compte, son code qui est défini automatiquement en fonction du nombre de comptes créés;
* 	Un compte peut subir les opérations de versement et de retrait. Pour ces deux opérations, il faut connaître le montant de l’opération.
* 	Pour consulter un compte on peut faire appel à sa méthode toString()
* 	Un compte simple est un compte qui possède un découvert. Ce qui signifie que ce compte peut être débiteur jusqu’à la valeur du découvert.
* 	Un compte Epargne est un compte bancaire qui possède en plus un champ «tauxInterêt» et une méthode calculIntérêt() qui permet de mettre à jour le solde en tenant compte des interêts.
* Un ComptePayant est un compte bancaire pour lequel chaque opération de retrait et de versement est payante et vaut 5 % du montant de l’opération.

 
 ## TP Class- Héritage



Exercice 1
•	Créez une classe « Person ».
•	Créez une classe « Student » et une autre classe « Teacher », les deux héritent de la classe « Person ».
•	La classe « Student » aura une méthode publique « GoToClasses », qui affichera à l’écran « I’m going to class. ».
•	La classe « Teacher » aura une méthode publique « Explain », qui affichera à l’écran « Explanation begins ». En plus, il aura un attribut privé « subject » de type string.
•	La classe « Person » doit avoir une méthode « SetAge(int n) » qui indiquera la valeur de leur âge (par exemple, 15 years old).
•	La classe « Student » aura une méthode publique « DisplayAge » qui écrira sur l’écran « My age is: XX years old ».
•	Dans la class App, dans sa methode main :
o	Créez un objet Person et faites-lui dire « Hello »
o	Créer un objet Student, définir son âge à 15 ans, faites-lui dire
« Hello », « I’m going to class. » et afficher son âge
o	Créez un objet Teacher, 40 ans, demandez-lui de dire « Hello » puis commence l’explication.

c:> Lors du lancement dans le main :
![](file:///D:/MainTpRepo/10_JAVA/_EXERCICES/Exo_Cours_04-04-2023/img/3.png)
 
Exercice 2

Créez une classe « House », avec un attribut « surface », un constructeur qui définit sa valeur et une méthode « Display » pour afficher « Je suis une maison, ma surface est de XXX m2 » (XXX: la valeur de surface). Incluez aussi des getters et des setters pour la surface.
La classe « House » contiendra une porte (Door). Chaque porte aura un attribut
« color » (de type String), et une méthode « Display » qui affichera « Je suis une porte, ma couleur est bleu » (ou quelle que soit la couleur). Inclure un getter et un setter. Créez également la méthode « GetDoor » dans la classe « House ».
La classe « Apartment » est une sous-classe de la classe « House », avec une surface prédéfinie de 50m2.
Créez également une classe Person, avec un nom (de type String). Chaque personne aura une maison. La méthode « Display » pour une personne affichera son nom, les données de sa maison et les données de la porte de cette maison.


Dans la methode main dans la class App :
Créer un Apartment, une personne pour y vivre et pour afficher les données de la personne.

c:> Lors du lancement dans le main :
![](file:///D:/MainTpRepo/10_JAVA/_EXERCICES/Exo_Cours_04-04-2023/img/4.png)
 
TP - Employe - Class

Dans une société, un employé est décrit par les membres suivants : Attributs :
●	Nom ; Age ; salaire.

Constructeurs :
●	par défaut,
●	avec trois paramètres Méthodes :
●	Augmentation(…) ;
●	afficher() ;
●	calculeSalaire() ;

Un technicien est décrit en plus par l’attribut : grade et la méthode prime( ) et la redéfinition de la méthode calculeSalaire().

●	Si grade=1 alors Prime= 100
●	Si grade=2 alors Prime= 200
●	Si grade=3 alors Prime= 300 Travail à faire :
●	1- Ecrire la classe Employé.
●	2- Ecrire la classe Technicien.
●	3- Ecrire un programme qui saisie un employé puis un technicien et affiche leurs informations avant et après augmentation de leurs salaires.
 
TP Class Salarié Java



A faire : Créez un nouveau projet nommé « TpClasseSalarie » et suivez les instructions suivantes

![](file:///D:/MainTpRepo/10_JAVA/_EXERCICES/Exo_Cours_04-04-2023/img/5.png)


![](file:///D:/MainTpRepo/10_JAVA/_EXERCICES/Exo_Cours_04-04-2023/img/6.png)