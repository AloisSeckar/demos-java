---
name: update-demo
description: 'Update an existing JEP demo in demos-java to a newer preview, incubator, or final iteration, linking earlier demos to the new implementation.'
argument-hint: '<new-jep-number> <existing-demo-jep-number>'
---

# Update a JEP Demo

Inputs: the new JEP number and the JEP number holding the current implementation. Ask for any missing input.
For a JEP without predecessors, use [create-demo](../create-demo/SKILL.md) instead.
Follow [CONTRIBUTING.md](../../../CONTRIBUTING.md) and the existing demo's style.

## Workflow

1. Read `https://openjdk.org/jeps/<new-jep-number>` and predecessor pages as needed to establish the full
   feature chain, official titles, JDK releases, and API changes. Locate the existing implementation,
   earlier stubs, JSON entries, and loaders. Identify missing iterations between the existing and new JEPs.
2. Port the implementation to `org.javademos.java<jdk>.jep<newJep>`, keeping the class name unchanged and
   starting `demo()` with `info(<newJep>)`. Check the installed JDK and API signatures, and adapt the code
   to the new API with small runnable examples of notable changes.
   Use a `///` header with a feature/status summary, required runtime flags, concise API-change notes
   per intervening release, newest-first JEP history using official titles, and relevant reading links.
   Retain existing reading links and author attribution.
3. Convert every superseded demo in the chain to a linking stub; create stubs for missing intermediate
   iterations too. Each stub keeps its original JDK/JEP package and header, calls only `info(<itsJep>)`
   in `demo()`, and has an `@see` pointing directly to the new implementation, never another stub.
4. Update each affected `src/main/resources/JDK<jdk>Info.json`:
   - Old and intermediate entries: `"link": true`, `"code": false`, and `dscr` set to
     ``Up-to-date demo in `org.javademos.java<jdk>.jep<newJep>.<ClassName>`.``
   - New implementation: the actual title/description, `"link": false`, `"code": true`.
   Import and register the new demo and newly created stubs in their respective
   `src/main/java/org/javademos/init/Java<jdk>DemoLoader.java`. Keep JSON and loader entries in ascending JEP order.
5. Run `mvn clean install` and the jar using the command in [CONTRIBUTING.md](../../../CONTRIBUTING.md).
   Confirm every JEP in the chain prints its header without exceptions and the new examples produce
   expected output. Check all earlier `@see` and JSON `dscr` references point to the new implementation,
   and review the diff for unrelated changes.
