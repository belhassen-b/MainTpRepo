<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER &quot; Jeu terminé&quot;"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2para="" F2defaut="" F2etat="inactif" F2lignes=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param totalAffichages="1000" epaisseurPoint="2" arrondiAuto="vrai" totalBoucles="5000000" epaisseurLigne="2" nbDecimales="8" maxBoucle="500000"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions">
        <item algoitem="FONCTION initialisation(CHOIX_MENU)" code="201#initialisation#CHOIX_MENU">
            <item algoitem="VARIABLES_FONCTION" code="202#declarationsvariablesfonction"/>
            <item algoitem="DEBUT_FONCTION" code="203#debutfonction"/>
            <item algoitem="i PREND_LA_VALEUR 1+2*CHOIX_MENU" code="5#i#1+2*CHOIX_MENU#pasliste"/>
            <item algoitem="FIN_FONCTION" code="204#finfonction"/>
        </item>
    </item>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
        <item algoitem="tableau EST_DU_TYPE LISTE" code="1#LISTE#tableau"/>
        <item algoitem="CHOIX_MENU EST_DU_TYPE NOMBRE" code="1#NOMBRE#CHOIX_MENU"/>
        <item algoitem="nbreAlea EST_DU_TYPE NOMBRE" code="1#NOMBRE#nbreAlea"/>
        <item algoitem="maReponse EST_DU_TYPE NOMBRE" code="1#NOMBRE#maReponse"/>
        <item algoitem="cpt EST_DU_TYPE NOMBRE" code="1#NOMBRE#cpt"/>
        <item algoitem="maxTent EST_DU_TYPE NOMBRE" code="1#NOMBRE#maxTent"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="////////////la valeur d arret de saisie est -1 ////" code="19#//////////la valeur d arret de saisie est -1 ////"/>
        <item algoitem="AFFICHER &quot;Chercher le grelot &quot;" code="4#Chercher le grelot #0"/>
        <item algoitem="AFFICHER &quot;\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===&quot;" code="4#\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===#1"/>
        <item algoitem="AFFICHER &quot;1. Niveau 1 (3 cadeaux)&quot;" code="4#1. Niveau 1 (3 cadeaux)#1"/>
        <item algoitem="AFFICHER &quot;2. Niveau 2 (5 cadeaux)&quot;" code="4#2. Niveau 2 (5 cadeaux)#1"/>
        <item algoitem="AFFICHER &quot;3. Niveau 2 (7 cadeaux)&quot;" code="4#3. Niveau 2 (7 cadeaux)#1"/>
        <item algoitem="AFFICHER &quot;0. Quitter le programme&quot;" code="4#0. Quitter le programme#1"/>
        <item algoitem="AFFICHER &quot;Votre choix : &quot;" code="4#Votre choix : #0"/>
        <item algoitem="///////  enregistremebts des elements ////////" code="19#/////  enregistremebts des elements ////////"/>
        <item algoitem="TANT_QUE (CHOIX_MENU!=1 ET CHOIX_MENU!=2 ET CHOIX_MENU!=3) FAIRE" code="15#CHOIX_MENU!=1 ET CHOIX_MENU!=2 ET CHOIX_MENU!=3">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="LIRE CHOIX_MENU" code="2#CHOIX_MENU#pasliste"/>
            <item algoitem="SI (CHOIX_MENU == 1 OU CHOIX_MENU == 2 OU CHOIX_MENU == 3) ALORS" code="6#CHOIX_MENU == 1 OU CHOIX_MENU == 2 OU CHOIX_MENU == 3">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="APPELER_FONCTION initialisation(CHOIX_MENU)" code="206#initialisation(CHOIX_MENU)"/>
                <item algoitem="AFFICHER &quot;Le grelot est parmi ces&quot;" code="4#Le grelot est parmi ces#1"/>
                <item algoitem="AFFICHER i" code="3#i#0#pasliste"/>
                <item algoitem="AFFICHER &quot; Cadeaux , trouve le bon :&quot;" code="4# Cadeaux , trouve le bon :#0"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
                <item algoitem="SINON" code="9#sinon">
                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                    <item algoitem="SI (CHOIX_MENU &lt; 0 OU CHOIX_MENU >= i) ALORS" code="6#CHOIX_MENU &lt; 0 OU CHOIX_MENU >= i">
                        <item algoitem="DEBUT_SI" code="7#debutsi"/>
                        <item algoitem="AFFICHER &quot;Faire un choix correct&quot;" code="4#Faire un choix correct#0"/>
                        <item algoitem="FIN_SI" code="8#finsi"/>
                    </item>
                    <item algoitem="SI (CHOIX_MENU == 0) ALORS" code="6#CHOIX_MENU == 0">
                        <item algoitem="DEBUT_SI" code="7#debutsi"/>
                        <item algoitem="AFFICHER &quot;Jeu terminé !&quot;" code="4#Jeu terminé !#0"/>
                        <item algoitem="FIN_SI" code="8#finsi"/>
                    </item>
                    <item algoitem="FIN_SINON" code="11#finsinon"/>
                </item>
            </item>
            <item algoitem="nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)" code="5#nbreAlea#ALGOBOX_ALEA_ENT(1,i)#pasliste"/>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="TANT_QUE (maReponse!=nbreAlea) FAIRE" code="15#maReponse!=nbreAlea">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="cpt PREND_LA_VALEUR 1" code="5#cpt#1#pasliste"/>
            <item algoitem="LIRE maReponse" code="2#maReponse#pasliste"/>
            <item algoitem="SI (maReponse==nbreAlea) ALORS" code="6#maReponse==nbreAlea">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="SI (maReponse &lt; 0 OU maReponse>= i) ALORS" code="6#maReponse &lt; 0 OU maReponse>= i">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="AFFICHER &quot;Faire un choix correct&quot;" code="4#Faire un choix correct#0"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                </item>
                <item algoitem="FIN_SI" code="8#finsi"/>
                <item algoitem="SINON" code="9#sinon">
                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                    <item algoitem="AFFICHER i" code="3#i#0#pasliste"/>
                    <item algoitem="AFFICHER &quot;\nLe cadeau n'est pas caché là !! &quot;" code="4#\nLe cadeau n'est pas caché là !! #0"/>
                    <item algoitem="AFFICHER &quot;\nIl était ici &quot;" code="4#\nIl était ici #0"/>
                    <item algoitem="AFFICHER nbreAlea" code="3#nbreAlea#1#pasliste"/>
                    <item algoitem="AFFICHER &quot;\nAllez on éteinds la lumière et on mélange ...&quot;" code="4#\nAllez on éteinds la lumière et on mélange ...#0"/>
                    <item algoitem="cpt PREND_LA_VALEUR cpt+1" code="5#cpt#cpt+1#pasliste"/>
                    <item algoitem="maxTent PREND_LA_VALEUR cpt" code="5#maxTent#cpt#pasliste"/>
                    <item algoitem="nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)" code="5#nbreAlea#ALGOBOX_ALEA_ENT(1,i)#pasliste"/>
                    <item algoitem="//lire maReponse" code="19#lire maReponse"/>
                    <item algoitem="// SI (maReponse ==-1) ALORS" code="19# SI (maReponse ==-1) ALORS"/>
                    <item algoitem="FIN_SINON" code="11#finsinon"/>
                </item>
            </item>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="AFFICHER &quot;Bravo tu as trouvé le grelot  !!!&quot;" code="4#Bravo tu as trouvé le grelot  !!!#0"/>
        <item algoitem="AFFICHER &quot;\nTu as trouvé en : &quot;" code="4#\nTu as trouvé en : #0"/>
        <item algoitem="AFFICHER &quot; tentatives !&quot;" code="4# tentatives !#0"/>
        <item algoitem="AFFICHER &quot; Jeu terminé&quot;" code="4# Jeu terminé#0"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
