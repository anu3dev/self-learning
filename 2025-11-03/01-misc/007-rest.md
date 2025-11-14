### rest

####
<details>
<summary>🟩 6 Core REST Principles</summary>

- Client–Server Architecture
    - Client and server must be separated -> Client handles UI and Server handles data & logic, This separation allows both to evolve independently.

- Statelessness
    - Each request from the client must contain all the information needed to process it -> Server does NOT store client session, No memory of previous requests, Every request is independent, Example: Client must send token every time.

- Cacheability
    - Responses must define whether they are cacheable or not -> Improves performance, Reduces server load, Uses headers like Cache-Control, ETag, Expires

- Uniform Interface (MOST IMPORTANT)
    - All communication between client and server must be done in a standard, consistent way.

    - Includes:
        - Resource-based URLs
            - /users/10/orders
        - Standard HTTP methods
            - GET → Read
            - POST → Create
            - PUT → Update (replace)
            - PATCH → Partial update
            - DELETE → Delete
        - Standard response codes
            - 200 OK
            - 201 Created
            - 400 Bad Request
            - 404 Not Found
            - 500 Server Error

- Layered System
    - REST allows multiple layers between client and server:
        - Load balancers
        - Proxies
        - Gateways
        - Security layers -> Client doesn’t know how many layers exist.

- Code on Demand (Optional)
    - Server can send executable code to the client. Example: Send JavaScript to browser.
</details>