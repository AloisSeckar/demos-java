package org.javademos.java14.jep366;

import org.javademos.commons.IDemo;

import java.lang.management.*;
import java.util.ArrayList;
import java.util.List;

/// Demo for JDK 14 feature <strong>JEP 366 - Deprecate the ParallelScavenge + SerialOld GC Combination</strong>.
///
///
/// Summary:
/// Deprecate the combination of the Parallel Scavenge and Serial Old garbage collection algorithms.
///
/// Further Reading -
/// - [Official JEP 366](https://openjdk.org/jeps/366)
///
/// Additional References -
/// - [DZone - Java 14](https://dzone.com/refcardz/java-14-1)
/// - [New Features in Java 14](https://www.baeldung.com/java-14-new-features)
///
///
/// @author SanjanaMahapatra

public class ParallelScavengeGCCombinationDemo implements IDemo {
    @Override
    public void demo() {
        info(366);

        // In the oracle documentation, it states that very few people uses the pairing
        // combination of parallel young generation GC (called ParallelScavenge) and the
        // serial old GC (called SerialOld).

        // To use this feature, this has to be explicitly specified and enabled by the
        // user with usage of following command - XX:+UseParallelGC -XX:-UseParallelOldGC
        // using the command line options.

        // This combination is only useful, only when there is a need of deployment which
        // involves very large young generation and a very small old generation.

        // This involves a very rare and risky deployment, since a slight shift in liveness for objects
        // in the young generation will result in an OutOfMemoryException, since the old generation is
        // significantly smaller than the young generation.

        // Since, this is a rarely used combination of GC algorithms, and requires significant
        // maintenance effort, Java 14 have deprecated this feature.

        // Lets demonstrates one example and check in the terminal


        System.out.println("=== JEP 366: Deprecate ParallelScavenge + SerialOld GC Combination ===");

        // Example 1: Showing the deprecation warning
        System.out.println("""
        1. Running with deprecated GC combination:
        Command: java -XX:+UseParallelGC -XX:-UseParallelOldGC -version
        Expected: Deprecation warning in Java 14+
        """
        );

        // Show current GC information
        System.out.println("Demonstrating with example");

        // allocate a memory to trigger the Garbage Collection (GC)

        List<byte[]> largeMemory = new ArrayList<>(2000);
        try {
            for(int i =0; i < 100_000; i++) {
                largeMemory.add(new byte[500 * 1024 * 1024]);
                System.out.println(" === Allocated memory : " + ((i+1)*500) + " MB ===");
                Thread.sleep(50);
            }
        }catch (OutOfMemoryError err) {
            System.out.println(" === OutOfMemoryError occurred === ");
        }catch (InterruptedException err) {
            Thread.currentThread().interrupt();
        }

        printGCInfo();
    }

