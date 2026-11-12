# AWS Certified Generative AI Developer – Professional
## Last-Week Quick Revision Notes

**Goal:** exam next week. This is the fast-revision companion to `AWS_GenAI_Developer_Professional_7_Papers_Master_Notes.md`, which retains all 525 questions and their original explanations from the seven uploaded papers.

> Use this document for fast concept recall. Use the master notes for every question's exact wording, all options, and the complete rationale. Do not study answer letters alone.

## 1. Solve scenario questions by identifying the stage

```text
Source data -> ingestion/chunking -> embeddings/index -> retrieval/filtering
    -> reranking -> prompt/context -> FM inference -> guardrails/output
    -> evaluation/release gate -> monitoring/audit/governance
```

- If the problem is **which chunks were retrieved or how they ranked**, test retrieval separately; do not start by changing prompts or the generation model.
- If the problem is **unsafe input must never influence generation**, moderate before invoking the FM.
- If the problem is **generated answers may leak PII**, use managed output controls and, where needed, pre-inference redaction.
- If the problem is **prompt/model change caused quality drift**, run repeatable regression evaluation and gate promotion on measured results.
- If the problem is **scale or throttling**, add buffering, bounded concurrency, retries, and workload-appropriate batch/async patterns rather than simply increasing real-time capacity.
- If the problem is **audit/provenance**, persist structured service-returned evidence instead of trying to parse citations from generated prose.

## 2. Amazon Bedrock APIs: know the boundaries

| Need | Prefer | Why / trap |
|---|---|---|
| Inspect retrieved chunks without generation | `Retrieve` | Isolates retrieval; inspect `retrievalResults`, content, metadata, location, and relevance score. |
| Retrieve context and generate answer with references | `RetrieveAndGenerate` | Combines retrieval and FM generation; answer wording adds generation variance. |
| Need application-controlled prompt/generation after retrieval | `Retrieve` then invoke model separately | Preserves custom downstream prompt and generation flow. |
| Call chat model using common supported request format | `Converse` / `ConverseStream` | Common conversational interface across supported models. |
| Call `InvokeModel` directly | Provider/model-native JSON body | Do not put a Converse body inside `InvokeModel`; Claude 3 Messages format is not the old Claude Text Completions format. |
| Enforce a guardrail on input before model invocation | `ApplyGuardrail` then invoke only if allowed | Rejected input must not reach the FM. Output-only guardrails are too late for this requirement. |
| Need structured citation lineage | Persist citation objects from `RetrieveAndGenerate` | Keep `generatedResponsePart` and `retrievedReferences`; don't scrape natural-language footnotes. |

### Retrieval relevance

- **Hybrid search** combines semantic/vector similarity with keyword matching. It is useful when queries combine natural-language descriptions with exact IDs, names, codes, or section numbers.
- **Reranking** reorders candidate chunks by query relevance. It cannot recover a relevant chunk that initial retrieval never selected; first ensure candidate retrieval is adequate.
- **Metadata filters** constrain the search set. If *both* jurisdiction and edition must match, use an AND-style filter (`andAll` in the relevant API), not OR.
- **Retrieve count (`numberOfResults`)** should be close to the amount of context the answer needs. More chunks can add noise, latency, and cost.
- For a fully managed Knowledge Base, follow its managed retrieval configuration (`managedSearchConfiguration` in the supplied paper scenario). Do not copy configuration fields from a custom vector-store knowledge base blindly.
- For baseline diagnosis, fix the test queries and inspect retrieved results before enabling reranking or changing prompts.

### CSV Knowledge Base metadata

For record-based CSV ingestion, the paper's scenario requires an RFC4180-compliant, UTF-8 CSV with a header and a matching `.csv.metadata.json` sidecar. Define one content field. If no include/exclude lists are set, the other columns can become metadata; explicit include lists create maintenance when new columns arrive. A field must not appear in both include and exclude lists.

### Binary embeddings compatibility

The paper's migration scenario requires two checks before release: (1) the selected embedding model supports `BINARY`; and (2) the vector store supports binary vectors. The paper identifies OpenSearch Serverless as the default target and OpenSearch managed clusters as an exception requiring cluster administration. Do not assume every valid Knowledge Base storage type supports every vector data type.

## 3. Guardrails, privacy and safety

### Input vs output

- **Input must not influence generation if rejected:** call `ApplyGuardrail` before `Converse`; only call the model when the decision is allow.
- **Sensitive information should be masked by managed Bedrock policy:** configure Guardrails sensitive-information filters and custom regex for organization-specific patterns; apply the guardrail during inference.
- **Reduce PII before inference:** Lambda can call Amazon Comprehend PII detection and replace detected spans with stable placeholders, preserving roles/references without sending raw values to the model.
- **Output streaming must not reveal unscanned text:** synchronous guardrail streaming buffers/scans chunks before forwarding them; this can add latency. The paper notes asynchronous guardrail streaming does not support sensitive-information masking.
- Prompt instructions alone are not a privacy/security boundary. Deterministic controls should enforce the policy.
- KMS encryption and IAM permissions protect stored data/access, but do not redact PII in the prompt sent to the FM.
- Macie discovers sensitive data in S3; it is not inline request-time masking.
- Keep audit records minimal when full message retention is prohibited: record moderation decision, policy/guardrail version, timestamp, and non-sensitive metadata rather than the full viewer text.

