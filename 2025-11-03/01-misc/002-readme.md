###

####
<details>
<summary> 🟩 Tell me about a conflict with a co-worker. How did you resolve it? </summary>

- In one of my recent projects at U.S. Bank, we were in the middle of migrating our onboarding platform to a Vite-based mono-repo architecture. I was leading the UI migration, while one of my colleagues — a senior developer — was responsible for integrating analytics and partner-specific configurations.

- During one sprint, we had a disagreement on how configuration overrides should be handled. I proposed a config-driven approach using JSON files to dynamically load partner-specific themes and behaviors, while my colleague preferred maintaining separate branches for each partner to simplify debugging.

- The conflict started affecting sprint discussions because both approaches had valid reasoning — mine emphasized scalability, his emphasized short-term maintainability.

- So, I suggested that instead of debating in theory, we run a technical proof of concept (POC) for both approaches and evaluate them against measurable criteria — build time, code reusability, and deployment complexity.

- We presented the results together during our sprint review — and it turned out that the config-driven model reduced maintenance effort by about 40% in future rollouts while still allowing partner-level debugging through environment-based flags.

- After that, my colleague appreciated the data-driven approach, and we agreed to adopt it as the standard. I also made sure to acknowledge his concerns by adding better logging and documentation for partner-specific overrides, which addressed his maintainability worries.

- The entire experience reinforced for me that most technical conflicts aren’t about ego — they’re about perspective. When you bring data, empathy, and openness into the discussion, conflicts turn into collaboration.

</details>

####
<details>
<summary> 🟩 Describe a time you disagreed with your manager. What did you do? </summary>

- At U.S. Bank, during the initial phase of our Onboarding V2 migration project, my manager wanted to move forward with reusing a legacy shared component library that had been built years ago in AngularJS and lightly wrapped in React for compatibility.

- His main concern was timelines — he wanted to accelerate delivery by leveraging existing code. However, after reviewing the library, I realized that reusing it would cause long-term issues: it wasn’t TypeScript-compatible, lacked accessibility compliance (WCAG 2.1), and didn’t fit well within our Vite + mono-repo architecture.

- Instead of pushing back immediately, I took a data-driven approach. I created a small technical spike comparing both approaches:

    - Reusing the old library: Quick start, but required multiple compatibility layers and generated 25% larger bundles.

    - Rebuilding key components in React + TypeScript: Slightly more upfront effort, but future-proof, reusable across 13,000+ partner apps, and passed accessibility audits out-of-the-box.

- I presented the findings to my manager along with a phased migration plan — where we’d rebuild only the critical shared components first and reuse the stable ones temporarily.

- He appreciated that I wasn’t just disagreeing but offering a balanced, evidence-based solution. Eventually, leadership agreed to the hybrid plan — it kept delivery on track and ensured long-term scalability.

</details>

####
<details>
<summary> 🟩 Tell me about a project you’re most proud of. </summary>

- The project I’m most proud of is the Onboarding V2 migration initiative I led at U.S. Bank. It was a large-scale modernization effort to rebuild the customer onboarding platform that serves over 13,000+ partner banks like Edward Jones, State Farm, and Union Bank.

- The legacy onboarding micro-app had grown complex over the years — each partner had their own forked version, leading to duplicated code, inconsistent themes, and slow deployments.

- I took the technical lead role for the migration, and my goal was to design a single, scalable architecture that could support all partners while maintaining flexibility for their individual configurations.

- So, I architected the platform using a Vite-based mono-repo structure with PNPM workspaces, where each partner app consumed shared components from a central core library. I also introduced a config-driven architecture — meaning partners could customize their branding, content, and behavior through JSON config files without modifying the shared core.

- On top of that, we integrated Adobe Experience Manager (AEM) for dynamic content delivery and built CI/CD automation using GitLab pipelines to handle multi-environment deployments (IT, UAT, Pre-Prod, Prod, etc.).

