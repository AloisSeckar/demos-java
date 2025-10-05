package org.javademos.java24.jep498;

import org.javademos.commons.IDemo;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/// Demo for JDK 24 feature **Warn upon Use of Memory-Access Methods in sun.misc.Unsafe** (JEP 498)
///
/// ### JEP history
/// - JDK 24: [JEP 498 - Warn upon Use of Memory-Access Methods in sun.misc.Unsafe](https://openjdk.org/jeps/498)
///
/// ### Further reading
/// - [JEP 498 - Warn upon Use of Memory-Access Methods in sun.misc.Unsafe](https://openjdk.org/jeps/498)
///
/// @see sun.misc.Unsafe
///
/// @author @adeelFeroz77

public class MemoryAccessMethods implements IDemo {

    @Override
    public void demo() {
        info(498);

        try {

            // theUnsafe is static singleton defined inside Unsafe class
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);

            // allocating some bytes
            long memoryAddress = unsafe.allocateMemory(4);
            unsafe.putInt(memoryAddress, 42);

            int value = unsafe.getInt(memoryAddress);

            System.out.println("Value read from Unsafe memory: " + value);

            unsafe.freeMemory(memoryAddress);

        } catch (Exception e) {
            System.err.println("Unsafe access failed: " + e.getMessage());
        }

    }
}
