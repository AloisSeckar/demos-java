---
name: update-demo
description: 'Update a JEP demo to its latest preview/incubator iteration in demos-java. Use when a previewed/incubating JEP (e.g. Structured Concurrency, Vector API, Lazy Constants) advances to a new JEP number in a newer JDK release and the existing demo code needs to move forward, with all older iterations turned into (or kept as) linking stubs. Takes two JEP numbers: the new JEP and the existing JEP whose implementation currently holds the demo code.'
argument-hint: '<new-jep-number> <existing-demo-jep-number>'
---

# Update Demo to Latest JEP Iteration

Creates a new demo implementation for a
JEP that **already has** preview/incubator predecessors. Moves a demo's real implementation from an older JEP
package to a new one (newest preview/incubator/final iteration of the same feature), turns the old demo into a
thin "linking" stub, and re-points every earlier iteration in the chain at the new demo. Mirrors the workflow
used to move Structured Concurrency from JEP 505 (JDK 25) to JEP 533 (JDK 27), also creating a JEP 525
(JDK 26) stub for the iteration in between. For a JEP with **no** prior iterations, use the `create-demo`
skill instead.

## Inputs

1. **New JEP number** — the JEP that should receive the real, up-to-date implementation.
2. **Existing demo JEP number** — the JEP that currently contains the working implementation.

If either number is missing when this skill is invoked, ask the user for both before doing anything else
(use the questions tool if available). Don't guess numbers.

## Procedure

### 1. Gather facts

- Fetch `https://openjdk.org/jeps/<new-jep-number>` (and the existing JEP's page if useful) to get: JEP title,
  target JDK release, preview/incubator status, and the **History** section — it lists every prior JEP in the
  chain and links "Relates to" the neighbors.
- Find the existing implementation: search the repo for the existing JEP number/class name
  (`grep_search` for the JEP number and class name) to locate its file, its `IDemoLoader`, and its JSON entry.
- From the History section, build the **full chain** of JEP numbers for this feature, oldest to newest
  (e.g. 428 → 437 → 453 → 462 → 480 → 499 → 505 → 525 → 533). Check which of those already have a demo class
  under `src/main/java/org/javademos/javaNN/jepNNN/`. **Any iteration in the chain between the existing demo
  and the new JEP that has no demo yet needs a new linking stub created too** — don't assume the new JEP is
  the very next one after the existing demo.

### 2. Create the new implementation

- New package: `org.javademos.java<jdk>.jep<newJep>`, same class name as the existing demo class
  (keep names stable so `@see` links and IDE rename tooling keep working).
- Read [CONTRIBUTING.md](../../../CONTRIBUTING.md) conventions and use an existing up-to-date demo (e.g. the
  file the existing JEP number points you to) as a style baseline: Java 23+ `///` Markdown doc comment header,
  `info(<newJep>)` as the first call in `demo()`.
- Doc header should include, in this order:
  - One-line summary of the feature and its status (preview/incubator) in the target release, plus the
    `--enable-preview` / `--add-modules` note if applicable.
  - A **"Changes in JDK X (JEP Y)"** subsection per intermediate release, summarizing only the API-relevant
    deltas pulled from each JEP's History section (renamed methods, new type parameters, removed methods,
    changed exception types, etc.) — this is what makes the demo useful for readers tracking the evolution.
  - **JEP history** list, newest to oldest, with correct ordinal names (Preview/Incubator counts) — verify
    each ordinal against the actual JEP title, don't copy-paste guesses forward.
  - Further reading links (keep existing ones, add new ones found while researching).
- Port the demo code forward, updating it to compile against the **currently installed JDK** (check with
  `java -version`). Inspect the real API shape before writing code:
  `javap java.util.concurrent.SomeClass java.util.concurrent.SomeClass\$Nested` (no `--enable-preview` flag —
  `javap` doesn't accept it; the installed preview JDK exposes the API either way).
- Prefer adding one small, runnable example per notable API change introduced along the chain (e.g. one method
  per joiner policy) over a single opaque example — it makes the "what changed" comments concrete.

### 3. Turn old iterations into linking stubs

Replace each superseded demo's body with the minimal linking pattern used throughout the repo:

```java
package org.javademos.java<old>.jep<old>;

import org.javademos.commons.IDemo;

/// Demo for JDK <old> feature JEP <old> - <Feature Name> (<Ordinal>).
///
/// This was a preview/incubator JEP. The feature's latest iteration is in JDK <new> by JEP <newJep>.
/// @see org.javademos.java<new>.jep<newJep>.<ClassName>
///
/// @author <keep original author tag if present>
public class <ClassName> implements IDemo {
    @Override
    public void demo() {
        info(<old>);
    }
}
```

- Do this for the JEP passed in as "existing demo JEP" **and** for every other already-implemented JEP in the
  chain that still points at it or at an earlier stub — they must all end up pointing at the new JEP, not at
  each other transitively. Search for `@see org.javademos...<ClassName>` across the repo to find all of them.
- For any JEP found in step 1's chain that has **no** folder/class yet (between the existing demo and the new
  JEP), create a linking stub for it too, following the same template, package
  `org.javademos.java<jdk>.jep<jep>`.

### 4. Register JSON entries

- In `src/main/resources/JDK<old>Info.json` (and any other JDK's JSON whose entry pointed at the old class):
  set `"link": true`, `"code": false`, and
  `"dscr": "Up-to-date demo in \`org.javademos.java<new>.jep<newJep>.<ClassName>\`."`.
- For any newly-created intermediate stub JEPs, add matching `"link": true` entries to their JDK's JSON.
- In `src/main/resources/JDK<new>Info.json`, add a new entry **ordered by JEP number ascending** with the
  real `name`/`dscr`, `"link": false`, `"code": true`.

### 5. Register loaders

- In `src/main/java/org/javademos/init/Java<new>DemoLoader.java`, import the new class and add
  `demos.put(<newJep>, new <ClassName>());`, **ordered by JEP number ascending**.
- Do the same for any intermediate JDK's `DemoLoader` that needs a new entry for a newly-created stub.

### 6. Verify

- `mvn clean install` must succeed.
- Run the jar (check the exact command/jar name in `README.md`/`CONTRIBUTING.md`, e.g.
  `java --enable-preview --add-modules=jdk.incubator.vector -jar target/JavaDemos-<version>.0.jar`) and confirm:
  - Every JEP in the chain (old, intermediate stubs, and new) prints its header via `info()` with no exceptions.
  - The new demo's runnable examples print the expected output for each showcased behavior.
- Double check no unrelated files were touched: grep the repo once more for the old class's `@see` target and
  old JEP number in JSON `dscr` fields to make sure nothing in the chain was missed.

## Notes

- This skill is for **an existing chain of iterations gaining a new one** — if step 1 shows the given JEP has
  no preview/incubator predecessors at all, stop and use `create-demo` instead.
- Never change a demo class's simple name when moving it forward — only the package (`javaNN.jepNNN`) changes,
  so `@see` references and any external tooling relying on the name keep working.
- `javap` does not accept `--enable-preview`; just run it against the installed JDK directly.
- JSON entries must stay ordered by ascending JEP number within each file.
- Keep the `@author` line of the original implementer on the linking stub; add yourself only to the new file
  if you wrote genuinely new example code.
