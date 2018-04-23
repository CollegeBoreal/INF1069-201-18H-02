### SPARK ###

Dans cette section, nous allons creer une application ***Spark*** avec ***Scala*** en utilisant ***IntelliJ***. 

1) Ouvrez et creez un nouveau projet avec ***IntelliJ*** (***File -> New Project***)

2) Cliquez sur ***Maven*** dans le menu de gauche et selectionnez ***scala-archetype-simple*** .

3) Remplissez les champs suivants : 

   ***GroupId: com.collegeboreal***
   ***ArtifactId: FirstsparkExample***
 
4) Dans le fichier ***pom.xml***, ajoutons les dependencies de ***Spark*** and ***Scala*** afin d'importer leurs packages dans le bon 
   fonctionnement des codes ***Scala*** dans ***IntelliJ*** . Nous avons sur le site de apache Spark pour telecharger les dependencies : https://mvnrepository.com/artifact/org.apache.spark.
   
  ```
  <dependencies>

  
   <dependency>
  <groupId>org.scala-tools</groupId>
  <artifactId>maven-scala-plugin</artifactId>
  <version>2.11</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.spark/spark-core -->
<dependency>
    <groupId>org.apache.spark</groupId>
    <artifactId>spark-core_2.11</artifactId>
    <version>2.3.0</version>
</dependency>

</dependencies>

  ```
   
   
   
