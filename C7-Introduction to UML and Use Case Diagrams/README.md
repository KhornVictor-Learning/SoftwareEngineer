# Chapter 07: Introduction to UML & Use Case Diagrams

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C7-Introduction to UML and Use Case Diagrams`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **The Rationale for Visual Modeling**:
   - Bridging the gap between ambiguous natural language prose and overly detailed implementation code.
   - Martin Fowler's three modeling modes: *UML as Sketch* (informal whiteboard discussions), *UML as Blueprint* (detailed architectural design prior to coding), and *UML as Programming Language* (executable models).
2. **UML 2.5.1 Standard Overview**:
   - Standardized by the Object Management Group (OMG, December 2017).
   - 14 diagram types categorized into two distinct families:
     - **Structure Diagrams** (Static: Class, Component, Deployment, Object, Package, Composite Structure, Profile).
     - **Behavior Diagrams** (Dynamic: Use Case, Activity, Sequence, State Machine, Communication, Interaction Overview, Timing).
3. **Use Case Core Elements**:
   - System Boundary (`«subject»`): The boundary separating what is inside the software under design from external entities.
   - Actors: External entities interacting with the system (represented as stick figures).
   - Use Cases: Units of observable business value delivered to an actor (represented as horizontal ellipses).
   - Naming Conventions: Use cases must be named with an active verb phrase from the actor's perspective (`Place Order`, `Track Shipment`, never passive nouns like `Order Management`).
4. **Actor Classifications**:
   - **Primary Actors**: External actors who initiate the interaction to achieve a personal business goal (placed on the left of the diagram).
   - **Supporting / Secondary Actors**: External systems or organizations that provide services to the system (e.g., `Payment Gateway`, `Email Provider`, `Warehouse ERP`; placed on the right).
   - System-as-Actor Anti-Pattern: Never model internal components, databases, or classes as actors.
5. **Relationships in Use Case Diagrams**:
   - **Association**: A solid line indicating direct interaction between an actor and a use case.
   - **«include»**: Mandatory, unconditional sub-routine reuse. The base use case cannot complete successfully without executing the included use case (dashed arrow pointing from base to included).
   - **«extend»**: Optional or conditional workflow insertion based on explicit guards (e.g., applying a promotional voucher during checkout). The dashed arrow points from the extension back to the base use case.
   - **Generalization**: Inheritance between actors (e.g., `Registered Customer` inherits all capabilities of `Guest Customer`) or between use cases (e.g., `Card Payment` specializes `Pay for Order`).
6. **Cockburn Goal Levels & System Scope**:
   - Sky / Cloud Level: Enterprise summary context.
   - Kite Level: Multi-session business process summary.
   - **Sea Level (User Goal)**: The core level for use cases — a single sitting that delivers distinct business value.
   - Fish / Submarine Level: Sub-function utility steps (best modeled as internal steps or «include» fragments).
7. **Use Case Textual Specifications**:
   - A diagram ellipse is merely a title; the actual requirements live in the structured specification.
   - Formal specification anatomy: Use Case ID & Name, Primary Actor, Stakeholders & Interests, Preconditions (guaranteed truths before start), Minimal Guarantees (failure postconditions), Success Postconditions, Main Success Scenario (numbered steps), Extensions / Alternative Flows (e.g., `3a. Card declined`).
8. **Traceability to Code & Testing**:
   - Mapping Business Requirements (BR) ➔ Use Cases (UC) ➔ Acceptance Tests (Gherkin BDD Given-When-Then) ➔ JUnit Integration Tests.
9. **Modeling Anti-Patterns**:
   - Functional decomposition (creating micro-use cases for `Enter Password`, `Click Button`).
   - "Spiderweb" diagrams with tangled, overlapping dependency lines.
10. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions on «include» vs «extend», primary vs supporting actors, and system boundaries.
    - **Lab-07**: 5 use case modeling tasks + 1 complete textual specification challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 06: C6-Testing in Java Web Applications (JUnit, Mockito)](../C6-Testing%20in%20Java%20Web%20Applications%20%28JUnit%2C%20Mockito%29/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 08: C8-Class Diagrams](../C8-Class%20Diagrams/README.md)

