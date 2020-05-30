# Présentation de l'application
Créateur de l'application : Issam Zeggaï Groupe 32 Classe 3A UFA
___________________________________________________________________________________________________________________________________________
Dans le cadre du module de Programmation Mobile, vous trouverez dans ce repository un exemple d'application codé en Java sous Android Studio.

Le but de cette application est de permettre un listing exhaustif des Champions du jeu crée par Riot Games®,
du nom de League of Legends™ avec une courte description du Champion, ainsi que ses statistiques de base.

L'ensemble des données sont affichés dans un RecyclerView faisant appel à un RestApi (ou Appel Serveur), permettant de display les données de
chaque champion (leurs icones, leurs descriptions, le type de champion, ainsi que leurs statistiques).

# Descriptif technique de l'application :
- L'application a été developpé sous une Architecture dite MVC (Model View Controller).
- L'application possède 3 écrans (une HomePage, la liste des Champions de LoL, ainsi que la page descriptives / statisticielles de chaque champion).
- L'application possède également une fonction de Memory Cache, permettant un loading plus intuitif des informations.
- Respect du Gitflow avec différenciation des différentes branches entre Master, Design et Developp.

# Home Page :

La HomePage contient une image en background du Champion "Kayn" avec un button permettant d'aller directement à la liste d'affichage
des Champions.


![Screen](https://i.imgur.com/jCozoZx.png)

# Liste des Champions :

La page d'affichage de la Liste des Champions est un affichage permettant le display de l'ensemble des Champions de League of Legends :

![Screen](https://i.imgur.com/pMXJppE.png)

# Description & Statistique de chaque Champion

Cette page permet un affichage des statistiques de chaque champion par type avec leur icône et leur description :

![Screen](https://i.imgur.com/ABRigEL.png)






