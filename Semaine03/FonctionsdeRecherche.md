La fonction find() permet de rechercher et afficher les documents d'une collection.   

db.departments.find()  -> affiche tous les déparments de la collection departments.

https://docs.mongodb.com/manual/reference/method/db.collection.find/

Pour plus de pratique, importons les fichiers csv (titanic, IndiaCitiesPopulation) et json (IndiaStates) dans mongo :
```
mongoimport --port 27017 -d semaine03 -c titanic --drop --type csv --file titanic.csv --headerline
mongoimport --port 27017 -d semaine03 -c cities --drop --type csv --file IndiaCitiesPopulation.csv --headerline
mongoimport --port 27017 -d semaine03 -c states --drop --type json --file IndiaStates.json
```

Pour rechercher et afficher tous les documents de la collection titanic : 
```
db.titanic.find().pretty()
```

On peut aussi restreindre la recherche aux documents ayant le champ male dans la collection titanic : 
```
db.titanic.find({sex: "male"})
```

Restreindre les champs dans la selection des donnees

 Cette commande permet d'afficher tous les documents avec seulement les champs name, sex et le champ _id de la collection titanic 
 ```
 db.titanic.find({}, {name:1, sex:1}) 
 ```

Pour ne pas afficher le champ identifiant (_id), on fait : 
```
db.titanic.find({}, {name:1, sex:1,_id:0}) 
```

Pour acceder aux champs imbriques, aussi appeles nested en anglais, on procede comme suit : 
```
db.collection.find({"nom_du_champ.element_du_champ":"une valeur de l'element du champ"})
```

où nom_du_champ est le champ qu'on souhaite extraire des informations et element du champ est un tableau (array) a plusieurs valeurs.
```
db.states.find({"info.capital":"Mumbai"})
```

# Quelques operateurs de comparaison #

NOT EQUAL ($ne), like ($regrex) , less than ($lt), ess than or equal ($lte), greater than ($gt), greater than or equal ($gte).

La syntaxe pour utiliser les operateurs ci-dessus est la suivante :  
```
{champ:{$operateur:valeur}} 
```

Examples : Afficher tous les hommes (male) de la collection titanic 
```
db.titanic.find({sex:{$ne:"female"}})
```

Avec like : 
```
db.titanic.find({"home.dest":/Montreal/i})
db.titatinac.find({"home.dest":{$regex:/Montreal/i}})
```

La fonction sort() permet de trier les données par ordre croissant en spécifiant le paramètre 1, et -1 par ordre décroissant.
```
db.titanic.find({}, {name:1, sex:1}).sort({name:1,sex:-1})
```

Les fonctions limit() et skip() permettent respectivement de limiter l'affichage des documents de la collection à un nombre spécifié 
et de sauter sur un certain nombre de documents avant d'afficher la collection.
```
db.titanic.find({}, {name:1, sex:1}).sort({name:1,sex:-1}).limit(5)
db.titanic.find({}, {name:1, sex:1}).sort({name:1,sex:-1}).skip(10)
db.titanic.find({}, {name:1, sex:1}).sort({name:1,sex:-1}).skip(5).limit(10)
```
Les opérateurs : include ($in), not include ($nin), all($all) and exclude ($not)
```
db.titanic.find({name:{$in:["Bazzani", "Blank", /Allison/]}}).pretty()
db.titanic.find({sex:{$nin:["male", "female"]}}).count()
db.titanic.find({embarked :{$all:["S"]}}).count()
db.titanic.find({age :{$not:{$gt:25}}}).count()
```
La commande $exists permet de vérifier la présence d'un champ.
```
db.titanic.find({embarked:{$exists:false}}).pretty()
```

Quelques opérateurs logiques avec la fonction recherche ($and), ($or) et ($nor)
```
db.titanic.find({$and:[{sex:"male", embarked:"S"}]}).count()
db.cities.find({$or:[{state:"BIHAR"}, {state:"HARIYANA"}]})
db.cities.find({$nor:[{state:"GUJARAT"}, {state:"HARIYANA"}]})
```
# Les fonctions findOne() and findAndModify #

La fonction findOne() retourne qu'un seul document selon le critère spécifié en arguments.
La syntaxe est la suivante : 
```
db.titanic.findOne({sex:"female"})
```
La fonction findAndModify permet de modifier et retourner un seul document 
```
db.collection.findAndModify({
    query: <document>,
    sort: <document>,
    remove: <boolean>,
    update: <document>,
    new: <boolean>,
    fields: <document>,
    upsert: <boolean>,
})
```
La commande suivante modifie le champ fare, l'incremente de 100 et retourne le premier document trié par ordre croissant :
```
db.titanic.findAndModify({
	query: {sex: "male"},
	sort: {name : 1},
	update: {$inc: {fare: 100}},
	upsert :true,
	new: true,
 fields:{pclass:1,survived:1,name,1,sex:1,age;1,fare:1}
})
```




