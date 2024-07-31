/*
 * steps to create an application:
 * 
 * 
 * create model package
 * create a model, it will be a POJO class
 * for example CustomerModel
 * 
 * 
 * create dao package
 * create an interface which will extend to CrudRepository,
 * for example ICustomerDao
 * 
 * 
 * create service package
 * create an interface with methods,
 * for example ICustomerService with getCustomers or registerCustomer methods
 * 
 * create a service class which will implement ICustomerService
 * use @Service annotation
 * for example CustomerService
 * write implementation and override method which was written in ICustomerService
 * while implementing method, also call Jpa methods
 * 
 * 
 * create controller package
 * create a controller 
 * use @Controller annotation
 * for example CustomerController
 * call ICustomerService and invoke methods to get data
 * use @GetMapping annotation
 * and pass data to jsp using model / map / any other way
 * 
 * 
 * create views folder under webapp under main under src
 * collect data sent by controller in JSP
 * page should display already registered user and a button should be there so
 * user can click and re-direct to register page
 * 
 * 
 * open respective controller in browser
 * 
 * 
 * create JSP under views with name of registerCustomer
 * user clicked on button and went to registerCustomer URL
 * 
 * 
 * open ICustomerService and add a method named registerCustomer
 * open customerService and add its implementation and call dao save method from Jpa
 * open controller and modify registerCustomer route logic so that
 * it should display registration page
 * create form with submit action in registerCustomer jsp page
 * action in form should be registerSuccess so that it should route to registerSuccess,
 * which has been created under controller and it will call registerCustomer from 
 * customerService and it will also route to registerSuccess page
 * 
 * 
 * display message at registerSuccess and add a button so that user can click and
 * view the details
 * 
 * 
 * now lets add update and delete button against each record
 * 
 * 
 * add updateCustomer and deleteCustomer in ICustomerService interface
 * add implementation of updateCustomer and deleteCustomer in CustomerService
 * create controller to handle request and pass id from jsp to controller to handle actions.
 */