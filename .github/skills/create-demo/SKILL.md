---
name: create-demo
description: 'Create a standalone JEP demo in demos-java. Use when adding a final JEP with no preview/incubator predecessors.'
argument-hint: '<jep-number>'
---

# Create a JEP Demo

Input: one JEP number. Ask for it if missing. For a JEP with earlier preview/incubator iterations,
use [update-demo](../update-demo/SKILL.md) instead.

Follow [CONTRIBUTING.md](../../../CONTRIBUTING.md) for templates, registration conventions, and generated files.
Use [LazyConstantsDemo.java](../../../src/main/java/org/javademos/java26/jep526/LazyConstantsDemo.java)
as the style baseline.

## Workflow

1. Read `https://openjdk.org/jeps/<jep-number>` for the title, target JDK, status, history, and relevant APIs.
   Confirm the target JDK package, JSON resource, and loader exist; report missing release infrastructure
   as out of scope.
2. Create a descriptively named `IDemo` implementation in `org.javademos.java<jdk>.jep<jep-number>`.
   Start `demo()` with `info(<jep-number>)`. Use a `///` header with a single-entry JEP history and
   relevant reading links. Keep the example small and runnable; use an explanation only when code
   cannot demonstrate the feature.
3. Add the entry to `src/main/resources/JDK<jdk>Info.json` with `"link": false` and `"code": true`
   (`false` for explanation-only demos). Import and register the class in
   `src/main/java/org/javademos/init/Java<jdk>DemoLoader.java`. Keep both registrations in ascending JEP order.
4. Run `mvn clean install` and the jar using the command in [CONTRIBUTING.md](../../../CONTRIBUTING.md).
   Confirm the new JEP's header and expected output appear without exceptions, and review the diff for
   unrelated changes.
