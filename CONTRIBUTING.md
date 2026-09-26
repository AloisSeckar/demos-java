# Java demos - how to help

**This project is [Hacktoberfest](https://hacktoberfest.com/) friendly!**

Start with the [typical workflow](#typical-workflow): check issue assignments before coding, and make sure
your changes compile and run before submitting.

## Introduction

Java adds and sometimes removes features every six months. Release overviews help, but **Java demos**
aims to bring that knowledge together for beginners and experienced developers alike.

The project began as a presentation for colleagues when **Java 17** came out. After a quieter period,
the goal is to grow it into an active open-source community. You are welcome to help!

### Notice about AI usage

In 2026, AI tools are welcome, but **understand their output before submitting a PR** and follow
[The AI Manifesto](https://ai-manifesto.dev/). We do not plan to ban AI-generated contributions, but may
ask you to explain your work and reject submissions you cannot demonstrate you understand.

## Project structure

What began as a few selected demos now aims to cover **all JEPs since Java 9, released on 21 September 2017**.
The full structure is still being built:

- [org.javademos](https://github.com/AloisSeckar/demos-java/tree/master/src/main/java/org/javademos)
    has a package per Java release, such as `java25`, with a subfolder per JEP, such as
    [java25/jep511](https://github.com/AloisSeckar/demos-java/tree/master/src/main/java/org/javademos/java25/jep511).
    Each JEP package contains **one** `IDemo` implementation.
- [resources](https://github.com/AloisSeckar/demos-java/tree/master/src/main/resources) holds the per-JDK
    JSON metadata, automatically loaded into a static map in
    [JEPInfo.java](src/main/java/org/javademos/init/JEPInfo.java#L10).
- [org.javademos.init](https://github.com/AloisSeckar/demos-java/tree/master/src/main/java/org/javademos/init)
    has one loader/helper per JDK, reducing imports and allowing whole releases' demos to be enabled or disabled.
- [Main.java](src/main/java/org/javademos/Main.java#L1) prints JVM information, loads demos through those
    helpers, and runs them sequentially. Each demo determines its own output.

**Migration note:** JDK 22 and older demos are not yet fully transferred to the new structure and Markdown
comment style. Some guidance may therefore differ from the code; ask when in doubt. Migration help is welcome
once you are familiar with the project.

## Demo implementation

Read the [project structure](#project-structure), then follow these conventions:

- Implement [IDemo](src/main/java/org/javademos/commons/IDemo.java#L1) in the correct JDK/JEP package,
    choosing a descriptive class name based on the JEP. Only `public void demo()` needs implementing;
    start it with `info(jepNumber)`. This default method uses the metadata map to print a standardized JEP header.
- Keep examples brief but sufficient to show the feature. For changes to JVM or library internals that cannot
    be demonstrated in code, explanatory comments or printed summaries are enough; see
    [GenerationalZGC23.java](src/main/java/org/javademos/java23/jep474/GenerationalZGC23.java#L1).
- Use ordinary code comments to explain behavior, reasoning, and possibilities so readers need not consult
    the full JEP or a tutorial. Add a Java 23+ Markdown (`///`) class header with JEP information, history,
    and useful article/tutorial links. The reference is
    [MarkdownComments.java for JEP 467](src/main/java/org/javademos/java23/jep467/MarkdownComments.java#L1).
- For preview/incubator chains, keep the implementation in the newest iteration and link older demos to it:
    older APIs may no longer compile on the latest JDK. Document differences using comments or print statements.
- Write generated files under the repository-local `tmp/` folder, which is gitignored to avoid untracked artifacts.
- Add a record to the appropriate JDK JSON resource, following existing entries and this field order:
    JEP number (`jep`), JDK version (`jdk`), name (`name`), brief description (`dscr`),
    `link` (`true` if replaced by another JEP), and `code` (`true` for code, `false` for explanation-only demos).
- Register the demo in its JDK's helper so `Main` runs it, adding a comment with the JEP number.
    **Keep both JSON records and loader registrations ordered by ascending JEP number.**

## Contributions

We are opening focused issues for all features, working backward from **JDK 27**; many JEPs remain uncovered.
Other JEPs are welcome too: open an issue so the work can be tracked and credited. You can also modernize
existing demos, fix inconsistencies, or add useful corrections and details while keeping examples brief.

Look for `good first issue` for smaller, simpler tasks. The `advanced` label suits contributors familiar
with the structure, preferably with accepted PRs already. Clarify the task in issue comments before coding
to avoid rework; ideas and improvements can be discussed on the issue or PR.

## Typical workflow

1. Choose an [issue](https://github.com/AloisSeckar/demos-java/issues), or open one if none fits.
    **Check that it is unassigned.** Requesting assignment before starting is recommended. If work overlaps, I will try
     to help combine contributions with an already accepted version, but cannot guarantee that outcome.
2. Fork the repository to your GitHub account and work on a new branch, following the implementation
     guidance above. Prefer **one JEP per branch and PR**. See
     [GitHub's contribution guide](https://docs.github.com/en/get-started/exploring-projects-on-github/contributing-to-a-project)
     for the basics.
3. **Build and run without errors** using both commands below. CI checks the build and execution;
     failures must be fixed before merging. Running catches errors, but read the source comments for full context.

     ```shell
     mvn clean install
     java --enable-preview --add-modules=jdk.incubator.vector -jar target/JavaDemos-27.0.jar
     ```

4. Sync your fork with the upstream default branch and open a PR against it. Shared helpers and JSON
     resources are common sources of conflicts. See
     [GitHub's PR guide](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests)
     and this [well-structured PR](https://github.com/AloisSeckar/demos-java/pull/52/files).
     Review **Files changed** and remove unrelated changes from your submission.
5. Ask questions or request help, including build problems, in the issue/PR or contact me directly.
     Please be patient: I aim to provide feedback or merge within **24 hours**, but cannot always review immediately.

Thank you for helping improve Java demos. I look forward to working with you!
