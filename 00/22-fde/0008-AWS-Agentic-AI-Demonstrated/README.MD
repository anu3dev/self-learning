AWS Agentic AI Demonstrated — Practical + Exam Revision Notes

Course: AWS Skill Builder — AWS Agentic AI Demonstrated
Purpose: Practical understanding + exam/lab execution checklist
Core services: Amazon Cognito, Amazon Bedrock AgentCore, Guardrails, Gateway, Memory, Knowledge Bases, VPC

1. Big Picture — What Are We Building?

The lab builds a secure, production-style agentic AI application.

A simplified architecture is:

User
  |
  v
Chat Application
  |
  | OAuth 2.0 / JWT
  v
Amazon Cognito
  |
  v
AgentCore Orchestrator Runtime
  |
  +--------------------+
  |                    |
  v                    v
AgentCore Gateway   KB Specialist Runtime
  |                    |
  |                    v
  |              Knowledge Base
  |                    |
  |              OpenSearch Serverless
  |
  +--> Inventory Lambda
  +--> Supplier Lambda
  +--> Logistics Lambda
  +--> Quality Lambda

Additional controls:
--------------------
Guardrails
Memory
VPC / Private Endpoints
CloudWatch Logs
Why these components exist
Component	Why it exists
Cognito	Machine-to-machine authentication using OAuth 2.0
Orchestrator Runtime	Main agent that understands requests and coordinates tools
Gateway	Gives the agent controlled access to external tools/Lambda functions
Guardrails	Controls harmful, sensitive, or prohibited input/output
Memory	Allows the agent to remember user preferences/context
Knowledge Base	Provides grounded information from enterprise documents
KB Specialist Runtime	Specialized agent/runtime that queries the KB
VPC	Keeps runtime communication private
VPC Endpoints	Private access to AWS services without public internet paths
OpenSearch Serverless	Vector database used by the Knowledge Base
2. OAuth 2.0 Machine-to-Machine Authentication
Theory

For an application where another application/service, rather than a human user, needs to authenticate:

Application
    |
    | Client ID + Client Secret
    v
Cognito
    |
    | OAuth 2.0 Client Credentials
    v
Access Token
    |
    v
AgentCore Runtime

The appropriate OAuth flow is:

Client Credentials

This is commonly used for service-to-service authentication.

Why create a new App Client?

The default Cognito app client may not have the required:

Client secret
Client credentials grant
Required scopes

Therefore:

Cognito
 → User Pool
 → App clients
 → Create app client

Choose:

Application type = Machine-to-machine
Important

The client must have a:

Client Secret

The Client ID and Client Secret identify the calling application.

Configure OAuth scopes

Inside the newly created app client:

Login pages
 → Edit

Select:

Cognito User Pool
Client credentials
Custom scopes

Required scopes:

read
write
Why scopes?

Scopes limit what the access token is allowed to do.

Think:

Authentication = Who are you?
Authorization  = What are you allowed to do?

OAuth scopes provide the second part.

3. Configure AgentCore Runtime for Cognito

Go to:

Amazon Bedrock
 → AgentCore
 → Runtime
 → Orchestrator Runtime
 → Update
JWT configuration

Set:

Inbound auth type = JWT

Use the Cognito discovery URL:

https://cognito-idp.<region>.amazonaws.com/<USER_POOL_ID>/.well-known/openid-configuration

Example:

https://cognito-idp.us-east-1.amazonaws.com/us-east-1_xxxxx/.well-known/openid-configuration

Under:

JWT authorization configuration
 → Allowed clients

add the Cognito App Client ID.

Important distinction

Use:

Client ID

—not the app client name.

4. Orchestrator Environment Variables

The Orchestrator needs Cognito configuration.

COGNITO_CLIENT_ID
COGNITO_DOMAIN
COGNITO_USER_POOL_ID

Other existing environment variables may include:

GATEWAY_URL
GUARDRAIL_VERSION
KB_SPECIALIST_RUNTIME_ARN
MEMORY_ID
MODEL_ID

Typical model:

MODEL_ID = amazon.nova-pro-v1:0
5. Chat Application Configuration

