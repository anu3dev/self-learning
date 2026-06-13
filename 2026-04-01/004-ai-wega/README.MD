# 📦 WEGA PLATFORM

---

## 🔹 What is WEGA

* Enterprise-wide **AI-driven build platform**
* Covers:

  * SDLC
  * Product lifecycle
* Works across:

  * Digital engineering
  * Cloud
  * Data & AI
  * Enterprise apps

---

## 🔹 WEGA Core Concept

👉 **WEGA Marketplace**

* Collection of:

  * Agents
  * Assistants
  * Tools
* Includes:

  * Wipro tools
  * Third-party tools ✅ (important from test)

---

## 🔹 WEGA Coverage (Project Archetypes)

* Digital Software Engineering
* Data & AI
* Enterprise Applications
* Cloud Migration & Modernization
* Product Engineering

---

## 🔹 WEGA Access Methods (TEST IMPORTANT)

* MS365 Copilot
* IDE plugins
* CLI
* Workbench / UI

❌ NOT limited to browser/mobile

---

## 🔹 WEGA Variants

* AWS
* Azure
* GCP
* NVIDIA

---

## 🔹 WEGA Agents Ecosystem

* 128+ agents
* Cover:

  * Planning
  * Design
  * Development
  * Testing
  * Deployment
  * Monitoring

---

## 🔹 WEGA Periodic Table

👉 Purpose:

* Organize agents **by lifecycle stage**

Categories:

* Planning
* Analysis
* Build
* Test
* Deploy
* Reliability
* Security
* Governance
* AI
* Data

---

## 🔹 WEGA Architecture (Detailed)

```
Personas (PM / Dev / QA / Architect)
        ↓
Consumption Layer (API / IDE / UI)
        ↓
Integration Layer
        ↓
WEGA Agent Platform
   - Tools
   - Orchestration
   - Knowledge Graph
   - Observability
        ↓
AI Core
   - LLMs
   - Vector DB
   - Custom Models
        ↓
Infrastructure
   - AWS / Azure / GCP / On-prem
```

---

## 🔹 Deployment Patterns

* Wipro hosted
* Client hosted
* ODC hosted

❌ NOT mobile hosted (test)

---

## 🔹 Adoption Flow (TEST IMPORTANT)

```
Approval (GBL + ADI)
↓
Training (WILearn)
↓
Deployment (FDE + Champions)
↓
Scaling
```

---

## 🔹 FDE (Forward Deployment Engineers)

* Work with account teams
* Not external-only ❌
* Customize deployment

---

## 🔹 Benefits (MEMORIZE)

* 8–12% → requirement accuracy
* 15–20% → design efficiency
* 20–25% → dev speed
* 20–25% → deployment speed
* 15–20% → code quality

---

## 🔹 Why WEGA

* Breadth → many tools
* Depth → Wipro expertise
* Choice → flexible ecosystem

---

## 🚨 MODULE 1 – IMPORTANT POINTS

* Marketplace = core concept
* Periodic table = lifecycle mapping
* FDE ≠ external only
* Third-party tools supported
* Adoption flow sequence important
* Benefits % can be asked

---

## 🔹 WEGA Studio

* Accelerator platform for GenAI
* Provides:

  * Security
  * Transparency (Explainability)
  * Guardrails
  * Content moderation
  * Performance tuning
  * Data engineering

---

## 🔹 End-to-End GenAI Flow

```
Data
↓
Chunker
↓
Embeddings
↓
Vector DB
↓
Query Rephraser
↓
Retriever
↓
Guardrails
↓
LLM
↓
Cache
↓
Quality Analyzer
```

---

## 🔹 Responsible AI Risks

* Hallucination
* Transparency issues
* Data privacy
* Safety (prompt injection)
* Security
* Evaluation

---

# 🔥 CORE ACCELERATORS

---

## 🔹 1. Chunker

### Why Needed

| Problem        | Solution          |
| -------------- | ----------------- |
| Token limits   | Split data        |
| Context loss   | Semantic chunking |
| Poor retrieval | Logical splits    |
| Hallucination  | Focused input     |

---

### Types

