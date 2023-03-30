<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="NomComplet PREND_LA_VALEUR Nom  + &quot; &quot; + Prenom"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2etat="inactif" F2lignes="" F2para="" F2defaut=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param totalBoucles="5000000" totalAffichages="1000" epaisseurPoint="2" arrondiAuto="vrai" nbDecimales="8" maxBoucle="500000" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="Nom EST_DU_TYPE CHAINE" code="1#CHAINE#Nom"/>
        <item algoitem="Prenom EST_DU_TYPE CHAINE" code="1#CHAINE#Prenom"/>
        <item algoitem="NomComplet EST_DU_TYPE CHAINE" code="1#CHAINE#NomComplet"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Saisir votre nom&quot;" code="4#Saisir votre nom#0"/>
        <item algoitem="LIRE Nom" code="2#Nom#pasliste"/>
        <item algoitem="AFFICHER &quot;Saisir votre prénom&quot;" code="4#Saisir votre prénom#0"/>
        <item algoitem="LIRE Prenom" code="2#Prenom#pasliste"/>
        <item algoitem="NomComplet PREND_LA_VALEUR Nom  + &quot; &quot; + Prenom" code="5#NomComplet#Nom  + &quot; &quot; + Prenom#pasliste"/>
        <item algoitem="AFFICHER &quot;Votre nom complet est : &quot;" code="4#Votre nom complet est : #0"/>
        <item algoitem="AFFICHER NomComplet" code="3#NomComplet#1#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
