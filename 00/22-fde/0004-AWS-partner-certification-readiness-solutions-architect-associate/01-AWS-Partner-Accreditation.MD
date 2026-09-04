````markdown
# AWS Partner Certification Readiness — Solutions Architect Associate

## AWS Cloud Fundamentals

### Cloud Computing

Cloud computing allows organizations to focus on business and application development instead of infrastructure tasks such as:

- Procurement
- Hardware maintenance
- Capacity planning

### Deployment Models

| Model | Description |
|---|---|
| **On-Premises** | Infrastructure is managed within the organization's own environment |
| **Cloud** | Infrastructure is provided and managed through a cloud provider |
| **Hybrid** | Combination of on-premises and cloud infrastructure |

### Six Advantages of Cloud Computing

1. **Pay-as-you-go** — Pay for resources based on usage.
2. **Massive economies of scale** — Benefit from AWS's large-scale infrastructure.
3. **Stop guessing capacity** — Scale resources based on demand.
4. **Increase speed and agility** — Provision resources quickly.
5. **Realize cost savings** — Reduce infrastructure and operational costs.
6. **Go global in minutes** — Deploy applications across AWS Regions quickly.

---

# AWS Global Infrastructure

## Region

A **Region** is a geographical area containing AWS infrastructure.

Example:

```text
us-east-1
us-west-2
```

## Availability Zone

An **Availability Zone (AZ)** is an isolated location within an AWS Region.

```text
Region
├── AZ-A
├── AZ-B
└── AZ-C
```

An AZ consists of **one or more data centers**.

### Relationship

```text
AWS Region
    ↓
Availability Zones
    ↓
One or More Data Centers
```

## Edge Locations

**Edge Locations** are global AWS locations used to cache content closer to users.

They help reduce latency when delivering frequently accessed content.

---

## Choosing an AWS Region

Important factors include:

- **Latency** — Choose a Region close to users.
- **Pricing** — AWS pricing can vary by Region.
- **Service availability** — Not every AWS service or feature is available in every Region.
- **Data compliance** — Data location and regulatory requirements can influence Region selection.

---

## High Availability

For resilient applications, deploy resources across multiple Availability Zones.

```text
Region
├── AZ-A → Application
└── AZ-B → Application
```

If one AZ becomes unavailable, the other AZ can continue serving the application.

> **Easy Memory:** Multi-AZ → High Availability + Fault Tolerance

---

# Interacting with AWS

Common ways to interact with AWS:

1. **AWS Management Console** — Web-based interface.
2. **AWS CLI** — Command-line interface.
3. **AWS SDKs** — Programmatic access from applications.

---

# Authentication vs Authorization

## Authentication

**Authentication** verifies **who you are**.

Example:

```text
Email + Password
       ↓
Identity Verified
```

### Question answered:

> **Who are you?**

---

## Authorization

**Authorization** determines **what you are allowed to do** after authentication.

Examples:

- Read
- Create
- Edit
- Delete AWS resources

### Question answered:

> **What actions can you perform?**

### Easy Memory

```text
Authentication → Who are you?
Authorization  → What can you do?
```

---

# AWS IAM

**AWS Identity and Access Management (IAM)** controls access to AWS resources.

## IAM Features

- Global service
- Integrated with AWS services
- Shared access
- Multi-factor authentication (MFA)
- Identity federation
- Free to use

---

## IAM User

An **IAM user** represents a person or service that interacts with AWS.

An IAM user can sign in and access AWS resources according to assigned permissions.

---

## IAM Groups

An **IAM group** is a collection of IAM users.

Users in the group inherit the permissions assigned to the group.

```text
IAM Group
├── User A
├── User B
└── User C

Group Permissions
       ↓
Inherited by Users
```

> **Best Practice:** Use groups to manage permissions for multiple users.

---

## IAM Policies

**IAM policies** define permissions for AWS resources and services.

AWS evaluates the policies associated with an IAM identity when that identity makes a request.

```text
IAM Identity
     ↓
IAM Policy
     ↓
Permission
     ↓
AWS Resource
```

---

## IAM Roles

IAM roles provide permissions that can be assumed by trusted entities such as AWS services, applications, or users.

Roles are preferred when temporary or service-based access is appropriate.

---

## IAM Best Practices

- Lock down the **AWS root user**.
- Follow the **principle of least privilege**.
- Use IAM appropriately.
- Use **IAM roles** when possible.
- Consider using an identity provider.
- Regularly review and remove unused users, roles, and credentials.

