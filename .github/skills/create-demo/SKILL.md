---
name: create-demo
description: 'Create a brand-new JEP demo in demos-java for a standalone feature with no preview/incubator history (a single, final JEP number). Use when asked to add/implement a demo for a new JEP that has no prior iterations to link. Takes one JEP number as input.'
argument-hint: '<jep-number>'
---

# Create a New Standalone JEP Demo

Creates a new demo implementation for a standalone
JEP that was delivered directly (no preview/incubator predecessors to link back to). For JEPs that
*do* have prior preview/incubator iterations, use the `update-demo` skill instead.

## Inputs

**JEP number** — the JEP to implement. If not provided when this skill is invoked, ask the user for it before
doing anything else (use the questions tool if available). Don't guess the number.

## Procedure

### 1. Gather facts

- Fetch `https://openjdk.org/jeps/<jep-number>` for: title, target JDK release, status (Feature/final vs.
  Preview/Incubator — if it turns out this JEP *does* have a preview/incubator history, stop and suggest the
  `update-demo` skill instead), Summary, and any relevant API/behavior details needed for a code example.
- Confirm the target JDK release folder exists under `src/main/java/org/javademos/java<jdk>/`. If the JDK
  package or its `Info.json`/`DemoLoader` don't exist yet, they're out of scope for this skill — flag it to
  the user.
- Check the JDK is actually installed/usable for compiling (`java -version`) if the JEP requires a specific
  preview flag or incubator module.

### 2. Create the implementation

- Package: `org.javademos.java<jdk>.jep<jep-number>`.
- Class name: based on the JEP name (arbitrary but descriptive, e.g. `LazyConstantsDemo`), implementing
  [`org.javademos.commons.IDemo`](../../../src/main/java/org/javademos/commons/IDemo.java).
- Use the Java 23+ `///` Markdown doc comment header, following the template embedded in
  [`IDemo.java`](../../../src/main/java/org/javademos/commons/IDemo.java):
  ```
  /// Demo for JDK <VER> feature JEP <NUM> - <JEP_NAME>.
  ///
  /// JEP history:
  /// - JDK <VER>: [JEP <NUM> - <JEP_NAME>](https://openjdk.org/jeps/<NUM>)
  ///
  /// Further reading:
  /// - [<ARTICLE_TITLE>](<ARTICLE_URL>)
  ///
  /// @author <your identifier>
  ```
  Since this JEP has no prior iterations, the "JEP history" section has just the one entry — don't invent a
  chain that doesn't exist.
- `demo()` must start with `info(<jep-number>)`.
- Add a small, runnable code example that demonstrates the feature in action. Use
  [`LazyConstantsDemo.java`](../../../src/main/java/org/javademos/java26/jep526/LazyConstantsDemo.java) as a
  style baseline (helper classes for demo-only data are fine alongside the main class in the same file).
- If the feature genuinely can't be shown with a code snippet (e.g. it changes JVM/GC internals), it's fine to
  only use comments/print statements to explain it — see
  [`GenerationalZGC23.java`](../../../src/main/java/org/javademos/java23/jep474/GenerationalZGC23.java) as
  precedent. Prefer a real example whenever the API allows one.
- If the demo writes any files, save them under the repo-local `tmp/` folder (gitignored).

### 3. Register the JSON entry

- Add a new entry to `src/main/resources/JDK<jdk>Info.json`, **ordered by JEP number ascending**:
  ```json
  {
    "jep": <jep-number>,
    "jdk": <jdk>,
    "name": "JEP <jep-number> - <JEP_NAME>",
    "dscr": "<brief description of the feature>",
    "link": false,
    "code": true
  }
  ```
  Use `"code": false` only if step 2 ended up as comments-only.

### 4. Register the loader

- In `src/main/java/org/javademos/init/Java<jdk>DemoLoader.java`, import the new class and add
  `demos.put(<jep-number>, new <ClassName>());`, **ordered by JEP number ascending**, with a comment noting
  the JEP number if the surrounding style uses one.

### 5. Verify

- `mvn clean install` must succeed.
- Run the jar per `README.md`/`CONTRIBUTING.md`
  (e.g. `java --enable-preview --add-modules=jdk.incubator.vector -jar target/JavaDemos-<version>.0.jar`) and
  confirm the new JEP's header and example output print with no exceptions.
- Double check no unrelated files were touched (only the intended JDK package, JSON entry, and loader line).

## Notes

- This skill is for **one JEP, one demo, no linking**. If research in step 1 reveals earlier preview/incubator
  JEPs for the same feature, stop and use `update-demo` instead (it handles chains and linking stubs).
- Keep the demo brief — comments should guide a curious reader without requiring them to read the full JEP.
