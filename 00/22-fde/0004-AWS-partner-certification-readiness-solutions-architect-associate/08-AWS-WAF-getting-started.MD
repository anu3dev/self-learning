# AWS WAF — Getting Started

## What is AWS WAF?

**AWS WAF (Web Application Firewall)** protects web applications and APIs from common web-based attacks.

It acts as a **protective layer between the internet and your web application** by inspecting incoming HTTP and HTTPS requests.

```text
Internet
   ↓
AWS WAF
   ↓
Inspect HTTP/HTTPS Request
   ↓
Web ACL + Rules
   ↓
Allow / Block / Count
   ↓
Web Application / API
```

> **Easy Memory:**  
> **AWS WAF = Inspect + Filter + Protect Web Traffic**

---

# How AWS WAF Works

AWS WAF inspects requests forwarded to protected resources.

Each request is evaluated against a **Web ACL (Web Access Control List)**.

Based on the configured rules, AWS WAF can:

```text
HTTP / HTTPS Request
        ↓
     Web ACL
        ↓
   Evaluate Rules
     ↙   ↓   ↘
 Allow  Block  Count
```

### Allow

The protected resource responds to the request.

### Block

AWS WAF can return:

```text
HTTP 403 Forbidden
```

or a configured custom response.

### Count

The request is counted for monitoring without necessarily blocking it.

---

# Attacks AWS WAF Can Help Protect Against

AWS WAF can help identify and block common web-based attacks such as:

- **SQL Injection**
- **Cross-Site Scripting (XSS)**
- **Brute-force login attempts**
- **Malicious bots**
- **DDoS-related events**
- Vulnerabilities associated with the **OWASP Top 10**

> **Easy Memory:**  
> **WAF → Web attacks**

---

# AWS WAF as a Gatekeeper

Think of AWS WAF as a **gatekeeper**.

```text
          Internet
             ↓
       Incoming Request
             ↓
        ┌───────────┐
        │ AWS WAF   │
        │ Gatekeeper│
        └───────────┘
          ↓       ↓
       Malicious  Valid
          ↓       ↓
        BLOCK    ALLOW
                  ↓
            Application
```

The goal is to detect malicious traffic **as early and as close to the entry point as possible**.

---

# Web ACL

A **Web ACL** is the main configuration used by AWS WAF to inspect and control web requests.

It contains rules that determine how requests should be handled.

```text
Web ACL
│
├── Rule 1 → IP filtering
├── Rule 2 → SQL injection
├── Rule 3 → XSS
├── Rule 4 → Bot control
└── Rule 5 → Geo restriction
```

> **Easy Memory:**  
> **Web ACL = Container of WAF rules**

---

# WAF Rules

Rules define the conditions that AWS WAF evaluates.

Rules can inspect conditions such as:

- Source IP address
- Query string values
- Request characteristics
- Known attack patterns
- Other web request properties

The action can include:

```text
ALLOW
BLOCK
COUNT
```

---

# Rule Groups

A **rule group** is a reusable collection of WAF rules.

```text
Rule Group
├── Rule 1
├── Rule 2
├── Rule 3
└── Rule 4
```

Useful when multiple related rules need to be managed together.

---

# IP Sets

**IP sets** contain collections of IP addresses that can be referenced by WAF rules.

Example:

```text
IP Set
├── 10.10.10.10
├── 10.10.10.11
└── 10.10.10.12
```

They can be used to:

- Allow specific IP addresses
- Block known malicious IP addresses
- Create IP-based filtering rules

> **Easy Memory:**  
> **IP Set = List of IP addresses used by WAF rules**

---

# Regular Expressions (Regex)

**Regular expressions (regex)** can be used to match specific patterns in web requests.

They can help identify patterns in:

- Query strings
- Request content
- Other request components

```text
Request
   ↓
Regex Pattern
   ↓
Match?
   ↓
WAF Rule Action
```

---

# AWS WAF Architecture Integrations

AWS WAF integrates with other AWS services to provide defense-in-depth security.