The chat Lambda also needs Cognito and Orchestrator information.

Go to:

AWS Lambda
 → Functions
 → supply-chain-chat-<suffix>
 → Configuration
 → Environment variables

Set:

COGNITO_CLIENT_ID
COGNITO_DOMAIN
COGNITO_USER_POOL_ID
ORCHESTRATOR_RUNTIME_ARN
Important ARN rule

ORCHESTRATOR_RUNTIME_ARN is the runtime ARN only.

Correct:

arn:aws:bedrock-agentcore:us-east-1:ACCOUNT_ID:runtime/xxxxx

Incorrect:

arn:aws:bedrock-agentcore:us-east-1:ACCOUNT_ID:runtime/xxxxx/mcp

The /mcp suffix belongs to the Gateway URL, not the runtime ARN.

6. AgentCore Guardrails
Why Guardrails?

An agent can receive dangerous, inappropriate, or sensitive information.

Guardrails provide deterministic controls around model input/output.

Conceptually:

User Input
    ↓
Guardrail
    ↓
Agent / Model
    ↓
Guardrail
    ↓
Response
7. Create the Guardrail

Go to:

Amazon Bedrock
 → Guardrails
 → Create guardrail
Harmful content filters

Configure:

Category	Strength
HATE	HIGH
INSULTS	HIGH
MISCONDUCT	HIGH
VIOLENCE	HIGH

Apply blocking to:

Input
Output

For the lab, disable:

SEXUAL
8. Word Filter

Enable:

Managed profanity filter

Add custom blocked word/phrase:

Project Meridian

Apply to:

Input
Output
Why?

A word filter is useful when an organization has specific terms that must never appear in an interaction.

9. Sensitive Information

Configure:

USERNAME

Action:

ANONYMIZE / MASK

for:

Input
Output
PASSWORD

Action:

BLOCK

for:

Input
Output
Difference
Anonymize = hide the sensitive value

Block = reject the content
10. Custom Regex Guardrail

Create regex:

DISC-[A-Z]{3}-\d{4}

Example matches:

DISC-ABC-1234
DISC-XYZ-5678

Action:

ANONYMIZE / MASK

for input and output.

Why regex?

Regex is useful when an organization has a known structured identifier such as:

Employee ID
Case ID
Account ID
Internal reference
11. Connect Guardrail to Orchestrator

After creating the Guardrail:

AgentCore
 → Runtime
 → Orchestrator
 → Update
 → Environment variables

Set:

GUARDRAIL_ID = <Guardrail ID>

If already present:

GUARDRAIL_VERSION = DRAFT
12. AgentCore Gateway
What is Gateway?

Gateway provides a controlled interface between an agent and external tools.

Instead of allowing an agent to directly execute arbitrary functions:

Agent
  ↓
Gateway
  ↓
Approved Tool
  ↓
Lambda

This provides:

controlled tool access
standardized interface
authentication/authorization
tool schemas
easier governance
13. Gateway Targets

Go to:

Amazon Bedrock
 → AgentCore
 → Gateways
 → Gateway
 → Targets

Required targets:

inventory-target
supplier-target
logistics-target
quality-target

Each target maps to the appropriate Lambda.

14. Quality Target

Create:

quality-target

Use:

QualityLambdaArn

from Solution Resources.

For schema:

Define as S3 schema

Browse the provided schema:

quality_schema.json
Important exam rule

Never guess the Lambda ARN.

Use:

Solution Resources

and copy the exact ARN.

15. Logistics Target

For:

logistics-target

Edit the target and use:

LogisticsLambdaArn

from Solution Resources.

A common checker failure is:

The gateway target 'logistics-target' is not pointing to the correct Lambda function.

The fix is simply to compare the target's Lambda ARN with the current lab's LogisticsLambdaArn.

16. Gateway URL

After creating the Gateway, copy its resource URL.

The Orchestrator environment variable should be:

GATEWAY_URL
Important

The Gateway URL should include:

/mcp

Example:

https://xxxxx.gateway.bedrock-agentcore.us-east-1.amazonaws.com/mcp
Remember
GATEWAY_URL
        ↓
