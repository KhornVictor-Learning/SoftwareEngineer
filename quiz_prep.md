# Software Engineering (I4-GIC-S1) — Official Quiz Preparation & Q&A Master

> **Purpose**: Complete practice questions, official slide quizzes, verified answers, detailed explanations, and high-frequency exam traps for **Software Engineering (I4-GIC-S1)** at ITC / Techno.  
> **Source**: Directly extracted from the **Check Your Understanding** quiz slides across all 12 chapters (120 official questions).

---

## 📑 Table of Contents

- [Chapter 01: Multithreading in Java Quiz](C1-MultiThread/quiz_prep.md) ([in-page](#chapter-01-multithreading-in-java-quiz))
- [Chapter 02: Spring Framework Quiz](C2-Spring%20Framework/quiz_prep.md) ([in-page](#chapter-02-spring-framework-quiz))
- [Chapter 03: Hibernate & Spring Data JPA Quiz](C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/quiz_prep.md) ([in-page](#chapter-03-hibernate--spring-data-jpa-quiz))
- [Chapter 04: RESTful Web Services (JAX-RS) Quiz](C4-RESTful%20Web%20Services%20(JAX-RS)/quiz_prep.md) ([in-page](#chapter-04-restful-web-services-jax-rs-quiz))
- [Chapter 05: Security in Java Web Applications (JWT) Quiz](C5-Security%20in%20Java%20Web%20Applications%20(Spring%20Security,%20JWT)/quiz_prep.md) ([in-page](#chapter-05-security-in-java-web-applications-jwt-quiz))
- [Chapter 06: Testing in Java Web Applications (JUnit & Mockito) Quiz](C6-Testing%20in%20Java%20Web%20Applications%20(JUnit,%20Mockito)/quiz_prep.md) ([in-page](#chapter-06-testing-in-java-web-applications-junit--mockito-quiz))
- [Chapter 07: Introduction to UML & Use Case Diagrams Quiz](C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/quiz_prep.md) ([in-page](#chapter-07-introduction-to-uml--use-case-diagrams-quiz))
- [Chapter 08: UML Class Diagrams Quiz](C8-Class%20Diagrams/quiz_prep.md) ([in-page](#chapter-08-uml-class-diagrams-quiz))
- [Chapter 09: UML Activity Diagrams Quiz](C9-Activity%20Diagrams/quiz_prep.md) ([in-page](#chapter-09-uml-activity-diagrams-quiz))
- [Chapter 10: UML Sequence Diagrams Quiz](C10-Sequence%20Diagrams/quiz_prep.md) ([in-page](#chapter-10-uml-sequence-diagrams-quiz))
- [Chapter 11: UML Component Diagrams Quiz](C11-Component%20Diagrams/quiz_prep.md) ([in-page](#chapter-11-uml-component-diagrams-quiz))
- [Chapter 12: UML Deployment Diagrams Quiz](C12-Deployment%20Diagrams/quiz_prep.md) ([in-page](#chapter-12-uml-deployment-diagrams-quiz))
- [⚡ Rapid-Fire Exam Flashcards (50 High-Yield Facts)](#-rapid-fire-exam-flashcards-50-high-yield-facts)

---

## Chapter 01: Multithreading in Java Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 01 Quiz Preparation](C1-MultiThread/quiz_prep.md) or review the [Chapter 01 Study Guide](C1-MultiThread/study_guide.md).

### Q1. Which call actually creates a new thread of execution?

- [ ] A) `thread.run()`
- [x] B) `thread.start()`
- [ ] C) `thread.join()`
- [ ] D) `Thread.yield()`

> **Correct Answer**: **B**  
> **Explanation**: `thread.start()` requests a new execution thread from the OS/JVM and invokes `run()` asynchronously on that new stack. Calling `thread.run()` simply executes the method synchronously on the *current* thread without spawning a new thread.  
> **Trap Alert**: Calling `run()` is a classic beginner mistake that compiles fine but performs sequential execution.

---

### Q2. A thread that is waiting to enter a synchronized block whose monitor is held by another thread is in state…

- [ ] A) `WAITING`
- [ ] B) `TIMED_WAITING`
- [x] C) `BLOCKED`
- [ ] D) `RUNNABLE`

> **Correct Answer**: **C**  
> **Explanation**: When a thread attempts to acquire an intrinsic monitor lock held by another thread, the JVM places it into the `BLOCKED` state until the monitor is released. `WAITING` is for `wait()` or `join()`.

---

## Q3. What does the `volatile` keyword guarantee?

- [ ] A) Atomicity of `x++`
- [x] B) Visibility and ordering of reads/writes of that field
- [ ] C) Mutual exclusion
- [ ] D) That the field is never cached in the CPU

> **Correct Answer**: **B**  
> **Explanation**: `volatile` guarantees that any write to the field is immediately visible to other threads and prevents instruction reordering (happens-before relationship). It does NOT provide mutual exclusion and does NOT make compound operations like `x++` atomic.

---

## Q4. Which is NOT one of the four Coffman conditions required for deadlock?

- [ ] A) Mutual exclusion
- [ ] B) Hold and wait
- [x] C) Preemption
- [ ] D) Circular wait

> **Correct Answer**: **C**  
> **Explanation**: The Coffman condition is **No Preemption** (resources cannot be forcibly taken from a thread). If preemption were allowed, deadlock would be broken.

---

## Q5. `Object.wait()` must be called…

- [ ] A) From any thread at any time
- [ ] B) Only from the main thread
- [x] C) While holding the monitor of that object (inside `synchronized`)
- [ ] D) Only on `Thread` objects

> **Correct Answer**: **C**  
> **Explanation**: Calling `wait()`, `notify()`, or `notifyAll()` without holding the target object's monitor lock throws `IllegalMonitorStateException`.

---

## Q6. What is the default priority of a new Java thread?

- [ ] A) 1 (`MIN_PRIORITY`)
- [x] B) 5 (`NORM_PRIORITY`)
- [ ] C) 10 (`MAX_PRIORITY`)
- [ ] D) It inherits the OS default, unknown to Java

> **Correct Answer**: **B**  
> **Explanation**: Java thread priorities range from 1 to 10; default priority is constant 5 (`Thread.NORM_PRIORITY`).

---

## Q7. You call `worker.interrupt()` on a thread that is busy computing and never checks the flag or blocks. What happens?

- [ ] A) It stops immediately
- [ ] B) `InterruptedException` is thrown in the worker
- [x] C) Only its interrupted flag is set; it keeps running
- [ ] D) The JVM kills it after a timeout

> **Correct Answer**: **C**  
> **Explanation**: Thread cancellation in Java is purely cooperative. `interrupt()` sets the interrupt status flag. If the thread is executing CPU loops and never checks `isInterrupted()` or calls blocking methods (`sleep`, `wait`), it will continue running indefinitely.

---

## Q8. Why is `ConcurrentHashMap` preferred over `Hashtable` or `Collections.synchronizedMap`?

- [ ] A) It is immutable
- [ ] B) It allows null keys
- [x] C) Fine-grained locking and non-blocking reads give much better concurrency, plus atomic compute/merge
- [ ] D) It preserves insertion order

> **Correct Answer**: **C**  
> **Explanation**: `Hashtable` and `synchronizedMap` lock the entire table on every read/write. `ConcurrentHashMap` uses lock-free volatile reads and per-bucket / per-node locks for writes, enabling high concurrent throughput.

---

## Q9. `Executors.newVirtualThreadPerTaskExecutor()` is the best fit for…

- [ ] A) CPU-bound number crunching
- [x] B) Thousands of tasks that mostly block on I/O
- [ ] C) Tasks that must run in a strict sequence
- [ ] D) Periodic scheduling

> **Correct Answer**: **B**  
> **Explanation**: Virtual threads excel when tasks spend most of their lifetime blocked on network or disk I/O, allowing the carrier platform thread to execute other virtual threads.

---

## Q10. Which synchronizer can be reused after it has released the waiting threads?

- [ ] A) `CountDownLatch`
- [x] B) `CyclicBarrier`
- [ ] C) Neither
- [ ] D) Both

> **Correct Answer**: **B**  
> **Explanation**: A `CountDownLatch` is a one-shot gate: once its count hits 0, it cannot be reset. A `CyclicBarrier` automatically resets to its party count and can be cycled repeatedly.

---

