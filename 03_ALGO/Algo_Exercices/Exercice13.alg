<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER nb3" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2defaut="" F2etat="inactif" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param arrondiAuto="vrai" maxBoucle="500000" epaisseurLigne="2" nbDecimales="8" totalBoucles="5000000" epaisseurPoint="2" totalAffichages="1000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#nb1" algoitem="nb1 EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nb3" algoitem="nb3 EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#nb3#0#pasliste" algoitem="nb3 PREND_LA_VALEUR 0"/>
        <item code="12#i#0#5" algoitem="POUR i ALLANT_DE 0 A 5">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="4#Saisir un chiffre#0" algoitem="AFFICHER &quot;Saisir un chiffre&quot;"/>
            <item code="2#nb1#pasliste" algoitem="LIRE nb1"/>
            <item code="6#nb1>nb3" algoitem="SI (nb1>nb3) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#nb3#nb1#pasliste" algoitem="nb3 PREND_LA_VALEUR nb1"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="4#le nombre plus grand est :#0" algoitem="AFFICHER &quot;le nombre plus grand est :&quot;"/>
        <item code="3#nb3#1#pasliste" algoitem="AFFICHER nb3"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
