


/*
 * for web programming, servlet is very imp, on top of servlet, 
 * spring MVC or spring web MVC has been created to develop web based applications.
 * 
 * we based application means Internet application.
 * 
 * spring web MVC has been developed based on two designs
 * 1. MVC design pattern
 * 2. front controller design pattern
 * 
 * model and view can't interact directly
 * 
 * spring MVC has below compounds.
 * 1. front controller - dispatcher servlet
 * 2. handler mapper
 * 3. controller
 * 4. model and view object
 * 5. view resolver
 * 6. view
 * 
 * DispatcherServlet is  Pre-defined class in Spring MVC module acting as FrontController.
 * DS will receive Incoming HTTP Request.
 * DS will send the Requested URL to HandlerMpper.
 * HM will identify which Controller will handle the request and give back Controller details to DS. 
 * DS will now call respective Controller. 
 * Controller will process the request and will return ModelAndView object to DS model.
 * model means data.
 * view means logical file name. 
 * DS now call ViewResolver based view name received from Controller.
 * VR will identify extension and view location and this info will be sent to DS.
 * DS will send Model data to view component.
 * Model data will be rendered and will be sent back to DS.
 * DS will response back to client with client understandable format view page.
 */


/*
 * In Spring MVC or Spring Boot MVC the FrontController is DispatcherServlet i.e. DS which is ready made ServletComponent. 
 * All the activities in Spring MVC takes place under the control or monitoring of DS Component.
 * 
 * Approach to develop Web-app with Spring MVC Module:
 * 1. Declarative Cfgs Approach (XML driven cfgs) ==> with web.xml file, we configure DS
 * 2. Annotation Cfgs Approach (XML + Annotation driven cfgs) ==> In user defined class, with @Configuration, we configure DS
 * 3. Spring Boot MVC Apps
 * 
 * While building Spring MVC or Spring Boot MVC Apps, we need to use the following annotations while developing handler classes:
 * 1. @Controller ==> To make java class as SpringBean + handler / controller class
 * 2. @RequestMapping => To mark java method of @Controller class as handler method having request path
 * 
 * HTTP Methods ==> GET, POST, PUT, DELETE
 * 
 * Spring 4.x > 
 * To bind our method to GET Request @GetMapping
 * To bind our method to POST Request @PostMapping
 * To bind our method to Put Request @PutMapping
 * To bind our method to Delete Request @DeleteMapping
 * All this can also managed by @RequestMapping("/", method=RequestMethod.GET)
 * 
 * Method will be binded to Get request by default if we have not specified method attribute with @RequestMapping
 * 
 * HandlerMapping ==> This component takes the incoming request through DispatcherServlet and maps the 
 * request with appropriate handler method of appropriate handler / controller class by matching the incoming 
 * URL path with handler request method
 * Handler mapper will identify which controller will handle the request and give back Controller details to DS
 * All HandlerMapping components are the classes implementing org.springframework.web.servlet.HandlerMapping(1)
 * 
 * Generally we work with ready made "HandlerMapping" components
 * 
 * ControllerClassHandlerMapping
 * SimpleUrlHandlerMapping
 * 
 * ViewResolver:  ==> This component takes the received logicalViewName with physical view component and 
 * returns View Object having the name and location of physical view component back to DS.
 * view Resolver will identify extension and view location and, this info will be sent to DS
 * ViewResolver Components are the classes that implements an interface called "org.springframework.web.servlet.ViewResolver(I)"
 * 
 * Generally we work with ready made "ViewResolver" components UrlBasedViewResolver
 * Generally we work with ready made "ViewResolver" components
 * 
 * UrlBasedViewResolver
 * InternalResourceViewResolver(default in SpringBoot)
 * XmlViewResolver
 * 
 * Al tool for eclipse. "Codium Al"
 * 
 * InternalViewResolver is capable of taking to jsp, html or any servlet component placed in private area of view component through html.
 * jsp components are not configured in "urlpatttern".
 * 
 * Outside of WEB-INF area is called public area of web application, the request to these components can 
 * be given directly without giving mapping details to ServletContainer.
 * Inside WEB-INF area is called private area of web application, the request to private are components must 
 * be given only after giving mapping details to ServletContainer.
 * 
 * Helps to hide technology of the web application because the jsp files names does not appear in the request url's, so many things does not 
 * appear in the browser address bars. This helps to protect app's source code of jsp files / components will be protected from outsider
 * 
 * InternalResourceViewResolver needs 3 details to locate view components or jsp components 
 * 1. location of view components - prefix info
 * 2. extension of view component--> suffix info 
 * Logical view name(file name)
 * 
 * spring.mvc.view.prefix=/WEB-INF/views/
 * spring.mvc.view.suffix=.jsp
 * 
 * In SpringBoot-MVC App's the following components comes automatically so we need not develop them 
 * 1. DispatcherServlet
 * 2. IOC-Container
 * 3. HandlerMapping
 * 4. ViewResolver
 * 
 * To get all these we need to go for a starter file called "spring boot-starter-web"
 * SpringBoot MVC can be developed as Stand alone web-app or deployable web application in web / Application server Server.
 * SpringBoot MVC Stand alone web application means nothing but web application that uses "tomcat embeded server" so 
 * no need of arranging any external server explicitly [Good in development, testing environment]
 * 
 * This application comes as a jar file, here SpringApplication.run() itself creates tomcat embeded server along 
 * with IOC container creation and DispatcherServlet Registration, no need of sepearte ServletInitializer class.
 * 
 * Spring Boot MVC deployable web application is nothing but web application that is deployable in any web server as normal war file
 * Separate ServletInitializer class is required extending from SpringBootServlet Initializer to create IOCcontainer and register DispatcherServlet dynamically
 * 
 * While creating Spring boot mvc project, if we select the type as "war", then the starter files will create 2 java files Main 
 * class cum Configuration class having @SpringBootApplication
 * The main() class is not required if we are running our App as Deployable web application using External Tomcat / any other server
 * 
 * ServletInitializer extending SpringBootServletInitializer
 * This class is not required if we are running our application as stand alone web application using embedded server
 */


