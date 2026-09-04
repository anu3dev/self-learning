````markdown
# AWS Networking Basics — Solutions Architect Associate

> **Course:** AWS Partner Certification Readiness – Solutions Architect – Associate  
> **Topic:** AWS Networking Basics  
> **Focus:** AWS networking foundations, protocols, global infrastructure, network security, and private connectivity.

---

# 1. AWS Networking Overview

AWS networking can be understood through **five major areas**:

```text
AWS Networking
│
├── Network Foundations
├── Edge Networking
├── Hybrid Connectivity
├── Application Networking
└── Network Security
```

### 1. Network Foundations

The basic building blocks used to create AWS networks.

Examples:

- Amazon VPC
- Subnets
- Route tables
- Internet Gateway
- Network interfaces
- IP addressing

---

### 2. Edge Networking

Used to improve how users access applications from different geographic locations.

Examples include services that provide:

- Content delivery
- Global traffic acceleration
- Edge-based application delivery

---

### 3. Hybrid Connectivity

Connects AWS environments with:

- On-premises data centers
- Corporate networks
- Other networks

Important services:

- AWS Direct Connect
- AWS Site-to-Site VPN

---

### 4. Application Networking

Provides networking capabilities for applications and services.

Examples:

- AWS App Mesh
- AWS Cloud Map
- Amazon API Gateway

---

### 5. Network Security

Controls and protects network traffic.

Important mechanisms:

- Security Groups
- Network ACLs
- Network routing controls

> **Easy Memory:**
>
> **Foundations → Edge → Hybrid → Application → Security**

---

# 2. Network Design

A good network design should clearly document how the network is structured.

A network design can help troubleshoot problems by:

### 1. Visualizing the Entire Network

Shows components such as:

```text
VPC
 ↓
Subnets
 ↓
EC2
 ↓
Load Balancer
 ↓
Internet / Other Networks
```

### 2. Tracing Network Traffic

Helps understand:

```text
Source
  ↓
Route
  ↓
Network Component
  ↓
Destination
```

### 3. Identifying Security Holes

A network diagram can help identify:

- Unnecessary public access
- Incorrect routes
- Missing security controls
- Unexpected network paths

> **Exam Answer:**  
> A good network design helps by:
>
> - ✅ Visualizing the entire network
> - ✅ Tracing network traffic routes
> - ✅ Identifying security holes

---

# 3. Network Protocols

Network protocols define how devices communicate and how network operations are performed.

The three main categories covered here are:

```text
Network Protocols
│
├── Communication Protocols
├── Security Protocols
└── Management Protocols
```

## Network Communication Protocols

Used for communication between systems.

Examples:

- TCP
- UDP
- IP

---

## Network Security Protocols

Used to secure communication.

Example:

- TLS

---

## Network Management Protocols

Used to manage and monitor network devices and services.

> **Exam Answer:**
>
> - ✅ Network management protocols
> - ✅ Network communication protocols
> - ✅ Network security protocols

---

# 4. Internet Protocols

Two important versions of the Internet Protocol are:

```text
IPv4
IPv6
```

## IPv4

Uses 32-bit addresses.

Example:

```text
192.168.1.10
```

## IPv6

Uses 128-bit addresses.

Example:

```text
2001:db8::1
```

Amazon EC2 and Amazon VPC support both **IPv4 and IPv6**.

> **Exam Answer:**
>
> - ✅ IPv4
> - ✅ IPv6

---

# 5. TCP and UDP

TCP and UDP are **transport-layer protocols**.

## TCP

**Transmission Control Protocol**

Provides reliable, connection-oriented communication.

```text
Client
  ↓
TCP Connection
  ↓
Server
```

Used when reliable delivery is important.

---

## UDP

**User Datagram Protocol**

Provides connectionless communication with lower overhead.

Useful when speed and low latency are more important than guaranteed delivery.

---

### Easy Memory

```text
IP  → Addressing
TCP → Reliable communication
UDP → Fast / connectionless communication
```

---

# 6. Networking Models

Two important networking models are:

```text
OSI Model
TCP/IP Model
```

These models help understand how network communication works.

---

# 7. OSI Model

The **Open Systems Interconnection (OSI)** model has **7 layers**.

```text
7 → Application
6 → Presentation
5 → Session
4 → Transport
3 → Network
2 → Data Link
1 → Physical
```

