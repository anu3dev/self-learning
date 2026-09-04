# AWS Secrets Manager — Introduction

## What is AWS Secrets Manager?

**AWS Secrets Manager** is a secure and scalable service used to **store, manage, retrieve, and rotate sensitive information**, called **secrets**.

Examples of secrets:

- Database credentials
- API keys
- OAuth tokens
- Passwords
- Access keys
- Application secrets

Think of Secrets Manager as a **secure digital vault** for sensitive information.

```text
Application
     ↓
Secrets Manager
     ↓
Retrieve Secret Securely
     ↓
Use Secret
```

> **Easy Memory:**  
> **Secrets Manager = Securely Store + Retrieve + Rotate Secrets**

---

# Problems Secrets Manager Solves

Without Secrets Manager, developers might store credentials directly in:

```text
Application Code
Environment Files
Plaintext Configuration Files
```

This creates security risks if the code or files are exposed.

### Better Approach

```text
Application
     ↓
Secrets Manager API
     ↓
Secret
```

The actual secret is **not hardcoded in application code**.

---

# Key Benefits

- **Secure secret storage**
- **Centralized secret management**
- **Fine-grained access control**
- **Automatic secret rotation**
- **Encryption**
- **Audit and monitoring**
- **Scalable secret storage and retrieval**
- **Integration with AWS services**

---

# Secret

A **secret** is sensitive information stored in Secrets Manager.

Examples:

```text
Database Username
Database Password
API Key
OAuth Token
Application Credential
```

Applications retrieve secrets programmatically instead of storing them in source code.

---

# Secret Retrieval

Instead of:

```text
Application Code
      ↓
Hardcoded Password
```

Use:

```text
Application
      ↓
Secrets Manager API
      ↓
Retrieve Secret
      ↓
Application
```

This reduces the risk of credentials being exposed through source code.

---

# Secret Rotation

**Rotation** means regularly replacing an existing secret with a new secret.

```text
Old Secret
    ↓
Rotation
    ↓
New Secret
```

Secrets Manager can automatically rotate secrets according to a configured schedule.

### Why Rotate?

Long-lived credentials increase the potential impact if they are compromised.

```text
Long-Term Secret
      ↓
Higher Risk

Regularly Rotated Secret
      ↓
Reduced Risk
```

> **Easy Memory:**  
> **Rotation = Replace old secret with a new one**

---

# Secret Lifecycle

```text
Create
  ↓
Store
  ↓
Retrieve
  ↓
Rotate
  ↓
Monitor
  ↓
Delete
```

---

# Encryption

Secrets Manager protects sensitive information using encryption.

It integrates with **AWS Key Management Service (AWS KMS)** for encryption.

```text
Secret
  ↓
AWS KMS
  ↓
Encryption
  ↓
Encrypted Secret
```

> **Easy Memory:**  
> **Secrets Manager → Secrets**  
> **KMS → Encryption Keys**

---

# IAM Integration

IAM controls **who or what can access a secret**.

```text
Application / IAM Role
        ↓
IAM Policy
        ↓
Secrets Manager
        ↓
Specific Secret
```

Use **fine-grained IAM policies** and the **principle of least privilege**.

Example:

```text
Application A → Secret A
Application B → Secret B
```

Avoid:

```text
Everyone → All Secrets
```

---

# Important Technical Concepts

```text
Secret
Rotation
Encryption
Version
Secrets Manager API
Secret ARN
Replica
```

---

## Secret Version

Secrets Manager can maintain different versions of a secret.

```text
Secret
├── Version 1 → Old
├── Version 2 → Current
└── Version 3 → New
```

Versions are useful during secret rotation and lifecycle management.

---

## Secret ARN

A **Secret ARN (Amazon Resource Name)** uniquely identifies a secret.

```text
Secret
   ↓
ARN
   ↓
Unique Resource Identification
```

ARNs can be used in IAM policies to specify exactly which secret an identity can access.

---

## Secrets Manager API

Applications can retrieve secrets programmatically using the Secrets Manager API.

```text
Application
     ↓
Secrets Manager API
     ↓
Secret
```

This avoids hardcoding credentials in application code.

---

## Replica

Secrets Manager supports **replication of secrets to additional AWS Regions**.

```text
Primary Secret
      ↓
Secret Replication
      ↓
Replica Secret
      ↓
Another AWS Region
```

This is useful for applications operating across multiple AWS Regions.

---

# ⭐ Multi-Region Secrets Manager Architecture

The following architecture shows an application running in **two AWS Regions**, with both the database and secret replicated across Regions.

![AWS Secrets Manager Multi-Region Replication](./control-tower-architecture.png)

```text
                    AWS Multi-Region Architecture

       us-east-1                              us-west-2
┌───────────────────────┐              ┌───────────────────────┐
│                       │              │                       │
│  Lambda Application   │              │  Lambda Application   │
│         ↓             │              │         ↓             │
│     GetSecret         │              │     GetSecret         │
│         ↓             │              │         ↓             │
│  Secrets Manager      │              │  Secrets Manager      │
│         │             │              │         │             │
│         │             │              │         │             │
│  Amazon RDS           │◄────────────►│  Amazon RDS           │
│                       │  DB Replication│                       │
└───────────────────────┘              └───────────────────────┘
           │                                      │
           └──────── Secret Replication ──────────┘
```

### Flow

### Region 1 — `us-east-1`

```text
Lambda Application
       ↓
GetSecret
       ↓
AWS Secrets Manager
       ↓
Database Credentials
       ↓
Amazon RDS
```

