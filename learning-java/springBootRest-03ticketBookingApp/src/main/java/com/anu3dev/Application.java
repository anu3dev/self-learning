package com.anu3dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*
 * create spring boot app with below dependencies
 * 
 * Spring Boot DevTools
 * Spring Web
 * Lombok
 * Spring Data JPA 
 * MySQL Driver
 */


/*
 * create mySql table
 * 
 * CREATE TABLE anurag.tourist (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    city varchar(255),
    name varchar(255),
    package_type varchar(255),
    budget varchar(255)
   );
 */


/*
 * create model package and create Tourist pojo class
 * 
 * @data
 * @Entity
 * @Table(name="tableName")
 * @Column(name="columnName")
 * @Id
 * @GeneratedValue(strategy=GenerationType.IDENTITY)
 */


/*
 * create a dao package and create ITouristRepo interface
 */


/*
 * create a service package and create ITouristManagement interface and TouristManagement class.
 * 
 * @Service
 * @Autowired
 * @Override
 */


/*
 * create controller package and create TouristController class
 * 
 * @RestController
 * @RequestMapping
 * @Autowired
 * @PostMapping
 * @getMapping
 */






