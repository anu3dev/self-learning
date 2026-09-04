# Amazon ECS — Getting Started

## What is Amazon ECS?

**Amazon ECS (Elastic Container Service)** is a **fully managed container orchestration service** used to deploy, manage, and scale containerized applications.

ECS removes the need to manage your own container orchestration software and manually schedule containers across virtual machines.

```text
Containerized Application
          ↓
      Amazon ECS
          ↓
Deploy → Manage → Scale
```

> **Easy Memory:**  
> **ECS = Deploy + Manage + Scale Containers**

---

# How Amazon ECS Works

Amazon ECS can run containers in two main environments:

```text
                 Amazon ECS
                    ↓
          ┌─────────┴─────────┐
          ↓                   ↓
       Amazon EC2          AWS Fargate
          ↓                   ↓
   You manage EC2       Serverless compute
   infrastructure       for containers
```

ECS handles tasks such as:

- Container placement
- Resource management
- Availability
- Health monitoring
- Failure recovery
- Scaling

---

# ECS High-Level Flow

```text
Container Image
       ↓
    Amazon ECR
       ↓
 Task Definition
       ↓
     ECS Task
       ↓
 ECS Service
       ↓
 Running Containers
```

---

# Core Functionality

Amazon ECS provides three major capabilities:

### Container Orchestration

Manages where and how containers run.

### Cluster Management

Provides a logical grouping of compute resources used to run ECS workloads.

### Application Lifecycle Management

Helps deploy, update, scale, monitor, and recover containerized applications.

---

# Important ECS Concepts

## 1. Container

A **container** packages an application and its dependencies into a portable unit.

```text
Container
├── Application
├── Dependencies
└── Runtime
```

---

## 2. Task Definition

A **Task Definition** is the blueprint that describes how ECS should run one or more containers.

It defines things such as:

- Container image
- CPU
- Memory
- Networking
- Ports
- Environment/configuration
- IAM roles

```text
Task Definition
       ↓
Container Configuration
       ↓
ECS Task
```

> **Easy Memory:**  
> **Task Definition = Blueprint**

---

## 3. Task

A **Task** is a running instance of a task definition.

```text
Task Definition
      ↓
    Task
      ↓
Running Container(s)
```

> **Easy Memory:**  
> **Definition = Blueprint**  
> **Task = Running Instance**

---

## 4. Service

An **ECS Service** maintains the desired number of running tasks.

Example:

```text
Desired Count = 3

ECS Service
   ├── Task 1
   ├── Task 2
   └── Task 3
```

If a task fails, the service can replace it to maintain the desired count.

> **Easy Memory:**  
> **Service = Keeps the desired number of Tasks running**

---

## 5. Cluster

An **ECS Cluster** is a logical grouping where ECS tasks and services run.

```text
ECS Cluster
│
├── Service A
│    ├── Task
│    └── Task
│
└── Service B
     ├── Task
     └── Task
```

---

# ECS Launch Options

## Amazon EC2

With the EC2 launch model:

```text
ECS
 ↓
EC2 Instances
 ↓
Containers
```

You have more responsibility for the underlying compute infrastructure.

---

## AWS Fargate

Fargate provides **serverless compute for containers**.

```text
ECS
 ↓
Fargate
 ↓
Containers
```

You don't need to manage the underlying EC2 servers.

> **Exam Shortcut:**

```text
ECS + EC2
→ You manage underlying compute

ECS + Fargate
→ Serverless container compute
```

---

# Capacity Providers

**Capacity providers** help ECS determine how tasks use available compute capacity.

They can be used with ECS compute options such as:

- EC2
- Fargate

They help manage how ECS tasks are placed onto available capacity.

---

# Task Placement Strategies

ECS uses **task placement strategies** to determine where tasks should run.

Placement is based on factors such as:

- Available resources
- Capacity
- Availability requirements

The goal is to place tasks efficiently while meeting application requirements.

---

# Container Agent

The **ECS container agent** communicates with the ECS service and manages containers on supported ECS compute infrastructure.

Conceptually:

```text
ECS Control Plane
       ↓
Container Agent
       ↓
Containers
```

