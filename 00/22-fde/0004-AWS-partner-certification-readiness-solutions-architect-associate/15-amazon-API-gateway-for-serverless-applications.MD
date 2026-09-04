# Amazon API Gateway for Serverless Applications

> **AWS Study Notes / README.md**
>
> **Core idea:** Amazon API Gateway is the **front door** of a serverless application. It receives client requests, controls access and traffic, optionally transforms/validates requests, and routes them to backend services such as Lambda, HTTP endpoints, AWS services, or VPC-connected resources.

---

## 1. What is an API?

An **API (Application Programming Interface)** allows two software components to communicate.

Think of an API as the **front door** to an application.

```
Client

  │

  │ HTTP Request

  ▼

API

  │

  ▼

Backend
```

The backend could contain:

- Business logic
- Data
- AWS services
- Databases
- Lambda functions
- Containerized applications

---

# 2. What is Amazon API Gateway?

**Amazon API Gateway** is an AWS service used to:

- Create APIs
- Publish APIs
- Maintain APIs
- Secure APIs
- Monitor APIs
- Control API traffic
- Manage API versions
- Handle authorization
- Support CORS
- Throttle requests
- Integrate with backend services

It acts as the **entry point between clients and backend services**.

```
Mobile App

Website

Other Service

     │

     ▼

   Internet

     │

     ▼

API Gateway

     │

 ┌───┼───────────────┐

 ▼   ▼               ▼

Lambda  EC2/HTTP   AWS Service
```

API Gateway is particularly important in **serverless architectures**, where clients commonly communicate with Lambda through an API endpoint.

---

# 3. API Management Challenges

When building APIs, common challenges include:

1. Handling API calls in serverless applications
2. Managing multiple API versions
3. Managing different environments
4. Controlling authentication and authorization
5. Handling traffic spikes
6. Monitoring API usage
7. Managing third-party consumers

API Gateway provides features to address these concerns.

---

# 4. API Gateway Major Features

## Developer Features

API Gateway supports:

- Multiple API versions
- SDK generation
- Request/response transformation
- Request validation

## API Access Features

API Gateway also supports:

- Throttling
- Traffic control
- Authorization
- API keys
- Usage plans

---

# 5. API Gateway Architecture

A typical serverless architecture looks like:

```
                  Internet

                     │

        ┌────────────┼────────────┐

        │            │            │

      Mobile       Website      Service

        │            │            │

        └────────────┼────────────┘

                     │

                     ▼

              API Gateway

                     │

        ┌────────────┼─────────────┐

        ▼            ▼             ▼

     Lambda       HTTP/EC2      AWS Service

        │

        ▼

    DynamoDB
```

API Gateway can integrate with:

- Lambda
- HTTP endpoints
- AWS services
- VPC-connected resources

---

# 6. API Gateway API Types

API Gateway provides three major API types:

```
Amazon API Gateway

        │

        ├── REST API

        │

        ├── HTTP API

        │

        └── WebSocket API
```

---

# 7. REST API vs HTTP API vs WebSocket API

| Feature | REST API | HTTP API | WebSocket API |
| --- | --- | --- | --- |
| Communication                        | Request/Response          | Request/Response       | Bidirectional           |
| Best for                             | Feature-rich APIs         | Modern/serverless APIs | Real-time applications  |
| Lambda integration                   | ✅                         | ✅                      | ✅                       |
| HTTP backend                         | ✅                         | ✅                      | ✅                       |
| API management features              | Rich                      | More limited           | Different model         |
| Real-time push                       | ❌                         | ❌                      | ✅                       |
| Persistent connection                | ❌                         | ❌                      | ✅                       |
| Typical use                          | Enterprise/API management | Serverless proxy APIs  | Chat, games, dashboards |

### Easy Memory

```
REST     → Feature-rich API

HTTP     → Fast + simple serverless API

WebSocket → Real-time + two-way
```

The course specifically describes HTTP APIs as optimized for Lambda/HTTP proxy workloads and WebSocket APIs as bidirectional APIs.

---

# 8. WebSocket APIs

