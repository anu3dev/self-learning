# AWS Key Management Service (AWS KMS) — Getting Started

## What is AWS KMS?

**AWS Key Management Service (AWS KMS)** is a managed service used to **create, manage, control, and protect cryptographic keys** used to encrypt data.

Think of KMS as a **secure vault for digital encryption keys**.

```text
Data
  ↓
Encryption Key
  ↓
Encrypted Data
```

AWS KMS handles key-management tasks such as:

- Key creation
- Key storage
- Key rotation
- Key deletion
- Access control
- Key usage auditing

> **Easy Memory:**  
> **KMS = Create + Manage + Control Encryption Keys**

---

# Why AWS KMS?

Managing encryption keys yourself can become complex as the number of applications and data sources grows.

AWS KMS helps with:

- Centralized key management
- Secure key storage
- Access control
- Key rotation
- Auditing
- Integration with AWS services
- Scalable encryption

```text
Applications / AWS Services
          ↓
        AWS KMS
          ↓
   Encryption Keys
          ↓
      Protected Data
```

---

# AWS KMS and Encryption

KMS provides keys that can be used to protect data.

Common examples include encrypting data stored in:

- Amazon S3
- Amazon EBS
- Amazon RDS
- Amazon Aurora
- Amazon Redshift
- Applications

```text
Application
     ↓
AWS KMS
     ↓
Encryption
     ↓
Protected Data
```

---

# AWS KMS Key Types

AWS KMS supports different types of keys.

## Symmetric Keys

A **symmetric key** uses the same key for encryption and decryption.

```text
          Same Key
        ↙         ↘
Encrypt Data     Decrypt Data
```

This is the common model for AWS service encryption.

---

## Asymmetric Keys

Asymmetric cryptography uses:

```text
Public Key
     +
Private Key
```

For example, AWS KMS can use an asymmetric private key to create a **digital signature**.

```text
Message
   ↓
Private Key
   ↓
Digital Signature
   ↓
Public Key
   ↓
Signature Verification
```

The public key can be used to verify that:

1. The message was signed by the corresponding private key.
2. The message was not changed after signing.

> **Easy Memory:**  
> **Symmetric → Same key**  
> **Asymmetric → Public + Private key**

---

# Key Management

AWS KMS manages the lifecycle of cryptographic keys.

```text
Create
  ↓
Store
  ↓
Use
  ↓
Rotate
  ↓
Disable / Manage
  ↓
Delete
```

This removes the need to build and maintain your own key-management infrastructure.

---

# AWS KMS Key Concepts

Important concepts include:

```text
Customer Managed Key
AWS Owned Keys
Key Policy
Key Rotation
Envelope Encryption
Grant
Alias
Key Material
HSM
```

---

# Customer Managed Key

A **customer managed key** is a KMS key that you create and manage.

You have greater control over:

- Key policies
- Permissions
- Rotation
- Key lifecycle

```text
Customer
   ↓
Create / Manage
   ↓
Customer Managed KMS Key
```

---

# AWS Owned Keys

**AWS owned keys** are managed by AWS and used by AWS services to protect resources.

The customer does not manage the underlying key in the same way as a customer managed key.

---

# Key Policy

A **key policy** controls access to a KMS key.

```text
Identity
   ↓
Key Policy
   ↓
KMS Key
   ↓
Allowed / Denied
```

Key policies are an important part of KMS access control.

> **Important:**  
> KMS access can involve both **IAM policies and key policies**.

---

# Key Rotation

Key rotation means replacing key material used for encryption over time.

```text
Current Key Material
        ↓
     Rotation
        ↓
New Key Material
```

Automatic key rotation can be configured for supported KMS keys.

> **Easy Memory:**  
> **Rotation → Reduce long-term key exposure**

---

# Envelope Encryption

**Envelope encryption** is an important KMS concept.

Instead of using a KMS key directly to encrypt large amounts of application data:

```text
KMS Key
   ↓
Generate / Protect Data Key
   ↓
Data Key
   ↓
Encrypt Large Data
```

