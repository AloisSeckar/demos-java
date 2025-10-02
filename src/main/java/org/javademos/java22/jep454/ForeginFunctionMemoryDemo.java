package org.javademos.java22.jep454;

import org.javademos.commons.IDemo;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.invoke.MethodHandle;

public class ForeignFunctionMemoryDemo implements IDemo {
    @Override
    public void demo() {
        info(454);
        // Demo: Call C standard library 'strlen' using Foreign Function & Memory API
        try (Arena arena = Arena.ofConfined()) {
            String str = "Hello, JEP 454!";
            MemorySegment cStr = arena.allocateUtf8String(str);
            SymbolLookup stdlib = SymbolLookup.libraryLookup("c", arena);
            Linker linker = Linker.nativeLinker();
            MethodHandle strlen = linker.downcallHandle(
                stdlib.find("strlen").get(),
                FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
            );
            long len = (long) strlen.invoke(cStr);
            System.out.printf("C strlen('%s') = %d\n", str, len);
        } catch (Throwable t) {
            System.out.println("Foreign Function demo failed: " + t);
        }
    }
}
