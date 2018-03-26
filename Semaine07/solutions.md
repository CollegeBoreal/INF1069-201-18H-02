### Question 1 ###

```
 function mapb() {
		for (var index = 0; index < this.authors.length; ++index) {
			var author = this.authors[index];
			emit(author.firstName + " " + author.lastName, 1);
		}
	};
  
 function reduceb(key, values){
		count = 0;
		for (var index = 0; index < values.length; ++index) {
			count += values[index];
		}		
		return count;
	};
db.mapreduceBooks.mapReduce( mapb, reduceb,{query: { $and: 
			[
				{"authors.firstName": {"$exists": true}},
				{"authors.lastName": {"$exists": true}},
				{"authors.firstName": {$ne: ""}},
				{"authors.lastName": {$ne: ""}}
			]
		}, 
    out: {replace: "question1"}
	}
)
```

### Question 2 ###

```
function mapp() {
        emit( this.publisher, { count: 1, price: this.price } );
    };

function reducep(key, values) {
        var value = { count: 0, price: 0 };

        for (var index = 0; index < values.length; ++index) {
            value.count += values[index].count;
            value.price += values[index].price;
        }
        return value;
    };
    
db.mapreduceBooks.mapReduce(mapp, reducep, {   
        scope: { currency: "US" },
        query:  
		{
			$and: 
			[
				{"publisher": {"$exists": true}},
				{"publisher": {$ne: ""}}
			]
		},
	out: { replace: "question2" },
        finalize: 
            function(key, value) {
                value.average = currency + ( value.price / value.count ).toFixed(2);
                return value;
            }
    }
)
```

L'option scope permet de rendre le champ currency global i.e. on peut l'appeler ou le faire référence dans les functions map, reduce et 
finalize.

toFixed(2) dans JavaScipt permet de limiter les résultats des sorties à 2 chiffres après la virgule.

### Question 3 ###

```
db.cityInspections.mapReduce(
	function() {
		var m = this.issue_date.getMonth()+1;
        emit( m, 1 );
    },
	function(key, values) {
		count = 0;
		for (var index = 0; index < values.length; ++index) {
			count += values[index];
		}
		return count;
    },
    {
		query:  
		{
			$and: 
			[
				{"result": {"$exists": true}},
				{"result": "Pass"},
				{"issue_date": {"$exists": true}}
			]
		},
		out: {replace: "question3"}
	}
)

db.question3.find({}).sort({"value":-1}).limit(5)
```

getMonth() dans JavaScript (js) retourne le mois sous forme numérique (entre 0 et 11). Donc on ajoute 1 à getMonth() ( getMont() + 1 ) pour extraire le mois exact.

### Question 4 ###

```
db.cityInspections.mapReduce(
	function() {
        emit( this.address.city.toUpperCase(), 1 );
    },
	function(key, values) {
		count = 0;
		for (var index = 0; index < values.length; ++index) {
			count += values[index];
		}
		return count;
    },
    {
		query:
		{
			$and: 
			[
				{"address.city": {"$exists": true}},
				{"address.city": {$ne: ""}}
			]
		},
		out: {replace: "question4"}
	}
)

db.question4.find({}).sort({"value":-1}).limit(5)
```

toUpperCase et toLowerCase dans JavaScript changent respectivement les string, les caractères en majuscule et minuscule.


[exercices](https://github.com/CollegeBoreal/INF1069-201-18H-02/blob/master/Semaine07/exercices.md)
