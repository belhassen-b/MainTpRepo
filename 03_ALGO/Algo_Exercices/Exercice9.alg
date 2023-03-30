<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_SINON" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2defaut="" F2para="" F2etat="inactif" F2lignes=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param nbDecimales="8" arrondiAuto="vrai" maxBoucle="500000" totalAffichages="1000" epaisseurPoint="2" totalBoucles="5000000" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="taille EST_DU_TYPE NOMBRE" code="1#NOMBRE#taille"/>
        <item algoitem="poids EST_DU_TYPE NOMBRE" code="1#NOMBRE#poids"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Entrez votre taille : &quot;" code="4#Entrez votre taille : #0"/>
        <item algoitem="LIRE taille" code="2#taille#pasliste"/>
        <item algoitem="AFFICHER &quot;Entrez votre poids: &quot;" code="4#Entrez votre poids: #0"/>
        <item algoitem="LIRE poids" code="2#poids#pasliste"/>
        <item algoitem="SI (taille>=145 ET taille&lt;=160 ET poids>43 ET poids&lt;66 OU taille>=145 ET taille&lt;=169 ET poids>=43 ET poids&lt;=47 OU taille>=145 ET taille&lt;=166 ET poids>=43 ET poids&lt;=53 OU taille>=145 ET taille&lt;=163 ET poids>=43 ET poids&lt;=59 OU taille>=145 ET taille&lt;=160 ET poids>=43 ET poids&lt;=65) ALORS" code="6#taille>=145 ET taille&lt;=160 ET poids>43 ET poids&lt;66 OU taille>=145 ET taille&lt;=169 ET poids>=43 ET poids&lt;=47 OU taille>=145 ET taille&lt;=166 ET poids>=43 ET poids&lt;=53 OU taille>=145 ET taille&lt;=163 ET poids>=43 ET poids&lt;=59 OU taille>=145 ET taille&lt;=160 ET poids>=43 ET poids&lt;=65">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="AFFICHER &quot;Votre taille est 1&quot;" code="4#Votre taille est 1#0"/>
            <item algoitem="FIN_SI" code="8#finsi"/>
            <item algoitem="SINON" code="9#sinon">
                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                <item algoitem="SI (poids>=48 ET poids&lt;=53 ET taille>=166 ET taille&lt;=178 OU  poids>=54 ET poids&lt;=59 ET taille>=163 ET taille&lt;=175 OU  poids>=60 ET poids&lt;=65 ET taille>=160 ET taille&lt;=172 OU  poids>=66 ET poids&lt;=71 ET taille>=157 ET taille&lt;=169) ALORS" code="6#poids>=48 ET poids&lt;=53 ET taille>=166 ET taille&lt;=178 OU  poids>=54 ET poids&lt;=59 ET taille>=163 ET taille&lt;=175 OU  poids>=60 ET poids&lt;=65 ET taille>=160 ET taille&lt;=172 OU  poids>=66 ET poids&lt;=71 ET taille>=157 ET taille&lt;=169">
                    <item algoitem="DEBUT_SI" code="7#debutsi"/>
                    <item algoitem="AFFICHER &quot;Votre taille est 2&quot;" code="4#Votre taille est 2#0"/>
                    <item algoitem="FIN_SI" code="8#finsi"/>
                    <item algoitem="SINON" code="9#sinon">
                        <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                        <item algoitem="SI (taille>=160 ET poids>=72 ET poids&lt;=77) OU (taille>=169 ET poids>=66 ET poids&lt;=71) OU (taille>=172 ET poids>=60 ET poids&lt;=65) OU (taille>=175 ET poids>=54 ET poids&lt;=59) ALORS" code="6#taille>=160 ET poids>=72 ET poids&lt;=77) OU (taille>=169 ET poids>=66 ET poids&lt;=71) OU (taille>=172 ET poids>=60 ET poids&lt;=65) OU (taille>=175 ET poids>=54 ET poids&lt;=59">
                            <item algoitem="DEBUT_SI" code="7#debutsi"/>
                            <item algoitem="AFFICHER &quot;Votre taille est 3&quot;" code="4#Votre taille est 3#0"/>
                            <item algoitem="FIN_SI" code="8#finsi"/>
                            <item algoitem="SINON" code="9#sinon">
                                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                                <item algoitem="AFFICHER &quot;Hors limite&quot;" code="4#Hors limite#0"/>
                                <item algoitem="FIN_SINON" code="11#finsinon"/>
                            </item>
                        </item>
                        <item algoitem="FIN_SINON" code="11#finsinon"/>
                    </item>
                </item>
                <item algoitem="FIN_SINON" code="11#finsinon"/>
            </item>
        </item>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