- The outcome was pretty significant:
    - Build time improved by ~40% with Vite.
    - Partner rollout cycles dropped from weeks to hours.
    - Code duplication reduced drastically, improving maintainability.
    - Accessibility and performance scores consistently passed audits.

- And one thing I’m personally proud of — beyond the technical results — is that I also mentored offshore developers, built coding standards for TypeScript and ESLint, and established SonarQube quality gates that the team still uses today.

- For me, that project really reflected end-to-end ownership — from architecture and code quality to deployment and team enablement — and made a lasting impact on how the bank manages partner integrations at scale.

</details>

####
<details>
<summary> 🟩 Tell me about a time you failed. What did you learn? </summary>


- Sure. Early in my time at U.S. Bank, during the first phase of our onboarding micro-app project, I was handling a major React component refactor that aimed to improve performance and modularity.

- In one sprint, I introduced a new lazy-loading pattern for dynamic components — the idea was solid, but I missed a critical dependency issue in our feature flag service. The change worked perfectly in IT and UAT, but when it was deployed to Pre-Prod, certain onboarding flows for credit card users failed silently because the lazy-loaded modules weren’t initializing the flag context correctly.

- That caused a partial production rollback, and it was a tough moment because I had led that piece.

- I immediately took responsibility — I worked with QA and DevOps to analyze logs via Splunk and Kibana, identified the missed edge case, and hotfixed it by ensuring proper dependency injection across all feature-flagged modules.

- But the more important part was what I learned:

    - I realized I had focused too much on code-level optimization and not enough on end-to-end scenario validation.

    - After that, I introduced a “cross-environment test checklist” and a peer review matrix to ensure that all context-dependent modules (like flags, analytics, or AEM content) were validated before merge.

    - I also began setting up automated integration tests using Cypress to catch such environment-specific regressions early.

- Since then, I’ve always viewed a “failure” not as a setback, but as a learning checkpoint — it improved my rigor, my empathy toward QA and DevOps, and my appreciation for shared accountability in a large-scale system.

</details>

####
<details>
<summary> 🟩 Give an example of a calculated risk you took when speed was critical. </summary>

- Sure. During the Onboarding V2 migration project at U.S. Bank, we had a critical release deadline for one of our largest partners, Edward Jones.
The deployment was tied to a major marketing campaign launch, and delaying it would have impacted both the bank’s go-live plan and client visibility.

- Two days before the release, we discovered a performance regression — one of the shared React components had started rendering slowly due to an unoptimized conditional configuration merge.
The proper fix involved a full refactor of the shared component, which would have taken at least a week — and we didn’t have that time.

- So I decided to take a calculated risk. Instead of refactoring, I proposed and implemented a temporary optimization layer that cached configuration merges in-memory using a lightweight hook, which bypassed redundant JSON parsing during render.

- I clearly communicated to my manager and QA team that this was a short-term tactical fix, documented the limitation, and scheduled a post-release ticket for the proper architectural change.
We ran a quick performance benchmark and regression test — and confirmed that the optimization improved load time by over 30% without breaking any flows.

- The release went out on time, and the campaign launched successfully.
Two weeks later, once the pressure was off, I refactored the component properly to integrate the same caching mechanism in a more maintainable way.

- So while it was a risk — touching shared code so close to release — it was a calculated one, based on measurable performance data, stakeholder alignment, and a clear rollback plan.

- That experience taught me that speed doesn’t have to mean recklessness — if you pair quick decision-making with transparency, validation, and follow-up, you can move fast and maintain trust.

</details>

####
<details>
<summary> 🟩 Describe a conflict between teams or departments that you helped resolve. </summary>

- Sure. One example that comes to mind was during the Onboarding V2 modernization project at U.S. Bank.

- We had a recurring conflict between the Frontend Development team (which I was leading) and the AEM Content Management team. The AEM team wanted to control partner-specific content rendering directly through their templates, while our frontend team believed that those configurations should come from our React config-driven architecture, to ensure consistency and reduce duplicate logic.

