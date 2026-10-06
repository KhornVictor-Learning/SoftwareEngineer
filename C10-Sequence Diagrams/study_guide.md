# Chapter 10: UML Sequence Diagrams & Dynamic Interactions — Study Guide

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📝 **Quiz Practice**: [`quiz_prep.md`](quiz_prep.md)  
> 🧭 **Navigation**: [⬅️ Chapter 09](../C9-Activity%20Diagrams/study_guide.md) | [📖 Syllabus](../readme.md) | [📚 Global Study Guide](../study_guide.md) | [Chapter 11 ➡️](../C11-Component%20Diagrams/study_guide.md)

---

## 1. Why This Matters
Sequence diagrams show how objects collaborate over time to realize a specific use case scenario.

## 2. Core Notations
- **Lifeline**: Rectangle head box (`name : Class`) with a dashed vertical line.
- **Activation Bar**: Narrow vertical rectangle showing when an object is actively executing a method.
- **Synchronous Message (`──▶` Solid line, filled arrowhead)**: Caller invokes method and blocks until return.
- **Asynchronous Message (`──>` Solid line, open stick arrowhead)**: Caller sends message and continues without waiting (`@Async`, MQ).
- **Return / Reply (`┈┈>` Dashed line, open arrowhead)**: Returns control and data.
- **Object Creation**: `«create»` message pointing directly at the lifeline head box.

## 3. Entity-Control-Boundary (ECB) Pattern
- **Actor**: External user.
- **`«boundary»`**: Controllers, web adapters (`OrderController`).
- **`«control»`**: Business workflow coordinators (`OrderService`).
- **`«entity»`**: Domain entities and repositories (`Order`, `OrderRepository`).
- *Strict Rule*: Boundaries cannot talk directly to Entities! Communication must flow: `Actor ➔ Boundary ➔ Control ➔ Entity`.

## 4. Combined Interaction Fragments (UML 2.5.1 §17.6)
- **`alt`**: Alternative execution (`if / else if / else`). Guards must be mutually exclusive and exhaustive.
- **`opt`**: Optional execution (`if` without `else`).
- **`loop`**: Iteration (`for`, `while`). Guard indicates condition or bounds: `loop [1, 10]`.
- **`par`**: Parallel / concurrent interactions.
- **`break`**: Exceptional exit (throwing an exception or early return).

## 🚀 UML to Code & Testing Quick Reference

| UML 2.5 Element | Diagram | Java / Spring Construct | Testing Equivalent |
| :--- | :--- | :--- | :--- |
| **Lifeline** | Sequence | Collaborator instance (`@Mock`, `@Service`) | `@InjectMocks` target |
| **Sync Message (`──▶`)**| Sequence | Direct Java method call | Standard assertion |
| **Async Message (`──>`)**| Sequence | `@Async` or Kafka message | Event listener test |
| **Boundary (`«boundary»`)** | Sequence | `@RestController` | `@WebMvcTest` with `MockMvc` |
| **Combined `alt`** | Sequence | `if ... else` block | Parameterized test |


---

## 🎯 Next Steps & Practice

- 📝 Test your understanding with the **10 Official Slide Quiz Questions**:
  👉 **[Go to Chapter 10 Quiz Preparation (`quiz_prep.md`)](quiz_prep.md)**
- 🏠 Back to main course directory:
  👉 **[Software Engineering Repository Overview (`readme.md`)](../readme.md)**
