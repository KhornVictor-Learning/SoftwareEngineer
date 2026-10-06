# Chapter 07: Introduction to UML & Use Case Diagrams Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 06 Quiz](../C6-Testing%20in%20Java%20Web%20Applications%20%28JUnit%2C%20Mockito%29/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 08 Quiz ➡️](../C8-Class%20Diagrams/quiz_prep.md)

---

#### Q1. What is UML 2.5.1 best described as?
- [ ] A) A software development process
- [x] B) A graphical modelling language standardised by the OMG
- [ ] C) A Java code generator
- [ ] D) A testing framework
> **Correct Answer**: **B**  
> **Explanation**: UML is a standard visual modeling language specified by the Object Management Group (OMG); it is a notation, not a methodology or development process.

---

#### Q2. Which of these is a UML structure diagram?
- [ ] A) Sequence diagram
- [ ] B) Activity diagram
- [x] C) Component diagram
- [ ] D) Use case diagram
> **Correct Answer**: **C**  
> **Explanation**: Structure diagrams model static elements (Component, Class, Deployment, Object). Behavior diagrams model dynamic workflows (Activity, Sequence, Use Case, State Machine).

---

#### Q3. In the online shop, how should the external Payment Gateway appear on the use case diagram?
- [ ] A) As a use case inside the boundary
- [x] B) As a supporting actor outside the boundary, on the right
- [ ] C) As a note attached to Pay for order
- [ ] D) It should not appear at all
> **Correct Answer**: **B**  
> **Explanation**: External systems that provide auxiliary services to the application are modeled as supporting actors placed outside the system boundary on the right.

---

#### Q4. What does `UC2 ..> UC6 : <<include>>` mean?
- [ ] A) UC6 optionally adds behaviour to UC2
- [x] B) UC2 always runs the behaviour of UC6 as part of itself
- [ ] C) UC6 is a specialisation of UC2
- [ ] D) UC2 and UC6 share an actor
> **Correct Answer**: **B**  
> **Explanation**: An `«include»` dependency indicates mandatory, unconditional execution of the target use case as an essential step of the base use case.

---

#### Q5. In which direction does the `«extend»` dashed arrow point?
- [ ] A) From the base use case to the extension
- [x] B) From the extension to the base use case
- [ ] C) From the actor to the extension
- [ ] D) Either direction is acceptable
> **Correct Answer**: **B**  
> **Explanation**: The `«extend»` relationship arrow points from the optional extending use case back to the base use case that it extends.

---

#### Q6. Which is the best use case name?
- [ ] A) `Order`
- [ ] B) `Click the Pay button`
- [x] C) `Place order`
- [ ] D) `OrderService.placeOrder`
> **Correct Answer**: **C**  
> **Explanation**: Proper use case names follow the **Active Verb + Business Noun** format at the user goal level (`Place order`).

---

#### Q7. Which statement about preconditions is correct?
- [ ] A) They are checked again in step 1 of the main scenario
- [ ] B) They describe the state after the use case succeeds
- [x] C) They must be true before the use case starts and are not re-checked in the steps
- [ ] D) They list the supporting actors
> **Correct Answer**: **C**  
> **Explanation**: Preconditions state assumptions guaranteed to be true prior to initiation; they do not need redundant checking steps in the main scenario.

---

#### Q8. What does a solid line with a hollow triangle between `Registered customer` and `Customer` express?
- [ ] A) `Registered customer` includes `Customer`
- [x] B) `Registered customer` is a specialisation of `Customer` and inherits its associations
- [ ] C) `Customer` extends `Registered customer`
- [ ] D) They are the same actor drawn twice
> **Correct Answer**: **B**  
> **Explanation**: A solid line with a hollow triangle represents generalization/inheritance. The specialized child actor inherits all associations of the parent actor.

---

#### Q9. What does a traceability matrix in this chapter link together?
- [ ] A) Classes, packages and modules
- [x] B) Business requirements, use cases and tests
- [ ] C) Actors, screens and database tables
- [ ] D) Sprints, stories and developers
> **Correct Answer**: **B**  
> **Explanation**: A traceability matrix connects high-level Business Requirements (BR) to Use Cases (UC) and automated verification Tests.

---

#### Q10. A diagram shows `Login`, `Enter address`, `Click Pay` and `Show confirmation` as use cases chained with `«include»`. What is the main mistake?
- [x] A) Functional decomposition: UI steps drawn as use cases instead of one user goal
- [ ] B) Too few actors
- [ ] C) Missing generalization
- [ ] D) The system boundary is too small
> **Correct Answer**: **A**  
> **Explanation**: Decomposing single user goals into fine-grained UI button clicks and screens is the classic "functional decomposition" anti-pattern in use case modeling.

---

## ⚡ High-Yield Exam Flashcards for Chapter 07

37. UML is a standard modeling language by the **OMG** (Structure vs Behavior diagrams).
38. Primary actors initiate the use case (placed on **left**); Supporting actors provide external services (placed on **right**).
39. `«include»` is mandatory/unconditional (Base ➔ Included); `«extend»` is optional/conditional (Extension ➔ Base).
40. Use case names must be **Active Verb + Business Noun** at the user goal level (`Place order`).

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 07 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
