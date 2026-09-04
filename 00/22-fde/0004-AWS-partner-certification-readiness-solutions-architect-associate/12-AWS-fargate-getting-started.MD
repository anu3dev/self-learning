# AWS Fargate — Getting Started

## What is AWS Fargate?

**AWS Fargate** is a **serverless compute engine for containers** that works with:

- **Amazon ECS**
- **Amazon EKS**

Fargate removes the need to provision and manage the underlying servers.

```text
Container
    ↓
ECS / EKS
    ↓
AWS Fargate
    ↓
AWS manages infrastructure
```

> **Easy Memory:**  
> **ECS / EKS = Container Orchestration**  
> **Fargate = Serverless Compute for Containers**

---

# What Problem Does Fargate Solve?

With traditional container deployments using EC2, you need to manage the underlying servers.

```text
ECS
 ↓
EC2
 ↓
You manage servers
```

With Fargate:

```text
ECS / EKS
 ↓
Fargate
 ↓
AWS manages servers
```

This allows developers to focus on:

- Application design
- Application development
- Container configuration
- Scaling applications

instead of infrastructure management.

---

# Fargate Core Functionality

AWS Fargate provides:

### Serverless Container Compute

Runs containers without requiring you to manage servers.

### Resource Isolation

Each container runs in its own isolated environment.

### Pay-Per-Use

You specify the resources required by the application and pay based on the resources used.

### Automatic Infrastructure Management

Fargate handles underlying:

- Provisioning
- Configuration
- Compute resource management
- Scaling

> **Key Idea:**  
> **Deploy and manage your applications, not your infrastructure.**

---

# Fargate Resource Isolation

Fargate provides **resource-level isolation**.

Each container runs in an isolated environment without sharing:

- Kernel
- CPU
- Memory
- Storage

with other containers.

```text
Fargate
│
├── Container A
│   └── Isolated Environment
│
├── Container B
│   └── Isolated Environment
│
└── Container C
    └── Isolated Environment
```

This provides stronger security boundaries between applications and helps reduce the attack surface.

> **Exam Point:**  
> **Fargate → Resource-level isolation**

---

# Resource Specification

With Fargate, you specify resources for your application/container workload.

Typical resource requirements include:

```text
CPU
Memory
```

Fargate then provides the required compute environment.

---

# Fargate vs Amazon EC2

| Amazon EC2 | AWS Fargate |
|---|---|
| You manage virtual machines | AWS manages underlying infrastructure |
| Server management required | No server management |
| More infrastructure responsibility | Less infrastructure management |
| Compute infrastructure is visible to you | Serverless container compute |

```text
EC2
→ Manage Servers

Fargate
→ Manage Containers
```

---

# Fargate vs ECS / EKS

These services have different responsibilities.

| Service | Primary Role |
|---|---|
| **Amazon ECS** | Container orchestration |
| **Amazon EKS** | Kubernetes container orchestration |
| **AWS Fargate** | Serverless compute environment for containers |

```text
ECS / EKS
   ↓
Orchestrates Containers
   ↓
Fargate
   ↓
Runs Containers
```

> **Easy Memory:**  
> **ECS/EKS = Orchestrate**  
> **Fargate = Compute**

---

# Important Technical Concepts

The course identifies these important Fargate concepts:

```text
Containers
Task Definitions
Pods
Networking
IAM Roles for Tasks
Service Discovery
Load Balancing
Logging and Monitoring
```

---

# Task Definitions

For ECS workloads, a **Task Definition** specifies container configuration and resource requirements.

```text
Task Definition
      ↓
Container Configuration
      ↓
CPU + Memory + Image + Networking
      ↓
Fargate Task
```

> **Exam Point:**  
> **Task Definition = Container configuration + resource requirements**

---

# Pods

When Fargate is used with **Amazon EKS**, workloads run using Kubernetes concepts such as **Pods**.

```text
EKS
 ↓
Pod
 ↓
Fargate
 ↓
Container
```

---

# Networking

Fargate integrates with **Amazon VPC** to provide networking for container workloads.

```text
Fargate Task
     ↓
Amazon VPC
     ↓
Network Interfaces
     ↓
Other AWS Resources
```

Important considerations include:

- VPC configuration
- Security groups
- Network interfaces
- Secure communication

---

# IAM Roles for Tasks

Fargate workloads can use **IAM roles** to access AWS resources.

```text
Fargate Task
     ↓
IAM Role
     ↓
AWS Permissions
     ↓
AWS Services
```

Use fine-grained permissions and **least privilege**.

---

# Service Discovery

Service discovery allows containerized applications/services to find and communicate with each other.

```text
Service A
    ↓
Service Discovery
    ↓
Service B
```

This is particularly useful in microservices architectures.

---

# Load Balancing

Fargate integrates with **Elastic Load Balancing**.

```text
Users
  ↓
Load Balancer
  ↓
Fargate Tasks
  ↓
Containers
```

This helps distribute application traffic across running containers.

---

# Logging and Monitoring

Fargate integrates with **Amazon CloudWatch** for monitoring and logging.

```text
Fargate
   ↓
CloudWatch
   ↓
Logs / Metrics / Monitoring
```

Useful for:

- Troubleshooting
- Monitoring application behavior
- Operational visibility

---

# Key Features

## 1. Serverless Containers

Run containers without managing underlying servers.

## 2. Resource-Level Isolation

Each container runs in its own isolated environment.

## 3. Granular Resource Specification

Specify required resources for the workload.

## 4. Automatic Scaling