Important integrations include:

```text
AWS WAF
│
├── Amazon CloudFront
├── Application Load Balancer
├── Amazon API Gateway
├── AWS Shield
├── Amazon CloudWatch
└── AWS Firewall Manager
```

---

# Amazon CloudFront + AWS WAF

CloudFront can work with AWS WAF to inspect and filter web traffic at the edge.

```text
User
 ↓
CloudFront Edge
 ↓
AWS WAF
 ↓
Application
```

This helps detect malicious traffic close to where it enters the AWS environment.

> **Easy Memory:**  
> **CloudFront + WAF = Edge delivery + Web protection**

---

# Application Load Balancer + AWS WAF

AWS WAF can protect applications behind an **Application Load Balancer (ALB)**.

```text
Internet
   ↓
ALB
   ↓
AWS WAF
   ↓
Application
```

WAF evaluates incoming web requests before they reach the application.

---

# Amazon API Gateway + AWS WAF

AWS WAF can protect APIs by inspecting incoming HTTP/HTTPS API requests.

```text
Client
  ↓
AWS WAF
  ↓
API Gateway
  ↓
Backend
```

> **Use Case:** API protection

---

# AWS Shield + AWS WAF

AWS Shield provides protection against **DDoS attacks**, while AWS WAF provides configurable filtering for web requests.

```text
Internet
   ↓
AWS Shield
   ↓
AWS WAF
   ↓
Application
```

Together they provide multiple layers of protection.

---

# Amazon CloudWatch + AWS WAF

CloudWatch can be used for monitoring AWS WAF activity through metrics and related monitoring capabilities.

```text
AWS WAF
   ↓
Metrics / Logs
   ↓
CloudWatch
   ↓
Monitoring / Alerts
```

---

# AWS Firewall Manager + AWS WAF

**AWS Firewall Manager** helps centrally manage firewall rules and policies across AWS accounts and resources.

Useful in **multi-account environments**.

```text
AWS Firewall Manager
        ↓
Central WAF Policies
        ↓
Multiple AWS Accounts
```

> **Easy Memory:**  
> **Firewall Manager = Centralized security policy management**

---

# Benefits of AWS WAF

## Enhanced Security

Protects applications from common web attacks.

## Customizable Rules

Allows organizations to define rules based on their requirements.

## Real-Time Monitoring

Helps monitor incoming web traffic and security activity.

## Improved Performance

Blocking malicious traffic early can prevent unnecessary traffic from reaching applications.

## Compliance Support

Consistent security controls can help support regulatory and compliance requirements.

## Scalable Defense

AWS WAF scales with the protected AWS resources.

## Centralized Management

Works with services such as AWS Firewall Manager for centralized management.

## API-Based Management

AWS WAF can be managed programmatically through APIs and automation.

---

# Typical AWS WAF Use Cases

## 1. Blocking Malicious Traffic

```text
Malicious Request
       ↓
AWS WAF
       ↓
BLOCK
```

---

## 2. Bot Control

AWS WAF can help identify and control unwanted or malicious bot traffic.

---

## 3. API Protection

Protect APIs from common web attacks and unwanted requests.

```text
Client
  ↓
WAF
  ↓
API
```

---

## 4. DDoS Mitigation

AWS WAF can be part of a broader DDoS protection architecture together with **AWS Shield**.

---

## 5. Compliance

Organizations can implement consistent web security controls to support compliance requirements.

---

## 6. Geo-Blocking

WAF rules can restrict traffic based on geographic origin.

```text
Request
   ↓
Geographic Check
   ↓
Allowed Country? 
   ├── Yes → ALLOW
   └── No  → BLOCK
```

---

# Security and Operational Considerations

## Security

Follow security best practices when configuring and managing WAF.

Important considerations:

- Use least privilege.
- Restrict who can modify WAF configuration.
- Regularly update rules.
- Keep protections aligned with emerging threats.
- Protect sensitive configuration data.

---

## Monitoring and Logging

