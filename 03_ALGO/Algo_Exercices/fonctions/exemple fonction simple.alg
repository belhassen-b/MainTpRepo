<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHERCALCUL addition(1,10,100,1000)" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2etat="inactif" F2para="" F2defaut="" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param totalBoucles="5000000" arrondiAuto="vrai" totalAffichages="1000" nbDecimales="8" epaisseurPoint="2" maxBoucle="500000" epaisseurLigne="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES">
        <item code="201#addition#A,B,C,D" algoitem="FONCTION addition(A,B,C,D)">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION"/>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="205#A+B+C+D" algoitem="RENVOYER A+B+C+D"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
        <item code="201#direBonjour#prenom, nom" algoitem="FONCTION direBonjour(prenom, nom)">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION">
                <item code="1#CHAINE#prez" algoitem="prez EST_DU_TYPE CHAINE"/>
            </item>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="4#dizaine de ligne#1" algoitem="AFFICHER &quot;dizaine de ligne&quot;"/>
            <item code="5#prez#&quot;bonjour&quot; + prenom + &quot; &quot; +nom#pasliste" algoitem="prez PREND_LA_VALEUR &quot;bonjour&quot; + prenom + &quot; &quot; +nom"/>
            <item code="4#dizaine de ligne#1" algoitem="AFFICHER &quot;dizaine de ligne&quot;"/>
            <item code="205#prez" algoitem="RENVOYER prez"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
    </item>
    <item code="100#declarationsvariables" algoitem="VARIABLES"/>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="20#addition(1,10,100,1000)#0" algoitem="AFFICHERCALCUL addition(1,10,100,1000)"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
