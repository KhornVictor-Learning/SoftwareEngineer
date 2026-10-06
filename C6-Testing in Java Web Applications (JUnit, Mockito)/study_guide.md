# Chapter 06: Testing in Java Web Applications (JUnit 5/6 & Mockito) — Study Guide

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📝 **Quiz Practice**: [`quiz_prep.md`](quiz_prep.md)  
> 🧭 **Navigation**: [⬅️ Chapter 05](../C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/study_guide.md) | [📖 Syllabus](../readme.md) | [📚 Global Study Guide](../study_guide.md) | [Chapter 07 ➡️](../C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/study_guide.md)

---

## 1. Why This Matters
Tests serve as automated, executable specifications. They give developers the confidence to refactor code, catch regressions early, and reduce maintenance costs.

## 2. The Test Pyramid Strategy

```
           /           / E2E \       <-- Fewest, Slowest (Playwright, Selenium)
         /-------        /  Slice  \     <-- Medium count (@WebMvcTest, @DataJpaTest)
       /-----------      / Integration \   <-- Testcontainers, real PostgreSQL
     /---------------    /   Unit Tests    \ <-- Most numerous, Fast, Isolated (Pure Mockito)
   /-------------------```

## 3. JUnit 5/6 Jupiter Architecture
- **Lifecycle**:
  - `@BeforeAll`: Static method executed once before all tests in the class (expensive setups like starting Docker containers).
  - `@BeforeEach`: Executed before *every* `@Test` method on a *fresh instance* of the test class.
  - `@Test`: Marks test method.
- **Assertions**:
  - Use `assertAll(...)` to test multiple properties together without early termination on first failure.
  - Prefer **AssertJ** for readable, fluent assertions: `assertThat(result).hasSize(3).contains("Order-1");`.
- **Parameterized Tests**: `@ParameterizedTest` with `@CsvSource`, `@ValueSource`, or `@MethodSource`.

## 4. Mockito 5 Isolation Techniques
- `@Mock`: Creates an empty test double where all methods return defaults (null, false, 0).
- `@Spy`: Wraps a real object instance; calls real methods unless explicitly stubbed.
- `@InjectMocks`: Instantiates the class under test and injects mocks into its fields/constructors.
- **Stubbing & Verification**:
  ```java
  // Stubbing
  when(orderRepo.findById(1L)).thenReturn(Optional.of(sampleOrder));

  // Act
  orderService.cancelOrder(1L);

  // Verification
  verify(orderRepo, times(1)).save(sampleOrder);
  verifyNoMoreInteractions(orderRepo);
  ```
- **Strict Stubbing**: If you declare a `when(...).thenReturn(...)` that is never invoked during the test, Mockito throws an `UnnecessaryStubbingException` to prevent obsolete code.

## 5. Spring Boot Test Slices
- **`@WebMvcTest(OrderController.class)`**: Loads *only* the web layer (controllers, JSON converters, security). Use `@MockitoBean` / `@MockBean` for services.
- **`@DataJpaTest`**: Loads *only* JPA entities and repositories. Runs tests inside transactions that **automatically roll back** at the end of each test method.
- **`@SpringBootTest(webEnvironment = RANDOM_PORT)`**: Loads the full application context.
- **Testcontainers**: Launches real Docker containers (e.g. real PostgreSQL) directly from JUnit using `@Container static PostgreSQLContainer<?> postgres`.

---

## 🎯 Next Steps & Practice

- 📝 Test your understanding with the **10 Official Slide Quiz Questions**:
  👉 **[Go to Chapter 06 Quiz Preparation (`quiz_prep.md`)](quiz_prep.md)**
- 🏠 Back to main course directory:
  👉 **[Software Engineering Repository Overview (`readme.md`)](../readme.md)**
