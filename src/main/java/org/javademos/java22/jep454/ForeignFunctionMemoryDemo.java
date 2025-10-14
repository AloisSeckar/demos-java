package org.javademos.java22.jep454;

import org.javademos.commons.IDemo;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.invoke.MethodHandle;

/// Demo for JDK 22 feature **JEP 454 - Foreign Function & Memory API**.
///
/// JEP history:
/// - JDK 22: [JEP 454 - Foreign Function & Memory API](https://openjdk.org/jeps/454)
/// - JDK 21: [JEP 442 - Foreign Function & Memory API (Third Preview)](https://openjdk.org/jeps/442)
/// - JDK 20: [JEP 434 - Foreign Function & Memory API (Second Preview)](https://openjdk.org/jeps/434)
/// - JDK 19: [JEP 424 - Foreign Function & Memory API (Preview)](https://openjdk.org/jeps/424)
/// - JDK 18: [JEP 419 - Foreign Function & Memory API (Second Incubator)](https://openjdk.org/jeps/419)
/// - JDK 17: [JEP 412 - Foreign Function & Memory API (Incubator)](https://openjdk.org/jeps/412)
/// - JDK 16: [JEP 393 - Foreign-Memory Access API (Third Incubator)](https://openjdk.org/jeps/393)
/// - JDK 16: [JEP 389 - Foreign Linker API (Incubator)](https://openjdk.org/jeps/389)
/// - JDK 15: [JEP 383 - Foreign-Memory Access API (Second Incubator)](https://openjdk.org/jeps/383)
/// - JDK 14: [JEP 370 - Foreign-Memory Access API (Incubator)](https://openjdk.org/jeps/370)
///
/// Further reading:
/// - [Inside Java: Foreign Function & Memory API](https://inside.java/2024/02/foreign-function-memory-api/)
/// - [Baeldung: Guide to Foreign Function & Memory API](https://www.baeldung.com/java-foreign-function-memory-api)
///
/// @author kishansingh956196@example.com
public class ForeignFunctionMemoryDemo implements IDemo {
    @Override
    public void demo() {
        info(454);
        // Demo: Call C standard library 'strlen' using Foreign Function & Memory API
        try (Arena arena = Arena.ofConfined()) {
            String str = "Hello, JEP 454!";
            byte[] utf8Bytes = (str + "\0").getBytes(java.nio.charset.StandardCharsets.UTF_8);
            MemorySegment cStr = arena.allocate(utf8Bytes.length, 1);
            cStr.asByteBuffer().put(utf8Bytes);
            SymbolLookup stdlib = SymbolLookup.libraryLookup("c", arena);
            Linker linker = Linker.nativeLinker();
            MethodHandle strlen = linker.downcallHandle(
                stdlib.find("strlen").get(),
                FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
            );
            long len = (long) strlen.invoke(cStr.address());
            System.out.printf("C strlen('%s') = %d\n", str, len);
        } catch (Throwable t) {
            System.out.println("Foreign Function demo failed: " + t);
        }
    }
}
