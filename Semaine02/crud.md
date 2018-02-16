L'opération CRUD (Create Read Update Delete) dans MongoDB

Dans ce cours, nous abordérons comment insérer, modifier et supprimer un document.

1) Pour insérer un document dans mongo, on suit l'instruction suivante : 

a) On se connecte à la base de donnees qu'on souhaite insérer les documents en utilisant la commande suivante : 

 use nom_bd (nom_bd est le nom de la base de donnees qu'on veut se connecter)
 
b) Ensuite, on execute cette commande : 
```
db.collection.insert(nom_du_document) 
```

où collection est le nom de la collection et nom_du_document est le document qu'on veut insérer dans la collection.

Example : document={ "Nom": "Chris",
                     "Prenom": "Beauchamps", 
                     "Profession": "Footballeur",
                     "Age":26 
                     }
```		     
db.collection.insert(document)
```
Pour afficher le contenu du document, on tape la commande suivante :
```
db.collection.find().pretty()
```
On peut aussi insérer un document directement sans faire appel à une variable c'est-à-dire :
```
db.collection.insert({ "Nom": "Chris",
                     "Prenom": "Beauchamps", 
                     "Profession": "Footballeur",
                     "Age":26 
                     })
db.collection.find().pretty()
```
On peut également insérer plusieurs documents à la fois en suivant l'instruction ci-dessous :
```
document1={"Nom":"Blondy","Prénom":"Alpha","Album":"Rendez-vous"}
document2={"Nom":"Marley","Prénom":"Bob","Status":"Mort","Album":"Live"}
db.collection.insert([document1,document2]) 
db.collection.insert([document1,document2],{ writeConcern: { w: "majority", wtimeout: 5000 }, ordered:true }) 
```
ou insérer directement les contenus des documents 
```
db.collection.insert([{"Nom":"Blondy","Prénom":"Alpha","Album":"Rendez-vous"},
                     {"Nom":"Marley","Prénom":"Bob","Status":"Mort","Album":"Live"}])
db.collection.find().pretty()
```
2) Le schema suivant permet de modifier les documents d'une collection :
```
db.collection.update(requete, modifier, options) 
```
où  est requete est le critere de selection des donnees pour la modification, 
modifier est la modification qu'on veut apporter au document et 
options permet de spécifier les options les plus utilisées (upsert et multi)
upsert permet de créer un nouveau document lorsqu'il y a aucun document correspondant à la requete.
multi met à jour plusieurs documents lorsque sa valeur est true. Par defaut, sa valeur est false et met à jour un seul document.
```
db.collection.drop()
 document1 = {
			"PatientId" : 1, 
			"Hospital" : 'JGH', 
			"Department" : 'Urology'
		}
 db.collection.insert(document1)
 db.collection.find().pretty()
 ```
On peut aussi déclarer une liste d'éléments dans les champs d'un document : 
```
document2 = {
			"PatientId" : 1, 
			"Hospital" : 'JGH', 
			"Department" : 'Urology',
			"City": ['Toronto', 'London','Kingston']
		}
 db.collection.insert(document2)
 db.collection.find().pretty()

 document2 = {
			"PatientId" : 1, 
			"Hospital" : 'JGH', 
			"Department" : 'Urology',
			"City": [ {"Toronto Population": 6000000},
			{"GTA": ["Durham, Halton,Peel,York"]}
			]
		}
 db.collection.insert(document2)
 db.collection.find().pretty()
 ```
 ```
db.collection.update(
	{ 
		PatientId: 1
	},
	{
			"PatientId" : 1, 
			"Hospital" : 'JGH', 
			"Department" : 'Pharmacy'
	}
)
db.collection.find().pretty()
```
Un cas où on utilise les options upsert et multi : 
```
db.collection.update(
	{ 
		"Hospital" : 'JGH'
	},
	{
	$set : {		
			"Hospital" : 'JGH', 
			"Department" : 'Microbiology',
			"City":'Toronto',
			"Province":'Ontario'
	     }, $inc:{"PatientId" : 2}
	},
	{upsert : true, multi : true}
)

db.collection.find().pretty()
```
Les opérateurs suivants inc, set, unset et addToSet permettent respectivement d'incrémenter une valeur, de changer le contenu d'un champ, de supprimer un champ 
et d'ajouter les données dans un tableau.

3) Cette section permet de supprimer les documents et la collection
```
db.collection.remove(critere, justOne)
```
où critere désigne les documents qu'on veut supprimer de la collection et 
justOne (1 ou true) permet de supprimer un seul document correspondant au critère.
```
 document1 = {
			"PatientId" : 1, 
			"Hospital" : 'JGH', 
			"Department" : 'Urology'
		}
 db.collection.insert(document1)
 db.collection.find().pretty()
 
  document2 = {
			"PatientId" : 2, 
			"Hospital" : 'JGH', 
			"Department" : 'Microbiology'
		}
 db.collection.insert(document2)
 db.collection.find().pretty()

db.collection.remove({PatientId : 1}, {justOne:true})
db.collection.find().pretty()
```
Pour supprimer tous les documents d'une collection : 
```
db.collection.remove({})
```
Cette commande permet de supprimer une collection :
```
db.collection.drop()
```
Enfin, pour supprimer une base de donnees, on tape la commande suivante : 
```
db.dropDatabase()
```

