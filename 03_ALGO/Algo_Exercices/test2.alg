<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER &quot; Jeu terminé&quot;"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2para="" F2lignes="" F2etat="inactif"/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param epaisseurLigne="2" arrondiAuto="vrai" maxBoucle="500000" totalBoucles="5000000" totalAffichages="1000" nbDecimales="8" epaisseurPoint="2"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES">
        <item code="201#choix_Diff#difficulty" algoitem="FONCTION choix_Diff(difficulty)">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION"/>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="5#i#1+ 2 * difficulty#pasliste" algoitem="i PREND_LA_VALEUR 1+ 2 * difficulty"/>
            <item code="5#nbreAlea#ALGOBOX_ALEA_ENT(1,i)#pasliste" algoitem="nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
    </item>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#indice" algoitem="indice EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#LISTE#tableau" algoitem="tableau EST_DU_TYPE LISTE"/>
        <item code="1#NOMBRE#N" algoitem="N EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#val_tab" algoitem="val_tab EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#CHOIX_MENU" algoitem="CHOIX_MENU EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nbreAlea" algoitem="nbreAlea EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#maReponse" algoitem="maReponse EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="19#//////////la valeur d arret de saisie est -1 ////" algoitem="////////////la valeur d arret de saisie est -1 ////"/>
        <item code="4#Chercher le grelot #0" algoitem="AFFICHER &quot;Chercher le grelot &quot;"/>
        <item code="4#\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===#1" algoitem="AFFICHER &quot;\n=== CHOISIR LE NIVEAU DE DIFFICULTÉ ===&quot;"/>
        <item code="4#1. Niveau 1 (3 cadeaux)#1" algoitem="AFFICHER &quot;1. Niveau 1 (3 cadeaux)&quot;"/>
        <item code="4#2. Niveau 2 (5 cadeaux)#1" algoitem="AFFICHER &quot;2. Niveau 2 (5 cadeaux)&quot;"/>
        <item code="4#3. Niveau 2 (7 cadeaux)#1" algoitem="AFFICHER &quot;3. Niveau 2 (7 cadeaux)&quot;"/>
        <item code="4#0. Quitter le programme#1" algoitem="AFFICHER &quot;0. Quitter le programme&quot;"/>
        <item code="4#Votre choix : #0" algoitem="AFFICHER &quot;Votre choix : &quot;"/>
        <item code="2#CHOIX_MENU#pasliste" algoitem="LIRE CHOIX_MENU"/>
        <item code="19#/////  enregistremebts des elements ////////" algoitem="///////  enregistremebts des elements ////////"/>
        <item code="206#choix_Diff(MON_CHOIX)" algoitem="APPELER_FONCTION choix_Diff(MON_CHOIX)"/>
        <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
        <item code="3#nbreAlea#0#pasliste" algoitem="AFFICHER nbreAlea"/>
        <item code="15#CHOIX_MENU!=1 ET CHOIX_MENU!=2 ET CHOIX_MENU!=3" algoitem="TANT_QUE (CHOIX_MENU!=1 ET CHOIX_MENU!=2 ET CHOIX_MENU!=3) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="6#CHOIX_MENU == 1" algoitem="SI (CHOIX_MENU == 1) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#Le grelot est parmi ces 3 Cadeaux , trouve le bon :#1" algoitem="AFFICHER &quot;Le grelot est parmi ces 3 Cadeaux , trouve le bon :&quot;"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
                <item code="9#sinon" algoitem="SINON">
                    <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                    <item code="6#CHOIX_MENU == 2" algoitem="SI (CHOIX_MENU == 2) ALORS">
                        <item code="7#debutsi" algoitem="DEBUT_SI"/>
                        <item code="4#Le grelot est parmi ces 5 Cadeaux , trouve le bon :#0" algoitem="AFFICHER &quot;Le grelot est parmi ces 5 Cadeaux , trouve le bon :&quot;"/>
                        <item code="5#i#5#pasliste" algoitem="i PREND_LA_VALEUR 5"/>
                        <item code="8#finsi" algoitem="FIN_SI"/>
                    </item>
                    <item code="6#CHOIX_MENU == 3" algoitem="SI (CHOIX_MENU == 3) ALORS">
                        <item code="7#debutsi" algoitem="DEBUT_SI"/>
                        <item code="4#Le grelot est parmi ces 7 Cadeaux , trouve le bon :#0" algoitem="AFFICHER &quot;Le grelot est parmi ces 7 Cadeaux , trouve le bon :&quot;"/>
                        <item code="5#i#7#pasliste" algoitem="i PREND_LA_VALEUR 7"/>
                        <item code="8#finsi" algoitem="FIN_SI"/>
                    </item>
                    <item code="11#finsinon" algoitem="FIN_SINON"/>
                </item>
            </item>
            <item code="5#nbreAlea#ALGOBOX_ALEA_ENT(1,i)#pasliste" algoitem="nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)"/>
            <item code="2#maReponse#pasliste" algoitem="LIRE maReponse"/>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
        <item code="15#tableau[i]!=nbreAlea" algoitem="TANT_QUE (tableau[i]!=nbreAlea) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="2#maReponse#pasliste" algoitem="LIRE maReponse"/>
            <item code="6#maReponse!=nbreAlea" algoitem="SI (maReponse!=nbreAlea) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
                <item code="4#\nLe cadeau n'est pas caché là !! #0" algoitem="AFFICHER &quot;\nLe cadeau n'est pas caché là !! &quot;"/>
                <item code="4#\nIl était ici #0" algoitem="AFFICHER &quot;\nIl était ici &quot;"/>
                <item code="3#nbreAlea#1#pasliste" algoitem="AFFICHER nbreAlea"/>
                <item code="4#\nAllez on éteinds la lumière et on mélange ...#0" algoitem="AFFICHER &quot;\nAllez on éteinds la lumière et on mélange ...&quot;"/>
                <item code="5#nbreAlea#ALGOBOX_ALEA_ENT(1,i)#pasliste" algoitem="nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)"/>
                <item code="19#cpt PREND_LA_VALEUR 1" algoitem="//cpt PREND_LA_VALEUR 1"/>
                <item code="19#cpt PREND_LA_VALEUR cpt+1" algoitem="//cpt PREND_LA_VALEUR cpt+1"/>
                <item code="19# maxTent PREND_LA_VALEUR cpt" algoitem="// maxTent PREND_LA_VALEUR cpt"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
            </item>
            <item code="19#lire maReponse" algoitem="//lire maReponse"/>
            <item code="19# SI (maReponse ==-1) ALORS" algoitem="// SI (maReponse ==-1) ALORS"/>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
        <item code="4#Bravo tu as trouvé le grelot  !!!#0" algoitem="AFFICHER &quot;Bravo tu as trouvé le grelot  !!!&quot;"/>
        <item code="4#\nTu as trouvé en : #0" algoitem="AFFICHER &quot;\nTu as trouvé en : &quot;"/>
        <item code="4# tentatives !#0" algoitem="AFFICHER &quot; tentatives !&quot;"/>
        <item code="4# Jeu terminé#0" algoitem="AFFICHER &quot; Jeu terminé&quot;"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