### Central governance across AWS accounts

- **SCPs** set the maximum permissions for principals in member accounts. The supplied paper uses them to restrict allowed Bedrock model ARNs and require a centrally approved guardrail identifier. Use explicit deny/conditions where needed; role-only permissions boundaries can miss principals that do not have the boundary.
- **CloudFormation StackSets** can deploy consistent guardrail definitions across accounts. The paper's pattern uses a block filtering policy for denied topics and sensitive/word filters for internal project code names.
- **AWS WA Tool review templates** standardize repeated review answers. Combine the AWS Generative AI Lens with a published custom lens for internal controls, and share the template with the relevant OU in the same Region. A custom lens alone is not a substitute for AWS-maintained Lens Catalog content.
- **SageMaker Model Cards** document intended use, risks, evaluation observations, and approval state. The paper recommends creating/updating cards via CI/CD and using model-card versions as history. `ModelCardStatus` review states include Draft, PendingReview, Approved, and Archived; Archived is not the state for an artifact expected to keep receiving substantive updates.

## 4. Evaluation, testing and release gates

Separate four questions:

1. **Retrieval quality:** Did the KB return relevant/complete context?
2. **Answer quality:** Is the generated answer correct, complete, coherent, helpful, faithful to sources, and appropriately refusing harmful requests?
3. **Safety:** Does it violate configured policies or reveal sensitive data?
4. **Human usefulness/fairness:** Is it respectful, complete, and consistent across cohorts?

- Use retrieve-only RAG evaluation for retrieval-focused metrics such as context relevance and context coverage. The supplied paper notes retrieve-only datasets are single-turn.
- Use retrieve-and-generate RAG evaluation for response-quality/safety metrics and multi-turn conversations (the supplied scenario supports up to five turns).
- Use human-worker evaluation when subjective human review is required; LLM-as-a-judge can score qualitative rubrics but does not replace separate retrieval-only measurement or human evidence when specifically required.
- Keep test datasets in the required S3 JSONL format, one valid JSON object per line. The paper's scenario notes a maximum of 1,000 prompts per job; verify current service limits in current docs before the exam.
- **Automated release gate:** a Step Functions regression workflow can orchestrate fixed test prompts, candidate prompt/model invocation, scoring, metric persistence, threshold evaluation, and pass/fail signaling to CI/CD.
- **Fairness testing:** replay the same representative cases across cohorts, use an explicit LLM-as-a-judge rubric for the target properties (e.g., completeness/respectfulness), and publish cohort-level aggregate evidence as CloudWatch custom metrics. Guardrail counts or sentiment alone are not fairness scores.
- **CloudWatch Synthetics** is useful for journey/availability checks, but is not by itself the best orchestration layer for scoring, persisting quality metrics, and returning a CI/CD gate.

## 5. Monitoring, logs and observability

- Use **AWS/Bedrock runtime metrics** for aggregate invocation latency, streaming responsiveness, throttling and errors; use business/application metrics for business impact.
- Use **Bedrock model invocation logging** when you need details about FM interactions, inputs/outputs subject to configuration and privacy controls, and debugging context. It complements, not replaces, service metrics.
- Do not build dashboards only grouped by `ModelId` if some failed calls lack a target model in application logs; include aggregate/error views that still count those failures.
- Use CloudTrail for API activity/configuration evidence; CloudWatch metrics/logs/dashboards for operational health; structured application logs for correlation IDs and business outcomes.
- For audits, store the exact citation/provenance fields returned by the service rather than relying on model-written footnotes.

## 6. Scaling, ingestion and inference modes

### Embedding ingestion

- **Huge historical backfill:** AWS Batch array jobs can fan out work across many documents and use retries for transient failures; use controlled parallelism and watch Bedrock quotas.
- **Continuous incremental arrivals:** S3/event → SQS buffer → Lambda workers is a practical event-driven path. SQS absorbs spikes, supports retry/redrive, and decouples producers from embedding API throughput. Set bounded concurrency and use a DLQ for poison messages.
- Avoid a sequential Step Functions execution per document for tens of millions of historical items when parallel batch processing fits better.
- Avoid triggering heavyweight Glue jobs for every individual new article when a queue/worker pattern better matches small incremental work.
- Do not rely on repeatedly re-embedding the entire corpus to handle daily incremental additions.

### Model inference workload fit

