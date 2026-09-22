# 1. AWS GLOBAL INFRASTRUCTURE

```text
AWS
│
├── Region
│   └── Geographic area, e.g. us-east-1
│
├── Availability Zones
│   ├── AZ-1
│   ├── AZ-2
│   └── AZ-3
│
└── Edge Locations
    └── Used by services such as CloudFront to cache/deliver content closer to users
```

## Region
- A geographic area independent from other AWS Regions.
- Examples: `us-east-1`, `us-west-2`.

## Availability Zone (AZ)
- A separate data-center location within a Region.
- AZs are designed to be isolated from failures in other AZs.
- Multiple AZs provide high availability.

## Edge Location
- AWS location primarily used by services such as CloudFront to cache content closer to users.

## Replication exam clue

```text
Multi-AZ
→ Synchronous replication
→ At least two AZs
→ Same Region
→ HA / automatic failover

Read Replica
→ Asynchronous replication
→ Can be same AZ, cross-AZ, or cross-Region
→ Read scaling
```

# 2. VPC FUNDAMENTALS

## VPC

```text
Region
│
└── VPC
    │
    ├── AZ-1 → Subnets
    ├── AZ-2 → Subnets
    └── AZ-3 → Subnets
```

- A VPC belongs to one AWS Region. 
- A VPC can span multiple AZs through subnets.

## Subnet

- A subnet is a smaller network inside a VPC.
- Every subnet belongs to **exactly one AZ**.
- One AZ can contain multiple subnets.

```text
AZ → many subnets
Subnet → exactly one AZ
```

# 3. PUBLIC VS PRIVATE SUBNET

## Public subnet

A subnet is considered **public** when its route table has a route to an Internet Gateway.

```text
Internet
   ↑
  IGW
   ↑
Route Table
   ↑
Public Subnet
```

Typical route:

```text
0.0.0.0/0 → Internet Gateway
```

A resource also needs appropriate public addressing and security rules for direct Internet communication.

## Private subnet

- No direct route to the Internet Gateway.
- Private resources can still access the Internet **outbound** through a NAT Gateway.

```text
Private EC2
    │
    ↓
Private Route Table
    │
    ↓
NAT Gateway
(Public Subnet)
    │
    ↓
Internet Gateway
    │
    ↓
Internet
```

### Critical distinction

```text
Internet → private EC2
        ✗ direct inbound Internet access

Private EC2 → Internet
        ✓ through NAT Gateway
```

# 4. INTERNET GATEWAY (IGW)

An Internet Gateway is a horizontally scaled, redundant, highly available VPC component.

It:
- Provides a target in VPC route tables for Internet-routable traffic.
- Performs network address translation for instances that have public IPv4 addresses.

```text
Public resource
     │
     ↓
Route Table
     │
     ↓
Internet Gateway
     │
     ↓
Internet
```

# 5. SECURITY GROUP vs NACL vs ROUTE TABLE

```text
Route Table
→ WHERE should traffic go?

Security Group
→ IS this traffic allowed to the resource?

NACL
→ IS this traffic allowed to/from the subnet?
```

## Security Group

- Virtual firewall for resources such as EC2.
- Primarily controls inbound/outbound traffic.
- **Stateful**
    - If Client → EC2 TCP 443 is allowed, the response traffic is automatically allowed.
    - Security groups can also control traffic to and from supported file-system resources.

Example:

```text
Inbound
TCP 443 → ALLOW
TCP 22  → ALLOW from specific IP
```

## Network ACL (NACL)

- Firewall around a **subnet**.
- **Stateless**.
- Because it is stateless, inbound and outbound rules must be allowed separately.

```text
Security Group → resource-level firewall → STATEFUL
NACL            → subnet-level firewall   → STATELESS
```

# 6. NAT GATEWAY vs NAT INSTANCE

## NAT Gateway

**Primary clue: OUTBOUND INTERNET FROM PRIVATE SUBNET**

```text
Private EC2
    │
    ↓
Private Route Table
    │
    ↓
NAT Gateway
(Public Subnet)
    │
    ↓
Internet Gateway
    │
    ↓
Internet
```

Use it when:
- EC2 is private.
- EC2 must download software.
- EC2 must call a public API/external service.
- Internet must **not initiate** a connection directly to the EC2.

### NAT Gateway vs NAT Instance

```text
NAT Gateway
→ Managed
→ No Security Group

NAT Instance
→ EC2 instance
→ Security Group can be attached
→ Can be used as a bastion server
→ Supports port forwarding
```

# 7. ALB / NLB / API GATEWAY

## ALB

- Application Load Balancer.
- Designed for web/application traffic.
- HTTP/HTTPS.
- Supports application-level routing such as path-based routing.

Example:

```text
example.com/orders
example.com/products
```

can be routed to different target groups.

## NLB

- Network Load Balancer.
- High-performance network connectivity.
- TCP / UDP / TLS.
- Useful when network-level performance or static IP behavior is required.

## Internet-facing vs internal load balancer

```text
Internet-facing ALB/NLB
→ public subnets

Internal ALB/NLB
→ can be used internally/private
```

## API Gateway

```text
API Gateway
├── HTTP API
├── REST API
└── WebSocket API
```

Think:

```text
API Gateway → API management/front door
ALB         → application HTTP/HTTPS load balancing
NLB         → TCP/UDP/TLS high-performance network load balancing
```

# 8. THREE-TIER NETWORK PATTERN

```text
                         INTERNET
                             │
                             ↓
                    ┌─────────────────┐
                    │ Public Subnets  │
                    │      ALB        │
                    └────────┬────────┘
                             │
                             ↓
                    ┌─────────────────┐
                    │ Private Subnets │
                    │      EC2        │
                    └────────┬────────┘
                             │
                             ↓
                    ┌─────────────────┐
                    │ Private DB      │
                    │      RDS        │
                    └─────────────────┘
```

### Security Group chain

```text
ALB-SG
443 ← Internet

EC2-SG
80 ← ALB-SG

RDS-SG
5432 ← EC2-SG
```

**Golden rule:**

> Each layer should allow traffic only from the layer immediately in front of it.

Meaning:
- ALB allows HTTPS from Internet.
- EC2 allows application traffic only from ALB security group.
- RDS allows database traffic only from EC2 security group.

### Traffic flows

```text
Internet
   ↓
IGW
   ↓
Internet-facing ALB
   ↓
Private EC2/ECS
   ↓
Private RDS
```

RDS communication:
- EC2 → RDS stays inside the VPC.
- No Internet Gateway.
- No NAT Gateway.
- No public Internet.

Private EC2 outbound Internet:

```text
EC2 → Private Route Table
   → NAT Gateway
   → IGW
   → Internet
```

# 9. AUTO SCALING GROUP (ASG)

- Automatically adjusts the number of EC2 instances based on traffic/metrics.
- Used for high availability and fault tolerance.

### Important unhealthy-instance behavior

An ASG may not immediately terminate/replace an unhealthy instance when:
- ELB health check has failed but health-check grace period has not expired.
- The instance is impaired.
- Health-check grace period has not expired.

## Target tracking

Example:

```text
ASG
  ↓
Target tracking policy
  ↓
CPU utilization target
  ↓
Scale out / scale in
```

## Scheduled scaling

Use when traffic is predictable by time.

```text
Known peak
    ↓
Scheduled action
    ↓
Increase desired capacity
    ↓
Instances ready before peak
```

## ASG STANDBY STATE

- Instance remains part of the ASG.
- Temporarily removed from service.
- Useful while performing maintenance.

Example:
- Suspend `ReplaceUnhealthy`.
- Apply maintenance patch.
- Keep instance associated with the ASG.


## ASG TERMINATION-POLICY

```text
1. Allocation strategy => On-Demand then Spot
2. Oldest launch => configuration then template
3. Closest to next billing hour
```

# 10. EC2 COMPUTE

## Lambda vs EC2

```text
EC2
→ "Give me a server."
→ You manage the server/OS
→ Long-running
→ Full OS/server control
→ No 15-minute invocation limit

Lambda
→ "Just run my code."
→ AWS manages infrastructure
→ Serverless
→ Event/request driven
→ Automatic scaling
→ Maximum 15 minutes per invocation
→ Less control
```

### Lambda example

```text
User
 ↓
S3 upload
 ↓
Lambda
 ↓
Resize image
 ↓
Save resized image to S3
```

