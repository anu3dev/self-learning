````markdown
# AWS Technical Essentials — Solutions Architect Associate

> **Course:** AWS Partner Certification Readiness – Solutions Architect – Associate  
> **Topic:** AWS Technical Essentials

---

# 1. AWS Storage Fundamentals

Cloud computing allows you to create, modify, and delete storage resources quickly.

AWS storage can be broadly categorized into:

```text
AWS Storage
├── Object Storage → Amazon S3
├── Block Storage  → Amazon EBS / EC2 Instance Store
└── File Storage   → Amazon EFS / Amazon FSx
```

---

# 2. File vs Block vs Object Storage

## File Storage

File storage organizes data using a hierarchical structure:

```text
Folder
 ├── Subfolder
 │    ├── File
 │    └── File
 └── File
```

Examples of use cases:

- Web serving
- Analytics
- Media and entertainment
- Home directories

---

## Block Storage

Block storage divides data into fixed-size blocks.

```text
1 GB File
   ↓
Block 1
Block 2
Block 3
Block 4
...
```

Each block has its own address.

Because individual blocks can be accessed directly, block storage is optimized for **low-latency and high-performance workloads**.

### Best Use Cases

- Transactional workloads
- Databases
- Virtual machines
- Containers
- Mission-critical applications
- I/O-intensive applications

> **Easy Memory:**  
> Transactional + I/O intensive → **Block Storage → EBS**

---

## Object Storage

Object storage treats each file as a single object.

```text
Object
├── Data
├── Metadata
└── Unique Identifier
```

Objects are stored in a flat structure inside a **bucket**.

Unlike block storage, changing a small portion of an object generally requires updating the entire object.

### Best Use Cases

- Backup and recovery
- Data archiving
- Rich media
- Large datasets
- Unstructured data

> **Easy Memory:**  
> Large + Unstructured + Scalable → **Object Storage → S3**

---

# 3. Amazon EFS

**Amazon Elastic File System (EFS)** is a managed, elastic file system.

It automatically grows and shrinks as files are added or removed.

```text
Files Added
    ↓
EFS grows

Files Removed
    ↓
EFS shrinks
```

### Key Features

- No need to provision storage capacity in advance.
- Automatically scales.
- Can be accessed by many compute instances simultaneously.
- Supports AWS compute services and on-premises resources.
- Can support tens, hundreds, or thousands of compute instances.

> **Easy Memory:**  
> **EFS = Elastic File System = Automatically grows/shrinks**

---

# 4. Amazon FSx

**Amazon FSx** is a fully managed file-system service.

It provides managed versions of popular file systems:

| Amazon FSx | File System |
|---|---|
| **FSx for NetApp ONTAP** | NetApp ONTAP |
| **FSx for OpenZFS** | OpenZFS |
| **FSx for Windows File Server** | Windows File Server |
| **FSx for Lustre** | Lustre |

### Common Use Cases

- Machine learning
- Analytics
- High-performance computing
- Media and entertainment

> **Easy Memory:**  
> Need a specific/third-party file system → **Amazon FSx**

---

# 5. EC2 Instance Store

**EC2 Instance Store** provides temporary block-level storage physically attached to the host running the EC2 instance.

It is **ephemeral storage**.

```text
EC2 Instance
     ↓
Instance Store
     ↓
Temporary Data
```

If the EC2 instance is deleted, the instance-store data is also deleted.

### Good Use Cases

- Buffers
- Caches
- Scratch data
- Temporary content
- Applications that replicate data elsewhere
- Hadoop/cluster workloads

> **Easy Memory:**  
> Instance Store → **Fast + Temporary + Ephemeral**

---

# 6. Amazon EBS

**Amazon Elastic Block Store (EBS)** provides persistent block-level storage for EC2.

```text
EC2
 ↓
EBS Volume
 ↓
Persistent Block Storage
```

## Key Characteristics

- Block storage
- Persistent
- Can be detached and attached to another EC2 instance in the same AZ
- Can be backed up using snapshots
- Commonly used for databases and operating systems
- Storage is provisioned in advance
- Most EBS volumes normally have a one-to-one relationship with an EC2 instance

> **Easy Memory:**  
> **EBS = Persistent Block Storage for EC2**

---

## EBS Multi-Attach

Provisioned IOPS SSD `io1` and `io2` volumes can support **Multi-Attach** for supported configurations.

This allows an EBS volume to be attached to multiple EC2 instances simultaneously.

The instances must be in the **same Availability Zone**.

---

# 7. EBS Volume Types

EBS volumes are broadly divided into:

```text
EBS
├── SSD
└── HDD
```

## SSD

Performance is primarily associated with **IOPS**.

Best for:

- Transactional workloads
- Databases
- Boot volumes
- Frequent small read/write operations

