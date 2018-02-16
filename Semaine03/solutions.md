
**Question 1 :** ``` 
            db.books.find({"categories":"Internet"}).count()
               db.books.find({"categories":{$ne:"Internet"}}).count() ```
             
**Question 2 :** ``` 
           var nbCount = db.books.find({}).count()
             db.books.find({}).skip(nbCount-3) ```
             
**Question 3 :** 
           ``` 
           db.books.find({"publishedDate": {$lt: ISODate("2010-01-01")}}).pretty() ```

**Question 4 :**  
            ```
            db.books.find({publishedDate:{$exists:true}},{"_id":0, "title":1, "isbn":1, "authors":1}).sort({"_id":1}).limit(5).pretty()               
            ```

**Question 5 :**  
                 ``` 
                      db.books.find({status : {$ne:"PUBLISH"}}).count()
                                                                         ```

**Question 6 :**  
                  ``` 
                     db.books.find({}).sort({"_id":1}).skip(20).limit(5).pretty()
                                                                                 ```

**Question 7 :**  
                  ``` 
                  db.books.find({$or:[{categories: "Networking"}, {status:{$ne:"PUBLISH"}}]}).count() ```

[exercices](https://github.com/CollegeBoreal/INF1069-201-18H-02/blob/master/Semaine03/exercices.md)