- The issue became serious when both teams implemented different ways to render partner banners — one through AEM, and the other through React configs — which caused inconsistent experiences across partner environments during UAT.

- To address it, I took the initiative to organize a joint working session with both teams — instead of debating whose system was “right,” we whiteboarded the data flow end-to-end:

    - What content belonged to AEM (static or marketing-driven)
    - What configurations belonged to React (behavioral or feature-driven)

- We then defined a clear boundary contract — AEM would handle content and imagery, while React would control UI behavior and layout through a shared JSON schema.
I also built a proof-of-concept API adapter that allowed AEM to expose content as a JSON feed, which React could consume directly — effectively bridging both systems.

- Once we tested the approach, both teams realized it solved the duplication issue and simplified deployments.
That solution became the standard integration model for all subsequent partner banks, and the friction between the two teams turned into active collaboration.

- What I learned from that experience is that technical conflicts between teams usually stem from unclear ownership — and the fastest way to resolve them is to get everyone in the same room, visualize the problem together, and co-own the solution.

</details>

####
<details>
<summary> 🟩 What’s the hardest feedback you’ve had to deliver? </summary>

- That’s a great question.

- One of the hardest feedback situations I had to handle was during my time leading a small UI sub-team at U.S. Bank.

- One of our offshore developers — a talented and hardworking team member — was consistently delivering features quickly, but his merge requests often had recurring issues: missing unit tests, inconsistent naming, and occasional ESLint violations that slowed down review cycles.

- Initially, I tried leaving MR comments and reminders, but the pattern continued.
So, I realized I needed to have a direct but constructive conversation.

- I scheduled a one-on-one with him, started by appreciating his speed and dedication, and then shared specific examples where skipping testing or linting had caused rework or regressions.

- I framed it not as “you’re making mistakes,” but as “here’s how we can raise the bar for the whole team.”

- I also took some responsibility — I told him that perhaps I hadn’t made our code quality expectations clear enough — and then we worked together to define a simple checklist for every merge request: test coverage, lint pass, and peer review sign-off.

- I paired with him for one sprint to review his code more closely, and within a few weeks, his MRs became some of the cleanest in the team.

- Later, he actually thanked me for that feedback, saying it helped him become more confident about his code quality and consistency.

- So while it was difficult initially — because nobody enjoys giving corrective feedback — it reinforced for me that the key is intent and empathy.
If people feel you’re genuinely trying to help them grow rather than criticize them, they’re far more open to change.

</details>

####
<details>
<summary> 🟩 Tell me about a time you had to work with someone very different from you. </summary>

- Sure. At U.S. Bank, during the Onboarding V2 migration project, I worked closely with a QA lead who had a very different working style from mine.

- I’m generally very proactive and iterative — I like to release in small increments, validate early, and fix fast. The QA lead, on the other hand, had a very structured and process-driven mindset — he preferred extensive documentation and complete end-to-end test coverage before approving any release candidate.

- Initially, this difference caused some friction. During one sprint, our team was ready to push a build to UAT, but the QA lead held it back because he wanted to wait until all regression test cases were formally signed off in JIRA.
From my side, I was worried that delaying would affect downstream integration testing with the partner teams.

- Instead of escalating, I set up a quick sync call with him to understand his perspective. He explained that in previous projects, rushing releases had caused rework due to missing test coverage. I shared that our new mono-repo setup actually included automated Jest and Cypress test suites, which already validated most of the core functionalities.

- We decided to find a middle ground:
    - We would proceed with incremental UAT builds using our automated coverage reports,

    - While his team would focus manual testing on only the new partner-specific configurations in each sprint.

- This compromise kept our delivery on schedule while also addressing his quality concerns. Over time, our collaboration improved — we even built a shared “test results dashboard” integrated with GitLab CI so both teams had real-time visibility into build quality.

