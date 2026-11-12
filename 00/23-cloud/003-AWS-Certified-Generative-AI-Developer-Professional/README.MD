evaluation jobs
1. automated
2. ll as jidge
3. human review

interference profile?

intelligent prompt routing

caching techniques
1. prompt caching
    - stores the exact text of prompts for quick retrieval
    - can improve retrieval speed for repeated prompts
2. semantic caching
   - stores the meaning of prompts rather than the exact text
   - can improve retrieval accuracy for similar prompts




GPT-n from OpenAI and Claude from Anthropic are type of foundation models.
Foundation models are pre-trained transformer models that can be fine-tuned for various downstream tasks.
transformer models are a type of deep learning architecture that use self-attention mechanisms to process sequential data efficiently.

diff between large language model and foundation model
- Foundation Model:
  - A broad category of pre-trained models that can be fine-tuned for various downstream tasks.
  - Can include models for text, images, audio, and multimodal data.
  - Examples: GPT-n, Claude, CLIP, DALL-E.
- Large Language Model (LLM):
  - A type of foundation model specifically trained on large text corpora.
  - Primarily used for natural language understanding and generation tasks.
  - Examples: GPT-n, Claude.







# Advanced Generative AI Development on AWS

### AI → ML → DL → FM → Generative AI

- `AI (Artificial Intelligence)` — The human defines the task or objective they want the system to accomplish. The system follows rules, logic, or other AI techniques to achieve the goal. The human is responsible for providing clear instructions and evaluating the output.
- `ML (Machine Learning)` — Instead of explicitly programming every rule, the human provides data, and the model learns patterns from that data to make predictions or decisions. The human is responsible for preparing the data, choosing the model, and evaluating its performance.
- `DL (Deep Learning)` — When data is large or complex, deep learning models, typically neural networks with multiple layers, automatically learn hierarchical representations from the data. The human is responsible for selecting the architecture, providing sufficient computational resources and data, and evaluating performance.
- `FM (Foundation Models)` — These are models pretrained on large and diverse datasets so they can be adapted to many downstream tasks. They may work with text, images, audio, video, or multiple modalities. The human is responsible for choosing the appropriate model, adapting it when necessary, providing task-specific context or data, and evaluating its performance.
- `Generative AI (GenAI)` — Generative AI uses models to generate new content, such as text, images, audio, video, and code, based on learned patterns and user prompts. Many modern GenAI systems use foundation models built with deep learning, such as Large Language Models (LLMs). The human is responsible for writing effective prompts, supplying relevant context, selecting suitable models, and validating the generated output.

### Practical example: MR Management application 

- `AI` - An application that helps decide which doctor an MR should visit next.
- `ML` - A model predicts which doctors are most likely to prescribe a medicine.
- `DL` - A neural network learns complex patterns in doctor visits and prescription data.
- `FM` - A pretrained Claude model understands questions about doctors, MRs, and visit reports.
- `Generative AI` - Claude generates an answer summarizing an MR's last 90 days of doctor visits.
- `RAG` - Your application retrieves relevant MR records and supplies them to Claude to generate a grounded answer.
- `AI Agent` - An agent can retrieve records, call APIs, analyze results, and coordinate follow-up tasks using tools.

### Challenges and solutions with FM

- `Knowledge Cutoff` — A Foundation Model may not know about events or information created after its training data was collected.
- `Hallucination` — A Foundation Model may generate plausible-sounding but incorrect or nonsensical information.

Solution: 
- Use `RAG` to retrieve up-to-date information from external knowledge sources or call APIs to fetch real-time data. 
- Use `Fine-tuning` to adapt the model behavior or specialized knowledge, especially for information that changes frequently.
- Use `Prompt Engineering` to carefully design prompts that guide the model towards generating accurate and relevant responses.

- `Statelessness` — Foundation Model API calls generally do not automatically retain conversation history between requests. The model cannot reliably recall previous interactions unless relevant information is provided again. 

Solution: 
- Use `External Memory` — Store conversation history or important facts externally and include relevant context in subsequent requests.

### Agentic AI

- `Agentic AI` — Agentic AI refers to AI systems that can work toward a defined goal by planning steps, making decisions, using tools, observing results, and adjusting their actions with limited human intervention. Unlike a traditional GenAI application that primarily generates a response to a prompt, an AI agent can perform multiple steps to accomplish a task. The human is responsible for defining the goal, setting constraints and permissions, and evaluating the final outcome.
- `Goal` — Defines what the agent needs to accomplish. For example, identify doctors who have not been visited by an MR in the last 30 days and prepare a follow-up plan.
- `Planning` — Breaks the goal into smaller steps and determines the sequence of actions required to achieve it.
- `Reasoning` — Uses the model to interpret information, evaluate available options, and decide which action or tool to use next.
- `Tool Calling` — Allows the agent to interact with external systems through APIs, databases, search tools, or other approved functions to retrieve information or perform actions.
- `Memory` — Maintains relevant conversation history, task state, or previously collected information so the agent can use it during subsequent steps.
- `Agent Loop` — The iterative cycle of observing the current state, selecting an action, executing it, evaluating the result, and continuing until the goal is achieved or a stopping condition is reached.
- `Human-in-the-Loop` — Allows a human to review, approve, or modify important decisions or actions, especially those involving sensitive data or business operations.

### Practical example: MR Management application

- `Goal` — Prepare a follow-up plan for Rahul based on doctor visits over the last 90 days.
- `Step 1: Retrieve` — Use RAG or APIs to retrieve Rahul's visit records and doctor details.
- `Step 2: Analyze` — Identify doctors who have not been visited recently or require follow-up.
- `Step 3: Plan` — Prioritize doctors and propose follow-up dates.
- `Step 4: Act` — Call a Java REST API to create follow-up tasks, if the agent has permission.
- `Step 5: Evaluate` — Check whether the tasks were created successfully and retry or report an error if necessary.
- `Step 6: Finish` — Present the completed plan and results to the user.

### GenAI vs AI Agent

- `Generative AI` — Primarily generates content or answers based on a prompt and the context provided.
- `AI Agent` — Uses an AI model to work toward a goal by selecting actions, calling tools, and evaluating results across one or more steps.
- `Agentic AI` — The broader approach of building AI systems that exhibit goal-directed, adaptive behavior, often through one or more AI agents.

### choosing right FM

- `Task Requirements` — Determine the specific capabilities needed for your task, such as language understanding, generation, reasoning, or tool integration.
- `Model Performance` — Evaluate the accuracy, reliability, and efficiency of different foundation models for your use case.
- `Integration` — Consider how easily the model can be integrated with your existing systems, APIs, and workflows.
- `Cost` — Assess the cost implications of using a particular foundation model, including usage fees and infrastructure requirements.
- `Security and Compliance` — Ensure the model meets your organization's security, privacy, and regulatory requirements.
- `Support and Community` — Look for models with strong support, documentation, and an active user community to facilitate development and troubleshooting.

### Misc Topics
- `Amazon Bedrock` — A fully managed AWS service that provides access to Foundation Models (FMs) from providers such as Amazon and Anthropic.
    - Use it to generate text, answer questions, summarize documents, and build AI applications.
    - You don't need to host or manage the underlying foundation model infrastructure yourself.

Summary:
- Bedrock = Access and run foundation models.
- APIs = Enable communication between applications and services.
- Knowledge Bases = Retrieve relevant information from data sources.
- RAG Evaluation = Measure retrieval and answer quality.
- AWS Glue = Integrate, transform, and prepare data.





