## HDD

Performance is primarily associated with **throughput (MB/s)**.

Best for:

- Big data
- Data warehouses
- Log processing
- Sequential I/O
- Throughput-intensive workloads

### Easy Memory

```text
IOPS / Transactional → SSD
Throughput / Streaming → HDD
```

---

# 8. EBS Snapshots

An **EBS snapshot** is a backup of an EBS volume.

Snapshots are **incremental backups**.

Example:

```text
Initial Volume
10 GB

After changes:
2 GB changed

Next Snapshot
→ Only changed blocks are saved
```

EBS snapshots are stored redundantly using Amazon S3 infrastructure.

### Snapshot Benefits

- Backup EBS volumes.
- Create new EBS volumes.
- Create volumes in another Availability Zone.
- Recover data from previous states.

> **Easy Memory:**  
> EBS → Snapshot → Backup

---

# 9. Amazon S3

**Amazon Simple Storage Service (S3)** is an object storage service.

Unlike EBS, S3 is **not attached to compute**.

```text
Application
    ↓
Amazon S3
    ↓
Objects
```

Objects are stored inside **buckets**.

### Object Identification

An S3 object is identified using:

```text
Bucket Name
     +
Object Key
     +
Version ID
```

---

# 10. Amazon S3 Use Cases

Common use cases:

- Backup and storage
- Media hosting
- Software delivery
- Data lakes
- Static websites
- Static content

---

# 11. S3 Default Security

Amazon S3 resources are **private by default**.

This includes:

- Buckets
- Objects

Access must be explicitly granted when required.

---

# 12. S3 IAM Policies vs Bucket Policies

## IAM Policies

IAM policies can be attached to identities such as:

- Users
- Groups
- Roles

They can also be used to manage access to AWS resources.

Useful when:

- You have many buckets with different permission requirements.
- You want centralized permission management.

---

## S3 Bucket Policies

S3 bucket policies are JSON-based policies attached specifically to an S3 bucket.

The policy applies to objects within that bucket.

Useful when:

- You need simple cross-account S3 access.
- IAM policy size limits are a concern.

### Easy Memory

```text
IAM Policy
→ Identity-based access

S3 Bucket Policy
→ Bucket-based access
```

---

# 13. S3 Encryption

Amazon S3 provides encryption for data:

```text
Data
├── In Transit
└── At Rest
```

S3 automatically encrypts uploaded objects using server-side encryption with S3-managed keys as the base level of encryption.

---

# 14. S3 Storage Classes

S3 storage classes allow you to optimize storage based on access patterns.

| Storage Class | Best For |
|---|---|
| **S3 Standard** | Frequently accessed data |
| **S3 Intelligent-Tiering** | Unknown/changing access patterns |
| **S3 Standard-IA** | Infrequently accessed but requires rapid access |
| **S3 One Zone-IA** | Infrequently accessed, recreatable/secondary backup data |
| **S3 Glacier Instant Retrieval** | Rarely accessed data requiring millisecond retrieval |
| **S3 Glacier Flexible Retrieval** | Archived data accessed roughly 1–2 times/year |
| **S3 Glacier Deep Archive** | Long-term archival, rarely accessed data |
| **S3 on Outposts** | S3 storage in an on-premises AWS Outposts environment |

---

## ⭐ Important S3 Exam Scenario

### Requirement

Patient information must be:

- Stored for **7 years**
- Rarely accessed
- Kept at low storage cost

### Answer

**S3 Glacier Deep Archive**

```text
Long-term
    +
Rarely accessed
    +
7+ years
    ↓
S3 Glacier Deep Archive
```

> **Exam Shortcut:**  
> Years + Rarely accessed → **Glacier Deep Archive**

---

# 15. S3 Versioning

S3 Versioning keeps multiple versions of the same object.

Without versioning:

```text
employee.jpg
     ↓
Upload new employee.jpg
     ↓
Old version overwritten
```

With versioning:

```text
employee.jpg
├── Version 1
├── Version 2
└── Version 3
```

### Benefits

- Recover accidentally deleted objects.
- Recover accidentally overwritten objects.
- Preserve previous versions.
- Protect against application failures.

### Important

When versioning is enabled and an object is deleted, S3 places a **delete marker** instead of permanently deleting the object immediately.

Removing the delete marker can restore the object.

---

# 16. S3 Versioning States

A bucket can be:

```text
Unversioned
Versioning-enabled
Versioning-suspended
```

Storage costs can apply to all retained object versions.

---

# 17. S3 Lifecycle Management

S3 Lifecycle rules automate storage management.

There are two major actions:

### Transition

Move objects to another storage class.

```text
S3 Standard
     ↓
S3 Standard-IA
     ↓
Glacier
```

