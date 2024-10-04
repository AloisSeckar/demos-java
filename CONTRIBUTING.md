# Java demos - how to help

You are welcome and encouraged to join your forces with us and put your Java skills and knowledge to a good use by helping us to build this project. "Java demos" are meant to be the place for both beginners in Java and more experienced programmers alike. With new features are being added (and sometimes even removed) every half a year, it is not easy to keep up. There are overview articles accompanying each JDK release, but having a comprehensive overview all at one place? Haven't found such project yet.

This originally started as a presentation for my work colleagues when **Java 17** came out, but I decided to keep it alive. After some transition period with not too much development being made, now I want to uplift it to be a livid open-source community project.

**You are invited to be a part of it!**

## Project structure

**NOTE:** Due to transition period, some information here may not correspond with the current state of the source code. Feel free to ask when in doubt.

Originally there were only a few cherry-picked demos for features I find most interesting and relevant. Now the ambition is to cover up **all JEPs since the release of Java 9 on 21 September 2017**. Currently, we are in the process of building the full structure.

- Under `org.javademos` there is/will be a package for each java release, e.g. `java23`. 
- Each such _"release package"_ contains sub-folders for JEPs included in it, e.g. `java23\jep455`.
- Every _"JEP package"_ contains **one** implementation of `org.javademos.commons.IDemo`, which is a simple interface designed to incorporate all demos together - see [the source](/src/main/java/org/javademos/commons/IDemo.java) for more info. Implementation class name is arbitrary, but should be based on the JEP name.
- Folder `org.javademos.init` contains helper classes, one for each JDK version, that were introduced mostly to reduce number of imports in the `Main.java` class.

## Demo implementation

**NOTE:** Due to transition period, some information here may not correspond with the current state of the source code. Feel free to ask when in doubt.

[`IDemo` interface](/src/main/java/org/javademos/commons/IDemo.java) prescribes two methods:
- `info()` - unified header, that only needs to be supplied with JEP number. Then it looks up the text info in Map defined in [`DemoInfo` class](/src/main/java/org/javademos/commons/DemoInfo.java) and prints it in a standardized way.
- `demo()` - this is the actual implementation of whatever can be shown to demonstrate tne new features introduced with the given JEP.

The code part in `demo()` method can contain little to no actual code. For many JEPs that are altering the internals of JVM or implementations of JDK library classes, only printing out some text summary may be enough to cover it.

Use comments to describe the code, reasons and possibilities. This should be a valuable source for the users to understand the behavior without having to read through the whole JEP specification or seeking some tutorial articles.

Each `IDemo` implementation should also contain a unified header (written in Java 23's Markdown style) with basic info about the JEP, its history and links to useful external resources (articles/tutorials).

For JEPs that are evolving over the time (more preview or incubator phases), older versions should be linked. The demo implementation code should bubble up to the newest available version. This is because sometimes it is not even possible to keep the older code style running in the latest JDK. The differences between the stages should be documented using comments and/or print statements.

Current referential implementation is [MarkdownComments.java for JEP 467](/src/main/java/org/javademos/java23/jep467/MarkdownComments.java).

## Contributions

Currently, there are stub implementations for the 12 features of **JDK 23**. For older JDK versions, the structure is not ready at all. You can help with that.

A number of demos already exist that are compatible, but not fully transferred to the new style. So this is the second option.

And most of the JEPs are not covered at all so far!

Of course also any corrections and inclusions to existing demos are welcome. I would like to keep the demos rather brief, but every relevant information may help the future users. 

We can always discuss under each individual PR, how to turn your invaluable effort into the best possible outcome.