/*
 * To get all these we need to go for a starter file called "spring boot-starter-web"
 * SpringBoot MVC can be developed as Stand alone web-app or deployable web application in web / Application server Server.
 * SpringBoot MVC Stand alone web application means nothing but web application that uses "tomcat embeded server" so 
 * no need of arranging any external server explicitly [Good in development, testing environment]
 * 
 * This application comes as a jar file, here SpringApplication.run() itself creates tomcat embeded server along 
 * with IOC container creation and DispatcherServlet Registration, no need of sepearte ServletInitializer class.
 * 
 * Spring Boot MVC deployable web application is nothing but web application that is deployable in any web server as normal war file
 * Separate ServletInitializer class is required extending from SpringBootServlet Initializer to create IOCcontainer and register DispatcherServlet dynamically
 * 
 * While creating Spring boot mvc project, if we select the type as "war", then the starter files will create 2 java files Main 
 * class cum Configuration class having @SpringBootApplication
 * The main() class is not required if we are running our App as Deployable web application using External Tomcat / any other server
 * 
 * ServletInitializer extending SpringBootServletInitializer
 * This class is not required if we are running our application as stand alone web application using embedded server
 */


/*
 * ﻿Data Rendering -> The process of giving the Controller generated/gathered data/result after executing Business methods or logic 
 * to the view components, that can be called as Data Rendering (Sending the data from Controller to view)
 * 
 * Data Binding -> The process of writing the input values (Form data / request parameter data) to java class, can be called as 
 * Data Binding (View to Controller)
 * 
 * Binding the data from view component to controller in the form of java class.
 */


/*
 * ﻿Multiple Controllers can be created in one Web App.
 * In One Controller we can have multiple Controller methods.
 * Every Controller can map class level URL pattern.
 * We can map method level url pattern for every Controller methods.
 * All methods url pattern must be unique.
 * 
 * When We run the Spring boot app then it will be deployed in Embedded Server Container which is Apache Tomcat.
 * If we run the Spring boot web app then embedded server will start and once we stop the application then server also will be stopped.
 * In embedded server container one application will be deployed as for ever new application it will have its own embedded server.
 * 
 * Spring boot web app will be deployed in embedded container in 8080 port number by default however, if we have oracle db in 
 * our system we need to change port number by adding server.port property in application.properties file to run the app in 
 * diff port num, we can add server.port in our properties file.
 * 
 * Default context path for spring boot web app is empty. However we can add the context path of our app by adding property 
 * server.servlet.context-path=/AppName
 * 
 * Sending Data from Controller to View / UI :
 * We can create ModelAndView and Add model data, logical view name and return that MAV object to View/UI.
 * We can have only Model object and add model data into it and return will be only logical view name.
 * We can add model data in the form of Map and return logical view name.
 * We can add model data in map and we can return Map as well.
 * We can add model data in Model object and Map both in key value pair.
 * We can get the model data in view file with the help of key.
 */

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

/*
 * Micro-services
 * 
 * 
 * Monolithic application -
 * All the functionalities of an application are developed and packaged into a single project.
 * The entire app is typically packaged as JAR/WAR file and deployed to the server.
 * 
 * Advantages of monolithic app -
 * simple to develop, easy to start and develop
 * everything is at one place, say to manage
 * single configuration.
 * 
 * Disadvantages of monolithic app -
 * As project grows, hard to maintenance 
 * In case of any small change, testing, packaging and deployment of whole application is needed.
 * Failure at one point can disrupt whole application.
 * 
 * Micro-services architecture -
 * 
 */

