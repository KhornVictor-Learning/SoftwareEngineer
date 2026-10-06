# Chapter 12: UML Deployment Diagrams & Infrastructure Topology

> **Module**: Software Engineering (I4-GIC-S1) — ITC / Techno  
> **Directory**: `C12-Deployment Diagrams`

---

## 📂 Quick Access & Files

| Resource | File Link | Purpose |
| :--- | :--- | :--- |
| 📄 **Lecture Slides** | [`Lesson.pdf`](Lesson.pdf) | Official course presentation slides from lecture |
| 📘 **Chapter Study Guide** | [`study_guide.md`](study_guide.md) | Focused conceptual summary, mental models, code snippets & traps |
| 📝 **Chapter Quiz & Flashcards** | [`quiz_prep.md`](quiz_prep.md) | 10 official slide quiz questions, answer keys, explanations & flashcards |

---

1. **Bridging Architecture to Infrastructure**:
   - While component diagrams answer *what* the software is built of, deployment diagrams answer *where* it executes physically and *how* nodes communicate.
2. **Core Notational Elements**:
   - **Nodes (3D Cubes)**: Computational resources.
     - `«device»`: Physical hardware machines, physical servers, client smartphones, or VMs.
     - `«executionEnvironment»`: Software environments hosting code execution (e.g., `JVM 25`, `Docker Engine`, `Tomcat 11`, `PostgreSQL 17`).
   - **Artifacts (Document Box icon)**: Physical manifestations of software components (`shop-1.0.jar`, `Dockerfile`, SQL scripts).
   - **Deployment Relationship (`«deploy»` dashed arrow)**: Direct assignment of an artifact to a target node.
   - **Communication Paths (Solid Lines)**: Network connections linking nodes, annotated with communication protocols, port numbers, and transport security (e.g., `HTTPS :443 [TLS 1.3]`, `JDBC :5432`, `AMQP :5672`).
3. **Enterprise Topologies & Network Zones**:
   - Classic Three-Tier Architecture: Presentation Tier (CDN / Reverse Proxy) ➔ Application Tier (Tomcat / Spring Boot) ➔ Data Tier (Database / Cache).
   - Network Security Zones:
     - Demilitarized Zone (DMZ): Public-facing load balancers (Nginx, AWS ALB).
     - Application Zone: Private subnet hosting application services.
     - Data Zone: Isolated database subnet protected by strict firewall rules.
4. **Modern Cloud, Container & Kubernetes Mapping**:
   - Docker Containerization: The container image is the `«artifact»`; the running container instance is an `«executionEnvironment»`.
   - Kubernetes on Deployment Diagrams:
     - Kubernetes Worker Node ➔ `«device»`.
     - Kubelet / Pod ➔ `«executionEnvironment»`.
     - Kubernetes Deployments, Services, and Ingress controllers modeled as UML nodes and routing artifacts.
5. **High Availability, Scalability & Failover**:
   - Reverse proxies and load balancers distributing traffic via `least_conn` or round-robin algorithms.
   - Stateless app servers clustered behind Nginx with externalized shared sessions in Redis.
   - Database clustering: Active primary (read-write) with automated failover and read replicas (read-only).
   - Horizontal Pod Autoscaling (HPA) governed by CPU/memory thresholds and Kubernetes liveness/readiness probes.
6. **Environment Parity & Deployment Specifications**:
   - The Golden Rule: Deploy the exact same immutable binary artifact (`shop-1.0.jar`) across Dev, Staging, and Production.
   - **Deployment Specification**: UML attached box declaring environment-specific parameters (`application-prod.yml`, JVM heap flags `-Xmx4g`, thread pool limits).
7. **Production Observability & Security Hardening**:
   - Modeling telemetry flows: Metrics export (Actuator ➔ Prometheus), distributed tracing (OpenTelemetry), and centralized logging (ELK / Loki).
   - Enforcing mutual TLS (mTLS) within cluster service meshes and restricting management endpoints.
8. **Synthesis of the Software Engineering Lifecycle**:
   - Tracing the complete development journey: from multithreaded Java foundations (Ch. 01) through Spring, JPA, REST, Security, and automated testing (Ch. 02–06) to comprehensive UML 2.5 modeling perspectives (Ch. 07–12).
9. **Hands-On Assessment**:
    - **Chapter Quiz**: 10 questions on device vs execution environment, deployment specifications, communication paths, and Kubernetes UML mappings.
    - **Lab-12**: 5 infrastructure deployment modeling tasks + 1 high-availability multi-region cluster design challenge.

---

## 🧭 Course Navigation

- ⬅️ **Previous Module**: [Chapter 11: C11-Component Diagrams](../C11-Component%20Diagrams/README.md)
- 🏠 **[Course Syllabus & Overview](../readme.md)**
- 📚 **[Full Course Study Guide](../study_guide.md)**
- 📝 **[Full Quiz Master (120 Questions)](../quiz_prep.md)**

