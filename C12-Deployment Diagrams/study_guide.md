# Chapter 12: UML Deployment Diagrams & Infrastructure Topology — Study Guide

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📝 **Quiz Practice**: [`quiz_prep.md`](quiz_prep.md)  
> 🧭 **Navigation**: [⬅️ Chapter 11](../C11-Component%20Diagrams/study_guide.md) | [📖 Syllabus](../readme.md) | [📚 Global Study Guide](../study_guide.md)

---

## 1. Why This Matters
Answers: *"Where does the software actually execute, and how do physical nodes talk across the network?"*

## 2. Core Elements & Stereotypes
- **Nodes (3D Cubes)**:
  - **`«device»`**: Physical hardware, bare metal server, or VM (e.g. `App Server VM`, `Load Balancer`).
  - **`«executionEnvironment»`**: Software environment executing code (e.g. `JVM 25`, `Docker Engine`, `Tomcat 11`, `PostgreSQL 17`).
- **Artifact (`«artifact»`)**: Physical file embodying software (`shop-1.0.jar`, Docker OCI image).
- **Communication Path**: Solid line between nodes showing network protocol and port (e.g., `HTTPS :443 [TLS 1.3]`, `JDBC :5432`).
- **Deployment Specification**: Text box or YAML file attached to an artifact listing runtime parameters (`application-prod.yml`, `-XX:MaxRAMPercentage=75`).

## 3. Modern Cloud & Kubernetes Mapping
- Kubernetes Worker Node ➔ `«device»`.
- Kubernetes Pod / Container ➔ `«executionEnvironment»`.
- Docker Image ➔ `«artifact»`.
- **Three-Zone Security Architecture**:
  - **DMZ**: Public load balancer (Nginx terminating TLS 443).
  - **App Zone**: Private subnet running Spring Boot application pods.
  - **Data Zone**: Isolated subnet hosting PostgreSQL and Redis. Only nodes in the App Zone may connect to the database!

## 🚀 UML to Code & Testing Quick Reference

| UML 2.5 Element | Diagram | Java / Spring Construct | Testing Equivalent |
| :--- | :--- | :--- | :--- |
| **`«executionEnvironment»`** | Deployment| `JVM 25`, Docker, Tomcat 11 | Testcontainers / Docker |
| **`«artifact»`** | Deployment| `shop-1.0.jar` or OCI Image | Container smoke test |
| **Deployment Spec** | Deployment| `application-prod.yml` | Environment config test |


---

## 🎯 Next Steps & Practice

- 📝 Test your understanding with the **10 Official Slide Quiz Questions**:
  👉 **[Go to Chapter 12 Quiz Preparation (`quiz_prep.md`)](quiz_prep.md)**
- 🏠 Back to main course directory:
  👉 **[Software Engineering Repository Overview (`readme.md`)](../readme.md)**