## Chapter 02: Spring Framework Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 02 Quiz Preparation](C2-Spring%20Framework/quiz_prep.md) or review the [Chapter 02 Study Guide](C2-Spring%20Framework/study_guide.md).

## Q1. Which injection style does the Spring team recommend for mandatory dependencies?

- [ ] A) Field injection with `@Autowired`
- [ ] B) Setter injection
- [x] C) Constructor injection
- [ ] D) Static factory lookup

> **Correct Answer**: **C**  
> **Explanation**: Constructor injection ensures mandatory dependencies cannot be null, allows fields to be `final` (immutable), and enables POJO unit testing without Spring container overhead.

---

## Q2. What is the default scope of a Spring bean?

- [ ] A) `prototype`
- [x] B) `singleton`
- [ ] C) `request`
- [ ] D) `session`

> **Correct Answer**: **B**  
> **Explanation**: Spring creates exactly one shared bean instance per `ApplicationContext` by default (`singleton`).

---

## Q3. `@SpringBootApplication` is a combination of…

- [ ] A) `@Controller` + `@Service` + `@Repository`
- [x] B) `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`
- [ ] C) `@Bean` + `@Import`
- [ ] D) `@RestController` + `@RequestMapping`

> **Correct Answer**: **B**  
> **Explanation**: `@SpringBootApplication` is a meta-annotation that configures bean definitions, enables convention-based auto-configuration, and triggers package component scanning.

---

## Q4. `server.port` is 8080 in `application.yml` and 9090 in `application-prod.yml`. The app is started with `--server.port=7070` and profile `prod`. Which port is used?

- [ ] A) 8080
- [ ] B) 9090
- [x] C) 7070
- [ ] D) Start-up fails because of the conflict

> **Correct Answer**: **C**  
> **Explanation**: Command-line arguments have the highest precedence in Spring Boot's property resolution hierarchy and override profile-specific YAML files.

---

## Q5. A `@Transactional` public method is called from another method of the same class via `this.method()`. What happens?

- [ ] A) A transaction is started as usual
- [x] B) No transaction: the call bypasses the proxy
- [ ] C) A nested transaction is created
- [ ] D) An exception is thrown

> **Correct Answer**: **B**  
> **Explanation**: Spring AOP implements `@Transactional` via dynamic proxies. Calling `this.method()` invokes the target instance directly, bypassing the proxy and its transaction interceptor.

---

## Q6. Which annotation binds a JSON request body to a method parameter?

- [ ] A) `@RequestParam`
- [ ] B) `@ModelAttribute`
- [x] C) `@RequestBody`
- [ ] D) `@PathVariable`

> **Correct Answer**: **C**  
> **Explanation**: `@RequestBody` deserializes the HTTP request body into a Java object using HTTP message converters (Jackson).

---

## Q7. A `@Valid @RequestBody` DTO fails validation in a `@RestController`. Without any custom handling the client receives…

- [ ] A) 500 Internal Server Error
- [x] B) 400 Bad Request
- [ ] C) 422 Unprocessable Entity
- [ ] D) 200 with an empty body

> **Correct Answer**: **B**  
> **Explanation**: Spring MVC throws `MethodArgumentNotValidException`, which by default resolves to an HTTP 400 Bad Request status.

---

## Q8. Compared with raw JDBC, `JdbcClient` / `JdbcTemplate` do NOT do which of the following?

- [ ] A) Open and close connections
- [ ] B) Translate `SQLException` into `DataAccessException`
- [x] C) Generate the SQL for you from the record type
- [ ] D) Bind named parameters

> **Correct Answer**: **C**  
> **Explanation**: `JdbcTemplate` / `JdbcClient` is a template abstraction over JDBC, not an ORM. You must write your own SQL queries.

---

## Q9. Which Actuator endpoint is typically used by Kubernetes liveness/readiness probes?

- [ ] A) `/actuator/env`
- [x] B) `/actuator/health`
- [ ] C) `/actuator/beans`
- [ ] D) `/actuator/loggers`

> **Correct Answer**: **B**  
> **Explanation**: Kubernetes queries `/actuator/health/liveness` and `/actuator/health/readiness` to determine container lifecycle.

---

## Q10. What extra behaviour does `@Repository` add compared to `@Component`?

- [ ] A) Automatic transactions
- [x] B) Translation of persistence exceptions into Spring's `DataAccessException` hierarchy
- [ ] C) Connection pooling
- [ ] D) JSON serialisation

> **Correct Answer**: **B**  
> **Explanation**: `@Repository` enables automatic exception translation via Spring's `PersistenceExceptionTranslationPostProcessor`.

---

## Chapter 03: Hibernate & Spring Data JPA Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 03 Quiz Preparation](C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/quiz_prep.md) or review the [Chapter 03 Study Guide](C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/study_guide.md).

## Q1. Which identifier generation strategy prevents Hibernate from batching INSERT statements?

- [ ] A) `SEQUENCE` with `allocationSize = 50`
- [x] B) `IDENTITY`
- [ ] C) `UUID`
- [ ] D) `AUTO`

> **Correct Answer**: **B**  
> **Explanation**: `IDENTITY` relies on the database table's auto-increment column; Hibernate must immediately execute each `INSERT` to retrieve the generated ID, breaking JDBC statement batching.

---

## Q2. In a bidirectional one-to-many, what does `mappedBy = "order"` on `Order.lines` declare?

- [ ] A) `Order` owns the foreign key column
- [ ] B) The collection is fetched eagerly
- [x] C) `OrderLine.order` is the owning side and holds the FK column
- [ ] D) A join table must be created

> **Correct Answer**: **C**  
> **Explanation**: `mappedBy` designates the inverse side. It specifies that the entity on the other end (`OrderLine`) contains the field (`order`) that owns the foreign key.

---

## Q3. What are the default fetch types of `@ManyToOne` and `@OneToMany`, respectively?

- [ ] A) `LAZY` / `LAZY`
- [x] B) `EAGER` / `LAZY`
- [ ] C) `EAGER` / `EAGER`
- [ ] D) `LAZY` / `EAGER`

> **Correct Answer**: **B**  
> **Explanation**: In JPA, all single-valued associations (`@ManyToOne`, `@OneToOne`) default to `EAGER`. All collection-valued associations (`@OneToMany`, `@ManyToMany`) default to `LAZY`.

---

## Q4. You touch a lazy collection after the transaction ended (`open-in-view=false`). What happens?

- [ ] A) Hibernate opens a new connection and loads it
- [ ] B) An empty list is returned
- [x] C) A `LazyInitializationException` is thrown
- [ ] D) It is served from the second-level cache

> **Correct Answer**: **C**  
> **Explanation**: Once the transaction and persistence context close, accessing an uninitialized proxy throws `LazyInitializationException`.

---

## Q5. How does Hibernate know it must issue an UPDATE for a managed entity you modified without calling `save()`?

- [ ] A) The setter sends SQL immediately
- [x] B) Dirty checking: at flush it compares the entity with the snapshot taken when it was loaded
- [ ] C) Spring Data intercepts setters with a proxy
- [ ] D) It re-reads the row and diffs it

> **Correct Answer**: **B**  
> **Explanation**: Hibernate takes an internal snapshot when an entity becomes managed. During transaction flush, it diffs current values against the snapshot and executes updates automatically.

---

## Q6. Two transactions load Order 42 with version 3 and both update it. What happens to the second commit?

- [ ] A) It silently overwrites the first update
- [ ] B) It waits for a row lock
- [x] C) It fails with an `OptimisticLockException` because `UPDATE … WHERE version = 3` affects 0 rows
- [ ] D) Hibernate merges both changes

> **Correct Answer**: **C**  
> **Explanation**: The first commit updates version to 4. The second commit attempts to update matching version 3, matches 0 rows, and triggers `OptimisticLockException`.

---

## Q7. Which return type avoids the extra count query when paginating?

- [ ] A) `Page<T>`
- [ ] B) `List<T>` with `Pageable`
- [x] C) `Slice<T>`
- [ ] D) `Stream<T>`

> **Correct Answer**: **C**  
> **Explanation**: `Page<T>` executes an expensive `SELECT COUNT(*)` query to calculate total pages. `Slice<T>` only fetches `limit + 1` rows to check if a next slice exists, avoiding the count query entirely.

---

## Q8. Which of these does NOT fix an N+1 problem?

