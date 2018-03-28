### Le but de ce projet est d'analyser les données avec les fonctions map-reduce. ###

Le jeu de données se trouve sur le site suivant :  http://media.mongodb.org/zips.json. 

Tout d'abord, sauvegarder les données avec l'extension ***json*** tout en les nommant ***mapreduce***. Ensuite, importer ces données dans mongo et nommer la collection ***mapreduce*** lors de l'importation.


Voici la description des champs : 

Le champ _id contient le zip code des villes. 

Le champ city contient le nom des villes.

Le champ state contient les deux premières lettres des states.

Le champ pop est la population de la ville.

Le champ loc est la position géographique de la ville (latittude et longitude).

#############################################################################

Ce projet sera structuré comme suit :

***a)*** Explication des codes correspondant aux questions 

***b)*** Affichage des sorties partielles et leurs interprétations selon les questions

***c)*** Une annexe avec tous les codes et toutes les sorties par ordre des questions 

###############################################################################

#### Question 1 ####

Quels sont les Etats (***state***) qui ont une population (***pop***) de plus de 5 millions ?

#### Question 2 ####

Quelle est la population moyenne des villes par Etat (***state***) ?

#### Question 3 ####

Quelles sont les plus petites et les plus grandes villes (***city***) dans chaque Etat (***state***) ?