### Expiration

Delete objects after a specified period.

```text
Object
  ↓
1 Year
  ↓
Delete
```

### Good Use Cases

- Periodic logs
- Old documents
- Backup data
- Data with changing access frequency
- Regulatory archives

> **Easy Memory:**  
> **Transition = Move**  
> **Expiration = Delete**

---

# 18. Choosing the Right Storage Service

| Requirement | Service |
|---|---|
| Temporary EC2 storage | **EC2 Instance Store** |
| Persistent block storage | **Amazon EBS** |
| Object storage | **Amazon S3** |
| Automatically scaling shared file system | **Amazon EFS** |
| Managed third-party file system | **Amazon FSx** |

### Most Important Comparison

```text
Instance Store → Temporary + Ephemeral
EBS            → Persistent + Block
S3             → Object + Highly Scalable
EFS            → Elastic + Shared File
FSx            → Managed Specific File Systems
```

---

# 19. Relational Databases

A relational database stores data in **tables**.

```text
Table
├── Rows
└── Columns
```

- **Row** → Record
- **Column** → Attribute

Tables can be related to each other.

---

# 20. Relational Database Management System

An **RDBMS** allows you to create, update, and manage relational databases.

Examples:

- MySQL
- PostgreSQL
- Oracle
- Microsoft SQL Server
- Amazon Aurora

Relational databases commonly use **SQL**.

Example:

```sql
SELECT * FROM table_name;
```

---

# 21. Relational Database Benefits

### SQL Relationships

SQL allows you to join multiple tables.

### Reduced Duplication

Data can be stored once and referenced from other tables.

### Familiar Technology

Relational databases have been widely used for decades.

### ACID

Relational databases support the **ACID** principles:

```text
A → Atomicity
C → Consistency
I → Isolation
D → Durability
```

---

# 22. Managed vs Unmanaged Databases

## Unmanaged Database

The customer manages almost everything.

```text
You
 ↓
Data Center
 ↓
Servers
 ↓
OS
 ↓
Database
 ↓
Patching
 ↓
Backups
 ↓
Optimization
```

Provides:

- Maximum control
- Maximum operational responsibility

---

## Managed Database

AWS handles much of the infrastructure and operational work.

```text
You
 ↓
Application
 ↓
Database Optimization
 ↓
Customer Data
```

AWS handles much of:

- Infrastructure
- Provisioning
- Scaling
- High availability
- Backups
- Database software patching
- OS patching
- Server maintenance

### Customer Still Handles

- Application optimization
- Database tuning
- Query optimization
- Customer data security

> **Easy Memory:**  
> Managed Database → **AWS manages infrastructure, You manage the database usage and application needs.**

---

# 23. Amazon RDS

**Amazon Relational Database Service (RDS)** is a managed relational database service.

It reduces the operational burden of:

- Provisioning
- Patching
- Scaling
- Backups
- Restoring

### Supported Engines

**Commercial**

- Oracle
- SQL Server

**Open Source**

- MySQL
- PostgreSQL
- MariaDB

**Cloud Native**

- Aurora

---

# 24. RDS DB Instance

An RDS database consists of compute and storage.

```text
RDS
├── DB Instance → Compute
└── Storage     → EBS
```

A DB instance runs the selected database engine.

A DB instance can contain multiple databases, and each database can contain multiple tables.

---

# 25. RDS Networking

An RDS database is deployed into a VPC.

A **DB subnet group** contains subnets across at least two Availability Zones.

For database security, these subnets should generally be private and should not have a direct route to an Internet Gateway.

```text
Application
     ↓
Private DB Subnet
     ↓
Amazon RDS
```

---

# 26. RDS Multi-AZ

RDS Multi-AZ provides a redundant database copy in another Availability Zone.

```text
AZ-A
Primary DB
    │
    │ Synchronous Replication
    ↓
AZ-B
Standby DB
```

### Important

The standby database is **not used by applications for normal queries**.

Its purpose is redundancy and failover.

> **Easy Memory:**  
> RDS Multi-AZ → **High Availability / Standby**

---

# 27. Purpose-Built Databases

AWS provides different databases for different application requirements.

> **Do not automatically choose a relational database for every workload.**

Choose the database based on:

- Data model
- Access pattern
- Scalability
- Performance
- Availability
- Cost

---

# 28. AWS Database Services

| Service | Database Type | Typical Use Case |
|---|---|---|
| **RDS / Aurora** | Relational | Traditional applications, ERP, CRM, ecommerce |
| **DynamoDB** | Key-value / NoSQL | High-scale web, ecommerce, gaming |
| **ElastiCache** | In-memory | Caching, sessions, gaming |
| **DocumentDB** | Document | Content management, catalogs, profiles |
| **Keyspaces** | Wide-column | High-scale applications |
| **Neptune** | Graph | Recommendations, fraud detection, social relationships |
| **Timestream** | Time series | IoT, telemetry, DevOps |
| **Aurora PostgreSQL** | Relational | Audit/compliance workloads |

