### Gestion de Performance ###

Pour evaluer la performance d'une requete avec mongoDB, on utilise la fonction ***explain()***. Sans argument, la fonction renvoie la  requête qui va être exécutée. Avec true comme argument, la fonction renvoie également des informations sur l’exécution de la requête.

```
db.collection.find().count().explain()

```