> **Least Privilege:** Give only the permissions required to perform the task.

---

# Compute Options

AWS compute options can broadly be categorized as:

```text
Compute
├── Virtual Machines
├── Containers
└── Serverless
```

---

# Amazon EC2

**Amazon EC2 (Elastic Compute Cloud)** provides secure, resizable compute capacity in the cloud.

An EC2 instance is a **virtual server**.

### EC2 Provides

- Control over the operating system
- Software installation
- Instance configuration
- Flexible compute capacity
- Multiple operating system options

Examples include:

- Linux
- Ubuntu
- Windows
- macOS

### When to Use EC2

Use EC2 when you need significant control over the operating system and installed software.

Example:

> Need to install and configure Apache or Nginx → **Amazon EC2**

---

## EC2 Instance Lifecycle

```text
Pending
   ↓
Running
   ↓
Shutting Down
   ↓
Terminated
```

---

## EC2 Pricing Options

| Option | Key Idea |
|---|---|
| **On-Demand** | Pay for usage without long-term commitment |
| **Spot Instances** | Use spare AWS capacity at lower prices; can be interrupted |
| **Savings Plans** | Commit to a consistent amount of usage for 1 or 3 years |
| **Reserved Instances** | Reservation-based pricing option |
| **Dedicated Hosts** | Dedicated physical EC2 server |

---

## EC2 Instance Type

An EC2 instance type indicates:

```text
Instance Family + Instance Size
```

Example concept:

```text
Compute-Optimized + Large
```

---

# Containers

Containers are lightweight environments for running applications.

## Containers vs Virtual Machines

### Virtual Machine

Each VM has its own operating system.

```text
Host
├── VM
│   └── OS
├── VM
│   └── OS
└── VM
    └── OS
```

### Container

Containers share the host operating system kernel.

```text
Host OS
├── Container
├── Container
└── Container
```

### Key Difference

| Virtual Machines | Containers |
|---|---|
| Own operating system | Share host OS/kernel |
| More resource overhead | Lightweight |
| Slower startup | Very fast startup |
| More OS-level control | Efficient application packaging |

> **Easy Memory:** VM → Own OS | Container → Shared Kernel

---

# Container Orchestration

Running containers at scale introduces challenges such as:

- Where should containers be placed?
- What happens if a container fails?
- What happens if an EC2 instance fails?
- How are deployments monitored?
- How do we achieve high availability?

Organizations commonly run containers across multiple EC2 instances and Availability Zones.

---

# Amazon EKS

**Amazon Elastic Kubernetes Service (EKS)** is AWS's managed Kubernetes service.

**Kubernetes** is an open-source platform for managing containerized workloads and services.

```text
Containers
     ↓
Kubernetes
     ↓
Amazon EKS
```

---

# Serverless

Serverless allows developers to focus on application logic without managing servers.

### Four Important Characteristics

- No servers to provision or manage.
- Automatically scales with usage.
- No payment for idle resources.
- Availability and fault tolerance are built in.

> **Serverless:** You don't manage the underlying servers.

---

# AWS Fargate

**AWS Fargate** provides serverless compute for containers.

Fargate abstracts the underlying EC2 infrastructure.

You can use container concepts and AWS integrations without managing the EC2 instances underneath.

### Key Point

```text
Container
   ↓
Fargate
   ↓
No EC2 Server Management
```

Fargate integrates with services such as:

- IAM
- Amazon VPC
- Amazon ECS

---

# AWS Lambda

**AWS Lambda** lets you run code without provisioning or managing servers.

Lambda provides:

- Automatic scaling
- High availability
- Subsecond metering
- No server management

### When to Use Lambda

Use Lambda when you want to run application/backend code without managing EC2 instances or containers.

---

## Lambda Core Concepts

### Function

A **Lambda function** is the resource that can be invoked to run code.

### Trigger

A **trigger** defines when the Lambda function should run.

### Event

An **event** is a JSON-formatted input containing data for the Lambda function to process.

### Deployment Package

Contains the function code and dependencies.

Two types:

1. `.zip` archive
2. Container image

### Runtime

Provides the language-specific execution environment.

Examples:

- Python
- Node.js
- Java
- Ruby
- Go
- .NET

### Handler

The **Lambda handler** is the method that processes the incoming event.

Python example:

