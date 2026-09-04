# AWS Security – Encryption Fundamentals

> **Course:** AWS Partner Certification Readiness – Solutions Architect  
> **Topic:** AWS Security – Encryption Fundamentals

---

# 1. Cryptography

**Cryptography** is the science of protecting information using complex mathematical operations.

Common applications of cryptography:

```text
Cryptography
├── Encryption
├── Hashing
└── Digital Signing
```

### Four Main Goals

```text
Confidentiality
Integrity
Authentication
Non-repudiation
```

> **Easy Memory:**  
> **CIA + Non-repudiation**

---

# 2. Encryption

Encryption protects data by converting readable **plaintext** into unreadable **ciphertext**.

```text
Plaintext
   ↓
Encryption + Key
   ↓
Ciphertext
   ↓
Decryption + Key
   ↓
Plaintext
```

Encryption can protect:

- Data at rest
- Data in transit
- Application-level data

Two major types:

```text
Symmetric Encryption
Asymmetric Encryption
```

---

# 3. Symmetric Encryption

Symmetric encryption uses the **same key** for encryption and decryption.

```text
             Same Key
                ↓
Plaintext → Encryption → Ciphertext
                         ↓
                     Decryption
                         ↓
                      Plaintext
```

The intended parties must have access to the shared key.

### Common Use

Symmetric encryption is commonly used for **data at rest**.

Examples:

- Amazon S3
- Amazon EBS
- Hard drives

> **Easy Memory:**  
> **Symmetric = Same key**

---

# 4. Asymmetric Encryption

Asymmetric encryption uses a **key pair**:

```text
Public Key
Private Key
```

The keys are mathematically related but designed so that knowing one does not practically allow you to calculate the other.

Example:

```text
Public Key
    ↓
Encrypt
    ↓
Ciphertext
    ↓
Private Key
    ↓
Decrypt
```

### Common Uses

- Data in transit
- TLS
- Authentication
- Digital signatures
- Payment transactions

> **Easy Memory:**  
> **Asymmetric = Public + Private key**

---

# 5. Symmetric vs Asymmetric

| Feature | Symmetric | Asymmetric |
|---|---|---|
| Keys | Same key | Public + Private |
| Main use | Data at rest | Authentication / Data in transit |
| Performance | Generally faster | Generally slower |
| Example use | S3 / EBS encryption | TLS / Digital signatures |

### Quick Memory

```text
Symmetric   → SAME key → Data at Rest
Asymmetric  → KEY PAIR → TLS / Signing
```

---

# 6. Envelope Encryption

**Envelope encryption** protects the encryption key itself.

The key used to encrypt the actual data is called the **data key**.

A separate key protects the data key. This is called the:

- Wrapping key
- Key encryption key

```text
Plaintext
    ↓
Data Key
    ↓
Ciphertext

Data Key
    ↓
Wrapping Key
    ↓
Encrypted Data Key
```

So:

```text
Wrapping Key
      ↓
 encrypts
      ↓
Data Key
      ↓
encrypts
      ↓
Data
```

### Why?

The data key should not be stored in plaintext alongside the encrypted data.

> **Easy Memory:**  
> **Key encrypts Data**  
> **Wrapping Key encrypts Key**

---

# 7. AWS KMS

**AWS Key Management Service (AWS KMS)** helps create and manage cryptographic keys and perform cryptographic operations.

Think of KMS as a managed service for **cryptographic key management**.

AWS KMS helps avoid the need to manage:

- Key hardware
- Key availability
- Key redundancy
- Key management infrastructure

---

# 8. AWS KMS Use Cases

AWS KMS can be used to:

- Encrypt data at rest across **100+ AWS services**.
- Provide wrapping keys for client-side encryption using the AWS Encryption SDK.
- Digitally sign and verify data using asymmetric key pairs.
- Generate and verify MACs.
- Generate random numbers for cryptographic applications.

Examples:

```text
Amazon S3
Amazon EBS
Other AWS Services
       ↓
     AWS KMS
       ↓
Encryption
```

---

# 9. KMS Key Types

KMS supports different key management options.

### AWS Managed Keys

Keys managed by AWS for supported AWS services.

### Customer Managed Keys

Keys that you create and have greater control over.

Customer managed keys can be used when you need more control over:

- Key policies
- Permissions
- Rotation
- Lifecycle

> **Easy Memory:**  
> **AWS Managed → AWS manages**  
> **Customer Managed → Customer controls more**

---

