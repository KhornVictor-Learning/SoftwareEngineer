# Chapter 10: UML Sequence Diagrams & Dynamic Interactions

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C10-Sequence Diagrams`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **Temporal Interaction Semantics**:
   - Visualizing how objects collaborate to realize a single specific use case scenario.
   - Two-dimensional layout: Horizontal axis lists participants (lifelines); vertical axis represents the linear progression of time (flowing from top to bottom).
2. **Core Notation Elements**:
   - **Lifeline**: Participant head box (`name : Class`) with a dashed vertical stem.
   - **Activation Bar (Execution Specification)**: Thin vertical rectangle on a lifeline indicating active execution of a method.
   - **Synchronous Call (`──▶` solid line, filled arrowhead)**: Caller invokes an operation and blocks until execution completes and returns.
   - **Asynchronous Message (`──>` solid line, open stick arrowhead)**: Caller dispatches a message non-blockingly and continues execution immediately (e.g., `@Async`, message queues).
   - **Reply / Return Message (`┈┈>` dashed line, open arrowhead)**: Returns control and result values back to the caller.
   - **Object Creation & Destruction**: `«create»` message pointing directly at a newly instantiated lifeline box; a large `X` marking the termination/closing of a resource.
3. **The Entity-Control-Boundary (ECB) Architectural Pattern**:
   - **Actor**: The external user or triggering system.
   - **«boundary»**: Interaction points on the system edge (Spring `@RestController`, HTTP client adapters).
   - **«control»**: Application orchestrators and transaction managers (Spring `@Service`).
   - **«entity»**: Business models and persistence gateways (Spring `@Repository`, JPA `@Entity`).
4. **Combined Interaction Fragments (UML 2.5.1 §17.6)**:
   - Framed interaction boxes with operator labels and dashed dividing lines:
     - `alt`: Alternative execution paths (`if / else if / else`) based on mutually exclusive guards.
     - `opt`: Optional execution path (single `if` without `else`).
     - `loop`: Repeated execution with iteration limits or boolean guards `[while hasItems]`.
     - `par`: Parallel concurrent execution paths.
     - `break`: Exceptional exit breaking out of the enclosing frame (maps to Java `throw` or early `return`).
     - `critical`: Atomic critical section (executes without interleaving).
5. **Advanced Interaction Patterns**:
   - Self-calls: Internal helper method calls creating stacked, nested activation bars.
   - Asynchronous callbacks and webhooks (e.g., payment provider notifying an asynchronous webhook endpoint).
6. **Direct Code & Test Traceability**:
   - The first incoming message into a boundary directly defines the REST API endpoint and HTTP method.
   - Deriving Mockito unit tests directly from sequence diagrams:
     - Participant lifelines become `@Mock` dependencies.
     - Dashed return messages become `when(...).thenReturn(...)` stubs.
     - Solid call arrows become `inOrder.verify(...)` verification assertions.
   - Consistency rule: Every message label in a sequence diagram must correspond to a declared public operation on the receiver's class diagram.
7. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions on activation bars, message arrows, combined fragments (`alt`, `opt`, `par`), and ECB patterns.
    - **Lab-10**: 5 sequence modeling tasks + 1 webhook callback interaction challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 09: C9-Activity Diagrams](../C9-Activity%20Diagrams/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 11: C11-Component Diagrams](../C11-Component%20Diagrams/README.md)

