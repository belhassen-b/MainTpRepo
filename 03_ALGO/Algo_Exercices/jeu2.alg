<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER best"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2defaut="" F2lignes="" F2etat="inactif" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" epaisseurPoint="2" maxBoucle="500000" totalAffichages="1000" epaisseurLigne="2" nbDecimales="8" totalBoucles="5000000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#LISTE#essai" algoitem="essai EST_DU_TYPE LISTE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#n" algoitem="n EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#CHOIX_MENU" algoitem="CHOIX_MENU EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#x" algoitem="x EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#cpt" algoitem="cpt EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#best" algoitem="best EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#cpt#0#pasliste" algoitem="cpt PREND_LA_VALEUR 0"/>
        <item code="5#CHOIX_MENU#-1#pasliste" algoitem="CHOIX_MENU PREND_LA_VALEUR -1"/>
        <item code="4#Devinez un nombre secret entre 1 et 100 :#0" algoitem="AFFICHER &quot;Devinez un nombre secret entre 1 et 100 :&quot;"/>
        <item code="15#CHOIX_MENU != 0" algoitem="TANT_QUE (CHOIX_MENU != 0) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="4#\n=== MENU ===#1" algoitem="AFFICHER &quot;\n=== MENU ===&quot;"/>
            <item code="4#\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===#1" algoitem="AFFICHER &quot;\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===&quot;"/>
            <item code="4#1. Niveau 1 (3 cadeaux)#1" algoitem="AFFICHER &quot;1. Niveau 1 (3 cadeaux)&quot;"/>
            <item code="4#2. Niveau 2 (5 cadeaux)#1" algoitem="AFFICHER &quot;2. Niveau 2 (5 cadeaux)&quot;"/>
            <item code="4#3. Niveau 2 (7 cadeaux)#1" algoitem="AFFICHER &quot;3. Niveau 2 (7 cadeaux)&quot;"/>
            <item code="4#0. Quitter le programme#1" algoitem="AFFICHER &quot;0. Quitter le programme&quot;"/>
            <item code="4#Votre choix : #0" algoitem="AFFICHER &quot;Votre choix : &quot;"/>
            <item code="2#CHOIX_MENU#pasliste" algoitem="LIRE CHOIX_MENU"/>
            <item code="19# LIRE n" algoitem="// LIRE n"/>
            <item code="19#   i PREND_LA_VALEUR CHOIX_MENU" algoitem="//   i PREND_LA_VALEUR CHOIX_MENU"/>
            <item code="6#CHOIX_MENU == 1" algoitem="SI (CHOIX_MENU == 1) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#3 CADEAUX #0" algoitem="AFFICHER &quot;3 CADEAUX &quot;"/>
                <item code="5#i#3#pasliste" algoitem="i PREND_LA_VALEUR 3"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
                <item code="9#sinon" algoitem="SINON">
                    <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                    <item code="6#CHOIX_MENU == 2" algoitem="SI (CHOIX_MENU == 2) ALORS">
                        <item code="7#debutsi" algoitem="DEBUT_SI"/>
                        <item code="4#5 CADEAUX #0" algoitem="AFFICHER &quot;5 CADEAUX &quot;"/>
                        <item code="5#i#5#pasliste" algoitem="i PREND_LA_VALEUR 5"/>
                        <item code="8#finsi" algoitem="FIN_SI"/>
                    </item>
                    <item code="6#CHOIX_MENU == 3" algoitem="SI (CHOIX_MENU == 3) ALORS">
                        <item code="7#debutsi" algoitem="DEBUT_SI"/>
                        <item code="4#7 CADEAUX #0" algoitem="AFFICHER &quot;7 CADEAUX &quot;"/>
                        <item code="5#i#7#pasliste" algoitem="i PREND_LA_VALEUR 7"/>
                        <item code="8#finsi" algoitem="FIN_SI"/>
                    </item>
                    <item code="11#finsinon" algoitem="FIN_SINON"/>
                </item>
            </item>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
        <item code="12#i#1#CHOIX_MENU" algoitem="POUR i ALLANT_DE 1 A CHOIX_MENU">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="5#x#ALGOBOX_ALEA_ENT(1,CHOIX_MENU)#pasliste" algoitem="x PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,CHOIX_MENU)"/>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="15#cpt&lt;=CHOIX_MENU ET essai[cpt]!=x" algoitem="TANT_QUE (cpt&lt;=CHOIX_MENU ET essai[cpt]!=x) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="5#cpt#cpt+1#pasliste" algoitem="cpt PREND_LA_VALEUR cpt+1"/>
            <item code="5#i#i-1#pasliste" algoitem="i PREND_LA_VALEUR i-1"/>
            <item code="4#Saisir un nombre pour trouver le cadeau#0" algoitem="AFFICHER &quot;Saisir un nombre pour trouver le cadeau&quot;"/>
            <item code="19#AFFICHER &quot;DESOLE  C etait ça &quot;" algoitem="//AFFICHER &quot;DESOLE  C etait ça &quot;"/>
            <item code="3#x#0#pasliste" algoitem="AFFICHER x"/>
            <item code="2#essai#cpt" algoitem="LIRE essai[cpt]"/>
            <item code="6#essai[cpt]==x" algoitem="SI (essai[cpt]==x) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#                      Gagné !!!#0" algoitem="AFFICHER &quot;                      Gagné !!!&quot;"/>
                <item code="5#best#cpt#pasliste" algoitem="best PREND_LA_VALEUR cpt"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
                <item code="9#sinon" algoitem="SINON">
                    <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                    <item code="4#Le nombre secret est + #0" algoitem="AFFICHER &quot;Le nombre secret est + &quot;"/>
                    <item code="6#essai[cpt]&lt;x" algoitem="SI (essai[cpt]&lt;x) ALORS">
                        <item code="7#debutsi" algoitem="DEBUT_SI"/>
                        <item code="4#grand#0" algoitem="AFFICHER &quot;grand&quot;"/>
                        <item code="8#finsi" algoitem="FIN_SI"/>
                        <item code="9#sinon" algoitem="SINON">
                            <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                            <item code="4#petit#0" algoitem="AFFICHER &quot;petit&quot;"/>
                            <item code="11#finsinon" algoitem="FIN_SINON"/>
                        </item>
                    </item>
                    <item code="4#...encore  #0" algoitem="AFFICHER &quot;...encore  &quot;"/>
                    <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
                    <item code="4#  essais ...#0" algoitem="AFFICHER &quot;  essais ...&quot;"/>
                    <item code="11#finsinon" algoitem="FIN_SINON"/>
                </item>
            </item>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
        <item code="4#          Meilleur Score : #0" algoitem="AFFICHER &quot;          Meilleur Score : &quot;"/>
        <item code="3#best#0#pasliste" algoitem="AFFICHER best"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