- **Interactive chat:** real-time inference; streaming improves perceived responsiveness but does not automatically request a latency-optimized service path.
- **Latency optimization:** in the supplied scenario, set `performanceConfig.latency` to `optimized` on each supported request; it is per-call. If optimized quota is reached, the scenario says Bedrock may fall back to Standard; confirm actual served configuration in response/CloudTrail.
- **Large non-user-facing batch with relaxed completion time:** SageMaker AI asynchronous inference can take S3 payloads and write results to S3; it avoids forcing a heavy batch through a real-time endpoint.
- **Provisioned throughput** is about reserved/dedicated model capacity, not automatically the best choice for a batch job that can run over hours.
- Queueing alone does not remove endpoint cost if the same expensive real-time capacity remains running; choose the inference mode to fit latency and utilization requirements.

## 7. Agents, memory and tool integration

- **Bedrock Agents + action groups** connect agent decisions to APIs/tools (often via Lambda). Use them when the assistant must take actions or call business APIs, not just answer from text.
- Separate **short-term/session context** from **long-term user preferences**. The paper's scenario stores session-scoped context separately from persistent profile preferences in DynamoDB so session details do not overwrite stable user preferences.
- Step Functions execution state is not a substitute for durable cross-session user memory.
- Secrets Manager is for secrets; Parameter Store is for configuration/parameters—not a default chat-history or user-profile database.
- For high-volume asynchronous agent or model workflows, use queues/orchestration with explicit retries, idempotency, and status tracking.

## 8. Amazon Q Developer workflows

- For selected code, use actions such as **Generate tests** and **Optimize**, then review the generated changes.
- For changes across Lambda handlers, prompt templates, and API clients, provide workspace/files/folders as context in IDE chat; inspect agentic coding diffs and undo/review as needed.
- The paper calls out IDE feature boundaries: transformations are not supported in Eclipse, and inline chat is not supported in Visual Studio. Select workflows that work across the team's actual IDEs.
- Q does not carry context across separate chat sessions; include the task's required context each time.

## 9. Quick scenario-to-service map

| Scenario clue | Best-fit pattern from the papers |
|---|---|
| “Diagnose retrieval before changing prompts” | `Retrieve`; inspect chunk content, metadata, location, score |
| “Symptoms plus exact identifiers/codes” | Hybrid search + managed reranking (where supported) |
| “Wrong jurisdiction OR wrong edition passages” | Metadata filter requiring both fields (`andAll`) |
| “Rejected input must not affect generation” | `ApplyGuardrail` before `Converse`; invoke only on allow |
| “PII should not reach FM” | Comprehend PII detection + Lambda placeholders; Guardrails for managed input/output filtering |
| “Mask sensitive info in streamed output before user sees it” | Synchronous guardrail streaming; accept latency tradeoff |
| “Millions of historical embeddings” | AWS Batch array jobs with retries and controlled parallelism |
| “Continuous arrivals with bursts” | SQS + Lambda incremental pipeline |
| “Nightly heavy job, hours are acceptable” | SageMaker asynchronous inference with S3 input/output |
| “Prompt edits must pass quality thresholds before deploy” | Step Functions regression workflow + stored scores + pass/fail gate |
| “Fairness evidence by cohort” | Fixed cohort samples + LLM-as-a-judge rubric + CloudWatch custom metrics |
| “Need source-to-generated-answer audit mapping” | Persist structured citation objects from `RetrieveAndGenerate` |
| “Restrict every account to approved model and guardrail” | Organization SCP enforcement + centrally deployed guardrails |
| “Standardize architecture reviews” | WA Tool review template + Generative AI Lens + published custom lens |
| “Cross-session memory” | Separate session-scoped memory and durable user-preference storage |
| “Common chat API across models” | Converse/ConverseStream; native payload for direct InvokeModel |

## 10. Final exam checklist

- [ ] Can I distinguish `Retrieve` from `RetrieveAndGenerate` and explain when to use each?
- [ ] Can I explain vector search vs hybrid search vs reranking vs metadata filtering?
- [ ] Can I identify which control must run before inference and which applies to output?
- [ ] Can I distinguish Guardrails, Comprehend, Macie, KMS, IAM, SCP, CloudTrail and CloudWatch?
- [ ] Can I design historical backfill and incremental ingestion separately?
- [ ] Can I choose real-time vs streaming vs async inference from latency requirements?
- [ ] Can I separate retrieval evaluation, response evaluation, safety evaluation and human/fairness evaluation?
- [ ] Can I build a quality-based CI/CD gate and preserve auditable score history?
- [ ] Can I persist structured citations and governance records rather than relying on generated prose?
- [ ] Have I reviewed all 525 detailed question records and retested every uncertain answer?

## Source boundary

This quick guide distills patterns explicitly present in the seven uploaded sample papers. It is not an official AWS exam blueprint and does not guarantee the exam will reuse these questions. For the complete source-backed explanations and all distractors, use the master notes file.
