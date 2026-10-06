# Chapter 04: RESTful Web Services (Jakarta REST & Jersey)

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C4-RESTful Web Services (JAX-RS)`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **REST Architectural Foundations**:
   - Architectural constraints: Uniform interface, stateless requests, cacheable responses, client-server decoupling, layered systems, code-on-demand.
   - Resource-oriented design: URIs identify nouns/resources (collections `/products`, singletons `/products/{id}`, sub-resources `/orders/{id}/lines`); HTTP methods provide the uniform verbs.
2. **HTTP Methods & Semantic Properties**:
   - `GET`: Safe, idempotent, cached retrieval.
   - `POST`: Unsafe, non-idempotent resource creation (returns `201 Created` with `Location` header).
   - `PUT`: Unsafe, idempotent complete replacement.
   - `PATCH`: Unsafe, partial resource mutation.
   - `DELETE`: Unsafe, idempotent resource removal (`204 No Content`).
3. **Jakarta REST 4.0 Annotation Model**:
   - Resource binding: `@Path`, `@GET`, `@POST`, `@PUT`, `@DELETE`.
   - Parameter extraction: `@PathParam`, `@QueryParam`, `@HeaderParam`, `@CookieParam`, `@Context` (`UriInfo`, `SecurityContext`).
   - Content negotiation: `@Consumes` and `@Produces` mapping to HTTP `Content-Type` and `Accept` headers.
4. **Serialization & Entity Binding**:
   - Marshalling/unmarshalling via Jakarta JSON Binding (JSON-B / Yasson), Jackson, and JAXB.
   - Custom `MessageBodyReader<T>` and `MessageBodyWriter<T>`.
   - Programmatic response construction using the fluent `Response.ok().entity(...).build()`.
5. **Runtime Interceptors & Filter Pipeline**:
   - `@PreMatching` container request filters (URL rewriting, early routing).
   - Post-matching `ContainerRequestFilter` (authentication, audit logging) and `ContainerResponseFilter` (CORS headers, caching).
   - Content transformation with `ReaderInterceptor` and `WriterInterceptor` (GZIP compression).
   - Scoping filter execution using custom `@NameBinding` annotations.
6. **Error Architecture & RFC 9457**:
   - Exception mapping via `@Provider public class CustomExceptionMapper implements ExceptionMapper<T>`.
   - Standardized error payloads adhering to RFC 9457 / RFC 7807 Problem Details (`type`, `title`, `status`, `detail`, `instance`).
   - Request payload validation via Jakarta Bean Validation (`@Valid`, `@NotNull`, `@Size`).
7. **Advanced Enterprise REST Patterns**:
   - HTTP Caching & Conditional Requests: `ETag` generation, validation with `If-None-Match`, and returning `304 Not Modified`.
   - Safe POST operations using custom `Idempotency-Key` headers backed by a deduplication store.
   - API versioning strategies: URI path (`/v1/`), custom request headers, or media types.
   - Pagination strategies: Offset/limit pagination with standard `Link` headers (`rel="next"`, `rel="prev"`).
   - Hypermedia as the Engine of Application State (HATEOAS) & Richardson Maturity Model (Levels 0–3).
8. **Documentation & Testing**:
   - OpenAPI 3.1 specification generation using MicroProfile OpenAPI annotations (`@Operation`, `@APIResponse`, `@Schema`).
   - Automated integration testing using `JerseyTest` and JUnit 6.
9. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions on HTTP safety/idempotency, status codes, JAX-RS filters, and ETags.
    - **Lab-04**: 5 RESTful endpoint implementation tasks + 1 ETag caching challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 03: C3-Hibernate Framework and Spring Data JPA](../C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 05: C5-Security in Java Web Applications (Spring Security, JWT)](../C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/README.md)

