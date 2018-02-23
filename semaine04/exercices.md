***Question 1 :*** Importez les fichiers suivants dans mongo : IndiaStates.json et cityInspections.json

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
***Question 2***

Comment réécrire la commande suivante en utilisant les fonctions d'agrégation.
```
db.IndiaStates.find({"state":/PUNJAB/i})
```

***Question 3***

Dans votre collection IndiaStates, vous avez une liste des villes. Vous devez trouver le nombre de villes regroupées par la première lettre d'alphabet du nom et trouver les trois premiers alphabets les plus courants des villes.

***Question 4***

Trouvez l'état le plus large et l'état le moins large.

***Question 5***

Trouvez le nombre d'inspections par mois en 2015. Présentez le résulat mensuel par ordre croissant.

***Question 6***

Trouvez le mois ayant le plus de réussite ("Pass") et le mois ayant le moins de réussite.

***Question 7***

Trouvez la ville la plus inspectée et la ville la moins inspectée.

***Question 8***

Trouvez le pourcentage des avertissements (Warning).

***Question 9***

Présentez pour chaque ville, la somme des inspections par secteur.

[solutions](https://github.com/CollegeBoreal/INF1069-201-18H-02/blob/master/semaine04/solutions.md)
