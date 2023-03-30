<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER &quot;Merci&quot;" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2defaut="" F2para="" F2etat="inactif" F2lignes=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param nbDecimales="8" arrondiAuto="vrai" maxBoucle="500000" totalAffichages="1000" epaisseurPoint="2" totalBoucles="5000000" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="saisie EST_DU_TYPE NOMBRE" code="1#NOMBRE#saisie"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Saisir un nombre entre 1 et 3:&quot;" code="4#Saisir un nombre entre 1 et 3:#0"/>
        <item algoitem="LIRE saisie" code="2#saisie#pasliste"/>
        <item algoitem="TANT_QUE (saisie&lt;1 OU saisie>3) FAIRE" code="15#saisie&lt;1 OU saisie>3">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="AFFICHER &quot;merci de saisir nbre entre 1 et 3&quot;" code="4#merci de saisir nbre entre 1 et 3#0"/>
            <item algoitem="LIRE saisie" code="2#saisie#pasliste"/>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="AFFICHER &quot;Merci&quot;" code="4#Merci#1"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