```python
def handler_name(event, context):
    # process event
    return some_value
```

### Lambda Flow

```text
Trigger
   ↓
Lambda Function
   ↓
Event
   ↓
Handler
   ↓
Response
```

> **Easy Memory:** Trigger → invokes → Function → processes → Event

---

# Networking

**Networking** allows computers and systems to communicate with each other.

---

# Amazon VPC

**Amazon VPC (Virtual Private Cloud)** is an isolated virtual network in AWS.

A VPC is created within a Region and spans the Availability Zones in that Region.

### Main VPC Configuration

When creating a VPC, define:

- VPC name
- AWS Region
- IP range using CIDR notation

Example:

```text
VPC
10.0.0.0/16
```

---

# Subnets

A **subnet** is a smaller network inside a VPC.

Each subnet belongs to a specific Availability Zone.

```text
VPC
│
├── AZ-A
│    └── Subnet
│
└── AZ-B
     └── Subnet
```

### Public vs Private Subnet

| Subnet | Purpose |
|---|---|
| **Public Subnet** | Resources that need internet connectivity |
| **Private Subnet** | Resources that should not be directly connected to the internet |

### High Availability

For redundancy and fault tolerance, create subnets across at least two Availability Zones.

---

# CIDR

CIDR notation defines the IP address range of a VPC or subnet.

Example:

```text
VPC     → 10.0.0.0/16
Subnet  → 10.0.0.0/24
```

The subnet CIDR must be a subset of the VPC CIDR.

---

# Reserved IP Addresses

AWS reserves **five IP addresses in each subnet** for networking, routing, DNS, and network management.

---

# VPC Gateways

## Internet Gateway

An **Internet Gateway (IGW)** provides internet connectivity for a VPC.

```text
VPC
 ↓
Internet Gateway
 ↓
Internet
```

The Internet Gateway must be attached to the VPC.

---

## Virtual Private Gateway

A **Virtual Private Gateway** connects a VPC to another private network.

```text
VPC
 ↓
Virtual Private Gateway
 ↓
Private Network
```

The AWS side uses the Virtual Private Gateway, while the other network uses a customer gateway.

---

# Route Tables

A **route table** contains routes that determine where network traffic is directed.

```text
Subnet
   ↓
Route Table
   ↓
Destination
```

When a VPC is created, AWS creates a **main route table**.

The main route table:

- Cannot be deleted.
- Can have routes added, removed, or modified.
- Is used implicitly by subnets without an explicit route table association.
- Can be replaced as the main route table.

### Custom Route Tables

Custom route tables allow different subnets to have different routing behavior.

```text
Public Subnet
     ↓
Public Route Table
     ↓
Internet Gateway

Private Subnet
     ↓
Private Route Table
```

---

# VPC Security

## Security Group

A **Security Group** is a virtual firewall associated with resources such as EC2 instances.

Default behavior:

```text
Inbound  → Blocked
Outbound → Allowed
```

Inbound traffic must be explicitly allowed through inbound rules.

---

## Network ACL

A **Network ACL (NACL)** secures traffic at the **subnet level**.

### Security Group vs NACL

| Security Group | Network ACL |
|---|---|
| Secures resources such as EC2 | Secures subnets |
| Instance/resource level | Subnet level |

> **Easy Memory:** Security Group → Instance | NACL → Subnet

---

# Amazon EBS

**Amazon Elastic Block Store (EBS)** provides block storage for EC2.

Use EBS when an application needs storage for workloads such as a **high-transaction, I/O-intensive relational database running on EC2**.

```text
EC2
 ↓
EBS
 ↓
Block Storage
```

### Storage Types

```text
Object Storage → S3
Block Storage  → EBS
File Storage   → EFS
```

---

# AWS Cloud Adoption Framework (AWS CAF)

The **AWS Cloud Adoption Framework (AWS CAF)** helps organizations build and implement a comprehensive plan for cloud adoption and digital transformation.

## Transformation Phases

```text
Envision
   ↓
Align
   ↓
Launch
   ↓
Scale
```

### Envision

Identify transformation opportunities and business outcomes.

### Align

Identify gaps and establish the best approach to guide the organization's cloud journey.

### Launch

Begin implementing prioritized transformation initiatives.

### Scale

Expand successful initiatives across the organization.

### Key Facts

- AWS CAF has **6 perspectives**.
- **Align** establishes the best approach to guide the organization during its cloud journey.

---

# AWS Migration Strategies

