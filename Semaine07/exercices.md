Importez d'abord les fichiers ou documents json ci-dessous : 

```
 mongoimport --db semaine10 --collection mapreduceBooks --type json --drop  --file mapreduceBooks.json
 mongoimport --db semaine10 --collection cityInspections --type json --drop  --file cityInspections.json
```
Les collections mapreduceBooks et cityInspections seront utilisées respectivement pour les questions 1 et 2, et 3 et 4.

### Question 1 ###

Compter les livres par auteur.

### Question 2 ### 

Compter le prix moyen du livre par l'éditeur.

### Question 3 ### 

Trouvez le mois ayant le plus de réussite ("No Violation Issued") et le mois ayant le moins de réussite ("Violation Issued").

### Question 4 ###

Trouvez la ville la plus inspectée et la ville la moins inspectée.

[solutions](https://github.com/CollegeBoreal/INF1069-201-18H-02/blob/master/Semaine07/solutions.md)
