# eAlbum - Application React avec Redux et Side Effects
### Objectifs
Appréhender le fonctionnement des side effects de Redux, de l'utilisation des Thunks dans le cadre d'une application Front-end reliée à une base de données Firebase

### Sujet
Réaliser une application React permettant à des utilisateurs de manipuler des albums de musique. L'application possèdera un mode connecté et un mode déconnecté.

Dans le cadre de l'utilisation de l'application en tant que personne deconnectée, il sera possible uniquement de consulter les albums et de les trier par titre, score et si possible d'autre critères tels que la date de sortie de l'album.

Dans le cadre d'une utilisation en tant qu'utilisateur connecté, il sera possible de manipuler les données stockées sur Firebase en pouvant éditer, supprimer oui ajouter des albums de musique. Les albums contiendront comme informations leur **titre**, leur **date de sortie**, leur **artiste**, une **image de couverture**, un **score allant de 1 à 5** et si possible d'autres informations laissées au choix du stagiaire.

```ts
interface Album {
  id?: string;
  title: string;
  releaseDate: string;
  artist: string;
  score: number;
  coverURL: string;
}
```

Pour vous loguer à Firebase, il sera idéal de passer par l'utilisation sous forme d'API REST de l'Authentification Firebase, disponible à [cette adresse](https://firebase.google.com/docs/reference/rest/auth?hl=fr). La sécurisation de vos informations de connexion Firebase passera par un JSON de règles de la base de données dont la structure sera la suivante :

```json
{
  "rules": {
    ".read": true,
    ".write": "auth != null"
  }
}
```

Les données nécessaire seront également placées dans un fichier à part qui sera ajouté au fichier `.gitignore` dans le but d'éviter de partager votre clé API sur Git.

Au niveau de l'interface, les manipulations de formulaire passeront par l'apparition d'un modal, qui se fera à la racine de votre body via l'utilisation de la fonction `createPortal()` offerte par **React-DOM** et seront idéalement des formulaires uniques (c'est à dire qu'il vous faudra user d'un composant de formulaire pour le logging ou l'enregistrement, et d'un composant pour les 3 manipulations d'albums que sont l'édition, la suppression et l'ajout). Pour ce faire, pensez à utiliser les props et n'oubvliez pas l'utilisation de la syntaxe d'appel de composant sous la forme `<Nom Composant>Ceci ira dans 'props.children'</Nom Composant>`.

---

![example](./example.png)