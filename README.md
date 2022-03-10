# Rush Hour

![Firebase](https://img.shields.io/static/v1?style=for-the-badge&message=Firebase&color=222222&logo=Firebase&logoColor=FFCA28&label=)
![Java](https://img.shields.io/static/v1?style=for-the-badge&message=Java&color=007396&logo=Java&logoColor=FFFFFF&label=)
![Android Studio](https://img.shields.io/static/v1?style=for-the-badge&message=Android+Studio&color=222222&logo=Android+Studio&logoColor=3DDC84&label=)
![Android](https://img.shields.io/static/v1?style=for-the-badge&message=Android&color=222222&logo=Android&logoColor=3DDC84&label=)

Rush Hour est une application mobile Android développée en Java s'inspirant de jeu de société <a href="https://www.jeuxetcompagnie.fr/rushhour-jeu-reflexion-a-partir-de-8-ans/#:~:text=R%C3%A8gle%20du%20Rush%20Hour%20%3A%20d%C3%A9placez,voiture%20de%20quitter%20l'embouteillage.&text=Restriction%20%3A%20il%20est%20interdit%20de,les%20camions%20bloquant%20le%20passage.">Rush Hour</a> où le but du jeu est de faire sortir une voiture d'un plateau encombré par d'autres voitures et véhicules.

<img src="https://user-images.githubusercontent.com/74766923/157574874-32629979-9dfe-4b96-80ee-703c87f2db24.jpg"/>

## Sommaire

[Explications](https://github.com/Suna24/Rush_Hour/blob/master/README.md#explications)

[Technologies](https://github.com/Suna24/Rush_Hour/blob/master/README.md#technologies)
- [Java](https://github.com/Suna24/Rush_Hour/blob/master/README.md#java)
- [Firebase](https://github.com/Suna24/Rush_Hour/blob/master/README.md#firebase)
- [GoogleSignIn](https://github.com/Suna24/Rush_Hour/blob/master/README.md#googlesignin)
- [Architecture](https://github.com/Suna24/Rush_Hour/blob/master/README.md#architecture)

[Contributeurs](https://github.com/Suna24/Rush_Hour/blob/master/README.md#contributeurs)

## Explications

Comme expliqué au début du README, ce projet est une version mobile du jeu de société Rush Hour avec diverses fonctionnalités (dont certaines que j'ai ajoutées par rapport au jeu d'origine) :
  - 40 niveaux présentants 4 niveaux de difficultés différents (Débutant, Intermédiaire, Avancé et Expert)
  - Un score symbolisé par un nombre d'étoile obtenable suivant le temps mis pour compléter le niveau
  - Une connexion à votre compte google pour sauvegarder vos scores
  - Une page des meilleurs scores parmi tous les utilisateurs de l'application
  - Une page pour consulter les règles du jeu
  - Des sons et de la musique pour davantage d'immersion

## Technologies

Pour réaliser ce projet, j'ai utilisé différentes technologies et connaissances que j'ai pu acquérir au cours de ma formation et que je vous détaille juste ci-dessous.

### Java

Cette application mobile est entièrement développée avec le langage de programmation Java et le SDK d'Android. J'ai travaillé avec l'environnement de développement Android Studio dans sa dernière version (BumbleBee).

### Firebase

Afin de stocker les scores des utilisateurs, deux choix s'offraient à moi. D'une part stocker les scores en local dans un fichier et de l'autre héberger les données sur Firebase (je vous invite à aller consulter mon portfolio juste <a href="https://bastientarot.works/generic.html#0">ici<a> pour plus de détails et la veille technologique que j'ai pu faire entre ces deux solutions. 
J'ai donc hébergé les données des joueurs sur Firebase et je peux y accéder en tout temps via des requêtes implémentées dans le SDK d'Android. Je mets également à jour ces données lorsqu'un joueur termine un niveau qu'il n'a pas fini ou qu'il améliore son temps pour le faire.

### GoogleSignIn
  
Rush Hour présente également la possibilité à l'utilisateur de se connecter en utilisant son compte Google. Cela est rendu possible grâce à l'utilisation de l'API Google est plus particulièrement de ``com.google.android.gms`` qui me permet de proposer à l'utilisateur de se connecter rien qu'en cliquant sur un bouton

### Architecture
  
L'architecture de l'application est basée sur un modèle MVC (Model, View, Controller) où on retrouve : 
- Dans le Model, les classes métiers comme ``Car``, ``Level``, ``Truck`` ou encore ``Player`` qui me permettent de matérialiser mes objets et de faire appel à des méthodes spécifiques dans chacune des classes pour rendre le code plus simple, plus facile et réutilisable.
  
- Dans la View, toutes les interfaces utilisateurs générées à l'aide de fichiers XML. Les différentes pages de l'application sont 
  * Une page d'accueil
  * Une page de règles du jeu
  * Une page des meilleurs scores 
  * Une page répertoriant les 40 niveaux
  * Une page permettant de jouer au niveau sélectionné
  
- Enfin, dans le Controller, sont présents les ``Activity``, il y a un controller par page de l'application, et ces controllers permettent de faire le lien entre tout ce qui concerne les interfaces (présentes dans le package View) et tous les objets et classes métiers (contenus dans le package Model).

## Contributeurs

Bastien TAROT (Suna24)

Merci également à mon professeur
- Simon Sébastien
