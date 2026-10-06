# Chapter 03: Hibernate & Spring Data JPA Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 02 Quiz](../C2-Spring%20Framework/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 04 Quiz ➡️](../C4-RESTful%20Web%20Services%20%28JAX-RS%29/quiz_prep.md)

---

#### Q1. Which identifier generation strategy prevents Hibernate from batching INSERT statements?
- [ ] A) `SEQUENCE` with `allocationSize = 50`
- [x] B) `IDENTITY`
- [ ] C) `UUID`
- [ ] D) `AUTO`
> **Correct Answer**: **B**  
> **Explanation**: `IDENTITY` relies on the database table's auto-increment column; Hibernate must immediately execute each `INSERT` to retrieve the generated ID, breaking JDBC statement batching.

---

#### Q2. In a bidirectional one-to-many, what does `mappedBy = "order"` on `Order.lines` declare?
- [ ] A) `Order` owns the foreign key column
- [ ] B) The collection is fetched eagerly
- [x] C) `OrderLine.order` is the owning side and holds the FK column
- [ ] D) A join table must be created
> **Correct Answer**: **C**  
> **Explanation**: `mappedBy` designates the inverse side. It specifies that the entity on the other end (`OrderLine`) contains the field (`order`) that owns the foreign key.

---

#### Q3. What are the default fetch types of `@ManyToOne` and `@OneToMany`, respectively?
- [ ] A) `LAZY` / `LAZY`
- [x] B) `EAGER` / `LAZY`
- [ ] C) `EAGER` / `EAGER`
- [ ] D) `LAZY` / `EAGER`
> **Correct Answer**: **B**  
> **Explanation**: In JPA, all single-valued associations (`@ManyToOne`, `@OneToOne`) default to `EAGER`. All collection-valued associations (`@OneToMany`, `@ManyToMany`) default to `LAZY`.

---

#### Q4. You touch a lazy collection after the transaction ended (`open-in-view=false`). What happens?
- [ ] A) Hibernate opens a new connection and loads it
- [ ] B) An empty list is returned
- [x] C) A `LazyInitializationException` is thrown
- [ ] D) It is served from the second-level cache
> **Correct Answer**: **C**  
> **Explanation**: Once the transaction and persistence context close, accessing an uninitialized proxy throws `LazyInitializationException`.

---

#### Q5. How does Hibernate know it must issue an UPDATE for a managed entity you modified without calling `save()`?
- [ ] A) The setter sends SQL immediately
- [x] B) Dirty checking: at flush it compares the entity with the snapshot taken when it was loaded
- [ ] C) Spring Data intercepts setters with a proxy
- [ ] D) It re-reads the row and diffs it
> **Correct Answer**: **B**  
> **Explanation**: Hibernate takes an internal snapshot when an entity becomes managed. During transaction flush, it diffs current values against the snapshot and executes updates automatically.

---

#### Q6. Two transactions load Order 42 with version 3 and both update it. What happens to the second commit?
- [ ] A) It silently overwrites the first update
- [ ] B) It waits for a row lock
- [x] C) It fails with an `OptimisticLockException` because `UPDATE … WHERE version = 3` affects 0 rows
- [ ] D) Hibernate merges both changes
> **Correct Answer**: **C**  
> **Explanation**: The first commit updates version to 4. The second commit attempts to update matching version 3, matches 0 rows, and triggers `OptimisticLockException`.

---

#### Q7. Which return type avoids the extra count query when paginating?
- [ ] A) `Page<T>`
- [ ] B) `List<T>` with `Pageable`
- [x] C) `Slice<T>`
- [ ] D) `Stream<T>`
> **Correct Answer**: **C**  
> **Explanation**: `Page<T>` executes an expensive `SELECT COUNT(*)` query to calculate total pages. `Slice<T>` only fetches `limit + 1` rows to check if a next slice exists, avoiding the count query entirely.

---

#### Q8. Which of these does NOT fix an N+1 problem?
- [ ] A) `join fetch` in JPQL
- [ ] B) `@EntityGraph(attributePaths = "lines")`
- [ ] C) `@BatchSize` / `default_batch_fetch_size`
- [x] D) `spring.jpa.open-in-view=true`
> **Correct Answer**: **D**  
> **Explanation**: Open Session in View (OSIV) keeps the DB connection open during web page rendering. It hides `LazyInitializationException` by executing the N queries during view rendering, making N+1 worse.

---

#### Q9. With Flyway managing the schema, which `spring.jpa.hibernate.ddl-auto` value should production use?
- [ ] A) `update`
- [ ] B) `create-drop`
- [x] C) `validate`
- [ ] D) `create`
> **Correct Answer**: **C**  
> **Explanation**: In production, Flyway executes immutable SQL scripts. Setting `ddl-auto=validate` (or `none`) verifies that JPA mappings match the schema without modifying the database.

---

#### Q10. Why is generating `equals`/`hashCode` from all entity fields (Lombok `@Data`) a mistake?
- [ ] A) It is slower than the default
- [x] B) The hash changes when the id is assigned or a field is edited, so the entity is lost in a `HashSet` and associations may be loaded
- [ ] C) JPA forbids overriding equals
- [ ] D) It disables dirty checking
> **Correct Answer**: **B**  
> **Explanation**: Entities have mutable fields and their ID is null before persistence. Changing fields changes the hash code, breaking `HashSet` / `HashMap` contracts and triggering unwanted lazy loading.

---

## ⚡ High-Yield Exam Flashcards for Chapter 03

12. JPA `@ManyToOne` defaults to **`EAGER`** (must be manually changed to **`LAZY`**).
13. JPA `@OneToMany` defaults to **`LAZY`**.
14. `mappedBy` always sits on the **inverse side**; the owning side holds the foreign key.
15. Touching a lazy collection outside an active transaction throws **`LazyInitializationException`**.
16. JPA dirty checking compares entities against their loading snapshot during **flush** (no need to call `save()`).
17. Optimistic locking uses **`@Version`**; throws `OptimisticLockException` on concurrent update.
18. To fix the N+1 problem, use **`JOIN FETCH`** or **`@EntityGraph`** (never enable Open Session in View).

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 03 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
