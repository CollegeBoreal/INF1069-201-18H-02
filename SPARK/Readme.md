### SPARK ###

Dans cette section, nous allons creer une application ***Spark*** avec ***Scala*** en utilisant ***IntelliJ***, qui permet 
de compter le nombre d'occurences de mots dans un document. Nous la nommera ***Wordcount***.

Pour se faire, creons un nouveau projet et configurons ***IntelliJ*** avec ***Spark*** pour ecrire les programmes ***Scala*** . 

1) Ouvrez et creez un nouveau projet avec ***IntelliJ*** (***File -> New Project***)

2) Cliquez sur ***Maven*** dans le menu de gauche et selectionnez ***scala-archetype-simple*** .

3) Remplissez les champs suivants : 

   ***GroupId: com.collegeboreal***
   
   ***ArtifactId: FirstsparkExample***
 
4) L'etape de configuration : 

   Dans le fichier ***pom.xml***, ajoutons les dependencies de ***Spark*** et ***Scala*** afin d'importer leurs packages pour le bon 
   fonctionnement des codes ***Scala*** dans ***IntelliJ*** . Nous avons sur le site de apache Spark pour telecharger les dependencies :    https://mvnrepository.com/artifact/org.apache.spark.
   
  ```
  <dependencies>

  
   <dependency>
  <groupId>org.scala-tools</groupId>
  <artifactId>maven-scala-plugin</artifactId>
  <version>2.11.8</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.spark/spark-core -->
<dependency>
    <groupId>org.apache.spark</groupId>
    <artifactId>spark-core_2.11</artifactId>
    <version>2.3.0</version>
</dependency>

</dependencies>

  ```
   
    L'etape de configuration etant terminee, creons le code ***Scala*** :
 
5)  Clique-droit sur ***FirstsparkExample***, selectionnez ***Scala class*** (changez ***kind*** en ***Object***) et   
    
    ***Name ->   WordCount***. 

    Cliquez sur ***OK*** 

6)  Copiez ce code dans la fenetre ***WordCount*** : 

   ```
   package com.myCompany.scala
   
   import org.apache.spark.SparkContext
   import org.apache.spark.SparkConf
   
   object WordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("Word Count")
      .setSparkHome("src/main/resources")
    val sc = new SparkContext(conf)
    val input = sc.textFile("src/main/resources/input.txt")
    val count = input.flatMap(line ⇒ line.split(" "))
      .map(word ⇒ (word, 1))
      .reduceByKey(_ + _)
    count.saveAsTextFile("src/main/resources/outfile")
    println("OK")
  }
}
   
   ```
7) Appuyez sur ***Run*** et plusieurs fichiers seront crees comme resultats de la compilation.


https://stackoverflow.com/questions/46009602/running-a-spark-word-count-in-intellij




   