---

# 29. Amazon DynamoDB

**Amazon DynamoDB** is a fully managed NoSQL database.

Key characteristics:

- Fast and predictable performance
- Seamless scalability
- Highly available
- Managed by AWS
- Suitable for high-scale applications
- Commonly used for serverless applications
- Suitable for OLTP workloads

AWS handles operational tasks such as:

- Hardware provisioning
- Setup/configuration
- Replication
- Software patching
- Scaling

### DynamoDB Use Cases

- High-scale applications
- Serverless applications
- OLTP workloads
- Gaming
- Retail
- Media metadata
- Applications requiring high availability

> **Easy Memory:**  
> High Scale + NoSQL + Serverless → **DynamoDB**

---

# 30. Other Purpose-Built Databases

## Amazon ElastiCache

Fully managed in-memory caching.

Supports:

- Redis
- Memcached

Use cases:

- Caching
- Session management
- Gaming leaderboards

---

## Amazon MemoryDB for Redis

Redis-compatible, durable in-memory database.

Provides:

- Very fast performance
- High throughput
- Multi-AZ durability

Can be used as a primary database for high-performance applications.

---

## Amazon DocumentDB

Fully managed document database with MongoDB compatibility.

Use cases:

- Content management
- User profiles
- Web/mobile applications

> **Document data → DocumentDB**

---

## Amazon Keyspaces

Managed Apache Cassandra-compatible database.

Useful for:

- High-scale applications
- High-volume workloads
- Straightforward access patterns

> **Cassandra → Keyspaces**

---

## Amazon Neptune

Managed graph database.

Useful for highly connected data.

Use cases:

- Recommendation engines
- Fraud detection
- Knowledge graphs
- Social networking

> **Relationships → Graph → Neptune**

---

## Amazon Timestream

Serverless time-series database.

Useful for:

- IoT
- Operational applications
- Telemetry
- Data that changes over time

Examples:

```text
Temperature over time
Stock price over time
CPU utilization over time
```

> **Time-based data → Timestream**

---

# 31. Monitoring

Monitoring provides visibility into applications and infrastructure.

It helps you:

- Detect problems
- Investigate issues
- Respond proactively
- Improve performance
- Improve reliability
- Detect security events
- Make data-driven decisions
- Optimize costs

---

# 32. Amazon CloudWatch

**Amazon CloudWatch** is an AWS monitoring and observability service.

It collects and analyzes:

- Metrics
- Logs
- Events
- Network-related monitoring data

```text
AWS Resources
     ↓
CloudWatch
     ↓
Metrics + Logs
     ↓
Monitoring / Alerts / Actions
```

### CloudWatch Can

- Detect anomalous behavior
- Create alarms
- Visualize metrics
- Analyze logs
- Trigger automated actions
- Troubleshoot issues
- Monitor operational health

---

# 33. CloudWatch Basic vs Detailed Monitoring

Many AWS services provide basic monitoring automatically.

### Basic Monitoring

For many AWS services:

```text
1 data point / 5 minutes
```

### Detailed Monitoring

For EC2, detailed monitoring can provide:

```text
1 data point / minute
```

Detailed monitoring incurs additional charges.

---

# 34. CloudWatch Metrics

A **metric** is a time-ordered set of data points.

Example:

```text
CPU Utilization

80% ─────●
70% ───●
60% ─●
50% ●
     Time →
```

Every metric data point has a timestamp.

Examples:

- CPU utilization
- Network utilization
- Disk performance
- Database connections
- Number of objects in S3

---

# 35. CloudWatch Dimensions

A **dimension** is a name/value pair associated with a metric.

Example:

```text
Dimension Name → InstanceId
Dimension Value → i-123456789
```

Dimensions help filter and identify metric data.

---

# 36. CloudWatch Custom Metrics

Custom metrics allow applications to publish their own metrics.

Examples:

- Webpage load time
- Request error rate
- Number of processes
- Number of threads
- Amount of application work performed

High-resolution custom metrics can provide data at **1-second resolution**.

> **Easy Memory:**  
> AWS resource metric → Standard metric  
> Application-specific metric → **Custom Metric**

---

# 37. CloudWatch Dashboards

Dashboards provide customizable visualizations of metrics.

You can use:

- Graph widgets
- Text widgets
- Multiple metrics
- Metrics from different AWS Regions

```text
CloudWatch
   ↓
Dashboard
   ├── EC2 CPU
   ├── Network
   ├── EBS
   └── RDS
```

---

# 38. CloudWatch Logs

