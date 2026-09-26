# Java demos

This is Java project using Maven as build tool.

The goal is to provide simple explanation and examples for all Java JEPs to teach new developers.

Tooling is described in [README.md](README.md#prerequisites).

Build and run commands are described in [README.md](README.md#usage).

When adding or updating demos, read [CONTRIBUTING.md](CONTRIBUTING.md#demo-implementation) for implementation conventions, project structure, and workflow. Use the appropriate skill:
- [create-demo](.github/skills/create-demo/SKILL.md): a standalone final JEP without preview/incubator predecessors.
- [update-demo](.github/skills/update-demo/SKILL.md): a newer preview, incubator, or final iteration of an existing demo.

Each demo needs an `IDemo` implementation, per-JDK JSON metadata, and registration in its JDK's loader. Start `demo()` with `info(jepNumber)`.

Use [src/main/java/org/javademos/java26/jep526/LazyConstantsDemo.java](src/main/java/org/javademos/java26/jep526/LazyConstantsDemo.java) as the baseline implementation.

Use `https://openjdk.org/jeps/jep-index.xml` to get basic JEP info by number and/or title, and `https://openjdk.org/jeps/<JEP_NUMBER>` for implementation details. Make sure the project compiles and runs without errors.
