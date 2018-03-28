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
où les parametres et les options sont definis ci-dessous :

| Parametres | types | Description |
| --- | --- | --- |
| *map* | function | A JavaScript function that associates or "maps" a value with a key and emits the key and value pair. |
| *reduce* | function | A JavaScript function that “reduces” to a single object all the values associated with a particular key. |
| *options* | document | A document that specifies additional parameters to ***db.collection.mapReduce().*** |

La seule option requise parmi les options est l'option *out*.

| Options | types | Description |
| --- | --- | --- |
| *out* | document or string | Specifies the location of the result of the map-reduce operation. You can output to a collection, output to a collection with an action, or output inline. You may output to a collection when performing map-reduce operations on the primary members of the set; on secondary members you may only use the inline output.|
| *query*	| document	| Specifies the selection criteria using query operators for determining the documents input to the map function.|
| sort	| document |	Sorts the input documents. This option is useful for optimization. For example, specify the sort key to be the same as the emit key so that there are fewer reduce operations. The sort key must be in an existing index for this collection.
| *limit*	| number |	Specifies a maximum number of documents for the input into the map function.|
| *finalize* |	function	| Optional. Follows the reduce method and modifies the output.|
| *scope*	| document|	Specifies global variables that are accessible in the map, reduce and finalize functions.|
| *jsMode* |	boolean	| Specifies whether to convert intermediate data into ***BSON format*** between the execution of the map and reduce functions. Defaults to false.|
|   |   | ***If false:*** Internally, MongoDB converts the JavaScript objects emitted by the map function to ***BSON objects***. These BSON objects are then converted back to JavaScript objects when calling the reduce function.The map-reduce operation places the intermediate BSON objects in temporary, on-disk storage. This allows the map-reduce operation to execute over arbitrarily large data sets.|
|   |    | ***If true:*** Internally, the JavaScript objects emitted during map function remain as JavaScript objects. There is no need to convert the objects for the reduce function, which can result in faster execution. You can only use ***jsMode for result sets with fewer than 500,000 distinct key arguments to the mapper’s emit() function.***|
| *verbose*	| boolean	| Specifies whether to include the timing information in the result information. ***Set verbose to true to include the timing information.*** Defaults to false.|


L'example ci-dessous est un example de l'opération map-reduce i.e. il explique le fonctionnement de l'opération map-reduce.

![alt tag](https://github.com/CollegeBoreal/INF1069-201-18H-02/blob/master/Semaine07/mapreduceexample1.PNG)

![alt tag](https://github.com/CollegeBoreal/INF1069-201-18H-02/blob/master/Semaine07/mapreduceexample2.PNG)

Avec l'opération map-reduce, nous calculerons le nombre d'hommes qui ont embarqué dans Titanic :

```
function mapt(){
emit(this.name, this.sex);
               };

function reducet(key,values){
return Array.sum(values);
                            };

db.titanic.mapReduce(mapt, reducet,
{ 
  query : {sex:"male"},
  out : "total_hommes"
}
                     )
```

Dans cet example, on veut calculer dans chaque classe le total d'hommes et de femmes dans chaque classe qui ont embarque dans Titanic

```
var mapfunction = function() {
	emit({pclass: this.pclass,sex:this.sex}, 1);
};

var reducefunction = function(key, values ) {
	return Array.sum(values);
};

db.titanic.mapReduce(mapfunction,reducefunction,{ 

query : {$and:[{sex:{$ne:""}},{pclass:{$ne:""}}]},

out: "hftotalclass" });
```

La syntaxe ci-dessous retourne le nombre de livres publiés par éditeur et le prix total.

```
function map1(){
emit(this.publisher.name,{p:this.price,count:1});
};

function reduce1(key,values){
var rvalue={p:0,count:0};
for(var i=0;i<values.length;i++){
rvalue.p +=values[i].p;
rvalue.count +=values[i].count;
}
return rvalue;
};

db.mapreduceBooks.mapReduce(map1,reduce1,{out:"mpresult"});

db.mpresult.find().pretty();
```
On peut utiliser la fonction finalize pour calculer le prix moyen des livres par éditeur.

```
 function finalizefunction(key, value) {
	value.avg = value.p/value.count;
	return value;
};

db.mapreduceBooks.mapReduce(map1,reduce1,{ out: "mpresult", finalize : finalizefunction });

db.mpresult.find().pretty();
```

Pour plus d'examples : https://docs.mongodb.com/v3.2/tutorial/map-reduce-examples/.