**CloudWatch Logs** provides centralized storage and analysis of logs.

Logs can come from:

- EC2
- Lambda
- Applications
- AWS services

You can:

- Search logs
- Filter logs
- Query logs
- Create metric filters

### CloudWatch Logs Structure

```text
Log Group
   ↓
Log Stream
   ↓
Log Events
```

> **Easy Memory:**  
> Group → Stream → Events

---

# 39. CloudWatch Alarms

CloudWatch alarms monitor metrics and can automatically initiate actions when a metric remains in a defined state for a specified period.

Example:

```text
CPU > 80%
for 5 minutes
      ↓
CloudWatch Alarm
      ↓
Action
```

Possible actions include:

- EC2 actions
- Auto Scaling actions
- SNS notifications

---

## Three CloudWatch Alarm States

```text
OK
ALARM
INSUFFICIENT_DATA
```

### Meaning

**OK** → Metric is within the expected range.

**ALARM** → Defined threshold condition has been met.

**INSUFFICIENT_DATA** → Not enough data is available to determine the state.

> **Exam Question:**  
> Possible CloudWatch alarm states?  
> **OK, ALARM, INSUFFICIENT_DATA**

---

# 40. CloudWatch Logs → Metric Filter → Alarm

A useful monitoring flow is:

```text
Application Logs
      ↓
CloudWatch Logs
      ↓
Metric Filter
      ↓
CloudWatch Metric
      ↓
CloudWatch Alarm
      ↓
SNS / Auto Scaling / EC2 Action
```

Example:

```text
HTTP 500 errors
      ↓
Metric Filter
      ↓
Alarm
      ↓
SNS Notification
```

---

# 41. High Availability

**Availability** measures how much time a system remains operational.

Examples:

| Availability | Approx. Downtime/Year |
|---|---:|
| 90% | 36.53 days |
| 99% | 3.65 days |
| 99.9% | 8.77 hours |
| 99.99% | 52.60 minutes |
| 99.999% | 5.26 minutes |

### Key Principle

> **To increase availability, introduce redundancy.**

```text
Single Server
     ↓
Single Point of Failure
```

Better:

```text
AZ-A → EC2
        +
AZ-B → EC2
```

---

# 42. Single Point of Failure

If only one EC2 instance hosts the application:

```text
Client
  ↓
EC2
```

That EC2 instance is a **Single Point of Failure (SPOF)**.

If it fails, customers cannot access the application.

A common solution is to deploy multiple instances across Availability Zones.

---

# 43. Active-Passive vs Active-Active

## Active-Passive

One server handles traffic.

Another server waits as standby.

```text
Active
  ↓
Traffic

Passive
  ↓
Standby
```

Useful for failover, but capacity is not fully utilized.

---

## Active-Active

Multiple servers actively handle traffic.

```text
         ┌→ EC2
Client → LB → EC2
         └→ EC2
```

This supports horizontal scaling and better resource utilization.

> **Easy Memory:**  
> Active-Passive → One works, one waits  
> Active-Active → Multiple work together

---

# 44. Elastic Load Balancing

**Elastic Load Balancing (ELB)** distributes incoming traffic across multiple targets.

```text
Client
   ↓
Internet
   ↓
ELB
   ↓
Target Group
├── EC2
├── EC2
└── EC2
```

A load balancer can distribute requests using algorithms such as round robin.

---

# 45. ELB Benefits

ELB provides:

- Load distribution
- High availability
- Automatic scaling
- Health checks
- Support for multiple target types
- Hybrid load balancing using IP targets

ELB can route traffic to:

- EC2 instances
- Containers
- IP addresses
- Lambda functions

---

# 46. ELB Health Checks

ELB uses health checks to determine whether targets are healthy.

Two examples:

### TCP Health Check

Attempts to establish a TCP connection.

### HTTP/HTTPS Health Check

Sends a request to a specified endpoint and checks the response.

A strong application health endpoint can verify dependencies such as:

```text
/monitor
   ↓
Database
   ↓
S3
   ↓
Application
```

Only healthy targets receive traffic.

---

# 47. ELB Connection Draining

When an instance is being removed, ELB can stop sending new connections while allowing existing connections to finish.

This is known as **connection draining**.

> **Easy Memory:**  
> Connection Draining → Finish existing requests before termination.

---

# 48. ELB Components

Three important ELB components:

```text
Listener
   ↓
Rules
   ↓
Target Group
```

### Listener

Receives incoming traffic.

### Rules

Determine how traffic should be routed.

### Target Group

Contains the targets that receive traffic.

---

# 49. Types of Load Balancers

AWS provides three important load balancer types in this course:

```text
ALB → Layer 7
NLB → Layer 4
GLB → Gateway
```

---

