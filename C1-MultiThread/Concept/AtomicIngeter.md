`AtomicInteger` is a class in the `java.util.concurrent.atomic` package that provides an `int` value capable of being updated atomically (thread-safely) without using explicit locks like `synchronized`.

### Why It's Needed

In standard Java, operations like incrementing a variable (`count++`) look like a single step, but under the hood, the CPU executes three distinct operations:

1. **Read** the current value from memory.
    
2. **Modify** (add 1).
    
3. **Write** the updated value back to memory.
    

When multiple threads execute `count++` concurrently on a standard `int`, their read/write cycles can overlap, resulting in **race conditions** and lost updates.

Java

```
// Thread-unsafe counter
int count = 0;
count++; // Multiple threads calling this concurrently will lose updates
```

### How `AtomicInteger` Works

`AtomicInteger` solves this by leveraging CPU-level hardware instructions rather than traditional locks:

- **Compare-And-Swap (CAS):** Instead of acquiring a thread lock (which blocks other threads and causes context-switching overhead), `AtomicInteger` uses a low-level atomic instruction called CAS. It checks: _"Is the current value still what I expect? If yes, update it. If not, retry."_
    
- **Memory Visibility:** The internal integer value is declared as `volatile`, ensuring that any write by one thread is immediately visible to all other threads.
    

### Common Methods

|**Method**|**Equivalent Operation**|**Description**|
|---|---|---|
|`get()`|`count`|Returns the current value.|
|`set(int newValue)`|`count = newValue`|Sets to the given value.|
|`incrementAndGet()`|`++count`|Atomically increments by 1 and returns the new value.|
|`getAndIncrement()`|`count++`|Atomically increments by 1 and returns the previous value.|
|`decrementAndGet()`|`--count`|Atomically decrements by 1 and returns the new value.|
|`addAndGet(int delta)`|`count += delta`|Atomically adds the given value and returns the result.|
|`compareAndSet(int expect, int update)`|CAS check|Sets value to `update` if current value equals `expect` (returns `boolean`).|

### Quick Example

Java

```
import java.util.concurrent.atomic.AtomicInteger;

public class CounterExample {
    // Shared thread-safe counter
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1_000; i++) {
                counter.incrementAndGet(); // Thread-safe atomic increment
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.get()); // Guaranteed to be 2000
    }
}
```

### When to Use (and When Not To)

- **Use `AtomicInteger`** for high-throughput counters, sequence generators, metrics trackers, or simple lock-free algorithms.
    
- **Use `LongAdder` instead** if you have very high contention across many threads where threads frequently write but rarely read. `LongAdder` distributes increments across separate cells to minimize CPU bus contention.
    
- **Use `synchronized` or `ReentrantLock`** if you need to update multiple variables together as a single atomic transaction. `AtomicInteger` only makes updates to _its own_ value atomic.