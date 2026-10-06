# Chapter 02: Spring Framework Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 01 Quiz](../C1-MultiThread/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 03 Quiz ➡️](../C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/quiz_prep.md)

---

#### Q1. Which injection style does the Spring team recommend for mandatory dependencies?
- [ ] A) Field injection with `@Autowired`
- [ ] B) Setter injection
- [x] C) Constructor injection
- [ ] D) Static factory lookup
> **Correct Answer**: **C**  
> **Explanation**: Constructor injection ensures mandatory dependencies cannot be null, allows fields to be `final` (immutable), and enables POJO unit testing without Spring container overhead.

---

#### Q2. What is the default scope of a Spring bean?
- [ ] A) `prototype`
- [x] B) `singleton`
- [ ] C) `request`
- [ ] D) `session`
> **Correct Answer**: **B**  
> **Explanation**: Spring creates exactly one shared bean instance per `ApplicationContext` by default (`singleton`).

---

#### Q3. `@SpringBootApplication` is a combination of…
- [ ] A) `@Controller` + `@Service` + `@Repository`
- [x] B) `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`
- [ ] C) `@Bean` + `@Import`
- [ ] D) `@RestController` + `@RequestMapping`
> **Correct Answer**: **B**  
> **Explanation**: `@SpringBootApplication` is a meta-annotation that configures bean definitions, enables convention-based auto-configuration, and triggers package component scanning.

---

#### Q4. `server.port` is 8080 in `application.yml` and 9090 in `application-prod.yml`. The app is started with `--server.port=7070` and profile `prod`. Which port is used?
- [ ] A) 8080
- [ ] B) 9090
- [x] C) 7070
- [ ] D) Start-up fails because of the conflict
> **Correct Answer**: **C**  
> **Explanation**: Command-line arguments have the highest precedence in Spring Boot's property resolution hierarchy and override profile-specific YAML files.

---

#### Q5. A `@Transactional` public method is called from another method of the same class via `this.method()`. What happens?
- [ ] A) A transaction is started as usual
- [x] B) No transaction: the call bypasses the proxy
- [ ] C) A nested transaction is created
- [ ] D) An exception is thrown
> **Correct Answer**: **B**  
> **Explanation**: Spring AOP implements `@Transactional` via dynamic proxies. Calling `this.method()` invokes the target instance directly, bypassing the proxy and its transaction interceptor.

---

#### Q6. Which annotation binds a JSON request body to a method parameter?
- [ ] A) `@RequestParam`
- [ ] B) `@ModelAttribute`
- [x] C) `@RequestBody`
- [ ] D) `@PathVariable`
> **Correct Answer**: **C**  
> **Explanation**: `@RequestBody` deserializes the HTTP request body into a Java object using HTTP message converters (Jackson).

---

#### Q7. A `@Valid @RequestBody` DTO fails validation in a `@RestController`. Without any custom handling the client receives…
- [ ] A) 500 Internal Server Error
- [x] B) 400 Bad Request
- [ ] C) 422 Unprocessable Entity
- [ ] D) 200 with an empty body
> **Correct Answer**: **B**  
> **Explanation**: Spring MVC throws `MethodArgumentNotValidException`, which by default resolves to an HTTP 400 Bad Request status.

---

#### Q8. Compared with raw JDBC, `JdbcClient` / `JdbcTemplate` do NOT do which of the following?
- [ ] A) Open and close connections
- [ ] B) Translate `SQLException` into `DataAccessException`
- [x] C) Generate the SQL for you from the record type
- [ ] D) Bind named parameters
> **Correct Answer**: **C**  
> **Explanation**: `JdbcTemplate` / `JdbcClient` is a template abstraction over JDBC, not an ORM. You must write your own SQL queries.

---

#### Q9. Which Actuator endpoint is typically used by Kubernetes liveness/readiness probes?
- [ ] A) `/actuator/env`
- [x] B) `/actuator/health`
- [ ] C) `/actuator/beans`
- [ ] D) `/actuator/loggers`
> **Correct Answer**: **B**  
> **Explanation**: Kubernetes queries `/actuator/health/liveness` and `/actuator/health/readiness` to determine container lifecycle.

---

#### Q10. What extra behaviour does `@Repository` add compared to `@Component`?
- [ ] A) Automatic transactions
- [x] B) Translation of persistence exceptions into Spring's `DataAccessException` hierarchy
- [ ] C) Connection pooling
- [ ] D) JSON serialisation
> **Correct Answer**: **B**  
> **Explanation**: `@Repository` enables automatic exception translation via Spring's `PersistenceExceptionTranslationPostProcessor`.

---

## ⚡ High-Yield Exam Flashcards for Chapter 02

7. Spring's default bean scope is **`singleton`**.
8. **Constructor injection** is strongly recommended because it enforces immutability and enables POJO unit testing.
9. `@SpringBootApplication` = `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`.
10. Command-line args (`--server.port=7070`) override YAML and environment variables.
11. Calling `@Transactional` via `this.method()` bypasses the Spring AOP proxy (no transaction started).

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 02 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
