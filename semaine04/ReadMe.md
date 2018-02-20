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
$match
L'opération $match filtre les documents correspondant aux critères de recherche.
Example : on veut regrouper tous les documents dont l'age est superieur a 17 selon le lieu d'embarquement et le sexe.
```
db.titanic.aggregate(
  [
    { $match : { age : { $gt : 17 } } },
    { $group : { _id : { sexe: "$sex", embarked: "$embarked"} , count : { $sum: 1 } } }
  ]).pretty()
  ```
$limit 

Quant a l'operation $limit, elle permet de limiter le nombre de documents a afficher.
```
db.titanic.aggregate(
  [
    { $match : { age : { $gt : 17 } } },
    { $group : { _id : { sexe: "$sex", embarked: "$embarked"} , count : { $sum: 1 } } },
    {$limit:10}
  ]).pretty()
  ```
  
  $skip
  
L'operation $skip saute le nombre de documents specifie .
```
db.titanic.aggregate(
  [
    { $match : { age : { $gt : 17 } } },
    { $group : { _id : { sexe: "$sex", embarked: "$embarked"} , count : { $sum: 1 } } },
    {$skip:10}
  ]).pretty()
  ```
  
 $sort
 
  Permet de trier les documents par ordre croissant en specifiant 1 devant le champ qu'on veut trier et -1 par ordre décroissant.
  
  ```
db.titanic.aggregate(
  [
    { $match : { age : { $gt : 17 } } },
    { $group : { _id : { sexe: "$sex", embarked: "$embarked"} , count : { $sum: 1 } } },
    {$sort:{_id:1}},
    {$limit:10}
  ]).pretty()
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

 ***3)  le MapReduce*** sera expliqué et détaillé dans l'une des prochaines séances
 




