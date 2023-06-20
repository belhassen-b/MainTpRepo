Sujet Exercice de revision JEE : TP: Création d'une application Web pour la gestion d'un tournoi d'e-sport

L'objectif de ce TP est de créer une application web qui permet d'organiser et de gérer un tournoi d'e-sport.

Spécifications de base :

Les administrateurs peuvent créer, modifier, supprimer et voir les détails des tournois.
Chaque tournoi a les attributs suivants : ID, nom, jeu, date et heure, et liste des équipes inscrites.
Les équipes ont un ID, un nom et une liste de joueurs.
Les joueurs ont un ID, un nom d'utilisateur et un jeu dans lequel ils sont spécialisés.
Les administrateurs doivent pouvoir ajouter et retirer des équipes des tournois.
Les utilisateurs peuvent s'inscrire en tant que joueurs et rejoindre des équipes.
Les utilisateurs peuvent consulter la liste des tournois à venir et leurs détails.

Tâches :

Configurez votre environnement de développement avec Java, un IDE, un serveur d'applications JEE et Hibernate.
Créez un nouveau projet JEE et configurez Hibernate.
Créez des classes POJO pour Tournament, Team et Player. Ces classes doivent inclure les attributs mentionnés ci-dessus.
Utilisez Hibernate pour persister ces objets dans une base de données.
Créez des servlets pour gérer les requêtes des utilisateurs et retourner des réponses appropriées. Par exemple, 
vous pouvez avoir un servlet pour gérer les requêtes liées aux tournois, un autre pour les équipes, et un autre pour les joueurs.
Utilisez JSP pour créer des pages Web que les utilisateurs peuvent utiliser pour interagir avec l'application. 
Par exemple, vous pouvez avoir une page pour afficher la liste des tournois, une autre pour afficher les détails d'un tournoi spécifique, une autre pour permettre aux utilisateurs de s'inscrire en tant que joueurs, etc.
Testez votre application pour vous assurer qu'elle fonctionne correctement.
10:18
Dispose d’un menu contextuel