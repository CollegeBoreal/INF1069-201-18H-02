## Les requêtes agregées ##

MongDB propose un framework d'agrégation permettant de recueillir l'information souhaitée. Celui-ci permet aussi de manipuler et 
d'analyser les données. MongoDB propose trois méthodes pour utiliser le framework d'agrégation :

***1) le pipeline d'agrégation***

https://docs.mongodb.com/manual/aggregation/

 ***2) les fonctions dédiées :***
 
 Les fonctions dédiées aussi appelées opérations d'agregation regroupent des documents d'une collection selon l'opération spécifiée.
 ```
 db.collection.count() retourne le nombre de documents selon le critère défini
 ```
 Example : cette commande retourne le nombre de femmes dans la collection titanic.
 ```
 db.titanic.count({sex:"female"}) 
 ```
 Si on souhaite afficher les catégories de livres publiés sans doublons, on execute cette commande : 
 ```
 db.books.distinct('categories', {"status" : "PUBLISH"})
 ```
 Pour regouper les documents selon un ou plusieurs critères, on utilise la fonction group() : 
 ```
 db.collection.group({ key, reduce, initial [, keyf] [, cond] [, finalize] })
 ```
 Cette commande compte le nombre de livres par status :
  ```
 db.books.group ({
    key: {status : true},
    initial: {total : 0},
    reduce :  function (items,prev) {
                prev.total += 1
              }
})
```
 
 https://docs.mongodb.com/manual/reference/method/db.collection.group/

 ***3)  le MapReduce***
 




