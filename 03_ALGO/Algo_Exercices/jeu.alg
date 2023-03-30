<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="APPELER_FONCTION initTab(longTab)" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2defaut="" F2lignes="" F2etat="inactif"/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param totalAffichages="1000" epaisseurLigne="2" epaisseurPoint="2" arrondiAuto="vrai" totalBoucles="5000000" maxBoucle="500000" nbDecimales="8"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions">
        <item algoitem="FONCTION initTab(longTab)" code="201#initTab#longTab">
            <item algoitem="VARIABLES_FONCTION" code="202#declarationsvariablesfonction">
                <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
            </item>
            <item algoitem="DEBUT_FONCTION" code="203#debutfonction"/>
            <item algoitem="POUR i ALLANT_DE 0 A i-1" code="12#i#0#i-1">
                <item algoitem="DEBUT_POUR" code="13#debutpour"/>
                <item algoitem="monTab[longTab] PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,MON_CHOIX)" code="5#monTab#ALGOBOX_ALEA_ENT(1,MON_CHOIX)#longTab"/>
                <item algoitem="FIN_POUR" code="14#finpour"/>
            </item>
            <item algoitem="FIN_FONCTION" code="204#finfonction"/>
        </item>
        <item algoitem="FONCTION checkGrelot( )" code="201#checkGrelot# ">
            <item algoitem="VARIABLES_FONCTION" code="202#declarationsvariablesfonction"/>
            <item algoitem="DEBUT_FONCTION" code="203#debutfonction"/>
            <item algoitem="FIN_FONCTION" code="204#finfonction"/>
        </item>
    </item>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="monTab EST_DU_TYPE LISTE" code="1#LISTE#monTab"/>
        <item algoitem="nbreAlea EST_DU_TYPE NOMBRE" code="1#NOMBRE#nbreAlea"/>
        <item algoitem="cpt EST_DU_TYPE NOMBRE" code="1#NOMBRE#cpt"/>
        <item algoitem="maxTent EST_DU_TYPE NOMBRE" code="1#NOMBRE#maxTent"/>
        <item algoitem="CHOIX_MENU EST_DU_TYPE NOMBRE" code="1#NOMBRE#CHOIX_MENU"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Chercher le grelot &quot;" code="4#Chercher le grelot #0"/>
        <item algoitem="AFFICHER &quot;\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===&quot;" code="4#\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===#1"/>
        <item algoitem="AFFICHER &quot;1. Niveau 1 (3 cadeaux)&quot;" code="4#1. Niveau 1 (3 cadeaux)#1"/>
        <item algoitem="AFFICHER &quot;2. Niveau 2 (5 cadeaux)&quot;" code="4#2. Niveau 2 (5 cadeaux)#1"/>
        <item algoitem="AFFICHER &quot;3. Niveau 2 (7 cadeaux)&quot;" code="4#3. Niveau 2 (7 cadeaux)#1"/>
        <item algoitem="AFFICHER &quot;0. Quitter le programme&quot;" code="4#0. Quitter le programme#1"/>
        <item algoitem="AFFICHER &quot;Votre choix : &quot;" code="4#Votre choix : #0"/>
        <item algoitem="LIRE CHOIX_MENU" code="2#CHOIX_MENU#pasliste"/>
        <item algoitem="AFFICHER CHOIX_MENU" code="3#CHOIX_MENU#0#pasliste"/>
        <item algoitem="cpt PREND_LA_VALEUR 0" code="5#cpt#0#pasliste"/>
        <item algoitem="nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)" code="5#nbreAlea#ALGOBOX_ALEA_ENT(1,i)#pasliste"/>
        <item algoitem="AFFICHER nbreAlea" code="3#nbreAlea#0#pasliste"/>
        <item algoitem="TANT_QUE (CHOIX_MENU!=1 ET CHOIX_MENU!=2 ET CHOIX_MENU!=3) FAIRE" code="15#CHOIX_MENU!=1 ET CHOIX_MENU!=2 ET CHOIX_MENU!=3">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="SI (CHOIX_MENU == 1) ALORS" code="6#CHOIX_MENU == 1">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="AFFICHER &quot;Le grelot est parmi ces 3 Cadeaux , trouve le bon :&quot;" code="4#Le grelot est parmi ces 3 Cadeaux , trouve le bon :#1"/>
                <item algoitem="//        i PREND_LA_VALEUR 3" code="19#        i PREND_LA_VALEUR 3"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
                <item algoitem="SINON" code="9#sinon">
                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                    <item algoitem="SI (CHOIX_MENU == 2) ALORS" code="6#CHOIX_MENU == 2">
                        <item algoitem="DEBUT_SI" code="7#debutsi"/>
                        <item algoitem="AFFICHER &quot;Le grelot est parmi ces 5 Cadeaux , trouve le bon :&quot;" code="4#Le grelot est parmi ces 5 Cadeaux , trouve le bon :#0"/>
                        <item algoitem="i PREND_LA_VALEUR 5" code="5#i#5#pasliste"/>
                        <item algoitem="FIN_SI" code="8#finsi"/>
                    </item>
                    <item algoitem="SI (CHOIX_MENU == 3) ALORS" code="6#CHOIX_MENU == 3">
                        <item algoitem="DEBUT_SI" code="7#debutsi"/>
                        <item algoitem="AFFICHER &quot;Le grelot est parmi ces 7 Cadeaux , trouve le bon :&quot;" code="4#Le grelot est parmi ces 7 Cadeaux , trouve le bon :#0"/>
                        <item algoitem="i PREND_LA_VALEUR 7" code="5#i#7#pasliste"/>
                        <item algoitem="FIN_SI" code="8#finsi"/>
                    </item>
                    <item algoitem="FIN_SINON" code="11#finsinon"/>
                </item>
            </item>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="TANT_QUE (monTab[longTab]!=nbreAlea) FAIRE" code="15#monTab[longTab]!=nbreAlea">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="LIRE monTab[longTab]" code="2#monTab#longTab"/>
            <item algoitem="SI (monTab[longTab]!=nbreAlea) ALORS" code="6#monTab[longTab]!=nbreAlea">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="AFFICHER &quot;\nLe cadeau n'est pas caché là !! &quot;" code="4#\nLe cadeau n'est pas caché là !! #0"/>
                <item algoitem="AFFICHER &quot;\nIl était ici &quot;" code="4#\nIl était ici #0"/>
                <item algoitem="AFFICHER nbreAlea" code="3#nbreAlea#1#pasliste"/>
                <item algoitem="AFFICHER &quot;\nAllez on éteinds la lumière et on mélange ...&quot;" code="4#\nAllez on éteinds la lumière et on mélange ...#0"/>
                <item algoitem="// nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)" code="19# nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)"/>
                <item algoitem="cpt PREND_LA_VALEUR 1" code="5#cpt#1#pasliste"/>
                <item algoitem="cpt PREND_LA_VALEUR cpt+1" code="5#cpt#cpt+1#pasliste"/>
                <item algoitem="maxTent PREND_LA_VALEUR cpt" code="5#maxTent#cpt#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
                <item algoitem="SINON" code="9#sinon">
                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                    <item algoitem="AFFICHER &quot;Bravo tu as trouvé le grelot  !!!&quot;" code="4#Bravo tu as trouvé le grelot  !!!#0"/>
                    <item algoitem="AFFICHER &quot;\nTu as trouvé en : &quot;" code="4#\nTu as trouvé en : #0"/>
                    <item algoitem="AFFICHER maxTent" code="3#maxTent#0#pasliste"/>
                    <item algoitem="AFFICHER &quot; tentatives !&quot;" code="4# tentatives !#0"/>
                    <item algoitem="FIN_SINON" code="11#finsinon"/>
                </item>
            </item>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="APPELER_FONCTION initTab(longTab)" code="206#initTab(longTab)"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