A **WebSocket API** maintains a persistent connection between the client and API Gateway.

Unlike REST:

```
REST

Client ───── Request ─────► Server

Client ◄──── Response ───── Server
```

WebSocket:

```
Client ◄──────────────► API Gateway

          persistent

          connection
```

Both sides can send messages.

```
Client ───────► Backend

Client ◄─────── Backend
```

This makes WebSocket APIs useful for:

- Chat applications
- Streaming dashboards
- Real-time alerts
- Notifications
- Collaboration platforms
- Multiplayer games
- Financial trading platforms

---

# 9. WebSocket Architecture

```
Client

  │

  │ WebSocket

  ▼

API Gateway

  │

  ├── Lambda

  ├── HTTP endpoint

  ├── AWS service

  └── Kinesis
```

The backend can independently send messages back to connected clients.

---

# 10. WebSocket Routes

WebSocket APIs use **route keys** to determine which backend should process a message.

### Predefined routes

```
$connect

$disconnect

$default
```

You can also define custom routes.

Example:

```
message:

{

   "action": "sendMessage"

}
```

API Gateway can route the message based on the route key.

---

# 11. WebSocket Integration

A WebSocket route needs a backend integration.

Possible integration endpoints include:

- Lambda
- HTTP endpoint
- AWS service action

```
Client

  ↓

WebSocket Route

  ↓

Integration

  ↓

Lambda / HTTP / AWS Service
```

An integration contains:

- Integration request
- Integration response

---

# 12. WebSocket One-Way vs Two-Way

### Two-way communication

If a route has a **route response**, the API can return a response over the WebSocket connection.

```
Client

  ↓

API Gateway

  ↓

Backend

  ↓

API Gateway

  ↓

Client
```

### One-way communication

If there is no route response:

```
Client

  ↓

API Gateway

  ↓

Backend

No response returned over WebSocket
```

---

# 13. WebSocket Pricing Concept

WebSocket API usage includes:

- Messages sent
- Messages received
- Connection minutes

Messages can be up to **128 KB**.

Messages are metered in **32-KB increments**.

Example:

```
32 KB → 1 message

33 KB → 2 messages

64 KB → 2 messages

65 KB → 3 messages
```

The course material also notes a free tier of:

- 1 million messages
- 750,000 connection minutes
- Up to 12 months

> Always verify current AWS pricing before making production cost estimates.

---

# 14. REST APIs

A REST API in API Gateway consists of:

```
Resources

   \+

Methods

   \+

Backend Integrations
```

Example:

```
/store

   │

   ├── /products

   │      ├── GET

   │      └── OPTIONS

   │

   └── /{cart}

          ├── GET

          └── POST
```

REST APIs use the traditional **request-response model**.

```
Client

  │

  │ Request

  ▼

API Gateway

  │

  ▼

Backend

  │

  │ Response

  ▼

Client
```

---

# 15. REST API Endpoint Types

REST APIs support three endpoint types:

### 1. Regional

```
Client

  ↓

Regional API Gateway
```

Useful when clients and backend are primarily in the same AWS Region.

### 2. Edge-Optimized

Designed for APIs accessed globally using AWS edge infrastructure.

### 3. Private

Used for APIs that should be accessible privately through a VPC.

```
VPC

 │

Private API

 │

Private resources
```

The course notes that endpoint type can be changed between supported types, but **private cannot be changed directly to edge-optimized**.

---

# 16. API Gateway Cache

API Gateway caching can cache backend responses.

```
Client

  ↓

API Gateway

  ↓
```

Cache Hit?

 ├── YES → Return cached response

 │

 └── NO

       ↓

    Backend

### Benefits

- Reduce backend calls
- Reduce latency
- Improve performance

The course material specifies that this optional cache is available for **REST APIs**.

---

# 17. API Gateway Integration Types

API Gateway supports several integration types:

```
Lambda Function

HTTP Endpoint

AWS Service

Mock

VPC Link
```

### Lambda

```
API Gateway

     ↓

Lambda
```

### HTTP

```
API Gateway

     ↓

HTTP Backend
```

### AWS Service

