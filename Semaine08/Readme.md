## Développement en Java avec MongoDB ##

Setting Up the Environment
Download Java SE Development Kit 8 Downloads

http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Get IntelliJ IDEA

https://www.jetbrains.com/idea/#chooseYourEdition


### Creating, Running and Packaging your Java Application ###

Le lien ci-dessous permet de configurer et de creer votre premier projet Java dans IntelliJ IDEA

https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html


Ceci etant, creons un projet Maven dans IntelliJ IDEA afin de faire du developpement Java avec MongoDB.

### Creating a Maven Project ###

Ouvrez d'abord Intellij IDEA 

1. Cliquez sur ***Create New Project*** 

2. Selectionnez ***Maven*** par les options se trouvant a gauche 

3. Specifiez le projet SDK (JDK) en utilisant votre propre archetype. Pour nous, ca sera Java ***(Jar)***. Ensuite, cliquez sur next.

4. Specifiez les 3 elements suivants :

   ***GroupId*** - a package of a new project.

   ***ArtifactId*** - a name of your project.

   ***Version*** - a version of a new project. By default, this field is specified automatically.

Ensuite, cliquez sur next.

5. Ajoutez les dépendances necessaires (***Java MongoDB Driver***) au fichier de configuration ***pom.xml***. Pour le faire, on ouvre

d'abord ***pom.xml***, ensuite, on execute la commande suivante : 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	
	<groupId>mongodb.java</groupId>
	<artifactId>MongoDBJava</artifactId>
	<version>1.0.0</version>
	<name>MongoDBJava</name>
	
	<dependencies>
		<dependency>
			<groupId>org.mongodb</groupId>
			<artifactId>mongo-java-driver</artifactId>
			<version>3.4.0</version>
		</dependency>
	</dependencies>
	
</project>
```

 ### Connectez-vous au server MongoDB dans le terminal Windows or MacBook avant d'executer votre code Java ###

Retournez dans Intellij IDEA pour creer un nouveau package ***Java*** appele ***semaine09*** et une nouvelle classe ***Java*** appelee 

***MongoDBConnect***. Pour ce faire, on suit les etapes suivantes :

1. Clique droit sur le nom du projet ***MongoDBJava***, ensuite ***New*** -> ***Package*** -> ***semaine09***.

2. Clique droit sur le nom du projet ***MongoDBJava***, ensuite ***New Java Class*** -> ***MongoDBConnect***.

Completez votre classe par le contenu de ce lien , compilez-la et executez-la en cliquant sur ***Run***.