ends with /mcp

ORCHESTRATOR_RUNTIME_ARN
        ↓
does NOT end with /mcp
17. AgentCore Memory
Why Memory?

A stateless agent forgets previous interactions.

Memory allows the application to retain useful information such as:

user preferences
semantic information
conversation summaries

Architecture:

User
 ↓
Agent
 ↓
Memory
 ↓
Relevant previous information
18. Create Memory

Go to:

AgentCore
 → Memory
 → Create memory

Add the required long-term strategies.

Summary
supplychain/user/{actorId}/session/{sessionId}/summary
Semantic
supplychain/user/{actorId}/semantic
User Preferences
supplychain/user/{actorId}/preferences

These strategies represent different types of persistent information.

19. Memory ID

After creating Memory:

Copy Memory ID

Set it in the Orchestrator:

MEMORY_ID = <Memory ID>
Why?

The runtime needs to know which Memory resource it should use.

20. Test Memory

Open the supplied Chat Application.

Send something that establishes a preference, for example:

My name is Alex and I prefer detailed reports.

Wait approximately:

60 seconds

Then start/use a new session and ask:

How should you format my reports?

The purpose is to verify that the preference was persisted and retrieved.

Exam/lab lesson

Creating Memory is not enough.

You may need:

Create Memory
       ↓
Configure strategies
       ↓
Configure MEMORY_ID
       ↓
Create a record
       ↓
Wait for processing
       ↓
Test retrieval
21. VPC Networking
Why VPC?

Production workloads should avoid unnecessary public network exposure.

Instead of:

Runtime
   ↓
Public AWS endpoint

use:

Runtime
   ↓
Private subnet
   ↓
VPC Endpoint
   ↓
AWS Service
22. Required VPC Interface Endpoints

Create Interface endpoints for:

1. AgentCore Gateway
com.amazonaws.us-east-1.bedrock-agentcore.gateway
2. AgentCore Data Plane
com.amazonaws.us-east-1.bedrock-agentcore
3. Bedrock Runtime
com.amazonaws.us-east-1.bedrock-runtime
4. CloudWatch Logs
com.amazonaws.us-east-1.logs

S3 may already have a:

Gateway endpoint
23. Endpoint Configuration

For each interface endpoint:

VPC
    = Solution Resources VpcId

Subnets
    = Both PrivateSubnetIds

Security Group
    = Solution Resources SecurityGroupId

Private DNS
    = Enabled

Endpoint type:

Interface
Why Private DNS?

With Private DNS enabled, applications can use normal AWS service DNS names while traffic resolves through the private endpoint.

24. Update Orchestrator Runtime for VPC

Go to:

AgentCore
 → Runtime
 → Orchestrator
 → Update runtime
 → Advanced configuration
 → Security

Set:

Security = VPC
VPC = Solution Resources VpcId
Subnets = both PrivateSubnetIds
Security Group = Solution Resources SecurityGroupId
IP address type = IPv4

Wait for:

READY
25. Knowledge Base
Why a Knowledge Base?

LLMs have general knowledge, but enterprise applications need answers based on company-specific information.

A Knowledge Base implements the RAG pattern:

Documents
   ↓
Chunking
   ↓
Embeddings
   ↓
Vector Store
   ↓
Similarity Search
   ↓
Relevant Context
   ↓
LLM
   ↓
Grounded Answer
26. Create the Knowledge Base

Go to:

Amazon Bedrock
 → AgentCore
 → Knowledge Bases
 → Self-managed KB
 → Unstructured Vector Store KB
Important

For this lab, select:

Unstructured Vector Store KB

Do not accidentally choose a managed vector-store option if the lab expects the existing OpenSearch Serverless collection.

27. Knowledge Base Configuration
Name

Example:

supply-chain-knowledge-base
Service role

Choose the existing role:

KnowledgeBaseRole-<current-suffix>

The exact suffix changes between lab resets.

28. S3 Data Source

Select:

Amazon S3

Use the bucket from Solution Resources.

Example:

s3://supply-chain-knowledge-<suffix>/

Use:

Amazon Bedrock default parser
29. Embedding Model

Use:

amazon.titan-embed-text-v2:0
Why embedding?

Documents cannot be directly compared semantically as raw text.

The embedding model converts text into vectors:

"Supplier delivery delay"
          ↓
[0.12, -0.42, 0.81, ...]

Similar concepts produce vectors that are close to each other.

30. OpenSearch Serverless Vector Store

Select:

Use an existing vector store

Type:

Amazon OpenSearch Serverless

Then select the collection from Solution Resources/OpenSearch Serverless.

Important

Do not memorize the collection ARN.

The account, collection and ARN can change after a lab reset.

Always retrieve:

OpenSearch Serverless
 → Collections
 → kb-collection

and use the ARN shown in the current lab.

31. Existing Vector Index

Use:

bedrock-knowledge-base-index
Vector field
bedrock-kb-vector
Text field
AMAZON_BEDROCK_TEXT_CHUNK
Metadata field
AMAZON_BEDROCK_METADATA

These names must match the existing OpenSearch index mapping.

32. Why Field Mapping Matters

Think of the OpenSearch index as:

bedrock-knowledge-base-index
│
├── bedrock-kb-vector
│      └── embedding/vector
│
├── AMAZON_BEDROCK_TEXT_CHUNK
│      └── actual document text
│
└── AMAZON_BEDROCK_METADATA
       └── document metadata

If you provide the wrong field name, Bedrock cannot correctly write/query the vector data.

Common mistakes
❌ bedrock-knowledge-index
❌ bedrock-knowledge-base-default-vector

✅ bedrock-knowledge-base-index
✅ bedrock-kb-vector

Always inspect the existing index mapping if unsure.

33. Sync the Knowledge Base

After creating the KB:

Knowledge Base
 → Data source
 → Sync

Wait until:

Completed / Succeeded
Important

Creating the Knowledge Base does not automatically mean the documents are indexed.

The workflow is:

Create KB
   ↓
Create/select data source
   ↓
Sync
   ↓
Documents ingested
   ↓
Embeddings generated
   ↓
Vectors stored
34. KB Specialist Runtime

The KB Specialist Runtime is a specialized runtime whose job is to work with the Knowledge Base.

Create:

AgentCore
 → Runtime
 → Create runtime
Configuration
Runtime name:
kb_specialist_runtime

Compute:

microVMs

Source:

S3 Source

Choose:

Existing S3 bucket

Use:

KBSpecalistAgentCodeS3Uri

from Solution Resources.

35. Runtime Code Configuration

Language:

Python 3.11

Entry point:

main.py

IAM role:

KBSpecalistRuntimeRole-<current-suffix>

Again, use the role from the current lab.

36. KB Specialist Environment Variables

After creating the runtime:

AgentCore
 → Runtime
 → kb_specialist_runtime
 → Update/Edit
 → Environment variables

Set:

KNOWLEDGE_BASE_ID = <current Knowledge Base ID>
MODEL_ID = amazon.nova-lite-v1:0
Why?

The runtime needs:

KNOWLEDGE_BASE_ID
        ↓
Which KB should I query?

MODEL_ID
        ↓
Which model should process the request?
37. KB Specialist JWT Authentication

Set:

Inbound auth type = JWT

Configure:

Discovery URL

using the current Cognito User Pool.

Then add the:

Cognito App Client ID

under:

Clients
Important

Again:

Client ID ≠ Client Name

Use the actual generated client ID.

38. KB Specialist VPC Configuration

Update:

AgentCore
 → Runtime
 → kb_specialist_runtime
 → Update
 → Advanced configuration
 → Security

Set:

Security = VPC
VPC security = Managed
VPC = Solution Resources VpcId
Subnets = both PrivateSubnetIds
Security group = Solution Resources SecurityGroupId
IP address type = IPv4

Wait until:

READY
39. Connect KB Specialist to Orchestrator

The Orchestrator needs the specialist runtime ARN.

Go to:

AgentCore
 → Runtime
 → Orchestrator
 → Update
 → Environment variables

Set:

KB_SPECIALIST_RUNTIME_ARN
    = ARN of kb_specialist_runtime
Architecture
User
 ↓