---

# ECS Networking

ECS supports task networking and integrates with **Amazon VPC**.

```text
ECS Task
   ↓
VPC Networking
   ↓
Network Resources
```

Task networking allows containers to communicate with other AWS resources and applications.

---

# ECS Auto Scaling

ECS supports **service auto scaling**.

```text
Low Traffic
    ↓
Fewer Tasks

High Traffic
    ↓
More Tasks
```

Example:

```text
Normal Traffic
   ↓
2 Tasks

Traffic Spike
   ↓
5 Tasks
```

This allows applications to respond to changing demand.

---

# ECS + Application Load Balancer

ECS integrates with **Elastic Load Balancing**, especially **Application Load Balancer (ALB)**.

```text
Users
  ↓
Application Load Balancer
  ↓
ECS Service
  ↓
Task  Task  Task
```

Benefits include:

- Traffic distribution
- Health checks
- Path-based routing
- TLS termination

This is a common architecture for web applications and APIs.

---

# ECS + Amazon ECR

**Amazon ECR (Elastic Container Registry)** stores container images.

```text
Developer
    ↓
Build Container Image
    ↓
Amazon ECR
    ↓
Amazon ECS
    ↓
Run Container
```

> **Easy Memory:**  
> **ECR = Store Container Images**  
> **ECS = Run/Manage Containers**

---

# ECS Monitoring

ECS integrates with **Amazon CloudWatch** for monitoring and logging.

```text
ECS
 ↓
CloudWatch
 ↓
Metrics / Logs / Monitoring
```

Useful for:

- Application monitoring
- Container monitoring
- Troubleshooting
- Operational visibility

---

# ECS Security

ECS integrates with **AWS IAM** to control access.

Use:

- IAM roles
- IAM policies
- Least-privilege permissions
- Encryption
- Secure authentication

```text
IAM
 ↓
Control Access
 ↓
ECS Resources
```

---

# ECS + VPC

ECS integrates with **Amazon VPC** for networking.

```text
VPC
│
├── Subnets
├── Security Groups
└── ECS Tasks
```

This allows ECS workloads to communicate securely with other resources in the AWS network.

---

# Important ECS Integrations

| AWS Service | Purpose |
|---|---|
| **Amazon ECR** | Store container images |
| **AWS Fargate** | Serverless container compute |
| **Elastic Load Balancing** | Distribute application traffic |
| **AWS IAM** | Access control |
| **Amazon CloudWatch** | Monitoring and logging |
| **AWS CloudFormation** | Infrastructure as Code |
| **Amazon VPC** | Networking |

---

# Practical Use Cases

## 1. Microservices Architecture

Each microservice can run as a separate container/service.

```text
ECS Cluster
│
├── User Service
├── Order Service
├── Payment Service
└── Notification Service
```

Each service can be developed, deployed, and scaled independently.

---

## 2. Batch Processing

ECS can run temporary workloads that process large amounts of data.

Examples:

- Log processing
- Data transformation
- Image processing
- Financial calculations

```text
Batch Job
   ↓
ECS Task
   ↓
Process Data
   ↓
Task Complete
```

For more complex batch scheduling and dependencies, ECS can integrate with **AWS Batch**.

---

## 3. Web Applications and APIs

Common architecture:

```text
Users
  ↓
Application Load Balancer
  ↓
ECS Service
  ↓
ECS Tasks
  ↓
Application
```

ECS service auto scaling can help handle variable traffic.

---

## 4. Machine Learning Workflows

ECS can run containerized ML workloads such as:

```text
Data Preprocessing
       ↓
Model Training
       ↓
Model Deployment
       ↓
Inference Service
```

Containers can package ML frameworks and dependencies consistently across environments.

---

# ECS Deployment

ECS supports deployment options for updating containerized applications.

Conceptually:

```text
Old Version
     ↓
Deployment
     ↓
New Version
```

ECS manages the deployment of tasks according to the configured service and deployment strategy.

---

# ECS High-Level Architecture

