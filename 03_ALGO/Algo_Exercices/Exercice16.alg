<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER moyenne"/>
    <extension extnom="inactif"/>
    <fonction fctetat="actif" fctcode=""/>
    <F2 F2etat="inactif" F2defaut="" F2lignes="" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurLigne="2" maxBoucle="500000" nbDecimales="8" arrondiAuto="vrai" totalBoucles="5000000" totalAffichages="1000" epaisseurPoint="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#noteBasse" algoitem="noteBasse EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#noteHaute" algoitem="noteHaute EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#moyenne" algoitem="moyenne EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#noteSaisie" algoitem="noteSaisie EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nbreNote" algoitem="nbreNote EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#sommeNote" algoitem="sommeNote EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#temp" algoitem="temp EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#noteBasse#99999999#pasliste" algoitem="noteBasse PREND_LA_VALEUR 99999999"/>
        <item code="5#noteHaute#-99999999#pasliste" algoitem="noteHaute PREND_LA_VALEUR -99999999"/>
        <item code="12#nbreNote#1#3" algoitem="POUR nbreNote ALLANT_DE 1 A 3">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="4#Saisir une note :#0" algoitem="AFFICHER &quot;Saisir une note :&quot;"/>
            <item code="2#noteSaisie#pasliste" algoitem="LIRE noteSaisie"/>
            <item code="4#Nombre de note saisie :#0" algoitem="AFFICHER &quot;Nombre de note saisie :&quot;"/>
            <item code="3#nbreNote#1#pasliste" algoitem="AFFICHER nbreNote"/>
            <item code="6#noteSaisie>noteHaute" algoitem="SI (noteSaisie>noteHaute) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#noteHaute#noteSaisie#pasliste" algoitem="noteHaute PREND_LA_VALEUR noteSaisie"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="6#noteSaisie &lt; noteBasse" algoitem="SI (noteSaisie &lt; noteBasse) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#noteBasse#noteSaisie#pasliste" algoitem="noteBasse PREND_LA_VALEUR noteSaisie"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="5#sommeNote#sommeNote+noteSaisie#pasliste" algoitem="sommeNote PREND_LA_VALEUR sommeNote+noteSaisie"/>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="5#moyenne#sommeNote/(nbreNote-1)#pasliste" algoitem="moyenne PREND_LA_VALEUR sommeNote/(nbreNote-1)"/>
        <item code="4#La note la plus basse est : #0" algoitem="AFFICHER &quot;La note la plus basse est : &quot;"/>
        <item code="3#noteBasse#1#pasliste" algoitem="AFFICHER noteBasse"/>
        <item code="4#note haute #0" algoitem="AFFICHER &quot;note haute &quot;"/>
        <item code="3#noteHaute#1#pasliste" algoitem="AFFICHER noteHaute"/>
        <item code="4#La moyenne est de : #0" algoitem="AFFICHER &quot;La moyenne est de : &quot;"/>
        <item code="3#moyenne#1#pasliste" algoitem="AFFICHER moyenne"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