### EC2 example

```text
Internet
   ↓
ALB
   ↓
EC2
   ↓
RDS
```

# 11. EC2 INSTANCE OPTIONS

## Spot Instance

Use when workload can tolerate interruption.

- Cost-effective.
- Suitable when workload can be started/stopped or interrupted.
- Notes in the mock: up to about 90% discount compared with On-Demand.
- Flexible start/stop times.

### Spot request behavior

- Cancelling an active Spot request does **not** itself terminate the associated running instance.
- A persistent Spot request can be opened again after interruption.
- Spot Fleets can maintain target capacity by launching replacement Spot Instances after interruptions/termination.

## On-Demand

- Pay for compute capacity by hour/second.
- No long-term commitment.
- Usually more expensive than Spot.

## EC2 Hibernate

```text
RAM / in-memory state
        ↓
Saved to disk
        ↓
Instance stopped
        ↓
Faster resume
```

Useful for:
- Long initialization.
- Applications where preserving in-memory state is useful.

## Dedicated Instances

- Run on hardware dedicated to a single customer.
- Physical isolation at host hardware level.
- Useful for compliance or licensing requirements.

## User Data

- By default, runs during the first boot cycle.
- By default, user-data scripts execute with root privileges.

# 12. EC2 SCALING

```text
Vertical Scaling = SCALE UP
2 CPU / 8 GB
      ↓
8 CPU / 32 GB

Horizontal Scaling = SCALE OUT
2 EC2
 ↓
5 EC2
 ↓
10 EC2
```

## AMI

- Reusable image containing OS/application configuration.
- Used as a repeatable source for launching EC2 instances.

## Launch Template

- Defines how EC2 instances should be launched.
- Stores launch configuration such as instance settings.

## ALB

- Distributes incoming application traffic.
- Supports path-based routing.

## ASG

- Maintains and scales the number of EC2 instances.

# 13. ECS / FARGATE / CONTAINERS

## Container concept

A container packages the application together with everything needed to run it.

```text
┌───────────────────────────┐
│         Container         │
│                           │
│  Spring Boot Application  │
│  Java                     │
│  Libraries                │
│  Configuration            │
└───────────────────────────┘
```

## Docker vs ECS

```text
Docker
→ Technology/tool to create and run containers

ECS
→ AWS service to manage/run many containers
```

## ECS compute choices

```text
                 ECS
                  │
          ┌───────┴────────┐
          ↓                ↓
        EC2              Fargate
          │                │
   You manage EC2     AWS manages
   infrastructure     infrastructure
          │                │
      Containers       Containers
```

- ECS EC2 launch type → you manage underlying EC2.
- ECS Fargate → serverless compute for containers; infrastructure management is abstracted away.
- ECS can automatically change desired task count.
- ECS Service Auto Scaling commonly uses CloudWatch metrics.

Typical architecture:

```text
ALB
 ↓
ECS Service
 ↓ ↓ ↓ ↓
T1 T2 T3 T4
(Fargate tasks)
```

## ECS pricing clue

```text
ECS + EC2 launch type
→ Pay for EC2 instances + EBS

ECS + Fargate
→ Pay for requested vCPU + memory resources
```

# 14. VPC ENDPOINTS

A VPC Endpoint is a private doorway from your VPC to an AWS service.

```text
Private VPC
    │
    ↓
VPC Endpoint
    │
    ↓
AWS Service
```

## Gateway Endpoint

Primarily used for:
- S3
- DynamoDB

Works through route tables.

### NAT vs VPC Endpoint

```text
NAT Gateway
→ Private resources → Internet

VPC Endpoint
→ Private resources → AWS service privately
```

NAT requires Internet connectivity; a VPC endpoint does not require Internet/NAT for the supported private AWS-service access pattern.

Example:

```text
EC2 → NAT → Internet → public service

EC2 → DynamoDB Gateway Endpoint → DynamoDB
```

# 15. VPC PEERING vs TRANSIT GATEWAY vs PRIVATELINK

```text
VPC Peering
→ "Connect two VPCs directly"

Transit Gateway
→ "Connect many VPCs/networks through a central hub"

PrivateLink
→ "Expose one private service without exposing the whole VPC"
```

## VPC Peering

```text
VPC-A ───────── VPC-B
```

- Private network connection between two VPCs.
- Best mental model: direct VPC-to-VPC connection.

## Transit Gateway

```text
             VPC-A
               │
VPC-B ─── Transit Gateway ─── VPC-C
               │
             VPC-D
```

- Central networking hub.
- Avoids creating many individual peering connections.
- Think: many VPCs/accounts/networks.

## PrivateLink

Use when:
- Company A exposes a service.
- Company B needs that service.
- Company A does **not** want Company B to access the entire VPC.

```text
Consumer VPC
     │
     ↓
PrivateLink
     │
     ↓
Specific provider service
```

# 16. DIRECT CONNECT / VPN / VPG

## AWS Direct Connect

- Dedicated private network connection between on-premises data center and AWS.
- Provides private, low-latency connectivity.

```text
On-Premises
     │
     │ Dedicated connection
     ↓
Direct Connect
     ↓
AWS
```

## Direct Connect resiliency

For highly available/resilient connectivity:
- Use multiple independent Direct Connect connections.
- Prefer different locations/facilities.

```text
DX = provides the connection
DX Resiliency = provides redundancy
```

## VPG

- Virtual Private Gateway.
- Used to set up AWS VPN connectivity.
- Can be used with Direct Connect to encrypt traffic traversing the Direct Connect link.

## IPsec VPN

```text
On-Premises
    │
Customer Gateway
    │
  IPsec VPN
    │
Virtual Private Gateway
    │
   AWS VPC
```

- Uses IPsec to secure communication between on-premises and AWS VPC.
- AWS side: Virtual Private Gateway (VGW).
- On-premises side: Customer Gateway.

# 17. VPC SHARING / MULTI-ACCOUNT NETWORKING

When multiple AWS accounts in one Region are managed by AWS Organizations and need private connectivity:

```text
Central VPC
   │
   └── Shared Subnets
         ├── Account A
         ├── Account B
         └── Account C
```

Use **AWS Resource Access Manager (RAM)** to share one or more VPC subnets.

### VPC Peering vs VPC Sharing

```text
VPC Peering
→ We each have our own VPC; connect them.

VPC Sharing
→ Share subnets from one VPC across accounts.
```

# 18. ROUTE 53

Amazon Route 53 is a highly available, scalable DNS service.

## Routing policies

```text
Simple
Weighted
Latency-based
Failover
Geolocation
Geoproximity
Multivalue answer
```

### Latency routing

Use when resources exist in multiple AWS Regions and you want DNS to route users to the Region providing the lowest latency.

```text
User
 ↓
Route 53
 ├── us-east-1
 ├── us-west-2
 └── another Region
        ↓
Lowest-latency Region
```

### Failover routing

```text
Primary
   ↓
Route 53
   ↓
Secondary if primary is unhealthy
```

Route 53 failover is **DNS-level routing/failover**.

# 19. DNS RECORDS — EXAM QUICK TABLE

```text
A     → Domain → IPv4 address
AAAA  → Domain → IPv6 address
CNAME → Domain → another domain name
Alias → Domain → AWS resource
MX    → Domain → mail server
TXT   → Text/verification/security information
SRV   → Service hostname + port
PTR   → IP address → domain name (reverse DNS)
CAA   → Which Certificate Authorities may issue certs
NS    → Authoritative name servers
```

### Alias vs CNAME

```text
Alias
→ AWS resource
→ example.com → CloudFront / ALB / S3
→ AWS-specific alternative to CNAME

CNAME
→ Domain name → another domain name
→ www.example.com → app.example.net
```

Example pattern:

```text
example.com
   ↓ Alias
CloudFront / ALB
```

For the mock's domain example:

```text
covid19survey.com → Alias → AWS resource
www.covid19survey.com → CNAME → covid19survey.com
www.example.com   → CNAME → app.example.net
```

# 20. APPLICATION DIRECTORY SERVICES

## AWS Directory Service — AD Connector

- Connects AWS to an existing on-premises Active Directory.

## IAM Identity Center + Active Directory

Use when employees need centralized AWS login using existing corporate identities across multiple AWS accounts.

# 21. AWS NETWORK SECURITY

