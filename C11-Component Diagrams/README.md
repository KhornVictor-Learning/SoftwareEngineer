# Chapter 11: UML Component Diagrams & Modular Architectures

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C11-Component Diagrams`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **Component Abstraction**:
   - Moving beyond individual classes: A component is a modular, replaceable unit of functionality that encapsulates its internals and exposes explicit contracts (UML 2.5.1 §11.6).
2. **Interface Notations & Connectors**:
   - **Ports**: Small square boxes on the component boundary defining interaction points.
   - **Provided Interface ("Lollipop" / Ball `──○`)**: The public API or contract that the component implements and offers to callers.
   - **Required Interface ("Socket" `──)`)**: The external dependency or contract that the component expects in order to perform its work.
   - **Assembly Connectors (`──○)`)**: Plugging a provided interface directly into a required interface (representing dependency injection or library linking).
   - **Delegation Connectors**: Internal arrows forwarding messages between an external boundary port and internal implementation classes.
3. **Architectural Styles & Component Boundaries**:
   - **The Modular Monolith**: Multiple cohesive components packaged into a single deployable artifact (`shop.jar`), enforcing boundaries at compile/test time.
   - **Microservices Architecture**: Components mapped one-to-one to independent network services with isolated databases and network APIs.
   - **Hexagonal / Ports-and-Adapters Architecture**: Core domain business logic isolated from infrastructure technologies through explicit SPI ports and adapter implementations.
4. **Mapping Components to Java & Build Tools**:
   - Mapping components to Maven multi-modules (`shop-orders`, `shop-catalog`, `shop-payment`).
   - Java Platform Module System (JPMS `module-info.java`): Using `exports`, `requires`, `uses`, and `provides ... with` via `java.util.ServiceLoader`.
   - **Spring Modulith**: Structuring application packages into verified modules, utilizing `@ApplicationModuleListener` for event-driven inter-module communication.
5. **Architectural Governance & Quality Attributes**:
   - Enforcing Directed Acyclic Graphs (DAG): Detecting and breaking cyclic module dependencies.
   - Automated Architectural Fitness Testing: Using **ArchUnit** in CI to guarantee that controllers never bypass services or access repositories directly.
   - Dependency verification using `jdeps` and `mvn dependency:analyze`.
   - Comparison with the C4 Model (C4 Component & Container diagrams).
   - Documenting architectural evolution using **Architecture Decision Records (ADRs)** within the arc42 framework.
6. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions on lollipops/sockets, assembly connectors, modular monoliths, and ArchUnit rules.
    - **Lab-11**: 5 component modeling tasks + 1 modular monolith refactoring challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 10: C10-Sequence Diagrams](../C10-Sequence%20Diagrams/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 12: C12-Deployment Diagrams](../C12-Deployment%20Diagrams/README.md)