```
API Gateway

     ↓

AWS Service
```

### Mock

Useful when a backend is not required.

```
API Gateway

     ↓

Mock Response
```

### VPC Link

Allows API Gateway to integrate with resources reachable through a VPC.

---

# 18. API Gateway Stages

A **stage** is a deployed snapshot/version of an API.

Typical environments:

```
dev

 ↓

beta

 ↓

prod
```

Example URL:

```
https://restApi-id.execute-api.region.amazonaws.com/prod/resource
```

Conceptually:

```
https://

  restApi-id

  .execute-api

  .region

  .amazonaws.com

  /

  stage

  /

  resource
```

A stage provides a unique deployed version/environment for an API.

---

# 19. Why Do We Need Stages?

Suppose you have:

```
Development API

Production API
```

You don't want developers testing new changes against production.

Use stages:

```
API Gateway

    │

    ├── dev

    │

    ├── beta

    │

    └── prod
```

Stages allow:

- Multiple environments
- Version management
- Rollbacks
- Different configuration
- Canary deployments

---

# 20. Stage Configuration

Important settings can be configured at the stage level:

- Caching
- Throttling
- Usage plans
- Canary deployment settings
- Logging
- Monitoring

Stages can also be used to:

- Export API definitions
- Generate SDKs

---

# 21. Stage Variables

Stage variables allow runtime configuration without hard-coding backend values.

Syntax:

```
$stageVariables.variableName
```

Example:

```
$stageVariables.lambdaFn
```

or:

```
$stageVariables.url
```

---

# 22. Stage Variable Example

Suppose:

```
Demo

  lambdaFn = demoLambda

  url      = demo.example.com
```

and:

```
Prod

  lambdaFn = prodLambda

  url      = prod.example.com
```

The API definition can reference:

```
$stageVariables.lambdaFn

$stageVariables.url
```

Instead of hard-coding:

```
demoLambda
```

or:

```
prodLambda
```

This allows the same API design to dynamically select the appropriate backend.

---

# 23. API Gateway + Lambda Versioning

A strong deployment pattern is:

```
API Gateway Stage

        ↓

Stage Variable

        ↓

Lambda Alias

        ↓

Lambda Version
```

For example:

```
prod stage

    ↓

lambdaFn = myFunction:prod

    ↓

Lambda alias

    ↓

Version 5
```

This avoids hard-coding specific Lambda versions.

---

# 24. Canary Deployment

Canary deployment sends only a percentage of traffic to a new version.

Example:

```
                 API Gateway

                     │

             ┌───────┴───────┐

             │               │

          90% traffic      10%

             │               │

          Stable          Canary

          Version         Version
```

If the new version works correctly:

```
Canary

10%

 ↓

Promote

 ↓

100%
```

This reduces deployment risk.

---

# 25. API Authentication vs Authorization

These two concepts are important.

### Authentication

**Who are you?**

```
"Are you really this user/service?"
```

### Authorization

**What are you allowed to do?**

```
"Are you allowed to call this API?"
```

---

# 26. API Gateway Authorization Options

The course identifies three major approaches:

```
1. IAM + Signature Version 4

2\. Lambda Authorizer

3\. Amazon Cognito User Pools
```

---

# 27. IAM + SigV4

IAM authorization is useful for:

- Internal applications
- AWS services
- Restricted customers
- Applications already using IAM roles

Requests are signed using **AWS Signature Version 4**.

```
Client

  ↓

SigV4 Signed Request

  ↓

API Gateway

  ↓

IAM Authorization

  ↓

Backend
```

### Easy Memory

> **Internal AWS-style access → IAM + SigV4**

---

# 28. Lambda Authorizer

A **Lambda Authorizer** lets you implement custom authorization logic.

Typical use:

```
Client

  ↓

Bearer Token

  ↓

API Gateway

  ↓

Lambda Authorizer

  ↓

Allow / Deny

  ↓

Backend
```

Useful for authentication strategies such as:

- OAuth
- SAML
- Custom bearer tokens

---

# 29. Lambda Authorizer — Token Type

