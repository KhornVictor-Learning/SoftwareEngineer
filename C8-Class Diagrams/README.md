# Chapter 08: UML Class Diagrams & Domain Modeling

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C8-Class Diagrams`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **Purpose & Levels of Modeling**:
   - Modeling static system structure: classes, interfaces, attributes, operations, and relationships.
   - Three abstraction levels: Conceptual / Domain Model (analysis), Design Model (types, visibility, packages), and Implementation Model (one-to-one Java/JPA code mapping).
2. **Class Anatomy (Three Compartments)**:
   - **Top Compartment**: Class name with optional stereotype (`«interface»`, `«abstract»`, `«record»`, `«enumeration»`).
   - **Middle Compartment**: Attributes formatted as `[visibility] name : type [multiplicity] [= default] [{modifiers}]`.
   - **Bottom Compartment**: Operations formatted as `[visibility] name(param: Type) : ReturnType`.
3. **Visibility Notation**:
   - `+` Public
   - `-` Private
   - `#` Protected
   - `~` Package-private
4. **Relationship Taxonomy & Semantics**:
   - **Association**: Structural link between instances. Annotated with navigability arrows, role names, and multiplicities (`1`, `0..1`, `*`, `1..*`).
   - **Aggregation (`◇` hollow diamond)**: Shared whole-part relationship ("has-a"). The part can exist independently of the whole (e.g., a `Team` has `Players`).
   - **Composition (`◆` filled diamond)**: Strict composite whole-part relationship. The part's lifecycle is bound to the whole; deleting the whole destroys the part (e.g., an `Order` owns its `OrderLine` items).
   - **Generalization (`──▷` solid line, hollow triangle)**: Object-oriented inheritance ("is-a").
   - **Realization (`┈┈▷` dashed line, hollow triangle)**: Contractual implementation of an interface.
   - **Dependency (`┈┈>` dashed arrow)**: Weakest relationship ("uses-a"). Indicates that a change in the supplier may force a change in the client (used for method parameters, return types, local variables, or factory creations).
5. **Domain Modeling with SOLID Principles**:
   - **Single Responsibility Principle (SRP)**: Ensuring classes represent one cohesive bundle of responsibilities (splitting monolithic classes with 15+ disparate methods).
   - **Open/Closed Principle (OCP)**: Extensibility through interfaces and the Template Method pattern without modifying existing classes.
   - **Liskov Substitution Principle (LSP)**: Derived classes must remain substitutable for base types without breaking contracts.
   - **Interface Segregation Principle (ISP)**: Decomposing bloated interfaces into role-specific contracts.
   - **Dependency Inversion Principle (DIP)**: High-level modules depending on abstractions rather than concrete low-level implementations.
6. **Packages & Architectural Namespaces**:
   - Grouping classes into namespaces (`edu.itc.shop.domain`, `edu.itc.shop.infrastructure`).
   - Enforcing inward dependency directions and preventing package dependency cycles.
7. **Mapping UML to Java 25 & Jakarta Persistence 3.2**:
   - UML Class ➔ Java `@Entity` class.
   - UML Value Object ➔ Java `record` with `@Embeddable`.
   - UML Composition ➔ `@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)`.
   - UML Association ➔ `@ManyToOne(fetch = FetchType.LAZY)`.
   - UML Generalization ➔ JPA `@Inheritance(strategy = InheritanceType.JOINED)`.
8. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions on aggregation vs composition, visibility symbols, navigability, and SOLID principles.
    - **Lab-08**: 5 class diagram design tasks + 1 SOLID refactoring challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 07: C7-Introduction to UML and Use Case Diagrams](../C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 09: C9-Activity Diagrams](../C9-Activity%20Diagrams/README.md)

