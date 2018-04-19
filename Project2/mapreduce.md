### Le but de ce projet est d'analyser les données avec les fonctions map-reduce. ###


Le jeu de données se trouve sur le site suivant :  http://media.mongodb.org/zips.json. 


Tout d'abord, sauvegarder les données avec l'extension ***json*** tout en les nommant ***mapreduce***. Ensuite, importer ces données

dans mongo et nommer la collection ***mapreduce*** lors de l'importation.


Voici la description des champs : 

Le champ ****_id**** contient le zip code des villes. 

Le champ ****city**** contient le nom des villes.

Le champ ****state**** contient les deux premières lettres des states.

Le champ ****pop**** est la population de la ville.

Le champ ****loc**** est la position géographique de la ville (latittude et longitude).

##########################################################################

Ce projet sera structuré comme suit :

***a)*** Explication des codes correspondant aux questions 

***b)*** Affichage des sorties partielles et leurs interprétations selon les questions

***c)*** Une annexe avec tous les codes et toutes les sorties par ordre des questions 

###########################################################################


#### Question 1 ####

Quels sont les Etats (***state***) qui ont une population (***pop***) de plus de 5 millions ?

#### Question 2 ####

Quelle est la population moyenne des villes par Etat (***state***) ?

#### Question 3 ####

Quelles sont les villes (***city***) les plus peuplées et les moins peuplées dans chaque Etat (***state***) ?


```
function map(){
emit({state:this.state},{min:{pop:this.pop,city:this.city},max:{pop:this.pop,city:this.city}});
};

function reduce(key, values){
var resultat=values[0];
for(var i=1;i<values.length;i++){
if(values[i].min.pop<resultat.min.pop)
resultat.min=values[i].min;
if(values[i].max.pop>resultat.max.pop)
resultat.max=values[i].max;
}
return resultat;
};

db.test.mapReduce(map,reduce,{out:"question3"});
db.question3.find().pretty();

ou 

db.test.mapReduce(map,reduce,{out:{inline:true}}); 

// Pour afficher en ligne de commande les sorties sans creer de output 

```
ou encore 

```
function map(){

// on declare une variable m contenant la population et les villes pour alleger le code

var m={pop:this.pop,city:this.city};

// on desire comme output les Etats ainsi que les minimums et les maximums des populations des villes dans chaque Etat

emit({state:this.state},{min:m,max:m});
};

function reduce(key, values){

//on initialise la variable a la premiere valeur de values qui est la premiere population 

var resultat=values[0];

// ce bout de code retourne le minimum et le maximum des populations

for(var i=1;i<values.length;i++){
if(values[i].min.pop<resultat.min.pop)
resultat.min=values[i].min;
if(values[i].max.pop>resultat.max.pop)
resultat.max=values[i].max;
}
return resultat;
};

db.test.mapReduce(map,reduce,{out:"question3"});
db.question3.find().pretty();

```