- [ ] A) `join fetch` in JPQL
- [ ] B) `@EntityGraph(attributePaths = "lines")`
- [ ] C) `@BatchSize` / `default_batch_fetch_size`
- [x] D) `spring.jpa.open-in-view=true`

> **Correct Answer**: **D**  
> **Explanation**: Open Session in View (OSIV) keeps the DB connection open during web page rendering. It hides `LazyInitializationException` by executing the N queries during view rendering, making N+1 worse.

---

## Q9. With Flyway managing the schema, which `spring.jpa.hibernate.ddl-auto` value should production use?

- [ ] A) `update`
- [ ] B) `create-drop`
- [x] C) `validate`
- [ ] D) `create`

> **Correct Answer**: **C**  
> **Explanation**: In production, Flyway executes immutable SQL scripts. Setting `ddl-auto=validate` (or `none`) verifies that JPA mappings match the schema without modifying the database.

---

## Q10. Why is generating `equals`/`hashCode` from all entity fields (Lombok `@Data`) a mistake?

- [ ] A) It is slower than the default
- [x] B) The hash changes when the id is assigned or a field is edited, so the entity is lost in a `HashSet` and associations may be loaded
- [ ] C) JPA forbids overriding equals
- [ ] D) It disables dirty checking

> **Correct Answer**: **B**  
> **Explanation**: Entities have mutable fields and their ID is null before persistence. Changing fields changes the hash code, breaking `HashSet` / `HashMap` contracts and triggering unwanted lazy loading.

---

## Chapter 04: RESTful Web Services (JAX-RS) Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 04 Quiz Preparation](C4-RESTful%20Web%20Services%20%28JAX-RS%29/quiz_prep.md) or review the [Chapter 04 Study Guide](C4-RESTful%20Web%20Services%20%28JAX-RS%29/study_guide.md).

## Q1. Which HTTP method is both safe and idempotent?

- [ ] A) `POST`
- [x] B) `GET`
- [ ] C) `PATCH`
- [ ] D) None of them

> **Correct Answer**: **B**  
> **Explanation**: `GET` is safe (does not alter server state) and idempotent (multiple identical requests have the exact same effect as a single request). `PUT` and `DELETE` are idempotent but unsafe. `POST` is neither.

---

## Q2. A POST creates a new product. Which response is correct?

- [ ] A) `200 OK` with the product
- [ ] B) `204 No Content`
- [x] C) `201 Created` with a `Location` header pointing at the new resource
- [ ] D) `202 Accepted`

> **Correct Answer**: **C**  
> **Explanation**: Successful resource creation returns `201 Created` and sets the `Location` header to the URI of the newly created resource.

---

## Q3. Which pair binds `?size=20` to a parameter and supplies 20 when it is absent?

- [ ] A) `@PathParam` + `@Context`
- [x] B) `@QueryParam` + `@DefaultValue`
- [ ] C) `@HeaderParam` + `@BeanParam`
- [ ] D) `@FormParam` + `@Produces`

> **Correct Answer**: **B**  
> **Explanation**: `@QueryParam("size")` extracts URL query string parameters, and `@DefaultValue("20")` provides the fallback.

---

## Q4. The client sends `Accept: text/csv` but the method only has `@Produces("application/json")`. What happens?

- [ ] A) JSON is returned anyway
- [ ] B) `415 Unsupported Media Type`
- [x] C) `406 Not Acceptable`
- [ ] D) `404 Not Found`

> **Correct Answer**: **C**  
> **Explanation**: When the server cannot produce a representation matching the client's `Accept` header, HTTP specification requires returning `406 Not Acceptable`.

---

## Q5. Which provider turns an exception into an HTTP response?

- [ ] A) `ContainerResponseFilter`
- [ ] B) `MessageBodyWriter`
- [x] C) `ExceptionMapper`
- [ ] D) `ParamConverterProvider`

> **Correct Answer**: **C**  
> **Explanation**: In Jakarta REST, implementing `ExceptionMapper<E>` allows catching application exceptions and translating them into structured HTTP `Response` objects.

---

## Q6. A `ContainerRequestFilter` must inspect the raw URI before the resource method is chosen. Which annotation does it need?

- [x] A) `@PreMatching`
- [ ] B) `@NameBinding`
- [ ] C) `@Priority`
- [ ] D) `@Context`

> **Correct Answer**: **A**  
> **Explanation**: `@PreMatching` filters execute before URI path matching occurs, allowing URI or HTTP method rewrites.

---

## Q7. What does `Request.evaluatePreconditions(tag)` return when the request carries a matching `If-None-Match` header?

- [ ] A) `null`
- [x] B) A `ResponseBuilder` already set to `304 Not Modified`
- [ ] C) A `ResponseBuilder` set to 412
- [ ] D) It throws `NotModifiedException`

> **Correct Answer**: **B**  
> **Explanation**: If the provided ETag matches the client's cached ETag, `evaluatePreconditions()` returns a pre-configured `304 Not Modified` response builder.

---

## Q8. Which media type does RFC 9457 define for error bodies?

- [ ] A) `application/error+json`
- [x] B) `application/problem+json`
- [ ] C) `text/problem`
- [ ] D) `application/vnd.error`

> **Correct Answer**: **B**  
> **Explanation**: RFC 9457 / RFC 7807 defines `application/problem+json` as the standard format for reporting errors from HTTP APIs.

---

## Q9. A method annotated with `@Path("{id}/reviews")` but with no HTTP method annotation that returns a `ReviewResource` is called a…

- [x] A) sub-resource locator
- [ ] B) name-bound filter
- [ ] C) dynamic feature
- [ ] D) entity provider

> **Correct Answer**: **A**  
> **Explanation**: In JAX-RS, a method with `@Path` but lacking `@GET`/`@POST` that returns another resource class is a **sub-resource locator**.

---

## Q10. Which request selects version 2 of a representation through content negotiation rather than the URI?

- [ ] A) `GET /v2/products/1`
- [ ] B) `GET /products/1?v=2`
- [x] C) `GET /products/1` with `Accept: application/vnd.shop.v2+json`
- [ ] D) `GET /products/1` with `X-Api-Key: v2`

> **Correct Answer**: **C**  
> **Explanation**: Using vendor-specific media types in the `Accept` header is the canonical REST approach to content-negotiated API versioning.

---

## Chapter 05: Security in Java Web Applications (JWT) Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 05 Quiz Preparation](C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/quiz_prep.md) or review the [Chapter 05 Study Guide](C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/study_guide.md).

## Q1. A logged-in customer calls `DELETE /api/products/7`, which requires `ROLE_ADMIN`. Which status code does Spring Security return?

- [ ] A) `400 Bad Request`
- [ ] B) `401 Unauthorized`
- [x] C) `403 Forbidden`
- [ ] D) `404 Not Found`

> **Correct Answer**: **C**  
> **Explanation**: `401 Unauthorized` means unauthenticated (identity unknown). `403 Forbidden` means authenticated, but lacking necessary authorities/roles.

---

## Q2. Why are MD5 or plain SHA-256 unsuitable for storing passwords?

- [ ] A) They produce hashes that are too long for a VARCHAR column
- [x] B) They are fast, so billions of guesses per second can be tried offline
- [ ] C) They are not supported by Spring Security
- [ ] D) They cannot be salted

> **Correct Answer**: **B**  
> **Explanation**: MD5 and SHA-256 are general-purpose cryptographic algorithms optimized for speed. Attackers can brute-force billions of hashes per second using GPUs. Password hashing requires intentionally slow, salted algorithms like BCrypt.

---

## Q3. What does `hasRole("ADMIN")` actually check?

- [ ] A) An authority named exactly `ADMIN`
- [x] B) An authority named `ROLE_ADMIN`
- [ ] C) A claim named `admin` in the JWT
- [ ] D) The username `admin`

> **Correct Answer**: **B**  
> **Explanation**: Spring Security automatically prefixes role checks in `hasRole()` with `ROLE_`. Checking `hasRole("ADMIN")` verifies the presence of `ROLE_ADMIN`.

---

## Q4. Which statement about `@PreAuthorize` on a service method is correct?

- [ ] A) It works on private methods too
- [ ] B) It is evaluated only for HTTP requests
- [x] C) It is applied through a proxy, so self-invocation bypasses it
- [ ] D) It replaces the need for URL rules

