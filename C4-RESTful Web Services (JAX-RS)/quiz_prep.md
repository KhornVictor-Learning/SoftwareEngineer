# Chapter 04: RESTful Web Services (JAX-RS) Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 03 Quiz](../C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 05 Quiz ➡️](../C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/quiz_prep.md)

---

#### Q1. Which HTTP method is both safe and idempotent?
- [ ] A) `POST`
- [x] B) `GET`
- [ ] C) `PATCH`
- [ ] D) None of them
> **Correct Answer**: **B**  
> **Explanation**: `GET` is safe (does not alter server state) and idempotent (multiple identical requests have the exact same effect as a single request). `PUT` and `DELETE` are idempotent but unsafe. `POST` is neither.

---

#### Q2. A POST creates a new product. Which response is correct?
- [ ] A) `200 OK` with the product
- [ ] B) `204 No Content`
- [x] C) `201 Created` with a `Location` header pointing at the new resource
- [ ] D) `202 Accepted`
> **Correct Answer**: **C**  
> **Explanation**: Successful resource creation returns `201 Created` and sets the `Location` header to the URI of the newly created resource.

---

#### Q3. Which pair binds `?size=20` to a parameter and supplies 20 when it is absent?
- [ ] A) `@PathParam` + `@Context`
- [x] B) `@QueryParam` + `@DefaultValue`
- [ ] C) `@HeaderParam` + `@BeanParam`
- [ ] D) `@FormParam` + `@Produces`
> **Correct Answer**: **B**  
> **Explanation**: `@QueryParam("size")` extracts URL query string parameters, and `@DefaultValue("20")` provides the fallback.

---

#### Q4. The client sends `Accept: text/csv` but the method only has `@Produces("application/json")`. What happens?
- [ ] A) JSON is returned anyway
- [ ] B) `415 Unsupported Media Type`
- [x] C) `406 Not Acceptable`
- [ ] D) `404 Not Found`
> **Correct Answer**: **C**  
> **Explanation**: When the server cannot produce a representation matching the client's `Accept` header, HTTP specification requires returning `406 Not Acceptable`.

---

#### Q5. Which provider turns an exception into an HTTP response?
- [ ] A) `ContainerResponseFilter`
- [ ] B) `MessageBodyWriter`
- [x] C) `ExceptionMapper`
- [ ] D) `ParamConverterProvider`
> **Correct Answer**: **C**  
> **Explanation**: In Jakarta REST, implementing `ExceptionMapper<E>` allows catching application exceptions and translating them into structured HTTP `Response` objects.

---

#### Q6. A `ContainerRequestFilter` must inspect the raw URI before the resource method is chosen. Which annotation does it need?
- [x] A) `@PreMatching`
- [ ] B) `@NameBinding`
- [ ] C) `@Priority`
- [ ] D) `@Context`
> **Correct Answer**: **A**  
> **Explanation**: `@PreMatching` filters execute before URI path matching occurs, allowing URI or HTTP method rewrites.

---

#### Q7. What does `Request.evaluatePreconditions(tag)` return when the request carries a matching `If-None-Match` header?
- [ ] A) `null`
- [x] B) A `ResponseBuilder` already set to `304 Not Modified`
- [ ] C) A `ResponseBuilder` set to 412
- [ ] D) It throws `NotModifiedException`
> **Correct Answer**: **B**  
> **Explanation**: If the provided ETag matches the client's cached ETag, `evaluatePreconditions()` returns a pre-configured `304 Not Modified` response builder.

---

#### Q8. Which media type does RFC 9457 define for error bodies?
- [ ] A) `application/error+json`
- [x] B) `application/problem+json`
- [ ] C) `text/problem`
- [ ] D) `application/vnd.error`
> **Correct Answer**: **B**  
> **Explanation**: RFC 9457 / RFC 7807 defines `application/problem+json` as the standard format for reporting errors from HTTP APIs.

---

#### Q9. A method annotated with `@Path("{id}/reviews")` but with no HTTP method annotation that returns a `ReviewResource` is called a…
- [x] A) sub-resource locator
- [ ] B) name-bound filter
- [ ] C) dynamic feature
- [ ] D) entity provider
> **Correct Answer**: **A**  
> **Explanation**: In JAX-RS, a method with `@Path` but lacking `@GET`/`@POST` that returns another resource class is a **sub-resource locator**.

---

#### Q10. Which request selects version 2 of a representation through content negotiation rather than the URI?
- [ ] A) `GET /v2/products/1`
- [ ] B) `GET /products/1?v=2`
- [x] C) `GET /products/1` with `Accept: application/vnd.shop.v2+json`
- [ ] D) `GET /products/1` with `X-Api-Key: v2`
> **Correct Answer**: **C**  
> **Explanation**: Using vendor-specific media types in the `Accept` header is the canonical REST approach to content-negotiated API versioning.

---

## ⚡ High-Yield Exam Flashcards for Chapter 04

19. `GET` is **safe** and **idempotent**; `PUT` and `DELETE` are **idempotent** but **unsafe**; `POST` is **neither**.
20. HTTP `201 Created` must return a **`Location`** header.
21. When client `Accept` cannot be met, server returns **`406 Not Acceptable`**.
22. When server cannot parse client `Content-Type`, it returns **`415 Unsupported Media Type`**.
23. RFC 9457 error media type is **`application/problem+json`**.
24. Conditional caching: Client sends `If-None-Match: "tag"`; server returns **`304 Not Modified`**.

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 04 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
