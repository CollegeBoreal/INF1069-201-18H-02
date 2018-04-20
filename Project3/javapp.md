Ce projet consiste a mettre en pratique une application Java avec MongoDB.

On considere la collection suivante (mycollection) : 

```
db.mycollection.insert([
{Username:"Paul",Country:"Australia", Education:"Master's degree"},
{Username:"Pierre", age:22, 
                              Country:"Canada", 
                              Hobbies:{ sports :["soccer","basketball"],
                                        movies :["seven pounds","Time out"]}
                              }])

```

a)  Ajouter le Baseball comme sport à tous les utilisateurs dont le pays est Australia.

b) Supprimer tous les movies de Pierre.

c) Supprimer tous les documents sans supprimer la collection.


Referrez-vous au code Java qui se trouve dans le lien ci-dessous pour repondre aux questions ci-dessus :



