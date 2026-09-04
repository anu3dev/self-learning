# AWS Security Agent — Revision Notes

## What is Penetration Testing?

**Penetration testing (Pen Test)** is an **authorized simulated cyberattack** performed to find and validate security vulnerabilities before a real attacker can exploit them.

> **Pen Test = Act like a hacker, with permission, to find security weaknesses.**

---

# AWS Security Agent

**AWS Security Agent** is an **AI-powered security agent** that helps secure applications throughout the software development lifecycle.

Its core capabilities are:

1. **Design Security Review**
2. **Code Security Review**
3. **On-Demand Penetration Testing**

### Easy Memory

**Design → Code → Attack**

---

# 3 Things to Remember About AWS Security Agent

## 1. AI-Powered Pen Testing

AWS Security Agent provides **autonomous, fully managed penetration testing**.

* AI-powered
* Autonomous
* Fully managed
* **No infrastructure to set up**

> **Security Agent = AI hacker without managing the hacking infrastructure**

---

## 2. Context-Aware Planning

The agent doesn't simply scan blindly.

It can ingest application context such as:

* Design documentation
* APIs
* Infrastructure as Code (IaC)
* Existing threat models
* Runtime behavior
* User stories

It uses this information to create a **tailored attack plan** for the application.

### Why is this important?

Traditional security tools may identify generic vulnerabilities, while Security Agent can understand **how the application is actually designed and supposed to work**.

---

## 3. Verified Findings

Every identified vulnerability comes with a **reproducible exploit**.

This means the finding is not simply:

> "There may be a vulnerability."

Instead, the agent provides evidence showing **how the vulnerability can actually be reproduced/exploited**.

### Remember

**Finding + Reproducible Exploit = Verified Finding**

---

# 3 Core Capabilities

## 1. Design Security Review

Reviews the application's:

* Design
* Infrastructure as Code
* Security rules/policies

It can identify security issues **before code is written**.

### Key phrase

> **Design review in minutes**

---

## 2. Code Security Review

Provides security analysis of source code.

It can integrate with **GitHub** and scan pull requests against organizational security policies.

### Key phrase

> **Near-real-time PR security review**

### Important Exam Point

AWS Security Agent's code-security guidance through **PR comments is restricted to private repositories**.

---

## 3. On-Demand Penetration Testing

Performs autonomous, multi-step penetration tests.

### Key characteristics

* Runs in **hours**
* Performs multi-step attacks
* Produces clear, repeatable exploits
* Provides verified findings

### Key phrase

> **On-demand penetration testing = multi-step attacks + reproducible exploits**

---

# SAST vs DAST vs AWS Security Agent

## SAST — Static Application Security Testing

SAST examines **source code without running the application**.

### Limitation

It generally lacks:

* Runtime context
* Application behavior
* Full application design context

---

## DAST — Dynamic Application Security Testing

DAST tests a **running application**.

### Limitation

It can assess the running application but generally lacks deeper:

* Application-level context
* Design understanding
* Threat-model context

---

## How AWS Security Agent Addresses These Limitations

AWS Security Agent can combine broader application context such as:

**Design + Threats + Runtime behavior + Code + User stories**

Therefore, it can reason about security issues beyond what a standalone SAST or DAST tool typically understands.

### Exam Memory

**SAST → Code**

**DAST → Running App**

**Security Agent → Context + Code + Runtime + Threats**

---

# Agent Space

An **Agent Space** is a **dedicated workspace/organizational container** representing a distinct:

* Application
* Project

being secured by AWS Security Agent.

### Easy Memory

> **1 Agent Space = 1 security workspace for an application/project**

---

# AWS Security Agent Access Options

During setup, users can choose between:

### 1. IAM Identity Center

Used for **SSO / centralized identity access**.

### 2. IAM-only access

Access using AWS IAM.

### Remember

**Access options = IAM Identity Center OR IAM**

---

# Target Ownership Validation

Before AWS Security Agent performs penetration testing against a target endpoint, **proof of ownership must be established**.

Two validation methods:

### 1. DNS Validation

Add a specific **TXT record** to your domain.

### 2. HTTP Validation

Host a specific **validation string** at the required URL/path.

### Memory

**Ownership → DNS TXT OR HTTP validation**

This prevents someone from using the penetration-testing capability against a system they don't own/control.

---

# Authentication During Penetration Testing

AWS Security Agent can authenticate to a target system using:

### Option 1 — Static Credentials

