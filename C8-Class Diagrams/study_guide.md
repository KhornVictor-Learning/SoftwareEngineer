# Chapter 08: UML Class Diagrams & Domain Modeling — Study Guide

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📝 **Quiz Practice**: [`quiz_prep.md`](quiz_prep.md)  
> 🧭 **Navigation**: [⬅️ Chapter 07](../C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/study_guide.md) | [📖 Syllabus](../readme.md) | [📚 Global Study Guide](../study_guide.md) | [Chapter 09 ➡️](../C9-Activity%20Diagrams/study_guide.md)

---

## 1. Why This Matters
Class diagrams model the static architectural structure of object-oriented systems: classes, interfaces, attributes, methods, and relationships.

## 2. Class Anatomy & Visibility
- A class box has three compartments:
  1. **Top**: Class Name + Stereotype (`«interface»`, `«record»`, `«abstract»`).
  2. **Middle**: Attributes: `[visibility] name : type [multiplicity] [= default]`.
  3. **Bottom**: Operations: `[visibility] name(param : Type) : ReturnType`.
- **Visibility Symbols**:
  - `+` Public
  - `-` Private
  - `#` Protected
  - `~` Package-Private

## 3. Relationship Typology Cheat Sheet

```
Dependency (dashed arrow)
  ClassA ..> ClassB        : "uses-a" (local variable, parameter, return type)

Association (solid arrow)
  ClassA --> ClassB        : "knows-a" (holds a reference as a field)

Aggregation (hollow diamond)
  Whole o-- Part           : "has-a" (part can exist without the whole)

Composition (filled diamond)
  Whole *-- Part           : "owns-a" (part dies when whole is destroyed)

Generalization (solid hollow triangle)
  Subclass --|> Superclass : "is-a" (class inheritance)

Realization (dashed hollow triangle)
  Class ..|> Interface    : "implements" (interface implementation)
```

## 4. Composition vs Aggregation: The Acid Test
- Ask: *"If I delete the Whole, does the Part still have a reason to exist?"*
  - **YES** ➔ **Aggregation (`o--`)**: A `Team` has `Player`s. If the team disbands, players still exist.
  - **NO** ➔ **Composition (`*--`)**: An `Order` owns `OrderLine` items. An order line cannot exist without its parent order. In JPA, this maps to `@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)`.

## 5. Applying SOLID in Class Diagrams
- **Single Responsibility (SRP)**: Split classes with operations from multiple domains (e.g. Order persistence, Order calculation, Email sending).
- **Dependency Inversion (DIP)**: `OrderService` must depend on an `OrderRepository` interface, NOT on `JpaOrderRepository` concrete class.

## 🚀 UML to Code & Testing Quick Reference

| UML 2.5 Element | Diagram | Java / Spring Construct | Testing Equivalent |
| :--- | :--- | :--- | :--- |
| **Class** | Class | `@Entity` or `@Component` | Unit test class |
| **Composition (`*--`)** | Class | `@OneToMany(cascade = ALL, orphanRemoval = true)` | Entity cascading test |
| **Aggregation (`o--`)** | Class | `@ManyToOne(fetch = LAZY)` | Lazy loading test |
| **Dependency (`..>`)** | Class | Method parameter or local variable | Method invocation test |


---

## 🎯 Next Steps & Practice

- 📝 Test your understanding with the **10 Official Slide Quiz Questions**:
  👉 **[Go to Chapter 08 Quiz Preparation (`quiz_prep.md`)](quiz_prep.md)**
- 🏠 Back to main course directory:
  👉 **[Software Engineering Repository Overview (`readme.md`)](../readme.md)**