### Easy Memory

> **All People Seem To Need Data Processing**

```text
Application
Presentation
Session
Transport
Network
Data Link
Physical
```

---

# 8. TCP/IP Model

The TCP/IP model is another important model for understanding network communication.

A simplified representation:

```text
Application
    ↓
Transport
    ↓
Internet
    ↓
Network Access
```

### Important Protocol Associations

```text
Application → HTTP, HTTPS, SSH
Transport   → TCP, UDP
Internet    → IP
```

> **Exam Shortcut:**
>
> **OSI + TCP/IP → Two important networking models**

---

# 9. AWS Global Infrastructure

AWS infrastructure is distributed globally.

Important components include:

```text
AWS Global Infrastructure
│
├── Regions
├── Availability Zones
├── Data Centers
└── Local Zones
```

---

# 10. AWS Region

A **Region** is a geographic area containing AWS infrastructure.

Example:

```text
AWS Region
│
├── Availability Zone A
├── Availability Zone B
└── Availability Zone C
```

Different AWS Regions are geographically separated.

---

# 11. Availability Zone

An **Availability Zone (AZ)** is an isolated infrastructure location within an AWS Region.

A Region contains multiple AZs.

```text
Region
│
├── AZ-A
├── AZ-B
└── AZ-C
```

Multiple AZs help provide:

- High availability
- Fault isolation
- Resilience

---

# 12. Data Center

A **Data Center** is a physical facility containing AWS infrastructure.

It contains infrastructure such as:

- Servers
- Storage
- Networking
- Power
- Cooling

Conceptually:

```text
Region
   ↓
Availability Zones
   ↓
Data Centers
   ↓
AWS Infrastructure
```

---

# 13. Local Zones

**AWS Local Zones** place selected AWS infrastructure closer to end users in specific metropolitan areas.

They can help applications that require:

- Lower latency
- Processing closer to users
- Localized application deployment

---

### Global Infrastructure — Exam Answer

**Question:** What infrastructure makes up AWS global infrastructure?

Correct choices from the question:

- ✅ AWS Regions
- ✅ Availability Zones
- ✅ Data centers

> **Remember:**  
> **Region → AZ → Data Center**

---

# 14. Amazon VPC

**Amazon Virtual Private Cloud (VPC)** provides a logically isolated network in AWS.

A VPC allows you to control:

- IP addressing
- Subnets
- Routing
- Network connectivity
- Network security

Basic structure:

```text
AWS Region
    ↓
VPC
    ↓
Subnets
    ↓
AWS Resources
```

---

# 15. Subnets

A **subnet** is a range of IP addresses within a VPC.

Subnets are associated with an Availability Zone.

```text
VPC
│
├── Subnet A → AZ-A
├── Subnet B → AZ-B
└── Subnet C → AZ-C
```

A subnet can generally be categorized as:

- Public subnet
- Private subnet

depending on its routing configuration.

---

# 16. Route Tables

A route table determines where network traffic should go.

Example:

```text
Destination
     ↓
Route Table
     ↓
Target
```

Example:

```text
0.0.0.0/0
    ↓
Internet Gateway
```

> **Easy Memory:**  
> **Route Table = Traffic direction**

---

# 17. Internet Gateway

An **Internet Gateway (IGW)** provides a path between a VPC and the internet.

Basic flow:

```text
VPC
 ↓
Internet Gateway
 ↓
Internet
```

To facilitate internet connectivity for a VPC:

1. Create an Internet Gateway.
2. Attach it to the VPC.
3. Add a route to the Internet Gateway in the appropriate route table.

> **Exam Shortcut:**
>
> **VPC Internet Access → Internet Gateway + Route**

---

# 18. Network Security

AWS provides multiple mechanisms to restrict network traffic.

Two important ones are:

```text
Security Groups
Network ACLs
```

---

# 19. Security Groups

A **Security Group** controls inbound and outbound traffic associated with supported AWS resources such as EC2 instances.

Think of it as a **virtual firewall at the resource level**.

```text
Internet
   ↓
Security Group
   ↓
EC2
```

Security Groups use rules to allow traffic.

---

# 20. Network ACLs

A **Network Access Control List (Network ACL)** controls traffic at the **subnet level**.