```text
                         Users
                           ↓
                Application Load Balancer
                           ↓
                     ECS Service
                           ↓
              ┌────────────┼────────────┐
              ↓            ↓            ↓
            Task         Task         Task
              ↓            ↓            ↓
         Containers   Containers   Containers
              ↓
        ECS Compute Capacity
          /             \
         ↓               ↓
      EC2              Fargate
```

---

# ECS vs ECR

| Service | Purpose |
|---|---|
| **Amazon ECS** | Container orchestration |
| **Amazon ECR** | Container image registry |

```text
ECR → STORE IMAGE

ECS → RUN / MANAGE CONTAINER
```

---

# ECS vs Fargate

These are not exactly competing services.

```text
Amazon ECS
   ↓
Container Orchestration
   ↓
Can use Fargate as compute
```

**ECS** manages the container workload.

**Fargate** provides serverless compute for the containers.

---

# ECS Security Considerations

Important considerations:

- Use IAM roles and policies.
- Follow least privilege.
- Encrypt sensitive data.
- Secure container networking.
- Use appropriate security groups.
- Audit permissions regularly.
- Consider VPC endpoints/private connectivity where appropriate.

```text
Security
   ↓
IAM + VPC + Security Groups
   ↓
Secure ECS Workloads
```

---

# Scalability Considerations

ECS supports scaling at the service/task level.

```text
Demand
  ↓
Auto Scaling
  ↓
Task Count Changes
  ↓
Application Capacity Adjusts
```

For production workloads, consider:

- Service Auto Scaling
- Capacity providers
- Load balancing
- Task placement
- Fargate/EC2 capacity

---

# ⭐ Quick Revision

```text
Amazon ECS
    ↓
Container Orchestration
    ↓
Task Definition
    ↓
Task
    ↓
Service
    ↓
Running Containers
```

### Key Terms

> **ECS** → Managed container orchestration service.

> **Container** → Packaged application and dependencies.

> **Task Definition** → Blueprint for running containers.

> **Task** → Running instance of a task definition.

> **Service** → Maintains the desired number of running tasks.

> **Cluster** → Logical grouping for ECS workloads.

> **EC2** → ECS compute where you manage the underlying instances.

> **Fargate** → Serverless compute for ECS containers.

> **ECR** → Container image registry.

> **Capacity Provider** → Helps manage ECS compute capacity.

> **Task Placement** → Determines where ECS tasks run.

> **Container Agent** → Communicates with ECS and manages containers on supported infrastructure.

---

# 🧠 Easy Memory

```text
ECR       → STORE IMAGE
ECS       → MANAGE CONTAINERS
Task Def  → BLUEPRINT
Task      → RUNNING INSTANCE
Service   → MAINTAIN TASKS
Cluster   → GROUP WORKLOADS
Fargate   → SERVERLESS COMPUTE
EC2       → MANAGED BY YOU
ALB       → DISTRIBUTE TRAFFIC
CloudWatch→ MONITOR
IAM       → CONTROL ACCESS
VPC       → NETWORK
```

# 🎯 Exam / FDE Takeaways

> **Need to run and manage containers on AWS?** → **Amazon ECS**

> **Need serverless container compute?** → **AWS Fargate**

> **Need to store Docker/container images?** → **Amazon ECR**

> **Need the blueprint for how a container should run?** → **Task Definition**

> **Need a running instance of a task definition?** → **Task**

> **Need to maintain a desired number of tasks?** → **ECS Service**

> **Need to group ECS workloads?** → **ECS Cluster**

> **Need to distribute traffic to ECS web applications?** → **Application Load Balancer**

> **Need automatic scaling based on demand?** → **ECS Service Auto Scaling**

> **Need monitoring and logging?** → **Amazon CloudWatch**

> **Need access control?** → **AWS IAM**

> **Need container networking?** → **Amazon VPC**

> **Need batch workloads?** → **ECS Tasks / AWS Batch integration**

> **Need microservices?** → **ECS is a common container orchestration option**

## ⭐ One-Line Summary

> **Amazon ECS is a fully managed AWS container orchestration service that deploys, manages, scales, and monitors containerized applications using compute options such as Amazon EC2 or serverless AWS Fargate.**