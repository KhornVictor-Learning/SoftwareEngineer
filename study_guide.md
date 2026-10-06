# Software Engineering (I4-GIC-S1) — Comprehensive Study Guide

> **Target Audience**: Students preparing for lectures, assignments, midterms, and final exams in Software Engineering at the Institute of Technology of Cambodia (ITC / Techno).  
> **Core Focus**: Clear, conceptual, and practical understanding of Java Enterprise Engineering (Chapters 01–06) and UML 2.5.1 Architectural Modeling (Chapters 07–12).

---

## 📑 Table of Contents

1. [Chapter 01: Multithreading & Modern Java Concurrency](C1-MultiThread/study_guide.md) ([in-page](#chapter-01-multithreading--modern-java-concurrency))
2. [Chapter 02: Spring Framework & Core Ecosystem](C2-Spring%20Framework/study_guide.md) ([in-page](#chapter-02-spring-framework--core-ecosystem))
3. [Chapter 03: Hibernate Framework & Spring Data JPA](C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/study_guide.md) ([in-page](#chapter-03-hibernate-framework--spring-data-jpa))
4. [Chapter 04: RESTful Web Services (Jakarta REST & Jersey)](C4-RESTful%20Web%20Services%20(JAX-RS)/study_guide.md) ([in-page](#chapter-04-restful-web-services-jakarta-rest--jersey))
5. [Chapter 05: Security in Java Web Applications (Spring Security & JWT)](C5-Security%20in%20Java%20Web%20Applications%20(Spring%20Security,%20JWT)/study_guide.md) ([in-page](#chapter-05-security-in-java-web-applications-spring-security--jwt))
6. [Chapter 06: Testing in Java Web Applications (JUnit 5/6 & Mockito)](C6-Testing%20in%20Java%20Web%20Applications%20(JUnit,%20Mockito)/study_guide.md) ([in-page](#chapter-06-testing-in-java-web-applications-junit-56--mockito))
7. [Chapter 07: Introduction to UML & Use Case Diagrams](C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/study_guide.md) ([in-page](#chapter-07-introduction-to-uml--use-case-diagrams))
8. [Chapter 08: UML Class Diagrams & Domain Modeling](C8-Class%20Diagrams/study_guide.md) ([in-page](#chapter-08-uml-class-diagrams--domain-modeling))
9. [Chapter 09: UML Activity Diagrams & Workflow Modeling](C9-Activity%20Diagrams/study_guide.md) ([in-page](#chapter-09-uml-activity-diagrams--workflow-modeling))
10. [Chapter 10: UML Sequence Diagrams & Dynamic Interactions](C10-Sequence%20Diagrams/study_guide.md) ([in-page](#chapter-10-uml-sequence-diagrams--dynamic-interactions))
11. [Chapter 11: UML Component Diagrams & Modular Architectures](C11-Component%20Diagrams/study_guide.md) ([in-page](#chapter-11-uml-component-diagrams--modular-architectures))
12. [Chapter 12: UML Deployment Diagrams & Infrastructure Topology](C12-Deployment%20Diagrams/study_guide.md) ([in-page](#chapter-12-uml-deployment-diagrams--infrastructure-topology))

---

## 🎯 How to Use This Study Guide

- **Read Section by Section**: Each chapter begins with **"Why This Matters"**, explains the **Core Mental Models**, shows the **Essential Code / Notation**, and ends with **"Professor's Traps & Rules of Thumb"**.
- **Pair with the Quiz Guide**: When you finish reading a chapter here, open [`quiz_prep.md`](file:///C:/Desktop/Student%20Online%20(SO)/Techno/I4-GIC-A/I4-GIC-S1/Software%20engineering/quiz_prep.md) to test your knowledge against the exact multiple-choice quiz questions from the lectures.

---

## Chapter 01: Multithreading & Modern Java Concurrency

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 01 Study Guide](C1-MultiThread/study_guide.md) or test your knowledge in [Chapter 01 Quiz Prep](C1-MultiThread/quiz_prep.md).

### 1. Why This Matters

CPUs have multiple cores. Sequential code leaves all cores but one idle. Multithreading enables applications to handle multiple requests concurrently, compute parallel tasks faster, and keep user interfaces responsive.

### 2. Core Mental Models & Definitions

- **Process vs Thread**:
  - **Process**: An OS-level running program with an isolated address space. The JVM is one process.
  - **Thread**: An independent path of execution *inside* a process. Threads share the heap memory, but each thread has its own private **call stack**, **registers**, and **program counter**.
- **Platform Threads vs Virtual Threads (Project Loom / JDK 21+)**:
  - **Platform Thread**: 1-to-1 wrapper around an OS kernel thread. Costs ~1 MB of stack memory and heavy OS context switches. Limited to a few thousand threads.
  - **Virtual Thread**: Managed entirely by the JVM on the heap. Extremely lightweight (few KB). Millions can run concurrently. Perfect for high-throughput **I/O-bound** tasks (e.g., waiting for database queries or REST calls).
  - *Golden Rule*: Use Virtual Threads for blocking I/O; use Platform Threads with a sized pool for CPU-bound computations.

### 3. Thread Lifecycle State Machine

```mermaid
stateDiagram-v2
    [*] --> NEW: new Thread()
    NEW --> RUNNABLE: start()
    RUNNABLE --> BLOCKED: waiting for monitor lock
    BLOCKED --> RUNNABLE: lock acquired
    RUNNABLE --> WAITING: wait(), join(), LockSupport.park()
    WAITING --> RUNNABLE: notify(), notifyAll(), unpark()
    RUNNABLE --> TIMED_WAITING: sleep(t), wait(t), join(t)
    TIMED_WAITING --> RUNNABLE: timeout elapsed
    RUNNABLE --> TERMINATED: run() completes or throws
    TERMINATED --> [*]
```

### 4. Critical Mechanisms & Code Patterns

#### A. Starting a Thread

```java
// 1. Lambda implementing Runnable (Preferred for simple tasks)
Thread t1 = new Thread(() -> System.out.println("Running in parallel"));
t1.start(); // ALWAYS call start(), NEVER call run() directly!

// 2. Modern Virtual Thread (JDK 21+)
Thread vt = Thread.ofVirtual().start(() -> doBlockingHttpCall());
```

#### B. Thread Safety: Race Conditions, Locks, and Visibility

- **Race Condition**: Two threads read and write shared mutable state concurrently without synchronization (e.g., `count++` consists of 3 distinct bytecode instructions: read, increment, write).
- **`synchronized`**: Guarantees **mutual exclusion** (only one thread enters the monitor at a time) AND **memory visibility** (flushes CPU caches on entry and exit).
- **`volatile`**: Guarantees **visibility** (reads/writes bypass CPU caches directly to main memory) and establishes a **happens-before** ordering. *Caution*: `volatile` does NOT make `count++` atomic!
- **Atomic Variables**: `AtomicInteger`, `AtomicReference` use hardware-level Compare-And-Swap (CAS) for lock-free atomicity.

#### C. Inter-Thread Coordination

- **Low-level**: `wait()` and `notify()` must *always* be invoked inside a `synchronized` block on the locked monitor object.
- **High-level (Recommended)**: Use `BlockingQueue` (`LinkedBlockingQueue`, `ArrayBlockingQueue`) for producer-consumer patterns without manual locking.

#### D. The Four Coffman Conditions for Deadlock

Deadlock can occur *if and only if* all four conditions hold simultaneously:

1. **Mutual Exclusion**: Resources cannot be shared.
2. **Hold and Wait**: A thread holding one resource waits for another.
3. **No Preemption**: Resources cannot be forcibly seized.
4. **Circular Wait**: Thread A waits for Thread B which waits for Thread A.

- *Fix*: Enforce a strict **global lock acquisition order** (e.g., always acquire Account locks in increasing order of `account.id`).

### 5. Professor's Traps & Rules of Thumb

> ⚠️ **Trap 1**: Calling `thread.run()` instead of `thread.start()`. `run()` executes sequentially on the *calling* thread. `start()` creates a new OS/JVM thread.  
> ⚠️ **Trap 2**: Thinking `worker.interrupt()` forcefully kills a thread. Java cancellation is **cooperative**; calling `interrupt()` only sets a boolean flag. If the worker doesn't check `Thread.currentThread().isInterrupted()`, it keeps running forever.  
> ⚠️ **Trap 3**: `CountDownLatch` vs `CyclicBarrier`. A `CountDownLatch` is a one-shot gate (cannot be reset once count hits zero); a `CyclicBarrier` can be reused over and over.

---

## Chapter 02: Spring Framework & Core Ecosystem

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 02 Study Guide](C2-Spring%20Framework/study_guide.md) or test your knowledge in [Chapter 02 Quiz Prep](C2-Spring%20Framework/quiz_prep.md).

### 1. Why This Matters

Enterprise applications require database access, transaction management, web routing, validation, and security. Spring eliminates low-level plumbing code via **Inversion of Control (IoC)**, allowing developers to write clean, testable POJOs (Plain Old Java Objects).

### 2. Core Mental Models & Definitions

- **Inversion of Control (IoC)**: Instead of your class instantiating its dependencies (`new JdbcOrderRepository()`), the Spring container creates objects, configures them, and injects them.
- **Dependency Injection (DI)**: The mechanism of passing dependencies into an object.
- **Bean**: An object managed by the Spring IoC container.
- **Default Bean Scope**: **`singleton`** (exactly one instance per Spring ApplicationContext). Other scopes: `prototype` (new instance every request), `request`, `session`.

### 3. Three Injection Styles — Which to Use?

1. **Constructor Injection (STRONGLY RECOMMENDED)**:

   ```java
   @Service
   public class OrderService {
       private final OrderRepository orderRepo; // Immutable & final
       private final PaymentGateway paymentGateway;

       public OrderService(OrderRepository orderRepo, PaymentGateway paymentGateway) {
           this.orderRepo = orderRepo;
           this.paymentGateway = paymentGateway;
       }
   }
   ```
  
   *Why*: Dependencies are explicit, objects are immutable, and classes can be unit tested without starting the Spring container (`new OrderService(mockRepo, mockGateway)`).
2. **Setter Injection**: Useful only for optional dependencies.
3. **Field Injection (`@Autowired` on private fields)**: **DISCOURAGED**. Hides dependencies, complicates unit testing, and encourages violation of Single Responsibility.

### 4. Spring Boot Fundamentals

- **`@SpringBootApplication`**: An alias combining three critical annotations:
  1. `@Configuration`: Marks the class as a source of bean definitions.
  2. `@EnableAutoConfiguration`: Enables Spring Boot's smart auto-wiring based on classpath JARs.
  3. `@ComponentScan`: Scans the current package and all sub-packages for `@Component`, `@Service`, `@Repository`, `@Controller`.
- **Property Precedence Order (Highest Wins)**:
  1. Command-line arguments (`--server.port=7070`) ➔ **Wins over everything**
  2. Java System properties (`-Dserver.port=7070`)
  3. OS Environment variables (`SERVER_PORT=7070`)
  4. Profile-specific files (`application-prod.yml`)
  5. Default configuration (`application.yml`)

### 5. Web MVC, Transactions, and AOP

```mermaid
flowchart LR
    Client([HTTP Client]) -->|POST /api/orders| DS[DispatcherServlet]
    DS -->|HandlerMapping| C[OrderController]
    C -->|calls placeOrder| Px[Spring AOP Proxy]
    Px -->|1. Begin Tx| TM[(Transaction Manager)]
    Px -->|2. Invoke real method| S[OrderService]
    S -->|3. Commit Tx| TM
    S --> R[OrderRepository]
```

- **Declarative Transactions (`@Transactional`)**:
  - Spring wraps your `@Service` in a dynamic proxy.
  - *The Self-Invocation Pitfall*: If method `A()` calls `this.B()` inside the same class, and `B()` has `@Transactional`, **NO transaction is started** because `this.` bypasses the Spring proxy!
- **Exception Translation (`@Repository`)**:
  - `@Repository` automatically catches vendor-specific database SQLExceptions and translates them into Spring's unified, unchecked `DataAccessException` hierarchy.

---

## Chapter 03: Hibernate Framework & Spring Data JPA

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 03 Study Guide](C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/study_guide.md) or test your knowledge in [Chapter 03 Quiz Prep](C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/quiz_prep.md).

### 1. Why This Matters

Writing manual SQL and mapping `ResultSet` rows to objects by hand is repetitive and error-prone. Jakarta Persistence (JPA) and Hibernate map Java objects directly to database tables, handling relationships, caching, and dirty checking automatically.

### 2. Core Mental Models & Definitions

- **Specification vs Implementation**:
  - **JPA 3.2** (`jakarta.persistence.*`): The official standard specification.
  - **Hibernate 7.4**: The concrete ORM library implementing the JPA standard.
  - **Spring Data JPA**: A repository abstraction built on top of JPA to generate queries from interface method names.
- **Persistence Context & First-Level Cache**:
  - The `EntityManager` maintains an in-memory identity map of all managed entities within a transaction.
  - It takes an initial snapshot upon loading. At transaction commit (**flush**), it performs **dirty checking**: compares current entity state against the snapshot and generates SQL `UPDATE`s only for fields that actually changed! You never need to call `save()` on a managed entity!

### 3. Entity States Lifecycle

```mermaid
[Transient / New] ──(persist / save)──▶ [Managed] ──(detach / clear)──▶ [Detached]
                                            │
                                      (remove / delete)
                                            │
                                            ▼
                                        [Removed]
```

### 4. Associations & The Golden Rules of JPA

| Relationship | Default Fetch Type | Recommended Override |
| :--- | :---: | :---: |
| `@ManyToOne` | **EAGER** ⚠️ | **Change to `FetchType.LAZY`!** |
| `@OneToOne` | **EAGER** ⚠️ | **Change to `FetchType.LAZY`!** |
| `@OneToMany` | **LAZY** ✅ | Keep `LAZY` |
| `@ManyToMany` | **LAZY** ✅ | Keep `LAZY` |

- **`mappedBy`**: Placed on the inverse side of a bidirectional relationship. It tells Hibernate: *"I do not hold the foreign key column; go look at the property named in `mappedBy` on the other entity!"*

### 5. Concurrency Control: Optimistic vs Pessimistic Locking

- **Optimistic Locking (`@Version`)**:
  - Adds a version column (`int version`).
  - Executes `UPDATE orders SET status = 'PAID', version = 4 WHERE id = 42 AND version = 3`.
  - If another transaction already committed version 4, zero rows are updated, and Hibernate immediately throws `OptimisticLockException`. Fast, non-blocking, perfect for web apps.
- **Pessimistic Locking (`@Lock(LockModeType.PESSIMISTIC_WRITE)`)**:
  - Issues `SELECT ... FOR UPDATE` directly in the database. Locks the physical row until commit. Prevents concurrent reads/writes; use only when conflicts are extremely frequent (e.g. flash sales).

### 6. The N+1 Query Problem & Its Fixes

- **The Problem**: Querying 100 orders, then looping through each order to access its customer triggers 1 initial query + 100 separate queries for each customer (101 total queries).
- **The Fixes**:
  1. `JOIN FETCH` in JPQL: `SELECT o FROM Order o JOIN FETCH o.customer` (1 single query).
  2. `@EntityGraph(attributePaths = {"customer", "lines"})` on Spring Data repo methods.
  3. Batch fetching: `@BatchSize(size = 25)` or `default_batch_fetch_size: 25`.
- *Common Anti-Pattern*: Enabling `spring.jpa.open-in-view=true`. It does NOT fix N+1; it only masks the error by keeping the DB session open during web view rendering, destroying throughput.

---

## Chapter 04: RESTful Web Services (Jakarta REST & Jersey)

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 04 Study Guide](C4-RESTful%20Web%20Services%20%28JAX-RS%29/study_guide.md) or test your knowledge in [Chapter 04 Quiz Prep](C4-RESTful%20Web%20Services%20%28JAX-RS%29/quiz_prep.md).

### 1. Why This Matters

REST (Representational State Transfer) is the dominant architectural style for building public web APIs and microservice communications over HTTP.

### 2. Core Mental Models & Principles

- **Roy Fielding's REST Axioms**:
  - Resources are **nouns** identified by URIs (`/api/products`, `/api/orders/42`).
  - Actions are standard HTTP verbs (the **uniform interface**).
  - Requests are strictly **stateless**.
- **HTTP Verbs Semantics**:
  - `GET`: Safe (no side effects), Idempotent (calling N times leaves system in same state), Cacheable.
  - `POST`: **Unsafe**, **Non-Idempotent** (calling twice creates two resources).
  - `PUT`: Unsafe, **Idempotent** (replaces entire resource).
  - `PATCH`: Unsafe, partial update.
  - `DELETE`: Unsafe, **Idempotent** (deleting twice leaves resource gone).

### 3. HTTP Status Codes Cheat Sheet

- **`200 OK`**: Standard success with body.
- **`201 Created`**: Resource created successfully. Must include `Location: /api/products/123` header!
- **`204 No Content`**: Success, no response body (common for `DELETE`).
- **`304 Not Modified`**: ETag matched `If-None-Match`; client should use cached copy.
- **`400 Bad Request`**: Malformed payload or validation error.
- **`401 Unauthorized`**: Unauthenticated (who are you? Missing or invalid token).
- **`403 Forbidden`**: Authenticated, but lacking permission (what may you do?).
- **`404 Not Found`**: Resource does not exist.
- **`406 Not Acceptable`**: Server cannot produce the media type requested in client's `Accept` header.
- **`415 Unsupported Media Type`**: Server cannot parse the media type sent in client's `Content-Type` header.
- **`422 Unprocessable Entity`**: Syntactically valid JSON, but violates business semantic rules.

### 4. Jakarta REST 4.0 (JAX-RS) Annotations

```java
@Path("/api/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Long id,
                               @QueryParam("detail") @DefaultValue("false") boolean detail) {
        Product p = service.find(id);
        return Response.ok(p).build();
    }
}
```

### 5. Advanced Patterns

- **RFC 9457 Problem Details**: Standardized JSON schema for API errors (`type`, `title`, `status`, `detail`, `instance`). Handled via `ExceptionMapper<T>`.
- **Conditional GET with ETags**:
  - Server computes hash of resource representation and returns `ETag: "a1b2c3"`.
  - Next time, client sends `If-None-Match: "a1b2c3"`.
  - Server evaluates tag; if unchanged, returns `304 Not Modified` with zero response body bytes!

---

## Chapter 05: Security in Java Web Applications (Spring Security & JWT)

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 05 Study Guide](C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/study_guide.md) or test your knowledge in [Chapter 05 Quiz Prep](C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/quiz_prep.md).

### 1. Why This Matters

Every web application is exposed to malicious requests. Security must protect identities, enforce permissions, and defend against OWASP Top 10 vulnerabilities.

### 2. Core Mental Models & Definitions

- **Authentication vs Authorization**:
  - **Authentication**: *"Who are you?"* (Verifying username/password, token, or passkey).
  - **Authorization**: *"Are you allowed to do this?"* (Checking roles and permissions).
- **Spring Security Architecture**:
  - Incoming requests pass through a chain of servlet filters (`SecurityFilterChain`).
  - `SecurityContextHolder` stores the active `Authentication` on a `ThreadLocal` storage variable for the duration of the request.
  - An `Authentication` object contains: `Principal` (user details), `Credentials` (cleared after login), and `Authorities` (granted roles/permissions).

### 3. Passwords & Credential Storage

- **Golden Rule**: Never store plaintext passwords or fast hashes (MD5, SHA-256). Attackers can compute billions of SHA-256 hashes per second using GPUs.
- **Solution**: Use **salted, computationally slow key derivation functions** with configurable work factors: **`BCryptPasswordEncoder`** or Argon2.

### 4. JSON Web Tokens (JWT) Anatomy

A JWT consists of three Base64URL-encoded strings separated by dots (`Header.Payload.Signature`):

```text
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhbGljZSIsInJvbGVzIjpbIlJPTEVfQ1VTVE9NRVIiXX0.SflKxwRJSMeKKF2QT4fwpM...
```

- **Header**: Algorithm (`HS256`, `RS256`) and token type (`JWT`).
- **Payload**: Claims (`sub` [subject/username], `iss` [issuer], `exp` [expiration timestamp], custom roles).
- **Signature**: `HMACSHA256(base64Url(header) + "." + base64Url(payload), secret)`.
- *Critical Security Warning*: The payload is **NOT ENCRYPTED**; it is merely Base64URL-encoded. Anyone holding the token can decode and read its claims! Never put passwords or secrets in a JWT payload!

### 5. Web Defenses & OWASP Top 10

- **CSRF (Cross-Site Request Forgery)**: A malicious site tricks a user's browser into sending requests to your site with their stored cookies.
  - *Stateless JWT Defense*: CSRF protection is safely disabled for stateless REST APIs because JWTs travel in the custom `Authorization: Bearer <token>` header, which browsers *never* attach automatically to cross-origin requests.
- **XSS (Cross-Site Scripting)**: Attacker injects malicious `<script>` tags into input.
  - *Defense*: HTML-encode all dynamic values before rendering to the screen (`th:text`, `c:out`, `HtmlUtils.htmlEscape()`).

---

## Chapter 06: Testing in Java Web Applications (JUnit 5/6 & Mockito)

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 06 Study Guide](C6-Testing%20in%20Java%20Web%20Applications%20%28JUnit%2C%20Mockito%29/study_guide.md) or test your knowledge in [Chapter 06 Quiz Prep](C6-Testing%20in%20Java%20Web%20Applications%20%28JUnit%2C%20Mockito%29/quiz_prep.md).

### 1. Why This Matters

Tests serve as automated, executable specifications. They give developers the confidence to refactor code, catch regressions early, and reduce maintenance costs.

### 2. The Test Pyramid Strategy

```mermaid
           /           / E2E \       <-- Fewest, Slowest (Playwright, Selenium)
         /-------        /  Slice  \     <-- Medium count (@WebMvcTest, @DataJpaTest)
       /-----------      / Integration \   <-- Testcontainers, real PostgreSQL
     /---------------    /   Unit Tests    \ <-- Most numerous, Fast, Isolated (Pure Mockito)
   /-------------------```

### 3. JUnit 5/6 Jupiter Architecture
- **Lifecycle**:
  - `@BeforeAll`: Static method executed once before all tests in the class (expensive setups like starting Docker containers).
  - `@BeforeEach`: Executed before *every* `@Test` method on a *fresh instance* of the test class.
  - `@Test`: Marks test method.
- **Assertions**:
  - Use `assertAll(...)` to test multiple properties together without early termination on first failure.
  - Prefer **AssertJ** for readable, fluent assertions: `assertThat(result).hasSize(3).contains("Order-1");`.
- **Parameterized Tests**: `@ParameterizedTest` with `@CsvSource`, `@ValueSource`, or `@MethodSource`.

### 4. Mockito 5 Isolation Techniques
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

### 5. Spring Boot Test Slices

- **`@WebMvcTest(OrderController.class)`**: Loads *only* the web layer (controllers, JSON converters, security). Use `@MockitoBean` / `@MockBean` for services.
- **`@DataJpaTest`**: Loads *only* JPA entities and repositories. Runs tests inside transactions that **automatically roll back** at the end of each test method.
- **`@SpringBootTest(webEnvironment = RANDOM_PORT)`**: Loads the full application context.
- **Testcontainers**: Launches real Docker containers (e.g. real PostgreSQL) directly from JUnit using `@Container static PostgreSQLContainer<?> postgres`.

---

## Chapter 07: Introduction to UML & Use Case Diagrams

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 07 Study Guide](C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/study_guide.md) or test your knowledge in [Chapter 07 Quiz Prep](C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/quiz_prep.md).

### 1. Why This Matters

Before writing hundreds of lines of code, engineers and stakeholders must agree on what the system does, who interacts with it, and where the boundaries lie.

### 2. Core Mental Models & Definitions

- **UML 2.5.1**: Standard visual modeling language by the OMG (December 2017).
- **Two Diagram Families**:
  - **Structure Diagrams (Static)**: Class, Component, Deployment, Object, Package.
  - **Behavior Diagrams (Dynamic)**: Use Case, Activity, Sequence, State Machine.
- **Actors**:
  - **Primary Actors (Left)**: Initiate the use case to achieve a personal business goal (e.g., `Customer`, `Store Manager`).
  - **Supporting Actors (Right)**: Provide external services to our system (e.g., `Payment Gateway`, `Shipping Carrier`).
  - *Anti-Pattern*: Never draw internal software classes (e.g., `Database`, `Controller`) as actors!

### 3. Relationships in Use Case Diagrams

- **Association**: Solid line connecting an Actor to a Use Case.
- **`«include»`**: Mandatory, unconditional sub-flow. The base use case *cannot* succeed without executing the included use case. Arrow points from Base ➔ Included:
  `[Place order] ..> [Authorize payment] : «include»`
- **`«extend»`**: Optional, conditional branch. Executed only under certain conditions at specific extension points. Arrow points from Extension ➔ Base:
  `[Apply promotional voucher] ..> [Place order] : «extend»`
- **Generalization**: Inheritance between actors (`Registered Customer` inherits all associations of `Customer`).

```mermaid
flowchart LR
    Customer((Customer)) --- PO([Place order])
    PO -.->|«include»| AP([Authorize payment])
    AV([Apply voucher]) -.->|«extend»| PO
    AP --- PG((Payment Gateway))
```

### 4. Cockburn Goal Levels & Naming

- **Naming Rule**: Always use **Active Verb + Business Noun** at the **Sea Level (User Goal)**: `Place order`, `Track shipment` (Never `Order Management`, `Click button`, or `Login`).
- **Functional Decomposition Anti-Pattern**: Do NOT chain UI button clicks (`Enter login`, `Type password`, `Click pay`) as use cases with `«include»`! A use case represents an entire end-to-end user goal.

---

## Chapter 08: UML Class Diagrams & Domain Modeling

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 08 Study Guide](C8-Class%20Diagrams/study_guide.md) or test your knowledge in [Chapter 08 Quiz Prep](C8-Class%20Diagrams/quiz_prep.md).

### 1. Why This Matters

Class diagrams model the static architectural structure of object-oriented systems: classes, interfaces, attributes, methods, and relationships.

### 2. Class Anatomy & Visibility

- A class box has three compartments:
  1. **Top**: Class Name + Stereotype (`«interface»`, `«record»`, `«abstract»`).
  2. **Middle**: Attributes: `[visibility] name : type [multiplicity] [= default]`.
  3. **Bottom**: Operations: `[visibility] name(param : Type) : ReturnType`.
- **Visibility Symbols**:
  - `+` Public
  - `-` Private
  - `#` Protected
  - `~` Package-Private

### 3. Relationship Typology Cheat Sheet

```mermaid
Dependency (dashed arrow)
  ClassA ..> ClassB        : "uses-a" (local variable, parameter, return type)

Association (solid arrow)
  ClassA --> ClassB        : "knows-a" (holds a reference as a field)

Aggregation (hollow diamond)
  Whole o-- Part           : "has-a" (part can exist without the whole)

Composition (filled diamond)
  Whole *-- Part           : "owns-a" (part dies when whole is destroyed)

Generalization (solid hollow triangle)
  Subclass --|> Superclass : "is-a" (class inheritance)

Realization (dashed hollow triangle)
  Class ..|> Interface    : "implements" (interface implementation)
```

### 4. Composition vs Aggregation: The Acid Test

- Ask: *"If I delete the Whole, does the Part still have a reason to exist?"*
  - **YES** ➔ **Aggregation (`o--`)**: A `Team` has `Player`s. If the team disbands, players still exist.
  - **NO** ➔ **Composition (`*--`)**: An `Order` owns `OrderLine` items. An order line cannot exist without its parent order. In JPA, this maps to `@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)`.

### 5. Applying SOLID in Class Diagrams

- **Single Responsibility (SRP)**: Split classes with operations from multiple domains (e.g. Order persistence, Order calculation, Email sending).
- **Dependency Inversion (DIP)**: `OrderService` must depend on an `OrderRepository` interface, NOT on `JpaOrderRepository` concrete class.

---

## Chapter 09: UML Activity Diagrams & Workflow Modeling

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 09 Study Guide](C9-Activity%20Diagrams/study_guide.md) or test your knowledge in [Chapter 09 Quiz Prep](C9-Activity%20Diagrams/quiz_prep.md).

### 1. Why This Matters

Activity diagrams model business workflows, complex processes, and concurrent algorithms using **token flow semantics** (Petri nets).

### 2. Core Nodes & Symbols

- **Initial Node (`●`)**: Workflow start; emits initial token.
- **Activity Final Node (`⊙` Bullseye)**: Terminates the entire workflow; destroys ALL tokens across all parallel branches.
- **Flow Final Node (`⊗` Circle with X)**: Terminates only the single path/token that reaches it; other parallel flows continue running.
- **Action Node (Rounded rectangle)**: Atomic step (e.g., `Validate Cart`).
- **Object Node (Sharp rectangle)**: Data or entity state (e.g., `Order [placed]`).

### 3. Control Nodes: Branching vs Concurrency

| Node | Symbol | Inputs / Outputs | Behavior | Code Counterpart |
| :--- | :---: | :---: | :--- | :--- |
| **Decision** | Diamond `◇` | 1 in, multiple out | Routes 1 token to the branch whose `[guard]` is true | `if / else` |
| **Merge** | Diamond `◇` | multiple in, 1 out | Passes any arriving token straight through | Merge point after `if` |
| **Fork** | Thick bar | 1 in, multiple out | Duplicates token to run all branches in parallel | `CompletableFuture.runAsync` |
| **Join** | Thick bar | multiple in, 1 out | Synchronizes: waits for tokens on ALL inputs | `CompletableFuture.allOf` |

> ⚠️ **The Implicit Join Trap**: If an action node has two incoming edges without a merge diamond, it acts as an **implicit join**! If only one path is taken at runtime, the action waits forever and **NEVER RUNS**. Always use a Merge node for alternative paths!

### 4. Swimlanes (Partitions)

Swimlanes divide the activity diagram into columns or rows, explicitly allocating who (e.g. `Customer`, `Web App`, `Payment Gateway`, `Warehouse`) performs each action.

---

## Chapter 10: UML Sequence Diagrams & Dynamic Interactions

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 10 Study Guide](C10-Sequence%20Diagrams/study_guide.md) or test your knowledge in [Chapter 10 Quiz Prep](C10-Sequence%20Diagrams/quiz_prep.md).

### 1. Why This Matters

Sequence diagrams show how objects collaborate over time to realize a specific use case scenario.

### 2. Core Notations

- **Lifeline**: Rectangle head box (`name : Class`) with a dashed vertical line.
- **Activation Bar**: Narrow vertical rectangle showing when an object is actively executing a method.
- **Synchronous Message (`──▶` Solid line, filled arrowhead)**: Caller invokes method and blocks until return.
- **Asynchronous Message (`──>` Solid line, open stick arrowhead)**: Caller sends message and continues without waiting (`@Async`, MQ).
- **Return / Reply (`┈┈>` Dashed line, open arrowhead)**: Returns control and data.
- **Object Creation**: `«create»` message pointing directly at the lifeline head box.

### 3. Entity-Control-Boundary (ECB) Pattern

- **Actor**: External user.
- **`«boundary»`**: Controllers, web adapters (`OrderController`).
- **`«control»`**: Business workflow coordinators (`OrderService`).
- **`«entity»`**: Domain entities and repositories (`Order`, `OrderRepository`).
- *Strict Rule*: Boundaries cannot talk directly to Entities! Communication must flow: `Actor ➔ Boundary ➔ Control ➔ Entity`.

### 4. Combined Interaction Fragments (UML 2.5.1 §17.6)

- **`alt`**: Alternative execution (`if / else if / else`). Guards must be mutually exclusive and exhaustive.
- **`opt`**: Optional execution (`if` without `else`).
- **`loop`**: Iteration (`for`, `while`). Guard indicates condition or bounds: `loop [1, 10]`.
- **`par`**: Parallel / concurrent interactions.
- **`break`**: Exceptional exit (throwing an exception or early return).

---

## Chapter 11: UML Component Diagrams & Modular Architectures

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 11 Study Guide](C11-Component%20Diagrams/study_guide.md) or test your knowledge in [Chapter 11 Quiz Prep](C11-Component%20Diagrams/quiz_prep.md).

### 1. Why This Matters

A real-world system contains hundreds of classes. Component diagrams provide a high-level architectural view of deployable, replaceable software units and their contracts.

### 2. Interfaces & Connectors

- **Provided Interface ("Lollipop" `──○`)**: The API or services a component offers to external clients.
- **Required Interface ("Socket" `──)`)**: The dependencies a component needs to function.
- **Assembly Connector (`──○)`)**: Plugs a required socket directly into a provided ball (wiring dependencies).
- **Delegation Connector**: Routes messages from external ports to internal classes inside the component.

```mermaid
flowchart LR
    subgraph OrderManagement["«component» Order Management"]
        O_Service[OrderService]
    end
    
    subgraph PaymentService["«component» Payment Service"]
        P_Gateway[StripeAdapter]
    end

    OrderManagement --o|OrderApi| WebUI[«component» Web UI]
    PaymentService --o|PaymentGateway| OrderManagement
```

### 3. Architectural Styles & Governance

- **Hexagonal / Ports-and-Adapters**: All dependencies point *inward* toward the core domain. Adapters implement SPI ports declared by the domain.
- **Spring Modulith & ArchUnit**: Write automated unit tests that enforce architecture rules:

  ```java
  // ArchUnit: Fail build if there is any cyclic dependency between packages!
  slices().matching("edu.itc.shop.(*)..").should().beFreeOfCycles();
  ```

---

## Chapter 12: UML Deployment Diagrams & Infrastructure Topology

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 12 Study Guide](C12-Deployment%20Diagrams/study_guide.md) or test your knowledge in [Chapter 12 Quiz Prep](C12-Deployment%20Diagrams/quiz_prep.md).

### 1. Why This Matters

Answers: *"Where does the software actually execute, and how do physical nodes talk across the network?"*

### 2. Core Elements & Stereotypes

- **Nodes (3D Cubes)**:
  - **`«device»`**: Physical hardware, bare metal server, or VM (e.g. `App Server VM`, `Load Balancer`).
  - **`«executionEnvironment»`**: Software environment executing code (e.g. `JVM 25`, `Docker Engine`, `Tomcat 11`, `PostgreSQL 17`).
- **Artifact (`«artifact»`)**: Physical file embodying software (`shop-1.0.jar`, Docker OCI image).
- **Communication Path**: Solid line between nodes showing network protocol and port (e.g., `HTTPS :443 [TLS 1.3]`, `JDBC :5432`).
- **Deployment Specification**: Text box or YAML file attached to an artifact listing runtime parameters (`application-prod.yml`, `-XX:MaxRAMPercentage=75`).

### 3. Modern Cloud & Kubernetes Mapping

- Kubernetes Worker Node ➔ `«device»`.
- Kubernetes Pod / Container ➔ `«executionEnvironment»`.
- Docker Image ➔ `«artifact»`.
- **Three-Zone Security Architecture**:
  - **DMZ**: Public load balancer (Nginx terminating TLS 443).
  - **App Zone**: Private subnet running Spring Boot application pods.
  - **Data Zone**: Isolated subnet hosting PostgreSQL and Redis. Only nodes in the App Zone may connect to the database!

---

## 🚀 Master Cheat Sheet: Diagram-to-Code Quick Reference

| UML 2.5 Element | Diagram | Java / Spring Construct | Testing Equivalent |
| :--- | :--- | :--- | :--- |
| **Actor** | Use Case | Client HTTP consumer | Playwright E2E test |
| **Use Case** | Use Case | `@Service` method | Gherkin / Cucumber BDD |
| **Class** | Class | `@Entity` or `@Component` | Unit test class |
| **Composition (`*--`)** | Class | `@OneToMany(cascade = ALL, orphanRemoval = true)` | Entity cascading test |
| **Aggregation (`o--`)** | Class | `@ManyToOne(fetch = LAZY)` | Lazy loading test |
| **Dependency (`..>`)** | Class | Method parameter or local variable | Method invocation test |
| **Decision / Merge** | Activity | `if / else` conditional | Branch coverage test |
| **Fork / Join** | Activity | `CompletableFuture.allOf()` | Concurrency timeout test |
| **Swimlane** | Activity | Architectural layer or remote microservice | Integration slice test |
| **Lifeline** | Sequence | Collaborator instance (`@Mock`, `@Service`) | `@InjectMocks` target |
| **Sync Message (`──▶`)** | Sequence | Direct Java method call | Standard assertion |
| **Async Message (`──>`)** | Sequence | `@Async` or Kafka message | Event listener test |
| **Boundary (`«boundary»`)** | Sequence | `@RestController` | `@WebMvcTest` with `MockMvc` |
| **Combined `alt`** | Sequence | `if ... else` block | Parameterized test |
| **Provided Interface (`──○`)** | Component | Public Java Interface | Contract test (Pact) |
| **Required Interface (`──)`)** | Component | Injected SPI dependency | Mockito stub |
| **`«executionEnvironment»`** | Deployment | `JVM 25`, Docker, Tomcat 11 | Testcontainers / Docker |
| **`«artifact»`** | Deployment | `shop-1.0.jar` or OCI Image | Container smoke test |
| **Deployment Spec** | Deployment | `application-prod.yml` | Environment config test |

---

*Now that you've mastered the concepts, proceed to [`quiz_prep.md`](file:///C:/Desktop/Student%20Online%20(SO)/Techno/I4-GIC-A/I4-GIC-S1/Software%20engineering/quiz_prep.md) to practice all 120 official quiz questions!*