Orchestrator
 ↓
KB Specialist Runtime
 ↓
Knowledge Base
 ↓
OpenSearch Serverless
 ↓
Relevant documents
 ↓
Answer
40. Final End-to-End Architecture

After everything is configured:

                         ┌─────────────────┐
                         │      User       │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │ Chat Application│
                         └────────┬────────┘
                                  │
                         OAuth 2.0 / JWT
                                  │
                                  ▼
                         ┌─────────────────┐
                         │    Cognito      │
                         └────────┬────────┘
                                  │
                                  ▼
                    ┌─────────────────────────┐
                    │ AgentCore Orchestrator  │
                    │       Runtime           │
                    └───────┬─────┬───────────┘
                            │     │
              ┌─────────────┘     └──────────────┐
              ▼                                  ▼
      ┌──────────────┐                  ┌─────────────────┐
      │   Gateway    │                  │ KB Specialist   │
      └──────┬───────┘                  │    Runtime      │
             │                          └────────┬────────┘
     ┌───────┼────────┐                         │
     ▼       ▼        ▼                         ▼
 Inventory Supplier Logistics              Knowledge Base
 Lambda   Lambda   Lambda                       │
                                                 ▼
                                         OpenSearch Serverless

      Guardrails ───────► Input/Output protection
      Memory ───────────► User preferences/context
      VPC ──────────────► Private connectivity
41. Exam/Lab Execution Order

This is the most important practical checklist.

When starting a fresh lab/reset, follow this order:

1. Cognito M2M App Client
        ↓
2. Orchestrator JWT configuration
        ↓
3. Orchestrator Cognito environment variables
        ↓
4. Guardrail
        ↓
5. Gateway + targets
        ↓
6. Gateway URL in Orchestrator
        ↓
7. Memory + strategies
        ↓
8. MEMORY_ID in Orchestrator
        ↓
9. Knowledge Base
        ↓
10. KB data source sync
        ↓
11. KB Specialist Runtime
        ↓
12. KNOWLEDGE_BASE_ID
        ↓
13. KB Specialist JWT
        ↓
14. KB Specialist VPC
        ↓
15. KB_SPECIALIST_RUNTIME_ARN in Orchestrator
        ↓
16. VPC endpoints
        ↓
17. Orchestrator VPC
        ↓
18. Test Chat Application
        ↓
19. Run challenge checkers
42. High-Value Checker Failures and Fixes
COGNITO_USER_POOL_ID missing

Add to Orchestrator:

COGNITO_USER_POOL_ID
COGNITO_CLIENT_ID missing

Add:

COGNITO_CLIENT_ID

Use the current M2M App Client ID.

COGNITO_DOMAIN missing

Add:

COGNITO_DOMAIN

from the current Cognito User Pool.

Runtime has no JWT authorizer

Configure:

Inbound auth type = JWT
Discovery URL = Cognito discovery URL
Clients = Cognito App Client ID
KB Specialist missing KNOWLEDGE_BASE_ID

Add:

KNOWLEDGE_BASE_ID = current KB ID
KB Specialist is UPDATING

Do nothing.

Wait:

UPDATING
   ↓
READY

Then rerun the checker.

Data source not synced

Go:

Knowledge Base
 → Data source
 → Sync

Wait for successful completion.

Orchestrator missing KB specialist ARN

Add:

KB_SPECIALIST_RUNTIME_ARN

with the ARN copied from the current specialist runtime.

Gateway target points to wrong Lambda

Do not guess.

Go to:

Solution Resources

Copy the appropriate:

QualityLambdaArn
LogisticsLambdaArn
InventoryLambdaArn
SupplierLambdaArn

and compare with the Gateway target.

Chat error involving /mcp

Remember:

GATEWAY_URL
       → includes /mcp

ORCHESTRATOR_RUNTIME_ARN
       → does NOT include /mcp
43. Critical "Do Not Guess" Rule

In these labs, many values change after a reset.

Do NOT memorize:
Account ID
User Pool ID
Client ID
Client Secret
Gateway ID
Gateway ARN
Runtime ARN
Knowledge Base ID
Lambda ARN
S3 bucket suffix
IAM role suffix
VPC ID
Subnet IDs
Security Group ID
OpenSearch collection ARN