For a token-based Lambda Authorizer, API Gateway passes the source token to Lambda.

Example:

```
{

  "type": "TOKEN",

  "authorizationToken": "someToken",

  "methodArn": "arn\:aws\:execute-api:..."

}
```

Lambda evaluates the token and returns an authorization policy.

Conceptually:

```
Token

  ↓

Lambda Authorizer

  ↓

┌───────────────┐

│ Allow / Deny  │

└───────────────┘
```

---

# 30. Cognito

Amazon Cognito User Pools can be used to authenticate users and authorize API access.

Typical architecture:

```
User

 ↓

Cognito User Pool

 ↓

Token

 ↓

API Gateway

 ↓

Backend
```

### Easy Memory

```
IAM       → AWS/internal identity

Lambda Auth → Custom authorization

Cognito   → User authentication
```

---

# 31. API Keys

API Gateway can issue API keys to API consumers.

The client sends:

```
x-api-key: <API_KEY>
```

API keys can help identify consumers and apply usage controls.

> **Important:** API keys are primarily for **identification and usage control**; don't treat them as a replacement for strong user authentication/authorization.

---

# 32. Usage Plans

Usage plans can be combined with API keys.

They allow controls such as:

### Throttling

```
Requests / second

\+

Burst
```

### Quota

```
Daily

Weekly

Monthly
```

Example:

```
Customer A

   ↓

API Key

   ↓

Usage Plan

   ↓

100 requests/sec

   \+

Monthly quota
```

---

# 33. Throttling

Throttling controls how many requests can be processed.

Example:

```
Rate = 50 requests/sec

Burst = 75
```

This protects downstream systems from excessive traffic.

```
1000 requests

      ↓

API Gateway

      ↓

Throttle

      ↓

Backend receives controlled traffic
```

---

# 34. Throttling Hierarchy / Troubleshooting

API Gateway throttling can be configured at different levels.

The course troubleshooting example considered:

1. API key throttling
2. Method-level throttling at stage level
3. Stage-level default throttling
4. Account-level limits

In the exercise:

```
Method throttling

Rate = 1

Burst = 5
```

was the root cause.

So when troubleshooting a `429` / throttling issue, inspect the **most specific applicable throttle configuration**, not just the account limit.

---

# 35. Resource Policies

Resource policies can restrict who can access an API.

They can be used together with:

- IAM
- Lambda Authorizers
- Cognito
- Other access mechanisms

Example:

```
Client

  ↓

API Gateway

  ↓

Resource Policy

  ↓

Allow / Deny
```

---

# 36. Troubleshooting 403 Access Denied

The course example:

```
Client IP

207.172.87.12
```

received:

```
403

Access Denied
```

X-Ray showed:

```
execute-api:Invoke

Explicit Deny
```

The root cause was:

> **The resource policy associated with the API explicitly denied access.**

### Troubleshooting thought process

```
403

 ↓

Check authorization

 ↓

Check resource policy

 ↓

Look for explicit Deny
```

---

# 37. Monitoring API Gateway

Three important AWS services:

```
CloudWatch

X-Ray

CloudTrail
```

### Easy Memory

```
CloudWatch → Metrics + Logs

X-Ray      → Trace

CloudTrail → Audit
```

---

# 38. CloudWatch Metrics

API Gateway provides important metrics.

## Count

Number of API requests.

```
How much traffic?
```

## Latency

Time from API Gateway receiving the request until returning the response.

```
Client

  ↓

API Gateway

  ↓

Backend

  ↓

API Gateway

  ↓

Client

<------ Latency ------>
```

## IntegrationLatency

Time API Gateway spends communicating with the backend.

```
API Gateway

     ↓

Backend

     ↓

Response

<-- IntegrationLatency -->
```

## 4xxError

Client-side errors.

Examples:

```
400

401

403

404

429
```

## 5xxError

Server-side errors.

## CacheHitCount

Requests served from cache.

## CacheMissCount

Requests that required the backend because the response wasn't available in cache.

---

# 39. API Gateway Overhead

Two metrics are particularly important:

```
Latency

IntegrationLatency
```

