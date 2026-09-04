# Amazon GuardDuty — Getting Started

## What is Amazon GuardDuty?

**Amazon GuardDuty** is a threat detection service that continuously monitors AWS accounts, workloads, and data for **malicious or potentially unauthorized activity**.

GuardDuty uses:

- Machine Learning (ML)
- Anomaly detection
- Threat intelligence
- AWS data sources and logs

```text
AWS Environment
      ↓
GuardDuty
      ↓
Continuous Monitoring
      ↓
Threat Analysis
      ↓
Security Findings
```

> **Easy Memory:**  
> **GuardDuty = Continuous AWS Threat Detection**

---

# How GuardDuty Detects Threats

GuardDuty continuously analyzes AWS data sources and logs.

It combines:

```text
AWS Data Sources
      +
Threat Intelligence
      +
Machine Learning
      +
Anomaly Detection
      ↓
Threat Detection
      ↓
Findings
```

### Threat Intelligence

GuardDuty can use intelligence such as:

- Malicious IP addresses
- Malicious domains
- File hashes

This helps identify known malicious activity.

---

# GuardDuty Core Functionality

GuardDuty provides three major areas of protection:

```text
GuardDuty
│
├── Foundational Threat Detection
├── Extended Threat Detection
└── Protection Plans
```

---

# GuardDuty Technical Concepts

Important GuardDuty concepts include:

| Concept | Purpose |
|---|---|
| **GuardDuty Detector** | Core GuardDuty component for detecting threats |
| **Data Sources** | AWS data analyzed by GuardDuty |
| **Threat Intelligence** | Known malicious IPs, domains, hashes, etc. |
| **Machine Learning Models** | Detect suspicious/anomalous behavior |
| **Findings** | Security issues detected by GuardDuty |
| **Multi-Account Management** | Manage GuardDuty across multiple AWS accounts |

---

# GuardDuty Findings

When GuardDuty detects suspicious activity, it generates a **finding**.

```text
Suspicious Activity
       ↓
GuardDuty Analysis
       ↓
Finding
       ↓
Security Investigation / Response
```

A finding provides information that helps security teams understand and investigate the detected threat.

> **Easy Memory:**  
> **GuardDuty detects → Finding reports**

---

# Key Features

## 1. Regional Deployment

GuardDuty operates on a **Regional basis**.

Consider GuardDuty deployment across the AWS Regions where your workloads operate.

---

## 2. Continuous Monitoring

GuardDuty continuously monitors and analyzes supported AWS data sources.

```text
AWS Environment
      ↓
Continuous Monitoring
      ↓
Threat Detection
```

---

## 3. Comprehensive Protection Plans

GuardDuty provides multiple protection capabilities to help detect different types of threats.

---

## 4. Automated Response

GuardDuty findings can be integrated with other AWS services to support automated security response workflows.

Example:

```text
GuardDuty Finding
       ↓
EventBridge
       ↓
Automated Workflow
       ↓
Response
```

---

# Practical Business Applications

## 1. Credential Protection

GuardDuty can detect suspicious use of AWS credentials.

Example:

```text
EC2 Instance
    ↓
Credentials
    ↓
Used from unusual location/account
    ↓
GuardDuty
    ↓
Suspicious Finding
```

It can detect:

- Unusual API calls
- Unusual access patterns
- Credentials used from unexpected locations
- Credentials used at unusual times

### Example

If credentials created for an EC2 instance are unexpectedly used from another account, GuardDuty can flag the activity as suspicious.

> **Easy Memory:**  
> **Unusual credential usage → GuardDuty detects it**

---

# 2. Ransomware Detection

GuardDuty can help identify potential ransomware activity by monitoring for suspicious behavior such as:

- Data exfiltration patterns
- Unusual file access
- Suspicious encryption activity
- Unusual network connections
- Known ransomware signatures

```text
Unusual Activity
      ↓
GuardDuty Monitoring
      ↓
Threat Detection
      ↓
Finding
```

The goal is to provide **early detection** before significant damage occurs.

