/*
 * JPARepository extends pagingandsortingRepository extends crudRepository extends Repository
 * 
 * Persistence means storing data
 * Persistence store means, a place where we store data, DBMS and files
 * Persistence operators means, CRUD - Insert, update, delete and retrieve
 * Persistence logic means, JDBC, Hibernate, Spring Data
 * 
 * JDBC -> Java
 * ORM -> Hibernate
 * Spring JDBC -> 
 * Spring Data JPA -> Spring JDBC
 * Spring ORM -> Spring with ORM, means Spring with Hibernate, ORM means Hibernate JPA
 * 
 * Dao layer or Repository layer -> we maintain separate layer for any persistence logic
 * For every table, dedicated Dao class must be there for mapping purpose like Entity annotation
 * If we have 500 table, then 500 classes should be there, this is called single responsibility principle
 * 
 * Direct implementation or code to interface -> we should always choose code to interface, not direct implementation.,
 * we should create interface and classes to implement interface
 * 
 * table and column name must be less than 30 character, if it is going beyond 30 then vowels can be missed like
 * CREDIT_CARD_NUMBER can be written as CRDT_CRD_NMBR.
 * 
 * Spring Data JPA provides two major interfaces, CRUD repository and JPA repository
 * CRUD repository -> all methods related to CRUD and custom operations
 * JPA repository -> CRUD operation, pagination, sorting and custom operations
 * 
 * parent of all the interface in JPA is Repository, it is a marker interface
 * 
 * CRUD has 11 or 12 methods
 * pagination and sorting has 2 methods
 * JPA Repository has 14 or 15 methods
 * 
 * Spring ORM is combination of spring and ORM -> Spring ORM will use Hibernate -> Hibernate use JDBC ->
 * JDBC will connect with DB
 */


/*
 * Dependencies ->
 * Spring Data JPA
 * MySQL Driver
 * Lombok
 * 
 * crudRepository extends Repository
 */


/*
 * Dependencies ->
 * Spring Data JPA
 * MySQL Driver
 * Lombok
 * 
 * pagingandsortingRepository extends crudRepository extends Repository
 */


/*
 * Dependencies ->
 * Spring Data JPA
 * MySQL Driver
 * Lombok
 * 
 * JPARepository extends pagingandsortingRepository extends crudRepository extends Repository
 */



/*
 * for 
 */

//************************************
List<String> list = new ArrayList<>();
list.add("mango");
list.add("orange");
list.add("Grapes");
System.out.println(list);
        
Set<String> set = new HashSet<String>();
set.add("mango");
set.add("orange");
set.add("Grapes");
System.out.println(set);
        
Map<Integer, String> map1 = new HashMap<Integer, String>();
map1.put(100, "Amit");
map1.put(101, "Vijay");
map1.put(102, "Rahul");
System.out.println(map1);
        
Map<String, String> map2 = new HashMap<String, String>();
map2.put("hi", "Amit");
map2.put("bi", "Vijay");
System.out.println(map2);
//*************************************

Distributed Applications - application which communicates with other applications, for
example, payment gateway on any website.

Restful  - 100% inter-operatibility and xml and json both optin are available


