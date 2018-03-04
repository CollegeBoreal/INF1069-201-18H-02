# L'objectif de ce projet est de manipuler et d'analyser les données de vols (flights) en utilisant les fonctions d'agrégation et les indexes de MongDB. #

Importer le jeu de données flights dans MongoDB.

### Question 1 ###

Quel est le meilleur moment du jour / de la semaine / de l'année pour voler afin de minimiser les retards ?

### Question 2 ###

Quels types d'avions accusent le plus de retards ? 


### Question 3 ###

À quelle fréquence un retard intervient-il dans d'autres retards de vol?

### Question 4 ###

Quel a été l'effet de l'ouragan Sandy sur le transport aérien à New York? Avec quelle rapidité l'état est-il redevenu normal?

### Question 5 ###

Exécute cette syntaxe dans mongo :

```
db.flights.aggregate(
    {"$match" : {"ARR_DELAY" : {"$gt" : 0}, "DEP_DELAY" : {"$lte" : 0}}} 
    , {"$group" : {"_id" : "$ORIGIN_STATE_NM", "FL_NUM" : {"$sum" : 1}}}
    , {"$sort" : {"FL_NUM" : -1}}
    , {"$limit" : 5}
);
```

Créer un index composé sur les champs ARR_DELAY et dep_Delay ({ARR_DELAY : -1, DEP_DELAY : -1}). 

Ensuite, tapez cette commande :

```
db.flights.aggregate(
    {"$match" : {"ARR_DELAY" : {"$gt" : 0}, "DEP_DELAY" : {"$lte" : 0}}} 
    , {"$group" : {"_id" : "$ORIGIN_STATE_NM", "FL_NUM" : {"$sum" : 1}}}
    , {"$sort" : {"FL_NUM" : -1}}
    , {"$limit" : 5}
);
```
Que constatez ?
