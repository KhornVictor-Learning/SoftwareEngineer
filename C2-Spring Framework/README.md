# Chapter 02: Spring Framework & Core Ecosystem

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C2-Spring Framework`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **Spring Philosophy & History**: Evolution from heavyweight J2EE EJB containers (2003, Rod Johnson) to lightweight POJO programming wired by an Inversion of Control container.
2. **Build Systems (Maven vs Gradle 9)**: Declarative XML dependency graphs versus expressive Groovy/Kotlin DSLs with build caching and daemon processes.
3. **Spring Boot Architecture**:
   - Starter dependencies (e.g., `spring-boot-starter-webmvc`).
   - Bill of Materials (BOM) and parent POM dependency version management.
   - The executable "fat JAR" produced by `spring-boot-maven-plugin`.
4. **Pre-Spring Web Foundations**: Servlets (Tomcat 11 / Servlet 6.1 container), request dispatching, JSP syntax, Expression Language (`${expr}`), and JSTL tags.
5. **Database Connectivity Evolution**:
   - Raw JDBC boilerplate: `Connection`, `PreparedStatement`, `ResultSet`, connection pooling via HikariCP.
   - Spring JDBC abstractions: `JdbcTemplate` and fluent `JdbcClient`, custom `RowMapper`, and unchecked `DataAccessException` translation.
6. **Inversion of Control (IoC) & Dependency Injection (DI)**:
   - Eliminating direct object instantiation (`new`) in favor of container-managed lifecycle.
   - Comparison of injection styles: Field injection (`@Autowired` on private fields — discouraged), Setter injection (optional dependencies), and Constructor injection (strongly recommended: enforces immutability and testability).
7. **Bean Configuration & Lifecycle**:
   - Stereotype annotations: `@Component`, `@Service`, `@Repository`, `@Controller`, `@RestController`.
   - Explicit configuration classes using `@Configuration` and `@Bean` methods.
   - Bean scopes (`singleton` [default], `prototype`, `request`, `session`).
   - Lifecycle callbacks: `@PostConstruct` and `@PreDestroy`.
8. **Auto-Configuration & Profiles**:
   - `@SpringBootApplication` combining `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
   - Externalized configuration via `application.properties` / `application.yml` and hierarchical override rules.
   - Environment profiling via `@Profile` and `application-{profile}.yml`.
9. **Spring Web MVC**:
   - Front Controller architecture centered on `DispatcherServlet` and `HandlerMapping`.
   - Endpoint annotations: `@GetMapping`, `@PostMapping`, `@PathVariable`, `@RequestParam`, `@RequestBody`, `@ResponseStatus`.
   - Jakarta Validation (`@Valid`, `@NotNull`, `@Size`, `@Email`) and standardized RFC 9457 / RFC 7807 `ProblemDetail` responses.
10. **Declarative Services & Spring AOP**:
    - Declarative transaction demarcation via `@Transactional` and dynamic proxy generation.
    - Aspect-Oriented Programming (AOP) for cross-cutting concerns (logging, timing, security).
11. **Production Operations**:
    - Spring Boot Actuator health endpoints (`/actuator/health`, `/actuator/info`, `/actuator/metrics`).
    - Standard layered architecture: Controller ➔ Service ➔ Repository ➔ Database.
12. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions covering IoC, injection styles, bean scopes, and transaction proxies.
    - **Lab-02**: 5 implementation tasks + 1 custom AOP timing challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 01: C1-MultiThread](../C1-MultiThread/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 03: C3-Hibernate Framework and Spring Data JPA](../C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/README.md)

