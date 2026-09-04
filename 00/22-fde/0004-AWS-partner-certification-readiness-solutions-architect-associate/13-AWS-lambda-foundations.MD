# AWS Lambda Foundations

## What is AWS Lambda?

**AWS Lambda** is an **event-driven, serverless compute service** that lets you run code without provisioning or managing servers.

AWS manages the underlying infrastructure, including:

- Servers
- Operating systems
- Capacity provisioning
- Automatic scaling
- Infrastructure maintenance

You focus mainly on your **application code**.

> **Easy Memory:**  
> **Lambda = Run code without managing servers**

---

# Why Lambda?

Traditional application hosting requires you to manage servers:

```text
Application
    ↓
EC2 / Server
    ↓
OS
    ↓
Infrastructure
    ↓
You manage everything
```

With Lambda:

```text
Application Code
      ↓
    Lambda
      ↓
AWS manages infrastructure
```

### Main Benefits

- Serverless
- Automatic scaling
- Event-driven execution
- No server management
- Pay for usage
- Easy integration with AWS services

---

# Lambda Function

The code that runs on Lambda is called a **Lambda function**.

A Lambda function can contain:

- Application code
- Runtime
- Memory configuration
- Timeout
- Environment variables
- IAM execution role

Lambda functions are generally:

- **Stateless**
- Independently executable
- Automatically scalable
- Event-driven

```text
Event
  ↓
Lambda Function
  ↓
Business Logic
  ↓
Result / Next Action
```

---

# Event-Driven Architecture

Lambda is commonly used in **event-driven architectures**.

```text
Event Source
     ↓
   Event
     ↓
   Lambda
     ↓
Business Logic
     ↓
AWS Service / Response
```

Common event sources include:

- Amazon S3
- Amazon SQS
- Amazon SNS
- Amazon EventBridge
- Amazon API Gateway
- DynamoDB Streams
- Amazon Kinesis

> **Easy Memory:**  
> **Something happens → Event → Lambda runs**

---

# Lambda Invocation Models

Lambda supports three major invocation models.

| Invocation Model | How It Works | Example |
|---|---|---|
| **Synchronous** | Caller waits for the response | API Gateway → Lambda |
| **Asynchronous** | Event is queued and Lambda processes it later | S3 → Lambda |
| **Polling / Event Source Mapping** | Lambda polls the event source | SQS → Lambda |

---

## Synchronous Invocation

The caller waits for Lambda to finish and return a response.

```text
Client
  ↓
API Gateway
  ↓
Lambda
  ↓
Response
  ↓
Client
```

Examples:

- API Gateway
- Direct Lambda invocation

> **Key Point:** No automatic Lambda retry for synchronous invocation.

---

## Asynchronous Invocation

The event is placed in a queue and Lambda processes it asynchronously.

```text
S3
 ↓
Event
 ↓
Lambda
 ↓
Processing
```

Lambda automatically retries failed asynchronous invocations.

> **Exam Point:**  
> **Asynchronous Lambda invocation → 2 automatic retries**

---

## Polling / Event Source Mapping

Lambda polls certain event sources and invokes the function when records/messages are available.

Example:

```text
SQS
 ↓
Lambda Polling
 ↓
Lambda Function
 ↓
Process Message
```

Common examples:

- Amazon SQS
- Kinesis
- DynamoDB Streams

---

# Important Invocation Examples

```text
API Gateway → Lambda
       ↓
Synchronous
```

```text
S3 → Lambda
   ↓
Asynchronous
```

```text
SQS → Lambda
   ↓
Polling
```

> **Easy Memory:**
>
> **API Gateway = Wait**  
> **S3 = Queue**  
> **SQS = Poll**

---

# Lambda Execution Environment

Lambda runs your function inside a **secure, isolated execution environment**.

```text
Lambda Invocation
       ↓
Execution Environment
       ↓
Runtime
       ↓
Handler
       ↓
Business Logic
       ↓
Response
```

The execution environment contains the resources required to execute the function.

---

# Cold Start

A **cold start** occurs when Lambda needs to create a new execution environment before executing the function.

