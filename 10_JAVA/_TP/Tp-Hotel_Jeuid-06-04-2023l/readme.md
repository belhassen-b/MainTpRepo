## TP HÔTEL
On désire informatiser la gestion des réservations et des séjours pour un l’hôtel : Réaliser une
application console de gestion des réservations.
1- Gestion des Clients
a) Affichage de la liste des clients, et détail de chaque client (Réservations, annulations).
b) Ajout d’un nouveau client
2- Gestion des réservations
a) Possibilité d’ajouter une réservation
a) Possibilité de changer le statut de réservation
b) Afficher la liste des réservations
Pour les besoins du TP :
Au démarrage de l’application on demande le nom de l’hôtel, on crée l’hôtel avec, par exemple 20
chambres au hasard.
Ensuite on affichera le menu suivant :
1. 1- Ajouter un client
2. 2- Afficher la liste des clients
3. 3- Afficher les réservations d’un client
4. 4- Ajouter une réservation
5. 5- Annuler une réservation
6. 6- Afficher la liste des réservations
Pour le menu 1 on demandera le nom, prénom, et le téléphone du client avant de l’ajouter aux
clients de l’hôtel
Pour le menu 3 on demandera le téléphone du client et ensuite on affichera les réservations de ce
client.
Pour le menu 4 on demandera le numéro du client, le nombre d’occupant, ensuite on vérifie si des
chambres sont libres pour la réservation si oui on crée la réservation et on l’ajoute aux réservations
de l’hôtel
Pour le menu 5 on demandera le numéro de réservation, on annule la réservation et on libère les
chambres de la réservation, on déclenchera un évènement à la libération de la chambre
Aide : L’application peut être modélisée par :
• - Une classe client (id, nom, prénom, téléphone)
• - Une classe chambre (numéro, statut (Libre ou occupée), tarif, capacité)
• - Une classe réservation (numéro, statut (validée, annulée), client, une chambre)
• - Une classe Hôtel (nom, liste chambres, liste réservations, liste clients)
• - Une classe IHM en mode console