- What I learned from that experience is that different doesn’t mean incompatible — sometimes people’s caution comes from valid past experiences.
When you take the time to understand their reasoning and find data-driven alignment, you not only resolve conflict but also build long-term trust and stronger teamwork.

</details>

####
<details>
<summary> 🟩 Share an example where you influenced a decision without formal authority. </summary>

- Sure. During my time at U.S. Bank, I was leading the frontend migration for our Onboarding V2 platform — a massive modernization project impacting more than 13,000 partner banks.

- At that time, I wasn’t a formal architect, but I noticed that our legacy Webpack build setup was slowing down development — builds took several minutes, dependency management was messy, and shared component updates required manual synchronization across multiple micro-apps.

- The initial plan, approved by our architecture group, was to continue with Webpack because it was “stable and proven.”
However, I strongly believed we needed a modern build system — specifically Vite with PNPM workspaces — to support modularization and faster iteration.

- Instead of simply opposing the decision, I took a data-driven and collaborative approach:

    - I built a small proof-of-concept mono-repo using Vite and PNPM, integrated with our onboarding micro-app.

    - Measured and documented tangible improvements: build time reduced by ~40 %, hot reload speed up by 60 %, and simpler dependency linking across modules.

    - I also highlighted how the new setup would simplify partner-specific theming and enable reusable UI packages.

- Then, I presented these findings to our architecture council and DevOps team, showing real numbers and a clear rollback plan in case of issues.
Even though I didn’t have the authority to make the architectural call, the results spoke for themselves.

- After reviewing the POC, the leadership team agreed to pilot the Vite-based setup — and within a few sprints, it became the standard build system for the entire onboarding platform.

- This experience taught me that influence doesn’t come from title — it comes from credibility and initiative.
When you combine technical evidence with respect for others’ concerns, you can drive meaningful change even without formal authority.

</details>

####
<details>
<summary> 🟩 Tell me about an ambiguous project. How did you handle the uncertainty? </summary>

- Sure. One of the most ambiguous projects I worked on at U.S. Bank was the early phase of the Onboarding V2 migration initiative.

- When the project started, the business direction was clear — modernize the onboarding experience — but the technical roadmap was very unclear.
We had to decide between multiple architectural approaches — micro-frontends vs. mono-repo, React with Webpack vs. Vite, and different strategies for handling partner-specific configurations.
At that point, there was no detailed documentation, no finalized requirements, and multiple stakeholders (architecture, security, and partner engineering) had different expectations.

- To manage this uncertainty, I took a structured discovery approach:

    - Clarify the unknowns — I started by listing what we knew and what we didn’t. For example, we knew the app had to serve 13,000+ partner banks, but we didn’t know the level of UI customization each required.

    - Run small experiments — I created quick POCs to compare approaches: one using micro-frontends with Module Federation and another using a Vite-based mono-repo.

    - Engage cross-functional teams early — I organized working sessions with DevOps, Security, and Product to align on deployment constraints, access policies, and scalability needs.

    - Document and communicate continuously — I maintained a living Confluence page capturing all learnings, trade-offs, and recommendations so leadership could make informed decisions.

- After a few iterations, we decided to go with a Vite + PNPM mono-repo architecture, supported by a config-driven theming system. That solution turned out to be highly scalable and reduced partner onboarding time drastically.

- What I learned from that experience is that ambiguity isn’t a blocker — it’s an opportunity to lead. By breaking the problem into smaller, testable parts, engaging the right people early, and communicating clearly, you can turn uncertainty into direction.

</details>

####
<details>
<summary> 🟩 Describe a time you decided with incomplete data. </summary>

- Sure. During the Onboarding V2 project at U.S. Bank, we were preparing for the first partner rollout of our new mono-repo platform — a major milestone.
A few days before the deployment, we discovered intermittent UI latency in one of the onboarding flows during QA testing.

- The tricky part was that we didn’t have consistent reproduction data — the issue occurred randomly in certain partner environments, and logs from Splunk were inconclusive.
We didn’t have enough time to do a full end-to-end trace because the release was tied to a business deadline.

