## Exercice JAVA - Objet

![](file:///D:/MainTpRepo/10_JAVA/_TP/Tp-Collection_Vendredi_14-04-2023/img/1.png)

![](file:///D:/MainTpRepo/10_JAVA/_TP/Tp-Collection_Vendredi_14-04-2023/img/2.png)

Exercice 2.11 : on veut écrire un programme pour simuler le comportement des élus. Un programmeur a écrit la classe ci-dessous (avant de démissionner pour se présenter aux élections législatives).

class Personne{ String nom, prenom;
int compteBancaire; Il montant de son compte en euros Personne(String nom, String prenom){
this.nom = nom; this.prenom = prenom;
this.compteBancaire = O;
}
void addSous(int montant){
this.compteBancaire = this.compteBancaire+montant;
}
}

En réutilisant cette classe Personne, écrivez une classe qui représente les élus, qui sont des personnes avec un ensemble d'assistants (qui sont aussi des personnes bien sur). Un élu peut embaucher un assistant ou le licencier. Un élu peut aussi distribuer à ses assistants une dotation budgétaire : il répartit la somme qui lui est allouée de façon équitable entre ses assistants en ajoutant des sous sur les comptes bancaires des assistants.

a.	Écrivez une classe Elu qui représente les élus.

Dans la suite, on veut représenter différents types d'élus, mais qu'on veut pouvoir manipuler comme des élus "normaux", c'est-à-dire qu'un objet de type Elu n'aura toujours que les trois méthodes définies dans la classe Elu et permettant d'embaucher un assistant, de licencier un assistant et de verser une dotation.

b.	On veut représenter les élus mafieux, qui n'embauchent comme assistants que des membres de leur famille (c'est-à-dire des personnes qui ont le même nom qu'eux, pour simplifier). Mais ils répartissent la dotation budgétaire qui leur est allouée de façon équitable entre leurs assistants. Écrivez une classe qui représente les élus mafieux.

c.	On veut représenter les élus économes, qui répartissent la dotation budgétaire qui leur est allouée de la façon suivante : chaque assistant reçoit au plus le SMIC (1480 euros brut) et s'il reste des sous, ils ne sont pas dépensés. Écrivez une classe qui représente les élus économes.

d.	On veut représenter les élus escrocs, qui ont un compte en Suisse en plus de leur compte bancaire normal, qui n'embauchent pas forcément que les membres de leur famille, et qui répartissent la dotation budgétaire qui leur est allouée de la façon suivante : chaque assistant reçoit au plus le SMIC (1480 euros brut) et s'il reste des sous, ils sont versés sur le compte en Suisse de l'élu. Écrivez une classe ui représente les élus escrocs.
 
TP Transaction Bancaire – Class – Enum - Interface



Soit un programme qui va vous permettre de gérer un compte bancaire et notamment les transactions qui sont effectuées sur le compte. Une transaction est une opération de crédit ou débit d’un compte vers un autre compte.

Mettre en œuvre un programme de console qui répondra aux exigences suivantes :

•	Implémenter la classe Account avec les champs suivants :

o	id entier

o	Transaction[] transactions

•	Implémentez l'énumération StandardAccountOperations qui contient les énumérations suivantes :

o	MONEY_TRANSFER_SEND

o	MONEY_TRANSFER_RECEIVE

o	CANCEL_OPERATION

•	Implémentez la classe Transaction qui a les champs suivants (Elle peut être imbriquee soit interne, si vous le souhaitez ) :

o	Compte compteDe

o	Compte compteÀ

o	double argentMontant

o	StandardAccountOperations operation

•	Dans la classe Account, implémentez les méthodes suivantes :

o	public void sendMoneyToAccount(Account accountTo, double moneyAmount)
{
 
<écrivez votre code ici>
}

o	public void receiveMoney(Account accountFrom, double moneyAmount){
<écrivez votre code ici>
}
o	




o	public void removeMoney(double moneyAmount) {
<écrivez votre code ici>
}

o	public Transaction getTransactions() {
<écrivez votre code ici>
o	}

Faites attention que lorsque de l'argent est envoyé d'un compte à un autre

 une transaction MONEY_TRANSFER_SEND est créée dans un compte et la deuxième transaction MONEY_TRANSFER_RECEIVE est créée dans un autre compte.
 Toutes les méthodes nécéssaires devront être implémentés en utilisant des interfaces pour chacune des classes (Account et Transaction).