Conceptually:

```text
KMS Key
   ↓
Protects Data Key
   ↓
Data Key
   ↓
Encrypts Data
```

This allows applications to efficiently encrypt large amounts of data while KMS manages the key hierarchy.

> **Easy Memory:**  
> **KMS Key → Protects Data Key → Data Key encrypts Data**

---

# Grant

A **grant** provides another way to give permissions to use a KMS key.

It can be useful when AWS services or applications need controlled access to a key.

```text
KMS Key
   ↓
Grant
   ↓
Authorized Principal
```

---

# Alias

An **alias** is a friendly name for a KMS key.

Instead of referring to a key only by its identifier, applications can use an easier-to-understand alias.

```text
KMS Key
   ↓
Alias
   ↓
alias/application-key
```

> **Easy Memory:**  
> **Alias = Friendly name for a KMS key**

---

# Key Material

**Key material** is the cryptographic material associated with a KMS key that is used for cryptographic operations.

AWS KMS protects this key material.

---

# Hardware Security Modules (HSMs)

AWS KMS uses **Hardware Security Modules (HSMs)** to protect the confidentiality and integrity of keys.

```text
KMS
 ↓
HSM
 ↓
Protect Cryptographic Keys
```

> **Important Exam Point:**  
> **AWS KMS uses HSMs to protect cryptographic keys.**

---

# AWS KMS + AWS CloudTrail

AWS CloudTrail can log AWS KMS API activity.

```text
KMS API Call
     ↓
CloudTrail
     ↓
Audit Trail
```

This helps with:

- Auditing
- Security investigations
- Compliance
- Tracking key-management activity

---

# Monitoring with CloudWatch

Amazon CloudWatch can be used to monitor relevant KMS activity and create alarms.

```text
KMS Activity
     ↓
Monitoring
     ↓
CloudWatch
     ↓
Alarm / Alert
```

---

# AWS KMS + CloudHSM

For workloads requiring additional hardware-based key-management capabilities, AWS KMS can be used alongside **AWS CloudHSM**.

> **Remember:**  
> **KMS → Managed key-management service**  
> **CloudHSM → Dedicated HSM environment with greater hardware-level control**

---

# Multi-Region Keys

AWS KMS supports **multi-Region keys**.

These can be useful when applications operate across multiple AWS Regions.

```text
Region A
   ↓
KMS Multi-Region Key
   ↓
Region B
```

This can simplify cryptographic operations for multi-Region architectures.

---

# Typical Use Cases

## Data Encryption

Encrypt sensitive data stored in AWS services and applications.

---

## Database Encryption

KMS can help protect data in:

- Amazon RDS
- Amazon Aurora
- Amazon Redshift

---

## Amazon EBS Encryption

KMS can be used with **Amazon EBS encryption** to protect EBS volumes.

```text
EC2
 ↓
EBS Volume
 ↓
KMS
 ↓
Encrypted Data
```

---

## Application Data Protection

Applications can integrate with KMS APIs to implement encryption.

---

## Client-Side Encryption

Applications can use KMS capabilities as part of client-side encryption architectures.

---

## Regulatory Compliance

Centralized key management, access control, and auditing can help organizations meet security and compliance requirements.

---

# Access Control

KMS security relies heavily on controlling who can use and manage keys.

Important controls include:

```text
IAM Policies
      +
KMS Key Policies
      +
Least Privilege
```

### Principle of Least Privilege

Only give users, applications, and services the permissions they actually need.

```text
❌ Everyone → Full KMS Access

✅ App A → Encrypt/Decrypt with Key A
✅ Admin → Manage Key A
```

---

# AWS KMS Architecture

```text
                AWS Application
                       ↓
                  IAM Policy
                       ↓
                  Key Policy
                       ↓
                    AWS KMS
                       ↓
                KMS Encryption Key
                       ↓
              Encrypt / Decrypt
                       ↓
                    Data
```

For auditing:

```text
AWS KMS
   ↓
CloudTrail
   ↓
Audit Logs
   ↓
Security / Compliance
```

---

# AWS KMS vs AWS Secrets Manager

These services are related but solve different problems.

| Service | Main Purpose |
|---|---|
| **AWS KMS** | Create and manage encryption keys |
| **AWS Secrets Manager** | Store and manage secrets such as passwords/API keys |

```text
KMS
 ↓
Encryption Keys

Secrets Manager
 ↓
Passwords / API Keys / Credentials
```

They can work together:

```text
Secrets Manager
      ↓
AWS KMS
      ↓
Encrypt Secret
```

> **Easy Memory:**  
> **KMS → Keys**  
> **Secrets Manager → Secrets**

---

# AWS KMS vs CloudHSM

| AWS KMS | AWS CloudHSM |
|---|---|
| Managed key-management service | Dedicated HSM infrastructure |
| AWS manages much of the infrastructure | Customer has more control over HSM environment |
| Easy integration with AWS services | Greater hardware-level control |
| General AWS encryption use cases | Specialized compliance/control requirements |

---

# Pricing

AWS KMS uses a **pay-as-you-go** pricing model.

Main cost factors include:

- Number of KMS keys
- KMS API requests
- Certain cross-Region/multi-Region usage

AWS also provides Free Tier benefits for eligible usage.

> **Note:** Pricing can change, so check current AWS pricing when making a real architecture/cost decision.

---

# ⭐ Quick Revision

```text
AWS KMS
   ↓
Create Encryption Keys
   ↓
Secure Key Storage
   ↓
Control Access
   ↓
Encrypt / Decrypt Data
   ↓
Rotate / Manage Keys
   ↓
Audit Key Usage
```

### Key Terms

> **KMS** → Managed cryptographic key-management service.

> **Customer Managed Key** → Key created and managed by the customer.

> **AWS Owned Key** → Key managed by AWS for AWS service use.

> **Key Policy** → Controls access to a KMS key.

> **Key Rotation** → Changes key material over time.

> **Envelope Encryption** → Data key encrypts data; KMS key protects the data key.

> **Grant** → Permission mechanism for KMS key access.

> **Alias** → Friendly name for a KMS key.

> **HSM** → Hardware Security Module protecting cryptographic keys.

> **CloudTrail** → Records KMS API activity for auditing.

> **Multi-Region Key** → KMS key capability designed for multi-Region architectures.

---

# 🧠 Easy Memory

```text
KMS

CREATE     → Keys
STORE      → Securely
CONTROL    → Policies
ENCRYPT    → Data
ROTATE     → Key Material
AUDIT      → CloudTrail
PROTECT    → HSM
REPLICATE  → Multi-Region
```

### Security Memory

```text
IAM Policy
     +
Key Policy
     +
Least Privilege
     ↓
Secure KMS Access
```

---

# 🎯 Exam / FDE Takeaways

> **Need to manage encryption keys?** → **AWS KMS**

> **Need to encrypt AWS data such as EBS/RDS data?** → **AWS KMS**

> **Need centralized cryptographic key management?** → **AWS KMS**

> **What protects KMS key material?** → **Hardware Security Modules (HSMs)**

> **Need to control access to a KMS key?** → **Key Policy + IAM permissions**

> **Need to audit KMS API activity?** → **AWS CloudTrail**

> **Need to monitor/alert on activity?** → **Amazon CloudWatch**

> **Need a friendly name for a key?** → **KMS Alias**

> **Need to encrypt large amounts of data efficiently?** → **Envelope Encryption**

> **Need to protect a data key?** → **KMS key**

> **Need public/private key cryptography or digital signatures?** → **Asymmetric KMS key**

> **Need multi-Region cryptographic key capabilities?** → **Multi-Region KMS keys**

> **Need to securely store passwords/API keys?** → **AWS Secrets Manager**

## ⭐ One-Line Summary

> **AWS KMS is a managed service that securely creates, stores, controls, rotates, and audits cryptographic keys used to protect data across AWS services and applications.**