* Fixed
* Semantic ✅
* Sliding window
* Sentence

---

### Chunking Flow

```
Document
↓
Layout Analysis
↓
Chunking
↓
Embedding
↓
Vector DB
```

---

### Table Handling

```
Analyze → Normalize → Flatten → Store
```

---

## 🔹 2. Query Rephraser

### Flow

```
User Query + History
↓
Rephraser
↓
Structured Query
↓
Vector DB
↓
LLM
```

---

### Purpose

* Improve clarity
* Add context
* Better retrieval

❌ Does NOT reduce token limits

---

## 🔹 3. Cache

### Flow

```
Query → Embedding → Compare
        ↓
Match → Cached response
No Match → LLM → Store
```

---

### Concept

👉 Semantic caching

* Based on meaning
* Not exact match

---

### Benefits

* Low latency
* Cost reduction
* Scalability

---

## 🔹 4. DataBuilder

### Flow

```
Seed Data
↓
Prompt Augmentation
↓
Question Generation
↓
LLM
↓
Ground Truth
↓
Evaluation
```

---

### Purpose

* Create datasets
* Reduce manual effort

---

## 🔹 5. Quality Analyzer

### Metrics

#### Response

* Correctness
* Relevance
* Faithfulness
* Hallucination

#### RAG

* Precision
* Recall
* Relevance

#### Responsible AI

* Bias
* Toxicity
* Prompt injection

---

## 🔹 Industry Use Cases

* BFSI → risk analysis
* Manufacturing → predictive maintenance
* Healthcare
* Retail
* Telecom

---

## 🚨 MODULE 2 – IMPORTANT POINTS

* Chunking = semantic (not split)
* Cache = semantic (not key-value)
* Rephraser = context-aware
* DataBuilder = ground truth generation
* QA = multi-metric evaluation
* Table flattening important

---

## 🔹 LLM Improvement Strategy

| Type      | Use              |
| --------- | ---------------- |
| Prompt    | quick fix        |
| Fine-tune | improve accuracy |
| Custom    | domain-specific  |

---

## 🔹 Decision Flow

```
Small issue → Prompt
Partial accuracy → Fine-tune
Domain-specific → Custom
```

---

## 🔹 Open Source vs Proprietary

### Open Source

* Full control
* Customizable
* Needs infra

### Proprietary

* Fast
* API-based
* Less control

---

## 🔹 Vector Database

### Tools

* Milvus
* Pinecone
* Weaviate
* Qdrant
* Chroma

---

### Role

* Store embeddings
* Similarity search

---

### Why Milvus

* Scalable
* Separate compute/storage

---

## 🔹 Embeddings

```
Text → Vector → Similarity
```

👉 Quality depends on **NDCG**

---

## 🔹 Guardrails

### Applied at:

* Query
* Retrieval
* Response

---

### Types

* Domain
* Safety
* Security

---

## 🔹 RAG + WEGA

```
Data
↓
Chunker
↓
Embedding
↓
Vector DB
↓
Rephraser
↓
Retriever
↓
Guardrails
↓
LLM
↓
Cache
↓
Quality Analyzer
```

---

## 🔹 LLMOps

```
Data → Model → Train → Test → Deploy → Monitor → Optimize
```

---

## 🔹 Agentic AI

### Levels

* Assisted
* Agentic
* Autonomous

---

### Capabilities

* Planning
* Execution
* Learning
* Memory

---

## 🚨 MODULE 3 – IMPORTANT POINTS

* Fine-tuning ≠ training from scratch
* Open source ≠ free (infra cost)
* Vector DB ≠ normal DB
* Guardrails applied everywhere
* Embedding quality > dimension

---

# 🚨 FINAL MASTER SUMMARY

👉 WEGA = End-to-end GenAI platform

👉 Pipeline:

```
Data → Chunker → Embeddings → Vector DB
→ Rephraser → LLM → Cache → Quality Analyzer
```

👉 Core:

* Chunker → context
* Rephraser → query
* Cache → speed
* QA → evaluation

👉 Key Concepts:

* Semantic chunking
* Semantic caching
* RAG pipeline
* Responsible AI

---
