<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="montantApres PREND_LA_VALEUR capital*(1+taux/100)^annee" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2etat="inactif" F2lignes="" F2defaut="" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurLigne="2" totalBoucles="5000000" nbDecimales="8" maxBoucle="500000" totalAffichages="1000" epaisseurPoint="2" arrondiAuto="vrai"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="capital EST_DU_TYPE NOMBRE" code="1#NOMBRE#capital"/>
        <item algoitem="taux EST_DU_TYPE NOMBRE" code="1#NOMBRE#taux"/>
        <item algoitem="annee EST_DU_TYPE NOMBRE" code="1#NOMBRE#annee"/>
        <item algoitem="montantApres EST_DU_TYPE NOMBRE" code="1#NOMBRE#montantApres"/>
        <item algoitem="tauxF EST_DU_TYPE NOMBRE" code="1#NOMBRE#tauxF"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Saississez le montant déposé :&quot;" code="4#Saississez le montant déposé :#0"/>
        <item algoitem="LIRE capital" code="2#capital#pasliste"/>
        <item algoitem="AFFICHER &quot;Nombre d'années dépôt :&quot;" code="4#Nombre d'années dépôt :#0"/>
        <item algoitem="LIRE annee" code="2#annee#pasliste"/>
        <item algoitem="AFFICHER &quot;Taux : &quot;" code="4#Taux : #0"/>
        <item algoitem="LIRE taux" code="2#taux#pasliste"/>
        <item algoitem="montantApres PREND_LA_VALEUR capital*(1+taux/100)^annee" code="5#montantApres#capital*(1+taux/100)^annee#pasliste"/>
        <item algoitem="AFFICHER montantApres" code="3#montantApres#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
