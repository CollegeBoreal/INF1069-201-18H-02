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
