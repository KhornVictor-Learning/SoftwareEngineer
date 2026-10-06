# Chapter 08: UML Class Diagrams Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 07 Quiz](../C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 09 Quiz ➡️](../C9-Activity%20Diagrams/quiz_prep.md)

---

#### Q1. Which visibility symbol marks a package-private member in UML?
- [ ] A) `#`
- [x] B) `~`
- [ ] C) `-`
- [ ] D) `*`
> **Correct Answer**: **B**  
> **Explanation**: In UML: `+` is public, `-` is private, `#` is protected, and `~` is package-private.

---

#### Q2. How is a realization (a class implementing an interface) drawn?
- [ ] A) Solid line with a hollow triangle at the interface
- [x] B) Dashed line with a hollow triangle at the interface
- [ ] C) Dashed line with an open arrowhead at the class
- [ ] D) Solid line with a filled diamond at the interface
> **Correct Answer**: **B**  
> **Explanation**: Realization uses a dashed line with a hollow triangular arrowhead pointing toward the implemented interface. (Generalization uses a solid line).

---

#### Q3. A filled diamond at the Order end of the Order-OrderLine line means…
- [ ] A) `OrderLine` is optional
- [ ] B) `Order` and `OrderLine` are both abstract
- [x] C) `OrderLine` is a part owned by `Order` and dies with it
- [ ] D) `OrderLine` may be shared by several orders
> **Correct Answer**: **C**  
> **Explanation**: A filled diamond (`◆`) denotes **Composition**: a strong whole-part relationship where parts cannot exist independently of the whole.

---

#### Q4. Which Java code matches the composition `Order ◆-- OrderLine` best?
- [ ] A) `public List lines;` set from outside
- [x] B) `private final List<OrderLine> lines = new ArrayList<>();` created by `addLine()`, exposed via `List.copyOf`
- [ ] C) `private OrderLine[] lines` passed into the constructor and returned directly
- [ ] D) a static List shared by all orders
> **Correct Answer**: **B**  
> **Explanation**: Composition requires strict encapsulation where the composite root manages the creation, modification, and lifecycle of its internal parts.

---

#### Q5. `Customer "1" <-- "0..*" Order` in Mermaid says that…
- [x] A) every order has exactly one customer and `Order` holds the reference
- [ ] B) every customer has exactly one order
- [ ] C) `Customer` holds a list of orders
- [ ] D) orders and customers are unrelated
> **Correct Answer**: **A**  
> **Explanation**: The arrowhead indicates navigability (Order holds reference to Customer), multiplicity 1 means each Order has 1 Customer, and `0..*` means a Customer can have many Orders.

---

#### Q6. `OrderService.place(PlaceOrder cmd)` takes a `PlaceOrder` parameter and stores nothing. In the diagram this is…
- [ ] A) an association `OrderService --> PlaceOrder`
- [ ] B) a composition `OrderService *-- PlaceOrder`
- [x] C) a dependency `OrderService ..> PlaceOrder`
- [ ] D) a generalization
> **Correct Answer**: **C**  
> **Explanation**: A dependency (`..>`) indicates a transient "uses-a" relationship (e.g. method parameter, return type, or local variable) rather than a persistent field reference.

---

#### Q7. In Mermaid `classDiagram`, how do you mark a class as an interface?
- [ ] A) `interface PaymentGateway { }`
- [ ] B) `class PaymentGateway <> on the relation line`
- [x] C) the annotation `<<interface>>` as the first line inside the class body
- [ ] D) `PaymentGateway : interface`
> **Correct Answer**: **C**  
> **Explanation**: In Mermaid syntax, stereotypes like `<<interface>>`, `<<abstract>>`, or `<<record>>` are placed on the first line inside the class definition block.

---

#### Q8. Which JPA mapping corresponds to a composition of `OrderLine` inside `Order`?
- [ ] A) `@ManyToMany` with a join table
- [x] B) `@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)`
- [ ] C) `@ManyToOne(optional = true)`
- [ ] D) `@Transient`
> **Correct Answer**: **B**  
> **Explanation**: Composition lifecycle coupling in JPA is represented by cascading all operations and enabling `orphanRemoval = true`.

---

#### Q9. `OrderService` (package service) has an association to `JpaOrderRepository` (package repository). Which principle is violated?
- [ ] A) Single Responsibility
- [ ] B) Liskov Substitution
- [ ] C) Interface Segregation
- [x] D) Dependency Inversion
> **Correct Answer**: **D**  
> **Explanation**: The Dependency Inversion Principle (DIP) states that high-level modules (`OrderService`) should depend on abstractions (`OrderRepository` interface), not concrete implementations (`JpaOrderRepository`).

---

#### Q10. Which of these is a common mistake in a class diagram?
- [ ] A) Writing a multiplicity at both association ends
- [x] B) Listing getters and setters as the operations of every class
- [ ] C) Using `<>` for a Java interface
- [ ] D) Drawing packages as namespaces
> **Correct Answer**: **B**  
> **Explanation**: Cluttering diagrams with trivial accessors (`getId()`, `setId()`) obscures genuine domain responsibilities with unnecessary noise.

---

## ⚡ High-Yield Exam Flashcards for Chapter 08

41. Visibility symbols: `+` (public), `-` (private), `#` (protected), `~` (package-private).
42. **Composition (`◆`)**: Part cannot exist without the Whole (`Order *-- OrderLine`).
43. **Aggregation (`◇`)**: Part can exist independently of the Whole (`Team o-- Player`).

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 08 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
