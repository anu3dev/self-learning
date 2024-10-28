/*
 * Persistence -> storing data
 * Persistence store -> a place where we store data, DBMS and files
 * Persistence operators -> CRUD - Insert, update, delete and retrieve
 * Persistence logic -> JDBC, Hibernate, Spring Data
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
 * parent for these are repository -> CRUD repository -> pagination and sorting -> JPA repository
 * 
 */