    private void printGCInfo() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Max Memory: " + runtime.maxMemory() / (1024 * 1024) + "MB");
        System.out.println("Total Memory: " + runtime.totalMemory() / (1024 * 1024) + "MB");
        System.out.println("Free Memory: " + runtime.freeMemory() / (1024 * 1024) + "MB");
        System.out.println("Used Memory: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024) + " MB");

        // Get GC information
        try {

            System.out.println("\n=== GARBAGE COLLECTORS ===");

            List<GarbageCollectorMXBean> gcBeans =
                    ManagementFactory.getGarbageCollectorMXBeans();

            for(GarbageCollectorMXBean gcBean : gcBeans) {
                System.out.println("GC Name: " + gcBean.getName());
                System.out.println("Collection Count: " + gcBean.getCollectionCount());
                System.out.println("Collection Time: " + gcBean.getCollectionTime());
            }

            System.out.println("\n === Memory Usage Distribution === ");

            MemoryMXBean m = ManagementFactory.getMemoryMXBean();
            for(MemoryType type: MemoryType.values()) {
                usage(type, type == MemoryType.HEAP?
                        m.getHeapMemoryUsage(): m.getNonHeapMemoryUsage());
                System.out.println();
                for(MemoryPoolMXBean mp: ManagementFactory.getMemoryPoolMXBeans())
                    if(mp.getType() == type) usage(mp.getName(), mp.getUsage());
                System.out.println();
            }

            System.out.println("\n === Memory Pools Used === ");

            List<MemoryPoolMXBean> memoryPoolMXBeanList = ManagementFactory.getMemoryPoolMXBeans();

            for(MemoryPoolMXBean poolMXBean : memoryPoolMXBeanList) {
                MemoryUsage memoryUsage = poolMXBean.getUsage();
                String name = poolMXBean.getName();

                System.out.println("Pool Name: " + name);

                System.out.printf("  - Init:   %,dMB%n", memoryUsage.getInit() / (1024 * 1024));
                System.out.printf("  - Used:   %,dMB%n", memoryUsage.getUsed() / (1024 * 1024));
                System.out.printf("  - Committed: %,dMB%n", memoryUsage.getCommitted() / (1024 * 1024));
                System.out.printf("  - Max:    %,dMB%n", memoryUsage.getMax() / (1024 * 1024));

                // Classify the pool
                if (name.contains("Eden") || name.contains("Young")) {
                    System.out.println("  - Type: Young Generation (Eden)");
                } else if (name.contains("Survivor")) {
                    System.out.println("  - Type: Young Generation (Survivor)");
                } else if (name.contains("Old") || name.contains("Tenured")) {
                    System.out.println("  - Type: Old Generation");
                } else if (name.contains("Metaspace")) {
                    System.out.println("  - Type: Metaspace");
                } else if (name.contains("Code")) {
                    System.out.println("  - Type: Code Cache");
                }

            }

            calculateGenerationTotals(memoryPoolMXBeanList);

        } catch (Exception e) {
            System.out.println("Unable to get GC details");
        }
    }

    private static void usage(Object header, MemoryUsage mu) {
        long used = mu.getUsed(), max = mu.getMax();
        System.out.printf(
                max > 0? "%-30s %,d (%,d MiB) of %,d (%,d MiB)%n": "%-30s %,d (%,d MiB)%n",
                header, used, used >>> 20, max, max >>> 20);
    }

    private void calculateGenerationTotals(List<MemoryPoolMXBean> memoryPools) {
        long youngGenUsed = 0;
        long youngGenCommitted = 0;
        long youngGenMax = 0;

        long oldGenUsed = 0;
        long oldGenCommitted = 0;
        long oldGenMax = 0;

        for (MemoryPoolMXBean pool : memoryPools) {
            MemoryUsage usage = pool.getUsage();
            String name = pool.getName();

            if (name.contains("Eden") || name.contains("Survivor") ||
                    name.contains("Young") || name.contains("PS Young")) {
                youngGenUsed += usage.getUsed();
                youngGenCommitted += usage.getCommitted();
                if (usage.getMax() != -1) {
                    youngGenMax += usage.getMax();
                }
            } else if (name.contains("Old") || name.contains("Tenured") ||
                    name.contains("PS Old")) {
                oldGenUsed += usage.getUsed();
                oldGenCommitted += usage.getCommitted();
                if (usage.getMax() != -1) {
                    oldGenMax += usage.getMax();
                }
            }
        }

        System.out.println("\n=== CALCULATED GENERATION TOTALS ===");
        System.out.printf("Young Generation:%n");
        System.out.printf("  - Used:      %,dMB%n", youngGenUsed / (1024 * 1024));
        System.out.printf("  - Committed: %,dMB%n", youngGenCommitted / (1024 * 1024));
        if (youngGenMax > 0) {
            System.out.printf("  - Max:       %,dMB%n", youngGenMax / (1024 * 1024));
        }

        System.out.printf("Old Generation:%n");
        System.out.printf("  - Used:      %,dMB%n", oldGenUsed / (1024 * 1024));
        System.out.printf("  - Committed: %,dMB%n", oldGenCommitted / (1024 * 1024));
        if (oldGenMax > 0) {
            System.out.printf("  - Max:       %,dMB%n", oldGenMax / (1024 * 1024));
        }

        if (youngGenCommitted > 0 && oldGenCommitted > 0) {
            double youngRatio = (double) youngGenCommitted / (youngGenCommitted + oldGenCommitted) * 100;
            double oldRatio = (double) oldGenCommitted / (youngGenCommitted + oldGenCommitted) * 100;
            System.out.printf("Generation Ratio: Young=%.1f%%, Old=%.1f%%%n", youngRatio, oldRatio);
        }
    }
}
