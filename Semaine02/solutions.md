Q1: 
```
db.mycollection.insert({Username:"Paul",Country:"Australia", Education:"Master's degree"})
```
Q2 : 
```
db.mycollection.update({Username:"Paul"},{$set:{age:20}})
```
Q3 : 
```
db.mycollection.insert({Username:"Pierre", age:22, 
                              Country:"Canada", 
                              Hobbies:{ sports :["soccer","basketball"],
                                        voyages :["Paris","New yor city"]}
                              })
```
Q4 : 
```
db.mycollection.update({Username:"Pierre"},{$unset:{age:1}})
```
Q5: 
```
db.mycollection.update({Username:"Pierre"},{$set:{"Hobbies.sports":["soccer","basketball","volleyball"]}})
``` 
ou encore

```
db.mycollection.update({Username:"Pierre"},{$addToSet:{"Hobbies.sports":"volleyball"}})
```
Q6 : 
```
db.mycollection.update({Country:"Australia"},{$set:{sports:"Baseball"}})
```
Q7 : 
```
db.mycollection.update({Username:"Pierre"},{$unset:{"Hobbies.voyages":1}})
```
Q8:
```
mongoexport -db INF1069 --collection mycollection --out mycollection.bak.json
```
Q9:  
```
db.mycollection.remove({})
```
Q10: 
```
mongoimport --port 27017 --db semaine02 -collection mycollection --drop --type json --file mycollection.json
```
Q11: 
```
mongoimport --port 27017 --db semaine02 -c customer --drop --type csv --file customers.csv --headerline
mongoimport --port 27017 --db semaine02 -c product --drop --type csv --file products.csv --headerline
```  
Q12: 
```
db.product.find().count()
      db.product.update( {},
                        {$set: { "OriginalCountry": "", "Description": ""}},
                         {upsert: false, multi: true}
                         )
```
Q13: 
```
db.product.find({"CategoryID" : 2}).count()
     db.product.update(
    {"CategoryID" : 2},
    {$inc: { UnitPrice: 5 }},
    {upsert: false, multi: true}
                        )    
```
Q14: 
```
db.product.find({"SupplierID" : 2}).count()
     db.product.find({"SupplierID" : 2}).pretty()
     db.product.update({"SupplierID" : 2},
     {$set: { OriginalCountry: "Canada" }},
     {upsert: false, multi: true}
                       )

 db.product.find({"SupplierID" : 1}).count()
 db.product.find({"SupplierID" : 1}).pretty()
 db.product.update({"SupplierID" : 1},
    {$set: { OriginalCountry: "USA" }},
    {upsert: false, multi: true}
                  )
 ```
 
 [exercices](https://github.com/CollegeBoreal/INF1069-201-18H-02/edit/master/Semaine02/exercices.md)
 
                  