```text
Request
   ↓
Create Execution Environment
   ↓
Initialize Runtime
   ↓
Load Code / Dependencies
   ↓
Initialization
   ↓
Handler
```

Cold starts introduce additional latency.

### Cold Starts Can Occur When

- A new execution environment is required.
- Concurrency increases.
- A function is updated.
- Existing execution environments are not available.

---

# Warm Start

A **warm start** occurs when Lambda reuses an existing execution environment.

```text
Request
   ↓
Existing Environment
   ↓
Handler
```

Because the environment already exists, initialization work can be avoided.

> **Easy Memory:**
>
> **Cold = Create environment**
>
> **Warm = Reuse environment**

---

# Provisioned Concurrency

**Provisioned Concurrency** keeps execution environments initialized and ready before requests arrive.

```text
Provisioned Concurrency
        ↓
Pre-initialized Environments
        ↓
Request
        ↓
Low / Predictable Startup Latency
```

Useful when applications require:

- Low latency
- Predictable response times
- Reduced cold-start impact

---

# Lambda Handler

The **handler** is the entry point that Lambda invokes.

The handler typically receives:

### Event

Contains information about what triggered the function.

### Context

Contains information about the Lambda invocation and execution environment.

```text
Event
  ↓
Handler(event, context)
  ↓
Business Logic
  ↓
Response
```

> **Easy Memory:**
>
> **Event = What happened**
>
> **Context = Execution information**
>
> **Handler = Entry point**

---

# Lambda IAM Permissions

There are two important permission concepts.

```text
Who can invoke Lambda?
        ↓
Resource-Based Policy
```

```text
What can Lambda access?
        ↓
Execution Role
```

---

## Resource-Based Policy

A **resource-based policy** controls **who or what can invoke a Lambda function**.

Example:

```text
S3
 ↓
Lambda Resource Policy
 ↓
Invoke Lambda
```

It can grant invocation permissions to:

- AWS services
- AWS accounts
- IAM principals

---

## Execution Role

The **Lambda execution role** controls what AWS resources the Lambda function can access.

Example:

```text
Lambda
   ↓
Execution Role
   ↓
DynamoDB
```

If Lambda needs to write to DynamoDB:

```text
Lambda
   ↓
IAM Execution Role
   ↓
dynamodb:PutItem
   ↓
DynamoDB
```

The execution role must trust the Lambda service.

> **Easy Memory:**

```text
Resource-Based Policy
→ WHO can invoke Lambda?

Execution Role
→ WHAT can Lambda access?
```

### Security Principle

Always follow **least privilege**.

---

# Lambda + VPC

Lambda functions can access resources inside an **Amazon VPC**.

You configure:

- VPC
- Subnets
- Security groups

```text
Lambda
  ↓
VPC
  ↓
Subnets
  ↓
Private Resources
```

The Lambda execution role needs the required permissions for VPC access.

---

# Lambda + AWS PrivateLink

Lambda APIs can be accessed privately through an **interface VPC endpoint** using AWS PrivateLink.

```text
VPC
 ↓
Interface VPC Endpoint
 ↓
AWS PrivateLink
 ↓
Lambda API
```

This can help keep traffic within the AWS network instead of traversing the public internet.

---

# Lambda Runtimes

Lambda supports multiple programming languages/runtimes, including:

- Python
- Node.js
- Java
- Go
- C#
- Ruby
- PowerShell
- Custom runtimes

---

# Lambda Deployment Options

Lambda functions can be deployed using different approaches.

## Lambda Console

Useful for:

- Learning
- Testing
- Simple functions
- Quick experimentation

---

## ZIP Deployment Package

Application code and dependencies can be packaged into a ZIP archive.

```text
Code
 +
Dependencies
 ↓
ZIP
 ↓
Lambda
```

---

## Container Image

Lambda also supports deploying functions as container images.

```text
Container Image
       ↓
Amazon ECR
       ↓
Lambda
```

> **Easy Memory:**
>
> **ZIP → Code package**
>
> **Container Image → ECR → Lambda**

---

# AWS SAM

**AWS Serverless Application Model (AWS SAM)** is an open-source framework for building serverless applications.