# 10. Hashing

Hashing is another application of cryptography.

A hash algorithm takes input and produces a fixed-length value.

```text
Input
  ↓
Hash Function
  ↓
Hash
```

Unlike encryption, hashing is a **one-way operation**.

```text
Plaintext
   ↓
Hash
   ↓
Hash Value
```

The hash is not designed to be converted back into the original plaintext.

---

# 11. Why Hashing is Used

Hashing can help determine whether data has been modified.

```text
Original File
    ↓
Hash A

Received File
    ↓
Hash B

Compare A and B
```

If:

```text
Hash A = Hash B
```

the data has not changed based on the hash comparison.

> **Easy Memory:**  
> **Hashing → Integrity**

---

# 12. Digital Signatures

Digital signatures combine **hashing + asymmetric cryptography**.

They can provide:

- Data integrity
- Authentication
- Proof of origin

### Signing Process

```text
Document
   ↓
Hash
   ↓
Hash Value
   ↓
Encrypt with Private Key
   ↓
Digital Signature
```

The sender sends:

```text
Document
+
Digital Signature
+
Public Key
```

---

# 13. Digital Signature Verification

The recipient:

```text
Received Document
      ↓
Calculate Hash
      ↓
Hash A
```

Then:

```text
Digital Signature
      ↓
Decrypt using Sender's Public Key
      ↓
Original Hash
```

Finally:

```text
Calculated Hash
      +
Signature Hash
      ↓
Compare
```

If the hashes match:

- The document was not altered.
- The signature corresponds to the sender's private key.

> **Easy Memory:**  
> **Private Key → Sign**  
> **Public Key → Verify**

---

# 14. Digital Certificates

A **digital certificate** is an electronic credential that helps prove the authenticity of:

- Users
- Devices
- Servers
- Websites

Certificates use public-key cryptography to establish trust.

A certificate can contain:

- Domain name
- Organization information
- Public key
- Expiration date
- Certificate Authority information
- CA digital signature

The most common certificate standard is:

> **X.509**

---

# 15. Certificate Authority (CA)

A **Certificate Authority (CA)** issues and can revoke digital certificates.

```text
Certificate Authority
        ↓
Issues Certificate
        ↓
Website / Server
        ↓
Client
```

There are two major types:

```text
Public CA
Private CA
```

---

# 16. Public Certificate Authority

A **publicly trusted CA** is trusted by major:

- Browsers
- Operating systems
- Devices

Example:

> **Amazon Trust Services**

Public certificates are commonly used for public-facing websites and applications.

---

# 17. Private Certificate Authority

A **private CA** is controlled by an organization for internal use.

Useful when an organization needs certificates for:

- Internal applications
- Private services
- Internal users/devices
- Private networks

> **Easy Memory:**  
> **Public CA → Public Internet**  
> **Private CA → Internal Organization**

---

# 18. Certificate Request Process

A simplified public certificate process:

```text
1. Create CSR
       ↓
2. Submit CSR to CA
       ↓
3. CA verifies request
       ↓
4. Certificate generated
       ↓
5. CA signs certificate
       ↓
6. Certificate installed
```

---

# 19. Certificate Signing Request (CSR)

A **Certificate Signing Request (CSR)** contains information needed to request a certificate.

It can include:

- Organization information
- Domain/common name
- Public key

The requester signs the CSR using their private key.

---

# 20. TLS and Data in Transit

TLS uses digital certificates to establish trust between a client and server.

Simplified flow:

```text
Client
   ↓
Server Certificate
   ↓
Verify Certificate
   ↓
Trust Established
   ↓
Session Key Established
   ↓
Symmetric Encryption
   ↓
Encrypted Communication
```

### Important

TLS commonly uses a combination of:

```text
Asymmetric Encryption
        +
Symmetric Encryption
```

Asymmetric cryptography helps establish trust and exchange/protect key material.

After the secure session is established, **symmetric encryption** is generally used for efficient data transfer.

> **Easy Memory:**  
> **Asymmetric → Establish Trust / Key Exchange**  
> **Symmetric → Encrypt Session Data**

---

# 21. Certificate Hierarchy

Certificate authorities commonly use a hierarchy.

```text
Root CA
   ↓
Intermediate CA
   ↓
End-Entity Certificate
   ↓
Website / Server
```

### Root CA

The root CA is the ultimate trust anchor.

### Intermediate CA

The root CA can authorize intermediate CAs to issue certificates.

### End-Entity Certificate

