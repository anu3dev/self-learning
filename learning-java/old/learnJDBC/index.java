/*
 * Data - information about any real world object, eg: car, bike, teacher etc.
 * 
 * Database - collection of data grouped at one place in strucured way like player has id, name, age, city etc.
 * 
 * DBMS - database management software.
 * It ia a technique to store data in a secure way, from where it can be easily accessible.
 * Benifits of DBMS are like: 
 * Security and safety.
 * Managing, storing and retrivving is easy.
 * Can maintain large volume of data easily.
 * 
 * DBMS of two types, relational or structured - (SQL) and non-relational or unstructured - (NoSQL).
 * 
 * relational DB - Oracle, MySQL, Postgresql, MariaDB etc.
 * non-relational DB - MongoDB, Redis, Casendra, Firebase etc.
 */ 

/*
 * Using SQL, we can work with DB but SQL was developed in nineties and focus was much on memory saving,
 * not on speed but, in the world of social media, we want data as fast as possible and here SQL lags,
 * then NoSql DB came into picture like MongoDB, Redis, Casendra etc.
 * 
 * NoSql doesn't mean no Sql, it means not only SQL, means it will have some query language to fetch data,
 * like casendra has CQL, Casendra query language.
 * 
 * One thing noSql provides is scalability means you can store data at distributed locations,
 * and user can access it based on their locations but little problem here is with syncing,
 * here noSQL DB takes a bit to update at every location and here cap's theorm comes into picture.
 * Cap's stands for conditioning, availabilty and partitioning.
 * 
 * Any DB can have either of two featurs from CAP's theorm like,
 * sql is a relational DB and it is consistant and available but not partitioned bcos it can't be distributed.
 * nosql is available and partitoned but not consistant bcos if you update data at one location, won't be consistant.
 * 
 * Casendra provides consistancy but not 100%.
 * 
 * Seletion of DB depends on usage, like speed is imp for social platforms, consistancy we can ignore a bit,
 * but in banking or healthcare, consistancy is more imp than speed.
 * 
 * Now Distributed SQL comes into picture, companies goes to noSql from Sql, they are coming to Distributed Sql.
 */

/*
 * There are few design patterns to develop applications, one of them is MVC pattern.
 * MVC means model, view and controller.
 * 
 * Model is responsible for database operations using Java files for data related operations.
 * View is responsible to create view for frontend using languages like HTML, JSP, React etc.
 * Controller will manage or process the application using Servlet.
 * 
 * Model and View shouldn't interact directly, Controller will enable the communication between View and Model.
 */

 /* 
 * JDBC - java database connectivity, it is a kind of API given by java team to work with DB.
 * To interact with DBMS, java team provided a .jar file named rt.jar, it is already installed as part of JDK.
 * To use rt.jar, we have to use packages called java.sql or javax.sql.
 * 
 * Java provided generic classes to all DB vendors and asked them to do the implementation.
 * We can use these implementations through interface and abstract methods.
 * 
 * For implimentation of interface's abstract methods of java SQL package we need to take help of DB vendors.
 * Each DB has its own implementations, they have done it and provided the implimentations 
 * by compiling all as .class file and provided as .jar file ie: java archieve file
 * Depending on DB, we need to add .jar to the project, also called as DB driver.
 */

/*
 * Steps to be followed for JDBC operation.
 * Download driver or .jar from respective vendor portal.
 * Import driver to project.
 * Establish connection.
 * Create / prepare statement to transfer the query.
 * Execute query and process the result.
 * Closing the resources.
 * 
 * One more step needs to be taken care, handling the exception.
 */

/*
 * statement - define the methods and properties that enable you to send SQL commands and receive/send data from/to your database. 
 * pre-statement - interface of statement, this can called as pre-compiled query, and it is high performance as compared to statement.
 * in case of pre-statement, query is incomplete and value will be injected at run time, values will be injected using setXXX(int pos, YYY value)
 */

/*
 * executeQuery() => select => used for data retrival => return type is ResultSet
 * executeUpdate() => non-select => used for insert, update and delete => return type is int (no of rows affected)
 * execute() => select or non-select used for all ops => => return type is boolean. if true, return ResultSet =>  PreparedStatement.getResultSet(), if false, 
 * return int (no of rows affected) => PreparedStatement.getUpdateCount()
 * executeBatch()
 */

/*
 * while working with database, we perform CRUD operation.
 * C => create (insert)
 * R => read (select)
 * U => update
 * D => delete
