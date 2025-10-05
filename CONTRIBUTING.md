# Java demos - how to help

**This project is [Hacktoberfest](https://hacktoberfest.com/) friendly!**

**tl;dr:** Please, check [typical workflow](#typical-workflow) section below for better understanding how to get started.

**DO NOT FORGET TO CHECK, IF THE ISSUE YOU WANT TO WORK ON, ISN'T ALREADY ASSIGNED TO SOMEONE ELSE!**

**MAKE SURE YOUR CODE COMPILES AND RUNS WITHOUT ERRORS BEFORE SUBMITTING!**

## Introduction

You are welcome and encouraged to join your forces with us and put your Java skills and knowledge to a good use by helping us to build this project. **"Java demos"** are meant to be the place for both beginners in Java and more experienced programmers alike. With new features are being added (and sometimes even removed) every half a year, it is not easy to keep up. There are overview articles accompanying each JDK release, but having a comprehensive overview all at one place? Haven't found such project yet.

This originally started as a presentation for my work colleagues when **Java 17** came out, but I decided to keep it alive. After some transition period with not too much development being made, now I want to uplift it to be a livid open-source community project.

**You are invited to be a part of it!**

## Project structure

Originally, there were only a few cherry-picked demos for features I find most interesting and relevant. Now the ambition is to cover up **all JEPs since the release of Java 9 on 21 September 2017**. Currently, we are in the process of building the full structure.

- Under [`org.javademos`](https://github.com/AloisSeckar/demos-java/tree/master/src/main/java/org/javademos) there is/will be a package for each Java release, e.g. `java25`. 
- Each such _"release package"_ contains sub-folders for JEPs included in it, e.g. [`java25/jep511`](https://github.com/AloisSeckar/demos-java/tree/master/src/main/java/org/javademos/java25/jep511).
- Every _"JEP package"_ contains **one** implementation of [`org.javademos.commons.IDemo`](https://github.com/AloisSeckar/demos-java/blob/master/src/main/java/org/javademos/commons/IDemo.java), which is a simple interface designed to incorporate all demos together - see the source code for more info. Implementation class name is arbitrary, but should be based on the JEP name.
- The interface only requires one method to be implemented - `public void demo()`. This is the entry point for each, where the relevant code is intended to run. 
- Each `public void demo()` implementation should start with a call to `info()` method, which takes number of the JEP as parameter and prints out a unified header with basic info about the JEP. To make it work, you need to add a new entry to the respective JSON in [`resources`](https://github.com/AloisSeckar/demos-java/tree/master/src/main/resources) folder. See existing entries for reference. All JSON entries are automatically loaded into a static Map in [`JEPInfo.java`](https://github.com/AloisSeckar/demos-java/blob/master/src/main/java/org/javademos/commons/JEPInfo.java) and used by `info()` default implementation in `IDemo` interface.
- For most JEPs, we then want to provide a little code example. Like that, future users can understand the feature better as they don't have to imagine it only, but see it in action. However, some features are not really possible to demonstrate with a code snippet. In such case, it is completely fine only to gather meaningful comments that would guide the curious reader to understand the point. Here is an example of such demo: [`java23/jep474/GenerationalZGC23.java`](https://github.com/AloisSeckar/demos-java/blob/master/src/main/java/org/javademos/java23/jep474/GenerationalZGC23.java)
- Folder [`org.javademos.init`](https://github.com/AloisSeckar/demos-java/tree/master/src/main/java/org/javademos/init) contains helper classes, one for every JDK version, that were introduced mostly to reduce number of imports per class. Also it allows to turn on/off whole sub-set for given JDK version, if needed.
- Last but not least, [`Main.java`](https://github.com/AloisSeckar/demos-java/blob/master/src/main/java/org/javademos/Main.java) class is the main entrypoint - it starts by displaying current JVM info, then loads all demos from the helper files and runs them one by one. The output depends on their implementation.

**Note:** Currently, there is a transition period, when JDK 22 and older files are not yet fully transferred to the new structure. Once you get familiar with this project better, you can also help with that aside from implementing new demos for lates JEPs.

## Demo implementation

**NOTE:** Due to transition period, some information here may not correspond with the current state of the source code. Feel free to ask when in doubt.

[`IDemo` interface](/src/main/java/org/javademos/commons/IDemo.java) prescribes two methods:
- `info()` - unified header, that only needs to be supplied with JEP number. Then it looks up the text info in Map defined in [`DemoInfo` class](/src/main/java/org/javademos/commons/DemoInfo.java) and prints it in a standardized way.
- `demo()` - this is the actual implementation of whatever can be shown to demonstrate tne new features introduced with the given JEP.

The code part in `demo()` method can contain little to no actual code. For many JEPs that are altering the internals of JVM or implementations of JDK library classes, only printing out some text summary may be enough to cover it.

Use comments to describe the code, reasons and possibilities. This should be a valuable source for the users to understand the behavior without having to read through the whole JEP specification or seeking some tutorial articles.

Each `IDemo` implementation should also contain a unified header (written in Java 23+ Markdown style) with basic info about the JEP, its history and links to useful external resources (articles/tutorials).

For JEPs that are evolving over the time (more preview or incubator phases), older versions should be linked. The demo implementation code should bubble up to the newest available version. This is because sometimes it is not even possible to keep the older code style running in the latest JDK. The differences between the stages should be documented using comments and/or print statements.

Current referential implementation is [MarkdownComments.java for JEP 467](/src/main/java/org/javademos/java23/jep467/MarkdownComments.java).

## Contributions

**If you want to help with some issue, please check if it not assigned yet first!** Lets avoid unncessesary conflicts and disappointments before they can happen.

Currently, the focus is on implementing demos for all features of [JDK 25](https://github.com/AloisSeckar/demos-java/issues/29), [JDK 24](https://github.com/AloisSeckar/demos-java/issues/28) and [JDK 23](https://github.com/AloisSeckar/demos-java/issues/1), in given order. However, if you feel like creating demo for some older JEP, you are very much welcome to do so! Just let me know by opening an issue, so it can be properly tracked and your contribution can be recognized. Rememeber, most of the JEPs are not covered at all so far.

Issues are tagged with labels. If you are here for the first time, look for `good first issue` label which indicates relatively smaller and simplier tasks. Tasks labeled with `advanced` will require better understanding of this project structure and they are recommended to users who already have some PRs accepted. Before starting to work on any issue, be sure you understand the task clearly to avoid unnecessary re-work. If in doubt, please, ask in the issue comments.

A number of JEP demos exist already, but they're not fully transferred to the new style (with Markdown comments). So this is also an option of how to help.

Last, but not least - any corrections and inclusions to existing demos are welcome. I would like to keep the demos rather brief, but every relevant information may help the future users. 

We can always discuss under each individual issue/PR, how to turn your invaluable effort into the best possible outcome!

## Typical workflow

1. Go into [Issues](https://github.com/AloisSeckar/demos-java/issues) and pick up an issue you want to work on. **Check if it is not assigned to someone else yet**. It is also advised to ask for an assignment first to avoid possible clash of two contributors over same issue. If that ever happens, I will try to guide you to blend your variant with the previously accepted, but the result can't be guaranted. If no suitable issue is opened, please feel free to create a new one.
2. Fork the repository to your own GitHub account, create a new branch and work on your changes there. Check [GitHub docs](https://docs.github.com/en/get-started/exploring-projects-on-github/contributing-to-a-project) to understand the general process better, if you not fully familiar with it yet. Don't hessitate to ask me for help, if needed.
3. **Always make sure your code compiles and runs without errors.** 
   - Command `mvn clean install` must execute successfully. It is guarded by GitHub workflow in the PR review process and if the changes cannot be compiled, the PR won't be merged until the problems are fixed. If you need help with making code compile, please, ask in the issue/PR comments or contact me directly.
   - Command `java --enable-preview --add-modules=jdk.incubator.vector -jar target\JavaDemos-25.0.jar` must run and finnish without errors. You may miss some important context and information without reading the comments in the source code, but at least you will be sure your code is not breaking anything.
4. Once you are done, create a Pull Request (PR) from your branch to the `main` branch of this repository. Again, check [GitHub docs](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests) for more info about PRs. I'd advise you to focus on one JEP at the time, have a new branch and new PR for each. Also, don't forget to sync your fork with the original repository to avoid conflicts. Conflicts are likely, because more people may access the same files (e.g. helpers and JSON resources) at the same time.
5. To get your submission accepted, I'd like to ask you to follow those few key points:
    - Make yourself familiar with the [Project structure](#project-structure) to understand how this project is meant to work.
    - If you are working on a new JEP, provide new implementation of `IDemo` interface for the JEP you are working on with sufficient content.
    - Place the new file accordingly into the project structure (correct JDK and JEP folder).
    - Follow the markdown style comments to describe the class.
    - Do not hessitate to use (standard) comments inside your code - remember the desired usecase is future users will check the code to figure out how the feature works.
    - Do not forget to add required record to the respective JSON resource file (JEP name and brief, but meaningful description). **Keep the records ordered by JEP number ascending.**
    - Do not forget to add your new demo into the respective helper class for the JDK version, so it gets executed from `Main.java`. Always add comment with JEP number for better clarity. **Keep the demos ordered by JEP number ascending.**
    - Make sure you are not accidentally submitting some other files or changes that are not related to PR topic.
    - Because this project might be quite active with multiple contributors working on same files, please make sure your fork is in sync with the `master` branch of the original repository before submitting the PR. Double-check the "Files changed" tab of your PR and avoid posting anything not relevant to your changes.
    - Check an [example of well-structured PR](https://github.com/AloisSeckar/demos-java/pull/52/files) to ensure your sumbission fits the expected standard.
6. For any questions, feel free to ask in the opened issue, or contact me directly.
7. Please, be patient. I will try to review your PR as soon as possible, but sometimes it is not possible to do it immediately. I will try to provide you with feedback and/or merge it within 24 hours.

Thank you for your interest in this project and your willingness to help! I am looking forward to co-operating with you :heart_eyes:
