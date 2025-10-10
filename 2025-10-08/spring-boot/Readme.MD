## 🧩 Section 1 – Spring Boot Basics

---

### **Q1. What is Spring Boot and how is it different from the Spring Framework?**

**Answer:**  
Spring Boot is a lightweight extension of the Spring Framework that simplifies setup and development.  
It provides:
- ✅ Auto-configuration  
- ✅ Embedded servers  
- ✅ Production-ready features (metrics, health checks, etc.)

**Difference:**  
- **Spring Framework:** Manual XML/Java configuration  
- **Spring Boot:** Convention-over-configuration + starter dependencies  

**Example:**
```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```
→ This single file starts a full Spring app without XML or explicit web.xml

### **Q2. What are the advantages of using Spring Boot?**

**Answer:**
- ✅ No need for XML configuration
- ✅ Embedded server (Tomcat, Jetty, Undertow)
- ✅ Built-in dependency management via spring-boot-starter
- ✅ Easier integration with JPA, Security, Actuator, etc.
- ✅ Supports microservices architecture

**Example:**
Including just one dependency:
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
→ Automatically adds Spring MVC + Tomcat

### **Q3. What is the role of @SpringBootApplication?**