```text
Internet / Web request
        ↓
      WAF
        ↓
Web application / API

VPC network traffic
        ↓
Network Firewall
        ↓
Network resources
```

## AWS WAF

Protects:
- Web applications.
- APIs.

Against:
- Malicious HTTP requests.
- SQL injection.
- XSS.
- Bots.
- Web exploits.

## AWS Network Firewall

- VPC/network traffic inspection.
- Network rules.
- Domain-list rules.
- Outbound filtering.

### WAF + CloudFront + S3

When **all traffic must be inspected by WAF before reaching S3 through CloudFront**:

```text
Users
  ↓
CloudFront
  ↓
WAF
  ↓
CloudFront origin
  ↓
S3
```

For origin protection, use CloudFront origin access controls/identity so users do not bypass CloudFront and directly access S3.

> Mock-note terminology: OAI = Origin Access Identity. OAI gives CloudFront a special identity used for S3 origin access. Modern AWS architectures commonly use OAC (Origin Access Control), but the exam question may still use OAI terminology.

## AWS SHIELD / DDOS

For enhanced DDoS protection:
- AWS Shield Advanced provides proactive DDoS protection.
- Can engage the AWS DDoS Response Team (DRT).
- Provides logging/reporting for detected events.

# 22. AWS SECURITY SERVICES — CLUE MAP

```text
Macie
→ S3 data
→ "What sensitive data do I have?"

GuardDuty
→ Threat detection
→ "Is someone/something behaving maliciously?"

Inspector
→ Vulnerability assessment
→ "What vulnerabilities exist on EC2/workloads?"

AWS Config
→ Resource configuration/compliance
→ "Does configuration meet guidelines?"
→ Maintains configuration-change history

Security Lake
→ Centralize security logs/events
```

# 23. IAM AUTHORIZATION

## IAM policy

Defines what an identity is allowed to do.

## Permissions Boundary

Maximum permissions for **one IAM identity**.

Can be attached to:
- IAM User
- IAM Role

Cannot be attached to:
- IAM Group

```text
IAM Role/User
   │
   ├── Identity Policy
   │      → what it is allowed to do
   │
   └── Permissions Boundary
          → maximum it can do
```

## SCP

Maximum permissions/guardrail at:
- AWS account
- Organizational Unit (OU)

```text
IAM identity
→ Permissions Boundary
→ identity-level maximum

AWS account / OU
→ SCP
→ organization-level maximum
```

### SCP exam facts

- SCP does not affect service-linked roles.
- SCP affects users and roles in member accounts, including the root user of member accounts.
- If IAM permission policy allows an action but the applicable SCP does not allow it or explicitly denies it, the action cannot be performed.

## ECS IAM ROLE

Do **not** put AWS access keys inside containers.

ECS/Fargate uses IAM roles.

Task role is used for application/container permissions.

Examples:
- Application accessing AWS services.
- Container permissions.

The mock notes also highlight ECS roles for actions such as:
- Pulling images from ECR.
- Sending logs to CloudWatch.
- Retrieving secrets/configuration required for task startup.

```text
IAM User
→ AWS user

IAM Group
→ Collection of IAM Users

IAM Role
→ Temporary AWS permissions/identity

Cognito User Pool
→ Authenticate application users

Cognito Identity Pool
→ Give application users temporary AWS credentials by using IAM Roles
```

# 24. ENCRYPTION

## At rest

Data stored on disk/storage.

Examples:
- EBS encryption.
- RDS encryption.
- S3 server-side encryption.
- EFS encryption.

## In transit

Data moving between systems.

```text
HTTPS
→ TLS
→ Encryption in transit
```

## Client-side encryption

```text
Application/client
    ↓
Encrypt data
    ↓
Upload to AWS
```
The data is encrypted **before** it is sent to AWS.

## SECRETS MANAGER

```text
Secrets Manager
→ Securely store secrets
→ Credentials
→ Automatic rotation

rule of thumb: Do not hard-code database credentials/API secrets into application code or containers.
```

# 25. RDS ENCRYPTION MIGRATION

An existing unencrypted RDS instance cannot simply be switched to encrypted.

Typical process:

```text
Unencrypted RDS
      ↓
Snapshot
      ↓
Copy snapshot
      ↓
Encrypt copied snapshot
      ↓
Restore new encrypted RDS
```

# 26. DATABASE SERVICE

```text
AWS DATABASES
│
├── Relational
│   ├── RDS
│   └── Aurora
│
├── NoSQL
│   └── DynamoDB
│
├── Cache / In-memory
│   ├── ElastiCache
│   └── MemoryDB
│
├── Document
│   └── DocumentDB
│
├── Graph
│   └── Neptune
│
├── Cassandra
│   └── Keyspaces
│
├── Time series
│   └── Timestream
│
├── Data warehouse
│   └── Redshift
│
├── Search / logs
│   └── OpenSearch
│
└── Ledger
    └── QLDB
```

## MANAGED vs SELF-MANAGED DATABASE

```text
MANAGED
│
├── Instance-based
│   ├── RDS
│   └── Aurora Provisioned
│
└── Serverless
    ├── DynamoDB
    └── Aurora Serverless

SELF-MANAGED
│
└── EC2 / ECS / EKS
      ↓
   You install/manage DB
      ↓
 MySQL / MongoDB /
 PostgreSQL / Cassandra
```

# 27. RDS

Use when:
- You need a traditional SQL relational database.
- You want AWS to manage the database infrastructure.

## RDS Read Replica

Problem:

```text
Too many READS
      ↓
Read Replica
      ↓
Read traffic distributed
```

- Copy of the RDS database used primarily for read traffic.
- Read Replica is billed as a standard DB instance.
- Same-Region replication does not incur data transfer charges for the replication traffic according to the mock notes; inter-Region replication incurs inter-Region data transfer charges.

## RDS Proxy

Problem:

```text
Too many DB connections
          ↓
       RDS Proxy
          ↓
          RDS
```

- Connection manager in front of DB.
- Main purpose: connection pooling and connection management.
- Useful for connection exhaustion, especially bursty/serverless workloads.

## RDS for Oracle vs RDS Custom for Oracle

```text
RDS for Oracle
→ AWS-managed infrastructure

RDS Custom for Oracle
→ AWS-managed infrastructure
→ More control
→ More ability to customize/optimize OS and environment
```

## RDS Multi-AZ vs Read Replica

```text
Multi-AZ
→ Availability
→ Automatic failover
→ Synchronous
→ Standby is not for read scaling

Read Replica
→ Read scaling
→ Asynchronous
→ Reader copy
```

Important exam clue:
- Database engine-level upgrade in an RDS Multi-AZ deployment upgrades primary and standby together, causing downtime until the upgrade completes.

# 28. AURORA

Use when you need:
- High availability.
- High performance relational database.
- Automatic storage scaling.

Aurora is MySQL and PostgreSQL compatible.

## Aurora Replica

```text
Aurora
   │
   ├── Writer
   └── Aurora Replica
          ├── Read scaling
          └── failover
```

Key distinction:

```text
RDS Multi-AZ
→ standby → failover only
→ Read scaling not supported, have to use Read Replica for that

Aurora Replica
→ failover + read scaling
```

Aurora supports the database engines listed in the mock notes for RDS/Aurora:
- Oracle
- IBM Db2
- SQL Server
- MariaDB
- PostgreSQL
- MySQL

## Aurora Global Database

```text
Aurora cluster
→ Regional database cluster

Aurora Global Database
→ Multiple Aurora clusters across Regions
→ One primary Region
→ Secondary Regions
→ Cross-Region DR + low-latency reads
```

Each regional Aurora cluster is still VPC-based.

Typical DR pattern:

```text
Primary Region
      ↓
Aurora Global Database
      ↓
Secondary Region(s)

Route 53 Failover
      ↓
Traffic moves to secondary when needed
```

## Aurora Serverless

Use for variable/less predictable relational DB capacity.

## Babelfish

- Babelfish for Aurora PostgreSQL enables support for T-SQL commands.

## Database migration

```text
AWS SCT
→ Schema conversion

AWS DMS
→ Data migration
```

Use SCT together with DMS when schema conversion and data migration are both required.

# 29. DYNAMODB

```text
DynamoDB
→ NoSQL
→ Serverless
→ Millions of requests
→ Single-digit millisecond latency
```

- Regional AWS service.
- A normal DynamoDB table exists in one AWS Region.

## Global Tables

