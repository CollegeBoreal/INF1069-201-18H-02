***Question 1 :***

Affiche les etats de l'Inde.

Affiche les etats de l'Inde qui ont une capitale.

***Question 2 :***

```
db.IndiaStates.aggregate({$match: {"state": /PUNJAB/i}}).pretty()
```
***Question 3 :***

```
db.IndiaStates.aggregate(
	{$project: {"cities": 1, "_id": 0}},
	{$unwind: "$cities"},
	{$project: {"firstLetter": {$substr: ["$cities", 0, 1]}}},
	{$group: {"_id": {"firstLetter": "$firstLetter"}, "count": {$sum: 1}}},
	{$sort: {"count": -1}},
	{$limit: 3}
).pretty()
```
{$substr: ["$cities", 0, 1]} retourne la premiere lettre de chaque ville.

***Question 4:***

Cette commande retourne l'etat le moins large

```
db.IndiaStates.aggregate(
	{
		$match: {"info.area": {$exists: true}}
	},
	{
		$group:
		{
			"_id": {"state": "$state"},
			"minArea": { $min: "$info.area" }			
		}
	},
	{$sort: {"minArea": 1}},
	{$limit: 1}
).pretty()
```

"$info.area" permet de recuperer les superficies (area)  dans le champ info et { $min: "$info.area" } retourne la superficie minimale parmi les superficies des villes. 


***Question 5 :***

```
db.cityInspections.aggregate(
[    
    {
        $project:
        {   
            "issue_date": "$issue_date",
            "issue_year": {$year: "$issue_date"},
            "issue_month": {$month: "$issue_date"}
        }
    },
    {
        $match: 
        {
            "issue_year": 2015
        }
    },
    {
        $group: 
        {       
            "_id": {"issue_month": "$issue_month"}, "count": {$sum: 1}
        }
    }, 
    {
        $sort: {"_id.issue_month": 1}
    }
]).pretty()
```

***Question 6 :***

```
db.cityInspections.aggregate(
[    
    {
        $match: 
        {
            $and: 
			[
                {"result": {"$exists": true}},
                {"result": "Pass"},
                {"issue_date": {"$exists": true}},
                {"issue_date": {$gte: ISODate('2015-01-01'), $lt: ISODate('2016-01-01')}}
            ]
        }
    },
    {
        $project:
        {   
            "issue_month": {$month: "$issue_date"}
        }
    },
    {
        $group: 
        {       
            "_id": {"issue_month": "$issue_month"}, "count": {$sum: 1}
        }
    }, 
    {
        $sort: {"count": -1}
    }
]).pretty()
```

***Question 7 :***

```
db.cityInspections.aggregate(
[
	{
		$match: 
		{
            $and: 
			[
                {"address.city": {"$exists": true}},
                {"address.city": {$ne: ""}}
            ]
		}
	},
    {
        $project:
        {
            "city": {$toLower: "$address.city"}
        }
    },
    {
        $group: 
        {       
            "_id": {"city": "$city"}, "count": {$sum: 1}
        }
    },
    {
        $sort: {"count": -1}
    },
    {
    	$limit: 1
    }
]).pretty()
```
***Question 9 :***

```
db.cityInspections.aggregate(
[
    {
        $match:
        {
			$and: 
			[
				{"address.city": {"$exists": 1}}, 
				{"address.city": {"$ne": ""}},
				{"sector": {"$exists": 1}},
				{"sector": {"$ne": ""}}
			]
            
        }
    },
    {
        $project:
        {
            "city": {"$toLower": "$address.city"},
            "sector": {"$toLower": "$sector"}
        }
    },
    {
        $group: 
        {       
            "_id": {"city": "$city", "sector":"$sector"}, "count": {$sum:1}
        }
    },
    {
        $sort: {"_id.city": 1, "_id.sector": 1}
    }
]).pretty()
```

[exercices](https://github.com/CollegeBoreal/INF1069-201-18H-02/blob/master/semaine04/exercices.md)
