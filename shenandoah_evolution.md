The Evolution of the Shenandoah Garbage Collector
This document provides a historical overview of the Shenandoah Garbage Collector, mapping its evolution through the key Java Enhancement Proposals (JEPs) that have shaped it. As noted in issue #301, Shenandoah's development path is a great example of iterative enhancement, where a feature is first stabilized and then gains significant new capabilities in subsequent releases.

Shenandoah is a concurrent garbage collector, which means it does the majority of its work—including marking, referencing, and compacting—at the same time as the application threads are running. This design results in extremely low and predictable pause times, making it ideal for applications with large heaps and strict latency requirements.

Key JEPs in the Shenandoah Timeline
The journey of Shenandoah can be traced through four major JEPs, each marking a critical milestone in its development.

1. JEP 189: The Experimental Introduction (JDK 12)
Title: Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)

Goal: To add a new garbage collection (GC) algorithm named Shenandoah, which reduces GC pause times by doing evacuation work concurrently with the running Java threads.

Significance:

This was the birth of Shenandoah in the OpenJDK.

It established the core design principle: a concurrent compacting collector that keeps pause times independent of heap size.

As an experimental feature, it required the -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC flags to be enabled.

2. JEP 379: From Experimental to Production (JDK 15)
Title: Shenandoah: A Low-Pause-Time Garbage Collector

Goal: To make the Shenandoah garbage collector a production feature, no longer marked as experimental.

Significance:

This marked Shenandoah's maturation into a stable, supported feature.

It was a vote of confidence in its reliability and performance, making it a first-class citizen alongside other collectors like G1 and ZGC.

The experimental flags were no longer required; it could be enabled simply with -XX:+UseShenandoahGC.

3. JEP 404: A Major New Capability (JDK 17)
Title: Generational Shenandoah (Experimental)

Goal: To add support for generational garbage collection to the Shenandoah GC as an experimental feature.

Significance:

This JEP represents the next stage of Shenandoah's evolution. While the core GC was already a production feature, this introduced a new, powerful mode of operation that was initially experimental.

By adding a young generation, Shenandoah could handle short-lived objects more efficiently, improving throughput and reducing the load on the concurrent cycle. This is crucial for applications with high allocation rates.

This highlights the non-traditional path: a new experimental feature was added to an existing production feature.

4. JEP 521: Finalizing the Generational Mode (JDK 25)
Title: Generational Shenandoah

Goal: To make the generational mode of the Shenandoah garbage collector a product (non-experimental) feature.

Significance:

This JEP completes the journey for generational collection, moving it from experimental to a fully supported, production-ready feature.

It solidifies Shenandoah as a highly versatile GC, offering both a default non-generational mode and a high-performance generational mode to suit different application profiles.

Users can now confidently use Generational Shenandoah in production environments to achieve both low pauses and high throughput.

Visualizing the Evolution
This diagram maps the connections between the JEPs and illustrates Shenandoah's unique development path.

Code snippet

graph TD;
    A[JEP 189 in JDK 12 <br> <strong>Shenandoah (Experimental)</strong>] -->|Matures into a product feature| B[JEP 379 in JDK 15 <br> <strong>Shenandoah (Production)</strong>];
    B -->|A new experimental mode is added| C[JEP 404 in JDK 17 <br> <strong>Generational Mode (Experimental)</strong>];
    C -->|The new mode becomes a product feature| D[JEP 521 in JDK 25 <br> <strong>Generational Mode (Production)</strong>];

    style A fill:#f9f,stroke:#333,stroke-width:2px
    style B fill:#9f9,stroke:#333,stroke-width:2px
    style C fill:#f9f,stroke:#333,stroke-width:2px
    style D fill:#9f9,stroke:#333,stroke-width:2px
Summary
The history of Shenandoah is a compelling story of continuous innovation within the OpenJDK. It started as a promising experimental idea (JEP 189), grew into a production-ready low-pause collector (JEP 379), and then evolved further by incorporating a powerful generational mode—first as an experiment (JEP 404) and finally as a fully supported feature (JEP 521). This journey demonstrates a flexible and robust development model for bringing large-scale features to the Java platform.
