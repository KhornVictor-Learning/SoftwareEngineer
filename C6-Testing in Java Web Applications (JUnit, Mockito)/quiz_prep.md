# Chapter 06: Testing in Java Web Applications (JUnit & Mockito) Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 05 Quiz](../C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 07 Quiz ➡️](../C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/quiz_prep.md)

---

#### Q1. According to the test pyramid, which kind of test should be the most numerous in the shop project?
- [ ] A) End-to-end browser tests
- [x] B) Unit tests without Spring
- [ ] C) `@SpringBootTest` tests on a random port
- [ ] D) Manual exploratory tests
> **Correct Answer**: **B**  
> **Explanation**: Unit tests without Spring are fast (sub-millisecond), reliable, and isolate domain logic, forming the broad foundation of the test pyramid.

---

#### Q2. In a JUnit Jupiter class with the default lifecycle, which method runs exactly once before all tests and must be static?
- [ ] A) `@BeforeEach`
- [x] B) `@BeforeAll`
- [ ] C) `@Nested`
- [ ] D) `@Test`
> **Correct Answer**: **B**  
> **Explanation**: `@BeforeAll` executes once before any test methods run. In the default per-method test lifecycle, it must be declared `static`.

---

#### Q3. What does `assertAll(...)` do that a sequence of plain `assertEquals` calls does not?
- [ ] A) It runs the assertions in parallel threads
- [x] B) It executes every assertion and reports all failures together
- [ ] C) It stops the test at the first passing assertion
- [ ] D) It retries failed assertions
> **Correct Answer**: **B**  
> **Explanation**: Standard assertions fail immediately at the first failing assertion. `assertAll` runs all supplied executables and aggregates all failures into a single report.

---

#### Q4. Which annotation feeds a `@ParameterizedTest` from a static method returning `Stream`?
- [ ] A) `@ValueSource`
- [ ] B) `@CsvSource`
- [x] C) `@MethodSource`
- [ ] D) `@EnumSource`
> **Correct Answer**: **C**  
> **Explanation**: `@MethodSource` references a static factory method providing argument streams or collections to parameterized tests.

---

#### Q5. With `@ExtendWith(MockitoExtension.class)` and default settings, a `when(...).thenReturn(...)` stub that the test never uses causes…
- [ ] A) nothing, unused stubs are ignored
- [ ] B) a compile error
- [x] C) an `UnnecessaryStubbingException` that fails the test
- [ ] D) a warning printed to `System.out` only
> **Correct Answer**: **C**  
> **Explanation**: Mockito 5 enables strict stubbing by default. Any stub that is never called during test execution triggers an `UnnecessaryStubbingException` to prevent code rot.

---

#### Q6. What is the difference between a `@Spy` and a `@Mock` in Mockito?
- [x] A) A spy calls the real methods unless stubbed; a mock returns defaults
- [ ] B) A spy cannot be verified
- [ ] C) A mock wraps a real instance; a spy is empty
- [ ] D) There is no difference in Mockito 5
> **Correct Answer**: **A**  
> **Explanation**: A mock is an empty shell returning default values (null, 0, false). A spy delegates to an underlying real object instance unless a specific method is stubbed.

---

#### Q7. In a `@WebMvcTest(ProductController.class)` slice, how does the test get a `ProductService`?
- [ ] A) The real `@Service` bean is component-scanned automatically
- [x] B) It must be declared with `@MockitoBean` (or `@Import`)
- [ ] C) `MockMvc` creates one on the fly
- [ ] D) It is injected from `application.yml`
> **Correct Answer**: **B**  
> **Explanation**: `@WebMvcTest` disables regular component scanning of `@Service` and `@Repository` beans. Collaborators must be provided as test doubles using `@MockitoBean` (or `@MockBean`).

---

#### Q8. Which statement about `@DataJpaTest` is correct by default?
- [ ] A) It starts the embedded Tomcat server
- [x] B) Each test runs in a transaction that is rolled back and uses an embedded database
- [ ] C) It commits every test so data can be inspected
- [ ] D) It requires Docker to run
> **Correct Answer**: **B**  
> **Explanation**: `@DataJpaTest` configures an in-memory/test database, disables web layers, and wraps each test in a transaction that automatically rolls back at test completion.

---

#### Q9. What does `@ServiceConnection` on a Testcontainers `PostgreSQLContainer` field do?
- [ ] A) Opens a JDBC connection pool inside the test class
- [x] B) Derives `spring.datasource.*` properties from the running container automatically
- [ ] C) Replaces PostgreSQL with H2
- [ ] D) Starts the container only when Docker is missing
> **Correct Answer**: **B**  
> **Explanation**: Spring Boot's `@ServiceConnection` automatically discovers the dynamic port and credentials of a running Testcontainer and binds them to Spring environment properties.

---

#### Q10. The JaCoCo check goal is configured with counter `LINE`, value `COVEREDRATIO`, minimum `0.80`. What happens when line coverage is 76%?
- [x] A) The build fails in the verify phase
- [ ] B) A warning is logged and the build passes
- [ ] C) Coverage is rounded up to 80%
- [ ] D) Only the HTML report is skipped
> **Correct Answer**: **A**  
> **Explanation**: JaCoCo's `check` goal enforces coverage thresholds and halts the Maven/Gradle build during the `verify` phase if criteria are unmet.

---

## ⚡ High-Yield Exam Flashcards for Chapter 06

30. The Test Pyramid has **many fast Unit tests**, fewer Integration/Slice tests, and very few E2E tests.
31. In JUnit Jupiter, `@BeforeAll` must be `static` under the default per-method lifecycle.
32. `assertAll()` reports all failure assertions together; standard assertions stop on first failure.
33. Mockito `@Spy` calls real methods unless stubbed; `@Mock` returns dummy defaults.
34. `@WebMvcTest` tests only web controllers; use `@MockitoBean` for services.
35. `@DataJpaTest` tests roll back transactions automatically after each test.
36. **Testcontainers** spins up real Docker containers (e.g. PostgreSQL) directly inside JUnit tests.

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 06 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
