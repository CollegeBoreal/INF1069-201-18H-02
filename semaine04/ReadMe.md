## Les requêtes agregées ##

MongDB propose un framework d'agrégation permettant de recueillir l'information souhaitée. Celui-ci permet aussi de manipuler et 
d'analyser les données. MongoDB propose trois méthodes pour utiliser le framework d'agrégation :

***1) le pipeline d'agrégation***

Le pipeline d'agrégation est un framework permettant d'enchainer des actions pour transformer et traiter des requêtes spécifiques.
```
db.collection.aggregate({pipeline document})
```
$group

L'opération $group permet de grouper les documents dans une collection selon certains critères spécifiques et d'effectuer quelques opérations d'agrégation telles que le comptage, la sommation, etc...

Pour regrouper les documents selon le lieu d'embarquement : 
```
db.titanic.aggregate({$group:{_id:"$embarked"}}).pretty()
```
Pour compter le nombre de personnes dans chaque document regroupé selon le lieu d'embarquement : 
```
db.titanic.aggregate({$group:{_id:"$embarked",count:{$sum:1}}}).pretty()
```

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
 Cette commande compte le nombre de personnes selon le lieu d'embarquement:
  ```
 db.titanic.group ({
    key: {embarked : 1},
    initial: {total : 0},
    reduce :  function (items,prev) {
                prev.total += 1
              }
})
```

Cette autre commande retourne le nombre de personnes selon le lieu d'embarquement (ici "S") et le sexe :

  ```
 db.titanic.group ({
    key: {embarked : 1,sex:1},
    cond :{embarked :"S"},
    initial: {total : 0},
    reduce :  function (items,prev) {
                prev.total += 1
              }
})
``` 
 https://docs.mongodb.com/manual/reference/method/db.collection.group/

 ***3)  le MapReduce*** sera expliqué et détaillé dans les prochaines séances
 