```text
VPC
 ↓
Subnet
 ↓
Network ACL
 ↓
Resources
```

Network ACLs provide another layer of network traffic control.

---

# 21. Security Group vs Network ACL

| Feature | Security Group | Network ACL |
|---|---|---|
| Level | Resource/instance | Subnet |
| Purpose | Control resource traffic | Control subnet traffic |
| Scope | Associated with resources | Associated with subnet |
| Role | Virtual firewall | Subnet-level network filter |

### Easy Memory

```text
Security Group → Resource
NACL           → Subnet
```

> **Exam Answer:**  
> Services/mechanisms that can restrict AWS network traffic:
>
> - ✅ Security Groups
> - ✅ Network ACLs

---

# 22. Private Connectivity

AWS provides several ways to connect networks without sending traffic through the public internet.

Important services include:

```text
Private Connectivity
│
├── VPC Peering
├── AWS PrivateLink
├── AWS Transit Gateway
├── AWS Site-to-Site VPN
└── AWS Direct Connect
```

---

# 23. VPC Peering

**VPC Peering** creates a private network connection between two VPCs.

```text
VPC-A
  │
  │ VPC Peering
  │
VPC-B
```

Traffic between the VPCs does not need to traverse the public internet.

Useful for direct VPC-to-VPC communication.

---

# 24. AWS PrivateLink

**AWS PrivateLink** provides private connectivity to services without requiring traffic to traverse the public internet.

It is especially useful for privately accessing services across VPC boundaries.

Conceptually:

```text
VPC
 ↓
PrivateLink
 ↓
AWS / Endpoint Service
```

> **Easy Memory:**  
> **PrivateLink → Private access to services**

---

# 25. AWS Transit Gateway

**AWS Transit Gateway** acts as a central network hub.

Instead of creating many individual connections:

```text
VPC-A ───── VPC-B
VPC-A ───── VPC-C
VPC-B ───── VPC-C
```

you can use a central hub:

```text
          VPC-A
            │
            ↓
      Transit Gateway
        ↙       ↘
     VPC-B      VPC-C
```

This simplifies connectivity between many VPCs and networks.

> **Easy Memory:**  
> **Transit Gateway = Central network hub**

---

# 26. AWS Site-to-Site VPN

AWS Site-to-Site VPN creates an encrypted connection between an AWS VPC and an external network, commonly an on-premises network.

```text
On-Premises
     │
     │ Encrypted VPN
     │
     ↓
AWS VPC
```

It uses the internet as the underlying transport but creates an **encrypted VPN tunnel**.

> **Easy Memory:**  
> **Site-to-Site VPN → Encrypted connection to on-premises**

---

# 27. AWS Direct Connect

**AWS Direct Connect** provides a dedicated network connection between an on-premises network and AWS.

```text
On-Premises
     │
     │ Dedicated Connection
     │
     ↓
AWS
```

It does not use the public internet for the dedicated connection.

Common reasons to use Direct Connect:

- Consistent network performance
- Private connectivity
- Hybrid cloud architectures
- Large amounts of data transfer

> **Easy Memory:**  
> **Direct Connect → Dedicated private connection**

---

# 28. Private Connectivity Comparison

| Service | Main Purpose |
|---|---|
| **VPC Peering** | Direct VPC-to-VPC connectivity |
| **PrivateLink** | Private access to services |
| **Transit Gateway** | Central hub connecting VPCs/networks |
| **Site-to-Site VPN** | Encrypted connection, commonly AWS ↔ on-premises |
| **Direct Connect** | Dedicated private network connection to AWS |

---

# 29. Knowledge Check Answers

## Question 1

### What are the networking options available in AWS?

**Answer:**

> ✅ **F. All of the above**

AWS networking includes:

```text
Network Foundations
Edge Networking
Hybrid Connectivity
Application Networking
Network Security
```

---

## Question 2

### Which services are network foundation services?

**Choose 2**

**Answer:**

> ✅ **A. Amazon VPC**  
> ✅ **B. AWS Cloud Map**

---

## Question 3

### Which service is a hybrid connectivity service?

**Answer:**

> ✅ **D. AWS Direct Connect**

---

## Question 4

### How does a good network design document help troubleshoot network problems?

**Choose 3**

**Answer:**

