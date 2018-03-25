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