It provides simplified syntax for defining resources such as:

- Lambda functions
- APIs
- Databases
- Event sources

```text
SAM Template
     ↓
SAM Transform
     ↓
CloudFormation
     ↓
AWS Resources
```

> **Easy Memory:**  
> **SAM = Simplified way to define serverless applications**

---

# AWS SAM CLI

The **SAM CLI** helps developers build, test, debug, and deploy serverless applications.

Common commands:

```text
sam init
   ↓
Initialize application

sam build
   ↓
Build application

sam local
   ↓
Test locally

sam validate
   ↓
Validate template

sam deploy
   ↓
Deploy application
```

---

# Lambda Configuration

Important Lambda configuration areas include:

```text
Memory
Timeout
Concurrency
Environment Variables
IAM Role
Runtime
```

---

# Lambda Memory

Lambda memory configuration affects the compute resources allocated to the function.

```text
More Memory
     ↓
More CPU / Compute
     ↓
Potentially Faster Execution
```

Lambda pricing is influenced by:

```text
Memory Allocated × Execution Duration
```

> **Important:**  
> You are charged based on the **configured memory**, not simply the amount of memory your application actually uses.

---

# Lambda Timeout

The maximum Lambda function timeout is:

**900 seconds = 15 minutes**

```text
Invocation
    ↓
Maximum 900 seconds
    ↓
Function Terminates
```

Don't automatically configure every function with the maximum timeout.

Choose a timeout based on the workload.

---

# Lambda Cost Optimization

Lambda costs are primarily influenced by:

- Number of requests
- Execution duration
- Configured memory

### Important Relationship

```text
Memory
  ↓
CPU
  ↓
Execution Time
  ↓
Cost
```

Increasing memory can sometimes **reduce total cost** if the function completes significantly faster.

---

# Lambda Power Tuning

**AWS Lambda Power Tuning** helps identify a suitable balance between:

- Cost
- Execution speed
- Performance

Conceptually:

```text
Memory Configuration
        ↓
Execution Time
        ↓
Cost
        ↓
Find Optimal Configuration
```

---

# Lambda Concurrency

**Concurrency** is the number of Lambda function invocations running at the same time.

Example:

```text
Request 1 → Running
Request 2 → Running
Request 3 → Running

Concurrency = 3
```

Lambda automatically creates execution environments to handle concurrent invocations.

---

# Types of Lambda Concurrency

## Unreserved Concurrency

Uses the account's available concurrency capacity.

---

## Reserved Concurrency

Reserved concurrency:

- Reserves concurrency for a function.
- Sets a maximum concurrency limit for that function.

Useful for:

- Protecting downstream services
- Controlling costs
- Preventing one function from consuming all available concurrency

```text
Lambda
  ↓
Reserved Concurrency = 100
  ↓
Maximum 100 concurrent executions
```

---

## Provisioned Concurrency

Provisioned concurrency keeps execution environments initialized and ready.

Useful for reducing cold-start latency.

> **Easy Memory:**

```text
Reserved Concurrency
→ CONTROL / LIMIT

Provisioned Concurrency
→ KEEP WARM
```

---

# Why Control Concurrency?

Lambda can scale quickly, but unlimited concurrency may overwhelm downstream systems.

Example:

```text
Users
  ↓
Lambda
  ↓
1000 concurrent requests
  ↓
RDS
```

If RDS cannot handle the load, it can become a bottleneck.

Reserved concurrency can help control the number of concurrent Lambda executions.

```text
Lambda
  ↓
Concurrency Limit
  ↓
Protect RDS
```

---

# Lambda Automatic Scaling

Lambda automatically scales execution environments based on incoming requests.

```text
Low Traffic
    ↓
Few Execution Environments

High Traffic
    ↓
More Execution Environments
```

Lambda concurrency quotas still apply.

---

# Lambda Monitoring

Lambda integrates with **Amazon CloudWatch**.

Important metrics include:

- Invocations
- Duration
- Errors
- Throttles
- ConcurrentExecutions
- UnreservedConcurrentExecutions
- IteratorAge
- DeadLetterErrors

