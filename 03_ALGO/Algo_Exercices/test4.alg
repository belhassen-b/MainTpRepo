<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="FIN_SINON"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2etat="inactif" F2lignes="" F2para="" F2defaut=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param totalAffichages="1000" maxBoucle="500000" totalBoucles="5000000" epaisseurPoint="2" arrondiAuto="vrai" nbDecimales="8" epaisseurLigne="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#LISTE#tableau" algoitem="tableau EST_DU_TYPE LISTE"/>
        <item code="1#NOMBRE#CHOIX_MENU" algoitem="CHOIX_MENU EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nbreAlea" algoitem="nbreAlea EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#maReponse" algoitem="maReponse EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#maxTent" algoitem="maxTent EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#cpt" algoitem="cpt EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Chercher le grelot #0" algoitem="AFFICHER &quot;Chercher le grelot &quot;"/>
        <item code="4#\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===#1" algoitem="AFFICHER &quot;\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===&quot;"/>
        <item code="4#1. Niveau 1 (3 cadeaux)#1" algoitem="AFFICHER &quot;1. Niveau 1 (3 cadeaux)&quot;"/>
        <item code="4#2. Niveau 2 (5 cadeaux)#1" algoitem="AFFICHER &quot;2. Niveau 2 (5 cadeaux)&quot;"/>
        <item code="4#3. Niveau 2 (7 cadeaux)#1" algoitem="AFFICHER &quot;3. Niveau 2 (7 cadeaux)&quot;"/>
        <item code="4#0. Quitter le programme#1" algoitem="AFFICHER &quot;0. Quitter le programme&quot;"/>
        <item code="4#Votre choix : #0" algoitem="AFFICHER &quot;Votre choix : &quot;"/>
        <item code="2#CHOIX_MENU#pasliste" algoitem="LIRE CHOIX_MENU"/>
        <item code="3#CHOIX_MENU#0#pasliste" algoitem="AFFICHER CHOIX_MENU"/>
        <item code="5#i#1+2*CHOIX_MENU#pasliste" algoitem="i PREND_LA_VALEUR 1+2*CHOIX_MENU"/>
        <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
        <item code="5#nbreAlea#ALGOBOX_ALEA_ENT(1,i)#pasliste" algoitem="nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)"/>
        <item code="6#CHOIX_MENU == 0" algoitem="SI (CHOIX_MENU == 0) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="4#Jeu terminé#1" algoitem="AFFICHER &quot;Jeu terminé&quot;"/>
            <item code="8#finsi" algoitem="FIN_SI"/>
            <item code="9#sinon" algoitem="SINON">
                <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                <item code="6#CHOIX_MENU &lt;0 OU CHOIX_MENU >3 " algoitem="SI (CHOIX_MENU &lt;0 OU CHOIX_MENU >3 ) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#Faire un choix valide#0" algoitem="AFFICHER &quot;Faire un choix valide&quot;"/>
                    <item code="2#CHOIX_MENU#pasliste" algoitem="LIRE CHOIX_MENU"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                </item>
                <item code="6#CHOIX_MENU == 1 OU CHOIX_MENU == 2 OU CHOIX_MENU == 3 " algoitem="SI (CHOIX_MENU == 1 OU CHOIX_MENU == 2 OU CHOIX_MENU == 3 ) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#Le grelot est parmi ces :#0" algoitem="AFFICHER &quot;Le grelot est parmi ces :&quot;"/>
                    <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
                    <item code="4# Cadeaux , trouve le bon :#0" algoitem="AFFICHER &quot; Cadeaux , trouve le bon :&quot;"/>
                    <item code="2#CHOIX_MENU#pasliste" algoitem="LIRE CHOIX_MENU"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                </item>
                <item code="11#finsinon" algoitem="FIN_SINON"/>
            </item>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
