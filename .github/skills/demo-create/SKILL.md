---
name: demo-create
description: 'Create a standalone JEP demo in demos-java. Use when adding a final JEP with no preview/incubator predecessors.'
argument-hint: '<jep-number>'
---

# Create a JEP Demo

Input: one JEP number. Ask for it if missing. For a JEP with earlier preview/incubator iterations,
use [demo-update](../demo-update/SKILL.md) instead.

Follow [CONTRIBUTING.md](../../../CONTRIBUTING.md) for templates, registration conventions, and generated files.
Use [LazyConstantsDemo.java](../../../src/main/java/org/javademos/java26/jep526/LazyConstantsDemo.java)
as the style baseline for demos with executable code. For explanation-only demos (no code to show), use
[GenerationalZGC23.java](../../../src/main/java/org/javademos/java23/jep474/GenerationalZGC23.java) instead.

## Workflow

1. Read `https://openjdk.org/jeps/<jep-number>` for the title, target JDK, status, history, and relevant APIs.
   Confirm the target JDK package, JSON resource, and loader exist; report missing release infrastructure
   as out of scope.
2. Create a descriptively named `IDemo` implementation in `org.javademos.java<jdk>.jep<jep-number>`.
   Start `demo()` with `info(<jep-number>)`. Use a `///` header with a single-entry JEP history and
   relevant reading links. Based on nature of the feature, consider whether it can have executable code demo
   or not. Some features only require an explanation via comments. If there is a code to be shown, keep the 
   example small and runnable; accompany code with explanatory comments.
3. Add the entry to `src/main/resources/JDK<jdk>Info.json` with `"link": false` and `"code": true`
   (`false` for explanation-only demos). Import and register the class in
   `src/main/java/org/javademos/init/Java<jdk>DemoLoader.java`. Keep both registrations in ascending JEP order.
4. Run `mvn clean install` and the jar using the command in [CONTRIBUTING.md](../../../CONTRIBUTING.md).
   Confirm the new JEP's header and expected output appear without exceptions, and review the diff for
   unrelated changes.
5. Branch, commit, and open the PR by following [pr-create](../pr-create/SKILL.md) for `<jep-number>`.
