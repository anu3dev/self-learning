### security

####
<details>
<summary>🟩 HTTP header and body</summary>

- Headers -> metadata about the request or response.
    - Examples (Request Headers):
    - Content-Type: application/json
    - Authorization: Bearer <token>
    - User-Agent: Chrome
    - Accept: application/json
    - Host: example.com
    - Cookie: sessionId=abc123
- HTTP BODY -> actual data you are sending.
    - API type -> POST, PUT, PATCH, GET, DELETE etc.
    - JSON body -> queries and details
    ```json
    {
        "name": "John",
        "age": 25
    }
    ```
</details>

####
<details>
<summary>🟩 What is JWT</summary>

- A JWT is a token that proves:
    - Who the user is
    - That they are authenticated
    - What permissions they have
- A JWT has 3 parts, separated by dots:
    - Header -> Contains metadata:
        ```json
        {
            "alg": "HS256", // signing algorithm
            "typ": "JWT"    // token type
        }
        ```
    - Payload -> Contains claims
        ```json
        {
            "id": 1,
            "name": "John",
            "role": "admin",
            "exp": 1712345678
        }
        ```
    - Signature

    - working with JWT
        - The Login Adventure Begins -> Imagine you’re logging into a website. You enter your username and password, just like how you’d normally sign in to a service.
        - The Guard at the Gate -> The server (like a security guard) checks if your credentials are correct. If they are, the guard is happy and lets you in.
        - The Magic Ticket -> Instead of remembering your login for every action, the server gives you a magic ticket (JWT). This ticket proves who you are. The ticket has three parts: the header, payload, and signature.
        - The Header -> This is like the label on the ticket saying what type of magic ticket it is and how it was created (the "how" is usually a secure algorithm).
        - The Payload -> This is the content of the ticket. It contains details about you — like your user ID, role (are you an admin or a guest?), and the expiration time (how long you can stay).
        - The Signature -> To make sure no one can tamper with the ticket, it’s signed. The signature is created using a secret key that only the server knows.
        - You Carry the Ticket -> You leave the login page, and the magic ticket is stored on your device (either in cookies or local storage). Whenever you need access, you carry it along.
        - Every Request Counts -> Next time you visit a new page or request some data, your magic ticket (JWT) is included automatically. It's like showing your ID card at each checkpoint.
        - The Guard Verifies the Ticket -> Every time you use your ticket, the server checks if it's still valid. It checks:
            - Did you forge it? (The signature must match)
            - Is it expired? (The expiration date must be valid)
            - If everything checks out, the server says, "Welcome back!"
        - The Adventure Continues -> Now, you can keep browsing, sending messages, or buying things on the website — all without having to log in every time. As long as your magic ticket is valid, you're good to go!
</details>

####
<details>
<summary>🟩 SSO - single sign on login</summary>

- working with SSO

    - The Login Journey Begins -> Imagine you’re logging into an online service or an application. Instead of entering your username and password for every service you use, you want to log in once and be able to access all your apps.
    - The Identity Provider (IDP) -> You need an Identity Provider (IDP). This is like a trusted security guard that knows who you are and can authenticate you.
        - Some popular IDPs are:
            - Azure Active Directory
            - Okta
            - Auth0
            - Google Identity
        - They manage and verify your identity.
    - Select a Protocol -> Now, you need to choose a protocol to communicate between your IDP and the applications you want to use.
        - This is like picking the right language for your system:
            - SAML – for older apps (like legacy software)
            - OAuth2.0 / OIDC – for modern apps and APIs (like web apps and mobile apps)
        - These protocols help in securely transferring identity information.
    - Configure the IDP (Identity Provider) -> Next, you configure the IDP (the security guard) so that it knows about the apps you want to use.
        - Here’s what you need to do:
            - Register the application: Tell the IDP which apps you're going to access (like "MyApp", "CRM", etc.).
            - Define Redirect URLs and Scopes: These are like addresses where your app will send the user after login. You also define what the app can do with the user’s information (this is called scope).
            - Obtain Client ID and Secret: This is like a unique key for your app. The IDP gives your app a Client ID and a secret key to securely identify itself.
    - The Magic Token -> When you log in, the IDP gives you a magic token (like a key). This token proves you’ve been authenticated and gives you access to the apps you want.
    - Integrate with Your Application -> Now, it's time to make your application talk to the IDP. 
        - This is done by:
            - Using SDKs or libraries provided by the IDP for your programming language/framework (e.g., Spring Security for Java, Passport.js for Node.js).
            - These libraries handle the communication between your app and the IDP, like redirecting to the login page and getting the magic token.
    - The Login Process Starts -> When you try to access the app, the application redirects you to the IDP (the trusted security guard) for authentication.
    - Authentication Happens at the IDP -> The IDP asks you to log in (e.g., via your Google, Okta, or Azure account). Once logged in, it sends you back a token (magic key) that proves you are who you say you are.
    - The Token is Verified -> Your app receives this token and verifies it. If the token is valid (it’s signed by the IDP and hasn’t expired), your app allows you access without asking you to log in again.
    - Access All the Applications -> Now, since you're authenticated through the IDP, you can access other apps that are also integrated with the same IDP. You don’t need to log in again — the magic token proves you're authenticated.

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-client</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```

    ```yaml
    spring:
    security:
        oauth2:
        client:
            registration:
            google:
                client-id: YOUR_GOOGLE_CLIENT_ID
                client-secret: YOUR_GOOGLE_CLIENT_SECRET
                scope: profile, email
                redirect-uri: "{baseUrl}/login/oauth2/code/{registrationId}"
                authorization-grant-type: authorization_code
                client-name: Google
            provider:
            google:
                authorization-uri: https://accounts.google.com/o/oauth2/auth
                token-uri: https://oauth2.googleapis.com/token
                user-info-uri: https://www.googleapis.com/oauth2/v3/userinfo
    ```

    ```java
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.security.oauth2.core.user.OAuth2User;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class SSOController {

        @GetMapping("/loginSuccess")
        public String loginSuccess(@AuthenticationPrincipal OAuth2User principal) {
            System.out.println("User name: " + principal.getName());  // User's Google name
            System.out.println("User email: " + principal.getAttribute("email"));  // User's Google email

            return "redirect:/home";  // Redirect to home after successful login
        }

        @GetMapping("/home")
        public String home() {
            return "home";  // Home page after login
        }

        @GetMapping("/")
        public String login() {
            return "login";  // Login page
        }
    }
    ```
</details>



