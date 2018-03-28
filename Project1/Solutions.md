### Question 1 : ###

Pour répondre à ces questions, nous allons d'abord écrire le code, ensuite interpréter les résultats des sorties de MongoDB :

```
db.flights.aggregate(
    {"$group" : {"_id" :"$ARR_TIME_BLK" , "retards" : {"$avg" : "$ARR_DELAY"}}}
    , {"$sort" : {"retards" : 1}}
);
```
Le meilleur moment du jour pour voyager avec moins de retard est le matin (entre 7h et 9h), tandis qu'on observe plus de retards le soir 
(entre 19h et minuit).

### Question 1 (suite) : ###

```
db.flights.aggregate(
    {"$group" : {"_id" :"$DAY_OF_WEEK" , "retards" : {"$avg" : "$ARR_DELAY"}}}
    , {"$sort" : {"retards" : 1}}
);
```

Le meilleur moment de la semaine pour voyager avec moins de retard ( 2 minutes de retards ) est le mercredi tandis qu'on observe plus de 
retards concernant les arrivées des avions dans les autres jours de la semaine, surtout les lundis et dimanches avec 9 à 10 minutes de retards.


### Question 1 (suite): ###


```
db.flights.aggregate(
    {"$group" : {"_id" :"$QUARTER" , "retards" : {"$avg" : "$ARR_DELAY"}}}
    , {"$sort" : {"retards" : 1}}
);
```
La meilleure période de l'année pour voyager se trouve entre janvier et mars.

### Question 2 : ###


```
db.flights.aggregate(
    {"$group" : {"_id" :"$UNIQUE_CARRIER" , "retards" : {"$avg" : "$DEP_DELAY"}}}
    , {"$sort" : {"retards" : -1}}
);
```

Les types d'avion qui accusent plus de retards concernant les départs sont : Frontiers Airlines et Envoy Air avec respectivement 17 et 16 minutes de retards. Et on 
constate que HA (Hawaiian Airlines) accuse seulement 1 minute de retard pour les départs.

### Question 3 : ###

```
db.flights.aggregate(
    {"$group" : {"_id" :"$ORIGIN_STATE_NM" , "retards" : {"$avg" : "$DEP_DELAY"}}}
    , {"$sort" : {"retards" : -1}}
);
```

Le pire Etat connu pour les retards des départs de vols est le Delaware avec 26 minutes de retards tandis que Alaska accuse moins de 
retard (approximativement 2 minutes).











