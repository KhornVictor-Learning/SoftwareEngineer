# Chapter 05: Security in Java Web Applications (Spring Security & JWT) — Study Guide

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📝 **Quiz Practice**: [`quiz_prep.md`](quiz_prep.md)  
> 🧭 **Navigation**: [⬅️ Chapter 04](../C4-RESTful%20Web%20Services%20%28JAX-RS%29/study_guide.md) | [📖 Syllabus](../readme.md) | [📚 Global Study Guide](../study_guide.md) | [Chapter 06 ➡️](../C6-Testing%20in%20Java%20Web%20Applications%20%28JUnit%2C%20Mockito%29/study_guide.md)

---

## 1. Why This Matters
Every web application is exposed to malicious requests. Security must protect identities, enforce permissions, and defend against OWASP Top 10 vulnerabilities.

## 2. Core Mental Models & Definitions
- **Authentication vs Authorization**:
  - **Authentication**: *"Who are you?"* (Verifying username/password, token, or passkey).
  - **Authorization**: *"Are you allowed to do this?"* (Checking roles and permissions).
- **Spring Security Architecture**:
  - Incoming requests pass through a chain of servlet filters (`SecurityFilterChain`).
  - `SecurityContextHolder` stores the active `Authentication` on a `ThreadLocal` storage variable for the duration of the request.
  - An `Authentication` object contains: `Principal` (user details), `Credentials` (cleared after login), and `Authorities` (granted roles/permissions).

## 3. Passwords & Credential Storage
- **Golden Rule**: Never store plaintext passwords or fast hashes (MD5, SHA-256). Attackers can compute billions of SHA-256 hashes per second using GPUs.
- **Solution**: Use **salted, computationally slow key derivation functions** with configurable work factors: **`BCryptPasswordEncoder`** or Argon2.

## 4. JSON Web Tokens (JWT) Anatomy
A JWT consists of three Base64URL-encoded strings separated by dots (`Header.Payload.Signature`):

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhbGljZSIsInJvbGVzIjpbIlJPTEVfQ1VTVE9NRVIiXX0.SflKxwRJSMeKKF2QT4fwpM...
```

- **Header**: Algorithm (`HS256`, `RS256`) and token type (`JWT`).
- **Payload**: Claims (`sub` [subject/username], `iss` [issuer], `exp` [expiration timestamp], custom roles).
- **Signature**: `HMACSHA256(base64Url(header) + "." + base64Url(payload), secret)`.
- *Critical Security Warning*: The payload is **NOT ENCRYPTED**; it is merely Base64URL-encoded. Anyone holding the token can decode and read its claims! Never put passwords or secrets in a JWT payload!

## 5. Web Defenses & OWASP Top 10
- **CSRF (Cross-Site Request Forgery)**: A malicious site tricks a user's browser into sending requests to your site with their stored cookies.
  - *Stateless JWT Defense*: CSRF protection is safely disabled for stateless REST APIs because JWTs travel in the custom `Authorization: Bearer <token>` header, which browsers *never* attach automatically to cross-origin requests.
- **XSS (Cross-Site Scripting)**: Attacker injects malicious `<script>` tags into input.
  - *Defense*: HTML-encode all dynamic values before rendering to the screen (`th:text`, `c:out`, `HtmlUtils.htmlEscape()`).

---

## 🎯 Next Steps & Practice

- 📝 Test your understanding with the **10 Official Slide Quiz Questions**:
  👉 **[Go to Chapter 05 Quiz Preparation (`quiz_prep.md`)](quiz_prep.md)**
- 🏠 Back to main course directory:
  👉 **[Software Engineering Repository Overview (`readme.md`)](../readme.md)**
