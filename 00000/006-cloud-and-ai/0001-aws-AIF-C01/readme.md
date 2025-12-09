# AWS AI Practitioner — Story-Based Complete Revision Guide

# 1. Web & Server Fundamentals

## 1.1 How a Website Works
A client (your device) sends a request through the network to a server, which processes it and sends back a webpage or API response. Think of it like posting a letter: you send a message, the postal system routes it, and the destination replies.

## 1.2 What a Server Is Made Of
A server is like a mini-city. Hardware (CPU, RAM, disks) are the buildings, the OS is city management, web server software is the receptionist handling requests, databases store records, and applications perform the work asked by users.

---

# 2. Cloud Computing Basics

## 2.1 What Is Cloud Computing?
Cloud computing is renting computing power instead of owning it. You get servers, storage, databases, and AI services on demand — paying only for what you use. Like using Uber instead of maintaining your own car fleet.

## 2.2 Cloud Service Models

### IaaS (Infrastructure as a Service)
You rent raw virtual machines, storage, and networks. You install OS and applications.  
Like renting land: you build everything on top.  
Examples: EC2, GCE, Azure VM.

### PaaS (Platform as a Service)
You bring only your code. The platform manages OS, runtime, middleware.  
Like renting a ready-made shop — just start operating.  
Examples: Google App Engine, Azure App Service.

### SaaS (Software as a Service)
Fully finished software delivered through browser. No maintenance.  
Like walking into a restaurant — everything is ready.  
Examples: Gmail, Salesforce.

### FaaS (Function as a Service)
Upload small functions; they run only when triggered.  
Like a food truck that opens only when customers arrive.  
Examples: AWS Lambda.

---

# 3. Cloud Responsibility Matrix

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

# 4. Cloud Deployment Models

## 4.1 Public Cloud
Shared cloud infrastructure like a shopping mall with many tenants. Examples: AWS, Azure, GCP.

## 4.2 Private Cloud
Dedicated infrastructure for one company. Like owning your own mall.

## 4.3 Hybrid Cloud
Mix of on-prem + cloud. Like running a home office + coworking space.

## 4.4 Multi-cloud
Use multiple providers at once. Like sourcing materials from multiple vendors.

---

# 5. Cloud Characteristics

## 5.1 Five Key Characteristics
- On-demand self-service  
- Broad network access  
- Resource pooling  
- Rapid elasticity  
- Measured service  

## 5.2 Six Advantages
Cost savings, scalability, global reach, disaster recovery, automatic updates, fast innovation.

---

# 6. Generative AI Concepts

## 6.1 What Is Generative AI?
Models that create new content (text, images, audio). Like an artist trained on millions of samples.

## 6.2 Foundation Models (FMs)
Large models pre-trained on huge datasets and adaptable to many tasks. Like universal engines.

## 6.3 Large Language Models (LLMs)
Foundation models focused on text — chat, Q&A, translation, summarization.

## 6.4 GLMs
LLMs optimized specifically for generating text.

## 6.5 Diffusion Models
Generate images by gradually turning noise into structure. Like fog clearing into a painting.

## 6.6 Multi-Modal Models
Understand text + images + audio. Like a person who can analyze everything together.

---

# 7. Amazon Bedrock

## 7.1 What Is Bedrock?
A managed service providing access to FMs (Claude, Titan, Llama) without infra. A library of AI engines.

## 7.2 Pricing
- On-demand → pay per request  
- Provisioned Throughput → reserve model capacity  

## 7.3 Choosing Models
Pick models based on creativity, reasoning, cost, multilingual needs, and latency.

---

# 8. Retrieval-Augmented Generation (RAG)

## 8.1 What Is RAG?
RAG retrieves relevant info from your documents and feeds it to a model, reducing hallucinations. Like an AI librarian.

## 8.2 Data Sources
PDFs, text docs, websites, knowledge bases, structured data — anything embed-able.

---

# 9. AI/ML Basics

## 9.1 AI → ML → DL → GenAI
AI is the goal, ML is the method, DL is complex neural networks, GenAI is the creative output stage.

## 9.2 ML Learning Types
- Supervised → learns from labeled examples  
- Unsupervised → finds patterns without labels  
- Reinforcement Learning → learns by reward/punishment  

---

# 10. Prompt Engineering & Embeddings

## 10.1 What Are Embeddings?
Turn text/images into numeric vectors capturing meaning. A semantic map where similar ideas sit close together.

## 10.2 Prompt Engineering Basics
A good prompt = Instruction + Context + Input + Output format.

## 10.3 Prompt Techniques
- Zero-shot  
- Few-shot  
- Chain-of-thought  
- Role prompting  

## 10.4 Generation Parameters (Important!)

### Temperature
Controls randomness.  
Low → factual; High → creative.

### Top-K
Chooses next token from top K probable tokens.  
Low K → focused; High K → creative.

### Top-P (Nucleus Sampling)
Chooses tokens until cumulative probability reaches p.  
Low p → strict; High p → flexible.

### Max Length
Caps output token size (short vs long response).

> Exam Tip: These affect creativity, not latency.

---

# 11. Responsible AI Principles
Fairness, Reliability, Privacy, Transparency, Accountability — the five safety pillars of AI behavior.

---

# 12. AI Risks & Misuse
Prompt injection, data leakage, hallucination, bias, model poisoning. Attackers may manipulate prompts; guardrails protect systems.

---

# 13. AWS AI/ML Services

## 13.1 Amazon Bedrock
Access foundation models for text, image, and agents.

## 13.2 Amazon SageMaker
End-to-end ML platform.

## 13.3 Amazon Comprehend
NLP tasks: sentiment, entities, PII.

## 13.4 Amazon Rekognition
Image/video detection.

## 13.5 Amazon Lex
Conversational chatbots.

## 13.6 Amazon Transcribe
Speech-to-text.

## 13.7 Amazon Polly
Text-to-speech.

## 13.8 Amazon Translate
Language translation.

## 13.9 Amazon Textract
Extract text/tables/forms from docs.

## 13.10 Amazon Kendra
Enterprise search.

## 13.11 Amazon Personalize
Personalized recommendations.

## 13.12 Amazon Ground Truth
Data labeling.

## 13.13 Amazon Mechanical Turk
Crowdsourcing human tasks.

## 13.14 Amazon A2I
Human review workflows for ML predictions.

---

# 14. Amazon SageMaker Components

## 14.1 JumpStart
Pretrained models + fine-tuning templates.

## 14.2 Clarify
Bias detection + explainability.

## 14.3 Ground Truth
Data labeling pipelines.

## 14.4 Model Monitor
Detects drift.

## 14.5 Pipelines
ML CI/CD automation.

## 14.6 Model Registry
Model versioning & governance.

## 14.7 Canvas
No-code ML tool.

## 14.8 Studio
Full ML IDE in the browser.

---

# 15. AWS Security & Compliance Tools

## IAM
Identity & access control.

## Macie
Detect PII in S3.

## Inspector
Vulnerability scanning.

## Config
Resource configuration compliance.

## CloudTrail
Logs API calls.

## Artifact
Download compliance reports (SOC, ISO, PCI).

## Audit Manager
Automate audit evidence collection.

## Trusted Advisor
Best-practice recommendations.

---

# 16. AWS Compute & Storage
- S3 → object storage  
- EC2 → virtual machines  
- Lambda → serverless compute  

---

# 17. GANs
GANs train a generator and discriminator in competition to create realistic synthetic data.

---