Applications can scale based on demand.

## 5. AWS Service Integration

Fargate integrates with multiple AWS services.

## 6. Cost Optimization

Pay for the resources used by your workloads instead of managing a fleet of servers.

---

# Practical Business Application

## Microservices Architecture

Fargate is well suited for microservices because teams can focus on individual services without managing the underlying infrastructure.

```text
Fargate
│
├── User Service
├── Order Service
├── Payment Service
└── Notification Service
```

Each service can be independently deployed and scaled.

### Why Fargate Works Well for Microservices

- Infrastructure management is reduced.
- Services can be independently deployed.
- Services can scale independently.
- Resource isolation supports service separation.

> **Easy Memory:**  
> **Fargate + Microservices = Independent services without server management**

---

# Fargate Architecture

A typical Fargate architecture can look like:

```text
Users
  ↓
Internet
  ↓
Load Balancer
  ↓
ECS / EKS
  ↓
AWS Fargate
  ↓
Containers
  ↓
AWS Services
```

The container image can be stored in Amazon ECR.

```text
Amazon ECR
    ↓
Container Image
    ↓
ECS / EKS
    ↓
Fargate
    ↓
Running Container
```

---

# Important Fargate Integrations

| AWS Service | Purpose |
|---|---|
| **Amazon ECS** | Container orchestration |
| **Amazon EKS** | Kubernetes orchestration |
| **Amazon ECR** | Store and manage container images |
| **Amazon VPC** | Networking |
| **Elastic Load Balancing** | Traffic distribution |
| **AWS IAM** | Access control |
| **Amazon CloudWatch** | Logging and monitoring |
| **AWS App Mesh** | Service-to-service communication/observability |

---

# Amazon ECR + Fargate

**Amazon ECR** stores container images that can be used by Fargate workloads.

```text
Developer
    ↓
Build Container Image
    ↓
Amazon ECR
    ↓
ECS / EKS
    ↓
Fargate
    ↓
Run Container
```

> **Easy Memory:**  
> **ECR = Store Image**  
> **Fargate = Run Container**

---

# Security Considerations

Important security considerations include:

### VPC

Properly configure VPC networking.

### Security Groups

Control network traffic to and from Fargate workloads.

### IAM

Use fine-grained IAM roles and policies.

### Private Connectivity

Where appropriate, use:

- VPC endpoints
- AWS PrivateLink

to keep traffic within the AWS network.

```text
Fargate
 ↓
VPC
 ↓
Security Groups
 ↓
IAM
 ↓
Private Connectivity
```

---

# Scalability Considerations

Fargate supports scalable container workloads.

```text
Low Demand
    ↓
Fewer Tasks

High Demand
    ↓
More Tasks
```

Scaling can be combined with ECS/EKS orchestration capabilities.

---

# Monitoring Considerations

Use monitoring and logging to understand:

- Application behavior
- Container health
- Resource usage
- Errors
- Operational issues

```text
Fargate
   ↓
CloudWatch
   ↓
Logs + Metrics
   ↓
Monitoring / Troubleshooting
```

---

# ⭐ Quick Revision

```text
AWS Fargate
      ↓
Serverless Container Compute
      ↓
Works with ECS + EKS
      ↓
No Server Management
      ↓
Resource Isolation
      ↓
Scale Containers
```

### Key Terms

> **Fargate** → Serverless compute engine for containers.

> **ECS** → AWS container orchestration service.

> **EKS** → Managed Kubernetes service.

> **ECR** → Container image registry.

> **Task Definition** → Defines ECS container configuration and resources.

> **Pod** → Kubernetes workload unit used with EKS.

> **Resource Isolation** → Containers run in isolated environments.

> **IAM Role for Task** → Provides AWS permissions to workloads.

> **Service Discovery** → Helps services find and communicate with each other.

> **Load Balancing** → Distributes traffic across containers.

> **CloudWatch** → Logging and monitoring.

---

# 🧠 Easy Memory

```text
FARGATE

SERVERLESS → No server management
ISOLATED   → Resource-level isolation
SPECIFY    → CPU / Memory
SCALE      → Automatically
INTEGRATE  → AWS Services
PAY        → Based on resources used
```

### Container Stack

```text
ECR
 ↓
STORE IMAGE

ECS / EKS
 ↓
ORCHESTRATE

FARGATE
 ↓
RUN CONTAINER

VPC
 ↓
NETWORK

IAM
 ↓
ACCESS

CloudWatch
 ↓
MONITOR
```

# 🎯 Exam / FDE Takeaways

> **Need to run containers without managing servers?** → **AWS Fargate**

> **What does Fargate work with?** → **Amazon ECS and Amazon EKS**

> **What is Fargate's core function?** → **Run containers without managing underlying servers**

> **Need a container configuration and resource specification for ECS?** → **Task Definition**

> **What is a key Fargate security feature?** → **Resource-level isolation**

> **Need to store container images?** → **Amazon ECR**

> **Need networking for Fargate workloads?** → **Amazon VPC**

> **Need AWS permissions for a Fargate task?** → **IAM role**

> **Need traffic distribution?** → **Elastic Load Balancing**

> **Need monitoring and logging?** → **Amazon CloudWatch**

> **Need serverless compute for microservices?** → **AWS Fargate**

> **Need Kubernetes workloads without managing worker nodes?** → **EKS + Fargate**

## ⭐ One-Line Summary

> **AWS Fargate is a serverless container compute engine for ECS and EKS that runs containers in isolated environments without requiring customers to provision or manage the underlying servers.**