> **Correct Answer**: **C**  
> **Explanation**: Like `@Transactional`, method security uses Spring AOP proxies. Calling a `@PreAuthorize` method internally via `this.method()` bypasses security interceptors.

---

## Q5. In the filter chain, which component picks the `SecurityFilterChain` that applies to a request?

- [ ] A) `DispatcherServlet`
- [x] B) `FilterChainProxy`
- [ ] C) `AuthorizationFilter`
- [ ] D) `DelegatingFilterProxy`

> **Correct Answer**: **B**  
> **Explanation**: `DelegatingFilterProxy` is the standard servlet filter that delegates to the Spring-managed `FilterChainProxy`, which evaluates request matchers and routes to the matching `SecurityFilterChain`.

---

## Q6. Why is CSRF protection usually disabled for a stateless JWT API?

- [ ] A) Because JWTs are encrypted
- [x] B) Because the token travels in the Authorization header, which browsers never add automatically
- [ ] C) Because `SessionCreationPolicy.STATELESS` already blocks cross-site requests
- [ ] D) Because CSRF only affects GET requests

> **Correct Answer**: **B**  
> **Explanation**: CSRF exploits the browser's automatic inclusion of session cookies on cross-origin requests. Because JWTs are stored in memory/localStorage and sent via `Authorization: Bearer`, third-party sites cannot forge requests.

---

## Q7. A JWT payload contains `{"sub":"alice","password":"secret"}`. What is the problem?

- [ ] A) Nothing, the signature protects the payload
- [x] B) The payload is only base64url-encoded, so anyone holding the token can read it
- [ ] C) JWTs may not contain more than two claims
- [ ] D) The `sub` claim must be numeric

> **Correct Answer**: **B**  
> **Explanation**: JWTs are digitally signed, NOT encrypted. The payload is readable in plaintext by anyone by decoding Base64URL. Never include passwords or confidential keys in claims.

---

## Q8. What happens when a client presents an expired JWT to an endpoint protected by `oauth2ResourceServer().jwt()`?

- [ ] A) The token is silently refreshed
- [x] B) `401` with `WWW-Authenticate: Bearer error="invalid_token"`
- [ ] C) `403 Forbidden`
- [ ] D) The request proceeds as anonymous with a warning

> **Correct Answer**: **B**  
> **Explanation**: Expired tokens fail signature/expiration validation, returning a `401 Unauthorized` with error details in the `WWW-Authenticate` response header.

---

## Q9. A product review containing `<script>steal()</script>` is stored. Which measure prevents it from executing on another customer's screen?

- [ ] A) Deleting the word `script` on input
- [ ] B) Storing the review in a NoSQL database
- [x] C) HTML-encoding the text when rendering (`th:text`, `c:out`, `HtmlUtils.htmlEscape`)
- [ ] D) Using HTTPS

> **Correct Answer**: **C**  
> **Explanation**: Proper contextual HTML entity escaping (`<` becomes `&lt;`) prevents browser HTML parsers from executing injected script tags (XSS mitigation).

---

## Q10. Where should the JWT signing secret live in a Spring Boot project?

- [ ] A) Hard-coded in `JwtConfig` so it cannot be changed by mistake
- [ ] B) In `application.yml` committed to git
- [x] C) In an environment variable or Vault, referenced as `${JWT_SECRET}`
- [ ] D) In the README so the team can find it

> **Correct Answer**: **C**  
> **Explanation**: Production secrets must never be committed to source control. They should be injected at runtime via environment variables or secret vaults.

---

## Chapter 06: Testing in Java Web Applications (JUnit & Mockito) Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 06 Quiz Preparation](C6-Testing%20in%20Java%20Web%20Applications%20%28JUnit%2C%20Mockito%29/quiz_prep.md) or review the [Chapter 06 Study Guide](C6-Testing%20in%20Java%20Web%20Applications%20%28JUnit%2C%20Mockito%29/study_guide.md).

## Q1. According to the test pyramid, which kind of test should be the most numerous in the shop project?

- [ ] A) End-to-end browser tests
- [x] B) Unit tests without Spring
- [ ] C) `@SpringBootTest` tests on a random port
- [ ] D) Manual exploratory tests

> **Correct Answer**: **B**  
> **Explanation**: Unit tests without Spring are fast (sub-millisecond), reliable, and isolate domain logic, forming the broad foundation of the test pyramid.

---

## Q2. In a JUnit Jupiter class with the default lifecycle, which method runs exactly once before all tests and must be static?

- [ ] A) `@BeforeEach`
- [x] B) `@BeforeAll`
- [ ] C) `@Nested`
- [ ] D) `@Test`

> **Correct Answer**: **B**  
> **Explanation**: `@BeforeAll` executes once before any test methods run. In the default per-method test lifecycle, it must be declared `static`.

---

## Q3. What does `assertAll(...)` do that a sequence of plain `assertEquals` calls does not?

- [ ] A) It runs the assertions in parallel threads
- [x] B) It executes every assertion and reports all failures together
- [ ] C) It stops the test at the first passing assertion
- [ ] D) It retries failed assertions

> **Correct Answer**: **B**  
> **Explanation**: Standard assertions fail immediately at the first failing assertion. `assertAll` runs all supplied executables and aggregates all failures into a single report.

---

## Q4. Which annotation feeds a `@ParameterizedTest` from a static method returning `Stream`?

- [ ] A) `@ValueSource`
- [ ] B) `@CsvSource`
- [x] C) `@MethodSource`
- [ ] D) `@EnumSource`

> **Correct Answer**: **C**  
> **Explanation**: `@MethodSource` references a static factory method providing argument streams or collections to parameterized tests.

---

## Q5. With `@ExtendWith(MockitoExtension.class)` and default settings, a `when(...).thenReturn(...)` stub that the test never uses causes…

- [ ] A) nothing, unused stubs are ignored
- [ ] B) a compile error
- [x] C) an `UnnecessaryStubbingException` that fails the test
- [ ] D) a warning printed to `System.out` only

> **Correct Answer**: **C**  
> **Explanation**: Mockito 5 enables strict stubbing by default. Any stub that is never called during test execution triggers an `UnnecessaryStubbingException` to prevent code rot.

---

## Q6. What is the difference between a `@Spy` and a `@Mock` in Mockito?

- [x] A) A spy calls the real methods unless stubbed; a mock returns defaults
- [ ] B) A spy cannot be verified
- [ ] C) A mock wraps a real instance; a spy is empty
- [ ] D) There is no difference in Mockito 5

> **Correct Answer**: **A**  
> **Explanation**: A mock is an empty shell returning default values (null, 0, false). A spy delegates to an underlying real object instance unless a specific method is stubbed.

---

## Q7. In a `@WebMvcTest(ProductController.class)` slice, how does the test get a `ProductService`?

- [ ] A) The real `@Service` bean is component-scanned automatically
- [x] B) It must be declared with `@MockitoBean` (or `@Import`)
- [ ] C) `MockMvc` creates one on the fly
- [ ] D) It is injected from `application.yml`

> **Correct Answer**: **B**  
> **Explanation**: `@WebMvcTest` disables regular component scanning of `@Service` and `@Repository` beans. Collaborators must be provided as test doubles using `@MockitoBean` (or `@MockBean`).

---

## Q8. Which statement about `@DataJpaTest` is correct by default?

- [ ] A) It starts the embedded Tomcat server
- [x] B) Each test runs in a transaction that is rolled back and uses an embedded database
- [ ] C) It commits every test so data can be inspected
- [ ] D) It requires Docker to run

> **Correct Answer**: **B**  
> **Explanation**: `@DataJpaTest` configures an in-memory/test database, disables web layers, and wraps each test in a transaction that automatically rolls back at test completion.

---

## Q9. What does `@ServiceConnection` on a Testcontainers `PostgreSQLContainer` field do?

- [ ] A) Opens a JDBC connection pool inside the test class
- [x] B) Derives `spring.datasource.*` properties from the running container automatically
- [ ] C) Replaces PostgreSQL with H2
- [ ] D) Starts the container only when Docker is missing

> **Correct Answer**: **B**  
> **Explanation**: Spring Boot's `@ServiceConnection` automatically discovers the dynamic port and credentials of a running Testcontainer and binds them to Spring environment properties.

---

## Q10. The JaCoCo check goal is configured with counter `LINE`, value `COVEREDRATIO`, minimum `0.80`. What happens when line coverage is 76%?