Customers choose migration strategies based on the application and business requirements.

There are **7 common migration strategies**:

```text
1. Retire
2. Retain
3. Rehost
4. Relocate
5. Repurchase
6. Replatform
7. Refactor / Re-architect
```

| Strategy | Meaning |
|---|---|
| **Retire** | Remove applications that are no longer needed |
| **Retain** | Keep the workload as-is |
| **Rehost** | Move to AWS with minimal changes |
| **Relocate** | Move workloads to another AWS environment/service with minimal changes |
| **Repurchase** | Replace with a different product, often SaaS |
| **Replatform** | Make limited optimizations while migrating |
| **Refactor / Re-architect** | Significantly redesign the application for cloud-native capabilities |

### Easy Memory

```text
Rehost    → Move
Replatform→ Optimize
Refactor  → Redesign
```

---

# AWS Well-Architected Framework

The **AWS Well-Architected Framework** provides best practices for designing and operating reliable, secure, efficient, and sustainable workloads.

## Six Pillars

### 1. Operational Excellence

Focuses on people, processes, and operations.

Examples:

- Automating changes
- Responding to events
- Defining operational standards

### 2. Security

Protects data, systems, and information.

Examples:

- Least privilege
- Credential management
- Security controls
- Detecting and responding to security events

### 3. Reliability

Ensures workloads can recover from failures and continue operating.

Examples:

- High availability
- Fault tolerance
- Recovery planning
- Resilient architecture

### 4. Performance Efficiency

Uses AWS resources efficiently to meet workload requirements.

Examples:

- Selecting appropriate resource types and sizes
- Monitoring performance
- Using elasticity

### 5. Cost Optimization

Maximizes the value received from AWS spending.

Examples:

- Understanding spending
- Selecting appropriate resources
- Monitoring costs over time

### 6. Sustainability

Minimizes the environmental impact of cloud workloads.

Examples:

- Improving resource utilization
- Reducing unnecessary resources
- Understanding environmental impact

### Easy Memory

```text
Operational Excellence
Security
Reliability
Performance Efficiency
Cost Optimization
Sustainability
```

---

# Important Certification Questions

## 1. S3 Lifecycle

### Question

A highly scalable system must store backup files that need immediate download access for one year and then be deleted.

### Answer

**Amazon S3 + Lifecycle Policy**

```text
S3
 ↓
Store Backup Files
 ↓
Lifecycle Policy
 ↓
Delete After 1 Year
```

---

## 2. High-Traffic E-Commerce Website

For an e-commerce application expected to handle high traffic, **Amazon DynamoDB** can be an appropriate database option when the workload fits its NoSQL model and scalability requirements.

---

## 3. AWS Fargate

**Fargate** is serverless compute for containers.

Use it when you want to run containers without managing the underlying EC2 instances.

---

## 4. HTTP/HTTPS Load Balancing

For HTTP and HTTPS traffic:

**Application Load Balancer (ALB)**

```text
HTTP / HTTPS
      ↓
     ALB
      ↓
Application
```

---

## 5. Quickly Migrate and Scale

If a workload needs to be migrated quickly with minimal changes:

**Rehost**

> **Rehost = Lift and Shift**

---

## 6. Install an HTTP Server

If a developer needs to install and configure an HTTP server such as **Apache or Nginx**, they need operating-system-level control.

### Answer

**Amazon EC2**

> EC2 provides control over the operating system and software installation.

---

## 7. Amazon RDS Responsibility

A database administrator using Amazon RDS is responsible for tasks such as:

**Database tuning and query optimization**

AWS manages much of the underlying infrastructure, while customers remain responsible for database-level tasks within the managed service.

---

## 8. Cloud Readiness Framework

### Question

Which AWS framework helps customers achieve cloud readiness for successful migration?

### Answer

**AWS Cloud Adoption Framework (AWS CAF)**

---

## 9. DynamoDB Data Structure

```text
Table
  ↓
Items
  ↓
Attributes
```

- **Table** → Collection of items
- **Item** → Collection of attributes
- **Attribute** → Individual data element

> **Easy Memory:** Table → Items → Attributes

---

## 10. Transactional and I/O-Intensive Storage

For transactional and I/O-intensive workloads:

**Block Storage → Amazon EBS**

```text
Transactional
      +
I/O Intensive
      ↓
Block Storage
      ↓
Amazon EBS
```

---

## 11. EC2 Auto Scaling

