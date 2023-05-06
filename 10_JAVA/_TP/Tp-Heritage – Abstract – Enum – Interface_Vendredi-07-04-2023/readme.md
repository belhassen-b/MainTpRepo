Exercice 1
Mettre en œuvre un programme de console qui répondra aux exigences suivantes :
•	Le programme démarre et demande à l'utilisateur d'entrer des nombres entiers séparés par un espace.
•	Le programme crée un objet tableau avec les nombres entrés.
•	Le programme appelle une méthode spécifique qui prend int[] comme paramètre et renvoie la valeur max dans ce tableau.

La méthode devrait ressembler à ceci :

public static int findMaxIntInArray(int[] intArray) {

<écrivez votre code ici>

}

 Le programme imprime la valeur maximale du tableau sur la console.

Exercice 2
Mettre en œuvre un programme de console qui répondra aux exigences suivantes :

•	Le programme démarre et demande à l'utilisateur de saisir la hauteur du rectangle
•	Une fois que l'utilisateur a entré les hauteurs du rectangle, le programme demande d'entrer la largeur du rectangle.
•	
Le programme appelle une méthode spécifique qui prend deux paramètres de type int qui imprime rectangle sur la console :

******
*	*
******

La méthode devrait ressembler à ceci :

public static void drawRectangle(int hauteur, int largeur) {

<écrivez votre code ici>

}
 Dans l'exemple ci-dessus, la hauteur du rectangle est de 3, la largeur du rectangle est de 6
 
N.B. : le rectangle est vide à l'intérieur

Exercice 3

Mettre en œuvre un programme de console qui répondra aux exigences suivantes :

•	Le programme démarre et demande à l'utilisateur de saisir du texte.
•	Le programme appelle une fonction spécifique qui prend un paramètre de type String et renvoie le nombre de mots dans le texte.

La méthode devrait ressembler à ceci :

public static int getWordsAmount (chaîne de texte) {

<écrivez votre code ici>

}

Le programme imprime le nombre de mots sur la console.

Exercice 4
Mettre en œuvre un programme de console qui répondra aux exigences suivantes :

•	Le programme démarre et demande à l'utilisateur d'entrer des mots aléatoires séparés par un espace
•	Le programme demande à l'utilisateur d'entrer la longueur minimale de la chaîne pour filtrer les mots qui ont été saisis
•	Le programme crée un objet tableau à partir des mots saisis
•	Le programme appelle une méthode spécifique qui prend String[] comme paramètre et renvoie un tableau de chaînes contenant des mots dont la longueur est supérieure ou égale à la valeur spécifiée par l'utilisateur

La méthode devrait ressembler à ceci :

public static String[] filterWordsByLength(int minLength, String[] mots) {

<écrivez votre code ici>
}

 Le programme imprime le tableau filtré sur la sortie de la console.
 
Exercice 5

Mettre en œuvre un programme de console qui répondra aux exigences suivantes :

•	Le programme démarre et demande à l'utilisateur d'entrer des mots aléatoires séparés par un espace
•	Le programme demande à l'utilisateur d'entrer la longueur minimale de la chaîne pour filtrer les mots qui ont été saisis
•	Le programme crée un objet tableau à partir des mots saisis
•	Le programme appelle une méthode spécifique qui prend String[] comme paramètre et renvoie un tableau de chaînes contenant des mots dont la longueur est supérieure ou égale à la valeur spécifiée par l'utilisateur

La méthode devrait ressembler à ceci :

public static String[] filterWordsByLength(int minLength, String[] mots) {

<écrivez votre code ici>

}


 Le programme imprime le tableau filtré sur la sortie de la console.

Exercice 6
Implémentez un programme de console qui répondra aux exigences suivantes :

a.	Le programme démarre et demande à l'utilisateur d'entrer deux chiffres séparés par un espace
b.	Le programme appelle une méthode spécifique pour trouver le plus grand diviseur commun.

La méthode devrait ressembler à ceci :

public static int gcdRecursive(int firstNumber, int secondNumber) {
<écrivez votre code ici>
}


Le programme imprime le plus grand diviseur commun sur la console
 
TP Class – Heritage – Abstract – Enum – Interface



Exercice 1 :
Créez une classe de compte bancaire qui a les propriétés suivantes : numéro de compte, solde, nom du titulaire du compte. La classe doit avoir des méthodes pour déposer et retirer de l'argent, ainsi que pour afficher le solde actuel. Créez ensuite une classe de test pour tester ces méthodes.

Exercice 2 :
Créez une interface pour un véhicule qui a les méthodes suivantes : accélérer, ralentir, tourner à gauche et tourner à droite. Créez ensuite deux classes qui implémentent cette interface : une pour une voiture et une pour une moto. Dans chaque classe, implémentez les méthodes de l'interface de manière appropriée pour chaque type de véhicule.

Exercice 3 :
Créez une énumération pour les couleurs primaires (rouge, jaune et bleu). Créez ensuite une classe de test qui utilise cette énumération pour mélanger ces couleurs et afficher le résultat.

Exercice 4 :
Créez une classe abstraite pour une forme qui a une méthode abstraite pour calculer l'aire. Créez ensuite des classes qui étendent cette classe abstraite pour représenter différentes formes (cercle, carré, triangle, etc.). Dans chaque classe, implémentez la méthode pour calculer l'aire de cette forme.

Exercice 5 :
Créez une interface pour un joueur de jeu qui a les méthodes suivantes : jouer, gagner et perdre. Créez ensuite deux classes qui implémentent cette interface : une pour un joueur humain et une pour un joueur informatique. Dans chaque classe, implémentez les méthodes de l'interface de manière appropriée pour chaque type de joueur.
