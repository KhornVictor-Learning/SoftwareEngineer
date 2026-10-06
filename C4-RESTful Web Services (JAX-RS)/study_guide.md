# Chapter 04: RESTful Web Services (Jakarta REST & Jersey) — Study Guide

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📝 **Quiz Practice**: [`quiz_prep.md`](quiz_prep.md)  
> 🧭 **Navigation**: [⬅️ Chapter 03](../C3-Hibernate%20Framework%20and%20Spring%20Data%20JPA/study_guide.md) | [📖 Syllabus](../readme.md) | [📚 Global Study Guide](../study_guide.md) | [Chapter 05 ➡️](../C5-Security%20in%20Java%20Web%20Applications%20%28Spring%20Security%2C%20JWT%29/study_guide.md)

---

## 1. Why This Matters
REST (Representational State Transfer) is the dominant architectural style for building public web APIs and microservice communications over HTTP.

## 2. Core Mental Models & Principles
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

## 3. HTTP Status Codes Cheat Sheet
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

## 4. Jakarta REST 4.0 (JAX-RS) Annotations
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

## 5. Advanced Patterns
- **RFC 9457 Problem Details**: Standardized JSON schema for API errors (`type`, `title`, `status`, `detail`, `instance`). Handled via `ExceptionMapper<T>`.
- **Conditional GET with ETags**:
  - Server computes hash of resource representation and returns `ETag: "a1b2c3"`.
  - Next time, client sends `If-None-Match: "a1b2c3"`.
  - Server evaluates tag; if unchanged, returns `304 Not Modified` with zero response body bytes!

---

## 🎯 Next Steps & Practice

- 📝 Test your understanding with the **10 Official Slide Quiz Questions**:
  👉 **[Go to Chapter 04 Quiz Preparation (`quiz_prep.md`)](quiz_prep.md)**
- 🏠 Back to main course directory:
  👉 **[Software Engineering Repository Overview (`readme.md`)](../readme.md)**
