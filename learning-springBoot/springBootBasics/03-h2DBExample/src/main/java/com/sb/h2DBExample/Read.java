/*
 * dependencies =>
 * Spring Data JPA
 * Spring Web
 * H2 Database
 * 
 * @Component
 * We can use @Component across the application to mark the 
 * beans as Spring’s managed components.
 * 
 * @Repository
 * job is to catch persistence-specific exceptions and re-throw them as one of 
 * Spring’s unified unchecked exceptions
 * 
 * @Service
 * We mark beans with @Service to indicate that they’re holding the business logic. 
 * 
 * @Entity
 * Entities in JPA are nothing but POJOs representing data that can be 
 * persisted in the database.
 */