```text
Region A
   ↕
Region B
   ↕
Region C
```

- Same DynamoDB data replicated across multiple Regions.
- Use for global applications / multi-Region data.

## DynamoDB Streams

- Captures item-level changes.
- Example: when a new record is created, trigger downstream processing/notifications.

## DynamoDB TTL

- Automatically deletes expired items.
- Expiration is based on a timestamp attribute you specify.

## DynamoDB PITR

Point-in-time recovery:
- Continuous backup.
- Per-second granularity.
- Mock notes specify restoration to any second in the preceding 35 days.
- Protects against accidental writes/deletes.

## DynamoDB capacity clue

```text
Unpredictable workload
→ On-Demand capacity
```

# 30. ELASTICACHE vs MEMORYDB

## ElastiCache

Use when you need a **cache**.

```text
User
 ↓
Application
 ↓
ElastiCache
 ├── Cache hit → return data
 └── Cache miss → DB → return/store cache
```

Memory is used to avoid repeatedly hitting the database.

## MemoryDB

Use when you need a **durable Redis-compatible primary database**.

```text
Database first
      ↓
Stored/served in memory
      ↓
Durable Redis-compatible DB
```

### Memory trick

```text
ElastiCache → CACHE
MemoryDB    → DURABLE REDIS DATABASE
```

# 31. SPECIALIZED DATABASES

```text
DocumentDB
→ MongoDB-compatible document database

Neptune
→ Graph database
→ Relationships between entities

Keyspaces
→ Apache Cassandra-compatible service

Timestream
→ Time-series data
→ Data indexed by time

Redshift
→ Data warehouse
→ Complex analytical queries over billions of records

OpenSearch
→ Search + logs + analytics
→ Application log analysis

QLDB
→ Immutable transaction history
→ Built-in immutable journal
```

### QLDB clue

If the storage layer must be immutable and you need an accurate, sequenced history of every data change:

```text
→ Amazon QLDB
```

# 32. SQS vs SNS vs KINESIS

```text
                    MESSAGING / STREAMING
                             │
       ┌─────────────────────┼──────────────────────┐
       ↓                     ↓                      ↓
      SQS                   SNS                  Kinesis
      Queue                Fan-out               Stream
       │                     │                      │
  1 message →          1 message →           Continuous/
  1 consumer            many subscribers      high-volume events
```

## SQS

Use for:
- Decoupling.
- Buffering.
- Retry.
- Reliable asynchronous processing.

Example:

```text
Order Service
     ↓
    SQS
     ↓
Payment Worker
```

If 10,000 orders arrive, SQS can hold 10,000 messages while workers process at their own pace.

### SQS FIFO

Use when order/exact-once processing requirements are important and the application requires requests to be processed exactly once with no loss according to the question's stated requirement.

### Polling

```text
Short polling
→ ask → immediate answer

Long polling
→ ask → wait → message
```

# 33. SNS

Use when you need **fan-out / publish-subscribe**.

```text
Order Service
     ↓
    SNS
   / | \
  ↓  ↓  ↓
Team A B Team C
```

Memory:

> "Something happened; tell everyone interested."

# 34. KINESIS

Use for:
- Continuous event streams.
- High-volume data.
- Real-time processing.
- Processing data over time/order.

## Kinesis Data Streams

```text
Producers
   ↓
Kinesis Data Streams
   ↓
Lambda / EC2 / applications
   ↓
Processing
```

Mental model:

> "Give me the data; I'll process it."

## Kinesis Data Firehose

```text
Producers
   ↓
Firehose
   ↓
S3 / Redshift / OpenSearch
```

Mental model:

> "Take this data and deliver it somewhere."

# 35. DATA / ANALYTICS SERVICES

## Athena

- Serverless SQL queries directly against data in S3.

```text
S3
 ↓
Athena
 ↓
SQL results
```

## Glue

- Serverless data integration / ETL.
- Discover.
- Catalog.
- Transform.
- Move data.

```text
CSV/JSON in S3
      ↓
    Glue
      ├── Discover schema
      ├── Catalog
      └── Transform
```

### Glue Data Catalog

- Stores metadata about datasets.
- Primarily used for data integration/preparation.

## Lake Formation

- Data lake governance.
- Fine-grained permissions.
- Can control access to specific tables/columns in an S3-based data lake.

```text
Glue
→ Discover / Catalog / Transform

Lake Formation
→ Data lake governance / permissions
```

## Security Lake

- Central repository for security-related data.
- Can collect security logs/events from CloudTrail, VPC Flow Logs, security solutions, SaaS, on-premises, and other sources.

```text
Security sources
   ↓
Security Lake
   ↓
Central security analysis
```

## OpenSearch

Example:

```text
Kinesis Data Streams
       ↓
     Lambda
       ↓
   OpenSearch
       ↓
Managed Grafana
```

## Managed Grafana

- Visual dashboards.

## AWS Batch

- Runs batch jobs.
- The mock notes specifically emphasize that Batch is **not the appropriate answer for scheduled jobs**.

## Step Functions

- Workflow orchestration.

# 36. STORAGE MASTER MAP

```text
AWS STORAGE
│
├── Object
│   └── S3
│
├── Block
│   ├── EBS
│   └── Instance Store
│
└── File
    ├── EFS
    ├── FSx for Windows
    ├── FSx for Lustre
    └── FSx for ONTAP
```

## Fast memory

```text
EBS            → one server's persistent disk
EFS            → many Linux servers' shared filesystem
Instance Store → fast temporary disk
S3             → durable object storage
```

# 37. S3 STORAGE CLASSES

```text
S3 Standard
   ↓
S3 Standard-IA
   ↓
S3 Intelligent-Tiering
   ↓
S3 One Zone-IA
   ↓
Glacier Instant Retrieval
   ↓
Glacier Flexible Retrieval
   ↓
Glacier Deep Archive
```

## S3 Standard
- Frequent access.
- Low latency.
- High throughput.

## S3 Standard-IA
- Infrequent access.
- Still highly available.
- Immediate retrieval.

## S3 One Zone-IA
- Cheaper.
- Stored in one AZ.
- Lower resilience than Standard-IA.

## Glacier Instant Retrieval
- Archive-oriented storage with immediate retrieval.

## Glacier Flexible Retrieval
- Archive with retrieval delays.

## Glacier Deep Archive
- Very low-cost long-term archive.

## Intelligent-Tiering
- Access pattern is unknown or changes over time.

# 38. S3 + CLOUDFRONT

Use for static content delivery.

```text
User
 ↓
CloudFront Edge Location
 ↓
S3
```

CloudFront caches content closer to users.

## S3 PRE-SIGNED URL

A pre-signed URL:
- Gives temporary access to a specific S3 object.
- Does not require making the bucket/object public.

```text
Application
   ↓
Generate pre-signed URL
   ↓
User
   ↓
Temporary access to S3 object
```

# 39. S3 TRANSFER ACCELERATION

Use when users are geographically far from the S3 bucket's Region and uploads/downloads need acceleration.

```text
User far from Region
      ↓
S3 Transfer Acceleration
      ↓
AWS edge network
      ↓
S3 bucket
```

For a large file, the mock notes highlight:
- Multipart upload.
- S3 Transfer Acceleration.

### Upload-speed clue

```text
Faster large S3 upload
→ Multipart upload

Geographically distant users
→ S3 Transfer Acceleration
```

# 40. S3 COMPLIANCE / IMMUTABILITY

## Versioning + MFA Delete

For compliance/regulatory protection against deletion:

```text
S3 Bucket
├── Versioning
└── MFA Delete
```

## Object Lock

When sensitive objects must be protected from deletion/modification for a fixed retention period:

```text
S3 Object Lock
→ Compliance mode
→ Retention period
→ Object cannot be changed/deleted during retention
```

# 41. S3 MULTI-REGION ENCRYPTION PATTERN

When moving S3 data across Regions while retaining use of the same encryption key concept:

```text
New S3 bucket in Region A
        ↓
Enable replication
        ↓
Destination bucket in Region B

Encryption
        ↓
SSE-KMS
        ↓
KMS multi-Region key
```

The mock's specific example uses:
- `us-east-1` source/new bucket.
- Replication to `us-west-1`.
- SSE-KMS.
- KMS multi-Region key.
- Copy existing data into the new bucket before replication.

# 42. EBS / EFS / FSx / INSTANCE STORE

