# Chapter 09: UML Activity Diagrams & Workflow Modeling

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C9-Activity Diagrams`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **Behavioral Token-Flow Semantics**:
   - Semantics based on Petri nets: execution is driven by discrete control and object tokens flowing along edges.
   - Action activation rule: An action executes when tokens arrive on all required incoming edges, and emits tokens on outgoing edges upon completion.
2. **Core Activity Nodes & Symbols**:
   - **Initial Node (`●` solid circle)**: Marks the start of workflow execution and generates the initial token.
   - **Activity Final Node (`⊙` bullseye circle)**: Terminates the entire activity and annihilates all active tokens across all branches.
   - **Flow Final Node (`⊗` circle with an X)**: Terminates a specific execution path without affecting concurrent branches.
   - **Action Node (rounded rectangle)**: Represents an atomic step (named with active verb + noun, e.g., `Reserve Stock`).
   - **Object Node (sharp rectangle)**: Represents data or entity state traveling through the workflow (e.g., `Order [placed]`), connected via object flow edges and action pins.
3. **Control Flow Branching & Synchronization**:
   - **Decision Node (`◇` diamond)**: 1 input, multiple outputs. Routes a single token along the path whose boolean `[guard]` condition evaluates to true. Guards must be mutually exclusive and collectively exhaustive.
   - **Merge Node (`◇` diamond)**: Multiple inputs, 1 output. Merges alternate paths back together; passes any arriving token directly without waiting.
   - **Fork Node (thick horizontal/vertical bar)**: 1 input, multiple outputs. Splits execution into concurrent parallel flows by duplicating tokens.
   - **Join Node (thick bar)**: Multiple inputs, 1 output. Synchronizes parallel flows by waiting for tokens to arrive on *all* incoming edges before releasing one output token.
4. **Swimlanes (Activity Partitions)**:
   - Allocating responsibilities across architectural layers, departments, or systems (e.g., `Customer`, `Web App`, `Payment Gateway`, `Warehouse ERP`).
5. **Iteration & Advanced Workflow Constructs**:
   - Looping: Structured using a merge node preceding a decision node with a backward feedback loop.
   - Expansion Regions (`«iterative»` vs `«parallel»`): Visualizing "for-each" processing over collections without explicit loops.
   - Interruptible Activity Regions: Dashed bounding boxes with a zig-zag lightning interrupting edge for handling cancellations, aborts, and timeouts.
   - Exception Handlers: Protected activity nodes paired with catch handlers to handle failure scenarios.
6. **Translating Workflows to Production Code**:
   - Mapping initial/final nodes to method entry and return points.
   - Mapping decisions and merges to `if / else` or `switch` statements.
   - Mapping forks and joins to `CompletableFuture.allOf()` or Java 21 Structured Concurrency.
7. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions covering decision vs fork, token flow mechanics, swimlanes, and interruptible regions.
    - **Lab-09**: 5 activity modeling tasks + 1 complex returns handling workflow challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 08: C8-Class Diagrams](../C8-Class%20Diagrams/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 10: C10-Sequence Diagrams](../C10-Sequence%20Diagrams/README.md)

