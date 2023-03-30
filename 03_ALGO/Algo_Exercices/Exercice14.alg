<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER sommeEntiers" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2defaut="" F2etat="inactif" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param arrondiAuto="vrai" maxBoucle="500000" epaisseurLigne="2" nbDecimales="8" totalBoucles="5000000" epaisseurPoint="2" totalAffichages="1000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#nbre" algoitem="nbre EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#sommeEntiers" algoitem="sommeEntiers EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Saisir un nombre#0" algoitem="AFFICHER &quot;Saisir un nombre&quot;"/>
        <item code="2#nbre#pasliste" algoitem="LIRE nbre"/>
        <item code="12#i#0#nbre" algoitem="POUR i ALLANT_DE 0 A nbre">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="5#sommeEntiers#sommeEntiers+i#pasliste" algoitem="sommeEntiers PREND_LA_VALEUR sommeEntiers+i"/>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="4#La somme des entiers est de : #0" algoitem="AFFICHER &quot;La somme des entiers est de : &quot;"/>
        <item code="3#sommeEntiers#1#pasliste" algoitem="AFFICHER sommeEntiers"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
