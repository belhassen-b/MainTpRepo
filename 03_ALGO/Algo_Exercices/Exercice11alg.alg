<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="annee PREND_LA_VALEUR annee-1"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2defaut="" F2para="" F2etat="inactif" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param totalAffichages="1000" epaisseurLigne="2" nbDecimales="8" epaisseurPoint="2" maxBoucle="500000" arrondiAuto="vrai" totalBoucles="5000000"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="c EST_DU_TYPE NOMBRE" code="1#NOMBRE#c"/>
        <item algoitem="t EST_DU_TYPE NOMBRE" code="1#NOMBRE#t"/>
        <item algoitem="annee EST_DU_TYPE NOMBRE" code="1#NOMBRE#annee"/>
        <item algoitem="double EST_DU_TYPE NOMBRE" code="1#NOMBRE#double"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Saisir le capital investi :&quot;" code="4#Saisir le capital investi :#0"/>
        <item algoitem="LIRE c" code="2#c#pasliste"/>
        <item algoitem="AFFICHER &quot;Saisir le taux souhaité :&quot;" code="4#Saisir le taux souhaité :#0"/>
        <item algoitem="LIRE t" code="2#t#pasliste"/>
        <item algoitem="annee PREND_LA_VALEUR 0" code="5#annee#0#pasliste"/>
        <item algoitem="TANT_QUE (double&lt;c*2) FAIRE" code="15#double&lt;c*2">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="double PREND_LA_VALEUR round(c *  pow(1+t/100,annee))" code="5#double#round(c *  pow(1+t/100,annee))#pasliste"/>
            <item algoitem="annee PREND_LA_VALEUR annee+1" code="5#annee#annee+1#pasliste"/>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="AFFICHER &quot;Le nombre d'année est de :&quot;" code="4#Le nombre d'année est de :#0"/>
        <item algoitem="annee PREND_LA_VALEUR annee-1" code="5#annee#annee-1#pasliste"/>
        <item algoitem="AFFICHER annee" code="3#annee#1#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
