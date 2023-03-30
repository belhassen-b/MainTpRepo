<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="prix2 PREND_LA_VALEUR 0.4"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2etat="inactif" F2defaut="" F2para="" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param arrondiAuto="vrai" maxBoucle="500000" epaisseurLigne="2" nbDecimales="8" epaisseurPoint="2" totalBoucles="5000000" totalAffichages="1000"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="nPhoto EST_DU_TYPE NOMBRE" code="1#NOMBRE#nPhoto"/>
        <item algoitem="prix1 EST_DU_TYPE NOMBRE" code="1#NOMBRE#prix1"/>
        <item algoitem="prix2 EST_DU_TYPE NOMBRE" code="1#NOMBRE#prix2"/>
        <item algoitem="prix3 EST_DU_TYPE NOMBRE" code="1#NOMBRE#prix3"/>
        <item algoitem="prixTTC EST_DU_TYPE NOMBRE" code="1#NOMBRE#prixTTC"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="prix1 PREND_LA_VALEUR 0.5" code="5#prix1#0.5#pasliste"/>
        <item algoitem="prix2 PREND_LA_VALEUR 0.4" code="5#prix2#0.4#pasliste"/>
        <item algoitem="prix3 PREND_LA_VALEUR 0.3" code="5#prix3#0.3#pasliste"/>
        <item algoitem="AFFICHER &quot;Saisir le nombre de copie : &quot;" code="4#Saisir le nombre de copie : #0"/>
        <item algoitem="LIRE nPhoto" code="2#nPhoto#pasliste"/>
        <item algoitem="SI (nPhoto>=20) ALORS" code="6#nPhoto>=20">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="prixTTC PREND_LA_VALEUR nPhoto*prix3" code="5#prixTTC#nPhoto*prix3#pasliste"/>
            <item algoitem="AFFICHER &quot;le prix est de : &quot;" code="4#le prix est de : #0"/>
            <item algoitem="AFFICHER prixTTC" code="3#prixTTC#0#pasliste"/>
            <item algoitem="FIN_SI" code="8#finsi"/>
            <item algoitem="SINON" code="9#sinon">
                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                <item algoitem="SI (nPhoto&lt;10) ALORS" code="6#nPhoto&lt;10">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="prixTTC PREND_LA_VALEUR nPhoto*prix1" code="5#prixTTC#nPhoto*prix1#pasliste"/>
                    <item algoitem="AFFICHER &quot;Le prix est de : &quot;" code="4#Le prix est de : #0"/>
                    <item algoitem="AFFICHER prixTTC" code="3#prixTTC#0#pasliste"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                </item>
                <item algoitem="FIN_SINON" code="11#finsinon"/>
            </item>
        </item>
        <item algoitem="SI (nPhoto >=10 ET nPhoto &lt;= 20) ALORS" code="6#nPhoto >=10 ET nPhoto &lt;= 20">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="prixTTC PREND_LA_VALEUR nPhoto*prix2" code="5#prixTTC#nPhoto*prix2#pasliste"/>
            <item algoitem="AFFICHER &quot;Le prix est de : &quot;" code="4#Le prix est de : #1"/>
            <item algoitem="AFFICHER prixTTC" code="3#prixTTC#0#pasliste"/>
            <item algoitem="FIN_SI" code="8#finsi"/>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
