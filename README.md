# Java demos - new language features from Java 11 to 25

This application helps to show some new features being introduced in Java versions until Java 25.

All relevant info is written down in comments inside sources.

## Prerequisites
This project requires **Java JDK 25** to run. I namely use [GraalVM for JDK 25](https://www.graalvm.org/release-notes/JDK_25/) for development and testing. For compiling, [Maven](https://maven.apache.org/index.html) is required (newest available version is advised).

## Usage
Checkout the project and explore the files in your favorite IDE. You may find some important context and information in the comments directly in the code.

To build the project locally:

```sh
mvn clean install
```

To run the project locally:

```sh
java --enable-preview --add-modules=jdk.incubator.vector -jar target/JavaDemos-25.0.jar
```

Using `--enable-preview` and `--add-modules` options is necessary to make the newest Java language features available.

**Note:** Until `Maven 3.9.12` is released, you would see warning about `Guice` library using deprecated `sun.misc.Unsafe` class when running Maven install. This is [known and about to be fixed](https://github.com/apache/maven/issues/10312).

## Contributing
You can help making this project better!

Look for the [issues](https://github.com/AloisSeckar/demos-java/issues) to see what can be done.

The most important rule: **Your code must compile and run under Java 25**. GitHub workflow is now set up to ensure this and PRs that cannot compile using `mvn clean install` will not be merged until the problems are fixed.

Check the [contribution guide](/CONTRIBUTING.md) or contact me directly for more info.

## Author
* alois.seckar@gmail.com
* http://alois-seckar.cz

## Extra - Java Features
[Java Features](JavaFeatures.md) is my list of all Java versions with all JEPs included in each release.

## Extra - Java Tech
[Java Tech](JavaTech.md) is my list of interesting projects based on Java.

## Extra - Java News
[Java News](JavaNews.md) is my list with interesting articles and information from Java world started since 09/2023.

## Extra - JEP Status
[JEP Status](JEPStatus.md) is my tracker of changes in [OpenJDK JEP Index](https://openjdk.org/jeps/0) since 09/2023.