# 50. Application Load Balancer (ALB)

ALB operates at **Layer 7**.

Best for:

- HTTP
- HTTPS

ALB can route traffic based on request content.

Examples:

```text
/path
/checkout
/users
```

### ALB Features

- Content-based routing
- TLS termination/offloading
- User authentication
- Secure traffic
- Sticky sessions
- Fixed responses

> **Easy Memory:**  
> **HTTP/HTTPS → ALB**

---

# 51. Network Load Balancer (NLB)

NLB operates at **Layer 4**.

Best for:

- TCP
- UDP
- TLS

### Key Features

- Very low latency
- Static IP support
- Elastic IP support
- Source IP preservation
- DNS failover
- Sticky sessions

> **Easy Memory:**  
> **TCP/UDP → NLB**

---

# 52. Gateway Load Balancer (GWLB)

Gateway Load Balancer is designed for deploying and scaling third-party network appliances.

Examples:

- Firewalls
- Intrusion detection systems
- Intrusion prevention systems
- Deep packet inspection appliances

> **Easy Memory:**  
> Security/network appliance → **GWLB**

---

# 53. ALB vs NLB vs GWLB

| Feature | ALB | NLB | GWLB |
|---|---|---|---|
| Layer | 7 | 4 | Gateway / L3 + L4 |
| Main Protocol | HTTP/HTTPS | TCP/UDP/TLS | IP |
| Content-based routing | ✅ | ❌ | ❌ |
| Static IP | ❌ | ✅ | — |
| Application traffic | ✅ | ✅ | ❌ |
| Network appliances | ❌ | ❌ | ✅ |

### Exam Shortcut

```text
HTTP / HTTPS → ALB
TCP / UDP    → NLB
Firewalls    → GWLB
```

---

# 54. Amazon EC2 Auto Scaling

**Amazon EC2 Auto Scaling** automatically adds or removes EC2 instances according to defined conditions.

```text
Demand ↑
   ↓
Add EC2 Instances

Demand ↓
   ↓
Remove EC2 Instances
```

### Benefits

- Automatic scaling
- High availability
- Fleet management
- Scheduled scaling
- Predictive scaling
- Different EC2 purchasing options

> **Easy Memory:**  
> **EC2 Auto Scaling = Fleet Management + Automatic Scaling**

---

# 55. Vertical vs Horizontal Scaling

## Vertical Scaling

Increase the size of an existing server.

```text
Small EC2
    ↓
Large EC2
```

Example:

```text
t3.medium
    ↓
t3.large
```

### Limitation

There is a maximum size for a server.

---

## Horizontal Scaling

Add more servers.

```text
1 EC2
 ↓
2 EC2
 ↓
4 EC2
 ↓
8 EC2
```

Horizontal scaling is particularly useful for active-active architectures.

> **Easy Memory:**

```text
Vertical   → Bigger server
Horizontal → More servers
```

---

# 56. EC2 Auto Scaling Components

Three major components:

```text
1. Launch Template
2. Auto Scaling Group
3. Scaling Policy
```

### Easy Question

**What resources should be launched?**

→ Launch Template

**Where should they be launched?**

→ Auto Scaling Group

**When should they be added/removed?**

→ Scaling Policy

---

# 57. Launch Template

A launch template defines how EC2 instances should be created.

It can contain:

- AMI ID
- Instance type
- Security groups
- Key pair
- Storage
- Tags

Launch templates support **versioning**.

This makes rollback easier.

### AWS Recommendation

AWS recommends using **Launch Templates** instead of older Launch Configurations.

> **Easy Memory:**  
> Launch Template → **How to create EC2**

---

# 58. Auto Scaling Group

An Auto Scaling Group defines where EC2 instances are deployed.

It specifies:

- VPC
- Subnets
- Capacity
- Purchasing options

For high availability, use subnets across multiple Availability Zones.

Example:

```text
ASG
├── AZ-A → EC2
└── AZ-B → EC2
```

---

# 59. Auto Scaling Capacity

An Auto Scaling Group uses:

```text
Minimum Capacity
Desired Capacity
Maximum Capacity
```

Example:

```text
Minimum = 2
Desired = 3
Maximum = 6
```

This means the ASG normally maintains 3 instances but can scale between 2 and 6.

---

# 60. Scaling Policies

Scaling policies determine when EC2 instances should be added or removed.

CloudWatch metrics and alarms can trigger scaling policies.

Example:

```text
CPU > 70%
     ↓
CloudWatch
     ↓
Scaling Policy
     ↓
Add EC2 Instance
```

### Types

- Simple Scaling
- Step Scaling
- Target Tracking Scaling

---

# 61. Simple Scaling

A simple scaling policy uses a CloudWatch alarm and performs a defined scaling action.

