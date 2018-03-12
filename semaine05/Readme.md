## Gestion des index ##

Les index permettent d'optimiser les requêtes les plus fréquentes. L'accès aux documents indexés est ainsi plus rapide.

Un index peut être créé sur n'importe quel attribut de vos documents. Sans index, MongoDB doit à chaque requête (execution) parcourir toute la collection. Il y a plusieurs types d'index parmi lesquels nous avons : simple, composé, géospatial, unique ou encore associé à un tableau, etc...

### Create an index ### 

Pour créer un index, on utilise la procédure suivante :

```
db.collection.createIndex( <key and index type specification>, <options> )
db.collection.ensureIndex(index, options)
```
Par défaut, un index dans MongoDB est positionné sur le champ _id.

L'exemple suivant crée un index ascendant à clé unique dans le champ name :

```
db.titanic.createIndex( { name: 1 } )
```
Pour afficher tous les index de la collection titanic, on execute la syntaxe suivante : 

```
db.titanic.getIndexes()
```

Pour supprimer un index :

```
db.collection.dropIndex(name)
```

https://docs.mongodb.com/manual/core/index-single/

### Indexes composés ###

Pour créer un indexe composé, on utilise la syntaxe suivante :
```
db.collection.createIndex( { "champ1": 1, "champ2": 1 } )
```
où chanp1 et champ2 désignent les champs sur lesquels on veut indexer.

### Text Indexes ###


```
db.reviews.createIndex( { comments: "text" } )
```

### Unique Index on a single field ###

L'unique indexe sur un seul champ permet d'assurer que les champs indexes n'ont pas de valeus dupliquées.

```
db.Collection.createIndex( { "champ": 1 }, { unique: true } )
```
### Unique Compound Index ###

L'unique indexe sur plusieurs champs permet d'assurer l'unicité des valeurs dans les champs indexés.

```
db.Collection.createIndex( { "Champ1": 1, "champ2": 1, "champ3": 1 }, { unique: true } )
```
où chanp1, champ2 et champ3 désignent les champs sur lesquels on veut indexer.

### Sparse indexes ###

Sparse indexes contiennent uniquement des données pour les documents contenant le champ indexé.

Example : 
```
db.Collection.createIndex( { "champ": 1 }, { sparse: true } )
```
https://docs.mongodb.com/manual/core/index-sparse/


On peut aussi combiner ces deux proprietés en créant un indexe i.e. la contrainte de l'unicité (unique) et le filtre Sparse. 

```
db.Collection.createIndex( { "champ": 1 } , { sparse: true, unique: true } )
```

La syntaxe ci-dessus rassure l'unicité des valeurs du champ indexé et applique le filtre sur les documents.

Example : On insere quelques documents dans la collecion grade.
```
db.grade.insert(
                { "_id" : ObjectId("523b6e32fb408eea0eec2647"), "name" : "Jack","grade":95 },
                { "_id" : ObjectId("523b6e61fb408eea0eec2648"), "name" : "John", "grade" : 85 },
                 { "_id" : ObjectId("523b6e6ffb408eea0eec2649"), "name" : "Robert", "grade" : 90 }
                )
```
On cree un indexe sur le champ grade avec la contrainte d'unicite et du filtre sparse
```
db.grade.createIndex( { grade: 1 } , { sparse: true, unique: true } )
```
Cette commande permet d'inserer des documents qui des valeurs uniques dans le champ grade.

```
db.grade.insert( {"name" : "Celine","grade":92 } )
db.grade.insert( { "name" : "Mat","grade":80} )
```
Avec la syntaxe ci-dessous, l'indexe ne sera pas crée vu que la valeur du grade (92) existe deja. 
```
db.grade.insert( {"name" : "Celine","grade":92 } )
```

