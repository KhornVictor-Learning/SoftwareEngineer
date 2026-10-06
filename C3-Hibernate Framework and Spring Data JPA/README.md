# Chapter 03: Hibernate Framework & Spring Data JPA

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C3-Hibernate Framework and Spring Data JPA`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **The Object-Relational Impedance Mismatch**:
   - Conceptual gap between object-oriented domains (pointers, polymorphism, collections, object identity) and relational databases (foreign keys, tables, normalization, primary keys).
   - Role of JPA 3.2 as the formal specification and Hibernate 7.4 as the reference implementation.
2. **Entity Mapping & Identifiers**:
   - Mapping classes with `@Entity`, `@Table`, `@Column`, and `@Enumerated(EnumType.STRING)`.
   - Primary key generation: `GenerationType.SEQUENCE` (supports statement batching) vs `IDENTITY` (disables JDBC batching).
   - Embeddable value objects using `@Embeddable` and `@Embedded`.
3. **Persistence Context & First-Level Cache**:
   - `EntityManager` as an identity map and change snapshot tracker.
   - Entity lifecycle states: `Transient/New` ➔ `Managed` ➔ `Detached` ➔ `Removed`.
   - Automatic dirty checking and transaction flush mechanisms.
4. **Association Mappings & Cascades**:
   - Mapping associations: `@ManyToOne`, `@OneToMany(mappedBy = "...")`, `@ManyToMany`.
   - Identifying the owning side (holds the foreign key) vs the inverse side.
   - Synchronizing bidirectional associations using entity helper methods (`addLine()`, `removeLine()`).
   - Cascading actions (`CascadeType.ALL`, `CascadeType.PERSIST`) and `orphanRemoval = true`.
5. **Fetching Strategies & Performance Hazards**:
   - `FetchType.LAZY` (load on demand via dynamic proxies) vs `FetchType.EAGER` (immediate join).
   - Best practice rule: Use `LAZY` as default for all associations (especially overriding `@ManyToOne`).
   - The **N+1 Query Problem**: Triggering 1 parent query followed by N child queries in a loop.
   - Solutions: JPQL `JOIN FETCH`, `@EntityGraph`, `@BatchSize`, and DTO projections.
   - Avoiding `MultipleBagFetchException` by preferring `Set<T>` or `@OrderColumn` with `List<T>`.
6. **Querying Techniques**:
   - JPQL: Queries operating on Java entities rather than SQL tables (`from Order o where o.customer.email = :email`).
   - Criteria API: Type-safe dynamic querying backed by the Hibernate Annotation Processor static metamodel (`Order_.placedAt`).
7. **Spring Data JPA Repositories**:
   - Interfaces hierarchy: `Repository`, `CrudRepository`, `ListCrudRepository`, `JpaRepository`.
   - Query method derivation from method names (`findByStatusAndPlacedAtAfterOrderByPlacedAtDesc`).
   - Custom JPQL queries via `@Query` and write queries with `@Modifying`.
8. **Concurrency Control & Locking**:
   - Optimistic Locking: Non-blocking version tracking using `@Version`, throwing `OptimisticLockException` on concurrent modification.
   - Pessimistic Locking: Explicit database-level row locks using `@Lock(LockModeType.PESSIMISTIC_WRITE)` (`SELECT ... FOR UPDATE`).
9. **Pagination, Sorting & Projections**:
   - Requesting slices and pages with `Pageable` and `PageRequest.of(page, size, sort)`.
   - `Page<T>` (executes count query) vs `Slice<T>` (checks for next item via `limit + 1`, zero count query overhead).
   - Interface and Java Record DTO projections to eliminate unnecessary column selection.
10. **Database Schema Management & Migrations**:
    - Disabling automatic schema alteration (`ddl-auto = none` / `validate` in production).
    - Immutable, versioned SQL migration scripts with Flyway (`V1__init.sql`, `V2__orders.sql`).
11. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions on identifier generation, entity states, fetch joins, and optimistic locking.
    - **Lab-03**: 5 persistence tasks + 1 repository query tuning challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 02: C2-Spring Framework](../C2-Spring%20Framework/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 04: C4-RESTful Web Services (JAX-RS)](../C4-RESTful%20Web%20Services%20%28JAX-RS%29/README.md)

