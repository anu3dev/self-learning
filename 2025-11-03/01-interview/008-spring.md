###

####
<details>
<summary> 🟩 diff between @Component / @Service / @Repository </summary>

All three are Spring-managed beans — they tell Spring to automatically detect and register the class in the ApplicationContext using component scanning.

- @Repository -> Marks DAO classes that interact with databases.
- @Service -> Marks business logic classes. Helps express “this class contains business rules or service logic.”
- @Component -> General-purpose bean. Used when a class doesn’t fit into service or repository layers.

```java
@Repository
public class UserRepository {
    // Handles DB operations
}

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    // Business logic
}

@Component
public class Utility {
    // General helper methods
}
```

- @Component, @Primary, and @Qualifier

```java
@Component
class EmailService implements MessageService {
    public void send() { System.out.println("Sending Email..."); }
}

@Component
class SMSService implements MessageService {
    public void send() { System.out.println("Sending SMS..."); }
}

@Service
class NotificationService {
    @Autowired
    private MessageService messageService; // ❌ Error! Two beans found
}

// Solution 1: Use @Primary
@Component
@Primary
class EmailService implements MessageService {
    public void send() { System.out.println("Sending Email..."); }
}

// Solution 2: Use @Qualifier
@Service
class NotificationService {
    @Autowired
    @Qualifier("SMSService")  // Bean name or custom qualifier
    private MessageService messageService;
}

```

</details>