### Map-Reduce ###
Map-reduce permet de faire le traitement de données pour condenser de gros volumes de données en résultats agrégés.

https://docs.mongodb.com/v3.2/core/map-reduce/

La syntaxe de la methode Map-Reduce est la suivante :

```
db.collection.mapReduce(
                         <map>,
                         <reduce>,
                         {
                           out: <collection>,
                           query: <document>,
                           sort: <document>,
                           limit: <number>,
                           finalize: <function>,
                           scope: <document>,
                           jsMode: <boolean>,
                           verbose: <boolean>,
                           bypassDocumentValidation: <boolean>
                         }
                       )
```

