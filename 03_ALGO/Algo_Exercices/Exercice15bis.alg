<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="AFFICHER &quot; pour la population atteigne au moins 120 000 Habitants&quot;" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2defaut="" F2etat="inactif" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param arrondiAuto="vrai" maxBoucle="500000" epaisseurLigne="2" nbDecimales="8" totalBoucles="5000000" epaisseurPoint="2" totalAffichages="1000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#hab" algoitem="hab EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#tx" algoitem="tx EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#annee" algoitem="annee EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#hab#96809#pasliste" algoitem="hab PREND_LA_VALEUR 96809"/>
        <item code="5#tx#0.0089#pasliste" algoitem="tx PREND_LA_VALEUR 0.0089"/>
        <item code="15#hab&lt;120000" algoitem="TANT_QUE (hab&lt;120000) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="5#annee#annee+1#pasliste" algoitem="annee PREND_LA_VALEUR annee+1"/>
            <item code="5#hab#hab+(hab*tx)#pasliste" algoitem="hab PREND_LA_VALEUR hab+(hab*tx)"/>
            <item code="3#hab#1#pasliste" algoitem="AFFICHER hab"/>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
        <item code="4#Il faut #0" algoitem="AFFICHER &quot;Il faut &quot;"/>
        <item code="3#annee#0#pasliste" algoitem="AFFICHER annee"/>
        <item code="4# pour la population atteigne au moins 120 000 Habitants#1" algoitem="AFFICHER &quot; pour la population atteigne au moins 120 000 Habitants&quot;"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