## EBS

- Block storage.
- Commonly acts as persistent disk for EC2.

## EFS

- Elastic File System.
- NFS-based.
- Linux workloads.
- Multiple EC2 instances can access the same filesystem simultaneously.
- Automatically scales.

```text
EC2-1 ─┐
EC2-2 ─┼── NFS → EFS
EC2-3 ─┘
```

## FSx for Windows File Server

```text
Windows application
       │
      SMB
       ↓
FSx for Windows
```

- Windows workloads.
- SMB.
- Active Directory.
- NTFS.
- DFS namespaces.
- Windows ACLs.
- Can be mounted from Windows and Linux EC2 instances using SMB.

## FSx for Lustre

- High-performance computing.
- Very high-performance file processing.

## FSx for ONTAP

- SMB + NFS workloads.

### Storage clue map

```text
Windows + SMB + AD → FSx for Windows
Linux + NFS        → EFS
On-prem SMB/NFS    → File Gateway
SMB + NFS          → FSx for ONTAP
EC2 disk           → EBS
Object storage     → S3
Temporary local    → Instance Store
HPC/Lustre         → FSx for Lustre
```

# 43. EBS VOLUME TYPES / IOPS / THROUGHPUT

## IOPS

**Input/Output Operations Per Second**

- Measures how many read/write operations a volume can handle per second.
- Higher IOPS → more small/random read/write operations per second.

## Throughput

- Amount of data transferred per unit time.
- Important for large sequential workloads.

```text
                     Amazon EBS
                         │
             ┌───────────┴───────────┐
             │                       │
            SSD                     HDD
             │                       │
   Low latency / high IOPS     High throughput
             │                       │
      ┌──────┼──────┐           ┌────┴────┐
      │      │      │           │         │
     gp2    gp3   io1/io2      st1       sc1
      │      │      │           │         │
 General  General Provisioned  Throughput Cold
 Purpose  Purpose IOPS SSD     Optimized  HDD
```

From the supplied mock notes:

```text
gp2
→ General-purpose SSD
→ IOPS: 16K
→ Throughput: 250 MiB/s
→ General-purpose workloads

gp3
→ General-purpose SSD
→ IOPS: 16K
→ Throughput: 1,000 MiB/s
→ Configurable performance

io1/io2
→ Provisioned IOPS SSD
→ IOPS: 64K (as captured in mock notes)
→ Throughput: 500 MiB/s (as captured)
→ High-performance databases

st1
→ Throughput Optimized HDD
→ Throughput: 500 MiB/s (as captured)
→ Big data / data warehouse / log processing

sc1
→ Cold HDD
→ Throughput: 250 MiB/s (as captured)
→ Infrequent data / archive / backup
```

> **Revision note:** The values above are preserved from the supplied mock notes. AWS limits can vary by volume generation/size/region and should be checked against the current exam reference if a question asks for an exact numeric limit.

## Boot volume

```text
Boot volume
→ Where the operating system lives
```

Mock-note classification:

```text
SSD EBS
→ gp2 → boot volume
→ io1 → boot volume

HDD EBS
→ st1 → not a boot volume
→ sc1 → not a boot volume
```

# 44. STORAGE COST MEMORY

The supplied notes use this simplified ordering:

```text
S3 < EFS < EBS
```

Use the exam's stated requirements rather than choosing solely by price.

# 45. AWS STORAGE GATEWAY

Storage Gateway bridges on-premises environments with AWS storage.

```text
On-Premises
     ↓
Storage Gateway
     ↓
AWS Storage
```

## File Gateway

```text
On-prem application
      ↓
File Gateway
      ↓
S3
```

Use for on-prem file shares backed by S3.

## Volume Gateway

- On-prem applications need block storage.
- AWS provides cloud-backed storage/backup.
- Mock clue: local cache + AWS-backed storage, including cached mode.

## Tape Gateway

```text
On-prem backup
      ↓
Tape Gateway
      ↓
S3 / Glacier
```

Physical tape replacement pattern.

# 46. DATASYNC vs SNOWBALL

```text
DataSync
→ Online / network transfer

Snowball
→ Physical transfer using AWS device
```

## DataSync

```text
On-Prem
   ↓
Network
   ↓
DataSync
   ↓
S3 / EFS / FSx
```

- Managed service.
- Automates and accelerates transfers between on-premises storage and AWS storage.

## Snowball

```text
On-Prem
   ↓
Copy data
   ↓
Snowball device
   ↓
Ship device to AWS
   ↓
AWS uploads data
```

Use when large data volume + poor/limited Internet makes online transfer impractical.

# 47. MIGRATION SERVICES

```text
Application Migration Service (MGN)
→ Server/application lift-and-shift

AWS DMS
→ Database → database migration

AWS DataSync
→ File/storage data transfer
```

Memory:

```text
Server migration → MGN
Database migration → DMS
File/storage migration → DataSync
```

# 48. CLOUDFRONT vs GLOBAL ACCELERATOR

```text
CloudFront
→ CDN
→ Cache content
→ Edge locations
→ Static/dynamic content delivery

Global Accelerator
→ Network acceleration
→ Static Anycast IPs
→ TCP/UDP acceleration
→ Global application/API traffic
```

### Clue

```text
"Cache images/videos/JS near users"
→ CloudFront

"Global users access an API; lower network latency"
→ Global Accelerator

"Need two static IPs users can whitelist"
→ Global Accelerator
```

# 49. S3 MULTI-REGION ACCESS POINT

For global access to S3 across multiple Regions:

```text
Global users
      ↓
S3 Multi-Region Access Point
      ↓
Regional S3 buckets
```

Memory:

```text
S3 global multi-Region access → Multi-Region Access Point
```

# 50. CLOUDWATCH vs CLOUDTRAIL — QUICK CLUE

```text
CloudWatch
→ Monitoring / metrics / logs / alarms

CloudTrail
→ API activity / audit trail
→ Who did what, when
```

Use the service that matches the question's focus.

# 51. CLOUDFORMATION

```text
CloudFormation
│
├── Template
│   → Blueprint
│
├── Stack
│   → Deployment of the blueprint
│
└── StackSet
    → Same blueprint across multiple AWS accounts and/or Regions
```

### Multi-account automation pattern

If an architect needs to automatically and repeatedly:
- Create many member accounts in an AWS Organization.
- Move them into an OU.
- Create VPCs/subnets.

The supplied mock answer is:

```text
CloudFormation + scripts
```

# 52. DATABASE BACKUP / RECOVERY

## RDS

```text
RDS
├── Automated Backup
└── Snapshot
```

### RDS automated backup
- Includes point-in-time recovery behavior.

## AWS Backup

- Centralized backup management.
- Long-term centralized backup clue.

## EBS Snapshot Recycle Bin

```text
EBS Snapshot
      ↓
Recycle Bin
      ↓
Temporary protection from accidental deletion
```

# 53. AVAILABILITY MASTER RULE

```text
Need High Availability / automatic failover
→ Multi-AZ

Need more read capacity
→ Read Replica
```

Do not confuse:

```text
Multi-AZ ≠ Read Scaling
Read Replica ≠ automatic HA replacement
```

For Aurora:

```text
Aurora Replica
→ HA + read scaling
```

# 54. AWS OUTPOSTS

```text
AWS infrastructure
        ↓
Physically located
        ↓
Customer data center
```

AWS Outposts puts AWS infrastructure physically inside the customer's data center.

# 55. AWS AI / ML SERVICES

```text
Comprehend  → Text analysis / sentiment / entities / key phrases
Rekognition → Images / videos
Transcribe   → Speech → text
Polly        → Text → speech
Translate    → Language translation
Textract     → Extract text/data from documents
Lex          → Conversational chatbots
Bedrock      → Foundation models / GenAI
SageMaker    → Build/train/deploy ML models
```

### Comprehend
Can identify:
- Sentiment.
- Entities.
- Key phrases.
- Language.
- Topics/categories.

### Bedrock vs SageMaker

```text
Bedrock
→ Use foundation/GenAI models

SageMaker
→ Build, train, deploy ML models
```

# 56. COST OPTIMIZATION / MANAGED SERVICE CLUES

When the question says:

```text
"Least operational overhead"
"Most cost-effective"
"Highly scalable"
"Do not want to manage servers"
```

Think:

```text
Managed / Serverless
```

Examples:

```text
Lambda
instead of
EC2 for event-driven short workloads

Fargate
instead of
managing EC2 workers

Aurora Serverless
instead of
fixed database capacity for variable workload

S3
instead of
EC2 file hosting

EFS
instead of
building your own NFS server

Security Lake
instead of
custom security ingestion

RDS Proxy
instead of
custom DB connection pooling
```

# 57. APPLICATION / DATA SERVICE CLUE SHEET

```text
Serverless ETL
→ Glue

Real-time stream
→ Kinesis Data Streams

Streaming delivery
→ Kinesis Firehose

Queue/buffer
→ SQS

Fan-out
→ SNS

DynamoDB changes/events
→ DynamoDB Streams

Batch jobs
→ AWS Batch

Workflow orchestration
→ Step Functions

Python file processing
→ S3 + Lambda

Sentiment analysis
→ Comprehend

SQL on S3
→ Athena

Search/log analytics
→ OpenSearch

Dashboard visualization
→ Managed Grafana

Static website
→ S3 + CloudFront

Global S3 upload acceleration
→ S3 Transfer Acceleration

Global CDN/downloads
→ CloudFront

Global application + static IP + acceleration
→ Global Accelerator

S3 global multi-Region access
→ S3 Multi-Region Access Point

S3 private VPC access
→ Gateway Endpoint

Private service between VPCs
→ PrivateLink

Many VPCs/accounts
→ Transit Gateway

Simple VPC-to-VPC
→ VPC Peering

On-prem dedicated network
→ Direct Connect

Highest DX resilience
→ Multiple DX connections/locations

Large data + poor Internet
→ Snowball

File migration/sync
→ DataSync

Server migration
→ MGN

Database migration
→ DMS

On-prem file share
→ File Gateway

On-prem block storage
→ Volume Gateway

Physical tape replacement
→ Tape Gateway

Linux shared filesystem
→ EFS

Windows SMB/AD
→ FSx for Windows

HPC/Lustre
→ FSx for Lustre

Ultra-low-latency temporary storage
→ Instance Store

EC2 persistent block storage
→ EBS

RDS read scaling
→ Read Replica

DB High Availability/failover
→ Multi-AZ

DB connection exhaustion
→ RDS Proxy

Variable relational DB workload
→ Aurora Serverless v2

Global relational DB
→ Aurora Global Database

Specific Aurora replicas
→ Custom Endpoint

Global DynamoDB
→ Global Tables

Unpredictable DynamoDB workload
→ On-Demand capacity

PITR
→ RDS automated backups

Long-term centralized backup
→ AWS Backup

Accidental EBS snapshot deletion
→ Recycle Bin

Temporary S3 object access
→ Pre-signed URL

Credentials + automatic rotation
→ Secrets Manager

Individual IAM maximum
→ Permissions Boundary

Organization-wide guardrail
→ SCP

ECS application AWS permissions
→ Task IAM Role

Employees + AD + multiple AWS accounts
→ IAM Identity Center

Security data centralization
→ Security Lake

VPC traffic filtering by domain
→ Network Firewall

Web/API protection
→ WAF

HPC low latency/high throughput in same AZ
→ Cluster Placement Group
```

# 58. PLACEMENT GROUP CLUE

For HPC workloads requiring low latency/high throughput between EC2 instances, particularly within the same AZ:

```text
→ Cluster Placement Group
```

# 59. ALB vs NLB — VISUAL REVISION

```text
                         USERS
                           │
                           ↓
                    ┌──────────────┐
                    │ API Gateway  │
                    │ API front    │
                    │ door/manage  │
                    └──────┬───────┘
                           │
                ┌──────────┴──────────┐
                ↓                     ↓
              ALB                   NLB
          HTTP / HTTPS        TCP / UDP / TLS
                │              High-performance
                ↓                     │
         Applications          Applications
```

# 60. CONTAINER REVISION GRAPH

```text
Application
   │
   ↓
Docker image
   │
   ↓
Container
   │
   ↓
ECS
   │
   ├───────────────┐
   ↓               ↓
  EC2            Fargate
   │               │
You manage      AWS manages
servers         infrastructure
```

# 61. IAM POLICY EXAMPLES FROM THE MOCKS

## S3 read-only access

To list the bucket:

```text
s3:ListBucket
Resource:
arn:aws:s3:::mybucket
```

To read objects:

```text
s3:GetObject
Resource:
arn:aws:s3:::mybucket/*
```

Memory:

```text
Bucket-level action
→ arn:aws:s3:::mybucket

Object-level action
→ arn:aws:s3:::mybucket/*
```

# 62. IAM REGION CONDITION

To allow EC2 `RunInstances` only in `eu-west-1`:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "ec2:RunInstances",
      "Effect": "Allow",
      "Resource": "*",
      "Condition": {
        "StringEquals": {
          "aws:RequestedRegion": "eu-west-1"
        }
      }
    }
  ]
}
```

### Exam clue

```text
aws:RequestedRegion
→ Region in which the API request is requested
```

# 63. IAM SOURCE-IP + REGION PATTERN

For a policy allowing EC2 termination from a specific source CIDR while restricting the operation to a Region, combine conditions such as:

```text
IpAddress
→ aws:SourceIp

Region restriction
→ appropriate EC2 region condition
```

The supplied mock includes examples for:
- `us-west-1` + source `10.200.200.0/24`.
- `us-east-1` + source `10.1.2.0/24`.
- `34.50.31.0/24` as an allowed source CIDR for `ec2:RunInstances`.

### Important reading rule

```text
Allow statement
→ What action is permitted?

Condition
→ Under what circumstances?

Deny statement
→ Explicitly blocks matching requests
```

# 64. EC2 TENANCY

Instance tenancy can be specified in:

```text
1. VPC tenancy
2. Launch Template tenancy
```

Mock combination:

```text
VPC Default    + Launch Default    → Default
VPC Default    + Launch Dedicated  → Dedicated
VPC Dedicated  + Launch Default    → Dedicated
VPC Dedicated  + Launch Dedicated  → Dedicated
```

# 65. CROSS-ZONE LOAD BALANCING PATTERN

From the supplied mock example:

### Cross-zone enabled

If:
- AZ-A has 1 instance.
- AZ-B has 4 instances.

Total = 5 instances.

Traffic is distributed evenly:

```text
AZ-A instance → 20%
AZ-B instance 1 → 20%
AZ-B instance 2 → 20%
AZ-B instance 3 → 20%
AZ-B instance 4 → 20%
```

### Cross-zone disabled

Traffic is distributed per AZ:

```text
AZ-A → 50%
  1 instance → 50%

AZ-B → 50%
  4 instances
  → 12.5% each
```

# 66. EC2 RECOVERY

If an instance has a public IPv4 address, the supplied mock notes state that after recovery the instance retains the public IPv4 address.

A recovered instance is identical to the original in the stated scenario, including:
- Instance ID.
- Private IP addresses.
- Elastic IP addresses.
- Instance metadata.

# 67. FSx FOR WINDOWS vs EFS

```text
Windows Application
      │
     SMB
      ↓
FSx for Windows
```

```text
Linux EC2
    │
   NFS
    ↓
   EFS
```

Quick memory:

```text
Windows + SMB → FSx for Windows
Linux + NFS   → EFS
```

# 68. AWS SERVICE CHOICE BY REQUIREMENT

## Compute

```text
Short event-driven code
→ Lambda

Long-running/full OS control
→ EC2

Containers + server management
→ ECS + EC2

Containers + no server management
→ ECS + Fargate

Interruptible/cost-sensitive
→ Spot

No long-term commitment
→ On-Demand
```

## Database

```text
Traditional relational
→ RDS

Cloud-optimized relational
→ Aurora

NoSQL/serverless
→ DynamoDB

Cache
→ ElastiCache

Durable Redis database
→ MemoryDB

MongoDB-compatible
→ DocumentDB

Graph relationships
→ Neptune

Cassandra
→ Keyspaces

Time-series
→ Timestream

Warehouse/analytics
→ Redshift

Search/logs
→ OpenSearch

Immutable ledger
→ QLDB
```

# 69. AVAILABILITY / SCALING / PERFORMANCE CLUES

```text
"High availability"
→ Multi-AZ / redundant architecture

"Read scaling"
→ Read Replica / Aurora Replica

"Too many DB connections"
→ RDS Proxy

"Unpredictable traffic"
→ Auto Scaling / Serverless / On-Demand

