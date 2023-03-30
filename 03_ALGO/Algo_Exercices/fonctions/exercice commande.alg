<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FONCTIONS_UTILISEES" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2defaut="" F2etat="inactif" F2lignes=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param maxBoucle="500000" totalAffichages="1000" arrondiAuto="vrai" epaisseurPoint="2" totalBoucles="5000000" nbDecimales="8" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="pac EST_DU_TYPE CHAINE" code="1#CHAINE#pac"/>
        <item algoitem="crois EST_DU_TYPE CHAINE" code="1#CHAINE#crois"/>
        <item algoitem="bag EST_DU_TYPE CHAINE" code="1#CHAINE#bag"/>
        <item algoitem="pxPac EST_DU_TYPE CHAINE" code="1#CHAINE#pxPac"/>
        <item algoitem="pxCrois EST_DU_TYPE CHAINE" code="1#CHAINE#pxCrois"/>
        <item algoitem="pxBag EST_DU_TYPE CHAINE" code="1#CHAINE#pxBag"/>
        <item algoitem="CHOIX_MENU EST_DU_TYPE NOMBRE" code="1#NOMBRE#CHOIX_MENU"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="CHOIX_MENU PREND_LA_VALEUR -1" code="5#CHOIX_MENU#-1#pasliste"/>
        <item algoitem="TANT_QUE (CHOIX_MENU != 0) FAIRE" code="15#CHOIX_MENU != 0">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="AFFICHER &quot;\n=== MENU ===&quot;" code="4#\n=== MENU ===#1"/>
            <item algoitem="AFFICHER &quot;1. Ajouter pain au chocolat&quot;" code="4#1. Ajouter pain au chocolat#1"/>
            <item algoitem="AFFICHER &quot;2. Retirer pain au chocolat&quot;" code="4#2. Retirer pain au chocolat#1"/>
            <item algoitem="AFFICHER &quot;3. Ajouter croissant&quot;" code="4#3. Ajouter croissant#1"/>
            <item algoitem="AFFICHER &quot;4. Retirer croissant&quot;" code="4#4. Retirer croissant#1"/>
            <item algoitem="AFFICHER &quot;5. Ajouter Baguette&quot;" code="4#5. Ajouter Baguette#1"/>
            <item algoitem="AFFICHER &quot;6. Retirer Baguette&quot;" code="4#6. Retirer Baguette#1"/>
            <item algoitem="AFFICHER &quot;7. Voir la commande&quot;" code="4#7. Voir la commande#1"/>
            <item algoitem="AFFICHER &quot;0. Quitter le programme&quot;" code="4#0. Quitter le programme#1"/>
            <item algoitem="AFFICHER &quot;Votre choix : &quot;" code="4#Votre choix : #0"/>
            <item algoitem="LIRE CHOIX_MENU" code="2#CHOIX_MENU#pasliste"/>
            <item algoitem="SI (CHOIX_MENU == 1) ALORS" code="6#CHOIX_MENU == 1">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="AFFICHER &quot;Pain au chocolat ajouté &quot;" code="4#Pain au chocolat ajouté #0"/>
                <item algoitem="pxPac PREND_LA_VALEUR pxPac +" code="5#pxPac#pxPac +#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
                <item algoitem="SINON" code="9#sinon">
                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                    <item algoitem="SI (CHOIX_MENU == 2) ALORS" code="6#CHOIX_MENU == 2">
                        <item algoitem="DEBUT_SI" code="7#debutsi"/>
                        <item algoitem="AFFICHER &quot;Pain au chocolat retiré &quot;" code="4#Pain au chocolat retiré #0"/>
                        <item algoitem="pxPac PREND_LA_VALEUR pxPac -" code="5#pxPac#pxPac -#pasliste"/>
                        <item algoitem="FIN_SI" code="8#finsi"/>
                    </item>
                    <item algoitem="SI (CHOIX_MENU == 3) ALORS" code="6#CHOIX_MENU == 3">
                        <item algoitem="DEBUT_SI" code="7#debutsi"/>
                        <item algoitem="AFFICHER &quot;Croissant ajouté &quot;" code="4#Croissant ajouté #0"/>
                        <item algoitem="pxPac PREND_LA_VALEUR pxCrois +" code="5#pxPac#pxCrois +#pasliste"/>
                        <item algoitem="FIN_SI" code="8#finsi"/>
                        <item algoitem="SINON" code="9#sinon">
                            <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                            <item algoitem="SI (CHOIX_MENU == 4) ALORS" code="6#CHOIX_MENU == 4">
                                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                                <item algoitem="AFFICHER &quot;pxCrois retiré &quot;" code="4#pxCrois retiré #0"/>
                                <item algoitem="pxPac PREND_LA_VALEUR pxPac -" code="5#pxPac#pxPac -#pasliste"/>
                                <item algoitem="FIN_SI" code="8#finsi"/>
                            </item>
                            <item algoitem="SI (CHOIX_MENU == 5) ALORS" code="6#CHOIX_MENU == 5">
                                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                                <item algoitem="AFFICHER &quot;Baguette ajoutée &quot;" code="4#Baguette ajoutée #0"/>
                                <item algoitem="pxPac PREND_LA_VALEUR pxBag +" code="5#pxPac#pxBag +#pasliste"/>
                                <item algoitem="FIN_SI" code="8#finsi"/>
                                <item algoitem="SINON" code="9#sinon">
                                    <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                                    <item algoitem="SI (CHOIX_MENU == 6) ALORS" code="6#CHOIX_MENU == 6">
                                        <item algoitem="DEBUT_SI" code="7#debutsi"/>
                                        <item algoitem="AFFICHER &quot;Baguette retirée &quot;" code="4#Baguette retirée #0"/>
                                        <item algoitem="pxPac PREND_LA_VALEUR pxBag -" code="5#pxPac#pxBag -#pasliste"/>
                                        <item algoitem="FIN_SI" code="8#finsi"/>
                                        <item algoitem="SINON" code="9#sinon">
                                            <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                                            <item algoitem="SI (CHOIX_MENU == 7) ALORS" code="6#CHOIX_MENU == 7">
                                                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                                                <item algoitem="AFFICHER &quot;La moyenne des notes est de &quot;" code="4#La moyenne des notes est de #0"/>
                                                <item algoitem="FIN_SI" code="8#finsi"/>
                                            </item>
                                            <item algoitem="FIN_SINON" code="11#finsinon"/>
                                        </item>
                                    </item>
                                    <item algoitem="FIN_SINON" code="11#finsinon"/>
                                </item>
                            </item>
                            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
                        </item>
                    </item>
                </item>
            </item>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
