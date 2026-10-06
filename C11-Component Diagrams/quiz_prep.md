# Chapter 11: UML Component Diagrams Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 10 Quiz](../C10-Sequence%20Diagrams/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 12 Quiz ➡️](../C12-Deployment%20Diagrams/quiz_prep.md)

---

#### Q1. In UML 2.5, how is a provided interface drawn on a component?
- [ ] A) A dashed arrow with an open head
- [x] B) A lollipop: small circle on a stub line (`○—`)
- [ ] C) A half-circle socket (`—(`)
- [ ] D) A small square on the border
> **Correct Answer**: **B**  
> **Explanation**: Provided interfaces use "ball" / "lollipop" notation (`○—`), while required interfaces use "socket" notation (`—)`).

---

#### Q2. An assembly connector joins…
- [ ] A) two ports of the same component
- [ ] B) an artifact to the component it manifests
- [x] C) a required interface (socket) to a compatible provided interface (ball)
- [ ] D) a subsystem to an external system
> **Correct Answer**: **C**  
> **Explanation**: An assembly connector wires a client component's required interface socket into a supplier component's provided interface ball.

---

#### Q3. Which JPMS declaration corresponds to a required interface that another module will implement?
- [ ] A) `exports`
- [ ] B) `opens … to`
- [x] C) `uses`
- [ ] D) `requires transitive`
> **Correct Answer**: **C**  
> **Explanation**: In Java Platform Module System (`module-info.java`), `uses ServiceInterface` declares a required interface resolved at runtime via `ServiceLoader`.

---

#### Q4. In a hexagonal architecture, in which direction do all dependencies point?
- [ ] A) Downwards, from presentation to infrastructure
- [ ] B) Outwards, from the domain to the adapters
- [x] C) Into the domain: adapters depend on ports the domain declares
- [ ] D) Along the layers, left to right
> **Correct Answer**: **C**  
> **Explanation**: Hexagonal (Ports & Adapters) architecture enforces the Dependency Inversion Principle: outer adapters depend inward on core domain models and SPI ports.

---

#### Q5. What is the main problem with a dashed «use» arrow from Notification straight to Order Management?
- [ ] A) It is not valid UML
- [x] B) It does not say what is used, so internals are exposed and the boundary cannot be enforced
- [ ] C) Dashed arrows may only be used for external systems
- [ ] D) It implies an asynchronous call
> **Correct Answer**: **B**  
> **Explanation**: Raw dependency arrows fail to specify explicit contracts. Components must communicate via defined interfaces to maintain encapsulation.

---

#### Q6. Order Management depends on Notification and Notification depends on Order Management. The recommended fix is…
- [ ] A) merge both into one component
- [x] B) let Order Management publish an `OrderEvents` interface / event that Notification requires
- [ ] C) add a third "common" module that imports both
- [ ] D) mark the dependency as `«transitive»`
> **Correct Answer**: **B**  
> **Explanation**: Cyclic dependencies are broken via Dependency Inversion or event-driven architecture: Order Management emits events consumed by Notification.

---

#### Q7. Which ArchUnit rule fails when there is a dependency cycle between component packages?
- [x] A) `slices().matching("edu.itc.shop.(*)..").should().beFreeOfCycles()`
- [ ] B) `noClasses().should().dependOnClassesThat().resideInAPackage("..web..")`
- [ ] C) `classes().should().bePublic()`
- [ ] D) `layeredArchitecture().consideringAllDependencies()`
> **Correct Answer**: **A**  
> **Explanation**: ArchUnit's `slices().should().beFreeOfCycles()` inspects package structures to guarantee that architectural dependencies form a Directed Acyclic Graph (DAG).

---

#### Q8. What does "Used undeclared dependencies" from `mvn dependency:analyze` tell you?
- [ ] A) A declared dependency is never used and should be removed
- [x] B) The code uses a library that arrives only transitively, so the diagram is missing an edge
- [ ] C) A module has a cycle
- [ ] D) A test-scoped dependency leaked into main code
> **Correct Answer**: **B**  
> **Explanation**: This warning indicates that the project directly references classes from a library not explicitly listed in `pom.xml`, relying on unsafe transitive inheritance.

---

#### Q9. A C4 container diagram differs from a UML component diagram mainly because it…
- [x] A) shows people and deployable containers with technology labels instead of interfaces and connectors
- [ ] B) is the same thing under another name
- [ ] C) only shows classes
- [ ] D) cannot show external systems
> **Correct Answer**: **A**  
> **Explanation**: The C4 Model Container diagram highlights runnable processes (databases, mobile apps, SPA, microservices) with explicit technology choices.

---

#### Q10. In a component × responsibility matrix, a row with two ticks means…
- [ ] A) good redundancy for availability
- [x] B) the responsibility has two owners: duplicated logic or a shared table that must be resolved
- [ ] C) the component is a library
- [ ] D) the row belongs to an external system
> **Correct Answer**: **B**  
> **Explanation**: Every business responsibility must have exactly one single owner component to avoid duplicate logic and split database tables.

---

## ⚡ High-Yield Exam Flashcards for Chapter 11

49. Component diagrams: Provided interface = **Lollipop (`○—`)**; Required interface = **Socket (`—)`)**.

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 11 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