"Predictable traffic at a known time"
→ Scheduled Scaling

"Temporary interruption acceptable"
→ Spot

"Global low-latency content"
→ CloudFront

"Global low-latency application/network"
→ Global Accelerator
```

# 70. PRIVATE CONNECTIVITY DECISION TREE

```text
Need private connectivity?
        │
        ├── AWS service?
        │      ├── S3/DynamoDB
        │      │      → Gateway Endpoint
        │      └── Specific private service
        │             → PrivateLink
        │
        ├── Many VPCs/networks?
        │      → Transit Gateway
        │
        ├── Just two VPCs?
        │      → VPC Peering
        │
        └── On-premises?
               ├── Dedicated/private
               │      → Direct Connect
               └── Encrypted VPN
                      → IPsec VPN
```

# 71. GLOBAL ARCHITECTURE DECISION TREE

```text
Global requirement
       │
       ├── Content / CDN
       │      → CloudFront
       │
       ├── Application/network traffic
       │      → Global Accelerator
       │
       ├── S3 multi-Region
       │      → S3 Multi-Region Access Point
       │
       ├── DynamoDB multi-Region
       │      → Global Tables
       │
       └── Aurora multi-Region
              → Aurora Global Database
```

# 72. SECURITY DECISION TREE

```text
Security requirement
        │
        ├── Web/API
        │      → WAF
        │
        ├── VPC/network
        │      → Network Firewall
        │
        ├── IAM identity maximum
        │      → Permissions Boundary
        │
        ├── Account/OU guardrail
        │      → SCP
        │
        ├── Secret/credential
        │      → Secrets Manager
        │
        ├── Temporary S3 access
        │      → Pre-signed URL
        │
        ├── Sensitive S3 data discovery
        │      → Macie
        │
        ├── Threat detection
        │      → GuardDuty
        │
        ├── Vulnerabilities
        │      → Inspector
        │
        └── Configuration/compliance history
               → AWS Config
```

# 73. DATABASE TROUBLESHOOTING DECISION TREE

```text
Database problem
      │
      ├── Need HA/failover?
      │      → Multi-AZ
      │
      ├── Too many reads?
      │      → Read Replica
      │
      ├── Too many connections?
      │      → RDS Proxy
      │
      ├── Variable Aurora capacity?
      │      → Aurora Serverless
      │
      ├── Global Aurora?
      │      → Aurora Global Database
      │
      └── Global DynamoDB?
             → Global Tables
```

# 74. SHARED STORAGE DECISION TREE

```text
Need shared storage?
       │
       ├── Linux + NFS
       │      → EFS
       │
       ├── Windows + SMB + AD
       │      → FSx for Windows
       │
       ├── HPC / Lustre
       │      → FSx for Lustre
       │
       ├── SMB + NFS
       │      → FSx for ONTAP
       │
       └── On-prem file share
              → File Gateway
```

# 75. MIGRATION DECISION TREE

```text
Need to move something to AWS?
        │
        ├── Entire server/application
        │      → Application Migration Service (MGN)
        │
        ├── Database
        │      → DMS
        │
        ├── Files/storage over network
        │      → DataSync
        │
        └── Huge amount of data + poor network
               → Snowball
```

# 76. SQS / SNS / KINESIS DECISION TREE

```text
Events/messages
     │
     ├── Need queue/buffer/retry?
     │      → SQS
     │
     ├── Need fan-out to many subscribers?
     │      → SNS
     │
     └── Need continuous high-volume stream?
            │
            ├── Process the stream
            │      → Kinesis Data Streams
            │
            └── Deliver stream to destination
                   → Kinesis Data Firehose
```

# 77. COMMON EXAM TRAPS

## Trap 1 — Multi-AZ vs Read Replica

```text
HA/failover       → Multi-AZ
Read performance  → Read Replica
```

## Trap 2 — NAT vs VPC Endpoint

```text
Internet           → NAT Gateway
AWS service        → VPC Endpoint
```

## Trap 3 — VPC Peering vs Transit Gateway

```text
Two VPCs            → Peering
Many VPCs/networks  → Transit Gateway
```

## Trap 4 — PrivateLink

```text
Want access to one private service without exposing the provider's entire VPC
→ PrivateLink
```

## Trap 5 — CloudFront vs Global Accelerator

```text
Cache/content → CloudFront
Network/API   → Global Accelerator
```

## Trap 6 — WAF vs Network Firewall

```text
HTTP/web application → WAF
VPC/network traffic  → Network Firewall
```

## Trap 7 — IAM Boundary vs SCP

```text
One IAM user/role → Permissions Boundary
Account/OU        → SCP
```

## Trap 8 — ElastiCache vs MemoryDB

```text
Cache                 → ElastiCache
Durable Redis DB      → MemoryDB
```

## Trap 9 — EFS vs FSx Windows

```text
Linux/NFS             → EFS
Windows/SMB/AD        → FSx for Windows
```

## Trap 10 — DataSync vs Snowball

```text
Online/network        → DataSync
Physical device       → Snowball
```

## Trap 11 — DMS vs MGN

```text
Database              → DMS
Server/application    → MGN
```

## Trap 12 — SQS vs Kinesis

```text
Work queue            → SQS
Continuous stream     → Kinesis
```

# 78. BIGGEST MOCK-EXAM PATTERNS

These are the high-value patterns captured across the supplied mocks:

```text
"Least operational effort"
→ Managed / Serverless

"Unpredictable traffic"
→ Auto Scaling / Serverless / On-Demand

"Predictable time-based traffic"
→ Scheduled Scaling

"Traffic spike overwhelms backend"
→ SQS buffer + scale consumers

"Global + low latency"
→ Identify traffic type:
     Content       → CloudFront
     Application   → Global Accelerator
     S3            → Multi-Region Access Point
     DynamoDB      → Global Tables
     Aurora        → Global Database

"Private"
→ Identify destination:
     S3/DynamoDB    → Gateway Endpoint
     Private service→ PrivateLink
     Many VPCs      → Transit Gateway
     Two VPCs       → Peering
     On-prem        → Direct Connect/VPN

"Shared storage"
→ Identify workload:
     Linux          → EFS
     Windows         → FSx Windows
     HPC             → FSx Lustre
     SMB + NFS       → FSx ONTAP
     On-prem file    → File Gateway

"Database performance"
→ Identify exact problem:
     Too many reads → Read Replica
     Connections     → RDS Proxy
     Variable cap.   → Aurora Serverless
     Global reads    → Aurora Global Database

"Security"
→ Identify level:
     Application     → WAF
     Network         → Network Firewall
     IAM identity    → Permissions Boundary
     Organization    → SCP
     Secret          → Secrets Manager
     S3 temporary    → Pre-signed URL
     At rest         → Encryption/KMS
     In transit      → TLS
```

# 79. LAST-MINUTE 5-MINUTE REVISION

```text
REGION
→ Geographic area

AZ
→ Isolated data-center location inside Region

VPC
→ Network inside one Region

SUBNET
→ Inside one AZ

PUBLIC SUBNET
→ Route to IGW

PRIVATE SUBNET
→ No direct IGW route

NAT GATEWAY
→ Private → Internet outbound

IGW
→ VPC ↔ Internet

SG
→ Resource firewall, stateful

NACL
→ Subnet firewall, stateless

ROUTE TABLE
→ Traffic direction

ALB
→ HTTP/HTTPS application traffic

NLB
→ TCP/UDP/TLS network traffic

API GATEWAY
→ API front door/management

ASG
→ EC2 scaling

LAMBDA
→ Serverless event-driven code

ECS
→ Container orchestration

FARGATE
→ Serverless container compute

S3
→ Object storage

EBS
→ Persistent block disk

EFS
→ Shared Linux filesystem

INSTANCE STORE
→ Temporary high-speed local disk

FSx Windows
→ Windows + SMB + AD

FSx Lustre
→ HPC

CLOUDFRONT
→ CDN/cache

GLOBAL ACCELERATOR
→ Global network acceleration/static IP

ROUTE 53
→ DNS

RDS
→ Managed relational DB

MULTI-AZ
→ HA/failover

READ REPLICA
→ Read scaling

RDS PROXY
→ Connection pooling

AURORA
→ Cloud-optimized relational DB

AURORA REPLICA
→ HA + read scaling

AURORA GLOBAL
→ Multi-Region Aurora