Example:

```text
CPU > 70%
   ↓
Alarm
   ↓
Add 1 EC2
```

After scaling, a cooldown period can prevent immediate additional scaling actions while the new capacity becomes available.

---

# 62. Step Scaling

Step scaling allows different scaling actions depending on how much the metric changes.

Example concept:

```text
CPU 70–80% → Add 1
CPU 80–90% → Add 2
CPU > 90%  → Add 3
```

> **Easy Memory:**  
> Simple → One defined response  
> Step → Different response based on severity

---

# 63. Target Tracking

Target tracking maintains a target metric value.

Example:

```text
Target CPU = 50%

CPU > 50% → Scale Out
CPU < 50% → Scale In
```

The goal is to maintain the desired target automatically.

---

# 64. ELB + EC2 Auto Scaling

ELB and Auto Scaling work together.

```text
Client
   ↓
ELB
   ↓
Target Group
   ↓
EC2 Auto Scaling Group
   ↓
EC2 Instances
```

When a new EC2 instance is launched:

```text
New EC2
  ↓
Health Check
  ↓
Healthy?
  ↓
ELB sends traffic
```

When an instance becomes unhealthy:

```text
Unhealthy EC2
      ↓
ELB stops traffic
      ↓
Auto Scaling removes instance
      ↓
New EC2 launched
      ↓
Health Check
      ↓
Traffic starts
```

This combination provides:

- High availability
- Automatic scaling
- Health-based traffic routing
- Better resilience

---

# 65. AWS CloudFront

**Amazon CloudFront** is a content delivery service that uses caching to deliver frequently accessed content closer to users.

```text
User
 ↓
CloudFront Edge Location
 ↓
Cached Content
```

If content is cached at an edge location, the request can be served without going back to the origin.

> **Easy Memory:**  
> **CloudFront → Cache content closer to users → Lower latency**

---

# 66. IAM Policies

Most IAM policies are stored as **JSON documents**.

Important policy elements include:

```text
Version
Effect
Action
Resource
```

Example concept:

```json
{
  "Version": "...",
  "Effect": "Allow",
  "Action": "...",
  "Resource": "..."
}
```

> **Easy Memory:**  
> IAM Policy → **Version + Effect + Action + Resource**

---

# 67. IAM Roles and Federation

Instead of creating an IAM user for every employee, organizations can use **IAM roles with identity federation**.

```text
Employee
   ↓
Identity Provider
   ↓
Federated Access
   ↓
IAM Role
   ↓
AWS Resources
```

Benefits:

- Centralized identity management
- Temporary access
- Reduced need for long-lived IAM user credentials

> **Exam Shortcut:**  
> Employees + Federation → **IAM Roles**

---

# 68. VPC Internet Connectivity

To provide internet connectivity to a VPC:

```text
VPC
 ↓
Internet Gateway
 ↓
Route Table
 ↓
Internet
```

Required steps:

1. Create an Internet Gateway.
2. Attach it to the VPC.
3. Create a route to the Internet Gateway.
4. Associate the appropriate subnet with the route table.

> **Exam Shortcut:**  
> Internet access → **IGW + Route Table**

---

# 69. Amazon Q Developer

**Amazon Q Developer** is an AI-powered development assistant that provides code recommendations and generation.

It can analyze:

- Existing code
- Comments
- Surrounding code
- Coding style
- Naming conventions

### Supported Environments

Examples include:

- VS Code
- JetBrains IDEs
- Amazon SageMaker Studio
- JupyterLab
- AWS Lambda console

### Code Generation Controls

| Action | Key |
|---|---|
| Previous recommendation | Left Arrow |
| Next recommendation | Right Arrow |
| Accept | Tab |
| Reject | Esc |
| Manually generate from comment | Alt + C on Windows |

### Supported Languages

Examples include:

- Python
- Java
- JavaScript
- TypeScript
- C#
- Go
- Rust
- PHP
- Ruby
- Kotlin
- C
- C++
- Shell
- SQL
- Scala

---

# ⭐ Important Exam Questions

## 1. CloudFront

**Question:** What does CloudFront do with frequently accessed content?

**Answer:** It can **cache the content at edge locations**, improving performance and reducing latency.

---

## 2. CloudWatch Alarm States

**Question:** What are the possible states of a CloudWatch alarm?

**Answer:**

```text
OK
ALARM
INSUFFICIENT_DATA
```

---

## 3. IAM Policy Elements

**Question:** What are common elements of an IAM policy?

**Answer:**

```text
Version
Effect
Action
Resource
```

---

## 4. Employee AWS Access

**Question:** Instead of creating an IAM user for every employee, what should be used for federated access?

**Answer:**

**IAM Roles + Identity Federation**

---

## 5. VPC Internet Connectivity

