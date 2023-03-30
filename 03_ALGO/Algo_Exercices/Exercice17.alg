<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="FIN_TANT_QUE"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2para="" F2lignes="" F2etat="inactif" F2defaut=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" maxBoucle="500000" totalAffichages="1000" nbDecimales="8" epaisseurLigne="2" totalBoucles="5000000" epaisseurPoint="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="noteBasse EST_DU_TYPE NOMBRE" code="1#NOMBRE#noteBasse"/>
        <item algoitem="noteHaute EST_DU_TYPE NOMBRE" code="1#NOMBRE#noteHaute"/>
        <item algoitem="moyenne EST_DU_TYPE NOMBRE" code="1#NOMBRE#moyenne"/>
        <item algoitem="noteSaisie EST_DU_TYPE NOMBRE" code="1#NOMBRE#noteSaisie"/>
        <item algoitem="nbreNote EST_DU_TYPE NOMBRE" code="1#NOMBRE#nbreNote"/>
        <item algoitem="sommeNote EST_DU_TYPE NOMBRE" code="1#NOMBRE#sommeNote"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="noteBasse PREND_LA_VALEUR 99999999" code="5#noteBasse#99999999#pasliste"/>
        <item algoitem="noteHaute PREND_LA_VALEUR -99999999" code="5#noteHaute#-99999999#pasliste"/>
        <item algoitem="AFFICHER &quot;Saisir une note :&quot;" code="4#Saisir une note :#0"/>
        <item algoitem="LIRE noteSaisie" code="2#noteSaisie#pasliste"/>
        <item algoitem="TANT_QUE (noteSaisie != 0) FAIRE" code="15#noteSaisie != 0">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="POUR nbreNote ALLANT_DE 1 A nbreNote" code="12#nbreNote#1#nbreNote">
                <item algoitem="DEBUT_POUR" code="13#debutpour"/>
                <item algoitem="AFFICHER &quot;Nombre de note saisie :&quot;" code="4#Nombre de note saisie :#0"/>
                <item algoitem="AFFICHER nbreNote" code="3#nbreNote#1#pasliste"/>
                <item algoitem="SI (noteSaisie>noteHaute) ALORS" code="6#noteSaisie>noteHaute">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="noteHaute PREND_LA_VALEUR noteSaisie" code="5#noteHaute#noteSaisie#pasliste"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                </item>
                <item algoitem="SI (noteSaisie &lt; noteBasse) ALORS" code="6#noteSaisie &lt; noteBasse">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="noteBasse PREND_LA_VALEUR noteSaisie" code="5#noteBasse#noteSaisie#pasliste"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                </item>
                <item algoitem="sommeNote PREND_LA_VALEUR sommeNote+noteSaisie" code="5#sommeNote#sommeNote+noteSaisie#pasliste"/>
                <item algoitem="moyenne PREND_LA_VALEUR sommeNote/(nbreNote-1)" code="5#moyenne#sommeNote/(nbreNote-1)#pasliste"/>
                <item algoitem="AFFICHER &quot;La note la plus basse est : &quot;" code="4#La note la plus basse est : #0"/>
                <item algoitem="AFFICHER noteBasse" code="3#noteBasse#1#pasliste"/>
                <item algoitem="AFFICHER &quot;note haute &quot;" code="4#note haute #0"/>
                <item algoitem="AFFICHER noteHaute" code="3#noteHaute#1#pasliste"/>
                <item algoitem="AFFICHER &quot;La moyenne est de : &quot;" code="4#La moyenne est de : #0"/>
                <item algoitem="AFFICHER moyenne" code="3#moyenne#1#pasliste"/>
                <item algoitem="FIN_POUR" code="14#finpour"/>
            </item>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
