# Chapter 09: UML Activity Diagrams Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 08 Quiz](../C8-Class%20Diagrams/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 10 Quiz ➡️](../C10-Sequence%20Diagrams/quiz_prep.md)

---

#### Q1. Which symbol is the activity final node?
- [ ] A) A filled circle
- [x] B) A circle with a filled dot inside
- [ ] C) A circle with an X inside
- [ ] D) A thick horizontal bar
> **Correct Answer**: **B**  
> **Explanation**: An Activity Final Node is drawn as a bullseye (a circle containing a solid black dot `⊙`).

---

#### Q2. What is the difference between a flow final `⊗` and an activity final `⊙`?
- [ ] A) There is none, they are synonyms
- [x] B) A flow final ends only the arriving token; an activity final terminates all flows
- [ ] C) A flow final may appear only inside swimlanes
- [ ] D) An activity final is used only in business processes
> **Correct Answer**: **B**  
> **Explanation**: A Flow Final (`⊗`) terminates only its specific branch without affecting concurrent branches. An Activity Final (`⊙`) stops the entire activity and destroys all active tokens.

---

#### Q3. Where is the condition of a decision node written?
- [ ] A) Inside the diamond
- [x] B) On the outgoing edges as guards in square brackets
- [ ] C) On the incoming edge
- [ ] D) In a note attached to the diamond
> **Correct Answer**: **B**  
> **Explanation**: In UML, diamond decision nodes contain no text; branch conditions are written as boolean guards in brackets `[guard]` on outgoing edges.

---

#### Q4. A merge node…
- [ ] A) waits for a token on every incoming edge
- [x] B) passes any arriving token straight on without synchronising
- [ ] C) duplicates the token on every outgoing edge
- [ ] D) is drawn as a thick bar
> **Correct Answer**: **B**  
> **Explanation**: A merge node combines alternate incoming paths and immediately releases any token that arrives without synchronization.

---

#### Q5. An action with two incoming control flow edges, where only one path is ever taken,…
- [ ] A) runs as soon as either token arrives
- [x] B) is an implicit join and never runs
- [ ] C) runs twice
- [ ] D) is a syntax error in UML
> **Correct Answer**: **B**  
> **Explanation**: Multiple edges entering an action form an implicit join, requiring tokens on *all* incoming edges. If only one path produces a token, the action deadlocks and never executes.

---

#### Q6. Guards on one decision node must be…
- [x] A) complete and mutually exclusive
- [ ] B) written in natural language only
- [ ] C) at most two
- [ ] D) ordered alphabetically
> **Correct Answer**: **A**  
> **Explanation**: Guards must cover all possible inputs (complete) without overlap (mutually exclusive) to avoid deadlock or ambiguous non-deterministic routing.

---

#### Q7. Which Java construct corresponds to a fork followed by a join?
- [ ] A) `if / else`
- [x] B) `CompletableFuture.allOf` or a `StructuredTaskScope`
- [ ] C) a `for` loop
- [ ] D) `try / finally`
> **Correct Answer**: **B**  
> **Explanation**: A fork initiates concurrent parallel execution; a join waits for all parallel tasks to finish before proceeding (`CompletableFuture.allOf`).

---

#### Q8. What does a swimlane (activity partition) express?
- [ ] A) The time at which an action runs
- [x] B) Who or what is responsible for the actions inside it
- [ ] C) The exception type of a handler
- [ ] D) The loop condition
> **Correct Answer**: **B**  
> **Explanation**: Partitions/swimlanes group actions according to the entity, organizational department, or architectural subsystem that performs them.

---

#### Q9. What happens when the accept event inside an interruptible region fires?
- [ ] A) Nothing until the region finishes
- [x] B) All tokens inside the region are destroyed and the flow continues along the interrupting edge
- [ ] C) The activity restarts from the initial node
- [ ] D) A join is executed
> **Correct Answer**: **B**  
> **Explanation**: Firing an interruptive event immediately terminates all internal tokens within the interruptible activity region and transfers control along the lightning edge.

---

#### Q10. Which element maps naturally to a Spring `@Scheduled` method?
- [ ] A) An object node
- [x] B) An accept time event (hourglass)
- [ ] C) A merge node
- [ ] D) A pin
> **Correct Answer**: **B**  
> **Explanation**: In UML, an accept time event (drawn as an hourglass) generates a token when a specific time or recurring schedule triggers.

---

## ⚡ High-Yield Exam Flashcards for Chapter 09

44. Activity diagrams use **token flow semantics** (Petri nets).
45. In Activity diagrams, Decision diamond branches must be **mutually exclusive** and **complete**.
46. Multiple edges entering an action without a merge form an **implicit join** (waits for all edges).

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 09 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
