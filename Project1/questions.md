### L'objectif de ce projet est de manipuler et d'analyser les données de vols (flights) en utilisant les fonctions d'agrégation et les indexes de MongoDB. ###

Importer le jeu de données ***flights*** dans MongoDB et assigner le nom ***flights*** à la collection ainsi créée. 

La description des champs se trouvent dans le lien suivant : 

https://www.transtats.bts.gov/DL_SelectFields.asp?Table_ID=236

### Question 1 ###

On suppose que les retards des arrivees (***ARR_DELAY*** dans la collection flights) sont les retards consideres pour les questions ci-dessous. Donc on s'interesse a la moyenne des retards des arrivees. 

Quel est le meilleur moment du jour pour voler afin de minimiser les retards ? (***ARR_TIME_BLK***: les horaires d'arrivee des avions en intervalle et ***ARR_DELAY*** sont les champs qu'il faut utiliser pour repondre a cette question)

Quel est le meilleur moment de la semaine pour voler afin de minimiser les retards ? (***DAY_OF_WEEK*** et ***ARR_DELAY***)

Quel est le meilleur moment de l'année pour voler afin de minimiser les retards ? (***QUATER*** et ***ARR_DELAY***)

### Question 2 ###

Quels types d'avions accusent le plus de retards ? (***UNIQUE_CARRIER*** : identifiant des avions et ***DEP_DELAY***)

### Question 3 ###

Quel est le pire Etat (state) connu pour les retards ? (***ORIGIN_STATE_NM*** et ***DEP_DELAY***)

### Question 4 ###

Exécute cette syntaxe dans mongo :

```
db.flights.aggregate(
    {"$match" : {"ARR_DELAY" : {"$gt" : 0}, "DEP_DELAY" : {"$lte" : 0}}} 
    , {"$group" : {"_id" : "$ORIGIN_STATE_NM", "FL_NUM" : {"$sum" : 1}}}
    , {"$sort" : {"FL_NUM" : -1}}
    , {"$limit" : 5}
);
```

Créer un index composé sur les champs ***ARR_DELAY*** et ***DEP_DELAY*** ({ARR_DELAY : -1, DEP_DELAY : -1}). 

Ensuite, tapez cette commande :

```
db.flights.aggregate(
    {"$match" : {"ARR_DELAY" : {"$gt" : 0}, "DEP_DELAY" : {"$lte" : 0}}} 
    , {"$group" : {"_id" : "$ORIGIN_STATE_NM", "FL_NUM" : {"$sum" : 1}}}
    , {"$sort" : {"FL_NUM" : -1}}
    , {"$limit" : 5}
);
```

Que constatez-vous ?


