# Chapter 09: UML Activity Diagrams & Workflow Modeling — Study Guide

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📝 **Quiz Practice**: [`quiz_prep.md`](quiz_prep.md)  
> 🧭 **Navigation**: [⬅️ Chapter 08](../C8-Class%20Diagrams/study_guide.md) | [📖 Syllabus](../readme.md) | [📚 Global Study Guide](../study_guide.md) | [Chapter 10 ➡️](../C10-Sequence%20Diagrams/study_guide.md)

---

## 1. Why This Matters
Activity diagrams model business workflows, complex processes, and concurrent algorithms using **token flow semantics** (Petri nets).

## 2. Core Nodes & Symbols
- **Initial Node (`●`)**: Workflow start; emits initial token.
- **Activity Final Node (`⊙` Bullseye)**: Terminates the entire workflow; destroys ALL tokens across all parallel branches.
- **Flow Final Node (`⊗` Circle with X)**: Terminates only the single path/token that reaches it; other parallel flows continue running.
- **Action Node (Rounded rectangle)**: Atomic step (e.g., `Validate Cart`).
- **Object Node (Sharp rectangle)**: Data or entity state (e.g., `Order [placed]`).

## 3. Control Nodes: Branching vs Concurrency

| Node | Symbol | Inputs / Outputs | Behavior | Code Counterpart |
| :--- | :---: | :---: | :--- | :--- |
| **Decision** | Diamond `◇` | 1 in, multiple out | Routes 1 token to the branch whose `[guard]` is true | `if / else` |
| **Merge** | Diamond `◇` | multiple in, 1 out | Passes any arriving token straight through | Merge point after `if` |
| **Fork** | Thick bar | 1 in, multiple out | Duplicates token to run all branches in parallel | `CompletableFuture.runAsync` |
| **Join** | Thick bar | multiple in, 1 out | Synchronizes: waits for tokens on ALL inputs | `CompletableFuture.allOf` |

> ⚠️ **The Implicit Join Trap**: If an action node has two incoming edges without a merge diamond, it acts as an **implicit join**! If only one path is taken at runtime, the action waits forever and **NEVER RUNS**. Always use a Merge node for alternative paths!

## 4. Swimlanes (Partitions)
Swimlanes divide the activity diagram into columns or rows, explicitly allocating who (e.g. `Customer`, `Web App`, `Payment Gateway`, `Warehouse`) performs each action.

## 🚀 UML to Code & Testing Quick Reference

| UML 2.5 Element | Diagram | Java / Spring Construct | Testing Equivalent |
| :--- | :--- | :--- | :--- |
| **Decision / Merge** | Activity | `if / else` conditional | Branch coverage test |
| **Fork / Join** | Activity | `CompletableFuture.allOf()` | Concurrency timeout test |
| **Swimlane** | Activity | Architectural layer or remote microservice | Integration slice test |


---

## 🎯 Next Steps & Practice

- 📝 Test your understanding with the **10 Official Slide Quiz Questions**:
  👉 **[Go to Chapter 09 Quiz Preparation (`quiz_prep.md`)](quiz_prep.md)**
- 🏠 Back to main course directory:
  👉 **[Software Engineering Repository Overview (`readme.md`)](../readme.md)**