Monitoring and logging are important for:

- Detecting attacks
- Troubleshooting
- Understanding blocked requests
- Security investigations
- Forensic analysis

```text
AWS WAF
   ↓
Logs / Metrics
   ↓
Monitoring
   ↓
Alerts / Investigation
```

---

## Operational Management

Establish processes for:

- Rule management
- Rule updates
- Configuration changes
- Version control
- Change management
- Auditing

Automation can reduce manual errors.

Infrastructure as Code (IaC) can be used to automate WAF configuration.

---

# Automation

AWS WAF can be integrated with automation services.

For example:

```text
Security Event
      ↓
Detection
      ↓
Lambda / Automation
      ↓
Update WAF Rules
```

Lambda functions can help automate WAF rule updates.

AWS WAF can also be integrated with **Amazon GuardDuty** to support broader threat detection and response workflows.

---

# WAF vs GuardDuty

These services have different primary purposes.

| Service | Main Purpose |
|---|---|
| **AWS WAF** | Filter and protect web/application traffic |
| **Amazon GuardDuty** | Detect threats and suspicious activity |

### Easy Memory

```text
WAF       → FILTER WEB TRAFFIC
GuardDuty → DETECT THREATS
```

---

# WAF vs Shield

| Service | Main Purpose |
|---|---|
| **AWS WAF** | Web request filtering and application-layer protection |
| **AWS Shield** | DDoS protection |

They can be used together for defense in depth.

---

# ⭐ Quick Revision

```text
AWS WAF
   ↓
Web Application Firewall
   ↓
Inspect HTTP/HTTPS
   ↓
Web ACL
   ↓
Rules
   ↓
ALLOW / BLOCK / COUNT
```

### Important Concepts

> **AWS WAF** → Protects web applications and APIs.

> **Web ACL** → Contains WAF rules.

> **Rules** → Define request inspection conditions and actions.

> **Rule Groups** → Collections of related rules.

> **IP Sets** → Lists of IP addresses used by rules.

> **Regex** → Matches request patterns.

> **Allow** → Let request reach the protected resource.

> **Block** → Reject request, commonly with HTTP 403.

> **Count** → Count matching requests without necessarily blocking them.

---

# 🧠 Easy Memory

```text
WAF = WEB TRAFFIC GATEKEEPER

Web ACL  → RULE CONTAINER
Rule     → WHAT TO CHECK
IP Set   → WHICH IPs
Regex    → WHICH PATTERN
Action   → ALLOW / BLOCK / COUNT
```

### Attack Memory

```text
SQL Injection
XSS
Brute Force
Malicious Bots
DDoS Events
OWASP Top 10
       ↓
     AWS WAF
```

### Integration Memory

```text
CloudFront      → Edge
ALB             → Application Load Balancer
API Gateway     → APIs
Shield          → DDoS Protection
CloudWatch      → Monitoring
Firewall Manager→ Central Management
```

# 🎯 Exam / FDE Takeaways

> **Need to protect a web application from SQL injection/XSS?** → **AWS WAF**

> **Need to inspect HTTP/HTTPS requests?** → **AWS WAF**

> **Need to define WAF rules?** → **Web ACL**

> **Need to filter specific IP addresses?** → **IP Set**

> **Need to match request patterns?** → **Regex**

> **Need to block a malicious request?** → **WAF Rule → Block**

> **Need to monitor without blocking initially?** → **Count**

> **Need edge-based web protection?** → **CloudFront + WAF**

> **Need API protection?** → **API Gateway + WAF**

> **Need DDoS protection?** → **AWS Shield + WAF**

> **Need centralized WAF management across accounts?** → **AWS Firewall Manager**

> **Need threat detection rather than web-request filtering?** → **Amazon GuardDuty**

## ⭐ One-Line Summary

> **AWS WAF is a scalable web application firewall that inspects HTTP/HTTPS requests and uses Web ACLs and rules to allow, block, or count traffic, protecting applications and APIs from common web attacks.**