Conceptually:

```
API Gateway Total Latency

           │

           ├── Integration Latency

           │

           └── API Gateway Overhead
```

Therefore:

```
API Gateway Overhead

\=

Latency - IntegrationLatency
```

This helps identify whether latency is coming from:

- API Gateway
- Backend integration
- Other API Gateway processing

---

# 40. CloudWatch Logs

API Gateway supports two important logging types:

```
Execution Logging

Access Logging
```

---

# 41. Execution Logging

Execution logs show details about request processing.

They can help troubleshoot:

- Request processing
- Integration behavior
- Errors
- Backend interactions
- Request parameters

### Important Production Warning

Full request/response logging can expose sensitive information.

Therefore:

> Avoid enabling **full request/response data logging** for production APIs unless there is a justified need.

There is also a logging cost consideration.

---

# 42. Access Logging

Access logs are customizable.

They can contain information such as:

- Request information
- Status
- Client information
- API stage
- Timing

They can be formatted using JSON and potentially sent to external analysis systems.

---

# 43. X-Ray

**AWS X-Ray** provides distributed tracing.

```
Client

  ↓

API Gateway

  ↓

Lambda

  ↓

Database / Other Service
```

X-Ray lets you see the request's journey across the architecture.

Useful for:

- Finding latency
- Debugging errors
- Finding bottlenecks
- Understanding request flow

---

# 44. X-Ray — Cold Start Example

The course example showed:

```
Cold Start

Total latency = 232 ms

Lambda billable duration = 26 ms
```

A cold start requires Lambda to initialize a new execution environment.

---

# 45. X-Ray — Warm Start Example

The warm-start example showed:

```
Warm Start

Total latency = 18 ms

Lambda billable duration = 1 ms
```

The existing Lambda execution environment can be reused.

### Easy Memory

```
Cold Start → initialization → slower

Warm Start → reuse → faster
```

The examples demonstrate how X-Ray can expose this latency difference.

---

# 46. CloudTrail

**AWS CloudTrail** is used for auditing API activity.

CloudTrail captures API calls made against API Gateway.

It can help determine:

- What request was made
- Who made it
- Source IP address
- When it happened
- Additional event details

You can inspect recent events using **CloudTrail Event History**.

You can also create a trail to send events to Amazon S3.

### Easy Memory

```
CloudWatch → How is it performing?
```

X-Ray      → Where is the request slow/failing?

CloudTrail → Who did what?

---

# 47. Mapping Templates

API Gateway can transform request and response data.

Example:

```
Client

  │

  │ JSON

  ▼

API Gateway

  │

  │ Mapping Template

  ▼

Backend

  │

  │ XML

  ▼

Client
```

A mapping template can transform:

```
JSON → XML

XML → JSON
```

or other required formats.

---

# 48. Mapping Template Variables

Important variables:

| VariablePurpose   |                              |
| ----------------- | ---------------------------- |
| `$input`          | Body, JSON, parameters, path |
| `$stageVariables` | Access stage variables       |
| `$util`           | Utility functions            |

Useful `$util` functions include:

```
escapeJavaScript()

parseJson()

urlEncode()

urlDecode()

base64Encode()

base64Decode()
```

---

# 49. Gateway Responses

For invalid requests, API Gateway can reject the request **before invoking the integration**.

Gateway Responses can be customized.

You can modify:

- HTTP status code
- Response body
- Headers

Example:

```
Invalid Request

      ↓

API Gateway

      ↓

Gateway Response

      ↓

400 / Custom Response
```

---

# 50. Request Validation

API Gateway can perform basic request validation before forwarding the request to the backend.

It can validate:

### Required Parameters

URL:

```
/path/{id}
```

Query string:

```
?name=Anurag
```

Headers:

```
Authorization: ...
```

### Request Body

The request payload can be validated against a configured JSON model.

```
Request

  ↓

API Gateway Validation

  ↓
```

Valid?

 ├── YES → Backend

 └── NO  → Error Response

---

# 51. Why Request Validation Matters

Without validation:

```
Client

 ↓

API Gateway

 ↓

Lambda

 ↓

Validate Input
```

