# AWS AI Practitioner (AFC01) — Final Consolidated Revision Notes ✅

> **Status:** AFC01 Cleared  
> **Purpose:** One definitive, non-repetitive, exam + interview ready reference  
> **Audience:** Long-term revision, future AWS certs, AI interviews  

---

## 1. Web & Server Fundamentals

### How a Website Works
Client → network → server → response (HTML / JSON)

**Analogy:** Letter → post office → reply

### Server Components
- Hardware: CPU, RAM, Disk
- OS: Resource management
- Web Server: Request handling
- App: Business logic
- Database: Persistent storage

---

## 2. Cloud Computing Basics

### 2.1 What Is Cloud Computing?
Cloud computing is renting computing power instead of owning it. You get servers, storage, databases, and AI services on demand — paying only for what you use. Like using Uber instead of maintaining your own car fleet.

### 2.2 Cloud Service Models

#### IaaS (Infrastructure as a Service)
You rent raw virtual machines, storage, and networks. You install OS and applications.  
Like renting land: you build everything on top.  
Examples: EC2, GCE, Azure VM.

#### PaaS (Platform as a Service)
You bring only your code. The platform manages OS, runtime, middleware.  
Like renting a ready-made shop — just start operating.  
Examples: Google App Engine, Azure App Service.

#### SaaS (Software as a Service)
Fully finished software delivered through browser. No maintenance.  
Like walking into a restaurant — everything is ready.  
Examples: Gmail, Salesforce.

#### FaaS (Function as a Service)
Upload small functions; they run only when triggered.  
Like a food truck that opens only when customers arrive.  
Examples: AWS Lambda.

---

## 3. Cloud Responsibility Matrix

| Component | On-Prem | IaaS | PaaS | SaaS |
|----------|---------|------|------|------|
| Apps | You | You | You | Provider |
| Data | You | You | You | Provider |
| Runtime | You | You | Provider | Provider |
| Middleware | You | You | Provider | Provider |
| OS | You | You | Provider | Provider |
| Virtualization | You | Provider | Provider | Provider |
| Servers | You | Provider | Provider | Provider |
| Storage | You | Provider | Provider | Provider |
| Networking | You | Provider | Provider | Provider |
---

## 4. Cloud Deployment Models

### 4.1 Public Cloud
Shared cloud infrastructure like a shopping mall with many tenants. Examples: AWS, Azure, GCP.

### 4.2 Private Cloud
Dedicated infrastructure for one company. Like owning your own mall.

### 4.3 Hybrid Cloud
Mix of on-prem + cloud. Like running a home office + coworking space.

### 4.4 Multi-cloud
Use multiple providers at once. Like sourcing materials from multiple vendors.

---

## 5. Cloud Characteristics (NIST)

- On-demand self-service
- Broad network access
- Resource pooling
- Rapid elasticity
- Measured service

---

## 6. AI, ML & GenAI Core Concepts

### Hierarchy
AI → ML → Deep Learning → Generative AI

### Learning Types
- **Supervised:** Labeled data
- **Unsupervised:** Unlabeled data
- **Self-supervised:** Labels generated from data itself  
- **Reinforcement:** Rewards & penalties

---

## 7. Foundation Models (FM)

> **Foundation Models use self-supervised learning**

- Pre-trained on massive **unlabeled data**
- Adaptable to many tasks
- Fine-tuned using **supervised learning** with labeled data

### Model Types
- **LLM:** Text-focused FM
- **Multimodal:** Text + image + audio
- **Diffusion:** Image generation via noise removal
- **GAN:** Generator vs Discriminator

---

## 8. Amazon Bedrock

### What It Is
Fully managed access to Foundation Models via API.  
**No infrastructure management.**

### Pricing
- On-Demand
- Provisioned Throughput (**required for custom models**)

### Key Concepts
- Guardrails (safety, PII, toxicity)
- Agents (action-taking workflows)
- Model selection based on cost, latency, reasoning, creativity

### Models Available
- Amamzon comprehend

---

## 9. Retrieval-Augmented Generation (RAG)

### What RAG Solves
Reduces hallucination by injecting retrieved data into prompts.

**Analogy:** AI librarian

### Data Sources
PDFs, docs, websites, databases

---

## 10. Prompt Engineering & Inference

