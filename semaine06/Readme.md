### Modelisation des donnees ###

La modelisation des donnees consiste a recuperer et analyser les donnees. Le principal défi de la modélisation des données dans MongoDB est de prendre efficacement en charge les besoins de l'application. Il y a deux façons qui permettent aux applications de relier les documents : ***references*** et ***embedded documents***.

https://docs.mongodb.com/manual/core/data-model-design/

### References ###

Normalized data models describe relationships using references between documents.

<img src="/https://github.com/CollegeBoreal/INF1069-201-18H-02/blob/master/semaine06/data-model-normalized.png" />



### Embedded documents ###

With MongoDB, you may embed related data in a single structure or document. These schema are generally known as “denormalized” models, and take advantage of MongoDB’s rich documents.

![alt text](https://github.com/CollegeBoreal/INF1069-201-18H-02/blob/master/semaine06/datamodeldenormalized.png)