With API Gateway validation:

```
Client

 ↓

API Gateway

 ↓

Validate

 ├── Invalid → Reject

 │

 └── Valid → Lambda
```

This prevents unnecessary backend invocations.

---

# 52. Private API Architecture

A private API can be accessed through private VPC connectivity.

Conceptually:

```
                 VPC

┌─────────────────────────────────────┐

│                                     │

│ Private Subnet                       │

│                                     │

│ EC2        Lambda                   │

│  │           │                      │

│  └──────┬────┘                      │

│         ↓                           │

│ Interface VPC Endpoint              │

│         │                           │

└─────────┼───────────────────────────┘

          ↓

     API Gateway

      Private API
```

This is useful when the API should not be publicly accessible.

---

# 53. VPC Link

A **VPC Link** allows API Gateway to connect to backend resources through a VPC.

Example:

```
Internet

   ↓

API Gateway

   ↓

VPC Link

   ↓

Load Balancer

   ↓

Private Backend
```

This is particularly useful when exposing private backend services through API Gateway.

---

# 54. API Gateway + CloudFront

A common architecture can include:

```
Client

  ↓

CloudFront

  ↓

API Gateway

  ↓

Lambda

  ↓

DynamoDB
```

API Gateway can also provide its own response caching for REST APIs.

### Think:

```
CloudFront → Edge/content distribution

API Gateway → API management

Lambda      → Compute

DynamoDB    → Data
```

---

# 55. API Gateway + Authentication Architecture

A typical authenticated serverless application:

```
             User

               │

               ▼

            Cognito

               │

               │ Token

               ▼

          API Gateway

               │

        Authorization

               │

               ▼

             Lambda

               │

               ▼

           DynamoDB
```

Another architecture can use:

```
Client

  ↓

SigV4

  ↓

API Gateway

  ↓

IAM

  ↓

Backend
```

Or:

```
Client

  ↓

Bearer Token

  ↓

API Gateway

  ↓

Lambda Authorizer

  ↓

Backend
```

---

# 56. API Gateway Design Decision

Use this mental decision tree:

```
Need an API?

    │

    ▼
```

Real-time two-way communication?

    │

 ┌──YES───────────────► WebSocket API

 │

 NO

 │

 ▼

Need rich API management features?

 │

 ├──YES──────────────► REST API

 │

 NO

 │

 ▼

Modern serverless / Lambda / HTTP backend?

 │

 └───────────────────► HTTP API

---

# 57. REST vs HTTP — Easy Interview Answer

### REST API

Choose REST API when you need richer API management functionality and features such as:

- API proxy capabilities
- Private APIs
- Edge-optimized APIs
- More extensive management features
- Certain advanced security/integration requirements

### HTTP API

Choose HTTP API when you want a simpler, lower-cost, lower-latency API for:

- Lambda
- HTTP backends
- Modern serverless workloads

The course describes HTTP APIs as a cheaper and faster alternative to REST APIs, with fewer API-management capabilities.

---

# 58. WebSocket — Easy Interview Answer

> Use **WebSocket API** when the backend needs to push data to the client without the client making a new request.

Examples:

```
Chat

Trading

Live Dashboard

Gaming

Notifications

Collaboration
```

---

# 59. API Gateway Request Flow

A complete request can look like:

```
Client

  │

  │ HTTPS

  ▼

API Gateway

  │

  ├── Authentication

  │

  ├── Authorization

  │

  ├── API Key

  │

  ├── Throttling

  │

  ├── Request Validation

  │

  ├── Mapping / Transformation

  │

  ├── Cache

  │

  ▼

Integration

  │

  ├── Lambda

  ├── HTTP

  ├── AWS Service

  └── VPC Link

       │

       ▼

    Backend
```

---

# 60. Response Flow

```
Backend

   │

   ▼

API Gateway

   │

   ├── Integration Response

   │

   ├── Mapping

   │

   ├── Cache

   │

   └── Gateway Response if applicable

   │

   ▼

Client
```

---

# 61. Monitoring Decision Tree

When an API has a problem:

```
API Problem

    │

    ▼

CloudWatch Metrics

    │
```

    ├── 4xx?

    │     ↓

    │   Client / Auth / Throttling

    │

    ├── 5xx?

    │     ↓

    │   Backend / Server problem

    │

    └── High Latency?

          ↓

       X-Ray

Then:

```
Need audit information?

        ↓

   CloudTrail
```

---

# 62. Troubleshooting Cheat Sheet

| ProblemFirst Place to Look       |                                 |
| -------------------------------- | ------------------------------- |
| Too many requests                | Throttling                      |
| `429`                            | Throttle settings               |
| `403`                            | Authorization / Resource Policy |
| High latency                     | CloudWatch + X-Ray              |
| Backend slow                     | IntegrationLatency              |
| API Gateway overhead             | Latency - IntegrationLatency    |
| Cache performance                | CacheHitCount / CacheMissCount  |
| Who made API configuration call? | CloudTrail                      |
| Request processing details       | Execution Logs                  |
| Request/client information       | Access Logs                     |
| Invalid request                  | Request Validation              |
| Wrong request format             | Mapping Templates               |

---

# 63. Troubleshooting Example — 429

Given:

```
4xx spike

 ↓

CloudWatch

 ↓

Execution Logs

 ↓

429

 ↓

Throttle limit exceeded
```

Check:

```
1. API key throttling

2\. Method-level stage throttling

3\. Stage-level default throttling

4\. Account limits
```

In the provided exercise:

```
Method throttling

Rate = 1

Burst = 5
```

was the actual cause.

---

# 64. Troubleshooting Example — 403

Given:

```
Customer

 ↓

API

 ↓

403 Access Denied
```

Use:

```
Access Logs

   \+

X-Ray
```

The trace showed:

```
execute-api:Invoke

Explicit Deny
```

Then inspect:

```
Resource Policy
```

The explicit deny for the customer's IP was the root cause.

---

# 65. API Gateway Best Practices

## 1. Use stages

```
dev

beta

prod
```

Separate environments cleanly.

## 2. Use Lambda aliases

```
API Stage

   ↓

Lambda Alias

   ↓

Lambda Version
```

## 3. Use stage variables where appropriate

Avoid hard-coding environment-specific backend information.

## 4. Use Canary deployments

Send a small percentage of traffic to new versions first.

## 5. Use least privilege

Give API Gateway integrations and authorization mechanisms only the permissions they need.

## 6. Validate requests

Reject invalid requests before they reach expensive backend processing.

## 7. Monitor with CloudWatch

Watch:

```
Count

Latency

IntegrationLatency

4xx

5xx

CacheHitCount

CacheMissCount
```

## 8. Use X-Ray for distributed troubleshooting

Especially useful for identifying backend latency and errors.

## 9. Avoid sensitive full request/response logging in production

Execution logging can expose sensitive data.

---

# 66. ⭐ Most Important Interview Concepts

### Q: What is API Gateway?

> A managed AWS service that acts as the front door for APIs and handles API creation, deployment, security, authorization, throttling, monitoring, and backend integration.

### Q: API Gateway + Lambda?

```
Client

 ↓

API Gateway

 ↓

Lambda

 ↓

Database
```

API Gateway exposes the HTTP endpoint; Lambda executes the business logic.

### Q: REST vs HTTP API?

> REST API provides richer API management capabilities; HTTP API is optimized for simpler, faster, lower-cost serverless/API proxy workloads.

### Q: REST vs WebSocket?

> REST follows request-response communication. WebSocket maintains a persistent connection and supports bidirectional communication.

### Q: What is a stage?

> A deployed snapshot/environment of an API, such as `dev`, `beta`, or `prod`.

### Q: What are stage variables?

> Runtime variables that allow different stages to reference different backend resources without hard-coding them.

### Q: What is a Lambda Authorizer?

> A Lambda function that implements custom authorization logic for API Gateway.

### Q: IAM vs Lambda Authorizer vs Cognito?

```
IAM

→ AWS/internal authorization

Lambda Authorizer

→ Custom token/authorization logic

Cognito

→ User authentication/user pools
```

