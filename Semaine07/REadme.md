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
                         }
                       )
```

| Parametres | types | Description |
| --- | --- | --- |
| map | function | A JavaScript function that associates or “maps” a value with a key and emits the key and value pair. |
| reduce | function | A JavaScript function that “reduces” to a single object all the values associated with a particular key. |
| options | document | A document that specifies additional parameters to db.collection.mapReduce(). |


| Champs | types | Description |
| --- | --- | --- |
| out | document or string | Specifies the location of the result of the map-reduce operation. You can output to a collection, output to a collection with an action, or output inline. You may output to a collection when performing map-reduce operations on the primary members of the set; on secondary members you may only use the inline output.|
| query	| document	| Specifies the selection criteria using query operators for determining the documents input to the map function.|
| sort	| document |	Sorts the input documents. This option is useful for optimization. For example, specify the sort key to be the same as the emit key so that there are fewer reduce operations. The sort key must be in an existing index for this collection.
|limit	| number |	Specifies a maximum number of documents for the input into the map function.|
| finalize |	function	| Optional. Follows the reduce method and modifies the output.|
|scope	| document|	Specifies global variables that are accessible in the map, reduce and finalize functions.|
|jsMode |	boolean	| Specifies whether to convert intermediate data into BSON format between the execution of the map and reduce functions.Defaults to false.|
|   |   | *If false:* Internally, MongoDB converts the JavaScript objects emitted by the map function to BSON objects. These BSON objects are then converted back to JavaScript objects when calling the reduce function.The map-reduce operation places the intermediate BSON objects in temporary, on-disk storage. This allows the map-reduce operation to execute over arbitrarily large data sets.|
|   |    | *If true:* Internally, the JavaScript objects emitted during map function remain as JavaScript objects. There is no need to convert the objects for the reduce function, which can result in faster execution. You can only use jsMode for result sets with fewer than 500,000 distinct key arguments to the mapper’s emit() function.|
| verbose	| boolean	| Specifies whether to include the timing information in the result information. Set verbose to true to include the timing information. Defaults to false.|

