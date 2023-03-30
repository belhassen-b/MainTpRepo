<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="LIRE n" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2lignes="" F2etat="inactif" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param maxBoucle="500000" arrondiAuto="vrai" epaisseurPoint="2" totalBoucles="5000000" totalAffichages="1000" epaisseurLigne="2" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES">
        <item code="201#tableau#i" algoitem="FONCTION tableau(i)">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION">
                <item code="1#LISTE#t" algoitem="t EST_DU_TYPE LISTE">
                    <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
                </item>
            </item>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
    </item>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#n" algoitem="n EST_DU_TYPE NOMBRE"/>
        <item code="1#CHAINE#y" algoitem="y EST_DU_TYPE CHAINE"/>
        <item code="1#CHAINE#z" algoitem="z EST_DU_TYPE CHAINE"/>
        <item code="1#CHAINE#x" algoitem="x EST_DU_TYPE CHAINE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#y#&quot;FIZZ&quot;#pasliste" algoitem="y PREND_LA_VALEUR &quot;FIZZ&quot;"/>
        <item code="5#z#&quot;BUZZ&quot;#pasliste" algoitem="z PREND_LA_VALEUR &quot;BUZZ&quot;"/>
        <item code="5#x#&quot;FIZZ BUZZ&quot;#pasliste" algoitem="x PREND_LA_VALEUR &quot;FIZZ BUZZ&quot;"/>
        <item code="4#Saisir un nombre#0" algoitem="AFFICHER &quot;Saisir un nombre&quot;"/>
        <item code="2#n#pasliste" algoitem="LIRE n"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