DYNAMODB
→ Serverless NoSQL

DYNAMODB GLOBAL TABLES
→ Multi-Region DynamoDB

ELASTICACHE
→ Cache

MEMORYDB
→ Durable Redis database

SQS
→ Queue

SNS
→ Fan-out

KINESIS
→ Stream

GLUE
→ ETL

ATHENA
→ SQL on S3

REDSHIFT
→ Data warehouse

OPENSEARCH
→ Search/logs/analytics

SECURITY LAKE
→ Central security data

WAF
→ Web/API protection

NETWORK FIREWALL
→ VPC traffic inspection

GUARDDUTY
→ Threat detection

MACIE
→ Sensitive S3 data

INSPECTOR
→ Vulnerability assessment

CONFIG
→ Configuration/compliance history

IAM POLICY
→ Permissions

PERMISSIONS BOUNDARY
→ IAM identity maximum

SCP
→ Account/OU guardrail

SECRETS MANAGER
→ Secrets + rotation

PRE-SIGNED URL
→ Temporary S3 access

DIRECT CONNECT
→ Dedicated on-prem ↔ AWS

VPN
→ Encrypted IPsec connectivity

VPC PEERING
→ Two VPCs

TRANSIT GATEWAY
→ Many VPCs

PRIVATELINK
→ One private service

DATASYNC
→ Online file/storage transfer

SNOWBALL
→ Physical data transfer

MGN
→ Server/application migration

DMS
→ Database migration

CLOUDFORMATION TEMPLATE
→ Blueprint

STACK
→ Blueprint deployment

STACKSET
→ Blueprint across accounts/Regions
```

# 80.FINAL EXAM MINDSET

For every scenario, ask these questions in order:

```text
1. WHAT is the problem?
   │
   ├── Compute?
   ├── Network?
   ├── Storage?
   ├── Database?
   ├── Security?
   ├── Messaging?
   └── Migration/Analytics?
          │
          ↓
2. WHAT is the required behavior?
   │
   ├── HA?
   ├── Read scaling?
   ├── Low latency?
   ├── Global?
   ├── Private?
   ├── Serverless?
   ├── Cheapest?
   ├── Least operational effort?
   └── Compliance?
          │
          ↓
3. WHAT is the scope?
   │
   ├── Resource
   ├── Subnet
   ├── VPC
   ├── Account/OU
   └── Organization
          │
          ↓
4. PICK THE SERVICE
          │
          ↓
5. ELIMINATE ANSWERS THAT ADD
   UNNECESSARY OPERATIONAL OVERHEAD
```

## One-line principle

> **SAA questions are usually testing whether you can identify the requirement and choose the AWS service that solves exactly that requirement with the appropriate level of availability, scalability, security, cost, and operational effort.**

# 81. SOURCE COVERAGE CHECKLIST

The supplied mock notes covered the following major areas, all organized above:

- Region / AZ / Edge Location
- VPC / Subnets / Public vs Private
- IGW / NAT Gateway / NAT Instance
- Security Groups / NACLs / Route Tables
- ALB / NLB / API Gateway
- Three-tier architecture and SG chaining
- Auto Scaling / target tracking / scheduled scaling / standby
- ASG termination policy
- EC2 / Lambda / Spot / On-Demand / Hibernate / Dedicated Instances / User Data
- Horizontal vs vertical scaling
- AMI / Launch Template
- ECS / Fargate / containers / Docker
- VPC Endpoints
- VPC Peering / Transit Gateway / PrivateLink
- Direct Connect / resiliency / VPG / IPsec VPN
- VPC sharing / RAM
- Route 53 routing policies
- DNS records
- Directory Service / AD Connector / IAM Identity Center
- WAF / Network Firewall / Shield
- RDS / Read Replica / RDS Proxy / Oracle / RDS Custom
- RDS Multi-AZ
- Aurora / Aurora Replica / Aurora Global / Babelfish / SCT / DMS
- DynamoDB / Global Tables / Streams / TTL / PITR / On-Demand
- ElastiCache / MemoryDB
- DocumentDB / Neptune / Keyspaces / Timestream / Redshift / OpenSearch / QLDB
- SQS / FIFO / polling / SNS / Kinesis Data Streams / Firehose
- S3 storage classes / Intelligent-Tiering
- S3 Transfer Acceleration / multipart upload
- S3 Versioning / MFA Delete / Object Lock
- S3 multi-Region encryption pattern
- CloudFront / Global Accelerator
- EBS / EFS / FSx Windows / FSx Lustre / FSx ONTAP / Instance Store
- EBS IOPS / throughput / volume types / boot volume
- Storage Gateway / File / Volume / Tape
- DataSync / Snowball
- MGN / DMS
- IAM Policies / Permissions Boundaries / SCP
- ECS IAM roles / Secrets Manager / Pre-signed URLs
- Encryption at rest / transit / client-side
- RDS encryption migration
- RDS backup / snapshots / AWS Backup / EBS Snapshot Recycle Bin
- Athena / Glue / Data Catalog / Lake Formation
- Security Lake / GuardDuty / Inspector / Macie / Config
- AI services
- Cost optimization / managed services
- CloudFormation Template / Stack / StackSet
- IAM policy examples / region / source-IP conditions
- Cross-zone load balancing
- EC2 recovery
- EC2 tenancy
- WAF + CloudFront + S3 origin protection
- ALB vs NLB
- Placement Groups
- Final mock-exam clue maps and decision trees

---

# 82. ULTRA-SHORT MEMORY GRAPH

```text
                         AWS SAA
                            │
 ┌──────────────────────────┼───────────────────────────┐
 │                          │                           │
COMPUTE                   NETWORK                    STORAGE
 │                          │                           │
EC2                       VPC                         S3
Lambda                    Subnet                      EBS
ECS/Fargate               SG/NACL                     EFS
ASG                       IGW/NAT                     FSx
Spot                      Endpoint                    Instance Store
                          Peering/TGW
                          PrivateLink/DX
 └──────────────────────────┼───────────────────────────┘
                            │
                         DATABASE
                            │
          ┌─────────────────┼─────────────────┐
          ↓                 ↓                 ↓
         RDS              Aurora          DynamoDB
      Multi-AZ          Replica/Global     Global/TTL
      Replica           Serverless         Streams
      Proxy
                            │
                            ↓
                       INTEGRATION
                            │
               SQS ─ SNS ─ Kinesis
                            │
                            ↓
                        ANALYTICS
                            │
          Glue ─ Athena ─ Redshift ─ OpenSearch
                            │
                            ↓
                         SECURITY
                            │
     WAF ─ Network Firewall ─ IAM ─ SCP ─ Secrets
     GuardDuty ─ Inspector ─ Macie ─ Config ─ Security Lake
                            │
                            ↓
                      GLOBAL / DNS
                            │
        Route 53 ─ CloudFront ─ Global Accelerator
```

**Final memory anchors:**

```text
HA                  → Multi-AZ
READS               → Read Replica
CONNECTIONS         → RDS Proxy
GLOBAL AURORA       → Aurora Global Database
GLOBAL DYNAMODB     → Global Tables
CACHE               → ElastiCache
DURABLE REDIS       → MemoryDB

PRIVATE → INTERNET  → NAT
PRIVATE → AWS SVC   → VPC Endpoint
2 VPCs              → Peering
Many VPCs           → Transit Gateway
One private service → PrivateLink
ON-PREM dedicated   → Direct Connect

WEB/API             → WAF
VPC traffic         → Network Firewall
IAM max             → Permissions Boundary
Account/OU max      → SCP
SECRET              → Secrets Manager
TEMP S3 ACCESS      → Pre-signed URL

CONTENT GLOBAL      → CloudFront
APP GLOBAL           → Global Accelerator
DNS                  → Route 53

LINUX SHARED        → EFS
WINDOWS SMB         → FSx Windows
HPC                 → FSx Lustre
OBJECT              → S3
BLOCK               → EBS
TEMP LOCAL          → Instance Store

QUEUE               → SQS
FAN-OUT             → SNS
STREAM              → Kinesis
ETL                 → Glue
SQL ON S3           → Athena
WORKFLOW            → Step Functions
BATCH               → AWS Batch

SERVER MIGRATION    → MGN
DB MIGRATION        → DMS
FILE MIGRATION      → DataSync
BIG DATA / POOR NET → Snowball
```















