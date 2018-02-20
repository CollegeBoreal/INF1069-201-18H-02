***Question1:*** importez les fichiers suivants dans mongo IndiaStates.json et cityInspections.json

Expliquez les commandes suivantes 
```
db.IndiaStates.aggregate({
    $project:{state:1, _id:0}
  })
  
db.IndiaStates.aggregate(
    [
        {$match: { "info.capital": { $exists: true}}},
        {$project:{"state":1, "_id":0}}
    ]
)
```