- [x] A) The build fails in the verify phase
- [ ] B) A warning is logged and the build passes
- [ ] C) Coverage is rounded up to 80%
- [ ] D) Only the HTML report is skipped

> **Correct Answer**: **A**  
> **Explanation**: JaCoCo's `check` goal enforces coverage thresholds and halts the Maven/Gradle build during the `verify` phase if criteria are unmet.

---

## Chapter 07: Introduction to UML & Use Case Diagrams Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 07 Quiz Preparation](C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/quiz_prep.md) or review the [Chapter 07 Study Guide](C7-Introduction%20to%20UML%20and%20Use%20Case%20Diagrams/study_guide.md).

## Q1. What is UML 2.5.1 best described as?

- [ ] A) A software development process
- [x] B) A graphical modelling language standardised by the OMG
- [ ] C) A Java code generator
- [ ] D) A testing framework

> **Correct Answer**: **B**  
> **Explanation**: UML is a standard visual modeling language specified by the Object Management Group (OMG); it is a notation, not a methodology or development process.

---

## Q2. Which of these is a UML structure diagram?

- [ ] A) Sequence diagram
- [ ] B) Activity diagram
- [x] C) Component diagram
- [ ] D) Use case diagram

> **Correct Answer**: **C**  
> **Explanation**: Structure diagrams model static elements (Component, Class, Deployment, Object). Behavior diagrams model dynamic workflows (Activity, Sequence, Use Case, State Machine).

---

## Q3. In the online shop, how should the external Payment Gateway appear on the use case diagram?

- [ ] A) As a use case inside the boundary
- [x] B) As a supporting actor outside the boundary, on the right
- [ ] C) As a note attached to Pay for order
- [ ] D) It should not appear at all

> **Correct Answer**: **B**  
> **Explanation**: External systems that provide auxiliary services to the application are modeled as supporting actors placed outside the system boundary on the right.

---

## Q4. What does `UC2 ..> UC6 : <<include>>` mean?

- [ ] A) UC6 optionally adds behaviour to UC2
- [x] B) UC2 always runs the behaviour of UC6 as part of itself
- [ ] C) UC6 is a specialisation of UC2
- [ ] D) UC2 and UC6 share an actor

> **Correct Answer**: **B**  
> **Explanation**: An `«include»` dependency indicates mandatory, unconditional execution of the target use case as an essential step of the base use case.

---

## Q5. In which direction does the `«extend»` dashed arrow point?

- [ ] A) From the base use case to the extension
- [x] B) From the extension to the base use case
- [ ] C) From the actor to the extension
- [ ] D) Either direction is acceptable

> **Correct Answer**: **B**  
> **Explanation**: The `«extend»` relationship arrow points from the optional extending use case back to the base use case that it extends.

---

## Q6. Which is the best use case name?

- [ ] A) `Order`
- [ ] B) `Click the Pay button`
- [x] C) `Place order`
- [ ] D) `OrderService.placeOrder`

> **Correct Answer**: **C**  
> **Explanation**: Proper use case names follow the **Active Verb + Business Noun** format at the user goal level (`Place order`).

---

## Q7. Which statement about preconditions is correct?

- [ ] A) They are checked again in step 1 of the main scenario
- [ ] B) They describe the state after the use case succeeds
- [x] C) They must be true before the use case starts and are not re-checked in the steps
- [ ] D) They list the supporting actors

> **Correct Answer**: **C**  
> **Explanation**: Preconditions state assumptions guaranteed to be true prior to initiation; they do not need redundant checking steps in the main scenario.

---

## Q8. What does a solid line with a hollow triangle between `Registered customer` and `Customer` express?

- [ ] A) `Registered customer` includes `Customer`
- [x] B) `Registered customer` is a specialisation of `Customer` and inherits its associations
- [ ] C) `Customer` extends `Registered customer`
- [ ] D) They are the same actor drawn twice

> **Correct Answer**: **B**  
> **Explanation**: A solid line with a hollow triangle represents generalization/inheritance. The specialized child actor inherits all associations of the parent actor.

---

## Q9. What does a traceability matrix in this chapter link together?

- [ ] A) Classes, packages and modules
- [x] B) Business requirements, use cases and tests
- [ ] C) Actors, screens and database tables
- [ ] D) Sprints, stories and developers

> **Correct Answer**: **B**  
> **Explanation**: A traceability matrix connects high-level Business Requirements (BR) to Use Cases (UC) and automated verification Tests.

---

## Q10. A diagram shows `Login`, `Enter address`, `Click Pay` and `Show confirmation` as use cases chained with `«include»`. What is the main mistake?

- [x] A) Functional decomposition: UI steps drawn as use cases instead of one user goal
- [ ] B) Too few actors
- [ ] C) Missing generalization
- [ ] D) The system boundary is too small

> **Correct Answer**: **A**  
> **Explanation**: Decomposing single user goals into fine-grained UI button clicks and screens is the classic "functional decomposition" anti-pattern in use case modeling.

---

## Chapter 08: UML Class Diagrams Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 08 Quiz Preparation](C8-Class%20Diagrams/quiz_prep.md) or review the [Chapter 08 Study Guide](C8-Class%20Diagrams/study_guide.md).

## Q1. Which visibility symbol marks a package-private member in UML?

- [ ] A) `#`
- [x] B) `~`
- [ ] C) `-`
- [ ] D) `*`

> **Correct Answer**: **B**  
> **Explanation**: In UML: `+` is public, `-` is private, `#` is protected, and `~` is package-private.

---

## Q2. How is a realization (a class implementing an interface) drawn?

- [ ] A) Solid line with a hollow triangle at the interface
- [x] B) Dashed line with a hollow triangle at the interface
- [ ] C) Dashed line with an open arrowhead at the class
- [ ] D) Solid line with a filled diamond at the interface

> **Correct Answer**: **B**  
> **Explanation**: Realization uses a dashed line with a hollow triangular arrowhead pointing toward the implemented interface. (Generalization uses a solid line).

---

## Q3. A filled diamond at the Order end of the Order-OrderLine line means…

- [ ] A) `OrderLine` is optional
- [ ] B) `Order` and `OrderLine` are both abstract
- [x] C) `OrderLine` is a part owned by `Order` and dies with it
- [ ] D) `OrderLine` may be shared by several orders

> **Correct Answer**: **C**  
> **Explanation**: A filled diamond (`◆`) denotes **Composition**: a strong whole-part relationship where parts cannot exist independently of the whole.

---

## Q4. Which Java code matches the composition `Order ◆-- OrderLine` best?

- [ ] A) `public List lines;` set from outside
- [x] B) `private final List<OrderLine> lines = new ArrayList<>();` created by `addLine()`, exposed via `List.copyOf`
- [ ] C) `private OrderLine[] lines` passed into the constructor and returned directly
- [ ] D) a static List shared by all orders

> **Correct Answer**: **B**  
> **Explanation**: Composition requires strict encapsulation where the composite root manages the creation, modification, and lifecycle of its internal parts.

---

## Q5. `Customer "1" <-- "0..*" Order` in Mermaid says that…

- [x] A) every order has exactly one customer and `Order` holds the reference
- [ ] B) every customer has exactly one order
- [ ] C) `Customer` holds a list of orders
- [ ] D) orders and customers are unrelated

> **Correct Answer**: **A**  
> **Explanation**: The arrowhead indicates navigability (Order holds reference to Customer), multiplicity 1 means each Order has 1 Customer, and `0..*` means a Customer can have many Orders.

---

## Q6. `OrderService.place(PlaceOrder cmd)` takes a `PlaceOrder` parameter and stores nothing. In the diagram this is…

- [ ] A) an association `OrderService --> PlaceOrder`
- [ ] B) a composition `OrderService *-- PlaceOrder`
- [x] C) a dependency `OrderService ..> PlaceOrder`
- [ ] D) a generalization

> **Correct Answer**: **C**  
> **Explanation**: A dependency (`..>`) indicates a transient "uses-a" relationship (e.g. method parameter, return type, or local variable) rather than a persistent field reference.

---

## Q7. In Mermaid `classDiagram`, how do you mark a class as an interface?

- [ ] A) `interface PaymentGateway { }`
- [ ] B) `class PaymentGateway <> on the relation line`
- [x] C) the annotation `<<interface>>` as the first line inside the class body
- [ ] D) `PaymentGateway : interface`

