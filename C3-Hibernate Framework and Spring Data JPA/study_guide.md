# Chapter 03: Hibernate Framework & Spring Data JPA — Study Guide

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📝 **Quiz Practice**: [`quiz_prep.md`](quiz_prep.md)  
> 🧭 **Navigation**: [⬅️ Chapter 02](../C2-Spring%20Framework/study_guide.md) | [📖 Syllabus](../readme.md) | [📚 Global Study Guide](../study_guide.md) | [Chapter 04 ➡️](../C4-RESTful%20Web%20Services%20%28JAX-RS%29/study_guide.md)

---

## 1. Why This Matters
Writing manual SQL and mapping `ResultSet` rows to objects by hand is repetitive and error-prone. Jakarta Persistence (JPA) and Hibernate map Java objects directly to database tables, handling relationships, caching, and dirty checking automatically.

## 2. Core Mental Models & Definitions
- **Specification vs Implementation**:
  - **JPA 3.2** (`jakarta.persistence.*`): The official standard specification.
  - **Hibernate 7.4**: The concrete ORM library implementing the JPA standard.
  - **Spring Data JPA**: A repository abstraction built on top of JPA to generate queries from interface method names.
- **Persistence Context & First-Level Cache**:
  - The `EntityManager` maintains an in-memory identity map of all managed entities within a transaction.
  - It takes an initial snapshot upon loading. At transaction commit (**flush**), it performs **dirty checking**: compares current entity state against the snapshot and generates SQL `UPDATE`s only for fields that actually changed! You never need to call `save()` on a managed entity!

## 3. Entity States Lifecycle

```
[Transient / New] ──(persist / save)──▶ [Managed] ──(detach / clear)──▶ [Detached]
                                            │
                                      (remove / delete)
                                            │
                                            ▼
                                        [Removed]
```

## 4. Associations & The Golden Rules of JPA

| Relationship | Default Fetch Type | Recommended Override |
| :--- | :---: | :---: |
| `@ManyToOne` | **EAGER** ⚠️ | **Change to `FetchType.LAZY`!** |
| `@OneToOne` | **EAGER** ⚠️ | **Change to `FetchType.LAZY`!** |
| `@OneToMany` | **LAZY** ✅ | Keep `LAZY` |
| `@ManyToMany` | **LAZY** ✅ | Keep `LAZY` |

- **`mappedBy`**: Placed on the inverse side of a bidirectional relationship. It tells Hibernate: *"I do not hold the foreign key column; go look at the property named in `mappedBy` on the other entity!"*

## 5. Concurrency Control: Optimistic vs Pessimistic Locking
- **Optimistic Locking (`@Version`)**:
  - Adds a version column (`int version`).
  - Executes `UPDATE orders SET status = 'PAID', version = 4 WHERE id = 42 AND version = 3`.
  - If another transaction already committed version 4, zero rows are updated, and Hibernate immediately throws `OptimisticLockException`. Fast, non-blocking, perfect for web apps.
- **Pessimistic Locking (`@Lock(LockModeType.PESSIMISTIC_WRITE)`)**:
  - Issues `SELECT ... FOR UPDATE` directly in the database. Locks the physical row until commit. Prevents concurrent reads/writes; use only when conflicts are extremely frequent (e.g. flash sales).

## 6. The N+1 Query Problem & Its Fixes
- **The Problem**: Querying 100 orders, then looping through each order to access its customer triggers 1 initial query + 100 separate queries for each customer (101 total queries).
- **The Fixes**:
  1. `JOIN FETCH` in JPQL: `SELECT o FROM Order o JOIN FETCH o.customer` (1 single query).
  2. `@EntityGraph(attributePaths = {"customer", "lines"})` on Spring Data repo methods.
  3. Batch fetching: `@BatchSize(size = 25)` or `default_batch_fetch_size: 25`.
- *Common Anti-Pattern*: Enabling `spring.jpa.open-in-view=true`. It does NOT fix N+1; it only masks the error by keeping the DB session open during web view rendering, destroying throughput.

---

## 🎯 Next Steps & Practice

- 📝 Test your understanding with the **10 Official Slide Quiz Questions**:
  👉 **[Go to Chapter 03 Quiz Preparation (`quiz_prep.md`)](quiz_prep.md)**
- 🏠 Back to main course directory:
  👉 **[Software Engineering Repository Overview (`readme.md`)](../readme.md)**