**Question:** How do you provide internet connectivity to a VPC?

**Answer:**

```text
Internet Gateway
      +
Attach to VPC
      +
Route Table
      ↓
Internet
```

---

## 6. Seven-Year Rarely Accessed Data

**Question:** A healthcare facility needs to store patient information for 7 years and rarely accesses it. Which S3 storage class is appropriate?

**Answer:**

**S3 Glacier Deep Archive**

```text
7 Years
+
Rarely Accessed
+
Lowest-cost archival
        ↓
Glacier Deep Archive
```

---

# 🧠 Ultimate AWS Technical Essentials Memory Map

```text
STORAGE
────────────────────────────────
S3           → Object
EBS          → Persistent Block
InstanceStore→ Temporary Block
EFS          → Elastic Shared File
FSx          → Managed Specific File System


DATABASE
────────────────────────────────
RDS          → Relational
Aurora       → Cloud-native Relational
DynamoDB     → NoSQL / Key-Value
ElastiCache  → In-Memory Cache
DocumentDB   → Document
Keyspaces    → Wide Column / Cassandra
Neptune      → Graph / Relationships
Timestream   → Time Series


MONITORING
────────────────────────────────
CloudWatch Metrics    → Numbers over time
CloudWatch Logs       → Logs
CloudWatch Dashboard  → Visualization
CloudWatch Alarm      → Threshold → Action
Custom Metrics        → Application-specific metrics


LOAD BALANCING
────────────────────────────────
ALB → HTTP / HTTPS → Layer 7
NLB → TCP / UDP    → Layer 4
GWLB → Firewalls / Appliances


SCALING
────────────────────────────────
Vertical   → Bigger Server
Horizontal → More Servers
Auto Scaling → Automatically Add/Remove


HIGH AVAILABILITY
────────────────────────────────
Multiple AZs
     ↓
Redundancy
     ↓
No Single Point of Failure


EC2 AUTO SCALING
────────────────────────────────
Launch Template → HOW
ASG              → WHERE
Scaling Policy   → WHEN


IAM
────────────────────────────────
Authentication → Who are you?
Authorization  → What can you do?

Policy:
Version + Effect + Action + Resource

Employees + Federation → IAM Roles


S3
────────────────────────────────
Standard              → Frequent
Intelligent-Tiering    → Unknown/Changing
Standard-IA            → Infrequent + Fast
One Zone-IA            → Infrequent + Re-creatable
Glacier Instant        → Archive + Millisecond retrieval
Glacier Flexible       → Archive + Occasional
Glacier Deep Archive   → Years + Rarely accessed


NETWORKING
────────────────────────────────
VPC          → Network
Subnet       → Smaller Network
IGW          → Internet
Route Table  → Traffic Direction
Security Group → Resource/Instance Security
NACL         → Subnet Security


CLOUDFRONT
────────────────────────────────
User
 ↓
Edge Location
 ↓
Cached Content
 ↓
Lower Latency
```

# ⭐ FDE / Interview Takeaway

The key AWS architecture pattern from this topic is:

```text
                    Internet
                       ↓
                  CloudFront
                       ↓
                      ALB
                       ↓
             Target Group
                       ↓
        ┌──────────────┴──────────────┐
        ↓                             ↓
      EC2                            EC2
        ↓                             ↓
        └──────── EC2 Auto Scaling ───┘
                       ↓
              Application Database
                       ↓
        ┌──────────────┴──────────────┐
        ↓                             ↓
       RDS                         DynamoDB

Storage:
S3  → Objects / Backups / Static Content
EBS → Persistent Block Storage
EFS → Shared File Storage
```

### Most Important Exam Associations

```text
HTTP/HTTPS                 → ALB
TCP/UDP                    → NLB
Firewalls / Appliances    → GWLB

Persistent EC2 storage     → EBS
Temporary EC2 storage      → Instance Store
Object storage             → S3
Elastic shared file system → EFS
Specific managed file sys. → FSx

Relational                 → RDS / Aurora
High-scale NoSQL           → DynamoDB
Caching                    → ElastiCache
Graph relationships        → Neptune
Time-series                → Timestream
Document                   → DocumentDB

Monitoring                 → CloudWatch
Logs                       → CloudWatch Logs
Threshold + Action         → CloudWatch Alarm

Bigger server              → Vertical Scaling
More servers               → Horizontal Scaling
Automatic EC2 scaling      → EC2 Auto Scaling

Long-term + rarely access. → Glacier Deep Archive
Frequent access            → S3 Standard
Unknown access pattern     → Intelligent-Tiering

Employee federation        → IAM Role
Policy elements            → Version / Effect / Action / Resource

Internet VPC access        → IGW + Route Table

Content caching            → CloudFront
```
````

