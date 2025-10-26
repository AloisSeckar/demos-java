package org.javademos.util;

import org.javademos.init.JEPInfo.JEPData;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class for filtering and parsing command-line arguments
 * that determine which JEP demos should be executed.
 * <p>
 * This class provides filtering logic based on various criteria
 * such as JDK version, JEP number, and demo type (code or link-only).
 * </p>
 *
 * <h3>Supported arguments and examples:</h3>
 * <ul>
 *   <li><b>--skip-links</b> — Skip demos that only contain links to other JEPs.</li>
 *   <li><b>--code-only</b> — Run only demos that contain executable code.</li>
 *   <li><b>--jdk=17,25</b> — Run demos only from the specified JDK versions.</li>
 *   <li><b>--only=382,409</b> — Run only demos with the specified JEP numbers.</li>
 * </ul>
 *
* <h3>Multiple filters and examples:</h3>
 * <p>
 * Multiple filters can be combined. When multiple filters are specified,
 * only demos that satisfy all active filters are executed.
 * </p>
 *
 * <ul>
 * <li><b>--jdk=24,25 --code-only</b></li>
 * <li><b>--jdk=17,21 --skip-links</b></li>
 * </ul>
 *
 *
 * @author Alexander Schneider @ab-schneider
 */
public class ArgsFilterUtil {

    private static final Set<Integer> jdkVersions = new HashSet<>();
    private static final Set<Integer> specificJeps = new HashSet<>();
    private static boolean skipLinks = false;
    private static boolean codeOnly = false;

    private static final String SKIP_LINKS = "--skip-links";
    private static final String CODE_ONLY = "--code-only";
    private static final String JDK = "--jdk=";
    private static final String ONLY = "--only=";
    private static final String DELIMITER = ",";

    private ArgsFilterUtil() {
    }

    public static Map<Integer, JEPData> getFilteredJepData(String[] args, Map<Integer, JEPData> jepDataMap) {
        parseArguments(args);
        var filtered = filterJepData(jepDataMap);
        printFilteredInfo(filtered);
        return filtered;
    }

    private static void parseArguments(String[] args) {
        for (String arg : args) {
            if (SKIP_LINKS.equals(arg)) {
                skipLinks = true;
            } else if (CODE_ONLY.equals(arg)) {
                codeOnly = true;
            } else if (arg.startsWith(JDK)) {
                String jdkValues = arg.substring(JDK.length());
                parseJdkVersions(jdkValues);
            } else if (arg.startsWith(ONLY)) {
                String jepValues = arg.substring(ONLY.length());
                parseSpecificJeps(jepValues);
            } else {
                throw new IllegalArgumentException("Unknown arg: " + arg);
            }
        }
    }

    private static void printFilteredInfo(Map<Integer, JEPData> filtered) {
        System.out.println("\n=== FILTERED JEP INFORMATION ===");

        if (!skipLinks && !codeOnly && specificJeps.isEmpty() && jdkVersions.isEmpty()) {
            System.out.println("No filters applied. Total JEPs found: " + filtered.size());
        } else {
            if (skipLinks) {
                var linkOnlyCount = filtered.values().stream()
                        .filter(jepData -> !jepData.link())
                        .count();
                System.out.println("Skipped link demos. JEPs found: " + linkOnlyCount);
            }

            if (codeOnly) {
                var codeOnlyCount = filtered.values().stream()
                        .filter(jepData -> !jepData.code())
                        .count();
                System.out.println("Skipped no code demos. JEPs found: " + codeOnlyCount);
            }

            if (!jdkVersions.isEmpty()) {
                System.out.println("JDK versions: " + jdkVersions);
            }

            if (!specificJeps.isEmpty()) {
                System.out.println("Specific JEPs: " + specificJeps);
            }
        }

        System.out.println("================================\n");
    }

    private static void parseJdkVersions(String jdkValues) {
        String[] versions = jdkValues.split(DELIMITER);
        for (String version : versions) {
            try {
                jdkVersions.add(Integer.parseInt(version.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid JDK version: " + version);
            }
        }
    }

    private static void parseSpecificJeps(String jepValues) {
        String[] jeps = jepValues.split(DELIMITER);
        for (String jep : jeps) {
            try {
                specificJeps.add(Integer.parseInt(jep.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid JEP number: " + jep);
            }
        }
    }

    private static Map<Integer, JEPData> filterJepData(Map<Integer, JEPData> jepDataMap) {
        return jepDataMap.entrySet().stream()
                .filter(entry -> matchesFilters(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static boolean matchesFilters(JEPData jepData) {
        if (skipLinks && jepData.link()) {
            return false;
        }

        if (codeOnly && !jepData.code()) {
            return false;
        }

        if (!jdkVersions.isEmpty() && !jdkVersions.contains(jepData.jdk())) {
            return false;
        }

        if (!specificJeps.isEmpty() && !specificJeps.contains(jepData.jep())) {
            return false;
        }

        return true;
    }
}