> **Correct Answer**: **C**  
> **Explanation**: In Mermaid syntax, stereotypes like `<<interface>>`, `<<abstract>>`, or `<<record>>` are placed on the first line inside the class definition block.

---

## Q8. Which JPA mapping corresponds to a composition of `OrderLine` inside `Order`?

- [ ] A) `@ManyToMany` with a join table
- [x] B) `@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)`
- [ ] C) `@ManyToOne(optional = true)`
- [ ] D) `@Transient`

> **Correct Answer**: **B**  
> **Explanation**: Composition lifecycle coupling in JPA is represented by cascading all operations and enabling `orphanRemoval = true`.

---

## Q9. `OrderService` (package service) has an association to `JpaOrderRepository` (package repository). Which principle is violated?

- [ ] A) Single Responsibility
- [ ] B) Liskov Substitution
- [ ] C) Interface Segregation
- [x] D) Dependency Inversion

> **Correct Answer**: **D**  
> **Explanation**: The Dependency Inversion Principle (DIP) states that high-level modules (`OrderService`) should depend on abstractions (`OrderRepository` interface), not concrete implementations (`JpaOrderRepository`).

---

## Q10. Which of these is a common mistake in a class diagram?

- [ ] A) Writing a multiplicity at both association ends
- [x] B) Listing getters and setters as the operations of every class
- [ ] C) Using `<>` for a Java interface
- [ ] D) Drawing packages as namespaces

> **Correct Answer**: **B**  
> **Explanation**: Cluttering diagrams with trivial accessors (`getId()`, `setId()`) obscures genuine domain responsibilities with unnecessary noise.

---

## Chapter 09: UML Activity Diagrams Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 09 Quiz Preparation](C9-Activity%20Diagrams/quiz_prep.md) or review the [Chapter 09 Study Guide](C9-Activity%20Diagrams/study_guide.md).

## Q1. Which symbol is the activity final node?

- [ ] A) A filled circle
- [x] B) A circle with a filled dot inside
- [ ] C) A circle with an X inside
- [ ] D) A thick horizontal bar

> **Correct Answer**: **B**  
> **Explanation**: An Activity Final Node is drawn as a bullseye (a circle containing a solid black dot `⊙`).

---

## Q2. What is the difference between a flow final `⊗` and an activity final `⊙`?

- [ ] A) There is none, they are synonyms
- [x] B) A flow final ends only the arriving token; an activity final terminates all flows
- [ ] C) A flow final may appear only inside swimlanes
- [ ] D) An activity final is used only in business processes

> **Correct Answer**: **B**  
> **Explanation**: A Flow Final (`⊗`) terminates only its specific branch without affecting concurrent branches. An Activity Final (`⊙`) stops the entire activity and destroys all active tokens.

---

## Q3. Where is the condition of a decision node written?

- [ ] A) Inside the diamond
- [x] B) On the outgoing edges as guards in square brackets
- [ ] C) On the incoming edge
- [ ] D) In a note attached to the diamond

> **Correct Answer**: **B**  
> **Explanation**: In UML, diamond decision nodes contain no text; branch conditions are written as boolean guards in brackets `[guard]` on outgoing edges.

---

## Q4. A merge node…

- [ ] A) waits for a token on every incoming edge
- [x] B) passes any arriving token straight on without synchronising
- [ ] C) duplicates the token on every outgoing edge
- [ ] D) is drawn as a thick bar

> **Correct Answer**: **B**  
> **Explanation**: A merge node combines alternate incoming paths and immediately releases any token that arrives without synchronization.

---

## Q5. An action with two incoming control flow edges, where only one path is ever taken,…

- [ ] A) runs as soon as either token arrives
- [x] B) is an implicit join and never runs
- [ ] C) runs twice
- [ ] D) is a syntax error in UML

> **Correct Answer**: **B**  
> **Explanation**: Multiple edges entering an action form an implicit join, requiring tokens on *all* incoming edges. If only one path produces a token, the action deadlocks and never executes.

---

## Q6. Guards on one decision node must be…

- [x] A) complete and mutually exclusive
- [ ] B) written in natural language only
- [ ] C) at most two
- [ ] D) ordered alphabetically

> **Correct Answer**: **A**  
> **Explanation**: Guards must cover all possible inputs (complete) without overlap (mutually exclusive) to avoid deadlock or ambiguous non-deterministic routing.

---

## Q7. Which Java construct corresponds to a fork followed by a join?

- [ ] A) `if / else`
- [x] B) `CompletableFuture.allOf` or a `StructuredTaskScope`
- [ ] C) a `for` loop
- [ ] D) `try / finally`

> **Correct Answer**: **B**  
> **Explanation**: A fork initiates concurrent parallel execution; a join waits for all parallel tasks to finish before proceeding (`CompletableFuture.allOf`).

---

## Q8. What does a swimlane (activity partition) express?

- [ ] A) The time at which an action runs
- [x] B) Who or what is responsible for the actions inside it
- [ ] C) The exception type of a handler
- [ ] D) The loop condition

> **Correct Answer**: **B**  
> **Explanation**: Partitions/swimlanes group actions according to the entity, organizational department, or architectural subsystem that performs them.

---

## Q9. What happens when the accept event inside an interruptible region fires?

- [ ] A) Nothing until the region finishes
- [x] B) All tokens inside the region are destroyed and the flow continues along the interrupting edge
- [ ] C) The activity restarts from the initial node
- [ ] D) A join is executed

> **Correct Answer**: **B**  
> **Explanation**: Firing an interruptive event immediately terminates all internal tokens within the interruptible activity region and transfers control along the lightning edge.

---

## Q10. Which element maps naturally to a Spring `@Scheduled` method?

- [ ] A) An object node
- [x] B) An accept time event (hourglass)
- [ ] C) A merge node
- [ ] D) A pin

> **Correct Answer**: **B**  
> **Explanation**: In UML, an accept time event (drawn as an hourglass) generates a token when a specific time or recurring schedule triggers.

---

## Chapter 10: UML Sequence Diagrams Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 10 Quiz Preparation](C10-Sequence%20Diagrams/quiz_prep.md) or review the [Chapter 10 Study Guide](C10-Sequence%20Diagrams/study_guide.md).

## Q1. In a sequence diagram, what does the thin rectangle drawn on a lifeline represent?

- [ ] A) The class of the object
- [x] B) An activation: the period during which the object executes a method
- [ ] C) A database transaction
- [ ] D) A combined fragment

> **Correct Answer**: **B**  
> **Explanation**: Activation bars (execution specifications) depict the duration over which an object is actively executing an operation or call stack frame.

---

## Q2. Which arrow head marks an asynchronous message in UML 2.5?

- [ ] A) Filled (solid) head
- [x] B) Open (stick) head
- [ ] C) Hollow triangle
- [ ] D) Diamond

> **Correct Answer**: **B**  
> **Explanation**: Synchronous blocking calls use solid filled arrowheads (`──▶`). Asynchronous non-blocking messages use open stick arrowheads (`──>`).

---

## Q3. How is object creation shown?

- [x] A) A dashed message ending at the head box of a lifeline that starts at that point in time
- [ ] B) A large X on the lifeline
- [ ] C) A bold lifeline
- [ ] D) A note saying "new"

> **Correct Answer**: **A**  
> **Explanation**: In UML 2.5, object creation is indicated by drawing the create arrow directly targeting the lifeline's head rectangle, which is positioned down at the moment of creation.

---

## Q4. In the ECB pattern, which communication is NOT allowed?

- [ ] A) Actor to boundary
- [ ] B) Boundary to control
- [ ] C) Control to entity
- [x] D) Boundary directly to entity

> **Correct Answer**: **D**  
> **Explanation**: The Entity-Control-Boundary architectural pattern forbids boundaries (`@RestController`) from accessing entities (`@Entity`) directly, routing all logic through controls (`@Service`).

---

## Q5. Which fragment operator models "do these messages zero or one time"?

- [ ] A) `loop`
- [ ] B) `alt`
- [x] C) `opt`
- [ ] D) `par`

> **Correct Answer**: **C**  
> **Explanation**: The `opt` (optional) combined fragment executes its sub-interaction zero or one time based on its guard condition (equivalent to `if` without `else`).

---

## Q6. What must be true of the guards of an `alt` fragment?

- [ ] A) They must all be the same expression
- [x] B) They must be exhaustive and mutually exclusive
- [ ] C) They must reference the actor
- [ ] D) They must be numbers