### Prompt Structure
Instruction + Context + Input + Output format

### Prompting Techniques
- Zero-shot
- Few-shot
- Chain-of-thought
- Role prompting

### Generation Parameters
- **Temperature:** randomness
- **Top-K:** token restriction
- **Top-P:** probability threshold
- **Max Length:** output size

> These affect creativity, **not latency**

---

## 11. Embeddings

- Numeric vector representation of meaning
- Used for search, clustering, RAG, recommendations

---

## 12. Model Fit & Generalization

- **Underfitting:** High bias
- **Overfitting:** High variance
- **Regularization:** Controls complexity
- **Cross-validation:** Tests generalization

---

## 13. Metrics (Exam Critical)

### Classification
- Accuracy
- Precision
- Recall
- F1 Score

### Regression
- MAE
- MSE
- RMSE
- R²

### NLP Evaluation
- **ROUGE:** Lexical overlap
- **BERTScore:** Semantic similarity

---

## 14. Responsible AI & Risks

### Principles
Fairness, Transparency, Accountability, Privacy, Security

### Risks
Hallucination, bias, prompt injection, data leakage, poisoning

---

## 15. AWS AI / ML Services (Clean List)

- Bedrock — Foundation Models
- SageMaker — Build/train/deploy ML
- Comprehend — NLP
- Rekognition — Image/video analysis
- Lex — Chatbots
- Transcribe — Speech to text
- Polly — Text to speech
- Translate — Language translation
- Textract — Forms & tables
- Kendra — Enterprise search
- Personalize — Recommendations
- Mechanical Turk — Human labeling
- A2I — Human review
- Macie — PII detection in S3

---

## 16. SageMaker — Core Components

- Studio (IDE)
- JumpStart
- Ground Truth
- Clarify (bias & explainability)
- Model Monitor (drift)
- Pipelines (CI/CD)
- Autopilot (AutoML)
- Canvas (no-code)

---

## 17. Security, Governance & Compliance

- **IAM:** Access control
- **CloudTrail:** API audit (who did what, when)
- **CloudWatch:** Metrics & logs
- **AWS Config:** Configuration compliance (NOT vulnerability scanning)
- **Amazon Inspector:** Vulnerability scanning
- **AWS Macie:** PII detection in S3
- **AWS Artifact:** Compliance reports
- **AWS Audit Manager:** Evidence automation
- **Trusted Advisor:** Best practices

---

## 18. ML Lifecycle

Data → Prep → Feature Engineering → Training → Evaluation → Deployment → Monitoring

---

## 19. Amazon Q (Consolidated)

Built **on Amazon Bedrock**

### Variants
- Q Developer — Code, IDE help
- Q Business — Enterprise chat (permissions respected)
- Q Console — AWS explanations
- Q Apps — Dashboards & MVPs
- Q in QuickSight — BI insights

---

## 20. AWS Global Infrastructure

- Region → multiple AZs
- AZ → isolated data centers

---

## 21. High-Yield Exam Nuggets

- Inference = prediction/output
- Smaller models = cheaper & faster
- Provisioned Throughput = reserved capacity
- F1 balances precision & recall
- Data lineage tracks origin
- Dimensionality reduction prevents overfitting
- Tokens = smallest text units

---

## 22. Transformers (Core DL Model)

- Self-attention
- Context-aware embeddings
- Backbone of LLMs
- Fine-tuned using **RLHF**

---

## 23. Feature Engineering

- Creating, transforming, selecting input features
- Applies to structured & unstructured data

---

## 24. Classification Types

- Multiclass → exactly one label
- Multilabel → multiple labels

---

## 25. EXAM-ONLY ADDITIONS (You Had Not Explicitly Listed)

### ❗ Cold Start
Latency when serverless / models spin up after inactivity.

### ❗ Data Drift vs Concept Drift
- Data drift → input data changes
- Concept drift → relationship changes

### ❗ Human-in-the-Loop
Used when:
- Low confidence predictions
- Regulatory decisions
- Bias-sensitive systems

---

## 26. One-Page Mental Model (Final)

- FM → unlabeled + self-supervised
- Fine-tuning → supervised
- Bedrock → FM access without infra
- RAG → retrieval + generation
- Guardrails → safety + PII + policy
- Smaller models → cost efficient
- Custom Bedrock models → provisioned throughput

---
