
### Spark SQL ###

Apres avoir configure ***Spark*** et ***Scala***, et toutes leurs ***dependencies*** sur ***IntelliJ***, illustrons un example d' application de ***Spark SQL***.

Considerons l'example de ***Employees.json*** pour la pratique de ***Spark Sql***

```
{
   {"id" : "1201", "name" : "Alex", "age" : "25"}
   {"id" : "1202", "name" : "Marwa", "age" : "28"}
   {"id" : "1203", "name" : "Denis", "age" : "39"}
   {"id" : "1204", "name" : "Chris", "age" : "23"}
   {"id" : "1205", "name" : "John", "age" : "23"}
}

```

On execute ce code dans ***IntelliJ*** :

```

import org.apache.spark.sql.SparkSession

object SparkSQLRunner {
  def main(args: Array[String]) {
    // setup SparkSession instance
    val spark = SparkSession
      .builder()
      .appName("SparkSQL For Csv")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    // Read json file
    val df = spark.read.json("C:/spark/examples/src/main/resources/Employees.json")
    //Display the content of the DataFrame 
    df.show()
    
    //Display only the "name" column
    df.select("name").show()
    
    //Select and display both columns "name" and "age"
    df.select($"name", $"age").show()
    
    //Select everybody's name and increment their age by 1
    df.select($"name", $"age" + 1).show()
    
    // Select and display people older than 21
    df.filter($"age" > 21).show()
    
    // Count and display people by age 
    df.groupBy("age").count().show()

    // Example of SQL
    // Register the DataFrame as a SQL temporary view
    df.createOrReplaceTempView("employees")

    val sqlDF = spark.sql("SELECT * FROM employees")
    sqlDF.show()


  }
}

```

https://spark.apache.org/docs/latest/sql-programming-guide.html


