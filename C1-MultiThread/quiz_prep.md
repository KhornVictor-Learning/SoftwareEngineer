# Chapter 01: Multithreading in Java Quiz

> 📍 **Software Engineering (I4-GIC-S1)** — Department of ICE (GIC), ITC / Techno  
> 📄 **Lecture Slides**: [`Lesson.pdf`](Lesson.pdf)  
> 📘 **Chapter Study Guide**: [`study_guide.md`](study_guide.md)  
> 🧭 **Navigation**: [📖 Syllabus](../readme.md) | [📝 Master Quiz Prep](../quiz_prep.md) | [Chapter 02 Quiz ➡️](../C2-Spring%20Framework/quiz_prep.md)

---

## Q1. Which call actually creates a new thread of execution?

- [ ] A) `thread.run()`
- [x] B) `thread.start()`
- [ ] C) `thread.join()`
- [ ] D) `Thread.yield()`

> **Correct Answer**: **B**  
> **Explanation**: `thread.start()` requests a new execution thread from the OS/JVM and invokes `run()` asynchronously on that new stack. Calling `thread.run()` simply executes the method synchronously on the *current* thread without spawning a new thread.  
> **Trap Alert**: Calling `run()` is a classic beginner mistake that compiles fine but performs sequential execution.

---

## Q2. A thread that is waiting to enter a synchronized block whose monitor is held by another thread is in state…

- [ ] A) `WAITING`
- [ ] B) `TIMED_WAITING`
- [x] C) `BLOCKED`
- [ ] D) `RUNNABLE`

> **Correct Answer**: **C**  
> **Explanation**: When a thread attempts to acquire an intrinsic monitor lock held by another thread, the JVM places it into the `BLOCKED` state until the monitor is released. `WAITING` is for `wait()` or `join()`.

---

## Q3. What does the `volatile` keyword guarantee?

- [ ] A) Atomicity of `x++`
- [x] B) Visibility and ordering of reads/writes of that field
- [ ] C) Mutual exclusion
- [ ] D) That the field is never cached in the CPU

> **Correct Answer**: **B**  
> **Explanation**: `volatile` guarantees that any write to the field is immediately visible to other threads and prevents instruction reordering (happens-before relationship). It does NOT provide mutual exclusion and does NOT make compound operations like `x++` atomic.

---

## Q4. Which is NOT one of the four Coffman conditions required for deadlock?

- [ ] A) Mutual exclusion
- [ ] B) Hold and wait
- [x] C) Preemption
- [ ] D) Circular wait

> **Correct Answer**: **C**  
> **Explanation**: The Coffman condition is **No Preemption** (resources cannot be forcibly taken from a thread). If preemption were allowed, deadlock would be broken.

---

## Q5. `Object.wait()` must be called…

- [ ] A) From any thread at any time
- [ ] B) Only from the main thread
- [x] C) While holding the monitor of that object (inside `synchronized`)
- [ ] D) Only on `Thread` objects

> **Correct Answer**: **C**  
> **Explanation**: Calling `wait()`, `notify()`, or `notifyAll()` without holding the target object's monitor lock throws `IllegalMonitorStateException`.

---

## Q6. What is the default priority of a new Java thread?

- [ ] A) 1 (`MIN_PRIORITY`)
- [x] B) 5 (`NORM_PRIORITY`)
- [ ] C) 10 (`MAX_PRIORITY`)
- [ ] D) It inherits the OS default, unknown to Java

> **Correct Answer**: **B**  
> **Explanation**: Java thread priorities range from 1 to 10; default priority is constant 5 (`Thread.NORM_PRIORITY`).

---

## Q7. You call `worker.interrupt()` on a thread that is busy computing and never checks the flag or blocks. What happens?

- [ ] A) It stops immediately
- [ ] B) `InterruptedException` is thrown in the worker
- [x] C) Only its interrupted flag is set; it keeps running
- [ ] D) The JVM kills it after a timeout

> **Correct Answer**: **C**  
> **Explanation**: Thread cancellation in Java is purely cooperative. `interrupt()` sets the interrupt status flag. If the thread is executing CPU loops and never checks `isInterrupted()` or calls blocking methods (`sleep`, `wait`), it will continue running indefinitely.

---

## Q8. Why is `ConcurrentHashMap` preferred over `Hashtable` or `Collections.synchronizedMap`?

- [ ] A) It is immutable
- [ ] B) It allows null keys
- [x] C) Fine-grained locking and non-blocking reads give much better concurrency, plus atomic compute/merge
- [ ] D) It preserves insertion order

> **Correct Answer**: **C**  
> **Explanation**: `Hashtable` and `synchronizedMap` lock the entire table on every read/write. `ConcurrentHashMap` uses lock-free volatile reads and per-bucket / per-node locks for writes, enabling high concurrent throughput.

---

## Q9. `Executors.newVirtualThreadPerTaskExecutor()` is the best fit for…

- [ ] A) CPU-bound number crunching
- [x] B) Thousands of tasks that mostly block on I/O
- [ ] C) Tasks that must run in a strict sequence
- [ ] D) Periodic scheduling

> **Correct Answer**: **B**  
> **Explanation**: Virtual threads excel when tasks spend most of their lifetime blocked on network or disk I/O, allowing the carrier platform thread to execute other virtual threads.

---

## Q10. Which synchronizer can be reused after it has released the waiting threads?

- [ ] A) `CountDownLatch`
- [x] B) `CyclicBarrier`
- [ ] C) Neither
- [ ] D) Both

> **Correct Answer**: **B**  
> **Explanation**: A `CountDownLatch` is a one-shot gate: once its count hits 0, it cannot be reset. A `CyclicBarrier` automatically resets to its party count and can be cycled repeatedly.

---

## ⚡ High-Yield Exam Flashcards for Chapter 01

1. `thread.start()` spawns a new thread; `thread.run()` executes on the caller thread.
2. In Java, thread cancellation is **cooperative** (`worker.interrupt()` sets a flag; it does NOT kill the thread).
3. `volatile` guarantees **visibility** and **ordering**; it does NOT guarantee atomicity for `count++`.
4. The 4 Coffman conditions for deadlock are: **Mutual exclusion**, **Hold and wait**, **No preemption**, **Circular wait**.
5. `CountDownLatch` cannot be reset (one-shot); `CyclicBarrier` is reusable.
6. Use **Virtual Threads** for I/O-bound blocking calls; use sized pools of **Platform Threads** for CPU-bound computation.

---

## 🎯 Study Navigation

- 📘 Review chapter concepts: **[Chapter 01 Study Guide](study_guide.md)**
- 📄 Lecture slides: **[Lesson.pdf](Lesson.pdf)**
- 🏠 Main course overview: **[Course Syllabus (`readme.md`)](../readme.md)**
- 📝 Master Quiz Collection: **[All 12 Chapters Quiz Prep](../quiz_prep.md)**
