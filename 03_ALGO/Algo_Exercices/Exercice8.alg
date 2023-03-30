<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER &quot;Le triangle n'est ni isocèle en A, ni isocèle en B, ni isocèle en C&quot;"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2para="" F2etat="inactif" F2defaut="" F2lignes=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param nbDecimales="8" maxBoucle="500000" epaisseurLigne="2" epaisseurPoint="2" arrondiAuto="vrai" totalAffichages="1000" totalBoucles="5000000"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="lngAB EST_DU_TYPE NOMBRE" code="1#NOMBRE#lngAB"/>
        <item algoitem="lngBC EST_DU_TYPE NOMBRE" code="1#NOMBRE#lngBC"/>
        <item algoitem="lngCA EST_DU_TYPE NOMBRE" code="1#NOMBRE#lngCA"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Saisir la longueur AB&quot;" code="4#Saisir la longueur AB#0"/>
        <item algoitem="LIRE lngAB" code="2#lngAB#pasliste"/>
        <item algoitem="AFFICHER &quot;Saisir la longueur BC&quot;" code="4#Saisir la longueur BC#0"/>
        <item algoitem="LIRE lngBC" code="2#lngBC#pasliste"/>
        <item algoitem="AFFICHER &quot;Saisir la longueur AC&quot;" code="4#Saisir la longueur AC#0"/>
        <item algoitem="LIRE lngCA" code="2#lngCA#pasliste"/>
        <item algoitem="SI (lngAB*lngBC==lngCA*lngCA) ALORS" code="6#lngAB*lngBC==lngCA*lngCA">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="AFFICHER &quot;Le triangle est equilatéral!&quot;" code="4#Le triangle est equilatéral!#0"/>
            <item algoitem="FIN_SI" code="8#finsi"/>
            <item algoitem="SINON" code="9#sinon">
                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                <item algoitem="SI (lngAB/lngBC==1) ALORS" code="6#lngAB/lngBC==1">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="AFFICHER &quot;Le triangle est isocèle en B mais n'est pas équilatéral !&quot;" code="4#Le triangle est isocèle en B mais n'est pas équilatéral !#0"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                    <item algoitem="SINON" code="9#sinon">
                        <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                        <item algoitem="SI (lngBC/lngCA==1) ALORS" code="6#lngBC/lngCA==1">
                            <item algoitem="DEBUT_SI" code="7#debutsi"/>
                            <item algoitem="AFFICHER &quot;Le triangle est isocèle en C mais n'est pas équilatéral !&quot;" code="4#Le triangle est isocèle en C mais n'est pas équilatéral !#0"/>
                            <item algoitem="FIN_SI" code="8#finsi"/>
                            <item algoitem="SINON" code="9#sinon">
                                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                                <item algoitem="SI (lngAB/lngCA==1) ALORS" code="6#lngAB/lngCA==1">
                                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                                    <item algoitem="AFFICHER &quot;Le triangle est isocèle en A mais n'est pas équilatéral !&quot;" code="4#Le triangle est isocèle en A mais n'est pas équilatéral !#0"/>
                                    <item algoitem="FIN_SI" code="8#finsi"/>
                                    <item algoitem="SINON" code="9#sinon">
                                        <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                                        <item algoitem="AFFICHER &quot;Le triangle n'est ni isocèle en A, ni isocèle en B, ni isocèle en C&quot;" code="4#Le triangle n'est ni isocèle en A, ni isocèle en B, ni isocèle en C#0"/>
                                        <item algoitem="FIN_SINON" code="11#finsinon"/>
                                    </item>
                                </item>
                                <item algoitem="FIN_SINON" code="11#finsinon"/>
                            </item>
                        </item>
                        <item algoitem="FIN_SINON" code="11#finsinon"/>
                    </item>
                </item>
                <item algoitem="FIN_SINON" code="11#finsinon"/>
            </item>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