> **Correct Answer**: **B**  
> **Explanation**: An `alt` fragment models mutually exclusive alternatives (`if / else if / else`); guards must not overlap and must account for all conditions.

---

## Q7. A payment provider calls our webhook minutes after we sent it an async request. How should the webhook call be drawn?

- [ ] A) As the dashed reply of the original async message
- [x] B) As a new message from the provider to a boundary, with its own activation
- [ ] C) As a self-call on PaymentGateway
- [ ] D) It should not appear

> **Correct Answer**: **B**  
> **Explanation**: A webhook is a separate incoming HTTP request arriving asynchronously later, represented as a new message from the external actor to our boundary.

---

## Q8. Which Mockito feature lets a test verify that mocked collaborators were called in the order shown in the diagram?

- [ ] A) `@Spy`
- [ ] B) `ArgumentCaptor`
- [x] C) `InOrder`
- [ ] D) `@MockitoBean`

> **Correct Answer**: **C**  
> **Explanation**: Mockito's `inOrder.verify(...)` asserts that method invocations occurred in the exact sequential order defined in the sequence diagram.

---

## Q9. An OrderService message ends in `throw OutOfStockException`. Where is the HTTP status decided?

- [ ] A) In the OrderService
- [ ] B) In the repository
- [x] C) In the `@ExceptionHandler` of a `@RestControllerAdvice`, returning a `ProblemDetail`
- [ ] D) In the browser

> **Correct Answer**: **C**  
> **Explanation**: Domain services throw exceptions without knowledge of HTTP. The Spring MVC `@ControllerAdvice` catches the exception and maps it to an HTTP status code.

---

## Q10. Which check ensures a sequence diagram is consistent with the class diagram?

- [ ] A) Every lifeline has a different colour
- [x] B) Every message is an operation of the receiver's class and the sender holds a reference to the receiver
- [ ] C) Every message has a reply
- [ ] D) There are at most three lifelines

> **Correct Answer**: **B**  
> **Explanation**: Cross-diagram consistency requires that any message dispatched to a lifeline corresponds to an existing method on that class, supported by an association or dependency in the class diagram.

---

## Chapter 11: UML Component Diagrams Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 11 Quiz Preparation](C11-Component%20Diagrams/quiz_prep.md) or review the [Chapter 11 Study Guide](C11-Component%20Diagrams/study_guide.md).

## Q1. In UML 2.5, how is a provided interface drawn on a component?

- [ ] A) A dashed arrow with an open head
- [x] B) A lollipop: small circle on a stub line (`○—`)
- [ ] C) A half-circle socket (`—(`)
- [ ] D) A small square on the border

> **Correct Answer**: **B**  
> **Explanation**: Provided interfaces use "ball" / "lollipop" notation (`○—`), while required interfaces use "socket" notation (`—)`).

---

## Q2. An assembly connector joins…

- [ ] A) two ports of the same component
- [ ] B) an artifact to the component it manifests
- [x] C) a required interface (socket) to a compatible provided interface (ball)
- [ ] D) a subsystem to an external system

> **Correct Answer**: **C**  
> **Explanation**: An assembly connector wires a client component's required interface socket into a supplier component's provided interface ball.

---

## Q3. Which JPMS declaration corresponds to a required interface that another module will implement?

- [ ] A) `exports`
- [ ] B) `opens … to`
- [x] C) `uses`
- [ ] D) `requires transitive`

> **Correct Answer**: **C**  
> **Explanation**: In Java Platform Module System (`module-info.java`), `uses ServiceInterface` declares a required interface resolved at runtime via `ServiceLoader`.

---

## Q4. In a hexagonal architecture, in which direction do all dependencies point?

- [ ] A) Downwards, from presentation to infrastructure
- [ ] B) Outwards, from the domain to the adapters
- [x] C) Into the domain: adapters depend on ports the domain declares
- [ ] D) Along the layers, left to right

> **Correct Answer**: **C**  
> **Explanation**: Hexagonal (Ports & Adapters) architecture enforces the Dependency Inversion Principle: outer adapters depend inward on core domain models and SPI ports.

---

## Q5. What is the main problem with a dashed «use» arrow from Notification straight to Order Management?

- [ ] A) It is not valid UML
- [x] B) It does not say what is used, so internals are exposed and the boundary cannot be enforced
- [ ] C) Dashed arrows may only be used for external systems
- [ ] D) It implies an asynchronous call

> **Correct Answer**: **B**  
> **Explanation**: Raw dependency arrows fail to specify explicit contracts. Components must communicate via defined interfaces to maintain encapsulation.

---

## Q6. Order Management depends on Notification and Notification depends on Order Management. The recommended fix is…

- [ ] A) merge both into one component
- [x] B) let Order Management publish an `OrderEvents` interface / event that Notification requires
- [ ] C) add a third "common" module that imports both
- [ ] D) mark the dependency as `«transitive»`

> **Correct Answer**: **B**  
> **Explanation**: Cyclic dependencies are broken via Dependency Inversion or event-driven architecture: Order Management emits events consumed by Notification.

---

## Q7. Which ArchUnit rule fails when there is a dependency cycle between component packages?

- [x] A) `slices().matching("edu.itc.shop.(*)..").should().beFreeOfCycles()`
- [ ] B) `noClasses().should().dependOnClassesThat().resideInAPackage("..web..")`
- [ ] C) `classes().should().bePublic()`
- [ ] D) `layeredArchitecture().consideringAllDependencies()`

> **Correct Answer**: **A**  
> **Explanation**: ArchUnit's `slices().should().beFreeOfCycles()` inspects package structures to guarantee that architectural dependencies form a Directed Acyclic Graph (DAG).

---

## Q8. What does "Used undeclared dependencies" from `mvn dependency:analyze` tell you?

- [ ] A) A declared dependency is never used and should be removed
- [x] B) The code uses a library that arrives only transitively, so the diagram is missing an edge
- [ ] C) A module has a cycle
- [ ] D) A test-scoped dependency leaked into main code

> **Correct Answer**: **B**  
> **Explanation**: This warning indicates that the project directly references classes from a library not explicitly listed in `pom.xml`, relying on unsafe transitive inheritance.

---

## Q9. A C4 container diagram differs from a UML component diagram mainly because it…

- [x] A) shows people and deployable containers with technology labels instead of interfaces and connectors
- [ ] B) is the same thing under another name
- [ ] C) only shows classes
- [ ] D) cannot show external systems

> **Correct Answer**: **A**  
> **Explanation**: The C4 Model Container diagram highlights runnable processes (databases, mobile apps, SPA, microservices) with explicit technology choices.

---

## Q10. In a component × responsibility matrix, a row with two ticks means…

- [ ] A) good redundancy for availability
- [x] B) the responsibility has two owners: duplicated logic or a shared table that must be resolved
- [ ] C) the component is a library
- [ ] D) the row belongs to an external system

> **Correct Answer**: **B**  
> **Explanation**: Every business responsibility must have exactly one single owner component to avoid duplicate logic and split database tables.

---

## Chapter 12: UML Deployment Diagrams Quiz

> 💡 **Prefer a shorter, standalone read?** Open the focused [Chapter 12 Quiz Preparation](C12-Deployment%20Diagrams/quiz_prep.md) or review the [Chapter 12 Study Guide](C12-Deployment%20Diagrams/study_guide.md).

## Q1. Which stereotype fits the JVM that runs shop-1.0.jar?

- [ ] A) `«device»`
- [x] B) `«executionEnvironment»`
- [ ] C) `«artifact»`
- [ ] D) `«component»`

> **Correct Answer**: **B**  
> **Explanation**: A software system offering an environment to execute other executable software (like JVM, Docker, Tomcat) is an `«executionEnvironment»`.

---

## Q2. What does a dashed «manifest» arrow connect?

- [ ] A) A node to another node
- [x] B) An artifact to the component it embodies
- [ ] C) A device to its firewall
- [ ] D) A pod to its Service

> **Correct Answer**: **B**  
> **Explanation**: `«manifest»` represents how a physical software artifact (e.g. `shop-1.0.jar`) realizes/implements a logical architectural `«component»`.

---

## Q3. A solid line between the app server and PostgreSQL is a communication path. What should its label contain?

- [ ] A) The class names involved
- [ ] B) Only the word TCP
- [x] C) The protocol and the port, e.g. `JDBC :5432`
- [ ] D) The SQL statements exchanged