Instead:

Solution Resources
        ↓
Copy current value
        ↓
Paste into configuration
Values that are generally stable within this lab design
amazon.titan-embed-text-v2:0
amazon.nova-lite-v1:0
amazon.nova-pro-v1:0

bedrock-knowledge-base-index
bedrock-kb-vector
AMAZON_BEDROCK_TEXT_CHUNK
AMAZON_BEDROCK_METADATA

quality-target
logistics-target
inventory-target
supplier-target

Even these should be verified against the task when possible.

44. RAG — Theory for Exam

RAG = Retrieval-Augmented Generation

Instead of:

Question → LLM → Answer

we use:

Question
   ↓
Embedding
   ↓
Vector Search
   ↓
Relevant Documents
   ↓
Prompt + Retrieved Context
   ↓
LLM
   ↓
Grounded Answer
Why RAG?

LLMs may:

hallucinate
lack current company information
lack private enterprise information

RAG supplies authoritative context at runtime.

45. Chunking — Important Exam Concept

Bad:

Huge document
      ↓
One giant vector

Better:

Document
 ↓
Semantic chunks
 ↓
Small overlap
 ↓
Embeddings
Why overlap?

Suppose a sentence starts at the end of one chunk and continues into the next.

Without overlap:

Chunk 1 → "The supplier must submit..."
Chunk 2 → "...documents within 30 days."

Context may be lost.

With modest overlap, important clauses remain together.

Exam answer pattern

Chunk on semantic boundaries with a modest overlap.

46. Metadata Filtering

Suppose:

User A → Finance documents
User B → HR documents

Do not retrieve everything and tell the LLM:

"Ignore documents the user isn't allowed to see."

Instead enforce authorization before retrieval:

User entitlement
      ↓
Metadata filter
      ↓
Vector search
      ↓
Authorized documents only
Exam answer

Apply metadata filters in the vector store query using the user's entitlements.

This is a major security principle.

47. Hallucination Control

If retrieval returns nothing relevant:

Bad
LLM → invent answer
Better
Relevance threshold
        ↓
No sufficiently relevant result
        ↓
Explicit fallback
        ↓
"I couldn't find this in the knowledge base."
Exam pattern

Use a relevance threshold with an explicit fallback when the answer is not in the knowledge base.

48. Agentic AI vs Normal Automation

Use an agent when the task:

has variable inputs
requires reasoning/judgment
may require different tools
has dynamic execution paths

Example:

User:
"Why was shipment X delayed and what supplier alternatives do we have?"

Agent may:

1. Query shipment tool
2. Query supplier tool
3. Analyze results
4. Decide what additional tool is needed
5. Produce recommendation

A fixed workflow might be better when:

Input → Step A → Step B → Step C → Output

with no meaningful variation.

Exam answer

Use an agent when the task has variable inputs, requires judgment, and benefits from dynamic tool selection.

49. Tool Calling

Reliable tool usage depends on:

Clear tool descriptions
        +
Explicit system policy
        +
Well-defined tool schemas

For critical operations:

Agent
 ↓
Policy check / Human approval
 ↓
Write action

Especially for:

refunds
deletes
financial transactions
irreversible changes
Principle

The model should not be the only security control.

50. Agent Evaluation

LLM output is non-deterministic.

Therefore don't test only:

Expected exact sentence

Instead test:

Scenario
 ↓
Agent
 ↓
Tool trace
 ↓
Outcome
 ↓
Expected behavior

Use:

scenario-based tests
tool-call validation
regression tests
task-specific metrics
representative internal evaluation datasets
51. Production Rollout

Don't immediately:

PoC → 100% users

Better:

Limited users
      ↓
Monitor
      ↓
Collect feedback
      ↓
Evaluate
      ↓
Rollback if necessary
      ↓
Expand rollout

This reduces production risk.

52. Agent Approval

Human approval is appropriate for:

High-impact
        +
Irreversible
        +
Financial
        +
Sensitive

actions.

Example:

Agent wants to issue $10,000 refund
             ↓
Human approval
             ↓
Execute

Do not require approval for every harmless read-only lookup; otherwise the system becomes unnecessarily cumbersome.

53. Token Cost Optimization

For large repeated instructions:

Stable prompt/context
        ↓
Prompt/context caching

Also:

monitor token usage
reuse stable context
set sensible limits
avoid unnecessarily huge prompts
Key idea

AI systems need cost controls just like traditional cloud systems.

54. Memory vs Knowledge Base

Very important distinction:

Memory

Stores information about:

User
Conversation
Preferences
Past interactions

Example:

User prefers detailed reports.
Knowledge Base

Stores/retrieves:

Enterprise documents
Policies
Manuals
Product information
Business knowledge

Example:

Company refund policy says...

Think:

Memory = What do I remember about YOU?

Knowledge Base = What do I know from COMPANY DOCUMENTS?
55. Guardrails vs IAM

These are different.

IAM

Controls:

WHO can access WHAT AWS resource.
Guardrail

Controls:

WHAT content/actions are allowed through the AI interaction.

Example:

IAM → Can this runtime access Lambda?

Guardrail → Can this sensitive content be passed/generated?

You generally need both in a production AI system.

56. Gateway vs VPC Endpoint

Also different.

Gateway

Controls:

Agent → Tool
VPC Endpoint

Controls:

Runtime → AWS service network path

So:

Gateway = tool access layer

VPC Endpoint = private network connectivity
57. Final Exam Memory Sheet

If you have only 2 minutes before the lab, remember this:

COGNITO
--------
M2M
Client secret
Client credentials
read + write scopes
Client ID → JWT clients
Discovery URL → Cognito

ORCHESTRATOR
------------
COGNITO_CLIENT_ID
COGNITO_DOMAIN
COGNITO_USER_POOL_ID
GATEWAY_URL
GUARDRAIL_ID
MEMORY_ID
KB_SPECIALIST_RUNTIME_ARN

GUARDRAIL
---------
HATE HIGH
INSULTS HIGH
MISCONDUCT HIGH
VIOLENCE HIGH
Project Meridian → block
Profanity → enabled
USERNAME → anonymize
PASSWORD → block
DISC-[A-Z]{3}-\d{4} → anonymize

GATEWAY
-------
inventory-target
supplier-target
logistics-target
quality-target

GATEWAY_URL → /mcp

MEMORY
------
summary
semantic
preferences
MEMORY_ID
test → wait → retrieve

KNOWLEDGE BASE
--------------
Unstructured Vector Store KB
S3
Titan Embed v2
OpenSearch Serverless
bedrock-knowledge-base-index
bedrock-kb-vector
AMAZON_BEDROCK_TEXT_CHUNK
AMAZON_BEDROCK_METADATA
SYNC

KB SPECIALIST
-------------
kb_specialist_runtime
microVM
S3 source
Python 3.11
main.py
KNOWLEDGE_BASE_ID
amazon.nova-lite-v1:0
JWT
VPC
READY

VPC
---
AgentCore Gateway endpoint
AgentCore endpoint
Bedrock Runtime endpoint
CloudWatch Logs endpoint
Private DNS ON
Private subnets
Same Security Group
Orchestrator → VPC
KB Specialist → VPC
58. Most Important Mental Model

The whole lab can be remembered as:

AUTHENTICATE
     ↓
COGNITO + JWT
     ↓
ORCHESTRATE
     ↓
AgentCore Runtime
     ↓
 ┌───────────────┬────────────────┐
 ↓               ↓                ↓
TOOLS           MEMORY           RAG
 ↓               ↓                ↓
Gateway         Preferences      KB
 ↓                                ↓
Lambdas                       OpenSearch
     \            |             /
      \           |            /
       └────── GUARDRAILS ────┘
                 ↓
             Safe Answer
                 ↓
              User

Everything runs through:
        VPC / Private Connectivity

The key production principle: don't treat the LLM as the security boundary. Authentication, authorization, network isolation, tool controls, guardrails, retrieval filtering, human approval, monitoring, and evaluation all contribute separate layers of protection.