---

# 3. Cryptomining Detection

Attackers may compromise resources and use them for unauthorized cryptocurrency mining.

GuardDuty can identify suspicious cryptomining activity through:

- Unusual CPU utilization patterns
- Suspicious network behavior
- Connections to known cryptomining pools
- Communication with known cryptomining domains/IP addresses

```text
Compromised Resource
       ↓
High / Unusual CPU
       +
Mining Network Activity
       ↓
GuardDuty
       ↓
Finding
```

> **Easy Memory:**  
> **Cryptomining → Unusual CPU + Suspicious Mining Network Activity**

---

# GuardDuty Integrations

GuardDuty can integrate with other AWS security and automation services.

| Service | Purpose |
|---|---|
| **AWS Security Hub CSPM** | Centralized security findings and posture management |
| **Amazon Detective** | Investigate and analyze security findings |
| **Amazon EventBridge** | Automate responses to GuardDuty findings |
| **AWS Organizations** | Multi-account management |

---

# GuardDuty + Security Services

A useful security workflow:

```text
GuardDuty
   ↓
Detect Threat
   ↓
Finding
   ↓
Security Hub
   ↓
Centralized Security View
   ↓
Detective
   ↓
Investigation
```

For automated response:

```text
GuardDuty
   ↓
Finding
   ↓
EventBridge
   ↓
Automated Response
```

---

# GuardDuty vs Other AWS Security Services

| Service | Main Purpose |
|---|---|
| **GuardDuty** | Threat detection |
| **Security Hub CSPM** | Centralized security posture/findings |
| **Amazon Detective** | Security investigation |
| **CloudTrail** | API activity/audit logging |
| **AWS Config** | Resource configuration/compliance |
| **EventBridge** | Event-driven automation |

### Easy Memory

```text
GuardDuty   → DETECT
Security Hub→ CENTRALIZE
Detective   → INVESTIGATE
CloudTrail  → RECORD
Config      → CONFIGURATION
EventBridge → AUTOMATE
```

---

# ⭐ Quick Revision

```text
Amazon GuardDuty
       ↓
Continuous Threat Detection
       ↓
AWS Data + Threat Intelligence + ML
       ↓
Suspicious Activity
       ↓
Finding
       ↓
Investigation / Response
```

### Key Terms

> **GuardDuty** → AWS threat detection service

> **Detector** → Core GuardDuty detection component

> **Threat Intelligence** → Malicious IPs, domains, hashes

> **ML / Anomaly Detection** → Identify suspicious behavior

> **Finding** → Detected security issue

> **Regional** → GuardDuty operates by AWS Region

> **Credential Protection** → Detect unusual credential/API activity

> **Ransomware Detection** → Detect suspicious encryption, access, and network behavior

> **Cryptomining Detection** → Detect unusual CPU/network mining activity

---

# 🧠 Easy Memory

```text
GUARDDUTY = DETECT THREATS

ML + Anomaly Detection
        +
Threat Intelligence
        +
AWS Data Sources
        ↓
GuardDuty
        ↓
Findings
```

### Integration Memory

```text
GuardDuty
    ↓
Security Hub → Centralize
Detective    → Investigate
EventBridge  → Automate
Organizations→ Multi-Account
```

# 🎯 Exam / FDE Takeaways

> **Need continuous threat detection in AWS?** → **Amazon GuardDuty**

> **Need to detect unusual credential/API activity?** → **GuardDuty**

> **Need to detect cryptomining activity?** → **GuardDuty**

> **Need to detect suspicious ransomware-related activity?** → **GuardDuty**

> **Need centralized security findings?** → **Security Hub**

> **Need to investigate a security finding?** → **Amazon Detective**

> **Need automated response to GuardDuty findings?** → **EventBridge**

> **Need multi-account GuardDuty management?** → **AWS Organizations**

### One-Line Summary

> **Amazon GuardDuty continuously analyzes AWS activity using threat intelligence, machine learning, and anomaly detection to identify potential threats and generate security findings.**