> **Correct Answer**: **C**  
> **Explanation**: Communication paths represent physical network connections and should specify the protocol and network port (`JDBC :5432`, `HTTPS :443`).

---

## Q4. In UML terms, what is `application-prod.yml` together with the environment variables?

- [x] A) A deployment specification
- [ ] B) A communication path
- [ ] C) A device
- [ ] D) A manifestation

> **Correct Answer**: **A**  
> **Explanation**: A deployment specification specifies execution properties and parameters that define how an artifact runs on a node.

---

## Q5. Which rule protects the data zone in the three-zone design?

- [ ] A) The DMZ may open JDBC connections to the database
- [x] B) Only app-zone nodes may reach the database, never the DMZ or the Internet
- [ ] C) The database must be placed in the DMZ for latency
- [ ] D) The load balancer terminates JDBC

> **Correct Answer**: **B**  
> **Explanation**: In a 3-tier security architecture, databases in the Data Zone are completely isolated and reachable solely from application servers in the App Zone.

---

## Q6. In a containerized deployment, which element is the UML artifact?

- [ ] A) The running container
- [ ] B) The worker node
- [x] C) The OCI image `ghcr.io/itc/shop:1.0`
- [ ] D) The containerd daemon

> **Correct Answer**: **C**  
> **Explanation**: The immutable container image is the physical `«artifact»`; the instantiated running container is an `«executionEnvironment»`.

---

## Q7. What should the readiness probe of the shop pod include that the liveness probe must not?

- [ ] A) The JVM heap size
- [x] B) Reachability of the database and broker
- [ ] C) The Tomcat thread count
- [ ] D) The image digest

> **Correct Answer**: **B**  
> **Explanation**: Liveness probes check if the container process is alive. If database reachability is placed in the liveness probe, a database outage causes all app containers to restart cyclically, crashing the cluster. Readiness probes manage traffic routing without killing pods.

---

## Q8. Why does the chapter recommend `-XX:MaxRAMPercentage=75` instead of a fixed `-Xmx`?

- [ ] A) It makes the JVM start faster
- [x] B) It follows the container memory limit automatically
- [ ] C) It disables garbage collection
- [ ] D) It is required by Spring Boot 4

> **Correct Answer**: **B**  
> **Explanation**: `MaxRAMPercentage` configures the JVM to allocate a percentage of the Docker container's allocated cgroup memory limit, avoiding hard-coded flags.

---

## Q9. What is the correct practice for dev, test and prod artifacts?

- [ ] A) Build a separate jar per environment with baked-in settings
- [x] B) Build once and promote the same digest, varying only the deployment specification
- [ ] C) Use H2 in production for consistency
- [ ] D) Commit prod secrets into application-prod.yml

> **Correct Answer**: **B**  
> **Explanation**: Immutable infrastructure requires building the binary artifact once and promoting the identical byte-for-byte image across environments, modifying only external configuration.

---

## Q10. What does multiplicity `[2..10]` on the App server node express?

- [ ] A) Ten CPUs per server
- [x] B) The autoscaling range: at least two, at most ten instances
- [ ] C) Two ports and ten threads
- [ ] D) Ten years of support

> **Correct Answer**: **B**  
> **Explanation**: Multiplicity on nodes represents the deployment count range, matching Horizontal Pod Autoscaler (HPA) min and max replica bounds.

---

## ⚡ Rapid-Fire Exam Flashcards (50 High-Yield Facts)

1. `thread.start()` spawns a new thread; `thread.run()` executes on the caller thread.
2. In Java, thread cancellation is **cooperative** (`worker.interrupt()` sets a flag; it does NOT kill the thread).
3. `volatile` guarantees **visibility** and **ordering**; it does NOT guarantee atomicity for `count++`.
4. The 4 Coffman conditions for deadlock are: **Mutual exclusion**, **Hold and wait**, **No preemption**, **Circular wait**.
5. `CountDownLatch` cannot be reset (one-shot); `CyclicBarrier` is reusable.
6. Use **Virtual Threads** for I/O-bound blocking calls; use sized pools of **Platform Threads** for CPU-bound computation.
7. Spring's default bean scope is **`singleton`**.
8. **Constructor injection** is strongly recommended because it enforces immutability and enables POJO unit testing.
9. `@SpringBootApplication` = `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`.
10. Command-line args (`--server.port=7070`) override YAML and environment variables.
11. Calling `@Transactional` via `this.method()` bypasses the Spring AOP proxy (no transaction started).
12. JPA `@ManyToOne` defaults to **`EAGER`** (must be manually changed to **`LAZY`**).
13. JPA `@OneToMany` defaults to **`LAZY`**.
14. `mappedBy` always sits on the **inverse side**; the owning side holds the foreign key.
15. Touching a lazy collection outside an active transaction throws **`LazyInitializationException`**.
16. JPA dirty checking compares entities against their loading snapshot during **flush** (no need to call `save()`).
17. Optimistic locking uses **`@Version`**; throws `OptimisticLockException` on concurrent update.
18. To fix the N+1 problem, use **`JOIN FETCH`** or **`@EntityGraph`** (never enable Open Session in View).
19. `GET` is **safe** and **idempotent**; `PUT` and `DELETE` are **idempotent** but **unsafe**; `POST` is **neither**.
20. HTTP `201 Created` must return a **`Location`** header.
21. When client `Accept` cannot be met, server returns **`406 Not Acceptable`**.
22. When server cannot parse client `Content-Type`, it returns **`415 Unsupported Media Type`**.
23. RFC 9457 error media type is **`application/problem+json`**.
24. Conditional caching: Client sends `If-None-Match: "tag"`; server returns **`304 Not Modified`**.
25. **Authentication** is *"Who are you?"*; **Authorization** is *"What may you do?"*.
26. HTTP `401` = Unauthenticated; HTTP `403` = Forbidden (Authenticated but lacking roles).
27. Passwords must use slow, salted hashes (**`BCrypt`**), never fast algorithms like MD5 or SHA-256.
28. JWT payload is **not encrypted**; it is Base64URL-encoded (anyone can decode and read claims).
29. CSRF protection is safely disabled for stateless APIs using Bearer JWT tokens.
30. The Test Pyramid has **many fast Unit tests**, fewer Integration/Slice tests, and very few E2E tests.
31. In JUnit Jupiter, `@BeforeAll` must be `static` under the default per-method lifecycle.
32. `assertAll()` reports all failure assertions together; standard assertions stop on first failure.
33. Mockito `@Spy` calls real methods unless stubbed; `@Mock` returns dummy defaults.
34. `@WebMvcTest` tests only web controllers; use `@MockitoBean` for services.
35. `@DataJpaTest` tests roll back transactions automatically after each test.
36. **Testcontainers** spins up real Docker containers (e.g. PostgreSQL) directly inside JUnit tests.
37. UML is a standard modeling language by the **OMG** (Structure vs Behavior diagrams).
38. Primary actors initiate the use case (placed on **left**); Supporting actors provide external services (placed on **right**).
39. `«include»` is mandatory/unconditional (Base ➔ Included); `«extend»` is optional/conditional (Extension ➔ Base).
40. Use case names must be **Active Verb + Business Noun** at the user goal level (`Place order`).
41. Visibility symbols: `+` (public), `-` (private), `#` (protected), `~` (package-private).
42. **Composition (`◆`)**: Part cannot exist without the Whole (`Order *-- OrderLine`).
43. **Aggregation (`◇`)**: Part can exist independently of the Whole (`Team o-- Player`).
44. Activity diagrams use **token flow semantics** (Petri nets).
45. In Activity diagrams, Decision diamond branches must be **mutually exclusive** and **complete**.
46. Multiple edges entering an action without a merge form an **implicit join** (waits for all edges).
47. Sequence diagrams: Filled head (`──▶`) is **synchronous**; open head (`──>`) is **asynchronous**.
48. In ECB pattern, **Boundary cannot talk directly to Entity** (must route via Control).
49. Component diagrams: Provided interface = **Lollipop (`○—`)**; Required interface = **Socket (`—)`)**.
50. Deployment diagrams: JVM/Docker is **`«executionEnvironment»`**; Host/VM is **`«device»`**; `.jar`/Image is **`«artifact»`**.

---

*Good luck on your Software Engineering quiz and exams!*