### Region 2 — `us-west-2`

```text
Lambda Application
       ↓
GetSecret
       ↓
AWS Secrets Manager Replica
       ↓
Database Credentials
       ↓
Amazon RDS Replica
```

### Replication

Two important things are replicated:

```text
Amazon RDS
    ↓
Database Replication
    ↓
RDS in another Region
```

and:

```text
AWS Secrets Manager
    ↓
Secret Replication
    ↓
Replica Secret in another Region
```

This allows applications in different Regions to retrieve the appropriate replicated secret while accessing the corresponding database.

> **FDE Takeaway:**  
> When designing a multi-Region application, consider **replicating both the data and the secrets required to access that data**.

---

# Typical Use Cases

## Database Credentials

Store:

```text
Database Username
Database Password
Database Connection Information
```

---

## API Keys and Tokens

Store:

```text
API Key
OAuth Token
Service Credential
```

---

## Passwords and Access Keys

Store sensitive authentication information securely.

---

## Application Secrets

Examples:

- Application credentials
- Third-party service credentials
- Sensitive configuration values

---

# Important Integrations

| AWS Service | Purpose |
|---|---|
| **AWS KMS** | Encryption and key management |
| **Amazon EventBridge** | Event-driven automation |
| **AWS IAM** | Access control |
| **Managed Rotation** | Automated secret rotation |
| **AWS Services / Applications** | Dynamic secret retrieval |

---

# Monitoring and Logging

Monitoring and logging help understand:

- Who accessed secrets
- When secrets were accessed
- Unexpected access
- Rotation activity
- Security events

```text
Secrets Manager
      ↓
Logs / Monitoring
      ↓
Security Analysis
      ↓
Response
```

---

# Security Best Practices

## 1. Use IAM Least Privilege

Only authorized users and applications should retrieve a secret.

```text
❌ Everyone → All Secrets

✅ Application A → Secret A
✅ Application B → Secret B
```

---

## 2. Avoid Hardcoded Secrets

Do not store sensitive credentials directly in:

- Source code
- Configuration files
- Plaintext files

Instead:

```text
Application
     ↓
Secrets Manager
     ↓
Secret
```

---

## 3. Rotate Secrets

Use automatic rotation where supported and appropriate.

```text
Old Credential
      ↓
Automatic Rotation
      ↓
New Credential
```

---

## 4. Monitor Secret Usage

Monitor access to identify suspicious or unexpected activity.

---

# Secrets Manager vs IAM

These solve different problems.

| Service | Purpose |
|---|---|
| **IAM** | Controls who/what can access AWS resources and secrets |
| **Secrets Manager** | Stores and manages sensitive secrets |

```text
IAM
 ↓
WHO CAN ACCESS?

Secrets Manager
 ↓
WHERE ARE THE SECRETS?
```

> **Easy Memory:**  
> **IAM = Access Control**  
> **Secrets Manager = Secret Storage & Management**

---

# Secrets Manager vs Parameter Store

| Secrets Manager | Parameter Store |
|---|---|
| Designed specifically for secrets management | General parameter/configuration storage |
| Supports automatic secret rotation | Does not provide the same built-in secret rotation capability |
| Useful for credentials, passwords, API keys | Useful for configuration values and parameters |
| Strong secret lifecycle capabilities | Simpler parameter management |

> **Exam Shortcut:**  
> **Need automatic secret rotation → Secrets Manager**

---

# Pricing

Secrets Manager follows a **pay-as-you-go** pricing model.

Main pricing factors include:

- Number of secrets stored
- API calls/operations
- AWS Region

---

# ⭐ Quick Revision

```text
AWS Secrets Manager
        ↓
Secure Secret Storage
        ↓
Retrieve Secrets Programmatically
        ↓
Rotate Secrets
        ↓
Monitor / Audit
        ↓
Replicate When Required
```

### Key Terms

> **Secret** → Sensitive information such as passwords/API keys.

> **Rotation** → Replacing an existing secret with a new value.

> **Encryption** → Protecting stored secrets.

> **Version** → Different version of a secret.

> **Secret ARN** → Unique identifier for a secret.

> **Replica** → Secret replicated to another AWS Region.

> **Secrets Manager API** → Programmatic secret retrieval.

> **IAM** → Controls access to secrets.

> **KMS** → Encryption/key management.

---

# 🧠 Easy Memory

```text
SECRETS MANAGER

STORE      → Secrets securely
RETRIEVE   → Through API
ROTATE     → Automatically
ENCRYPT    → With KMS
CONTROL    → With IAM
AUDIT      → Monitor access
REPLICATE  → Across Regions
```

# 🎯 Exam / FDE Takeaways

> **Need to securely store database credentials?** → **Secrets Manager**

> **Need to store API keys/tokens?** → **Secrets Manager**

> **Need to avoid hardcoding passwords?** → **Secrets Manager**

> **Need automatic secret rotation?** → **Secrets Manager**

> **Need fine-grained access to secrets?** → **IAM policies**

> **Need encryption/key management?** → **AWS KMS**

> **Need programmatic retrieval?** → **Secrets Manager API**

> **Need a unique identifier for a secret?** → **Secret ARN**

> **Need the secret in another AWS Region?** → **Secret Replica**

> **Need to monitor secret access?** → **Logging and monitoring**

> **Multi-Region application?** → Consider **secret replication + database replication**

## ⭐ One-Line Summary

> **AWS Secrets Manager securely stores, retrieves, rotates, encrypts, and manages sensitive information such as database credentials, API keys, passwords, and application secrets throughout their lifecycle.**