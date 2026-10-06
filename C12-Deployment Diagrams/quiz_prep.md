# Chapter 12: UML Deployment Diagrams Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [⬅️ Chapter 11 Quiz](../C11-Component%20Diagrams/quiz_prep.md) | [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md)

---

#### Q1. Which stereotype fits the JVM that runs shop-1.0.jar?
- [ ] A) `«device»`
- [x] B) `«executionEnvironment»`
- [ ] C) `«artifact»`
- [ ] D) `«component»`
> **Correct Answer**: **B**  
> **Explanation**: A software system offering an environment to execute other executable software (like JVM, Docker, Tomcat) is an `«executionEnvironment»`.

---

#### Q2. What does a dashed «manifest» arrow connect?
- [ ] A) A node to another node
- [x] B) An artifact to the component it embodies
- [ ] C) A device to its firewall
- [ ] D) A pod to its Service
> **Correct Answer**: **B**  
> **Explanation**: `«manifest»` represents how a physical software artifact (e.g. `shop-1.0.jar`) realizes/implements a logical architectural `«component»`.

---

#### Q3. A solid line between the app server and PostgreSQL is a communication path. What should its label contain?
- [ ] A) The class names involved
- [ ] B) Only the word TCP
- [x] C) The protocol and the port, e.g. `JDBC :5432`
- [ ] D) The SQL statements exchanged
> **Correct Answer**: **C**  
> **Explanation**: Communication paths represent physical network connections and should specify the protocol and network port (`JDBC :5432`, `HTTPS :443`).

---

#### Q4. In UML terms, what is `application-prod.yml` together with the environment variables?
- [x] A) A deployment specification
- [ ] B) A communication path
- [ ] C) A device
- [ ] D) A manifestation
> **Correct Answer**: **A**  
> **Explanation**: A deployment specification specifies execution properties and parameters that define how an artifact runs on a node.

---

#### Q5. Which rule protects the data zone in the three-zone design?
- [ ] A) The DMZ may open JDBC connections to the database
- [x] B) Only app-zone nodes may reach the database, never the DMZ or the Internet
- [ ] C) The database must be placed in the DMZ for latency
- [ ] D) The load balancer terminates JDBC
> **Correct Answer**: **B**  
> **Explanation**: In a 3-tier security architecture, databases in the Data Zone are completely isolated and reachable solely from application servers in the App Zone.

---

#### Q6. In a containerized deployment, which element is the UML artifact?
- [ ] A) The running container
- [ ] B) The worker node
- [x] C) The OCI image `ghcr.io/itc/shop:1.0`
- [ ] D) The containerd daemon
> **Correct Answer**: **C**  
> **Explanation**: The immutable container image is the physical `«artifact»`; the instantiated running container is an `«executionEnvironment»`.

---

#### Q7. What should the readiness probe of the shop pod include that the liveness probe must not?
- [ ] A) The JVM heap size
- [x] B) Reachability of the database and broker
- [ ] C) The Tomcat thread count
- [ ] D) The image digest
> **Correct Answer**: **B**  
> **Explanation**: Liveness probes check if the container process is alive. If database reachability is placed in the liveness probe, a database outage causes all app containers to restart cyclically, crashing the cluster. Readiness probes manage traffic routing without killing pods.

---

#### Q8. Why does the chapter recommend `-XX:MaxRAMPercentage=75` instead of a fixed `-Xmx`?
- [ ] A) It makes the JVM start faster
- [x] B) It follows the container memory limit automatically
- [ ] C) It disables garbage collection
- [ ] D) It is required by Spring Boot 4
> **Correct Answer**: **B**  
> **Explanation**: `MaxRAMPercentage` configures the JVM to allocate a percentage of the Docker container's allocated cgroup memory limit, avoiding hard-coded flags.

---

#### Q9. What is the correct practice for dev, test and prod artifacts?
- [ ] A) Build a separate jar per environment with baked-in settings
- [x] B) Build once and promote the same digest, varying only the deployment specification
- [ ] C) Use H2 in production for consistency
- [ ] D) Commit prod secrets into application-prod.yml
> **Correct Answer**: **B**  
> **Explanation**: Immutable infrastructure requires building the binary artifact once and promoting the identical byte-for-byte image across environments, modifying only external configuration.

---

#### Q10. What does multiplicity `[2..10]` on the App server node express?
- [ ] A) Ten CPUs per server
- [x] B) The autoscaling range: at least two, at most ten instances
- [ ] C) Two ports and ten threads
- [ ] D) Ten years of support
> **Correct Answer**: **B**  
> **Explanation**: Multiplicity on nodes represents the deployment count range, matching Horizontal Pod Autoscaler (HPA) min and max replica bounds.

---

## ⚡ High-Yield Exam Flashcards for Chapter 12

50. Deployment diagrams: JVM/Docker is **`«executionEnvironment»`**; Host/VM is **`«device»`**; `.jar`/Image is **`«artifact»`**.

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 12 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