A:

**Username + Password**

stored securely in **AWS Secrets Manager**.

### Option 2 — Credential Vendor

A credential provider implemented as an **AWS Lambda function**.

### Memory

**Credentials = Secrets Manager OR Lambda credential vendor**

---

# Design Review — Compliance Categories

AWS Security Agent's design review classifies findings into **4 compliance status categories**:

| Status                | Meaning                                        |
| --------------------- | ---------------------------------------------- |
| **Non-compliant**     | Security requirement is not satisfied          |
| **Insufficient data** | Not enough information to determine compliance |
| **Compliant**         | Requirement is satisfied                       |
| **Not applicable**    | Requirement does not apply                     |

### Memory

**N → I → C → N**

**Non-compliant → Insufficient data → Compliant → Not applicable**

---

# Vulnerability Baseline

AWS Security Agent detects vulnerabilities against the:

### **OWASP Top 10 for Web Applications**

It can also identify **business-logic flaws**.

### Important

Business-logic vulnerabilities are particularly important because they may not be detected by simple vulnerability scanners.

Example:

> An application correctly validates a user's login, but due to flawed business logic, a user can manipulate an order and receive a product without paying.

Technically the authentication may be secure, but the **business logic is vulnerable**.

---

# Why Run Penetration Tests in Non-Production?

AWS Security Agent penetration tests are recommended in **non-production environments**.

### Why?

The agent uses **Kali Linux tools** during penetration testing.

These tools/attacks may:

* Modify application state
* Modify data
* Modify system configuration
* Cause data loss
* Cause service disruption
* Trigger incident-response systems

Therefore:

> **Avoid testing production unless the risks and impact are fully understood and controlled.**

### Exam Memory

**Pen Test → Kali tools → May modify state/data → Use non-production**

---

# AWS Security Agent — Complete Exam Cheat Sheet

| Topic                    | Remember                                                    |
| ------------------------ | ----------------------------------------------------------- |
| **Purpose**              | Secure applications using AI                                |
| **Core capabilities**    | Design review + Code review + Pen testing                   |
| **Pen testing**          | Autonomous + fully managed                                  |
| **Infrastructure**       | No infrastructure to set up                                 |
| **Planning**             | Context-aware                                               |
| **Context**              | Design, APIs, IaC, threats, runtime, user stories           |
| **Findings**             | Reproducible exploits                                       |
| **Design review**        | Before code is written                                      |
| **Code review**          | GitHub PR security review                                   |
| **PR comments**          | Private repositories only                                   |
| **Pen testing**          | Multi-step attacks                                          |
| **SAST limitation**      | No runtime context                                          |
| **DAST limitation**      | Limited application/design context                          |
| **Agent Space**          | Workspace for an application/project                        |
| **Access**               | IAM Identity Center or IAM-only                             |
| **Ownership validation** | DNS TXT or HTTP validation                                  |
| **Target credentials**   | Secrets Manager or Lambda credential vendor                 |
| **Compliance statuses**  | Non-compliant, Insufficient data, Compliant, Not applicable |
| **Baseline**             | OWASP Top 10                                                |
| **Additional detection** | Business-logic flaws                                        |
| **Pen test environment** | Prefer non-production                                       |
| **Reason**               | Kali tools can modify state/data/configuration              |

---

# ⭐ Most Important Exam Questions

### Q: What are the three core capabilities of AWS Security Agent?

**A:**
**Design security review, code security review, and on-demand penetration testing.**

### Q: What is the key limitation of SAST?

**A:**
SAST examines code without **runtime context**.

### Q: What is the key limitation of DAST?

**A:**
DAST evaluates running applications but lacks deeper **application/design context**.

### Q: What is an Agent Space?

**A:**
A dedicated workspace representing a distinct **application or project** being secured.

### Q: How is target ownership validated?

**A:**
**DNS TXT record or HTTP validation.**

### Q: What framework does Security Agent use as a vulnerability baseline?

**A:**
**OWASP Top 10 for Web Applications**, plus business-logic flaws.

### Q: Why use non-production for penetration testing?

**A:**
Because penetration-testing tools can **modify application state/data/configuration**, potentially causing disruption or data loss.

---

## 🧠 Final Memory Formula

**AWS Security Agent**

**DESIGN → CODE → PEN TEST**

**Context → Analyze → Attack → Verify**

And remember:

> **Security Agent doesn't just find vulnerabilities — it understands context and provides reproducible exploits.**