```text
Lambda
  ↓
CloudWatch
  ↓
Metrics
  ↓
Dashboards / Alarms
```

---

# Lambda Insights

**CloudWatch Lambda Insights** provides deeper performance visibility.

It can provide information about:

- Memory usage
- CPU/resource behavior
- Network activity
- Cold starts
- Performance
- Execution environment behavior

Useful for troubleshooting and performance optimization.

---

# AWS X-Ray

**AWS X-Ray** helps trace and troubleshoot application requests.

It can help identify:

- Performance bottlenecks
- Request paths
- Service dependencies
- Failures
- Latency issues

```text
Request
  ↓
Lambda
  ↓
X-Ray
  ↓
Trace / Service Map
  ↓
Identify Bottleneck
```

---

# Monitoring Tools — Easy Comparison

| Tool | Main Purpose |
|---|---|
| **CloudWatch** | Metrics, logs, alarms |
| **Lambda Insights** | Detailed Lambda performance |
| **X-Ray** | Distributed tracing |
| **CloudTrail** | AWS API auditing |
| **DLQ** | Review failed asynchronous events |

> **Easy Memory:**
>
> **CloudWatch → Monitor**
>
> **X-Ray → Trace**
>
> **CloudTrail → Audit**
>
> **DLQ → Failed Events**

---

# Lambda Versions

Lambda supports **versioning** to manage different releases of a function.

The unpublished development version is:

```text
$LATEST
```

When a version is published, it becomes immutable.

```text
$LATEST
   ↓
Publish
   ↓
Version 1
   ↓
Version 2
   ↓
Version 3
```

---

# Lambda Aliases

An **alias** is a pointer to a published Lambda version.

Example:

```text
Alias: production
        ↓
     Version 5
```

Aliases make it easier to manage application environments and deployments.

Example:

```text
dev
 ↓
Version 5

test
 ↓
Version 6

prod
 ↓
Version 5
```

> **Important:**  
> An alias points to a **published version**, not `$LATEST`.

---

# Lambda Traffic Shifting

Lambda aliases can route traffic between published versions.

Example:

```text
90% → Version 1
10% → Version 2
```

This can be useful for controlled testing and safer deployments.

---

# Lambda + AWS CodeDeploy

AWS CodeDeploy can be used for safer Lambda deployments.

Deployment strategies include:

### Canary

Move traffic in stages.

```text
Old Version → 90%
New Version → 10%

Then

Old Version → 0%
New Version → 100%
```

### Linear

Gradually shift traffic over time.

### All-at-once

Move all traffic to the new version immediately.

CodeDeploy can also work with:

- CloudWatch alarms
- Pre-traffic hooks
- Post-traffic hooks
- Automatic rollback

---

# Lambda + CloudFormation

**AWS CloudFormation** can define Lambda and related infrastructure as code.

Example:

```text
CloudFormation Template
        ↓
Lambda
IAM
API Gateway
DynamoDB
        ↓
CloudFormation Stack
```

Benefits:

- Repeatable deployments
- Infrastructure consistency
- Version-controlled infrastructure
- Easier environment creation

---

# Common Lambda Architecture

```text
                  User
                   ↓
             API Gateway
                   ↓
              Lambda
                   ↓
        ┌──────────┼──────────┐
        ↓          ↓          ↓
    DynamoDB       S3        SQS
        ↓
    Application
```

Monitoring:

```text
Lambda
  ├── CloudWatch
  └── X-Ray
```

---

# Lambda + Event-Driven Architecture

A common serverless pattern:

```text
              Event Source
                   ↓
              Lambda
                   ↓
             Business Logic
                   ↓
          AWS Managed Services
```

Example:

```text
User uploads file
       ↓
      S3
       ↓
    Lambda
       ↓
Process File
       ↓
DynamoDB / S3
```

---

# Important Lambda Best Practices

## Keep Functions Stateless

Do not depend on local execution state for application persistence.

Use services such as:

- DynamoDB
- S3
- RDS
- ElastiCache

for persistent data where appropriate.

---

## Reuse Connections

When appropriate, initialize reusable resources outside the handler.

