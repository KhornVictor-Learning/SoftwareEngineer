# Chapter 06: Testing in Java Web Applications (JUnit 5/6 & Mockito)

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C6-Testing in Java Web Applications (JUnit, Mockito)`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **Testing Economics & The Test Pyramid**:
   - Fast feedback loops, executable specifications, and safe refactoring.
   - The defect cost curve: bugs caught in unit tests cost minutes; bugs caught in production cost thousands.
   - The Test Pyramid:
     - **Base (Unit Tests)**: Fast, plentiful, completely isolated (in-memory, no Spring context, milliseconds).
     - **Middle (Integration & Slice Tests)**: Targeted Spring slices, database interactions, HTTP client stubs.
     - **Peak (End-to-End Tests)**: Few, slow, full-stack journeys through browser/API (Playwright, Selenium).
2. **JUnit Jupiter Test Architecture**:
   - Lifecycle: `@BeforeAll` (static, once per class), `@BeforeEach` (fresh fixture before every test), `@Test`, `@AfterEach`, `@AfterAll`.
   - Clean test isolation (new test class instance instantiated per test method).
   - Assertions: Arrange-Act-Assert (AAA) pattern; JUnit assertions vs fluent, readable AssertJ assertions (`assertThat(order.getStatus()).isEqualTo(OrderStatus.PAID)`).
   - Data-Driven Testing: `@ParameterizedTest` with `@ValueSource`, `@CsvSource`, `@CsvFileSource`, and `@MethodSource`.
3. **Mockito 5 Test Doubles**:
   - Definitions: Dummies, Stubs, Mocks, Spies, and Fakes.
   - Isolating the unit under test using `@Mock`, `@InjectMocks`, and `@ExtendWith(MockitoExtension.class)`.
   - Stubbing behavior: `when(repo.findById(1L)).thenReturn(Optional.of(product))` and `doThrow()`.
   - Behavioral verification: `verify(repo, times(1)).save(any())`, `verifyNoInteractions()`, and strict verification with `inOrder()`.
   - Argument inspection using `ArgumentCaptor<T>` and `argThat()`.
4. **Spring Boot Test Slices**:
   - Testing Services: Pure JUnit + Mockito (no Spring context overhead).
   - Testing Controllers: `@WebMvcTest(OrderController.class)` using `MockMvc`, mocking service beans with `@MockitoBean` / `@MockBean`, verifying HTTP status and JSON responses (`jsonPath("$.status").value("NEW")`).
   - Testing Repositories: `@DataJpaTest`, configuring SQL statement inspection, and testing transactional rollbacks.
5. **Test Data Management & Fixtures**:
   - Avoiding brittle test fixtures using the Test Data Builder pattern and Object Mother pattern.
   - Pre-seeding database state with `@Sql(scripts = "/seed.sql", executionPhase = BEFORE_TEST_METHOD)`.
6. **Real-World Integration Testing**:
   - Eliminating in-memory H2 divergence: Real database testing using **Testcontainers** (`@Testcontainers`, `@Container static PostgreSQLContainer<?>`).
   - Mocking external HTTP clients using `MockRestServiceServer` and WireMock.
   - Full-stack testing with `@SpringBootTest(webEnvironment = RANDOM_PORT)` and `TestRestTemplate` / `RestClient`.
   - Spring TestContext framework caching: Sharing initialized Spring contexts across test classes to minimize test suite execution duration.
7. **Contract Testing, Coverage & CI**:
   - Consumer-Driven Contract testing with Pact (validating API provider/consumer expectations without end-to-end environments).
   - Code coverage metrics via JaCoCo (line coverage, branch coverage, instruction coverage).
   - Eliminating test smells (e.g., eliminating flaky `Thread.sleep()` in favor of Awaitility).
8. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions on the test pyramid, Mockito verifications, test slices, and Testcontainers.
    - **Lab-06**: 5 testing implementation tasks + 1 Testcontainers PostgreSQL challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 05: C5-Security in Java Web Applications (Spring Security, JWT)](../C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 07: C7-Introduction to UML and Use Case Diagrams](../C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/README.md)

