# Chapter 05: Security in Java Web Applications (Spring Security & JWT)

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C5-Security in Java Web Applications (Spring Security, JWT)`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **Core Security Axioms**:
   - Authentication ("Who are you?"): Credential verification.
   - Authorization ("What are you permitted to do?"): Access control.
   - Defense in depth: Protection against injection, forged requests, and data leakage.
2. **Spring Security Architecture**:
   - The servlet filter pipeline: `DelegatingFilterProxy` delegating to `FilterChainProxy` and configured `SecurityFilterChain` beans.
   - `SecurityContextHolder` holding the `SecurityContext` on a `ThreadLocal` per request.
   - The `Authentication` token: `Principal` (user identity), `Credentials` (wiped after login), and `Authorities` (granted permissions).
3. **Password Hashing & Credential Storage**:
   - Never store cleartext passwords.
   - Salted, slow key-derivation algorithms with configurable work factors (`BCryptPasswordEncoder`, Argon2).
   - Implementing `UserDetailsService` and `UserDetails` backed by Spring Data JPA.
4. **Authorization & Method Security**:
   - Roles (`ROLE_ADMIN`, `ROLE_CUSTOMER`) vs granular Authorities (`order:cancel`).
   - Hierarchical roles configured via `RoleHierarchy`.
   - Declarative method security via `@PreAuthorize("hasRole('ADMIN')")`, `@PostAuthorize`, and SpEL.
5. **Stateful vs Stateless Authentication**:
   - Session-based security: HTTP-only session cookies (`JSESSIONID`), server-side session memory, `SessionCreationPolicy.IF_REQUIRED`.
   - Stateless security: `SessionCreationPolicy.STATELESS`, eliminating session state for REST APIs.
6. **JSON Web Tokens (JWT) Deep Dive**:
   - JWT structure: Three Base64URL-encoded parts separated by dots (`Header.Payload.Signature`).
   - Standard claims (`sub`, `iss`, `exp`, `iat`) and custom role claims.
   - Cryptographic signing: Symmetric HMAC-SHA256 (`HS256`) with a shared secret vs Asymmetric RSA/ECDSA (`RS256`) using public/private key pairs.
   - Token authentication pipeline: Custom filter or `BearerTokenAuthenticationFilter` (Nimbus JOSE) extracting tokens, verifying signatures/expiry, and populating `SecurityContext`.
7. **Web Exploits & Defenses**:
   - Cross-Site Request Forgery (CSRF): Browser cookie auto-submission exploit; mitigated via CSRF tokens or disabled for purely stateless JWT-authenticated APIs.
   - Cross-Origin Resource Sharing (CORS): Preflight `OPTIONS` requests, configuring allowed origins, headers, and HTTP methods.
   - Clickjacking & Browser Security Headers: Enforcing `X-Frame-Options: DENY`, Content Security Policy (CSP), `X-Content-Type-Options: nosniff`, and `Strict-Transport-Security` (HSTS).
   - SQL Injection & XSS: Parameterized queries in JPA/JDBC, input validation via `@Valid`, and HTML output escaping.
8. **Secrets Management & Security Auditing**:
   - Externalizing sensitive keys (`JWT_SECRET`, database passwords) using environment variables, HashiCorp Vault, or Kubernetes Secrets (never committed to Git).
   - Security auditing: Logging authentication failures, role violations, and administrative actions; strictly redacting passwords, session tokens, and credit card numbers from logs.
9. **Testing Security**: Automated test support via `spring-security-test`, `@WithMockUser`, `@WithUserDetails`, and `SecurityMockMvcRequestPostProcessors.jwt()`.
10. **OWASP Top 10 (2021) Mapping**: Direct mapping of Broken Access Control (A01), Cryptographic Failures (A02), and Injection (A03) to Spring Security configurations.
11. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions covering HTTP 401 vs 403, BCrypt, JWT structure, and CORS/CSRF configurations.
    - **Lab-05**: 5 security configuration tasks + 1 JWT refresh token rotation challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 04: C4-RESTful Web Services (JAX-RS)](../C4-RESTful%20Web%20Services%20%28JAX-RS%29/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**
- ➡️ **Next Module**: [Chapter 06: C6-Testing in Java Web Applications (JUnit, Mockito)](../C6-Testing%20in%20Java%20Web%20Applications%20%28JUnit%2C%20Mockito%29/README.md)

