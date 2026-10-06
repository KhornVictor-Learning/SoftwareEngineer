# Chapter 10: UML Sequence Diagrams Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 09 Quiz](../C9-Activity%20Diagrams/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 11 Quiz ➡️](../C11-Component%20Diagrams/quiz_prep.md)

---

#### Q1. In a sequence diagram, what does the thin rectangle drawn on a lifeline represent?
- [ ] A) The class of the object
- [x] B) An activation: the period during which the object executes a method
- [ ] C) A database transaction
- [ ] D) A combined fragment
> **Correct Answer**: **B**  
> **Explanation**: Activation bars (execution specifications) depict the duration over which an object is actively executing an operation or call stack frame.

---

#### Q2. Which arrow head marks an asynchronous message in UML 2.5?
- [ ] A) Filled (solid) head
- [x] B) Open (stick) head
- [ ] C) Hollow triangle
- [ ] D) Diamond
> **Correct Answer**: **B**  
> **Explanation**: Synchronous blocking calls use solid filled arrowheads (`──▶`). Asynchronous non-blocking messages use open stick arrowheads (`──>`).

---

#### Q3. How is object creation shown?
- [x] A) A dashed message ending at the head box of a lifeline that starts at that point in time
- [ ] B) A large X on the lifeline
- [ ] C) A bold lifeline
- [ ] D) A note saying "new"
> **Correct Answer**: **A**  
> **Explanation**: In UML 2.5, object creation is indicated by drawing the create arrow directly targeting the lifeline's head rectangle, which is positioned down at the moment of creation.

---

#### Q4. In the ECB pattern, which communication is NOT allowed?
- [ ] A) Actor to boundary
- [ ] B) Boundary to control
- [ ] C) Control to entity
- [x] D) Boundary directly to entity
> **Correct Answer**: **D**  
> **Explanation**: The Entity-Control-Boundary architectural pattern forbids boundaries (`@RestController`) from accessing entities (`@Entity`) directly, routing all logic through controls (`@Service`).

---

#### Q5. Which fragment operator models "do these messages zero or one time"?
- [ ] A) `loop`
- [ ] B) `alt`
- [x] C) `opt`
- [ ] D) `par`
> **Correct Answer**: **C**  
> **Explanation**: The `opt` (optional) combined fragment executes its sub-interaction zero or one time based on its guard condition (equivalent to `if` without `else`).

---

#### Q6. What must be true of the guards of an `alt` fragment?
- [ ] A) They must all be the same expression
- [x] B) They must be exhaustive and mutually exclusive
- [ ] C) They must reference the actor
- [ ] D) They must be numbers
> **Correct Answer**: **B**  
> **Explanation**: An `alt` fragment models mutually exclusive alternatives (`if / else if / else`); guards must not overlap and must account for all conditions.

---

#### Q7. A payment provider calls our webhook minutes after we sent it an async request. How should the webhook call be drawn?
- [ ] A) As the dashed reply of the original async message
- [x] B) As a new message from the provider to a boundary, with its own activation
- [ ] C) As a self-call on PaymentGateway
- [ ] D) It should not appear
> **Correct Answer**: **B**  
> **Explanation**: A webhook is a separate incoming HTTP request arriving asynchronously later, represented as a new message from the external actor to our boundary.

---

#### Q8. Which Mockito feature lets a test verify that mocked collaborators were called in the order shown in the diagram?
- [ ] A) `@Spy`
- [ ] B) `ArgumentCaptor`
- [x] C) `InOrder`
- [ ] D) `@MockitoBean`
> **Correct Answer**: **C**  
> **Explanation**: Mockito's `inOrder.verify(...)` asserts that method invocations occurred in the exact sequential order defined in the sequence diagram.

---

#### Q9. An OrderService message ends in `throw OutOfStockException`. Where is the HTTP status decided?
- [ ] A) In the OrderService
- [ ] B) In the repository
- [x] C) In the `@ExceptionHandler` of a `@RestControllerAdvice`, returning a `ProblemDetail`
- [ ] D) In the browser
> **Correct Answer**: **C**  
> **Explanation**: Domain services throw exceptions without knowledge of HTTP. The Spring MVC `@ControllerAdvice` catches the exception and maps it to an HTTP status code.

---

#### Q10. Which check ensures a sequence diagram is consistent with the class diagram?
- [ ] A) Every lifeline has a different colour
- [x] B) Every message is an operation of the receiver's class and the sender holds a reference to the receiver
- [ ] C) Every message has a reply
- [ ] D) There are at most three lifelines
> **Correct Answer**: **B**  
> **Explanation**: Cross-diagram consistency requires that any message dispatched to a lifeline corresponds to an existing method on that class, supported by an association or dependency in the class diagram.

---

## ⚡ High-Yield Exam Flashcards for Chapter 10

47. Sequence diagrams: Filled head (`──▶`) is **synchronous**; open head (`──>`) is **asynchronous**.
48. In ECB pattern, **Boundary cannot talk directly to Entity** (must route via Control).

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 10 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
