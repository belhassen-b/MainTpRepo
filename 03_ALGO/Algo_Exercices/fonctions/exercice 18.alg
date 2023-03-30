<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FONCTION grandNombre(A,B)" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2etat="inactif" F2para="" F2defaut="" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param totalBoucles="5000000" arrondiAuto="vrai" totalAffichages="1000" nbDecimales="8" epaisseurPoint="2" maxBoucle="500000" epaisseurLigne="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES">
        <item code="201#grandNombre#A,B" algoitem="FONCTION grandNombre(A,B)">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION"/>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="6#A>B" algoitem="SI (A>B) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="205#A" algoitem="RENVOYER A"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="205#B" algoitem="RENVOYER B"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
    </item>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#nombre1" algoitem="nombre1 EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nombre2" algoitem="nombre2 EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Saisir nombre 1#0" algoitem="AFFICHER &quot;Saisir nombre 1&quot;"/>
        <item code="2#nombre1#pasliste" algoitem="LIRE nombre1"/>
        <item code="4#Saisir nombre 2#0" algoitem="AFFICHER &quot;Saisir nombre 2&quot;"/>
        <item code="2#nombre2#pasliste" algoitem="LIRE nombre2"/>
        <item code="20#grandNombre(nombre1, nombre2)#0" algoitem="AFFICHERCALCUL grandNombre(nombre1, nombre2)"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