> ✅ **A. It visualizes the entire network.**  
> ✅ **B. It traces network traffic routes.**  
> ✅ **C. It identifies security holes.**

---

## Question 5

### What are the main types of network protocols?

**Choose 3**

**Answer:**

> ✅ **A. Network management protocols**  
> ✅ **C. Network communication protocols**  
> ✅ **D. Network security protocols**

---

## Question 6

### Which internet protocols are supported by EC2 and VPC?

**Choose 2**

**Answer:**

> ✅ **B. IPv4**  
> ✅ **C. IPv6**

---

## Question 7

### Which two networking models are important?

**Choose 2**

**Answer:**

> ✅ **B. OSI Model**  
> ✅ **D. TCP/IP Model**

---

## Question 8

### What infrastructure makes up AWS global infrastructure?

**Choose 3**

**Answer:**

> ✅ **A. AWS Regions**  
> ✅ **C. Availability Zones**  
> ✅ **D. Data Centers**

---

## Question 9

### Which services can restrict or secure an AWS network?

**Choose 2**

**Answer:**

> ✅ **A. Security Groups**  
> ✅ **C. Network ACLs**

---

## Question 10

### Which services provide private VPC-to-VPC connectivity?

**Question asks for 2**

The important concepts to remember are:

> **VPC Peering** → direct private VPC-to-VPC connection  
> **AWS Transit Gateway** → central private connectivity hub

Therefore:

> ✅ **C. VPC Peering**  
> ✅ **E. AWS Transit Gateway**

**Note:** AWS PrivateLink is also a private connectivity service, but it is primarily designed for **private service access**, rather than general VPC-to-VPC networking.

---

# ⭐ Quick Revision

```text
NETWORKING
────────────────────────────────────

AWS Networking
├── Network Foundations
├── Edge Networking
├── Hybrid Connectivity
├── Application Networking
└── Network Security


FOUNDATION
────────────────────────────────────

VPC          → AWS private network
Subnet       → IP range inside VPC
Route Table  → Determines traffic path
IGW          → Internet connectivity


GLOBAL INFRASTRUCTURE
────────────────────────────────────

Region
  ↓
Availability Zone
  ↓
Data Center


PROTOCOLS
────────────────────────────────────

IPv4 / IPv6 → Internet Protocol
TCP / UDP   → Transport
OSI         → 7-layer networking model
TCP/IP      → Networking model


SECURITY
────────────────────────────────────

Security Group → Resource-level
NACL           → Subnet-level


PRIVATE CONNECTIVITY
────────────────────────────────────

VPC Peering    → VPC ↔ VPC
PrivateLink    → Private service access
Transit GW     → Central network hub
Site-to-Site VPN → Encrypted network connection
Direct Connect → Dedicated private connection


INTERNET ACCESS
────────────────────────────────────

VPC
 ↓
Internet Gateway
 ↓
Route Table
 ↓
Internet
```

# 🧠 Easy Memory

```text
VPC          → YOUR AWS NETWORK
Subnet       → PART OF NETWORK
Route Table  → WHERE TRAFFIC GOES
IGW          → INTERNET EXIT

SG           → RESOURCE FIREWALL
NACL         → SUBNET FIREWALL

Peering      → VPC ↔ VPC
PrivateLink  → PRIVATE SERVICE
Transit GW   → NETWORK HUB
VPN          → ENCRYPTED CONNECTION
DirectConnect→ DEDICATED CONNECTION

IPv4/IPv6    → IP
TCP/UDP      → TRANSPORT
OSI/TCP-IP   → NETWORKING MODELS

Region → AZ → Data Center
```

# 🎯 FDE / Exam Takeaway

When designing an AWS network, think in this order:

```text
1. Where is my infrastructure?
        ↓
   Region / AZ

2. What is my network?
        ↓
   VPC / Subnets

3. Where should traffic go?
        ↓
   Route Tables

4. Does it need internet access?
        ↓
   Internet Gateway

5. How do I secure it?
        ↓
   Security Groups / NACLs

6. How do I connect other networks?
        ↓
   Peering / Transit Gateway / VPN / Direct Connect

7. How does the application communicate?
        ↓
   TCP / UDP / HTTP / HTTPS
```

> **Core FDE mindset:**  
> **Design the network → define routes → secure traffic → establish connectivity → monitor and troubleshoot.**
````