- So, I had to make a decision with incomplete data: either block the release until we could fully diagnose it, or deploy with controlled monitoring in place.

- I brought the QA lead, product owner, and DevOps together for a quick risk assessment huddle. We analyzed what we did know — the issue only occurred under heavy load, and there was no data loss or transaction failure, just a slight UI lag.

- Based on that, I made the call to proceed with the release, but with mitigation steps:

    - We added real-time performance monitoring via Quantum Metric and Splunk dashboards.

    - I created a feature flag so we could instantly disable the affected module if the issue worsened.

    - We scheduled a hotfix sprint to investigate root cause post-release.

- The deployment went live successfully with no critical incidents. Later, we discovered the lag was caused by redundant analytics event listeners, which we fixed in the next sprint.

- That situation taught me that sometimes, you’ll never have 100% clarity — but you can still make sound decisions by quantifying risk, communicating transparently, and having a rollback or mitigation plan in place.

- It reinforced my belief that good leadership isn’t about always being right — it’s about being responsible, transparent, and adaptable when you have to decide under uncertainty.

</details>

####
<details>
<summary> 🟩 What’s a situation where you prioritized one project over another? </summary>

- Sure. At U.S. Bank, I was leading two major initiatives in parallel:

    - The Onboarding V2 migration project, where we were rebuilding the onboarding platform using a Vite-based mono-repo.

    - A new AI-driven merge request assistant (Merge Mind), an internal tool using GPT-4 to analyze code quality and suggest improvements within our CI/CD pipeline.

- Both projects were important — the onboarding platform had direct business impact and external visibility, while the AI assistant was an innovation initiative backed by leadership.

- However, mid-quarter, we hit a crunch: the Edward Jones partner rollout for Onboarding V2 was at risk due to configuration conflicts, and I was asked to split my time between both projects.

- After evaluating the situation, I made the decision to prioritize Onboarding V2. Here’s how I approached it:

    - I assessed impact and urgency — the onboarding rollout had committed business dates and downstream dependencies (QA, partner testing, marketing).

    - I communicated transparently with the innovation team, explaining that temporarily pausing AI feature development would avoid production risks in a revenue-impacting project.

    - To keep momentum, I delegated parts of Merge Mind’s prompt-engineering work to another teammate and provided them with detailed technical notes and next-step guidance.

- By focusing my efforts on Onboarding V2, we delivered the partner migration on time, avoided potential deployment issues, and then resumed work on the AI project the following sprint.

- In hindsight, that decision reinforced an important principle for me — prioritization isn’t just about what’s exciting or new, but what’s most critical to customer and business outcomes. As a lead engineer, sometimes the best decision is to pause innovation temporarily to protect stability and delivery credibility.

</details>

####
<details>
<summary> 🟩 Tell me about a time you had to change your approach after receiving tough feedback. </summary>

- Sure. During the early phase of the Onboarding V2 migration project at U.S. Bank, I received some tough but very valuable feedback from my manager.

- I was leading the frontend modernization and was deeply focused on technical excellence — optimizing build speed, improving modularization, and setting strict ESLint/SonarQube standards. However, in one of our retrospectives, my manager pointed out that while my technical leadership was strong, my communication with non-technical stakeholders — particularly product and QA teams — was sometimes too detail-heavy and not outcome-focused enough.

- Initially, I was a bit defensive because I thought I was just being transparent and thorough. But after reflecting, I realized he was right — my approach, though well-intentioned, sometimes overwhelmed others with technical depth when what they really needed was clarity, priorities, and impact. So, I decided to change my approach.

    - I started tailoring my updates to the audience — using visuals, metrics, and summaries instead of code-level details.

    - For instance, instead of saying, “We’re migrating our bundler from Webpack to Vite to leverage native ES module resolution,” I began framing it as, “This change will reduce build times by 40% and speed up partner onboarding.”

    - I also started doing short demo sessions during sprint reviews so stakeholders could see progress rather than just hear about it.

