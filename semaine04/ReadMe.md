## Les requêtes agregées ##

MongDB propose un framework d'agrégation permettant de recueillir l'information souhaitée. Celui-ci permet aussi de manipuler et 
d'analyser les données. MongoDB propose trois méthodes pour utiliser le framework d'agrégation :
***1) le pipeline d'agrégation***
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
 
 
 https://docs.mongodb.com/manual/reference/method/db.collection.group/

 ***3)  le MapReduce***
 




