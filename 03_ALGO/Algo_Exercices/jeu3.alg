<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="APPELER_FONCTION checkGrelot()"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2lignes="" F2etat="inactif" F2para="" F2defaut=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param maxBoucle="500000" epaisseurPoint="2" nbDecimales="8" epaisseurLigne="2" totalAffichages="1000" arrondiAuto="vrai" totalBoucles="5000000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES">
        <item code="201#initJeu#CHOIX_MENU" algoitem="FONCTION initJeu(CHOIX_MENU)">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION"/>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="5#maBoite#1+ 2 * CHOIX_MENU#pasliste" algoitem="maBoite PREND_LA_VALEUR 1+ 2 * CHOIX_MENU"/>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
        <item code="201#aleatoire#maBoite" algoitem="FONCTION aleatoire(maBoite)">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION">
                <item code="1#NOMBRE#nbreAlea" algoitem="nbreAlea EST_DU_TYPE NOMBRE"/>
                <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
            </item>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="5#nbreAlea#ALGOBOX_ALEA_ENT(1,i)#pasliste" algoitem="nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)"/>
            <item code="12#i#0#maBoite - 1" algoitem="POUR i ALLANT_DE 0 A maBoite - 1"/>
            <item code="6#monTab[i]!=nbreAlea" algoitem="SI (monTab[i]!=nbreAlea) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="5#monTab#0#i" algoitem="monTab[i] PREND_LA_VALEUR 0"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
                <item code="9#sinon" algoitem="SINON">
                    <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                    <item code="5#monTab#1#i" algoitem="monTab[i] PREND_LA_VALEUR 1"/>
                    <item code="11#finsinon" algoitem="FIN_SINON"/>
                </item>
            </item>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        <item code="201#checkGrelot# " algoitem="FONCTION checkGrelot( )">
            <item code="202#declarationsvariablesfonction" algoitem="VARIABLES_FONCTION"/>
            <item code="203#debutfonction" algoitem="DEBUT_FONCTION"/>
            <item code="5#cpt#1#pasliste" algoitem="cpt PREND_LA_VALEUR 1"/>
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
                            <item code="8#finsi" algoitem="FIN_SI"/>
                        </item>
                        <item code="6#CHOIX_MENU == 3" algoitem="SI (CHOIX_MENU == 3) ALORS">
                            <item code="7#debutsi" algoitem="DEBUT_SI"/>
                            <item code="4#Le grelot est parmi ces 7 Cadeaux , trouve le bon :#0" algoitem="AFFICHER &quot;Le grelot est parmi ces 7 Cadeaux , trouve le bon :&quot;"/>
                            <item code="8#finsi" algoitem="FIN_SI"/>
                        </item>
                        <item code="6#CHOIX_MENU &lt; 0 OU MON_CHOIX>maBoite" algoitem="SI (CHOIX_MENU &lt; 0 OU MON_CHOIX>maBoite) ALORS">
                            <item code="7#debutsi" algoitem="DEBUT_SI"/>
                            <item code="4#Votre choix n'est pas valide !#1" algoitem="AFFICHER &quot;Votre choix n'est pas valide !&quot;"/>
                            <item code="8#finsi" algoitem="FIN_SI"/>
                        </item>
                        <item code="11#finsinon" algoitem="FIN_SINON"/>
                    </item>
                </item>
                <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
            </item>
            <item code="15#monTab[i]!=nbreAlea" algoitem="TANT_QUE (monTab[i]!=nbreAlea) FAIRE">
                <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
                <item code="2#monTab#i" algoitem="LIRE monTab[i]"/>
                <item code="6#monTab[i]!=nbreAlea" algoitem="SI (monTab[i]!=nbreAlea) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#\nLe cadeau n'est pas caché là !! #0" algoitem="AFFICHER &quot;\nLe cadeau n'est pas caché là !! &quot;"/>
                    <item code="4#\nIl était ici #0" algoitem="AFFICHER &quot;\nIl était ici &quot;"/>
                    <item code="3#nbreAlea#1#pasliste" algoitem="AFFICHER nbreAlea"/>
                    <item code="4#\nAllez on éteinds la lumière et on mélange ...#0" algoitem="AFFICHER &quot;\nAllez on éteinds la lumière et on mélange ...&quot;"/>
                    <item code="5#nbreAlea#ALGOBOX_ALEA_ENT(1,i)#pasliste" algoitem="nbreAlea PREND_LA_VALEUR ALGOBOX_ALEA_ENT(1,i)"/>
                    <item code="5#cpt#1#pasliste" algoitem="cpt PREND_LA_VALEUR 1"/>
                    <item code="5#cpt#cpt+1#pasliste" algoitem="cpt PREND_LA_VALEUR cpt+1"/>
                    <item code="5#maxTent#cpt#pasliste" algoitem="maxTent PREND_LA_VALEUR cpt"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                    <item code="9#sinon" algoitem="SINON">
                        <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                        <item code="4#Bravo tu as trouvé le grelot  !!!#0" algoitem="AFFICHER &quot;Bravo tu as trouvé le grelot  !!!&quot;"/>
                        <item code="4#\nTu as trouvé en : #0" algoitem="AFFICHER &quot;\nTu as trouvé en : &quot;"/>
                        <item code="3#maxTent#0#pasliste" algoitem="AFFICHER maxTent"/>
                        <item code="4# tentatives !#0" algoitem="AFFICHER &quot; tentatives !&quot;"/>
                        <item code="11#finsinon" algoitem="FIN_SINON"/>
                    </item>
                </item>
                <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
            </item>
            <item code="204#finfonction" algoitem="FIN_FONCTION"/>
        </item>
    </item>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#LISTE#monTab" algoitem="monTab EST_DU_TYPE LISTE"/>
        <item code="1#NOMBRE#cpt" algoitem="cpt EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#maxTent" algoitem="maxTent EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#CHOIX_MENU" algoitem="CHOIX_MENU EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#maBoite" algoitem="maBoite EST_DU_TYPE NOMBRE"/>
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
        <item code="3#monTab#0#i" algoitem="AFFICHER monTab[i]"/>
        <item code="206#aleatoire(maBoite)" algoitem="APPELER_FONCTION aleatoire(maBoite)"/>
        <item code="206#checkGrelot()" algoitem="APPELER_FONCTION checkGrelot()"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