```text
Execution Environment
        ↓
Initialize Connection
        ↓
Handler Invocations
        ↓
Reuse Connection
```

This can improve performance during warm invocations.

---

## Keep Dependencies Small

Large deployment packages can increase initialization time.

Use only required dependencies.

---

## Use Environment Variables

Keep configuration outside application code.

Examples:

```text
DATABASE_URL
TABLE_NAME
ENVIRONMENT
API_ENDPOINT
```

Do not store sensitive credentials directly in environment variables when a dedicated secrets-management solution is more appropriate.

---

## Follow Least Privilege

Give the Lambda execution role only the permissions required by the function.

```text
Lambda
  ↓
IAM Role
  ↓
Only Required Permissions
```

---

# Lambda Limits to Remember

| Configuration | Important Point |
|---|---|
| **Maximum Timeout** | 900 seconds / 15 minutes |
| **Memory** | Configurable; more memory also provides more CPU |
| **Concurrency** | Controlled by Lambda/account/function quotas |
| **Versions** | Published versions are immutable |
| **Aliases** | Point to published versions |

---

# ⭐ Quick Revision

```text
AWS Lambda
    ↓
Serverless Compute
    ↓
Event-Driven
    ↓
Automatic Scaling
    ↓
Stateless Functions
    ↓
Pay for Usage
```

### Core Concepts

> **Lambda** → Run code without managing servers.

> **Function** → Code executed by Lambda.

> **Handler** → Entry point of the function.

> **Event** → Input that triggers the function.

> **Context** → Information about the invocation/environment.

> **Execution Role** → What Lambda can access.

> **Resource-Based Policy** → Who can invoke Lambda.

> **Cold Start** → New execution environment initialization.

> **Warm Start** → Reused execution environment.

> **Provisioned Concurrency** → Keeps environments initialized.

> **Reserved Concurrency** → Reserves and limits concurrency.

> **Concurrency** → Number of simultaneous invocations.

> **SAM** → Framework for serverless applications.

> **CloudWatch** → Metrics, logs, alarms.

> **X-Ray** → Distributed tracing.

> **CloudTrail** → API auditing.

> **ECR** → Container images for Lambda container deployments.

---

# 🧠 Easy Memory

```text
LAMBDA

EVENT       → TRIGGER
FUNCTION    → CODE
HANDLER     → ENTRY POINT
ROLE        → WHAT LAMBDA CAN ACCESS
POLICY      → WHO CAN INVOKE
COLD START  → NEW ENVIRONMENT
WARM START  → REUSE ENVIRONMENT
CONCURRENCY → SIMULTANEOUS EXECUTIONS
RESERVED    → LIMIT / PROTECT
PROVISIONED → KEEP WARM
SAM         → SERVERLESS DEVELOPMENT
CLOUDWATCH  → MONITOR
X-RAY       → TRACE
CLOUDTRAIL  → AUDIT
```

# 🎯 AWS FDE / Exam Takeaways

> **Need to run code without managing servers?**  
> → **AWS Lambda**

> **Need event-driven serverless compute?**  
> → **AWS Lambda**

> **Need API request → function → response?**  
> → **API Gateway + Lambda**

> **Need S3 event processing?**  
> → **S3 + Lambda**

> **Need queue-based processing?**  
> → **SQS + Lambda**

> **Need to control who can invoke Lambda?**  
> → **Resource-based policy**

> **Need to control what Lambda can access?**  
> → **Execution role**

> **Need low/predictable startup latency?**  
> → **Provisioned Concurrency**

> **Need to limit Lambda's maximum concurrency?**  
> → **Reserved Concurrency**

> **Need metrics and logs?**  
> → **CloudWatch**

> **Need distributed tracing?**  
> → **AWS X-Ray**

> **Need serverless infrastructure as code?**  
> → **AWS SAM / CloudFormation**

> **Need safe Lambda deployments?**  
> → **Versions + Aliases + CodeDeploy**

## ⭐ One-Line Summary

> **AWS Lambda is an event-driven, serverless compute service that automatically runs and scales application code without requiring you to provision or manage servers.**