### Q: What is throttling?

> A mechanism for limiting API traffic so consumers cannot overwhelm the API or downstream systems.

### Q: What is API key?

> A key used to identify API consumers and apply usage/throttling controls.

### Q: What is X-Ray?

> A distributed tracing service used to analyze request flow, latency, and errors.

### Q: What is CloudTrail?

> An auditing service that records API activity and helps determine who made an API call, when, and from where.

### Q: What is CloudWatch?

> Used to monitor API Gateway metrics and logs.

---

# 67. 🧠 Easy Memory

```
API Gateway

     ↓

FRONT DOOR

     ↓

┌──────────────────────────────┐

│ Authentication               │

│ Authorization                │

│ API Keys                     │

│ Throttling                   │

│ Caching                      │

│ Validation                   │

│ Transformation               │

│ Monitoring                   │

│ Version / Stage Management   │

└──────────────────────────────┘

     ↓

Backend
```

### API Types

```
REST      → Feature-rich

HTTP      → Simple + fast + serverless

WebSocket → Real-time + bidirectional
```

### Security

```
IAM          → SigV4

Lambda Auth  → Custom token

Cognito      → Users

API Key      → Consumer identification/usage

Resource     → Policy-based access
```

### Monitoring

```
CloudWatch → Metrics + Logs

X-Ray      → Tracing

CloudTrail → Audit
```

### Deployment

```
Stage

  ↓

Stage Variable

  ↓

Lambda Alias

  ↓

Lambda Version
```

### Traffic

```
Throttle → Rate + Burst

Quota    → Daily / Weekly / Monthly

Canary   → Percentage of traffic
```

---

# 68. 🎯 AWS Exam Quick Revision

> **Need an API front door for Lambda?**
>  → API Gateway

> **Need real-time bidirectional communication?**
>  → WebSocket API

> **Need simple serverless API with Lambda/HTTP backend?**
>  → HTTP API

> **Need rich API management capabilities?**
>  → REST API

> **Need different dev/prod API environments?**
>  → API Gateway Stages

> **Need different Lambda/backend per stage?**
>  → Stage Variables

> **Need gradual traffic migration?**
>  → Canary Deployment

> **Need custom authorization?**
>  → Lambda Authorizer

> **Need AWS/IAM-based API authorization?**
>  → IAM + SigV4

> **Need user authentication through user pools?**
>  → Cognito

> **Need consumer throttling/quota?**
>  → API Keys + Usage Plans

> **Need request transformation?**
>  → Mapping Templates

> **Need reject invalid requests before backend invocation?**
>  → Request Validation

> **Need API performance metrics?**
>  → CloudWatch

> **Need distributed request tracing?**
>  → X-Ray

> **Need audit of API calls?**
>  → CloudTrail

> **Need investigate** **`429`****?**
>  → Check throttling configuration

> **Need investigate** **`403`** **with explicit deny?**
>  → Check Resource Policy

> **Need identify backend latency?**
>  → IntegrationLatency / X-Ray

---

# 69. Final Architecture to Remember

```
                         CLIENTS

              ┌────────────┼────────────┐

              │            │            │

           Mobile       Website       Service

              │            │            │

              └────────────┼────────────┘

                           │

                         HTTPS

                           │

                           ▼

                  ┌─────────────────┐

                  │  API GATEWAY    │

                  │                 │

                  │ Authentication  │

                  │ Authorization   │

                  │ Throttling      │

                  │ Validation      │

                  │ Mapping         │

                  │ Caching         │

                  │ Monitoring      │

                  └────────┬────────┘

                           │

             ┌─────────────┼──────────────┐

             │             │              │

             ▼             ▼              ▼

          Lambda        HTTP/EC2      AWS Service

             │

             ▼

          DynamoDB
```

---

# ⭐ One-Line Summary

> **Amazon API Gateway is the managed front door for APIs: it receives client requests, authenticates and authorizes them, controls traffic, validates/transforms requests, routes them to backend services, and provides deployment, monitoring, and troubleshooting capabilities.**
