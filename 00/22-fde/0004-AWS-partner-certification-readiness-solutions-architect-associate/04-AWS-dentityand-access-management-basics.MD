````markdown
# AWS Identity and Access Management (IAM)

## What is IAM?

**AWS Identity and Access Management (IAM)** controls **who can access AWS resources and what they are allowed to do**.

```text
Authentication → Who are you?
Authorization  → What can you do?
```

---

## IAM Components

```text
IAM
├── Users
├── Groups
├── Roles
└── Policies
```

---

## IAM User

An **IAM User** represents a person or application that needs long-term AWS access.

A user can have:

- Username/password
- Access keys
- Permissions through policies
- MFA

```text
IAM User
   ↓
Permissions
   ↓
AWS Resources
```

> **Use:** Individual identity requiring AWS access.

---

## IAM Group

An **IAM Group** is a collection of IAM users.

Instead of assigning the same permissions to every user individually:

```text
Developers Group
├── User A
├── User B
└── User C
```

Assign the permissions to the group.

### Benefit

Easier permission management for multiple users.

> **Easy Memory:**  
> **Group = Collection of Users**

---

## IAM Role

An **IAM Role** is an identity with permissions that can be **assumed temporarily**.

Roles are commonly used by:

- AWS services
- Applications
- EC2 instances
- Lambda functions
- Federated users

Example:

```text
EC2
 ↓
Assume IAM Role
 ↓
Temporary Credentials
 ↓
Access S3
```

### Important

An IAM Role does **not** have long-term credentials like an IAM user.

> **Easy Memory:**  
> **Role = Temporary / Assumed Access**

---

## IAM Policy

An **IAM Policy** defines what actions are allowed or denied.

Policies are generally written in **JSON**.

Important elements:

```text
Version
Effect
Action
Resource
```

Example concept:

```json
{
  "Effect": "Allow",
  "Action": "s3:GetObject",
  "Resource": "arn:aws:s3:::my-bucket/*"
}
```

Meaning:

> Allow reading objects from the specified S3 bucket.

---

# IAM User vs Group vs Role vs Policy

| Component | Purpose |
|---|---|
| **User** | Represents an individual identity |
| **Group** | Collection of users |
| **Role** | Identity that can be assumed for temporary access |
| **Policy** | Defines permissions |

### Easy Memory

```text
USER   → WHO
GROUP  → USERS TOGETHER
ROLE   → ASSUME ACCESS
POLICY → WHAT THEY CAN DO
```

---

# Least Privilege

The **principle of least privilege** means giving an identity **only the permissions it actually needs**.

Example:

If an application only needs to read S3 objects:

```text
❌ AdministratorAccess
❌ s3:*
✅ s3:GetObject
```

> **Easy Memory:**  
> **Give minimum required permissions — nothing extra.**

---

# IAM Authentication vs Authorization

## Authentication

Verifies identity.

```text
Who are you?
     ↓
Authentication
```

Examples:

- Username/password
- Access keys
- MFA

## Authorization

Determines permissions.

```text
What can you do?
     ↓
Authorization
```

Controlled through IAM policies.

---

# IAM Roles for AWS Services

AWS services can use IAM roles to access other AWS resources.

Example:

```text
EC2
 ↓
IAM Role
 ↓
S3
```

The EC2 instance does not need hard-coded AWS access keys.

This is the **preferred approach** for AWS service-to-service access.

---

# IAM Federation

Organizations can allow employees to use an existing corporate identity system to access AWS.

```text
Employee
   ↓
Corporate Identity Provider
   ↓
Federation
   ↓
IAM Role
   ↓
AWS Resources
```

### Benefit

Avoids creating and managing individual long-term IAM credentials for every employee.

---

# MFA

**Multi-Factor Authentication (MFA)** adds another verification factor in addition to a password or credentials.

```text
Password
   +
MFA
   ↓
Access
```

### Best Practice

Enable MFA, especially for highly privileged accounts such as the **AWS root user**.

---

# AWS Root User

The **AWS root user** is the original identity created when an AWS account is created.

### Best Practice

Do **not** use the root user for everyday AWS tasks.

Use IAM identities/roles instead.

Protect the root user with:

- MFA
- Strong credentials
- Minimal usage

---

# IAM Best Practices

```text
1. Follow Least Privilege
2. Enable MFA
3. Avoid using Root User for daily tasks
4. Use IAM Roles for AWS services
5. Use Groups to manage permissions for multiple users
6. Avoid long-term credentials when temporary credentials are appropriate
7. Regularly review permissions
```

---

# ⭐ Quick Revision

```text
IAM
│
├── User
│    └── Individual identity
│
├── Group
│    └── Collection of users
│
├── Role
│    └── Assumed / temporary access
│
└── Policy
     └── Defines permissions
```

### Most Important Exam Associations

```text
Individual AWS identity       → IAM User

Multiple users with same
permissions                   → IAM Group

EC2 needs S3 access           → IAM Role

Lambda needs DynamoDB access  → IAM Role

Define allowed actions        → IAM Policy

Minimum required permissions  → Least Privilege

Extra authentication factor   → MFA

Employee corporate login      → Federation + IAM Role

Daily AWS administration      → Don't use Root User
```

# 🧠 Easy Memory

> **USER = WHO**

> **GROUP = USERS TOGETHER**

> **ROLE = ASSUME ACCESS**

> **POLICY = WHAT CAN YOU DO**

> **IAM = CONTROL AWS ACCESS**
````
