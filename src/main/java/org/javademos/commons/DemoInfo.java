package org.javademos.commons;

import java.util.Map;

public class DemoInfo {

    private DemoInfo() {}

    public record DemoInfoData(String name, String dscr) {}

    public static Map<Integer, DemoInfoData> DEMO_INFO = Map.ofEntries(
            // JDK 22
            Map.entry(423, new DemoInfoData(
                    "JEP 423 - Region Pinning for G1",
                    "No executable code, see RegionPinningForG1 class for further info"
            )),
            Map.entry(447, new DemoInfoData(
                    "JEP 447 - Statements before super(...)",
                    "Since Java 22, super() it is no longer required\nto be placed as first statement in constructor"
            )),
            // JDK 23
            Map.entry(455, new DemoInfoData(
                    "JEP 455 - Primitive Types in Patterns, instanceof, and switch (Preview)",
                    "See PrimitiveTypesInPatterns class for further info"
            )),
            Map.entry(466, new DemoInfoData(
                    "JEP 466 - Class-File API (Second Preview)",
                    "See ClassFileAPI class for further info"
            )),
            Map.entry(467, new DemoInfoData(
                    "JEP 467 - Markdown Documentation Comments",
                    "Markdown is now allowed in Java comments. See MarkdownComments.java class for further info"
            )),
            Map.entry(469, new DemoInfoData(
                    "JEP 469 - Vector API (Eighth Incubator)",
                    "See VectorAPI class for further info"
            )),
            Map.entry(471, new DemoInfoData(
                    "JEP 471 - Deprecate the Memory-Access Methods in sun.misc.Unsafe for Removal",
                    "See DeprecateMemoryAccessMethods class for further info"
            )),
            Map.entry(473, new DemoInfoData(
                    "JEP 473 - Stream Gatherers (Second Preview)",
                    "See StreamGatherers class for further info"
            )),
            Map.entry(474, new DemoInfoData(
                    "JEP 474 - ZGC: Generational Mode by Default",
                    "See ZGCGenerational class for further info"
            )),
            Map.entry(476, new DemoInfoData(
                    "JEP 476 - Module Import Declarations (Preview)",
                    "See ModuleImportDeclarations class for further info"
            )),
            Map.entry(477, new DemoInfoData(
                    "JEP 477 - Implicitly Declared Classes and Instance Main Methods (Third Preview)",
                    "See ImplicitlyDeclaredClasses class for further info"
            )),
            Map.entry(480, new DemoInfoData(
                    "JEP 480 - Structured Concurrency (Third Preview)",
                    "See StructuredConcurrency class for further info"
            )),
            Map.entry(481, new DemoInfoData(
                    "JEP 481 - Scoped Values (Third Preview)",
                    "See ScopedValues class for further info"
            )),
            Map.entry(482, new DemoInfoData(
                    "JEP 482 - Flexible Constructor Bodies (Second Preview)",
                    "See FlexibleConstructorBodies class for further info"
            ))
    );

}