The certificate ultimately used by a website or server.

---

# 22. Chain of Trust

Clients generally trust known root CAs.

```text
Trusted Root CA
      ↓
Intermediate CA
      ↓
Server Certificate
      ↓
Website
```

If the root CA is trusted, the certificate chain can establish trust in the subordinate certificates.

> **Easy Memory:**  
> **Root → Intermediate → Website**

---

# 23. AWS Certificate Manager (ACM)

**AWS Certificate Manager (ACM)** helps provision, manage, and deploy TLS certificates.

ACM reduces the operational overhead of managing certificates.

It can help with:

- Certificate provisioning
- Certificate deployment
- Certificate renewal
- Importing existing certificates
- Public TLS certificates
- Private certificates from AWS Private CA

---

# 24. When to Use ACM

Consider ACM when you need to:

- Secure web traffic with TLS certificates.
- Import existing certificates into AWS.
- Deploy certificates to public-facing AWS applications.
- Manage private certificates created through AWS Private CA.

```text
Web Application
      ↓
ACM Certificate
      ↓
TLS
      ↓
Secure HTTPS Traffic
```

---

# 25. Encryption at Rest vs In Transit

## Data at Rest

Data is stored somewhere.

Examples:

```text
S3
EBS
Database
Disk
```

Commonly uses:

> **Symmetric Encryption**

AWS KMS can help manage the encryption keys.

---

## Data in Transit

Data is moving between systems.

Examples:

```text
Browser → Web Server
Application → API
AWS → On-Premises
```

Commonly protected using:

> **TLS**

TLS uses digital certificates and a combination of asymmetric and symmetric cryptography.

---

# ⭐ Encryption Architecture

```text
                    CRYPTOGRAPHY
                         │
        ┌────────────────┼────────────────┐
        ↓                ↓                ↓
   Encryption         Hashing          Signing
        │                │                │
        ↓                ↓                ↓
 Confidentiality    Integrity      Authentication
        │
   ┌────┴─────┐
   ↓          ↓
Symmetric  Asymmetric
   │          │
   ↓          ↓
At Rest     TLS / Signing
   │
   ↓
Envelope Encryption
   │
   ↓
AWS KMS
```

---

# 🧠 Quick Revision

```text
Encryption
→ Protects confidentiality

Symmetric
→ Same key
→ Commonly used for data at rest

Asymmetric
→ Public + Private key
→ TLS / Digital signatures

Envelope Encryption
→ Data key encrypts data
→ Wrapping key encrypts data key

KMS
→ Managed cryptographic key service
→ Encrypt data at rest across 100+ AWS services

Hashing
→ One-way
→ Integrity

Digital Signature
→ Hash + Private Key
→ Integrity + Authentication

Certificate
→ Digital identity / trust credential
→ X.509

CA
→ Issues certificates

ACM
→ Provision + manage + deploy TLS certificates

TLS
→ Secure data in transit

Certificate Chain
→ Root CA → Intermediate CA → Server Certificate
```

# 🎯 Exam / FDE Takeaways

> **Same key for encryption and decryption?** → Symmetric

> **Public + private key?** → Asymmetric

> **Need to protect a data encryption key?** → Envelope encryption

> **AWS managed key management?** → AWS KMS

> **Need to verify data wasn't modified?** → Hashing

> **Need integrity + authentication?** → Digital signature

> **Need to establish website/server identity?** → Digital certificate

> **Certificate standard?** → X.509

> **Who issues certificates?** → Certificate Authority

> **Secure web traffic?** → TLS

> **Manage TLS certificates on AWS?** → AWS Certificate Manager (ACM)

> **Certificate trust chain?** → Root CA → Intermediate CA → End-Entity Certificate

### One-Line Memory

```text
KMS       → KEYS
Hash      → INTEGRITY
Signature → SIGN / VERIFY
Certificate → IDENTITY / TRUST
TLS       → DATA IN TRANSIT
ACM       → CERTIFICATE MANAGEMENT
S3/EBS    → DATA AT REST
```

## ⭐ Important AWS Relationship

```text
Application Data
      ↓
Data Key
      ↓
Encrypt Data
      ↓
Ciphertext

Data Key
      ↓
KMS / Wrapping Key
      ↓
Encrypted Data Key
```

> **Remember:** AWS KMS is primarily a **key management and cryptographic service**. It can provide keys used in envelope encryption; the AWS Encryption SDK can use KMS as a wrapping-key provider for client-side encryption.