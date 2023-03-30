<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="I PREND_LA_VALEUR 5" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2etat="inactif" F2defaut="" F2lignes="" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param epaisseurLigne="2" totalBoucles="5000000" totalAffichages="1000" arrondiAuto="vrai" nbDecimales="8" maxBoucle="500000" epaisseurPoint="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="I EST_DU_TYPE NOMBRE" code="1#NOMBRE#I"/>
        <item algoitem="CHOIX_MENU EST_DU_TYPE NOMBRE" code="1#NOMBRE#CHOIX_MENU"/>
        <item algoitem="TAB EST_DU_TYPE LISTE" code="1#LISTE#TAB"/>
        <item algoitem="cpt EST_DU_TYPE NOMBRE" code="1#NOMBRE#cpt"/>
        <item algoitem="attempt EST_DU_TYPE NOMBRE" code="1#NOMBRE#attempt"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="cpt PREND_LA_VALEUR 0" code="5#cpt#0#pasliste"/>
        <item algoitem="CHOIX_MENU PREND_LA_VALEUR -1" code="5#CHOIX_MENU#-1#pasliste"/>
        <item algoitem="TANT_QUE (CHOIX_MENU != 0) FAIRE" code="15#CHOIX_MENU != 0">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="AFFICHER &quot;\n=== MENU ===&quot;" code="4#\n=== MENU ===#1"/>
            <item algoitem="AFFICHER &quot;\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===&quot;" code="4#\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===#1"/>
            <item algoitem="AFFICHER &quot;1. Niveau 1 (3 cadeaux)&quot;" code="4#1. Niveau 1 (3 cadeaux)#1"/>
            <item algoitem="AFFICHER &quot;2. Niveau 2 (5 cadeaux)&quot;" code="4#2. Niveau 2 (5 cadeaux)#1"/>
            <item algoitem="AFFICHER &quot;3. Niveau 2 (7 cadeaux)&quot;" code="4#3. Niveau 2 (7 cadeaux)#1"/>
            <item algoitem="AFFICHER &quot;0. Quitter le programme&quot;" code="4#0. Quitter le programme#1"/>
            <item algoitem="AFFICHER &quot;Votre choix : &quot;" code="4#Votre choix : #0"/>
            <item algoitem="LIRE CHOIX_MENU" code="2#CHOIX_MENU#pasliste"/>
            <item algoitem="I PREND_LA_VALEUR C&#x9;HOIX_MENU" code="5#I#C&#x9;HOIX_MENU#pasliste"/>
            <item algoitem="SI (CHOIX_MENU == 1) ALORS" code="6#CHOIX_MENU == 1">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="AFFICHER &quot;3 CADEAUX &quot;" code="4#3 CADEAUX #0"/>
                <item algoitem="I PREND_LA_VALEUR 3" code="5#I#3#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
                <item algoitem="SINON" code="9#sinon">
                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                    <item algoitem="SI (CHOIX_MENU == 2) ALORS" code="6#CHOIX_MENU == 2">
                        <item algoitem="DEBUT_SI" code="7#debutsi"/>
                        <item algoitem="AFFICHER &quot;5 CADEAUX &quot;" code="4#5 CADEAUX #0"/>
                        <item algoitem="I PREND_LA_VALEUR 5" code="5#I#5#pasliste"/>
                        <item algoitem="FIN_SI" code="8#finsi"/>
                    </item>
                    <item algoitem="SI (CHOIX_MENU == 3) ALORS" code="6#CHOIX_MENU == 3">
                        <item algoitem="DEBUT_SI" code="7#debutsi"/>
                        <item algoitem="AFFICHER &quot;7 CADEAUX &quot;" code="4#7 CADEAUX #0"/>
                        <item algoitem="I PREND_LA_VALEUR 7" code="5#I#7#pasliste"/>
                        <item algoitem="FIN_SI" code="8#finsi"/>
                    </item>
                    <item algoitem="FIN_SINON" code="11#finsinon"/>
                </item>
            </item>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="TANT_QUE (cpt&lt;=n ET essai[cpt]!=attempt) FAIRE" code="15#cpt&lt;=n ET essai[cpt]!=attempt">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="cpt PREND_LA_VALEUR cpt+1" code="5#cpt#cpt+1#pasliste"/>
            <item algoitem="I PREND_LA_VALEUR I-1" code="5#I#I-1#pasliste"/>
            <item algoitem="LIRE TAB[cpt]" code="2#TAB#cpt"/>
            <item algoitem="SI (TAB[cpt]==attempt) ALORS" code="6#TAB[cpt]==attempt">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="SI (CHOIX_MENU == 1) ALORS" code="6#CHOIX_MENU == 1">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="attempt PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,3)" code="5#attempt#ALGOBOX_ALEA_ENT(1,3)#pasliste"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                    <item algoitem="SINON" code="9#sinon">
                        <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                        <item algoitem="SI (CHOIX_MENU == 2) ALORS" code="6#CHOIX_MENU == 2">
                            <item algoitem="DEBUT_SI" code="7#debutsi"/>
                            <item algoitem="attempt PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,5)" code="5#attempt#ALGOBOX_ALEA_ENT(1,5)#pasliste"/>
                            <item algoitem="FIN_SI" code="8#finsi"/>
                        </item>
                        <item algoitem="SI (CHOIX_MENU == 3) ALORS" code="6#CHOIX_MENU == 3">
                            <item algoitem="DEBUT_SI" code="7#debutsi"/>
                            <item algoitem="attempt PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,7)" code="5#attempt#ALGOBOX_ALEA_ENT(1,7)#pasliste"/>
                            <item algoitem="FIN_SI" code="8#finsi"/>
                        </item>
                        <item algoitem="FIN_SINON" code="11#finsinon"/>
                    </item>
                </item>
            </item>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