**EC2 Auto Scaling = Fleet Management + Automatic Scaling**

It manages a fleet of EC2 instances and adjusts capacity based on demand.

---

## 12. NFS / SMB Storage

For applications requiring standard file-system protocols such as:

- NFS
- SMB

### Answer

**File Storage**

AWS example:

**Amazon EFS** for NFS-based file storage.

> **Easy Memory:**

```text
NFS / SMB → File Storage
S3        → Object Storage
EBS       → Block Storage
```

---

## 13. Fault Tolerance

For redundancy and fault tolerance:

**Use at least two Availability Zones.**

```text
Region
├── AZ-A → Application
└── AZ-B → Application
```

---

## 14. Recommendation Engine

For relationship-based recommendation use cases:

### Answer

**Amazon Neptune**

Neptune is a **graph database** that can model relationships such as:

```text
Users
  ↓
Movies
  ↓
Genres
  ↓
Actors
  ↓
Viewing History
```

> **Easy Memory:** Recommendations → Relationships → Graph → Neptune

---

## 15. CloudWatch Alarms

### Question

Automatically initiate actions based on sustained metric state changes.

### Answer

**CloudWatch Alarms**

Example:

```text
CPU > 80% for 5 minutes
          ↓
CloudWatch Alarm
          ↓
Action
```

> **Easy Memory:** Metric → Threshold → Alarm → Action

---

## 16. Cloud-Native Migration

### Question

A monolithic application is redesigned to become cloud-native.

### Answer

**Refactor / Re-architect**

```text
Monolith
   ↓
Refactor
   ↓
Cloud-Native Architecture
```

Examples of cloud-native architecture can include:

- Microservices
- Containers
- Serverless

> **Easy Memory:** Cloud-native transformation → Refactor

---

## 17. Elastic File System

### Question

Which file system automatically grows and shrinks as files are added and removed?

### Answer

**Amazon EFS**

```text
Files Added
    ↓
EFS Grows

Files Removed
    ↓
EFS Shrinks
```

> **Easy Memory:** EFS = Elastic File System

---

## 18. Lambda Function

### Question

Which Lambda concept is a resource that can be invoked to run code?

### Answer

**Function**

```text
Trigger
   ↓
Lambda Function
   ↓
Processes Event
```

### Distinguish the Terms

| Concept | Meaning |
|---|---|
| **Function** | Lambda resource that runs code |
| **Trigger** | Causes/invokes the function |
| **Event** | Input/data passed to the function |
| **Deployment Package** | Function code and dependencies |

> **Easy Memory:** Trigger → invokes → Function → processes → Event

---

# Serverless Pricing

With serverless services, you generally **pay based on usage rather than paying for idle server capacity**.

Different serverless services have different pricing models based on their usage metrics.

```text
Usage
  ↓
Serverless Service
  ↓
Pay Based on Usage
```

> **Easy Memory:** Serverless → No server management + No paying for idle server capacity.

---

# Final Quick Revision

```text
AWS Global Infrastructure
Region → AZ → Data Center

Authentication → Who are you?
Authorization  → What can you do?

IAM
User → Group → Policy → Role

Compute
EC2 → Virtual Machine
EKS → Kubernetes / Containers
Fargate → Serverless Containers
Lambda → Serverless Code

Storage
S3  → Object
EBS → Block
EFS → File

Networking
VPC → Network
Subnet → Smaller network
IGW → Internet connectivity
Route Table → Traffic direction
Security Group → Instance/resource security
NACL → Subnet security

Migration
Rehost      → Move
Replatform  → Optimize
Refactor    → Redesign

AWS CAF
Envision → Align → Launch → Scale

Well-Architected
Operational Excellence
Security
Reliability
Performance Efficiency
Cost Optimization
Sustainability
```

## ⭐ High-Value Exam Associations

```text
HTTP/HTTPS Load Balancing → ALB
High I/O Transactional    → EBS
NFS / SMB                 → File Storage
Elastic File System       → EFS
Object Storage            → S3
Graph / Recommendations   → Neptune
Metric Threshold → Action → CloudWatch Alarm
Install Apache/Nginx      → EC2
Container without EC2     → Fargate
Serverless Code           → Lambda
Cloud-Native Redesign     → Refactor
Quick Migration           → Rehost
Cloud Readiness           → AWS CAF
Multi-AZ                  → High Availability
Least Privilege           → IAM
```
````