- Within a few sprints, I noticed a real shift — discussions became more collaborative, feedback was more actionable, and I started getting positive recognition from both engineering and business leaders for clear communication.

- That experience taught me that technical leadership isn’t just about writing great code — it’s about aligning people.

- Sometimes tough feedback is the best gift, because it helps you grow from being a strong individual contributor to a true cross-functional leader.

</details>

####
<details>
<summary> 🟩 Give an example of driving alignment across teams or stakeholders. </summary>

- Sure. One strong example was during the Onboarding V2 migration initiative at U.S. Bank.

- The project involved multiple teams — Frontend (UI), Backend (API), AEM Content, DevOps, and QA — spread across different time zones and managed under separate verticals. Each team had different priorities and timelines. The backend team wanted to stabilize their REST APIs before front-end integration, the AEM team wanted early hooks for dynamic content, and product owners were pushing for parallel UAT cycles.

- This misalignment was causing bottlenecks and circular dependencies, which risked delaying our first major partner rollout.

- I decided to step up and drive alignment, even though I didn’t have formal authority over all teams. Here’s what I did:

    - Visualized the dependencies — I created a clear dependency map showing which components, APIs, and environments each team relied on.

    - Facilitated a joint planning session — I invited leads from each team and walked through the timeline collaboratively instead of sequentially.

        - We identified which API endpoints were critical for early UI development.

        - Agreed on a mock-data contract so UI work could continue in parallel while the backend finalized implementations.

    - Defined shared milestones — Instead of individual team goals, I proposed cross-functional deliverables — for example, “partner configuration end-to-end validation” — that required collaboration between UI, AEM, and QA.

    - Set up a communication rhythm — a weekly 30-minute “integration sync” where we reviewed blockers, release readiness, and metrics together.

- The result? Within two sprints, we were fully aligned — UI, AEM, and API teams started delivering in parallel instead of waiting on one another. That collaboration enabled us to meet the Edward Jones rollout date on schedule, without sacrificing quality or accessibility compliance.

- The key takeaway for me was that alignment isn’t about authority — it’s about clarity and empathy. When you help people see how their work connects to a shared goal, they naturally move in the same direction.

</details>

####
<details>
<summary> 🟩 Tell me about a time you mentored or supported someone’s growth. </summary>

- Sure. During the Onboarding V2 migration project at U.S. Bank, I mentored one of our offshore developers who had recently transitioned from a Java backend role to front-end development.

- When he first joined the team, he struggled with some of the modern front-end concepts — especially around React hooks, TypeScript types, and accessibility standards (WCAG 2.1). His merge requests were often coming back with multiple review comments, and he was starting to lose confidence.

- I could see that he had great problem-solving ability — he just needed structured guidance and a bit of confidence-building. So, I decided to formally mentor him over a few sprints:

    - We started with pair programming sessions where I walked him through React patterns like state management using Redux Toolkit and component composition.

    - I created bite-sized learning challenges — for example, building a small reusable modal or form component — and reviewed his code together in real time, focusing on “why” instead of just “what to fix.”

    - I also showed him how to use linting, unit tests (Jest), and Cypress automation to self-validate code before raising merge requests.

    - Beyond the technical side, I gave him feedback on communicating progress clearly in daily stand-ups — something offshore devs sometimes find challenging when working remotely.

- Within two months, his merge request rework dropped by more than 70%, and he began proactively reviewing other developers’ code.
By the next quarter, he was independently handling partner-specific configurations for State Farm and Union Bank — and even mentoring a new hire himself.

- That experience reminded me that leadership isn’t just about solving problems — it’s about enabling others to solve them confidently.
Seeing his growth was genuinely one of the most rewarding parts of that project.

</details>

- more sample questions - https://newsletter.bigtechcareers.com/p/behavioral-interview-question-bank