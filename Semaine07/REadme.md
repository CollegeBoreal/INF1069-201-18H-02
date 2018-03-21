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


```
Parameter	Type	Description
map	function	
A JavaScript function that associates or “maps” a value with a key and emits the key and value pair.

See Requirements for the map Function for more information.

reduce	function	
A JavaScript function that “reduces” to a single object all the values associated with a particular key.

See Requirements for the reduce Function for more information.

options	document	A document that specifies additional parameters to db.collection.mapReduce().
bypassDocumentValidation	boolean	
Optional. Enables mapReduce to bypass document validation during the operation. This lets you insert documents that do not meet the validation requirements.
```
