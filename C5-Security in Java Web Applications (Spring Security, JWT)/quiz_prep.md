# Chapter 05: Security in Java Web Applications (JWT) Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 04 Quiz](../C4-RESTful%20Web%20Services%20%28JAX-RS%29/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 06 Quiz ➡️](../C6-Testing%20in%20Java%20Web%20Applications%20%28JUnit%2C%20Mockito%29/quiz_prep.md)

---

#### Q1. A logged-in customer calls `DELETE /api/products/7`, which requires `ROLE_ADMIN`. Which status code does Spring Security return?
- [ ] A) `400 Bad Request`
- [ ] B) `401 Unauthorized`
- [x] C) `403 Forbidden`
- [ ] D) `404 Not Found`
> **Correct Answer**: **C**  
> **Explanation**: `401 Unauthorized` means unauthenticated (identity unknown). `403 Forbidden` means authenticated, but lacking necessary authorities/roles.

---

#### Q2. Why are MD5 or plain SHA-256 unsuitable for storing passwords?
- [ ] A) They produce hashes that are too long for a VARCHAR column
- [x] B) They are fast, so billions of guesses per second can be tried offline
- [ ] C) They are not supported by Spring Security
- [ ] D) They cannot be salted
> **Correct Answer**: **B**  
> **Explanation**: MD5 and SHA-256 are general-purpose cryptographic algorithms optimized for speed. Attackers can brute-force billions of hashes per second using GPUs. Password hashing requires intentionally slow, salted algorithms like BCrypt.

---

#### Q3. What does `hasRole("ADMIN")` actually check?
- [ ] A) An authority named exactly `ADMIN`
- [x] B) An authority named `ROLE_ADMIN`
- [ ] C) A claim named `admin` in the JWT
- [ ] D) The username `admin`
> **Correct Answer**: **B**  
> **Explanation**: Spring Security automatically prefixes role checks in `hasRole()` with `ROLE_`. Checking `hasRole("ADMIN")` verifies the presence of `ROLE_ADMIN`.

---

#### Q4. Which statement about `@PreAuthorize` on a service method is correct?
- [ ] A) It works on private methods too
- [ ] B) It is evaluated only for HTTP requests
- [x] C) It is applied through a proxy, so self-invocation bypasses it
- [ ] D) It replaces the need for URL rules
> **Correct Answer**: **C**  
> **Explanation**: Like `@Transactional`, method security uses Spring AOP proxies. Calling a `@PreAuthorize` method internally via `this.method()` bypasses security interceptors.

---

#### Q5. In the filter chain, which component picks the `SecurityFilterChain` that applies to a request?
- [ ] A) `DispatcherServlet`
- [x] B) `FilterChainProxy`
- [ ] C) `AuthorizationFilter`
- [ ] D) `DelegatingFilterProxy`
> **Correct Answer**: **B**  
> **Explanation**: `DelegatingFilterProxy` is the standard servlet filter that delegates to the Spring-managed `FilterChainProxy`, which evaluates request matchers and routes to the matching `SecurityFilterChain`.

---

#### Q6. Why is CSRF protection usually disabled for a stateless JWT API?
- [ ] A) Because JWTs are encrypted
- [x] B) Because the token travels in the Authorization header, which browsers never add automatically
- [ ] C) Because `SessionCreationPolicy.STATELESS` already blocks cross-site requests
- [ ] D) Because CSRF only affects GET requests
> **Correct Answer**: **B**  
> **Explanation**: CSRF exploits the browser's automatic inclusion of session cookies on cross-origin requests. Because JWTs are stored in memory/localStorage and sent via `Authorization: Bearer`, third-party sites cannot forge requests.

---

#### Q7. A JWT payload contains `{"sub":"alice","password":"secret"}`. What is the problem?
- [ ] A) Nothing, the signature protects the payload
- [x] B) The payload is only base64url-encoded, so anyone holding the token can read it
- [ ] C) JWTs may not contain more than two claims
- [ ] D) The `sub` claim must be numeric
> **Correct Answer**: **B**  
> **Explanation**: JWTs are digitally signed, NOT encrypted. The payload is readable in plaintext by anyone by decoding Base64URL. Never include passwords or confidential keys in claims.

---

#### Q8. What happens when a client presents an expired JWT to an endpoint protected by `oauth2ResourceServer().jwt()`?
- [ ] A) The token is silently refreshed
- [x] B) `401` with `WWW-Authenticate: Bearer error="invalid_token"`
- [ ] C) `403 Forbidden`
- [ ] D) The request proceeds as anonymous with a warning
> **Correct Answer**: **B**  
> **Explanation**: Expired tokens fail signature/expiration validation, returning a `401 Unauthorized` with error details in the `WWW-Authenticate` response header.

---

#### Q9. A product review containing `<script>steal()</script>` is stored. Which measure prevents it from executing on another customer's screen?
- [ ] A) Deleting the word `script` on input
- [ ] B) Storing the review in a NoSQL database
- [x] C) HTML-encoding the text when rendering (`th:text`, `c:out`, `HtmlUtils.htmlEscape`)
- [ ] D) Using HTTPS
> **Correct Answer**: **C**  
> **Explanation**: Proper contextual HTML entity escaping (`<` becomes `&lt;`) prevents browser HTML parsers from executing injected script tags (XSS mitigation).

---

#### Q10. Where should the JWT signing secret live in a Spring Boot project?
- [ ] A) Hard-coded in `JwtConfig` so it cannot be changed by mistake
- [ ] B) In `application.yml` committed to git
- [x] C) In an environment variable or Vault, referenced as `${JWT_SECRET}`
- [ ] D) In the README so the team can find it
> **Correct Answer**: **C**  
> **Explanation**: Production secrets must never be committed to source control. They should be injected at runtime via environment variables or secret vaults.

---

## ⚡ High-Yield Exam Flashcards for Chapter 05

25. **Authentication** is *"Who are you?"*; **Authorization** is *"What may you do?"*.
26. HTTP `401` = Unauthenticated; HTTP `403` = Forbidden (Authenticated but lacking roles).
27. Passwords must use slow, salted hashes (**`BCrypt`**), never fast algorithms like MD5 or SHA-256.
28. JWT payload is **not encrypted**; it is Base64URL-encoded (anyone can decode and read claims).
29. CSRF protection is safely disabled for stateless APIs using Bearer JWT tokens.

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 05 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
