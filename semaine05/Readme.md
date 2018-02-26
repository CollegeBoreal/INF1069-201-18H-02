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
